package com.gopher.system.model.vo.request;

/**
 * @author 1500
 * @Date 2019/7/20.
 */
public class CategoryDetailJspRequest extends CategoryRequest {

    /**
     * 父节点ID
     */
    private Integer pId;

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }
}
