package com.hooview.api.dao;

import com.hooview.api.dto.HistoryDTO;
import com.hooview.api.entity.BrowseHistoryEntity;
import com.hooview.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

/**
 * 用户浏览历史表
 * 
 * @author lee
 * @email 
 * @date 2018-01-19 09:34:44
 */
@Mapper
public interface BrowseHistoryDao extends BaseDao<BrowseHistoryEntity> {
    void deleteBrowseHistory(@RequestBody BrowseHistoryEntity browseHistory);

    List<HistoryDTO> queryHistoryList(Map<String,Object> map);

    void deleteSource(Map<String,Object> map);
	
}
