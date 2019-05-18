package system;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.gopher.system.constant.SystemConstants;
import com.gopher.system.model.entity.CpStore;
import com.gopher.system.model.vo.request.StorePageRequst;
import com.gopher.system.service.StoreService;

public class StoreTest extends BaseTest{
	@Autowired
    private StoreService storeService;
	
	@Test
	public void getPage() {
		StorePageRequst request = new StorePageRequst();
		request.setCountry("US");
		request.setScrapy(2);
		request.setScrapyType(SystemConstants.SPIDER_TYPE_NOT_REQUIRED.getValue());
		request.setSearch("Cynthia Rowley");
		System.out.println(JSON.toJSONString(storeService.getPage(request)));
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
