package com.hooview.api.dao;

        import com.hooview.api.dto.MuteCharMembers;
        import com.hooview.api.entity.MuteEntity;
        import com.hooview.dao.BaseDao;
        import org.apache.ibatis.annotations.Mapper;

        import java.util.List;
        import java.util.Map;

/**
 * 禁言列表
 *
 * @author lee
 * @email
 * @date 2018-03-05 09:12:07
 */
@Mapper
public interface MuteDao extends BaseDao<MuteEntity> {

    void saveBatch(MuteCharMembers mute);

    List<MuteEntity> queryMuteList(Map<String, Object> map);

}
