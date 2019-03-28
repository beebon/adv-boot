package org.adv.modules.app.service.impl;

import org.adv.modules.app.entity.AppUserDevice;
import org.adv.modules.app.mapper.AppUserDeviceMapper;
import org.adv.modules.app.service.IAppUserDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title: AppUserDevice servcie implement
 * @Description: {'text': '用户设备表'}
 * @author： codesmith
 * @date：   2019-03-07 13:27
 * @version： v1.0
 */
@Service
public class AppUserDeviceServiceImpl extends ServiceImpl<AppUserDeviceMapper, AppUserDevice> implements IAppUserDeviceService {
    @Autowired
    AppUserDeviceMapper dao;

    @Override
    public Map<String, Object> listInPage(Map<String, Object> param) {
        Map<String,Object> result = new HashMap();
        result.put("list",dao.listInPage(param));
        param.put("totalCount","true");
        result.put("total",Integer.parseInt(dao.listInPage(param).get(0).toString().split("=")[1].replace("}","")));
        return result;
    }
}