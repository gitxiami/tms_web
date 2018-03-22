package com.sunyard.tms.constant;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author:zhangbin
 * @date:${date} ${time}
 */
public class LogName {
    public static List<String> list = new ArrayList<>();
    static {
        list.add("login");
        list.add("change password");
        list.add("query user");
        list.add("add user");
        list.add("modify user");
        list.add("delete user");
        list.add("unlock user");
        list.add("reset user");
        list.add("query role");
        list.add("add role");
        list.add("modify role");
        list.add("delete role");
        list.add("edit permissions");
        list.add("query organization");
        list.add("add organization");
        list.add("modify organization");
        list.add("delete organization");
        list.add("query log");
        list.add("query brand");
        list.add("add brand");
        list.add("modify brand");
        list.add("query model");
        list.add("delete brand");
        list.add("add model");
        list.add("modify model");
        list.add("delete model");
        list.add("query terminal");
        list.add("add terminal");
        list.add("modify terminal");
        list.add("disable terminal");
        list.add("enable terminal");
        list.add("delete terminal");
        list.add("query merchant");
        list.add("query merchant detail");
        list.add("add merchant");
        list.add("modify merchant");
        list.add("enable merchant");
        list.add("disable merchant");
        list.add("delete merchant");
    }
}
