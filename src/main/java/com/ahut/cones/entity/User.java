package com.ahut.cones.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author itour
 * @since 2020-12-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 邮箱
     */
    /**
     * @TableField 这个注释暂时没有什么必要   使用mybatis的时候你还是一个一个进行添加的    这个又和没有没什么区别
     * mybatisplus另当别论
     * */
    @TableField("email")
    private String email;

    /**
     * 是否为管理员
     */
    @TableField("admin_flag")
    private Boolean adminFlag;

    /**
     * 上次登陆时间
     */
    @TableField("last_login")
    private LocalDateTime lastLogin;

    /**
     * 是否激活
     */
    @TableField("is_active")
    private Boolean isActive;

    /**
     * 创建时间
     */
    private Date createtime;

    public String getUsername() {
        return username;
    }
    public void setPassword(Object password) {
        this.password = (String) password;
    }
    public Integer getId() {
        return id;
    }
}
