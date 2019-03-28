package org.adv.modules.app.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.adv.common.api.vo.Result;
import org.adv.common.util.oConvertUtils;
import org.adv.modules.app.entity.AppTask;
import org.adv.modules.app.service.IAppTaskService;
import org.adv.common.api.vo.Result;
import org.adv.common.util.oConvertUtils;
import org.adv.modules.app.entity.AppTask;
import org.adv.modules.app.service.IAppTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

 /**
 * @Title: Controller
 * @Description: 任务管理
 * @author： adv-boot
 * @date：   2019-03-05
 * @version： V1.0
 */
@RestController
@RequestMapping("/app/appTask")
@Slf4j
public class AppTaskController {
	@Autowired
	private IAppTaskService appTaskService;

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
			 result.setResult(appTaskService.listInPage(param));
		 } catch (Exception e) {
			 e.printStackTrace();
			 log.info(e.getMessage());
			 result.error500("操作失败");
		 }
		 return result;
	 }

	/**
	  *   添加
	 * @param appTask
	 * @return
	 */
	@PostMapping(value = "/add")
	public Result<AppTask> add(@RequestBody AppTask appTask) {
		Result<AppTask> result = new Result<AppTask>();
		try {
			appTaskService.save(appTask);
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
	 * @param appTask
	 * @return
	 */
	@PutMapping(value = "/edit")
	public Result<AppTask> edit(@RequestBody AppTask appTask) {
		Result<AppTask> result = new Result<AppTask>();
		AppTask appTaskEntity = appTaskService.getById(appTask.getId());
		if(appTaskEntity==null) {
			result.error500("未找到对应实体");
		}else {
			boolean ok = appTaskService.updateById(appTask);
			//TODO 返回false说明什么？
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
	public Result<AppTask> delete(@RequestParam(name="id",required=true) String id) {
		Result<AppTask> result = new Result<AppTask>();
		AppTask appTask = appTaskService.getById(id);
		if(appTask==null) {
			result.error500("未找到对应实体");
		}else {
			boolean ok = appTaskService.removeById(id);
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
	public Result<AppTask> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		Result<AppTask> result = new Result<AppTask>();
		if(ids==null || "".equals(ids.trim())) {
			result.error500("参数不识别！");
		}else {
			this.appTaskService.removeByIds(Arrays.asList(ids.split(",")));
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
	public Result<AppTask> queryById(@RequestParam(name="id",required=true) String id) {
		Result<AppTask> result = new Result<AppTask>();
		AppTask appTask = appTaskService.getById(id);
		if(appTask==null) {
			result.error500("未找到对应实体");
		}else {
			result.setResult(appTask);
			result.setSuccess(true);
		}
		return result;
	}

}
