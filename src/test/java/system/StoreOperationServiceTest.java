package system;


import com.alibaba.fastjson.JSON;
import com.gopher.system.dao.mysql.StoreOperationDAO;
import com.gopher.system.model.vo.request.StorePageRequst;
import com.gopher.system.service.StoreOperationService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class StoreOperationServiceTest extends BaseTest {
    @Autowired
    private StoreOperationService storeOperationService;
    @Autowired
    private StoreOperationDAO storeOperationDAO;
    @Test
    public void test(){
        StorePageRequst storePageRequst = new StorePageRequst();
        storePageRequst.setBeginTime(System.currentTimeMillis()-2*24*60*60*1000);
        storePageRequst.setEndTime(System.currentTimeMillis());
        storePageRequst.setRange(1);
        System.out.println(JSON.toJSONString(storePageRequst));
        System.out.println(JSON.toJSONString( storeOperationService.getPage(storePageRequst)));
    }
    @Test
    public void test2(){
        StorePageRequst storePageRequst = new StorePageRequst();
        storePageRequst.setBeginDate(new Date(System.currentTimeMillis()-6*24*60*60*1000));
        storePageRequst.setEndDate(new Date());
        storePageRequst.setRange(1);
        System.out.println(JSON.toJSONString(storeOperationDAO.getPageList(storePageRequst)));
    }

    @Test
    public void test3(){
        StorePageRequst storePageRequst = new StorePageRequst();
        storePageRequst.setBeginDate(new Date(System.currentTimeMillis()-6*24*60*60*1000));
        storePageRequst.setEndDate(new Date());
        storePageRequst.setRange(3);
        System.out.println(storeOperationDAO.getCount(storePageRequst));
    }
}
