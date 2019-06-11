package system;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gopher.system.model.vo.request.ShowSiteStoreRequest;
import com.gopher.system.service.ShowSiteService;

public class ShowSiteServiceTest extends BaseTest{
	@Autowired
	private ShowSiteService showSiteService;
	@Test
	public void delete() {
		ShowSiteStoreRequest showSiteStoreRequest = new ShowSiteStoreRequest();
		showSiteStoreRequest.setSiteId(1);
		showSiteStoreRequest.setStoreId(10066);
		showSiteService.deleteStoreInSite(showSiteStoreRequest);
	}
}
