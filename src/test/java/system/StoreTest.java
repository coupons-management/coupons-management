package system;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.gopher.system.model.vo.request.StoreRequest;
import com.gopher.system.service.StoreService;

public class StoreTest extends BaseTest{
	@Autowired
    private StoreService storeService;
	
	@Test
	public void getPage() {
		StoreRequest storeRequest = new StoreRequest();
		System.out.println(JSON.toJSONString(storeService.getPage(storeRequest)));
	}
}
