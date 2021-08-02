package com.zwt.demo;

import com.zwt.demo.circularreference.TestA;
import com.zwt.demo.circularreference.TestB;
import com.zwt.demo.model.CourseModel;
import com.zwt.demo.service.CourseService;
import com.zwt.demo.service.TestService;
import com.zwt.demo.util.SpringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zwt
 * @detail
 * @date 2020/5/8
 * @since 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDefault {
    @Autowired
    private CourseService courseService;
    @Test
    public void doSomething(){
        CourseModel c = new CourseModel();
        courseService.doSomething();
    }

    @Test
    public void test(){
        try{
            TestA a = SpringUtils.getBean(TestA.class);
            System.out.println(a);
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            TestB b = SpringUtils.getBean(TestB.class);
            System.out.println(b);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
