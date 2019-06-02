package system;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gopher.system.model.vo.request.ShowSiteCouponRequest;
import com.gopher.system.service.ShowSiteCouponService;

public class OutSiteCouponTest extends BaseTest{
	@Autowired
	private ShowSiteCouponService showSiteCouponService;
	
	@Test
	public void test() {
		ShowSiteCouponRequest showSiteCouponRequest  = new ShowSiteCouponRequest();
		showSiteCouponRequest.setCode("");
		showSiteCouponRequest.setId(1332);
		showSiteCouponRequest.setMapId(121);
		showSiteCouponRequest.setCurrentTitle("TEST_123123");
		showSiteCouponRequest.setIsPass("1");
		showSiteCouponRequest.setExpiryTime(System.currentTimeMillis());
		showSiteCouponService.edit(showSiteCouponRequest);
	}

}
