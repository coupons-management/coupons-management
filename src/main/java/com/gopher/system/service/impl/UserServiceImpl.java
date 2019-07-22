package com.gopher.system.service.impl;

import com.gopher.system.constant.RoleTypeEnmu;
import com.gopher.system.dao.mysql.CpStoreDAO;
import com.gopher.system.dao.mysql.RoleDAO;
import com.gopher.system.dao.mysql.UserDAO;
import com.gopher.system.exception.BusinessRuntimeException;
import com.gopher.system.model.entity.CpStore;
import com.gopher.system.model.entity.Role;
import com.gopher.system.model.entity.User;
import com.gopher.system.model.vo.Page;
import com.gopher.system.model.vo.request.*;
import com.gopher.system.model.vo.response.UserListResponse;
import com.gopher.system.service.UserService;
import com.gopher.system.util.MD5Utils;
import com.gopher.system.util.ThreadLocalUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dongyangyang
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDAO userDAO;

    @Autowired
    private CpStoreDAO cpStoreDAO;

    @Autowired
    private RoleDAO roleDAO;

    @Override
    public User findByAccount(String account) {
        if (!StringUtils.hasText(account)) {
            throw new BusinessRuntimeException("无效的账号");
        }
        return userDAO.selectByAccount(account);
    }

    @Override
    public User findById(Integer id) {
        if (null == id || id < 0) {
            throw new BusinessRuntimeException("无效的ID");
        }
        return userDAO.selectByPrimaryKey(id);
    }

    @Override
    public User getCurrentUser() {
        Object object = ThreadLocalUtils.getObject(ThreadLocalUtils.USER_KEY);
        User user = null;
        if (null != object) {
            user = (User) object;
        }
        return user;
    }


    @Override
    public void addAccount(UserAddRequest userAddRequest) {
        if (!StringUtils.hasText(userAddRequest.getAccount()) || !StringUtils.hasText(userAddRequest.getPassword())) {
            throw new BusinessRuntimeException("账号/密码不能为空");
        }
        if (null != findByAccount(userAddRequest.getAccount())) {
            throw new BusinessRuntimeException("账号已存在");
        }
        User user = new User();
        BeanUtils.copyProperties(userAddRequest, user, "password");
        user.setPassword(MD5Utils.MD5(userAddRequest.getPassword()));
        User currentUser = getCurrentUser();
        user.setCreateUser(currentUser.getId());
        user.setCreateTime(new Date());
        Integer id = userDAO.addAccount(user);
        if (id == null) {
            throw new BusinessRuntimeException("新增失败");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteAccount(Integer id) {
        User user = findById(id);
        if (null != user) {
            userDAO.deleteByPrimaryKey(id);
            userDAO.deleteUserRole(id);
            userDAO.deleteUserStore(id);
        }
    }

    @Override
    public Page<UserListResponse> getPage(UserPageRequst userPageRequst) {
        if (null == userPageRequst) {
            throw new BusinessRuntimeException("参数不能为空");
        }
        Page<UserListResponse> result = new Page<>();
        result.setPageNumber(userPageRequst.getPageNumber());
        result.setPageSize(userPageRequst.getPageSize());
        List<User> list = userDAO.selectPage(userPageRequst);
        List<UserListResponse> collect = null;
        if(!CollectionUtils.isEmpty(list)){
            collect = list.stream().map(p -> {
                UserListResponse response = new UserListResponse();
                BeanUtils.copyProperties(p, response);
                response.setRoleList(userRole(p.getId()));
                return response;
            }).collect(Collectors.toList());
        }
        final int totalCount = userDAO.getCount(userPageRequst);
        result.setTotalCount(totalCount);
        result.setList(collect);
        return result;
    }


    @Override
    public void updateUser(UserVerifyRequest verifyRequest) {
        User user = new User();
        if (verifyRequest == null || verifyRequest.getId() == null) {
            throw new BusinessRuntimeException("ID不能为空");
        }
        BeanUtils.copyProperties(verifyRequest, user);
        if (StringUtils.hasText(verifyRequest.getPassword())) {
            user.setPassword(MD5Utils.MD5(verifyRequest.getPassword()));
        }
        user.setUpdateTime(new Date());
        user.setUpdateUser(this.getCurrentUser().getId());
        userDAO.updateByPrimaryKeySelective(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public synchronized void assignStore(UserAssignStoreRequest userAssignStoreRequest) {
        if (userAssignStoreRequest == null || userAssignStoreRequest.getUserId() == null) {
            throw new BusinessRuntimeException("参数不能为空");
        }
        userDAO.deleteUserStore(userAssignStoreRequest.getUserId());
        if (!CollectionUtils.isEmpty(userAssignStoreRequest.getStores())) {
            int count = userDAO.assignedCount(userAssignStoreRequest.getStores());
            if (count > 0) {
                throw new BusinessRuntimeException("商家已被分配");
            }
            for (Integer store : userAssignStoreRequest.getStores()) {
                CpStore cpStore = cpStoreDAO.selectByPrimaryKey(store);
                if (cpStore == null) {
                    throw new BusinessRuntimeException(store + "商家不存在");
                }
            }
            userDAO.assignStore(userAssignStoreRequest);
        }
    }


    @Override
    public void assignRole(UserAssigRoleRequest userAssigRoleRequest) {
        if (userAssigRoleRequest == null || userAssigRoleRequest.getUserId() == null) {
            throw new BusinessRuntimeException("参数不能为空");
        }
        userDAO.deleteUserRole(userAssigRoleRequest.getUserId());
        if (!CollectionUtils.isEmpty(userAssigRoleRequest.getRoles())) {
            for (Integer roleId : userAssigRoleRequest.getRoles()) {
                Role role = roleDAO.selectByPrimaryKey(roleId);
                if (role == null) {
                    throw new BusinessRuntimeException(roleId+"角色不存在");
                }
            }
            userDAO.assignRole(userAssigRoleRequest);
        }
    }


    @Override
    public List<Role> userRole(Integer userId) {
        if (userId == null) {
            throw new BusinessRuntimeException("参数不能为空");
        }
        return userDAO.userRole(userId);
    }


    @Override
    public Page<CpStore> userStore(UserStoreRequest userStoreRequest) {
        if (userStoreRequest == null || userStoreRequest.getUserId() == null) {
            throw new BusinessRuntimeException("参数不能为空");
        }
        Page<CpStore> result = new Page<>();
        result.setPageNumber(userStoreRequest.getPageNumber());
        result.setPageSize(userStoreRequest.getPageSize());
        List<CpStore> list = userDAO.userStore(userStoreRequest);
        final int totalCount = userDAO.userStoreCount(userStoreRequest);
        result.setTotalCount(totalCount);
        result.setList(list);
        return result;
    }

    @Override
    public Page<CpStore> currentUserStore(UserStoreRequest userStoreRequest) {
        User user = this.getCurrentUser();
        if (user == null) {
            throw new BusinessRuntimeException("用户未登陆");
        }
        List<Role> roleList = this.userRole(user.getId());
        boolean adminFlag = false;
        if (!CollectionUtils.isEmpty(roleList)) {
            for (Role role : roleList) {
                if (RoleTypeEnmu.ADMIN.name().equals(role.getType())) {
                    adminFlag = true;
                    break;
                }
            }
        }
        Page<CpStore> result = new Page<>();
        result.setPageNumber(userStoreRequest.getPageNumber());
        result.setPageSize(userStoreRequest.getPageSize());

        if (adminFlag) {
            userStoreRequest.setUserId(null);
        } else {
            userStoreRequest.setUserId(user.getId());
        }

        List<CpStore> list = userDAO.userStore(userStoreRequest);
        final int totalCount = userDAO.userStoreCount(userStoreRequest);
        result.setTotalCount(totalCount);
        result.setList(list);
        return result;
    }
}
