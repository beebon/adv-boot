package org.adv.modules.system.service;

import java.util.List;

import org.adv.modules.system.entity.SysPermission;
import org.adv.common.exception.BootException;
import org.adv.modules.system.model.TreeModel;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 菜单权限表 服务类
 * </p>
 *
 * @author scott
 * @since 2018-12-21
 */
public interface ISysPermissionService extends IService<SysPermission> {
	
	public List<TreeModel> queryListByParentId(String parentId);
	
	/**真实删除*/
	public void deletePermission(String id) throws BootException;
	/**逻辑删除*/
	public void deletePermissionLogical(String id) throws BootException;
	
	public void addPermission(SysPermission sysPermission) throws BootException;
	
	public void editPermission(SysPermission sysPermission) throws BootException;
	
	public List<SysPermission> queryByUser(String username);
}
