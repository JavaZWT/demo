package com.zwt.demo.service;

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
public class TestService {
    @Autowired
    private CourseService courseService;
    @Transactional(rollbackFor = Exception.class)
    public void doSomething() throws Exception{
        try{
            CourseModel courseModel = new CourseModel();
            courseModel.setTeachNo("TestService");
            courseModel.setCouNo("TestService");
            courseModel.setCouName("TestService");
            courseModel.setId(1234570);
            courseService.doSomethingUpdate(courseModel);
        }catch (Exception e){
            System.out.println(e);
            throw e;
        }
    }
}
