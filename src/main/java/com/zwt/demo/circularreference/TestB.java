package com.zwt.demo.circularreference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author zwt
 * @detail
 * @date 2019/8/1
 * @since 1.0
 */
//@Scope(value = BeanDefinition.SCOPE_SINGLETON)
//@Component
public class TestB {

    private TestA testA;

    public TestB() {
    }
    @Autowired
    public TestB(TestA testA) {
        this.testA = testA;
    }


    public void setTestA(TestA testA) {
        this.testA = testA;
    }

    public TestA getTestA() {
        return testA;
    }
}
