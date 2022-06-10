package com.ahut.cones.service;

import com.ahut.cones.config.BaseResponse;
import com.ahut.cones.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author itour
 * @since 2020-12-20
 */
public interface IUserService extends IService<User> {


    public User login(String username, String password);

    Boolean checkUser(String username);

    List<User> userList();

    BaseResponse userRegister(User user);
}
