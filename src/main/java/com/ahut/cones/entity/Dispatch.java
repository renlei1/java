package com.ahut.cones.entity;

import java.time.LocalDateTime;


import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class Dispatch implements Serializable {
    public Dispatch() {

    }

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    /**
     * 锥桶id
     */
    @TableField("cones_id")
    private Long conesId;

    /**
     * 调度用户id
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 事故类别
     */
    @TableField("accident_type")
    private Integer accidentType;

    /**
     * 部署位置
     */
    private String location;

    /**
     * 调度状态：1正在使用中，2已完成
     */
    private Integer status;

    /**
     * 创建时间
     */
    private LocalDateTime createtime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getConesId() {
        return conesId;
    }

    public Dispatch setConesId(Long conesId) {
        this.conesId = conesId;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAccidentType() {
        return accidentType;
    }

    public Dispatch setAccidentType(Integer accidentType) {
        this.accidentType = accidentType;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public Dispatch setLocation(String location) {
        this.location = location;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public Dispatch setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public LocalDateTime getCreatetime() {
        return createtime;
    }

    public Dispatch setCreatetime(LocalDateTime createtime) {
        this.createtime = createtime;
        return this;
    }
}
