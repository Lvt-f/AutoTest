package com.course.testng.paramter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviderTest {
    @Test(dataProvider = "data")
    public void testDataProvider(String name,int age){
        System.out.println("name ="+name +"age ="+age);
    }
    @DataProvider(name = "data")
    public Object[][] providerData(){

        Object[][] o = new Object[][]{
                {"zhangsan",10},
                {"lisi",20},
                {"wangwu",30}
        };
        return o;
    }

    /**
     * 通过方法名去传递参数
     * **/
    @Test(dataProvider = "datap")
    public void test1(String name,int age){
        System.out.println("test11111 name="+name+"age="+age);
    }
    @Test(dataProvider = "datap")
    public void test2(String name,int age){
        System.out.println("test22222 name="+name+"age="+age);
    }
    @DataProvider(name = "datap")
    public Object[][] methodDataTest(Method method){

        Object[][] result = null;
        if(method.getName().equals("test1")){
            result=new Object[][]{
                    {"zhangsan",20},
                    {"lisi",23}
            };
        }else if (method.getName().equals("test2")){
            result=new Object[][]{
                    {"wangwu",30},
                    {"zhaoliu",33}
            };
        }

        return result;
    }
}
