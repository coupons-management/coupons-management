package com.gopher.system.dao.mongo;

import com.gopher.system.model.vo.response.CpStoreMongoVo;
import com.gopher.system.util.StoreJson;
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
public class StoreDAO {
  
    @Resource
    private MongoTemplate mongoTemplate;

    private Query getQuery(String spiderName, String name, String website){
      Query query = new Query();
      if(StringUtils.hasText(spiderName)){
        query.addCriteria(Criteria.where("spider_name").is(spiderName));
      }
      if(StringUtils.hasText(name)){
        Pattern pattern = Pattern.compile("^.*"+name+".*$", Pattern.CASE_INSENSITIVE);
        query.addCriteria(Criteria.where("name").regex(pattern));
      }
      if(StringUtils.hasText(website)){
        Pattern pattern = Pattern.compile("^.*"+website+".*$", Pattern.CASE_INSENSITIVE);
        query.addCriteria(Criteria.where("website").regex(pattern));
      }
      return query;
    }
    
    public List<CpStoreMongoVo> getLastStoreList(int pageNum, String spiderName, String name, String website){
      Query query = getQuery(spiderName, name, website);
      int pageSize = 10;
      int start = (pageNum - 1) * pageSize;
      List<CpStoreMongoVo> storeList = 
          mongoTemplate.find(query.with(new Sort(Direction.DESC, "id")).skip(start).limit(pageSize), CpStoreMongoVo.class);
      return storeList;
    }
    
    public int getLastStoreCount(int pageNum, String spiderName, String name, String website){
      Query query = getQuery(spiderName, name, website);
      int cnt = (int) mongoTemplate.count(query, CpStoreMongoVo.class);
      return cnt;
    }
    
    public List<StoreJson> getSyncStoreList(){
      Query query = new Query();
      query.addCriteria(Criteria.where("sync_state").is(false));
//      Pattern pattern = Pattern.compile("^.*http.*$", Pattern.CASE_INSENSITIVE);
//      query.addCriteria(Criteria.where("url_name").regex(pattern));
      int pageSize = 5000;
      List<StoreJson> storeList = 
          mongoTemplate.find(query.with(new Sort(Direction.ASC, "id")).limit(pageSize), StoreJson.class);
      return storeList;
    }

    public int updateStoreSyncState(String objectId){
      Query query = new Query(); 
      query.addCriteria(Criteria.where("_id").is(objectId));
      Update update = Update.update("sync_state", true);
      WriteResult upsert = mongoTemplate.updateFirst(query, update, "store"); //查询更新第一条
      return upsert.getN();       //返回执行的条数
    }
    
    public StoreJson getStoreById(Integer storeId){
      Query query = new Query();
      query.addCriteria(Criteria.where("id").is(storeId));
      StoreJson store = mongoTemplate.findOne(query, StoreJson.class);
      return store;
    }

}
