package org.adv.modules.app.service;

import org.adv.modules.app.entity.AppUserTask;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.Map;

/**
 * @Title: AppUserTask service interface
 * @Description: {'text': '用户任务表'}
 * @author： codesmith
 * @date：   2019-03-07 13:27
 * @version： v1.0
 */
public interface IAppUserTaskService extends IService<AppUserTask> {
	Map<String,Object> listInPage(Map<String, Object> param);
}