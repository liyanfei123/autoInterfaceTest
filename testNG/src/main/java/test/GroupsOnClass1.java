package test;

import org.testng.annotations.Test;

/**
 * Description:
 *
 * @date:2022/06/18 19:29
 * @author: lyf
 */
@Test(groups = {"g1"})
public class GroupsOnClass1 {

    public void test1() {
        System.out.println("GroupsOnClass1 test1");
    }

    public void test2() {
        System.out.println("GroupsOnClass1 test2");
    }
}
