package com.ahut.cones.service.impl;

import com.ahut.cones.config.BaseResponse;
import com.ahut.cones.config.Code;
import com.ahut.cones.entity.User;
import com.ahut.cones.mapper.UserMapper;
import com.ahut.cones.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author itour
 * @since 2020-12-20
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String username, String password) {

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        queryWrapper.eq("password",password);
        User user = userMapper.selectOne(queryWrapper);

        return user;
    }

    @Override
    public Boolean checkUser(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        User user = userMapper.selectOne(queryWrapper);
        if (user!=null){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<User> userList() {
        List<User> userList = userMapper.selectList(null);
        return userList;
    }
    //大部分逻辑是在service层进行实现的

    @Override
    public BaseResponse userRegister(User user) {
        user.setCreatetime(new Date());
        Integer i= userMapper.insert(user);
        if(i==1){
            return new BaseResponse().setCode(Code.SUCCESS).setMsg("注册成功");
        }else{
            return new BaseResponse().setCode(Code.FAIL).setMsg("注册失败，请重新注册");
        }

    }
}
