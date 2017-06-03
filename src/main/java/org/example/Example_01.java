package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 * httpclient quick start
 * 1. 加入maven依赖
 * <dependency>
 *  <groupId>org.apache.httpcomponents</groupId>
 *  <artifactId>httpclient</artifactId>
 *  <version>4.5.3</version>
 * </dependency>
 * <dependency>
 *  <groupId>org.apache.httpcomponents</groupId>
 *  <artifactId>fluent-hc</artifactId>
 *  <version>4.5.3</version>
 * </dependency>
 * 
 * 
 * @author L 
 *
 * @date 2017年6月3日
 */

public class Example_01 {

    public static void main(String[] args) throws Throwable {
        // TODO Auto-generated method stub
        new Example_01().sendGet();
    }
    
    private void sendGet() throws Throwable{
        String url = "https://www.quyiyuan.com/hospital/210004/";
        
        //创建httpclient实例
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 创建get请求
        HttpGet req = new HttpGet(url);
        // 发送请求
        CloseableHttpResponse resp = httpClient.execute(req);
        
        try{
            // 响应状态码
            System.out.println(resp.getStatusLine());
            // 响应内容
            StringBuffer text = new StringBuffer();
            
            String line = "";
            try(BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            resp.getEntity().getContent(),
                            "utf-8"))){
              //
                while((line = reader.readLine()) != null){
                    text.append(line + '\n');
                }
            }
            
            System.out.println(text.toString());
        } finally {
            resp.close();
        }
    }

}
