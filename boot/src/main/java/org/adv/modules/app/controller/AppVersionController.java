package org.adv.modules.app.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.adv.common.util.oConvertUtils;
import org.adv.modules.app.entity.AppVersion;
import org.adv.modules.app.service.IAppVersionService;
import org.adv.common.api.vo.Result;
import org.adv.common.util.oConvertUtils;
import org.adv.modules.app.entity.AppVersion;
import org.adv.modules.app.service.IAppVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

 /**
 * @Title: Controller
 * @Description: 版本管理
 * @author： adv-boot
 * @date：   2019-03-05
 * @version： V1.0
 */
@RestController
@RequestMapping("/app/appVersion")
@Slf4j
public class AppVersionController {
	@Autowired
	private IAppVersionService appVersionService;

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
			 result.setResult(appVersionService.listInPage(param));
		 } catch (Exception e) {
			 e.printStackTrace();
			 log.info(e.getMessage());
			 result.error500("操作失败");
		 }
		 return result;
	 }

	
	/**
	  *   添加
	 * @param appVersion
	 * @return
	 */
	@PostMapping(value = "/add")
	public Result<AppVersion> add(@RequestBody AppVersion appVersion) {
		Result<AppVersion> result = new Result<AppVersion>();
		try {
			appVersionService.save(appVersion);
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
	 * @param appVersion
	 * @return
	 */
	@PutMapping(value = "/edit")
	public Result<AppVersion> edit(@RequestBody AppVersion appVersion) {
		Result<AppVersion> result = new Result<AppVersion>();
		AppVersion appVersionEntity = appVersionService.getById(appVersion.getId());
		if(appVersionEntity==null) {
			result.error500("未找到对应实体");
		}else {
			boolean ok = appVersionService.updateById(appVersion);
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
	public Result<AppVersion> delete(@RequestParam(name="id",required=true) String id) {
		Result<AppVersion> result = new Result<AppVersion>();
		AppVersion appVersion = appVersionService.getById(id);
		if(appVersion==null) {
			result.error500("未找到对应实体");
		}else {
			boolean ok = appVersionService.removeById(id);
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
	public Result<AppVersion> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		Result<AppVersion> result = new Result<AppVersion>();
		if(ids==null || "".equals(ids.trim())) {
			result.error500("参数不识别！");
		}else {
			this.appVersionService.removeByIds(Arrays.asList(ids.split(",")));
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
	public Result<AppVersion> queryById(@RequestParam(name="id",required=true) String id) {
		Result<AppVersion> result = new Result<AppVersion>();
		AppVersion appVersion = appVersionService.getById(id);
		if(appVersion==null) {
			result.error500("未找到对应实体");
		}else {
			result.setResult(appVersion);
			result.setSuccess(true);
		}
		return result;
	}

}
