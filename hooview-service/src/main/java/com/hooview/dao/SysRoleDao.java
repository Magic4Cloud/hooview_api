package com.hooview.dao;

import com.hooview.api.dto.SelectRoleDTO;
import com.hooview.entity.SysRoleEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 角色管理
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:33:33
 */
@Mapper
public interface SysRoleDao extends BaseDao<SysRoleEntity> {
	
	/**
	 * 查询用户创建的角色ID列表
	 */
	List<SelectRoleDTO> queryRoleIdList();

	Long getCreateUserId(SysRoleEntity role );
}
