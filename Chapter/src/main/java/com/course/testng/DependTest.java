package com.course.testng;

import org.testng.annotations.Test;

public class DependTest {
    //依赖测试
    //被依赖的方法如果失败了，依赖的方法会被忽略不执行
    @Test
    public void test1(){
        System.out.println("test1 run");

    }
    @Test(dependsOnMethods = {"test1"})
    public void test2(){
        System.out.println("test2 run");

    }

}
