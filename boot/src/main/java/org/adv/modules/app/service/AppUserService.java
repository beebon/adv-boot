package org.adv.modules.app.service;

import org.adv.modules.app.entity.AppUser;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.Map;

/**
 * @Title: AppUser service interface
 * @Description: {'text': '应用用户'}
 * @author： codesmith
 * @date：   2019-03-06 19:13
 * @version： v1.0
 */
public interface AppUserService extends IService<AppUser> {
	Map<String,Object> listInPage(Map<String, Object> param);
}