package com.gopher.system.dao.mongo;

import com.gopher.system.model.vo.response.CpCouponMongoVo;
import com.gopher.system.util.CouponJson;
import com.gopher.system.util.DateUtils;
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

import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

@Repository
public class CouponDAO {
  
    @Resource
    private MongoTemplate mongoTemplate;

    private Query getQuery(String spiderName, String name, String type, String isPast){
      Query query = new Query();
      if(StringUtils.hasText(spiderName)){
        query.addCriteria(Criteria.where("spider_name").is(spiderName));
      }
      if(StringUtils.hasText(name)){
        Pattern pattern = Pattern.compile("^.*"+name+".*$", Pattern.CASE_INSENSITIVE);
        query.addCriteria(Criteria.where("name").regex(pattern));
      }
      if(StringUtils.hasText(type)){
        query.addCriteria(Criteria.where("coupon_type").is(type));
      }
      if(StringUtils.hasText(isPast)){
        String nowDate = DateUtils.getDatetimeString(new Date());
        if(isPast.equals("1")){//已过期
          query.addCriteria(Criteria.where("expire_at").lt(nowDate));
        } else {//未过期
          query.addCriteria(Criteria.where("expire_at").gte(nowDate));
//          Criteria criteria = new Criteria().orOperator(
//                  Criteria.where("expire_at").is(""),
//                  Criteria.where("expire_at").gte(nowDate)
//                  );
//          query.addCriteria(criteria);
        }
      }
      return query;
    }
    
    public List<CpCouponMongoVo> getLastCouponList(int pageNum, String spiderName, String name, String type, String isPast){
      Query query = getQuery(spiderName, name, type, isPast);
      int start = (pageNum - 1) * 10;
      int pageSize = 10;
      List<CpCouponMongoVo> couponList = 
          mongoTemplate.find(query.with(new Sort(Direction.DESC, "id")).skip(start).limit(pageSize), CpCouponMongoVo.class);
      return couponList;
    }
    
    public int getLastCouponCount(String spiderName, String name, String type, String isPast){
      Query query = getQuery(spiderName, name, type, isPast);
      int cnt = (int) mongoTemplate.count(query, CpCouponMongoVo.class);
      return cnt;
    }
    
    public List<CouponJson> getSyncCouponList(){
      Query query = new Query();
      query.addCriteria(Criteria.where("sync_state").is(false));
      int pageSize = 200;
      List<CouponJson> couponList = 
          mongoTemplate.find(query.with(new Sort(Direction.ASC, "id")).limit(pageSize), CouponJson.class);
      return couponList;
    }
    
    public int updateCouponSyncState(String objectId){
      Query query = new Query(); 
      query.addCriteria(Criteria.where("_id").is(objectId));
      Update update = Update.update("sync_state", true);
      WriteResult upsert = mongoTemplate.updateFirst(query, update, "coupon");
      return upsert.getN();       //返回执行的条数
    }

}
