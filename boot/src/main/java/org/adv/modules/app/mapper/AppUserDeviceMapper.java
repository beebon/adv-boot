package org.adv.modules.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.adv.modules.app.entity.AppUserDevice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;

/**
 * @Title: AppUserDevice mapper
 * @Description: {'text': '用户设备表'}
 * @author： codesmith
 * @date：   2019-03-07 13:27
 * @version： v1.0
 */
public interface AppUserDeviceMapper extends BaseMapper<AppUserDevice> {
	List listInPage(Map<String, Object> param);
}