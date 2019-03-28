package org.adv.modules.app.entity;

import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @Description: 任务管理
 * @author： adv-boot
 * @date：   2019-03-05
 * @version： V1.0
 */
@Data
@TableName("app_task")
public class AppTask implements Serializable {
    private static final long serialVersionUID = 1L;
    
	/**记录标识ID*/
	@TableId(type = IdType.UUID)
	private String id;
	/**任务名称*/
	private String name;
	/**记录状态：1＝有效 0＝无效 －1＝逻辑删除*/
	private Integer status;
	/**平台ID（关联平台表ID）*/
	private String platformId;
	/**任务类型：关注、点赞、评论等*/
	private String taskType;
	/**任务总量*/
	private Integer taskSum;
	/**领取量*/
	private Integer receiveNum;
	/**完成量*/
	private Integer completeNum;
	/**创建人*/
	private String createdBy;
	/**更新人*/
	private String updatedBy;
	/**创建时间*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	/**更新时间*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date updateTime;
	/**最低奖励（分）*/
	private Integer minBonus;
	/**最高奖励（分）*/
	private Integer maxBonus;
	/**奖励（分）*/
	private Integer bonus;
}
