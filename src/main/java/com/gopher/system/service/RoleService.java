package com.gopher.system.service;

import com.gopher.system.model.entity.Resource;
import com.gopher.system.model.entity.Role;
import com.gopher.system.model.vo.request.CommonIdRequest;
import com.gopher.system.model.vo.request.RoleAddRequest;
import com.gopher.system.model.vo.request.RoleUpdateResourceRequest;
import com.gopher.system.model.vo.response.ResourceResponse;

import java.util.List;

public interface RoleService {
    /**
     * 新增角色
     * @param roleAddRequest
     */
    void addRole(RoleAddRequest roleAddRequest);

    /**
     * 修改角色
     * @param roleUpdateRequest
     */
    void updateRole(RoleAddRequest roleUpdateRequest);

    /**
     * 删除角色
     * @param request
     */
    void deleteRole(CommonIdRequest request);

    /**
     * 角色菜单
     * @param request
     * @return
     */
    List<Resource> roleResource(CommonIdRequest request);

    /**
     * 当前用户资源树
     * @return
     */
    List<ResourceResponse> currentResource();


    /**
     * 查询全部资源树
     * @return
     */
    List<ResourceResponse> findAllResource();


    /**
     * 更新角色资源
     * @param roleUpdateResourceRequest
     */
    void updateRoleResource(RoleUpdateResourceRequest roleUpdateResourceRequest);

    /**
     * 角色列表
     * @return
     */
    List<Role> roleList();

}
