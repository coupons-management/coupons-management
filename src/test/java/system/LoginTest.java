package system;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.gopher.system.model.User;
import com.gopher.system.model.vo.request.LoginRequest;
import com.gopher.system.service.CacheService;
import com.gopher.system.service.LoginService;

public class LoginTest extends BaseTest{
	@Autowired
	private LoginService loginService;
	@Autowired
	private CacheService<String,User> cacheService;
	@Test
	public void login() {
		LoginRequest loginRequest = new LoginRequest();
		loginRequest.setAccount("TEST");
		loginRequest.setPassword("test");
		loginService.login(loginRequest);
	}
	@Test
    public void get() {
    	Object user = cacheService.get("TEST");
    	System.out.println(JSON.toJSONString(user));
    }
	@Test
    public void set() {
    	User user = new User();
    	user.setAccount("123");
    	user.setPassword("123");
    	cacheService.set("TEST", user,60);
    }
	@Test
    public void del() {
    	cacheService.delete("TEST");
    }
}
