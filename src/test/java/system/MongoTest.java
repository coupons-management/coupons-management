package system;

import com.alibaba.fastjson.JSON;
import com.gopher.system.dao.mongo.CouponDAO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
public class MongoTest extends BaseTest{
    @Autowired
    private CouponDAO couponDAO;
    @Test
    public void test(){
        System.out.println(JSON.toJSONString(couponDAO.test()));
    }
}
