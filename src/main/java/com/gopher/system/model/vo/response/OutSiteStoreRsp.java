package com.gopher.system.model.vo.response;

import com.gopher.system.model.entity.CpOutSiteStore;

public class OutSiteStoreRsp extends CpOutSiteStore {

    private int typeId;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }
}
