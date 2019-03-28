package org.adv.modules.app.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Title: AppUserDevice entity
 * @Description: {'text': '用户设备表'}
 * @author： codesmith
 * @date：   2019-03-07 13:27
 * @version： v1.0
 */
@Data
@TableName("app_user_device")
public class AppUserDevice implements Serializable {
    private static final long serialVersionUID = 1L;

    
    @TableId(type = IdType.UUID)
    private String id; //记录标识ID（设备号）
    
    
    private String userId; //关联用户ID
    
    
    private String deviceModel; //设备型号
    
    
    private String deviceSys; //设备操作系统
    
    
    private Byte status; //记录状态：1＝有效 0＝无效 －1＝逻辑删除
    
    
    private String userKey; //用户授权key（按设备进行授权）
    
    
    private String createdBy; //创建人
    
    
    private String updatedBy; //更新人
    
    
    @com.fasterxml.jackson.annotation.JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @org.springframework.format.annotation.DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private java.util.Date createTime; //创建时间
    
    
    @com.fasterxml.jackson.annotation.JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @org.springframework.format.annotation.DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private java.util.Date updateTime; //更新时间
    
}