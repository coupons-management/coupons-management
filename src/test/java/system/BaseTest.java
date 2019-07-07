package system;

import java.util.Date;
import java.util.List;

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
}
