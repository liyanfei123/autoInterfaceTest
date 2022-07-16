package demo;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Description:
 *
 * @date:2022/07/09 22:14
 * @author: lyf
 */
public class MyCookiesForGet {

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
    public void testGetWithCookies() throws IOException {
        String uri = bundle.getString("test.get.with.cookies");
        HttpGet get = new HttpGet(url + uri);
        System.out.println(this.cookieStore.getCookies().toString());

        DefaultHttpClient client = new DefaultHttpClient();


        // 方法1 通过header头设置cookie
//        get.setHeader("Cookie", "login=true");


        // 方法2
        // 直接使用之前step拿到的cookie,但这边需要注意的是两个接口的path需保持一致，否则将会无效
        // 若path无法保持一致，则需要自行构造cookie
        client.setCookieStore(this.cookieStore);

        // 方法3 自行构造cookie
//        BasicCookieStore cookieStore = new BasicCookieStore();
//        BasicClientCookie cookie = new BasicClientCookie("login", "true");
//        cookie.setDomain("localhost");
//        cookie.setPath("/");
//        cookieStore.addCookie(cookie);

        HttpResponse response = client.execute(get);

        // 获取状态响应码
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("statusCode= " + statusCode);

        if (statusCode == 200) {
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity, "UTF-8");
            System.out.println(result);
        }


    }
}
