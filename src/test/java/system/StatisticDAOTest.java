package system;

import com.alibaba.fastjson.JSON;
import com.gopher.system.dao.mysql.StatisticDAO;
import com.gopher.system.model.vo.request.StatisticRequest;
import com.gopher.system.service.StatisticService;
import com.gopher.system.util.DateUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class StatisticDAOTest extends BaseTest {
    @Autowired
    private StatisticDAO statisticDAO;
    @Autowired
    private StatisticService statisticService;
    @Test
    public void t1(){
        StatisticRequest statisticRequest = new StatisticRequest();
        statisticRequest.setBeginDate(DateUtils.getOneDayStartDate(System.currentTimeMillis()));
        statisticRequest.setEndDate(new Date());
        System.out.println(statisticDAO.getCouponValidCount(statisticRequest));
    }
    @Test
    public void t2(){
        StatisticRequest statisticRequest = new StatisticRequest();
        statisticRequest.setBeginTime(System.currentTimeMillis()-6*24*60*60*1000);
        statisticRequest.setEndTime(System.currentTimeMillis());
        statisticRequest.setRange(1);
        System.out.println(JSON.toJSONString(statisticService.getStatisticBySpider(statisticRequest)));
    }

}
