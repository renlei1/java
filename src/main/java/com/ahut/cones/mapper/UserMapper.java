package com.ahut.cones.mapper;

import com.ahut.cones.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author itour
 * @since 2020-12-20
 */
public interface UserMapper extends BaseMapper<User> {

    Integer register(User user);
}
