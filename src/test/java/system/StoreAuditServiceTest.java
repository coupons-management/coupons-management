package system;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gopher.system.dao.mysql.CpOutSiteStoreDAO;
import com.gopher.system.model.entity.CpOutSiteCoupon;
import com.gopher.system.model.entity.CpOutSiteStore;
import com.gopher.system.model.vo.request.CouponSortRequest;
import com.gopher.system.model.vo.request.StoreSortRequest;
import com.gopher.system.service.CpOutSiteCouponService;
import com.gopher.system.service.StoreAuditService;

public class StoreAuditServiceTest extends BaseTest {
	@Autowired
	private CpOutSiteStoreDAO cpOutSiteStoreDAO;
	@Autowired
	private StoreAuditService storeAuditService;
	@Autowired
	private CpOutSiteCouponService cpOutSiteCouponService;

	@Test
	public void clearTest() {
		cpOutSiteStoreDAO.clearAdviseSort(1);
		cpOutSiteStoreDAO.clearHotSort(1);
	}
	@Test
	public void addBatch() {
		StoreSortRequest storeSortRequest = new StoreSortRequest();
		storeSortRequest.setOutId(1);
		List<CpOutSiteStore> list = new ArrayList<>();
		CpOutSiteStore cpOutSiteStore = new CpOutSiteStore();
		cpOutSiteStore.setId(70);
		cpOutSiteStore.setHotSort(1);
		list.add(cpOutSiteStore);
		storeSortRequest.setCpOutSiteStoreList(list);
		storeAuditService.updateHotSort(storeSortRequest);
	}
	@Test
	public void addCouponBatch() {
		CouponSortRequest couponSortRequest = new CouponSortRequest();
		couponSortRequest.setOutId(1);
		List<CpOutSiteCoupon> list = new ArrayList<>();
		CpOutSiteCoupon cpOutSiteCoupon = new CpOutSiteCoupon();
		cpOutSiteCoupon.setId(267);
		cpOutSiteCoupon.setHotSort(1);
		list.add(cpOutSiteCoupon);
		couponSortRequest.setCpOutSiteCouponList(list);
		cpOutSiteCouponService.updateHotSort(couponSortRequest);
	}
}
