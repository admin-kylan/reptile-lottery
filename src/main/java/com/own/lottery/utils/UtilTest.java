package com.own.lottery.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/12/6.
 */
public class UtilTest {

    static CloseableHttpClient httpClient= HttpClients.custom().build();



    public void testA() throws IOException {
        //post请求返回结果
        CloseableHttpResponse response = null;
        HttpEntity entity = null;
        String responseContent = null;
        String httpUrl = "https://www.rndsystems.com/cn";
        HttpPost httpPost = new HttpPost(httpUrl);// 创建httpPost
        //设置参数
        StringEntity stringEntity = new StringEntity("UTF-8");
        stringEntity.setContentType("application/x-www-form-urlencoded");
        httpPost.setEntity(stringEntity);

        response = httpClient.execute(httpPost);
        entity = response.getEntity();
        responseContent = EntityUtils.toString(entity, "UTF-8");
        System.out.println(responseContent);
    }

    @Test
    public void testB(){
        HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1, HttpStatus.SC_OK, "OK");

        System.out.println(response.getProtocolVersion());//HTTP/1.1
        System.out.println(response.getStatusLine().getStatusCode());//200
        System.out.println(response.getStatusLine().getReasonPhrase());//OK
        System.out.println(response.getStatusLine().toString());//HTTP/1.1 200 OK
    }


   /* public static void main(String[] args) {
        URL url = null;
        URLConnection urlconn = null;
        BufferedReader br = null;
        PrintWriter pw = null;
//        String regex = "http://[\\w+\\.?/?]+\\.[A-Za-z]+";
        String regex = "https://[\\w+\\.?/?]+\\.[A-Za-z]+";//url匹配规则
        Pattern p = Pattern.compile(regex);
        try {
            url = new URL("https://www.rndsystems.com/cn");//爬取的网址、这里爬取的是一个生物网站
            urlconn = url.openConnection();
            pw = new PrintWriter(new FileWriter("D:/SiteURL.txt"), true);//将爬取到的链接放到D盘的SiteURL文件中
            br = new BufferedReader(new InputStreamReader(
                    urlconn.getInputStream()));
            String buf = null;
            while ((buf = br.readLine()) != null) {
                Matcher buf_m = p.matcher(buf);
                while (buf_m.find()) {
                    pw.println(buf_m.group());
                }
            }
            System.out.println("爬取成功^_^");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            pw.close();
        }
    }*/
}
