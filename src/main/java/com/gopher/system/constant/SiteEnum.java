package com.gopher.system.constant;

/**
 * @author 1500
 *
 * @Date 2019/7/8.
 */
public enum SiteEnum {
    //绿站
    GREEN(1),
    //橙站
    YELLOW(2);
    private int id;

    private SiteEnum(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
