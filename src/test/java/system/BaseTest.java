package system;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.gopher.system.dao.mysql.CpOutSiteStoreDAO;
import com.gopher.system.service.MessageDataService;
import com.gopher.system.util.SpiderStatusJson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.gopher.system.dao.mysql.UserDAO;
import com.gopher.system.model.entity.User;
import com.gopher.system.model.vo.request.UserPageRequst;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:applicationContext.xml"
 })
@WebAppConfiguration
public class BaseTest {
	@Autowired
	private UserDAO userDAO;

	@Autowired
	private CpOutSiteStoreDAO cpOutSiteStoreDAO;
	@Autowired
	private MessageDataService messageDataService;
	@Test
	public void getUserPage() {
		UserPageRequst userPageRequst = new UserPageRequst();
		List<User> userList = userDAO.selectPage(userPageRequst);
		if(null != userList) {
			System.out.println(JSON.toJSONString(userList));
		}
	}
	@Test
	public void addUser() {
		User user = new User();
		user.setAccount("TEST");
		user.setAge(1);
		user.setCreateTime(new Date());
		userDAO.insert(user);
	}
	@Test
	public void test(){
		System.out.println(JSON.toJSONString(	cpOutSiteStoreDAO.getListByStore(82890)));
	}

	@Test
	public void test2(){
		SpiderStatusJson query = new SpiderStatusJson();
		query.setEndTime(new Timestamp(System.currentTimeMillis()));
		query.setStatus("0");
		query.setSpider("couponpaone");
		messageDataService.updateCouponIndex(JSON.toJSONString(query));
	}
}
