package org.adv.modules.app.controller;

import java.util.Arrays;
import org.adv.common.api.vo.Result;
import org.adv.modules.app.entity.AppUserDevice;
import org.adv.modules.app.service.IAppUserDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
import java.util.Map;



 /**
 * @Title: AppUserDevice Controller
 * @Description: 用户设备表
 * @author： codesmith
 * @date：   2019-03-07 13:27
 * @version： v1.0
 */
 //@Api("{'text': '用户设备表'}")
@RestController
@RequestMapping("/app/appUserDevice")
@Slf4j
public class AppUserDeviceController {
	@Autowired
	private IAppUserDeviceService svc;
	
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
	 * @param appuserdevice
	 * @return
	 */
	@PostMapping(value = "/add")
	public Result<AppUserDevice> add(@RequestBody AppUserDevice appuserdevice) {
		Result<AppUserDevice> result = new Result<AppUserDevice>();
		try {
			svc.save(appuserdevice);
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
	 * @param appuserdevice
	 * @return
	 */
	@PutMapping(value = "/edit")
	public Result<AppUserDevice> edit(@RequestBody AppUserDevice appuserdevice) {
		Result<AppUserDevice> result = new Result<AppUserDevice>();
		AppUserDevice ent = svc.getById(appuserdevice.getId());
		if(ent==null) {
			result.error500("未找到对应实体");
		}else {
			boolean ok = svc.updateById(appuserdevice);
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
	public Result<AppUserDevice> delete(@RequestParam(name="id",required=true) String id) {
		Result<AppUserDevice> result = new Result<AppUserDevice>();
		AppUserDevice ent = svc.getById(id);
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
	public Result<AppUserDevice> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		Result<AppUserDevice> result = new Result<AppUserDevice>();
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
	public Result<AppUserDevice> queryById(@RequestParam(name="id",required=true) String id) {
		Result<AppUserDevice> result = new Result<AppUserDevice>();
		AppUserDevice ent = svc.getById(id);
		if(ent==null) {
			result.error500("未找到对应实体");
		}else {
			result.setResult(ent);
			result.setSuccess(true);
		}
		return result;
	}

}