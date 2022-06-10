package com.ahut.cones.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

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
public class Cones implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 锥桶id
     */
    @TableField("cone_id")
    private Long coneId;

    /**
     * 锥桶名称
     */
    @TableField("cone_name")
    private String coneName;

    /**
     * 锥桶类别
     */
    @TableField("type")
    private Integer type;

    /**
     * 采购时间
     */
    @TableField("in_time")
    private LocalDateTime inTime;

    /**
     * 负责人id
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 使用状态
     */
    @TableField("user_flag")
    private Integer userFlag;

    /**
     * 当前位置
     */
    @TableField("location")
    private String location;

    /**
     * 系统电量:满电为100%
     */
    @TableField("battery_left")
    private Integer batteryLeft;

    /**
     * 报废时间
     */
    @TableField("scrap_time")
    private LocalDateTime scrapTime;

    /**
     * 报废标志
     */
    @TableField("scrap_flag")
    private Integer scrapFlag;

    /**
     * 创建时间
     */
    @TableField("createtime")
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

    public Long getConeId() {
        return coneId;
    }

    public Cones setConeId(Long coneId) {
        this.coneId = coneId;
        return this;
    }

    public String getConeName() {
        return coneName;
    }

    public Cones setConeName(String coneName) {
        this.coneName = coneName;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public Cones setType(Integer type) {
        this.type = type;
        return this;
    }

    public LocalDateTime getInTime() {
        return inTime;
    }

    public Cones setInTime(LocalDateTime inTime) {
        this.inTime = inTime;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public Cones setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Integer getUserFlag() {
        return userFlag;
    }

    public Cones setUserFlag(Integer userFlag) {
        this.userFlag = userFlag;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public Cones setLocation(String location) {
        this.location = location;
        return this;
    }

    public Integer getBatteryLeft() {
        return batteryLeft;
    }

    public Cones setBatteryLeft(Integer batteryLeft) {
        this.batteryLeft = batteryLeft;
        return this;
    }

    public LocalDateTime getScrapTime() {
        return scrapTime;
    }

    public void setScrapTime(LocalDateTime scrapTime) {
        this.scrapTime = scrapTime;
    }

    public Integer getScrapFlag() {
        return scrapFlag;
    }

    public Cones setScrapFlag(Integer scrapFlag) {
        this.scrapFlag = scrapFlag;
        return this;
    }

    public LocalDateTime getCreatetime() {
        return createtime;
    }

    public void setCreatetime(LocalDateTime createtime) {
        this.createtime = createtime;
    }
}
