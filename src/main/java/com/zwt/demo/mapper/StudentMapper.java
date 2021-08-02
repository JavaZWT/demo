package com.zwt.demo.mapper;

import com.zwt.demo.model.StudentCriteria;
import com.zwt.demo.model.StudentModel;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
* StudentMapper
* 
* @version v1.0
* @copy pet
* @date 2018-10-29 17:11:48
*/
public interface StudentMapper {
    /**
     * 根据条件查询记录总数
     */
    int countByExample(StudentCriteria studentCriteria);

    /**
     * 根据条件删除记录
     */
    int deleteByExample(StudentCriteria studentCriteria);

    int insertBatch(List<StudentModel> list);

    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(StudentModel studentModel);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(StudentModel studentModel);

    /**
     * 根据条件查询记录集
     */
    List<StudentModel> selectByExample(StudentCriteria studentCriteria);

    /**
     * 根据主键查询记录
     */
    StudentModel selectByPrimaryKey(Integer id);

    /**
     * 根据条件更新属性不为空的记录
     */
    int updateByExampleSelective(@Param("record") StudentModel studentModel, @Param("example") StudentCriteria studentCriteria);

    /**
     * 根据条件更新记录
     */
    int updateByExample(@Param("record") StudentModel studentModel, @Param("example") StudentCriteria studentCriteria);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(StudentModel studentModel);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(StudentModel studentModel);

    String selectBySomething(StudentModel studentModel);

    int updateStudentName(@Param("name") String name,@Param("id") Integer id);

    int selectStudentScore(@Param("stuNo") String stuNo,@Param("couNo") String couNo);
}