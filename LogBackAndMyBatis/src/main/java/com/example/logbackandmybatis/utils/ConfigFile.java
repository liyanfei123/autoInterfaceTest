package com.example.logbackandmybatis.utils;

import com.example.logbackandmybatis.model.meta.enums.InterfaceName;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Description:
 *
 * @date:2022/08/01 22:06
 * @author: lyf
 */
public class ConfigFile {

    private static ResourceBundle bundle = ResourceBundle.getBundle("application", Locale.CHINA);

    public static String getUrl(InterfaceName name) {
        String address = bundle.getString("test.url");
        String uri = "";
        String testUrl;

        if (name == InterfaceName.GETUSERLIST) {
            uri = bundle.getString("getUserList.uri");
        } else if (name == InterfaceName.GETUSERLIST) {
            uri = bundle.getString("getUserList.uri");
        } else if (name == InterfaceName.GETUSERINFO) {
            uri = bundle.getString("getUserInfo.uri");
        } else if (name == InterfaceName.UPDATEUSERINFO) {
            uri = bundle.getString("updateUserInfo.uri");
        } else if (name == InterfaceName.LOGIN) {
            uri = bundle.getString("addUser.uri");
        }

        testUrl = address + uri;
        return testUrl;
    }


}
