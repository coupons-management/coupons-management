package com.gopher.system.model.vo.response;

import com.gopher.system.model.entity.CpOutSiteStore;

public class OutSiteStoreRsp extends CpOutSiteStore {

    private int typeId;

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }
}
