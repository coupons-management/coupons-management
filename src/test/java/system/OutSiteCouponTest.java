package system;

import com.alibaba.fastjson.JSON;
import com.gopher.system.dao.mysql.CpOutSiteCouponDAO;
import com.gopher.system.model.entity.CpOutSiteCoupon;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gopher.system.model.vo.request.ShowSiteCouponRequest;
import com.gopher.system.service.ShowSiteCouponService;

public class OutSiteCouponTest extends BaseTest {
    @Autowired
    private ShowSiteCouponService showSiteCouponService;
    @Autowired
    private CpOutSiteCouponDAO cpOutSiteCouponDAO;

    @Test
    public void test() {
        ShowSiteCouponRequest showSiteCouponRequest = new ShowSiteCouponRequest();
        showSiteCouponRequest.setCode("");
        showSiteCouponRequest.setId(1332);
        showSiteCouponRequest.setMapId(121);
        showSiteCouponRequest.setCurrentTitle("TEST_123123");
        showSiteCouponRequest.setIsPass("1");
        showSiteCouponRequest.setExpiryTime(System.currentTimeMillis());
        showSiteCouponService.edit(showSiteCouponRequest);
    }


    @Test
    public void getOne() {
        CpOutSiteCoupon coupon = cpOutSiteCouponDAO.selectByPrimaryKey(267);
        if(null != coupon){
            System.out.println(JSON.toJSONString(coupon));
        }
    }
    @Test
    public void update(){
        CpOutSiteCoupon coupon = cpOutSiteCouponDAO.selectByPrimaryKey(267);
        coupon.setClickCount(coupon.getClickCount()+1);
        cpOutSiteCouponDAO.updateByPrimaryKeySelective(coupon);
    }

}
