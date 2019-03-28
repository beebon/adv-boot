package org.adv.modules.app.mapper;

import java.util.List;

import org.adv.modules.app.entity.AppUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.Map;

/**
 * @Title: AppUser mapper
 * @Description: {'text': '应用用户'}
 * @author： codesmith
 * @date：   2019-03-06 19:10
 * @version： v1.0
 */
public interface AppUserMapper extends BaseMapper<AppUser> {
	List listInPage(Map<String, Object> param);
}