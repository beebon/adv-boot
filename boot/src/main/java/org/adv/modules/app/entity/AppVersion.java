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
 * @Description: 版本管理
 * @author： adv-boot
 * @date：   2019-03-05
 * @version： V1.0
 */
@Data
@TableName("app_version")
public class AppVersion implements Serializable {
    private static final long serialVersionUID = 1L;
    
	/**记录标识ID*/
	@TableId(type = IdType.UUID)
	private String id;
	/**记录状态：1＝有效 0＝无效 －1＝逻辑删除*/
	private String status;
	/**版本号*/
	private String num;
	/**版本描述*/
	private String remark;
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
}
