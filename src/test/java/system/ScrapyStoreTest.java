package system;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.gopher.system.model.vo.request.StoreAllPageRequst;
import com.gopher.system.service.ScrapyStoreService;

public class ScrapyStoreTest  extends BaseTest{
	@Autowired
	private ScrapyStoreService scrapyStoreService;
	@Test
	public void getList() {
		StoreAllPageRequst m=new StoreAllPageRequst();
		System.out.println(JSON.toJSONString(scrapyStoreService.getScrapyPageList(m)));
	}
}
