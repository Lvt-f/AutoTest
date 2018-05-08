package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.DefaultClientConnection;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForGet {

    private String url;
    private ResourceBundle bundle;

    CookieStore store;
    @BeforeTest
    public void beforeTets(){
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");
    }
    @Test
    public void testGetCookies() throws IOException {
        String result;
        //从配置文件中拼接测试URl
        String uri = bundle.getString("getCookies.uri");
        String testUrl = this.url+uri;
        //测试逻辑代码书写
        HttpGet get = new HttpGet(testUrl);
        HttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        //获取cookies信息
        this.store =((DefaultHttpClient) client).getCookieStore();
        List<Cookie>cookies= store.getCookies();
        for(Cookie cookie:cookies){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie name="+name+
            ";cookie value = "+value);

        }
    }
    @Test(dependsOnMethods = {"testGetCookies"})
    public void testGetwithCookies() throws IOException {
        String uri = bundle.getString("test.get.with.cookies");
        String testurl = this.url+uri;
        HttpGet httpGet = new HttpGet(testurl);
        DefaultHttpClient client = new DefaultHttpClient();
        //设置cookies信息
        client.setCookieStore(this.store);
        HttpResponse response=client.execute(httpGet);

        //获取响应的状态吗
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.printf("statusCode"+statusCode);

        if (statusCode == 200){
            String result;
            result = EntityUtils.toString(response.getEntity(),"utf-8");
            System.out.println(result);
        }



    }
}
