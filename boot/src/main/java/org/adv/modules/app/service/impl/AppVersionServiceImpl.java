package org.adv.modules.app.service.impl;

import org.adv.modules.app.mapper.AppVersionMapper;
import org.adv.modules.app.service.IAppVersionService;
import org.adv.modules.app.entity.AppVersion;
import org.adv.modules.app.mapper.AppVersionMapper;
import org.adv.modules.app.service.IAppVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 版本管理
 * @author： adv-boot
 * @date：   2019-03-05
 * @version： V1.0
 */
@Service
public class AppVersionServiceImpl extends ServiceImpl<AppVersionMapper, AppVersion> implements IAppVersionService {
    @Autowired
    AppVersionMapper dao;

    @Override
    public Map<String, Object> listInPage(Map<String, Object> param) {
        Map<String,Object> result = new HashMap();
        result.put("list",dao.listInPage(param));
        param.put("totalCount","true");
        result.put("total",Integer.parseInt(dao.listInPage(param).get(0).toString().split("=")[1].replace("}","")));
        return result;
    }
}
