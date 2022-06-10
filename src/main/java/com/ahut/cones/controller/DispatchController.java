package com.ahut.cones.controller;


import com.ahut.cones.config.BaseResponse;
import com.ahut.cones.config.Code;
import com.ahut.cones.config.ConesDateUtils;
import com.ahut.cones.config.IDUtils;
import com.ahut.cones.entity.Cones;
import com.ahut.cones.entity.Dispatch;
import com.ahut.cones.entity.Gps;
import com.ahut.cones.mapper.DispatchMapper;
import com.ahut.cones.mapper.GpsMapper;
import com.ahut.cones.service.IGpsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/dispatch")
public class DispatchController {


   @Autowired
    DispatchMapper dispatchMapper;
   @Autowired
   GpsMapper iGpsService;



    @GetMapping("/getDispatchList")
    public BaseResponse getDispatchList(){
        List<Dispatch> dispatchList = dispatchMapper.selectList(null);

        String test = new StringBuffer("sdfs").reverse().toString();

        System.out.println(test);


        return new BaseResponse().setCode(Code.SUCCESS).setMessage("获取成功").setData(dispatchList);
    }

    @GetMapping("/getGPSLocation")
    public BaseResponse getGPS(){
        List<Gps> dispatchList = iGpsService.selectList(null);

        return new BaseResponse().setCode(Code.SUCCESS).setMessage("获取成功").setData(dispatchList);
    }



    @GetMapping("/getDispatchInfo")
    public BaseResponse getDispatchInfo(@RequestParam("dispatchId") Integer dispatchId){
        Dispatch dispatchInfo = dispatchMapper.selectById(dispatchId);
        return new BaseResponse().setCode(Code.SUCCESS).setMessage("获取成功").setData(dispatchInfo);
    }

    @PostMapping("/addDispatch")
    public BaseResponse addCones(@RequestParam("coneId") Long conesId,@RequestParam("userId") Integer userId
            ,@RequestParam("accidentType") Integer accidentType,@RequestParam("location") String location
            ,@RequestParam("status") Integer status,@RequestParam("createtime") String createtime){

        Dispatch addDispatch = new Dispatch();
        addDispatch.setConesId(conesId).setAccidentType(accidentType).setCreatetime(ConesDateUtils.dateToLocalDateTime(ConesDateUtils.parseTimeZone(createtime)))
                .setLocation(location).setStatus(status).setUserId(userId);
        dispatchMapper.insert(addDispatch);

        return new BaseResponse().setCode(Code.SUCCESS).setMessage("获取成功").setData(null);
    }

}
