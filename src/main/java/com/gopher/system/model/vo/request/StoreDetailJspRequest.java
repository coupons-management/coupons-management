package com.gopher.system.model.vo.request;

/**
 * @author 1500
 * @Date 2019/7/21.
 */
public class StoreDetailJspRequest {
    private String website;
    private Integer outSiteId;

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Integer getOutSiteId() {
        return outSiteId;
    }

    public void setOutSiteId(Integer outSiteId) {
        this.outSiteId = outSiteId;
    }

    public StoreDetailJspRequest() {
    }

    public StoreDetailJspRequest(String website, Integer outSiteId) {
        this.website = website;
        this.outSiteId = outSiteId;
    }
}
