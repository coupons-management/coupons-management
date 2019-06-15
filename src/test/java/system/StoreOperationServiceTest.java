package system;


import com.alibaba.fastjson.JSON;
import com.gopher.system.model.vo.request.StorePageRequst;
import com.gopher.system.service.StoreOperationService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class StoreOperationServiceTest extends BaseTest {
    @Autowired
    private StoreOperationService storeOperationService;
    @Test
    public void test(){
        StorePageRequst storePageRequst = new StorePageRequst();
        storePageRequst.setBeginTime(System.currentTimeMillis()-2*24*60*60*1000);
        storePageRequst.setEndTime(System.currentTimeMillis());
        storePageRequst.setRange(1);
        System.out.println(JSON.toJSONString(storePageRequst));
        System.out.println(JSON.toJSONString( storeOperationService.getPage(storePageRequst)));
    }
}
