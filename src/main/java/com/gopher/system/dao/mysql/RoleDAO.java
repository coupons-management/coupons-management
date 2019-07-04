package com.gopher.system.dao.mysql;

import com.gopher.system.model.entity.Resource;
import com.gopher.system.model.entity.Role;
import com.gopher.system.model.vo.request.RoleUpdateResourceRequest;
import com.gopher.system.model.vo.response.ResourceResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 1500
 * @Date 2019/7/1.
 */
public interface RoleDAO extends MyBatisBaseDao<Role, Integer> {

    List<Role> findByName(String name);

    void deleteUserRoleByRoleId(Integer roleId);

    void deleteRoleResourceByRoleId(Integer roleId);

    List<Resource> roleResource(@Param("roleId")Integer roleId);

    List<Resource> findResourceByRoles(List<Integer> roleIds);

    List<ResourceResponse> findResourceByPid(Integer pid);

    List<ResourceResponse> findAllResource();

    void addRoleResource(@Param("param") RoleUpdateResourceRequest param);

    Resource findResourceById(Integer id);

}
