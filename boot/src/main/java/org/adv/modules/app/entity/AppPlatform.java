package org.adv.modules.app.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Description: 平台管理
 * @author： adv-boot
 * @date：   2019-03-05
 * @version： V1.0
 */
@Data
@TableName("app_platform")
public class AppPlatform implements Serializable {
    private static final long serialVersionUID = 1L;
    
	/**记录标识ID*/
	@TableId(type = IdType.UUID)
	private String id;
	/**记录状态：1＝有效 0＝无效 －1＝逻辑删除*/
	private Integer status;
	/**平台名称*/
	private String name;
}
