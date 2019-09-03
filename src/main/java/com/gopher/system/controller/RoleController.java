package com.gopher.system.controller;

import com.gopher.system.controller.model.Result;
import com.gopher.system.model.entity.Resource;
import com.gopher.system.model.vo.request.CommonIdRequest;
import com.gopher.system.model.vo.request.RoleAddRequest;
import com.gopher.system.model.vo.request.RoleUpdateResourceRequest;
import com.gopher.system.model.vo.response.ResourceResponse;
import com.gopher.system.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 1500
 * @Date 2019/7/2.
 */
@RestController
@RequestMapping(path="/role")
@Api(value="roles", description = "角色管理")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @ApiOperation(value = "新增角色",httpMethod = "POST" ,response = Result.class)
    @RequestMapping(path="/add")
    public Result addRole(@ApiParam(value = "角色信息", required = true) @RequestBody RoleAddRequest roleAddRequest) {
        Result result = new Result();
        roleService.addRole(roleAddRequest);
        return result;
    }

    @ApiOperation(value = "修改角色信息",httpMethod = "POST" ,response = Result.class)
    @RequestMapping(path="/update")
    public Result updateRole(@ApiParam(value = "角色信息", required = true) @RequestBody RoleAddRequest roleAddRequest) {
        Result result = new Result();
        roleService.updateRole(roleAddRequest);
        return result;
    }

    @ApiOperation(value = "删除角色",httpMethod = "POST" ,response = Result.class)
    @RequestMapping(path="/delete")
    public Result deleteRole(@ApiParam(value = "角色ID", required = true) @RequestBody CommonIdRequest commonIdRequest) {
        Result result = new Result();
        roleService.deleteRole(commonIdRequest);
        return result;
    }

    @ApiOperation(value = "角色列表",httpMethod = "POST" ,response = Result.class)
    @RequestMapping(path="/list")
    public Result roleList() {
        Result result = new Result();
        result.setData(roleService.roleList());
        return result;
    }


    @ApiOperation(value = "某个角色资源列表",httpMethod = "POST" ,response = Resource.class)
    @RequestMapping(path="/resource")
    public Result roleResource(@ApiParam(value = "角色ID", required = true) @RequestBody CommonIdRequest commonIdRequest) {
        Result result = new Result();
        result.setData(roleService.roleResource(commonIdRequest));
        return result;
    }

    @ApiOperation(value = "当前用户资源树",httpMethod = "POST",response = ResourceResponse.class)
    @RequestMapping(path="/currentResource")
    public Result currentResource() {
        Result result = new Result();
        result.setData(roleService.currentResource());
        return result;
    }

    @ApiOperation(value = "全部资源树",httpMethod = "POST",response = ResourceResponse.class)
    @RequestMapping(path="/allResource")
    public Result allResource() {
        Result result = new Result();
        result.setData(roleService.findAllResource());
        return result;
    }

    @ApiOperation(value = "修改角色资源(全量修改)",httpMethod = "POST",response = ResourceResponse.class)
    @RequestMapping(path="/updateResource")
    public Result updateRoleResource(@ApiParam(value = "角色资源信息", required = true) @RequestBody RoleUpdateResourceRequest roleUpdateResourceRequest) {
        Result result = new Result();
        roleService.updateRoleResource(roleUpdateResourceRequest);
        return result;
    }




}
