package com.zwt.demo;

import com.zwt.demo.util.TestClassA;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LookUpTests {
    @Autowired
    private TestClassA testClassA;
    @Test
    public void test(){
        for (int i=0;i<5;i++){
            testClassA.printClass();
        }
    }
}
