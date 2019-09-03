package com.gopher.system.model.vo.response;

import com.gopher.system.model.entity.CpOutSiteStore;

public class OutSiteStoreRsp extends CpOutSiteStore {

  private static final long serialVersionUID = 1L;

    private Integer typeId;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }
}
