package com.gopher.system.model.vo.request;

/**
 * @author 1500
 * @Date 2019/7/20.
 */
public class CategoryDetailJspRequest extends CategoryRequest {

    /**
     * 分类名称
     */
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
