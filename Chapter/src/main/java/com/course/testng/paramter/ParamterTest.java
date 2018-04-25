package com.course.testng.paramter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParamterTest {
    //通过xml文件，数据来自xml

    @Test
    @Parameters({"name","age"})
    public void paramTest1(String name,int age){
        System.out.println("name ="+name +"age ="+age);
    }
}
