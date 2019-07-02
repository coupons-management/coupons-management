package com.gopher.system.controller;

import com.gopher.system.controller.model.Result;
import com.gopher.system.model.vo.request.CommonIdRequest;
import com.gopher.system.model.vo.request.UserAddRequest;
import com.gopher.system.model.vo.request.UserPageRequst;
import com.gopher.system.model.vo.request.UserVerifyRequest;
import com.gopher.system.service.UserService;
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
public class UserController {

    @Autowired
    private UserService userService;



    @RequestMapping(path="/add")
    public Result add(@RequestBody UserAddRequest userAddRequest) {
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

}
