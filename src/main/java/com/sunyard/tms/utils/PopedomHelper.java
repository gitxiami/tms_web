package com.sunyard.tms.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import com.sunyard.tms.entity.Popedom;

/**
 * @Description:权限工具类
 * @author:zhangbin
 * @date:2017年7月31日 上午9:05:41
 */
public class PopedomHelper {
    /**
     * 生成树结构
     *
     * @return List<Popedom>
     */
    public static List<Popedom> getTree(List<Popedom> all) {
        List<Popedom> popedom1 = new ArrayList<Popedom>();
        for (Popedom pope : all) {
            if ("0".equals(pope.getPopedomPid())) {
                popedom1.add(pope);
            }
        }
        for (Popedom popedom : popedom1) {
            getChild(popedom, all);
        }
        return popedom1;
    }
    private static void getChild(Popedom popedom1, List<Popedom> all) {
        // 子权限
        List<Popedom> childList = new ArrayList<>();
        // 子权限Id
        List<String> childString = new ArrayList<>();
        for (Popedom popedom : all) {
            // 遍历所有节点，将父权限id与传过来的id比较
            if (StringUtils.isNotBlank(popedom.getPopedomPid())) {
                if (popedom.getPopedomPid().equals(popedom1.getPopedomId())) {
                    childList.add(popedom);
                    childString.add(popedom.getPopedomId());
                    popedom1.setChildren(childList);
                    popedom1.setIds(childString);
                }
            }
        }
        // 把子菜单的子菜单再循环一遍
        for (Popedom popedom : childList) {
            getChild(popedom, all);
        } // 递归退出条件
        if (childList.size() == 0) {
            return;
        }
    }

    /**
     * 将英文逗号分隔的权限id转成list
     * 
     * @param popedomIds
     * @return List<String>
     */
    public static List<String> getListPopedom(String popedomIds) {
        String[] arr = popedomIds.split(",");

        List<String> list = new ArrayList<>();

        for (String s : arr) {
            list.add(s);
        }
        return list;
    }

    /**
     * 将权限列表通过英文逗号分隔
     * 
     * @param list
     * @return String
     */
    public static String getPopedomIds(List<String> list) {
        if (CollectionUtils.isEmpty(list)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();

        for (String s : list) {
            sb.append(s + ",");
        }
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }
}
