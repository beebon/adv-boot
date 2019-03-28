package org.adv.modules.app.service.impl;

import org.adv.modules.app.entity.AppUser;
import org.adv.modules.app.mapper.AppUserMapper;
import org.adv.modules.app.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title: AppUser servcie implement
 * @Description: {'text': '应用用户'}
 * @author： codesmith
 * @date：   2019-03-06 19:03
 * @version： v1.0
 */
@Service
public class AppUserServiceImpl extends ServiceImpl<AppUserMapper, AppUser> implements AppUserService {
    @Autowired
    AppUserMapper dao;

    @Override
    public Map<String, Object> listInPage(Map<String, Object> param) {
        Map<String,Object> result = new HashMap();
        result.put("list",dao.listInPage(param));
        param.put("totalCount","true");
        result.put("total",Integer.parseInt(dao.listInPage(param).get(0).toString().split("=")[1].replace("}","")));
        return result;
    }
}