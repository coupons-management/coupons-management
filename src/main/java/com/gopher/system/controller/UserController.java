package com.gopher.system.controller;

import com.gopher.system.controller.model.Result;
import com.gopher.system.model.vo.request.*;
import com.gopher.system.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 1500
 * @Date 2019/7/1.
 */
@RestController
@RequestMapping(path="/user")
@Api(value="users", description = "员工管理")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "创建员工",httpMethod = "POST" ,response = Result.class)
    @RequestMapping(path="/add")
    public Result add(@ApiParam(value = "员工信息", required = true) @RequestBody UserAddRequest userAddRequest) {
        Result result = new Result();
        userService.addAccount(userAddRequest);
        return result;
    }

    @RequestMapping(path="/delete")
    public Result delete(@RequestBody CommonIdRequest request) {
        Result result = new Result();
        userService.deleteAccount(request.getId());
        return result;
    }

    @RequestMapping(path="/getPage")
    public Result getPage(@RequestBody UserPageRequst userPageRequst) {
        Result result = new Result();
        result.setData(userService.getPage(userPageRequst));
        return result;
    }


    @RequestMapping(path="/update")
    public Result update(@RequestBody UserVerifyRequest userVerifyRequest) {
        Result result = new Result();
        userService.updateUser(userVerifyRequest);
        return result;
    }

    @RequestMapping(path="/assignStore")
    public Result assignStore(@RequestBody UserAssignStoreRequest userAssignStoreRequest) {
        Result result = new Result();
        userService.assignStore(userAssignStoreRequest);
        return result;
    }

    @RequestMapping(path="/assignOrCancel")
    public Result assignOrCancelStore(@RequestBody UserAssignOrCancelStoreRequest request) {
        Result result = new Result();
        userService.assignOrCancelStoreToUser(request);
        return result;
    }


    @RequestMapping(path="/assignRole")
    public Result assignRole(@RequestBody UserAssigRoleRequest userAssigRoleRequest) {
        Result result = new Result();
        userService.assignRole(userAssigRoleRequest);
        return result;
    }

    @RequestMapping(path="/roles")
    public Result userRole(@RequestBody CommonIdRequest request) {
        Result result = new Result();
        result.setData(userService.userRole(request.getId()));
        return result;
    }

    @RequestMapping(path="/stores")
    public Result userStore(@RequestBody UserStoreRequest request) {
        Result result = new Result();
        result.setData(userService.userStore(request));
        return result;
    }

    @RequestMapping(path="/currentStores")
    public Result currentUserStore(@RequestBody UserStoreRequest request) {
        Result result = new Result();
        result.setData(userService.currentUserStore(request));
        return result;
    }








}
