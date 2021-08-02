package com.zwt.demo.service;

import com.zwt.demo.mapper.CourseMapper;
import com.zwt.demo.model.CourseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zwt
 * @detail
 * @date 2019/7/29
 * @since 1.0
 */
@Service
public class CourseService {
    @Autowired
    private CourseMapper courseMapper;

    @Transactional(rollbackFor = Exception.class)
    public void doSomethingUpdate(CourseModel courseModel){
        courseMapper.updateByPrimaryKey(courseModel);
    }

    @Transactional(rollbackFor = Exception.class)
    public void doSomething(){
        CourseModel courseModel = new CourseModel();
        courseModel.setCouNo("11");
        courseModel.setCouName("111");
        courseModel.setId(123456);
        doSomethingUpdate(courseModel);
        boolean flag =true;
        if(flag){
            throw new RuntimeException("1111");
        }
    }
}
