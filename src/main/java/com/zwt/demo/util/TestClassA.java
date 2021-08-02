package com.zwt.demo.util;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

/**
 * @author zwt
 * @detail
 * @date 2019/6/12
 * @since 1.0
 */
@Component
public class TestClassA {
    @Lookup
    public TestClassB getTestClassB() {
        return null;
    }
    public void printClass() {
        System.out.println("This is TestClass A: " + this);
        getTestClassB().printClass();
    }
}
