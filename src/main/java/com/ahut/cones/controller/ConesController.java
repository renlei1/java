package com.ahut.cones.controller;

import cn.hutool.core.date.LocalDateTimeUtil;
import com.ahut.cones.config.BaseResponse;
import com.ahut.cones.config.Code;
import com.ahut.cones.config.ConesDateUtils;
import com.ahut.cones.config.IDUtils;
import com.ahut.cones.entity.Cones;
import com.ahut.cones.mapper.ConesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cones")
public class ConesController {

    @Autowired
    ConesMapper conesMapper;
    @GetMapping("/getConesList")
    public BaseResponse getConesList(){
        List<Cones> conesList = conesMapper.selectList(null);
        return new BaseResponse().setCode(Code.SUCCESS).setMessage("获取成功").setData(conesList);
    }
    @GetMapping("/getConesInfo")
    public BaseResponse getConesInfo(@RequestParam("conesId") Integer conesId){
        Cones conesInfo = conesMapper.selectById(conesId);
        return new BaseResponse().setCode(Code.SUCCESS).setMessage("获取成功").setData(conesInfo);
    }
    @GetMapping("/deleteCones")
    public BaseResponse deleteCones(@RequestParam("conesId") Long conesId){

        Map<String,Object> deleteMap = new HashMap<>();
        deleteMap.put("cone_id",conesId);
        int i = conesMapper.deleteByMap(deleteMap);
        return new BaseResponse().setCode(Code.SUCCESS).setMessage("获取成功").setData(null);
    }
    @PostMapping("/addCones")
    public BaseResponse addCones(@RequestParam("coneName") String coneName,@RequestParam("coneType") Integer coneType
            ,@RequestParam("inTime") String inTime,@RequestParam("userFlag") Integer userFlag,@RequestParam("location") String location
            ,@RequestParam("batteryLeft") Integer batteryLeft,@RequestParam("scrapFlag") Integer scrapFlag,@RequestParam("userId") Integer userId){
        Cones addCones = new Cones().setConeId(IDUtils.genItemId()).setConeName(coneName).setType(coneType).setInTime(ConesDateUtils.dateToLocalDateTime(ConesDateUtils.parseTimeZone(inTime))).setUserFlag(userFlag).setLocation(location).setBatteryLeft(batteryLeft)
                .setScrapFlag(scrapFlag).setUserId(userId);

        //判断是否报废
        if (scrapFlag == 1){
            addCones.setScrapTime(LocalDateTime.now());
        }else {
            addCones.setScrapTime(null);
        }

        addCones.setCreatetime(LocalDateTime.now());

        conesMapper.insert(addCones);

        return new BaseResponse().setCode(Code.SUCCESS).setMessage("获取成功").setData(null);
    }
}
