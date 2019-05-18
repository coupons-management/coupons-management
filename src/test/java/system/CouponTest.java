package system;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.gopher.system.model.entity.CpCoupon;
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
		couponPageRequest.setExpired(1);
		couponPageRequest.setScrapy(1);
		couponPageRequest.setTitle("TEST");
		Page<CouponResponse> result = couponService.getPage(couponPageRequest);
		System.out.println(JSON.toJSONString(result));
	}
	
	@Test
	public void getCount() {
		System.out.println(couponService.getTotalCountByStore(1));
		System.out.println(couponService.getValidCountByStore(1));
	}
	@Test
	public void getListByStoreId() {
		System.out.println(JSON.toJSONString(couponService.getListByStore(28)));
	}
	@Test
	public void create() {
		CpCoupon cpCoupon = new CpCoupon();
		cpCoupon.setStoreId(1);
		cpCoupon.setName("123");
		couponService.createCoupon(cpCoupon);
	}
	@Test
	public void edit() {
		CpCoupon cpCoupon = new CpCoupon();
		cpCoupon.setId(161);
		cpCoupon.setStoreId(1);
		cpCoupon.setName("TEST");
		couponService.editCoupon(cpCoupon);
	}
	@Test
	public void delete() {
		couponService.deleteCoupon(161);
	}
	@Test
	public void getOne() {
		System.out.println(JSON.toJSONString(couponService.getCoupon(149)));
	}
}
