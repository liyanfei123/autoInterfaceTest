package suite;

import org.testng.annotations.*;

/**
 * Description:
 *
 * @date:2022/06/16 22:19
 * @author: lyf
 */
public class SuiteConfig {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("before suite run");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("after suite run");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("before test run");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("after test run");
    }
}
