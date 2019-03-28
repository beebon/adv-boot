package org.adv.modules.app.mapper;

import java.util.List;

import org.adv.modules.app.entity.AppTask;
import org.apache.ibatis.annotations.Param;
import org.adv.modules.app.entity.AppTask;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * @Description: 任务管理
 * @author： adv-boot
 * @date：   2019-03-05
 * @version： V1.0
 */
public interface AppTaskMapper extends BaseMapper<AppTask> {
	List listInPage(Map<String, Object> param);
}
