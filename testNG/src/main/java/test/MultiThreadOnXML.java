package test;

import org.testng.annotations.Test;

/**
 * Description:
 *
 * @date:2022/06/26 11:07
 * @author: lyf
 */
public class MultiThreadOnXML {

    @Test
    public void test1() {
        System.out.println("test1 run");
        System.out.printf("thread Id: %s%n", Thread.currentThread().getId());
    }

    @Test
    public void test2() {
        System.out.println("test2 run");
        System.out.printf("thread Id: %s%n", Thread.currentThread().getId());
    }

    @Test
    public void test3() {
        System.out.println("test3 run");
        System.out.printf("thread Id: %s%n", Thread.currentThread().getId());
    }
}
