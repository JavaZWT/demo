package com.zwt.demo.util;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;
import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_SINGLETON;

/**
 * @author zwt
 * @detail
 * @date 2019/6/12
 * @since 1.0
 */
@Component
@Scope(value = SCOPE_SINGLETON)
public class TestClassB {
    public void printClass() {
        System.out.println("This is TestClass B: " + this);
    }
}
