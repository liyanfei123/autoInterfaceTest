package test;

import org.testng.annotations.Test;

/**
 * Description:
 *
 * @date:2022/06/20 22:08
 * @author: lyf
 */
public class DependTest {

    @Test
    public void func(){}

    @Test
    public void depend() {
    }

    @Test(dependsOnMethods = "depend")
    public void f() {
        throw new RuntimeException();
    }

    @Test
    public void failed() {
        throw new RuntimeException();
    }

}
