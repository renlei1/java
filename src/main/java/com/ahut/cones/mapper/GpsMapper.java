package com.ahut.cones.mapper;

import com.ahut.cones.entity.Gps;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface GpsMapper extends BaseMapper<Gps> {
}
