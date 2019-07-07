package com.gopher.system.dao.mongo;

import com.gopher.system.model.entity.Category;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class CouponDAO {
    @Resource
    private MongoTemplate mongoTemplate;

    public List<Category> test(){
        Query query = new Query();
        query.addCriteria(Criteria.where("id").gt(1));
        return mongoTemplate.find(query, Category.class);
    }

}
