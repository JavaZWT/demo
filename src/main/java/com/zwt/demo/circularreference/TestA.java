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
//@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
//@Component
public class TestA {

    private TestB testB;

    public TestA() {
    }


    public TestA(TestB testB) {
        this.testB = testB;
    }
    @Autowired
    public void setTestB(TestB testB) {
        this.testB = testB;
    }

    public TestB getTestB() {
        return testB;
    }
}
