package org.adv.modules.app.controller;

import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;

import org.adv.common.util.oConvertUtils;
import org.adv.common.api.vo.Result;
import org.adv.modules.app.entity.AppPlatform;
import org.adv.modules.app.service.IAppPlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

 /**
 * @Title: Controller
 * @Description: 平台管理
 * @author： adv-boot
 * @date：   2019-03-05
 * @version： V1.0
 */
@RestController
@RequestMapping("/app/appPlatform")
@Slf4j
public class AppPlatformController {
	@Autowired
	private IAppPlatformService appPlatformService;

	/**
	  * 分页列表查询
	 * @param appPlatform
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	@GetMapping(value = "/list")
	public Result<IPage<AppPlatform>> queryPageList(AppPlatform appPlatform,
									  @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
									  @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
									  HttpServletRequest req) {
		Result<IPage<AppPlatform>> result = new Result<IPage<AppPlatform>>();
		QueryWrapper<AppPlatform> queryWrapper = new QueryWrapper<AppPlatform>(appPlatform);
		Page<AppPlatform> page = new Page<AppPlatform>(pageNo,pageSize);
		//排序逻辑 处理
		String column = req.getParameter("column");
		String order = req.getParameter("order");
		if(oConvertUtils.isNotEmpty(column) && oConvertUtils.isNotEmpty(order)) {
			if("asc".equals(order)) {
				queryWrapper.orderByAsc(oConvertUtils.camelToUnderline(column));
			}else {
				queryWrapper.orderByDesc(oConvertUtils.camelToUnderline(column));
			}
		}
		IPage<AppPlatform> pageList = appPlatformService.page(page, queryWrapper);
		//log.debug("查询当前页："+pageList.getCurrent());
		//log.debug("查询当前页数量："+pageList.getSize());
		//log.debug("查询结果数量："+pageList.getRecords().size());
		//log.debug("数据总数："+pageList.getTotal());
		result.setSuccess(true);
		result.setResult(pageList);
		return result;
	}

	/**
	  *   添加
	 * @param appPlatform
	 * @return
	 */
	@PostMapping(value = "/add")
	public Result<AppPlatform> add(@RequestBody AppPlatform appPlatform) {
		Result<AppPlatform> result = new Result<AppPlatform>();
		try {
			appPlatformService.save(appPlatform);
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
	 * @param appPlatform
	 * @return
	 */
	@PutMapping(value = "/edit")
	public Result<AppPlatform> eidt(@RequestBody AppPlatform appPlatform) {
		Result<AppPlatform> result = new Result<AppPlatform>();
		AppPlatform appPlatformEntity = appPlatformService.getById(appPlatform.getId());
		if(appPlatformEntity==null) {
			result.error500("未找到对应实体");
		}else {
			boolean ok = appPlatformService.updateById(appPlatform);
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
	public Result<AppPlatform> delete(@RequestParam(name="id",required=true) String id) {
		Result<AppPlatform> result = new Result<AppPlatform>();
		AppPlatform appPlatform = appPlatformService.getById(id);
		if(appPlatform==null) {
			result.error500("未找到对应实体");
		}else {
			boolean ok = appPlatformService.removeById(id);
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
	public Result<AppPlatform> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		Result<AppPlatform> result = new Result<AppPlatform>();
		if(ids==null || "".equals(ids.trim())) {
			result.error500("参数不识别！");
		}else {
			this.appPlatformService.removeByIds(Arrays.asList(ids.split(",")));
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
	public Result<AppPlatform> queryById(@RequestParam(name="id",required=true) String id) {
		Result<AppPlatform> result = new Result<AppPlatform>();
		AppPlatform appPlatform = appPlatformService.getById(id);
		if(appPlatform==null) {
			result.error500("未找到对应实体");
		}else {
			result.setResult(appPlatform);
			result.setSuccess(true);
		}
		return result;
	}

}
