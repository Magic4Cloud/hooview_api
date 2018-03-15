package com.hooview.api.dao;

import com.hooview.api.entity.CodeEntity;
import com.hooview.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import java.util.Map;

/**
 * 验证码表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:34:44
 */
@Mapper
public interface CodeDao extends BaseDao<CodeEntity> {

    //查询验证码是否过期
    CodeEntity queryByCheckCode(Map<String, Object> map);

}
