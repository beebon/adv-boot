package org.adv.modules.app.service;

import org.adv.modules.app.entity.AppUserDevice;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.Map;

/**
 * @Title: AppUserDevice service interface
 * @Description: {'text': '用户设备表'}
 * @author： codesmith
 * @date：   2019-03-07 13:27
 * @version： v1.0
 */
public interface IAppUserDeviceService extends IService<AppUserDevice> {
	Map<String,Object> listInPage(Map<String, Object> param);
}