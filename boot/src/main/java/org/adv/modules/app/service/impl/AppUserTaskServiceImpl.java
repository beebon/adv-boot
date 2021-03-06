package org.adv.modules.app.service.impl;

import org.adv.modules.app.entity.AppUserTask;
import org.adv.modules.app.mapper.AppUserTaskMapper;
import org.adv.modules.app.service.IAppUserTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title: AppUserTask servcie implement
 * @Description: {'text': '用户任务表'}
 * @author： codesmith
 * @date：   2019-03-07 13:27
 * @version： v1.0
 */
@Service
public class AppUserTaskServiceImpl extends ServiceImpl<AppUserTaskMapper, AppUserTask> implements IAppUserTaskService {
    @Autowired
    AppUserTaskMapper dao;

    @Override
    public Map<String, Object> listInPage(Map<String, Object> param) {
        Map<String,Object> result = new HashMap();
        result.put("list",dao.listInPage(param));
        param.put("totalCount","true");
        result.put("total",Integer.parseInt(dao.listInPage(param).get(0).toString().split("=")[1].replace("}","")));
        return result;
    }
}