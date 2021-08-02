package com.zwt.demo.mapper;

import com.zwt.demo.model.ScoreCriteria;
import com.zwt.demo.model.ScoreModel;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
* ScoreMapper
* 
* @version v1.0
* @copy pet
* @date 2018-10-29 17:11:48
*/
public interface ScoreMapper {
    /**
     * 根据条件查询记录总数
     */
    int countByExample(ScoreCriteria scoreCriteria);

    /**
     * 根据条件删除记录
     */
    int deleteByExample(ScoreCriteria scoreCriteria);

    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(ScoreModel scoreModel);

    /**
     * 批量插入
     * @param list
     * @return
     */
    int insertBatch(List<ScoreModel> list);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(ScoreModel scoreModel);

    /**
     * 根据条件查询记录集
     */
    List<ScoreModel> selectByExample(ScoreCriteria scoreCriteria);

    /**
     * 根据主键查询记录
     */
    ScoreModel selectByPrimaryKey(Integer id);

    /**
     * 根据条件更新属性不为空的记录
     */
    int updateByExampleSelective(@Param("record") ScoreModel scoreModel, @Param("example") ScoreCriteria scoreCriteria);

    /**
     * 根据条件更新记录
     */
    int updateByExample(@Param("record") ScoreModel scoreModel, @Param("example") ScoreCriteria scoreCriteria);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(ScoreModel scoreModel);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(ScoreModel scoreModel);

    int updateScore(@Param("stuNo") String stuNo,@Param("couNo") String couNo,@Param("score")Integer score);
}