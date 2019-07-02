package com.gopher.system.model.vo.request;

import com.gopher.system.model.vo.PageRequestBase;

public class UserPageRequst extends PageRequestBase{

    private String name;

    private String account;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
