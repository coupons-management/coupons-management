package com.gopher.system.service.impl;

import com.gopher.system.constant.RoleTypeEnmu;
import com.gopher.system.dao.mysql.RoleDAO;
import com.gopher.system.exception.BusinessRuntimeException;
import com.gopher.system.model.entity.Resource;
import com.gopher.system.model.entity.Role;
import com.gopher.system.model.entity.User;
import com.gopher.system.model.vo.request.CommonIdRequest;
import com.gopher.system.model.vo.request.RoleAddRequest;
import com.gopher.system.model.vo.request.RoleUpdateResourceRequest;
import com.gopher.system.model.vo.response.ResourceResponse;
import com.gopher.system.service.RoleService;
import com.gopher.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * @author 1500
 * @Date 2019/7/2.
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private UserService userService;


    @Override
    public void addRole(RoleAddRequest roleAddRequest) {
        if (roleAddRequest == null || !StringUtils.hasText(roleAddRequest.getName())) {
            throw new BusinessRuntimeException("角色名称不能为空");
        }
        List<Role> roleList = roleDAO.findByName(roleAddRequest.getName());
        if (!CollectionUtils.isEmpty(roleList)) {
            throw new BusinessRuntimeException("角色名称重复");
        }
        User currentUser = userService.getCurrentUser();
        if (currentUser == null) {
            throw new BusinessRuntimeException("用户未登陆");
        }
        Role role = new Role();
        role.setCreateTime(new Date());
        role.setName(roleAddRequest.getName());
        role.setDescription(roleAddRequest.getDescription());
        role.setType(RoleTypeEnmu.NORMAL.name());
        role.setCreateUser(currentUser.getId());
        roleDAO.insert(role);
    }

    @Override
    public void updateRole(RoleAddRequest roleUpdateRequest) {
        if (roleUpdateRequest == null || !StringUtils.hasText(roleUpdateRequest.getName()) || roleUpdateRequest.getId() == null) {
            throw new BusinessRuntimeException("参数不能为空");
        }
        Role role = roleDAO.selectByPrimaryKey(roleUpdateRequest.getId());
        if (role == null) {
            throw new BusinessRuntimeException(roleUpdateRequest.getId() + "角色不存在");
        }
        if (RoleTypeEnmu.ADMIN.name().equals(role.getType())) {
            throw new BusinessRuntimeException("该角色禁止修改");
        }
        User currentUser = userService.getCurrentUser();
        if (currentUser == null) {
            throw new BusinessRuntimeException("用户未登陆");
        }
        List<Role> roleList = roleDAO.findByName(roleUpdateRequest.getName());
        if (!CollectionUtils.isEmpty(roleList)) {
            for (Role sameNameRole : roleList) {
                if (!roleUpdateRequest.getId().equals(sameNameRole.getId())) {
                    throw new BusinessRuntimeException("角色名称重复");
                }
            }
        }
        role.setUpdateTime(new Date());
        role.setUpdateUser(currentUser.getId());
        role.setName(roleUpdateRequest.getName());
        role.setDescription(roleUpdateRequest.getDescription());
        roleDAO.updateByPrimaryKey(role);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteRole(CommonIdRequest request) {
        if (request == null || request.getId() == null) {
            throw new BusinessRuntimeException("参数不能为空");
        }
        Role role = roleDAO.selectByPrimaryKey(request.getId());
        if (role != null) {
            if (RoleTypeEnmu.ADMIN.name().equals(role.getType())) {
                throw new BusinessRuntimeException("该角色禁止删除");
            }
            roleDAO.deleteByPrimaryKey(request.getId());
            roleDAO.deleteRoleResourceByRoleId(request.getId());
            roleDAO.deleteUserRoleByRoleId(request.getId());
        }

    }


    @Override
    public List<Resource> roleResource(CommonIdRequest request) {
        if (request == null || request.getId() == null) {
            throw new BusinessRuntimeException("参数不能为空");
        }
        Role role = roleDAO.selectByPrimaryKey(request.getId());
        List<Resource> resourceList;
        if (role == null) {
            resourceList = null;
        } else if (RoleTypeEnmu.ADMIN.name().equals(role.getType())) {
            resourceList = roleDAO.roleResource(null);
        } else {
            resourceList = roleDAO.roleResource(request.getId());
        }
        return resourceList;
    }


    @Override
    public List<ResourceResponse> currentResource() {
        User currentUser = userService.getCurrentUser();
        if (currentUser == null) {
            throw new BusinessRuntimeException("用户未登陆");
        }
        List<Role> roles = userService.userRole(currentUser.getId());
        List<ResourceResponse> resourceResponseList = null;

        if (!CollectionUtils.isEmpty(roles)) {
            List<Integer> roleIds = new ArrayList<>(roles.size());
            boolean adminFlag = false;
            for (Role role : roles) {
                if (RoleTypeEnmu.ADMIN.name().equals(role.getType())) {
                    adminFlag = true;
                    break;
                }
                roleIds.add(role.getId());
            }
            if (adminFlag) {
                resourceResponseList = roleDAO.findAllResource();
            } else {
                List<Resource> resourceList = roleDAO.findResourceByRoles(roleIds);
                if (!CollectionUtils.isEmpty(resourceList)) {
                    List<ResourceResponse> allResource = roleDAO.findAllResource();
                    for (Resource resource : resourceList) {
                        Integer resourceId = resource.getId();
                        for (ResourceResponse resourceResponse : allResource) {
                            checkHasResource(resourceId, resourceResponse);
                        }
                    }
                    clearResource(allResource);
                    resourceResponseList = allResource;
                }

            }
        }

        return resourceResponseList;
    }

    @Override
    public List<ResourceResponse> findAllResource() {
        return roleDAO.findAllResource();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateRoleResource(RoleUpdateResourceRequest roleUpdateResourceRequest) {
        if (roleUpdateResourceRequest == null || roleUpdateResourceRequest.getRoleId() == null) {
            throw new BusinessRuntimeException("角色ID不能为空");
        }
        roleDAO.deleteRoleResourceByRoleId(roleUpdateResourceRequest.getRoleId());

        if (!CollectionUtils.isEmpty(roleUpdateResourceRequest.getResources())) {
            for (Integer resourceId : roleUpdateResourceRequest.getResources()) {
                Resource resource = roleDAO.findResourceById(resourceId);
                if (resource == null) {
                    throw new BusinessRuntimeException(resourceId + "资源不存在");
                }
            }
            roleDAO.addRoleResource(roleUpdateResourceRequest);
        }


    }

    @Override
    public List<Role> roleList() {
        return roleDAO.getList();
    }

    private boolean checkHasResource(Integer resourceId, ResourceResponse resourceResponse) {
        boolean flag = false;
        List<ResourceResponse> children = resourceResponse.getChildren();
        if (!CollectionUtils.isEmpty(children)) {
            for (ResourceResponse child : children) {
                if (checkHasResource(resourceId, child)) {
                    child.setHasResource(true);
                    flag = true;
                }
            }
        }
        if (flag || resourceId.equals(resourceResponse.getId())) {
            resourceResponse.setHasResource(true);
            flag = true;
        }
        return flag;
    }

    private void clearResource(List<ResourceResponse> resourceResponseList) {
        if (CollectionUtils.isEmpty(resourceResponseList)) {
            return;
        }
        for (int i = resourceResponseList.size() - 1; i >= 0; i--) {
            ResourceResponse resourceResponse = resourceResponseList.get(i);
            if (resourceResponse.getHasResource()) {
                clearResource(resourceResponse.getChildren());
            } else {
                resourceResponseList.remove(resourceResponse);
            }
        }
    }

}
