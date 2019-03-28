package org.adv.modules.quartz.service;

import java.util.List;

import org.adv.modules.quartz.entity.QuartzJob;
import org.adv.modules.quartz.entity.QuartzJob;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @Description: 定时任务在线管理
 * @author： adv-boot
 * @date：   2019-01-02
 * @version： V1.0
 */
public interface IQuartzJobService extends IService<QuartzJob> {

	List<QuartzJob> findByJobClassName(String jobClassName);

}
