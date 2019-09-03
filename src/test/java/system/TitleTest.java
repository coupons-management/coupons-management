package system;

import com.gopher.system.util.TitleUtils;
import org.junit.Test;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
public class TitleTest extends BaseTest {
    @Test
    public void test(){
        System.out.println(TitleUtils.getMessage("Extra 16% Off Sitewide Order Over $69 (Verified)"));
    }
}
