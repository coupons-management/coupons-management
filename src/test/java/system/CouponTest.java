package system;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.gopher.system.model.vo.Page;
import com.gopher.system.model.vo.request.CouponPageRequest;
import com.gopher.system.model.vo.response.CouponResponse;
import com.gopher.system.service.CouponService;

public class CouponTest extends BaseTest {
	@Autowired
	private CouponService couponService;
	@Test
	public void getPage() {
		CouponPageRequest couponPageRequest = new CouponPageRequest();
		Page<CouponResponse> result = couponService.getPage(couponPageRequest);
		System.out.println(JSON.toJSONString(result));
	}
	
	@Test
	public void getCount() {
		System.out.println(couponService.getTotalCountByStore(1));
		System.out.println(couponService.getValidCountByStore(1));
	}
}
