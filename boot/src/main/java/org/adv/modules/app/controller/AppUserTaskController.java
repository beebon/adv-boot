package org.adv.modules.app.controller;

import java.util.Arrays;
import org.adv.common.api.vo.Result;
import org.adv.modules.app.entity.AppUserTask;
import org.adv.modules.app.service.IAppUserTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
import java.util.Map;



 /**
 * @Title: AppUserTask Controller
 * @Description: 用户任务表
 * @author： codesmith
 * @date：   2019-03-07 13:27
 * @version： v1.0
 */
 //@Api("{'text': '用户任务表'}")
@RestController
@RequestMapping("/app/appUserTask")
@Slf4j
public class AppUserTaskController {
	@Autowired
	private IAppUserTaskService svc;
	
	/**
	  * 分页列表查询
	 * @param param
	 * @return
	 */
    @PostMapping(value = "/list")
    public Result<Map> list(@RequestBody Map<String,Object> param){
    	Result<Map> result = new Result<>();
    	try {
	    	result.setSuccess(true);
			result.setResult(svc.listInPage(param));
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
			result.error500("操作失败");
		}
		return result;
    }
    
	
	/**
	  *   添加
	 * @param appusertask
	 * @return
	 */
	@PostMapping(value = "/add")
	public Result<AppUserTask> add(@RequestBody AppUserTask appusertask) {
		Result<AppUserTask> result = new Result<AppUserTask>();
		try {
			svc.save(appusertask);
			result.success("添加成功！");
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
			result.error500("操作失败");
		}
		return result;
	}
	
	/**
	  *  编辑
	 * @param appusertask
	 * @return
	 */
	@PutMapping(value = "/edit")
	public Result<AppUserTask> edit(@RequestBody AppUserTask appusertask) {
		Result<AppUserTask> result = new Result<AppUserTask>();
		AppUserTask ent = svc.getById(appusertask.getId());
		if(ent==null) {
			result.error500("未找到对应实体");
		}else {
			boolean ok = svc.updateById(appusertask);
			if(ok) {
				result.success("修改成功!");
			}
		}
		
		return result;
	}
	
	/**
	  *   通过id删除
	 * @param id
	 * @return
	 */
	@DeleteMapping(value = "/delete")
	public Result<AppUserTask> delete(@RequestParam(name="id",required=true) String id) {
		Result<AppUserTask> result = new Result<AppUserTask>();
		AppUserTask ent = svc.getById(id);
		if(ent==null) {
			result.error500("未找到对应实体");
		}else {
			boolean ok = svc.removeById(id);
			if(ok) {
				result.success("删除成功!");
			}
		}
		
		return result;
	}
	
	/**
	  *  批量删除
	 * @param ids
	 * @return
	 */
	@DeleteMapping(value = "/deleteBatch")
	public Result<AppUserTask> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		Result<AppUserTask> result = new Result<AppUserTask>();
		if(ids==null || "".equals(ids.trim())) {
			result.error500("参数不识别！");
		}else {
			this.svc.removeByIds(Arrays.asList(ids.split(",")));
			result.success("删除成功!");
		}
		return result;
	}
	
	/**
	  * 通过id查询
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/queryById")
	public Result<AppUserTask> queryById(@RequestParam(name="id",required=true) String id) {
		Result<AppUserTask> result = new Result<AppUserTask>();
		AppUserTask ent = svc.getById(id);
		if(ent==null) {
			result.error500("未找到对应实体");
		}else {
			result.setResult(ent);
			result.setSuccess(true);
		}
		return result;
	}

}