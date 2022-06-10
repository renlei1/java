package com.ahut.cones.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

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
@TableName("warning_info")
public class WarningInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    /**
     * 消息id
     */
    @TableField("msg_id")
    private Integer msgId;

    /**
     * 锥桶id
     */
    @TableField("cone_id")
    private Integer coneId;

    /**
     * 事故发生位置
     */
    private String location;

    /**
     * 消息类别
     */
    @TableField("msg_type")
    private Integer msgType;

    /**
     * 消息状态
     */
    private Integer status;

    /**
     * 创建时间
     */
    private LocalDateTime createtime;


}
