package com.gopher.system.model.vo.request;

import com.gopher.system.model.vo.PageRequestBase;

/**
 * @author 1500
 * @Date 2019/7/2.
 */
public class StoreAvailableRequet extends PageRequestBase {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
