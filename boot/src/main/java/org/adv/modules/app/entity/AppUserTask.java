package org.adv.modules.app.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Title: AppUserTask entity
 * @Description: {'text': '用户任务表'}
 * @author： codesmith
 * @date：   2019-03-07 13:27
 * @version： v1.0
 */
@Data
@TableName("app_user_task")
public class AppUserTask implements Serializable {
    private static final long serialVersionUID = 1L;

    
    @TableId(type = IdType.UUID)
    private String id; //记录标识ID
    
    
    private String taskId; //关联任务ID
    
    
    private String userId; //关联用户ID
    
    
    private String appVersion; //应用版本
    
    
    private Byte taskStatus; //1=已领取 2＝已完成
    
    
    @com.fasterxml.jackson.annotation.JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @org.springframework.format.annotation.DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private java.util.Date receiveTime; //None
    
    
    @com.fasterxml.jackson.annotation.JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @org.springframework.format.annotation.DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private java.util.Date completeTime; //None
    
    
    private Long bonus; //奖励（分）
    
}