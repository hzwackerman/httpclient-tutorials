package org.example;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;

/**
 * 4.x版本引入流式api，使用更加简单、方便
 * 需要导入如下jar依赖
 * <dependency>
 *  <groupId>org.apache.httpcomponents</groupId>
 *  <artifactId>fluent-hc</artifactId>
 *  <version>4.5.3</version>
 * </dependency>
 * @author L 
 *
 * @date 2017年6月3日
 */

public class Example_02 {

//    public static void main(String[] args) throws Throwable {
//        // TODO Auto-generated method stub
////        new Example_02().sendGet();
////        new Example_02().sendPost();
//    }
    
    public void sendGet() throws Throwable{
        String resp = Request.Get("https://www.apache.org")
            .execute()
            .returnResponse()
            .getStatusLine()
            .toString();
//            .getReasonPhrase();
//            .returnContent()
//            .asString();
        System.err.println(resp);
    }
    
    public void sendPost() throws Throwable{
        // Form = ArrayList<NameValuePair>
        String resp = Request.Post("https://www.quyiyuan.com/user/login/")
            .addHeader("user-agent", "Mozilla/5.0")
            .bodyForm(Form.form()
                    .add("username", "username")
                    .add("pwd", "password")
                    .build())
            .execute()
            .returnContent()
            .asString();
        System.out.println(resp);
    }

}
