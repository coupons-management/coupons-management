package system;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.gopher.system.model.entity.CpStore;
import com.gopher.system.model.vo.Page;
import com.gopher.system.model.vo.request.StorePageRequst;
import com.gopher.system.model.vo.response.StoreResponse;
import com.gopher.system.service.StoreService;

public class StoreTest extends BaseTest{
	@Autowired
    private StoreService storeService;
	
	@Test
	public void getPage() {
		StorePageRequst request = new StorePageRequst();
		request.setCountry("US");
		request.setPageNumber(1);
		request.setPageSize(1);
		Page<StoreResponse> page = storeService.getPage(request);
		System.out.println(JSON.toJSONString(page));
	}
	
	@Test
	public void edit() {
		CpStore cpStore  = new CpStore();
		cpStore.setId(1);
		cpStore.setCountry("US");
		cpStore.setName("JUST 4 TEST");
		storeService.edit(cpStore);	
	}
}
