package system;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gopher.system.model.vo.request.CategoryRequest;
import com.gopher.system.service.OfficialWebsiteService;

public class OfficialWebServiceTest extends BaseTest{
	@Autowired
	private OfficialWebsiteService officialWebsiteService ;
	@Test
	public void test() {
		CategoryRequest categoryRequest = new CategoryRequest();
		categoryRequest.setId(1);
		categoryRequest.setOutId(1);
		officialWebsiteService.getAllStoreByCategory(categoryRequest);
	}
}
