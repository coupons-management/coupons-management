package system;

import com.alibaba.fastjson.JSON;
import com.gopher.system.model.vo.request.ShowSiteCouponPageRequest;
import com.gopher.system.model.vo.request.StoreRequest;
import com.gopher.system.model.vo.response.ShowSiteCouponResponse;
import com.gopher.system.service.ShowSiteCouponService;
import com.gopher.system.service.WebSiteService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gopher.system.model.vo.request.ShowSiteStoreRequest;
import com.gopher.system.service.ShowSiteService;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@WebAppConfiguration
public class ShowSiteServiceTest extends BaseTest {
    @Autowired
    private ShowSiteService showSiteService;
    @Autowired
    private ShowSiteCouponService showSiteCouponService;
    @Autowired
    private WebSiteService webSiteService;

    @Test
    public void delete() {
        ShowSiteStoreRequest showSiteStoreRequest = new ShowSiteStoreRequest();
        showSiteStoreRequest.setSiteId(1);
        showSiteStoreRequest.setStoreId(10066);
        showSiteService.deleteStoreInSite(showSiteStoreRequest);
    }

    @Test
    public void test() {
        ShowSiteCouponPageRequest showSiteCouponPageRequest = new ShowSiteCouponPageRequest();
        showSiteCouponPageRequest.setStoreId(27768);
        List<ShowSiteCouponResponse> list = showSiteCouponService.getCouponListWithSort(showSiteCouponPageRequest);
        System.out.println(JSON.toJSONString(list));
    }

    @Test
    public void test2() {
        System.out.println(JSON.toJSONString(showSiteService.getStoreTemplate()));
    }

    @Test
    public void test3(){
        System.out.println( JSON.toJSONString(showSiteService.findPageInfoList(1)));
    }

    @Test
    public void test4(){
        System.out.println( JSON.toJSONString(showSiteService.findOne(1)));
    }

    @Test
    public void getSiteDetail(){
        StoreRequest storeRequest = new StoreRequest();
        storeRequest.setSiteId(1);
        storeRequest.setStoreId(82887);
        System.out.println(JSON.toJSONString(  webSiteService.getStoreDetail(storeRequest)));
    }
}
