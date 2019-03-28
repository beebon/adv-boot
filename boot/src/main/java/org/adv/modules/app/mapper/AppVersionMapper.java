package org.adv.modules.app.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.adv.modules.app.entity.AppVersion;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Description: 版本管理
 * @author： adv-boot
 * @date：   2019-03-05
 * @version： V1.0
 */
public interface AppVersionMapper extends BaseMapper<AppVersion> {
    List listInPage(Map<String, Object> param);
}
