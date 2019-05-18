package system;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.gopher.system.model.vo.KV;
import com.gopher.system.service.CommonService;

public class CommonsServiceTest extends BaseTest{
	@Autowired
	private CommonService commonService;
	@Test
	public void getSpiderList() {
		List<KV<Integer,String>> list = commonService.getSpiderList();
		System.out.println(JSON.toJSONString(list));
	}

}
