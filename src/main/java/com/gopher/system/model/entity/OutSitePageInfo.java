package com.gopher.system.model.entity;

import java.io.Serializable;

/**
 * OUT_SITE_PAGE_INFO
 * @author 
 */
public class OutSitePageInfo implements Serializable {
    private Integer id;

    private Integer outSiteId;

    private Integer type;

    private String name;

    private String title;

    private String keyWords;

    private String description;

    private static final long serialVersionUID = 1L;
    
    //页面类型
    public static Integer TYPE_INDEX = 1;//首页
    public static Integer TYPE_CATEGORY_LIST = 2;//分类列表
    public static Integer TYPE_CATEGORY_DETAIL = 3;//分类详情
    public static Integer TYPE_STORE_LIST = 4;//商家列表
    public static Integer TYPE_ABOUT_US = 5;//关于我们
    public static Integer TYPE_CONTACT_US = 6;//联系我们

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOutSiteId() {
        return outSiteId;
    }

    public void setOutSiteId(Integer outSiteId) {
        this.outSiteId = outSiteId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}