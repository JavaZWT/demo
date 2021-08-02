package com.zwt.demo;

import com.zwt.demo.model.CourseModel;
import com.zwt.demo.service.CourseService;
import com.zwt.demo.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author zwt
 * @detail
 * @date 2019/7/29
 * @since 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionalTest {

    @Autowired
    private CourseService courseService;
    @Autowired
    private TestService testService;
    @Test
    public void test() throws Exception{
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        executorService.scheduleAtFixedRate(()->{
            try{
                testService.doSomething();
            }catch (Exception e){
                e.printStackTrace();
            }
        }, 0, 2, TimeUnit.SECONDS);

        executorService.scheduleAtFixedRate(()->{
            try{
                courseService.doSomething();
            }catch (Exception e){
                e.printStackTrace();
            }
        },1,2,TimeUnit.SECONDS);
        //courseService.doSomething();
        Thread.sleep(100000);
    }
}
