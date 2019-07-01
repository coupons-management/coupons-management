package com.gopher.system.service.impl;

import javax.annotation.Resource;

import com.gopher.system.model.vo.Page;
import com.gopher.system.model.vo.request.UserAddRequest;
import com.gopher.system.model.vo.request.UserPageRequst;
import com.gopher.system.model.vo.request.UserVerifyRequest;
import com.gopher.system.util.MD5Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.gopher.system.dao.mysql.UserDAO;
import com.gopher.system.exception.BusinessRuntimeException;
import com.gopher.system.model.entity.User;
import com.gopher.system.service.UserService;
import com.gopher.system.util.ThreadLocalUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * @author dongyangyang
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDAO userDAO;

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
    public Page<User> getPage(UserPageRequst userPageRequst) {
        if (null == userPageRequst) {
            throw new BusinessRuntimeException("参数不能为空");
        }
        Page<User> result = new Page<>();
        result.setPageNumber(userPageRequst.getPageNumber());
        result.setPageSize(userPageRequst.getPageSize());
        List<User> list = userDAO.selectPage(userPageRequst);
        final int totalCount = userDAO.getCount(userPageRequst);
        result.setTotalCount(totalCount);
        result.setList(list);
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
}
