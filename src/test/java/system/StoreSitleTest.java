package system;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gopher.system.model.entity.CpOutSiteCoupon;
import com.gopher.system.model.entity.CpOutSiteStore;
import com.gopher.system.model.entity.CpSiteStore;
import com.gopher.system.service.CpOutSiteCouponService;
import com.gopher.system.service.StoreAuditService;

public class StoreSitleTest extends BaseTest{
	@Autowired
	private StoreAuditService storeAuditService;
	@Autowired
	private CpOutSiteCouponService cpOutSiteCouponService;
	
	
	
	
	//@Test
	public void addSite() {
		CpOutSiteStore cpOutSiteStore = new CpOutSiteStore();
		cpOutSiteStore.setOutId(1);
		cpOutSiteStore.setStoreId(1);
		 storeAuditService.addSite(cpOutSiteStore);
       // System.out.println(JSON.toJSONString(rsp));
	}
	
	//@Test
	public void updateHotSort() {
		CpOutSiteStore cpOutSiteStore = new CpOutSiteStore();
		cpOutSiteStore.setId(12);
		cpOutSiteStore.setHotSort(2);
		 storeAuditService.updateHotSort(cpOutSiteStore);
       // System.out.println(JSON.toJSONString(rsp));
	}
	
	//@Test
	public void deleteHotSort() {
		CpOutSiteStore cpOutSiteStore = new CpOutSiteStore();
		cpOutSiteStore.setId(12);
		//cpOutSiteStore.setHotSort(2);
		 storeAuditService.deleteHotSort(cpOutSiteStore);
       // System.out.println(JSON.toJSONString(rsp));
	}
	//@Test
	public void updateAdviseSort() {
		CpOutSiteStore cpOutSiteStore = new CpOutSiteStore();
		cpOutSiteStore.setId(12);
		cpOutSiteStore.setAdviseSort(2);
		 storeAuditService.updateAdviseSort(cpOutSiteStore);;
       // System.out.println(JSON.toJSONString(rsp));
	}
	
	
	//@Test
	public void deleteAdviseSort() {
		CpOutSiteStore cpOutSiteStore = new CpOutSiteStore();
		cpOutSiteStore.setId(12);
		//cpOutSiteStore.setAdviseSort(2);
		 storeAuditService.deleteAdviseSort(cpOutSiteStore);
       // System.out.println(JSON.toJSONString(rsp));
	}
	
	
	
	//@Test
		public void updateCouponHotSort() {
		CpOutSiteCoupon obj = new CpOutSiteCoupon();
		obj.setId(2);
		obj.setHotSort(5);
			cpOutSiteCouponService.updateHotSort(obj);;
	       // System.out.println(JSON.toJSONString(rsp));
		}
			
	//@Test
	public void deleteCountHotSort() {
	CpOutSiteCoupon obj = new CpOutSiteCoupon();
	obj.setId(2);
	//obj.setHotSort(5);
		cpOutSiteCouponService.deleteHotSort(obj);;
       // System.out.println(JSON.toJSONString(rsp));
	}
	//@Test
	public void updateCouponAdviseSort() {
	CpOutSiteCoupon obj = new CpOutSiteCoupon();
	obj.setId(2);
	obj.setAdviseSort(8);
		cpOutSiteCouponService.updateAdviseSort(obj);;
       // System.out.println(JSON.toJSONString(rsp));
	}
	@Test
	public void deleteCouponAdviseSort() {
	CpOutSiteCoupon obj = new CpOutSiteCoupon();
	obj.setId(2);
	//obj.setHotSort(5);
		cpOutSiteCouponService.deleteAdviseSort(obj);;
       // System.out.println(JSON.toJSONString(rsp));
	}	
	
}
