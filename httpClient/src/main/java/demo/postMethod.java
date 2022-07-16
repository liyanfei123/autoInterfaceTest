package demo;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Description:
 *
 * @date:2022/07/16 21:10
 * @author: lyf
 */
public class postMethod {

    private String url;

    private ResourceBundle bundle;

    // 存储cookie
    private CookieStore cookieStore;

    @BeforeTest
    private void getPro() {
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url.get");
    }

    @Test
    public void getCookies() throws IOException {
        String uri = bundle.getString("getCookies.uri");
        HttpGet get = new HttpGet(url + uri);
        DefaultHttpClient client = new DefaultHttpClient(); // 用于获取cookie信息
        HttpResponse response = client.execute(get);
        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity, "UTF-8");
        System.out.println(result);

        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("statusCode= " + statusCode);

        // 获取Cookies信息
        this.cookieStore = client.getCookieStore();
        List<Cookie> cookies = cookieStore.getCookies();


        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie name: " + name + ", cookie value: " + value);
        }
    }

    @Test(dependsOnMethods = {"getCookies"})
    public void testPostWithCookies() throws IOException {
        String uri = bundle.getString("test.post.with.cookies");

        // 声明一个clinet对象，用于执行方法
        DefaultHttpClient client = new DefaultHttpClient();

        // 声明一个post方法
        HttpPost request = new HttpPost(url + uri);

        // 添加body参数
        JSONObject param = new JSONObject();
        param.put("name", "lyf");
        param.put("age", "25");

        // 设置请求头信息
        request.setHeader("content-type", "application/json");

        // 将参数信息添加到方法中
        StringEntity entity = new StringEntity(param.toString(), "UTF-8");
        request.setEntity(entity);

        // 声明一个对象来进行响应结果的存储
        String result;

        // 设置cookie信息
        client.setCookieStore(cookieStore);

        // 执行post方法
        HttpResponse response = client.execute(request);
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("statusCode= " + statusCode);

        // 处理响应结果
        if (response.getStatusLine().getStatusCode() == 200) {
            HttpEntity entity2 = response.getEntity();
            result = EntityUtils.toString(entity2, "UTF-8");
            System.out.println(result);

            JSONObject resultJson = new JSONObject(result);
            String msg = (String) resultJson.get("msg");
            Assert.assertEquals("success", msg);
            System.out.println(resultJson);
        }

    }


//    网上抄的post方法，可能会用上
//    httpClIEnt clIEnt = new DefaulthttpClIEnt();
//
//    //the request to get the cookies
//    httpGet request = new httpGet("http://www.SitenameCutOut.cz");
//
//    List <nameValuePair> parameters = new ArrayList <nameValuePair>();
//    parameters.add(new BasicnameValuePair("vIEw_state","eaftOTAPef3NDs79"));
//    parameters.add(new BasicnameValuePair("age","23"));
//    parameters.add(new BasicnameValuePair("button","go"));
//
//    UrlEncodedFormEntity entity = new UrlEncodedFormEntity(parameters);
//    httpPost post = new httpPost("http://www.SameSiteAsAbove.cz");
//    post.setEntity(entity);
//
//
//    //post.addheader(request.getFirstheader("Set-cookie")); maybe?
//    post.addheader("Host","theSiteHost");
//    post.addheader("User-Agent","Mozilla/5.0 (windows NT 6.0; rv:2.0.1) Gecko/20100101 firefox/4.0.1");
//    post.addheader("Accept","text/HTML,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
//    post.addheader("Accept-Language","en-us,en;q=0.5");
//    post.addheader("Accept-EnCoding","gzip,deflate");
//    post.addheader("Accept-Charset","ISO-8859-1,utf-8;q=0.7,*;q=0.7");
//    post.addheader("Keep-Alive","115");
//    post.addheader("Connection","keep-alive");
//
//
//    clIEnt.execute(request);
}
