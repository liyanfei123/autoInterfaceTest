package test;

import org.testng.annotations.Test;

/**
 * Description:
 *
 * @date:2022/06/26 10:50
 * @author: lyf
 */
public class MultiThreadOnAnnotion {

    @Test(invocationCount = 10, threadPoolSize = 1, invocationTimeOut = 1000)
    public void test() throws InterruptedException {
        System.out.println("run");
        Thread.sleep(1900);
        System.out.printf("thread Id: %s%n", Thread.currentThread().getId());
    }

}

//
