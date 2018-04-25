package com.course.testng;

import org.testng.annotations.*;

public class BasucAbbitation {

    //最基本的注解，用来把方法标记为测试的一部分
    @Test
    public void testCase1(){
        System.out.println("Test这是测试用例1");
    }
    @Test
    public void testCase2(){
        System.out.println("Test这是测试用例2");
    }

//每次运行都会执行一次此方法
    @BeforeMethod
    public void beforMethod(){
        System.out.println("beforMethod这是测试方法之前运行的");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("afterMethod这是测试方法之后运行的");
    }
    //每次运行类都会执行的方法
    @BeforeClass
    public void beforeClass(){
        System.out.println("beforeClass这是在类运行之前运行的方法");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("afterClasss这是在类运行之后运行的方法");
    }
    //在类执行之前和之后运行的
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforeSuite测试套件");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("afterSuite测试套件");
    }
}
