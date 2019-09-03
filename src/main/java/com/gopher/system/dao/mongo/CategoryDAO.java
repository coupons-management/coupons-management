package com.gopher.system.dao.mongo;

import com.gopher.system.model.vo.response.CpCategoryMongoVo;
import com.gopher.system.model.vo.response.CpCouponMongoVo;
import com.gopher.system.util.CateGoryJson;
import com.mongodb.WriteResult;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import javax.annotation.Resource;
import java.util.List;
import java.util.regex.Pattern;

@Repository
public class CategoryDAO {
    @Resource
    private MongoTemplate mongoTemplate;

//    public List<Category> test(){
//        Query query = new Query();
//        query.addCriteria(Criteria.where("id").gt(1));
//        return mongoTemplate.find(query, Category.class);
//    }
    
    private Query getQuery(String spiderName, String name){
      Query query = new Query();
      if(StringUtils.hasText(spiderName)){
        query.addCriteria(Criteria.where("spider_name").is(spiderName));
      }
      if(StringUtils.hasText(name)){
        Pattern pattern = Pattern.compile("^.*"+name+".*$", Pattern.CASE_INSENSITIVE);
        query.addCriteria(Criteria.where("name").regex(pattern));
      }
      return query;
    }
    
    public List<CpCategoryMongoVo> getLastCategoryList(String spiderName, String name){
      Query query = getQuery(spiderName, name);
      List<CpCategoryMongoVo> categoryList = 
          mongoTemplate.find(query.with(new Sort(Direction.DESC, "id")), CpCategoryMongoVo.class);
      return categoryList;
    }
    
    public int getLastCouponCount(String spiderName, String name){
      Query query = getQuery(spiderName, name);
      int cnt = (int) mongoTemplate.count(query, CpCouponMongoVo.class);
      return cnt;
    }
    
    public List<CateGoryJson> getSyncCategoryList(){
      Query query = new Query();
      query.addCriteria(Criteria.where("sync_state").is(false));
      int pageSize = 5000;
      List<CateGoryJson> couponList = 
          mongoTemplate.find(query.with(new Sort(Direction.ASC, "id")).limit(pageSize), CateGoryJson.class);
      return couponList;
    }
    
    public int updateCategorySyncState(String objectId){
      Query query = new Query(); 
      query.addCriteria(Criteria.where("_id").is(objectId));
      Update update = Update.update("sync_state", true);
      WriteResult upsert = mongoTemplate.updateFirst(query, update, "category");
      return upsert.getN();       //返回执行的条数
    }

}
