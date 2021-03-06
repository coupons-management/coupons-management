package system;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.gopher.system.model.vo.request.CategoryRequest;
import com.gopher.system.model.vo.request.ShowSiteStoreRequest;
import com.gopher.system.model.vo.request.StoreRequest;
import com.gopher.system.service.ShowSiteService;
import com.gopher.system.service.WebSiteService;

public class OfficialWebServiceTest extends BaseTest{
	@Autowired
	private WebSiteService officialWebsiteService ;
	@Autowired
	private ShowSiteService showSiteService;
	@Test
	public void test() {
		CategoryRequest categoryRequest = new CategoryRequest();
		categoryRequest.setId(1);
		categoryRequest.setSiteId(1);
		System.out.println(JSON.toJSONString(officialWebsiteService.getCouponListByCategory(categoryRequest)));
	}
	
	@Test
	public void test2() {
		StoreRequest storeRequest = new StoreRequest();
		storeRequest.setSiteId(1);
		storeRequest.setStoreId(10078);
		System.out.println(JSON.toJSONString(officialWebsiteService.getStoreDetail(storeRequest)));
	}
	@Test
	public void test3() {
		ShowSiteStoreRequest showSiteStoreRequest= new ShowSiteStoreRequest();
		showSiteStoreRequest.setSiteId(1);
		showSiteStoreRequest.setStoreId(10077);
		showSiteService.deleteStoreInSite(showSiteStoreRequest);
	}
}
