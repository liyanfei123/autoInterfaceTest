package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Description:
 *
 * @date:2022/06/18 17:25
 * @author: lyf
 */
public class  ParameterTest {

    @Parameters({"param1", "param2"})
    @Test
    public void testParameter(String key1, String key2) {
        System.out.println("传入的参数为：" + key1);
        System.out.println("传入的参数为：" + key2);
    }
}
