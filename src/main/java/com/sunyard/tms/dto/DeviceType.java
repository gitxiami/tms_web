package com.sunyard.tms.dto;

import java.util.List;

/**
 * @Description:
 * @author:zhangbin
 * @date:${date} ${time}
 */
public class DeviceType {
    private String id;
    private String name;
    List<String> children;

    public String getId() {
        return id;
    }

    public DeviceType() {
    }

    public DeviceType(String id, String name, List<String> children) {
        this.id = id;
        this.name = name;
        this.children = children;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getChildren() {
        return children;
    }

    public void setChildren(List<String> children) {
        this.children = children;
    }
}
