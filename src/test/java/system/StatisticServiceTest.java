package system;

import com.alibaba.fastjson.JSON;
import com.gopher.system.model.vo.request.StatisticRequest;
import com.gopher.system.service.StatisticService;
import com.gopher.system.util.DateUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class StatisticServiceTest extends BaseTest {
    @Autowired
    private StatisticService statisticService;
    @Test
    public void test(){
        StatisticRequest statisticRequest = new StatisticRequest();
        statisticRequest.setBeginTime(System.currentTimeMillis()-2*24*60*60*1000);
        statisticRequest.setEndTime(System.currentTimeMillis());
        statisticRequest.setRange(3);
        System.out.println(JSON.toJSONString(statisticRequest));
        System.out.println(JSON.toJSONString(statisticService.getStatisticBySpider(statisticRequest)));
    }
    @Test
    public void test2(){
        StatisticRequest statisticRequest = new StatisticRequest();
        statisticRequest.setBeginTime(System.currentTimeMillis()-5*24*60*60*1000);
        statisticRequest.setEndTime(System.currentTimeMillis());
        statisticRequest.setRange(3);
        statisticRequest.setSiteId(1);
        System.out.println(JSON.toJSONString(statisticRequest));
        System.out.println(JSON.toJSONString(statisticService.getStatisticBySite(statisticRequest)));
    }
    @Test
    public void test3(){
        StatisticRequest statisticRequest = new StatisticRequest();
        statisticRequest.setBeginTime(System.currentTimeMillis()-5*24*60*60*1000);
        statisticRequest.setEndTime(System.currentTimeMillis());
        statisticRequest.setRange(1);
        statisticRequest.setSiteId(1);
        System.out.println(JSON.toJSONString(statisticRequest));
        System.out.println(JSON.toJSONString(statisticService.getStoreStatistic(statisticRequest)));
    }

    @Test
    public void test4(){
        StatisticRequest statisticRequest = new StatisticRequest();
        statisticRequest.setSiteId(1);
        System.out.println(JSON.toJSONString(statisticService.getSiteStatistic(statisticRequest)));
    }

}
