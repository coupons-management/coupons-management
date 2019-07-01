package system;

import com.alibaba.fastjson.JSON;
import com.gopher.system.model.vo.request.ShowSiteCouponPageRequest;
import com.gopher.system.model.vo.response.ShowSiteCouponResponse;
import com.gopher.system.service.ShowSiteCouponService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gopher.system.model.vo.request.ShowSiteStoreRequest;
import com.gopher.system.service.ShowSiteService;

import java.util.List;

public class ShowSiteServiceTest extends BaseTest {
    @Autowired
    private ShowSiteService showSiteService;
    @Autowired
    private ShowSiteCouponService showSiteCouponService;

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
}
