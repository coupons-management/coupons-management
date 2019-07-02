package com.gopher.system.controller;

import com.gopher.system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 1500
 * @Date 2019/7/2.
 */
@RestController
@RequestMapping(path="/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

}
