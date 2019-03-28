package org.adv.modules.app.service;

import org.adv.modules.app.entity.AppVersion;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * @Description: 版本管理
 * @author： adv-boot
 * @date：   2019-03-05
 * @version： V1.0
 */
public interface IAppVersionService extends IService<AppVersion> {
    Map<String,Object> listInPage(Map<String, Object> param);
}
