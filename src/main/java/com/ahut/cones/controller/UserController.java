package com.ahut.cones.controller;

import com.ahut.cones.config.BaseResponse;
import com.ahut.cones.config.Code;
import com.ahut.cones.config.JwtUtil;
import com.ahut.cones.entity.User;
import com.ahut.cones.mapper.UserMapper;
import com.ahut.cones.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userServiceImpl;

    //用户登录
    @GetMapping("/login")
    public BaseResponse login(String username,String password){


        //登录成功之后返回一个token，之后 每次请求都在header中携带token。
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
           return new BaseResponse().setCode(Code.FAIL).setMsg("用户名或密码不能为空").setData(null);
        }
       User loginUser = userServiceImpl.login(username,password);
       if(loginUser == null){
           return new BaseResponse().setCode(Code.FAIL).setMsg("用户名或密码错误，请重新再试").setData(null);
       }else {


           String token = new JwtUtil().createToken(loginUser.getUsername());

           Map<String,Object> dataMap = new HashMap<String,Object>();
           dataMap.put("token",token);
           loginUser.setPassword(null);
           dataMap.put("userinfo",loginUser);

           return new BaseResponse().setCode(Code.SUCCESS).setMsg("登陆成功").setData(dataMap);
       }
    }

    //用户注册

    //@RequestBody接收前端发送的json数据     直接可以转化成实体类
    @PostMapping("/register")
    public BaseResponse register(@RequestBody User user){
        return userServiceImpl.userRegister(user);
    }
    //用户名验证
    @GetMapping("/checkUser")
    public BaseResponse checkUser(@RequestParam("username") String username){

        Boolean flag = userServiceImpl.checkUser(username);

        return  new BaseResponse().setCode(Code.SUCCESS).setMsg("验证成功").setData(flag);

    }


    //获取用户list
    @GetMapping("/userList")
    public BaseResponse userList(){

        List<User> userList = userServiceImpl.userList();

        List<Map<String,Object>> retList = new ArrayList<Map<String,Object>>();
        for (User user: userList) {
            Map<String,Object> userMap = new HashMap<>();
            userMap.put("userId",user.getId());
            userMap.put("userName",user.getUsername());
            retList.add(userMap);
        }
        return  new BaseResponse().setCode(Code.SUCCESS).setMsg("验证成功").setData(retList);

    }

}
