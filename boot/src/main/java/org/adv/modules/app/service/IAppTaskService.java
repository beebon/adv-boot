package org.adv.modules.app.service;

import org.adv.modules.app.entity.AppTask;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * @Description: 任务管理
 * @author： adv-boot
 * @date：   2019-03-05
 * @version： V1.0
 */
public interface IAppTaskService extends IService<AppTask> {
    Map<String,Object> listInPage(Map<String, Object> param);
}
