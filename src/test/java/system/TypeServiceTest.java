package system;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.gopher.system.model.entity.CpType;
import com.gopher.system.service.TypeService;

public class TypeServiceTest extends BaseTest{
	@Autowired
	private TypeService type;
	@Test
	public void create() {
		CpType cpType = new CpType();
		cpType.setName("TEST");
		type.create(cpType);
	}
	@Test
	public void getList() {
		System.out.println(JSON.toJSONString(type.getList()));
	}

}
