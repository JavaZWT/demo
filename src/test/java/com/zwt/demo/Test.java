package com.zwt.demo;

import com.zwt.demo.circularreference.TestA;
import com.zwt.demo.circularreference.TestB;

/**
 * @author zwt
 * @detail
 * @date 2019/8/2
 * @since 1.0
 */
public class Test {
    public static void main(String[] args) {
        //1.生成1个TestB对象
        TestB testB = new TestB();
        //2.将TestB注入到TestA
        TestA testA = new TestA();
        testA.setTestB(testB);
        //3.将TestA注入到TestB
        testB.setTestA(testA);
        //4.最后两者完成循环依赖
        System.out.println(testA.getTestB());
        System.out.println(testB.getTestA());
    }
}
