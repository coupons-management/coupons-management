package com.gopher.system.dao.mysql;

import java.util.List;

import com.gopher.system.model.entity.CpType;
import com.gopher.system.model.entity.TMessage;


public interface SynMessageDataDao {
    List<TMessage> getCouPonMessages();

    List<TMessage> getScrapyeMessages();

    List<TMessage> getStoreMessages();

    void insertStoreMessages(TMessage message);

    void insertCouponMessages(TMessage message);

    void insertCategoryMessages(TMessage message);


    //修改类型消息状态
    int updateCategoryMessageStatus(String id);

    //修改优惠卷消息状态
    int updateCouPonMessageStatus(String id);

    //修改商家消息状态
    int updateStoreMessageStatus(String id);

    void insertType(CpType json);

    //删除前一天已处理的优惠卷消息
    void deleteCouPonMessages();

    //删除前一天已处理的商家消息;
    void deleteStoreMessage();

    //删除前一天已处理的商家类型;
    int deleteCategoryMessage();


}

