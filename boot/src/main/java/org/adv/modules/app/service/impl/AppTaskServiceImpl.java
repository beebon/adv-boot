package org.adv.modules.app.service.impl;

import org.adv.modules.app.entity.AppTask;
import org.adv.modules.app.service.IAppTaskService;
import org.adv.modules.app.mapper.AppTaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 任务管理
 * @author： adv-boot
 * @date：   2019-03-05
 * @version： V1.0
 */
@Service
public class AppTaskServiceImpl extends ServiceImpl<AppTaskMapper, AppTask> implements IAppTaskService {
    @Autowired
    AppTaskMapper dao;

    @Override
    public Map<String, Object> listInPage(Map<String, Object> param) {
        Map<String,Object> result = new HashMap();
        result.put("list",dao.listInPage(param));
        param.put("totalCount","true");
        result.put("total",Integer.parseInt(dao.listInPage(param).get(0).toString().split("=")[1].replace("}","")));
        return result;
    }
}
