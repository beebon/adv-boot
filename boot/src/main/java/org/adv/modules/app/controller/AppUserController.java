package org.adv.modules.app.controller;

import java.util.Arrays;

import io.swagger.annotations.ApiOperation;
import org.adv.common.api.vo.Result;
import org.adv.modules.app.entity.AppUser;
import org.adv.modules.app.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
import java.util.Map;



/**
 * @Title: AppUser Controller
 * @Description: 应用用户
 * @author： codesmith
 * @date：   2019-03-07 09:40
 * @version： v1.0
 */
//@Api("{'text': '应用用户'}")
@RestController
@RequestMapping("/app/appUser")
@Slf4j
public class AppUserController {
	@Autowired
	private AppUserService svc;

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
	 * @param appuser
	 * @return
	 */
	@PostMapping(value = "/add")
	public Result<AppUser> add(@RequestBody AppUser appuser) {
		Result<AppUser> result = new Result<AppUser>();
		try {
			svc.save(appuser);
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
	 * @param appuser
	 * @return
	 */
	@PutMapping(value = "/edit")
	public Result<AppUser> edit(@RequestBody AppUser appuser) {
		Result<AppUser> result = new Result<AppUser>();
		AppUser ent = svc.getById(appuser.getId());
		if(ent==null) {
			result.error500("未找到对应实体");
		}else {
			boolean ok = svc.updateById(appuser);
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
	public Result<AppUser> delete(@RequestParam(name="id",required=true) String id) {
		Result<AppUser> result = new Result<AppUser>();
		AppUser ent = svc.getById(id);
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
	public Result<AppUser> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		Result<AppUser> result = new Result<AppUser>();
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
	public Result<AppUser> queryById(@RequestParam(name="id",required=true) String id) {
		Result<AppUser> result = new Result<AppUser>();
		AppUser ent = svc.getById(id);
		if(ent==null) {
			result.error500("未找到对应实体");
		}else {
			result.setResult(ent);
			result.setSuccess(true);
		}
		return result;
	}

}