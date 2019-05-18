package system;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.gopher.system.model.entity.CpSitestoreType;
import com.gopher.system.service.ShowSiteTypeService;

public class ShowSiteTypeServiceTest extends BaseTest{
	@Autowired
	private ShowSiteTypeService showSiteTypeService;
	@Test
	public void create() {
		CpSitestoreType cpSitestoreType = new CpSitestoreType();
		cpSitestoreType.setName("TEST2_1");
		cpSitestoreType.setLevel(2);
		cpSitestoreType.setOutSiteId(1);
		cpSitestoreType.setPid(1);
		showSiteTypeService.create(cpSitestoreType);
	}
	@Test
	public void getTree() {
		System.out.println(JSON.toJSONString(showSiteTypeService.getTree(1)));
	}

}
