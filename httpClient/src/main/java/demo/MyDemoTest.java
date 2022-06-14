package demo;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Description:
 *
 * @date:2022/06/14 21:55
 * @author: lyf
 */
public class MyDemoTest {

    @Test
    public void test1() throws IOException {
        String result;
        HttpGet get = new HttpGet("https://www.baidu.com/");
        HttpClient client = new DefaultHttpClient(); // 用于执行get方法
        HttpResponse response = client.execute(get);
        HttpEntity entity = response.getEntity();  // 获取响应实体
        result = EntityUtils.toString(entity, "utf-8");
        System.out.println(result);
    }


}
