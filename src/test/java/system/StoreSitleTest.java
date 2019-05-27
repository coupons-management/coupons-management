package system;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.gopher.system.controller.model.Result;
import com.gopher.system.model.entity.CpCoupon;
import com.gopher.system.model.entity.CpOutSiteCoupon;
import com.gopher.system.model.entity.CpOutSiteStore;
import com.gopher.system.model.entity.CpSiteStore;
import com.gopher.system.model.vo.CpOutSiteCouponVo;
import com.gopher.system.model.vo.CpOutSiteStoreVo;
import com.gopher.system.model.vo.request.ShowSiteStoreRequest;
import com.gopher.system.service.CpOutSiteCouponService;
import com.gopher.system.service.ShowSiteTwoService;
import com.gopher.system.service.StoreAuditService;

public class StoreSitleTest extends BaseTest{
	@Autowired
	private StoreAuditService storeAuditService;
	@Autowired
	private CpOutSiteCouponService cpOutSiteCouponService;
	@Autowired
	private ShowSiteTwoService showSiteTwoService;
	
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
		cpOutSiteStore.setId(10);
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
	//@Test
	public void deleteCouponAdviseSort() {
	CpOutSiteCoupon obj = new CpOutSiteCoupon();
	obj.setId(2);
	//obj.setHotSort(5);
		cpOutSiteCouponService.deleteAdviseSort(obj);;
       // System.out.println(JSON.toJSONString(rsp));
	}	
	//@Test
	public void getHotStoreList() {
		CpOutSiteStore cpOutSiteStore = new CpOutSiteStore();
		cpOutSiteStore.setId(12);
		cpOutSiteStore.setAdviseSort(2);
	List<CpOutSiteStore>rsp=storeAuditService.getHotStoreList(cpOutSiteStore);
        System.out.println(JSON.toJSONString(rsp));
	}	
	
	//@Test
	public void getAdviseStroreList() {
		CpOutSiteStore cpOutSiteStore = new CpOutSiteStore();
		cpOutSiteStore.setOutId(1);
	List<CpOutSiteStore>rsp=storeAuditService.getAdviseStroreList(cpOutSiteStore);
        System.out.println(JSON.toJSONString(rsp));
	}
	
	//@Test
	public void getHotCountList() {
		CpOutSiteCoupon cpOutSiteStore = new CpOutSiteCoupon();
		cpOutSiteStore.setOutSiteId(1);
		List<CpOutSiteCouponVo>rsp=cpOutSiteCouponService.getHotList(cpOutSiteStore);
        System.out.println(JSON.toJSONString(rsp));
	}	
	//@Test
	public void getAdviseCountList() {
		CpOutSiteCoupon cpOutSiteStore = new CpOutSiteCoupon();
		cpOutSiteStore.setOutSiteId(1);
		List<CpOutSiteCouponVo>rsp=cpOutSiteCouponService.getAdviseList(cpOutSiteStore);
        System.out.println(JSON.toJSONString(rsp));
	}	
	
	
	//@Test
	public void getTopHotStoreList() {
		CpOutSiteStore cpOutSiteStore = new CpOutSiteStore();
		cpOutSiteStore.setId(12);
		cpOutSiteStore.setAdviseSort(2);
	List<CpOutSiteStore>rsp=storeAuditService.getTopHotStoreList(cpOutSiteStore);
        System.out.println(JSON.toJSONString(rsp));
	}	
	
	//@Test
	public void getTopAdviseStroreList() {
		CpOutSiteStore cpOutSiteStore = new CpOutSiteStore();
		cpOutSiteStore.setOutId(1);
	List<CpOutSiteStore>rsp=storeAuditService.getTopAdviseStroreList(cpOutSiteStore);
        System.out.println(JSON.toJSONString(rsp));
	}
	
	//@Test
	public void getTopHotCountList() {
		CpOutSiteCoupon cpOutSiteStore = new CpOutSiteCoupon();
		cpOutSiteStore.setOutSiteId(1);
		List<CpOutSiteCouponVo>rsp=cpOutSiteCouponService.getTopHotList(cpOutSiteStore);
        System.out.println(JSON.toJSONString(rsp));
	}	
	//@Test
	public void getTopAdviseCountList() {
		CpOutSiteCoupon cpOutSiteStore = new CpOutSiteCoupon();
		cpOutSiteStore.setOutSiteId(1);
		List<CpOutSiteCouponVo>rsp=cpOutSiteCouponService.getTopAdviseList(cpOutSiteStore);
        System.out.println(JSON.toJSONString(rsp));
	}	
	
	@Test
		public void getTwoStoreList() {
		ShowSiteStoreRequest obj = new ShowSiteStoreRequest();
		obj.setSiteId(1);

	        System.out.println(JSON.toJSONString(showSiteTwoService.getTwoList(obj)));
		}	
		
	
		
		
		
		
		//@Test
				public void getCouponList() {
			CpOutSiteStore obj = new CpOutSiteStore();
			obj.setOutId(1);
			obj.setStoreId(8783);
			 List<CpCoupon> list =showSiteTwoService.getCouponList(obj);
			 System.out.println(JSON.toJSONString(list));
				}
		
		/*
		@Test
			public void getNewCouponList() {
			CpOutSiteStore obj = new CpOutSiteStore();
				obj.setSiteId(1);
				 List<CpCoupon> list=showSiteTwoService.getNewCouponList(obj);
				 System.out.println(JSON.toJSONString(list));
				}*/
		
	
}
