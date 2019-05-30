package system;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.gopher.system.dao.mysql.DefendStoreDAO;
import com.gopher.system.model.vo.request.DefendStorePageRequest;
import com.gopher.system.service.DefendStoreService;

public class DefendStoreServiceTest extends BaseTest{
	@Autowired
	private DefendStoreService defendStoreService;
	@Autowired
	private DefendStoreDAO defendStoreDAO;
	@Test
	public void test() {
		DefendStorePageRequest defendStorePageRequst = new DefendStorePageRequest();
		defendStorePageRequst.setSpiderSiteId(738);
		defendStorePageRequst.setBeginDate(new Date(System.currentTimeMillis() - 10* 24*60*60*1000));
		defendStorePageRequst.setEndDate(new Date());
		defendStorePageRequst.setStoreType(3);
		System.out.println(JSON.toJSONString(defendStoreService.getStorePage(defendStorePageRequst)));
	}
	@Test
	public void test2() {
		DefendStorePageRequest defendStorePageRequst = new DefendStorePageRequest();
		defendStorePageRequst.setSpiderSiteId(738);
		defendStoreDAO.getStorePageList(defendStorePageRequst);
	}

}
