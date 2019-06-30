package system;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.gopher.system.dao.mysql.CpOutSiteStoreDAO;
import com.gopher.system.dao.mysql.CpStoreDAO;
import com.gopher.system.model.entity.CpOutSiteStore;
import com.gopher.system.model.entity.CpStore;
import com.gopher.system.model.vo.Page;
import com.gopher.system.model.vo.request.StorePageRequst;
import com.gopher.system.model.vo.request.StoreVerifyRequest;
import com.gopher.system.model.vo.response.StoreResponse;
import com.gopher.system.service.StoreService;

public class StoreTest extends BaseTest {
	@Autowired
	private StoreService storeService;
	@Autowired
	private CpStoreDAO cpStoreDAO;
	@Autowired
	private CpOutSiteStoreDAO cpOutSiteStoreDAO;
    @Test
	public void get() {
		CpOutSiteStore query = new CpOutSiteStore();
		query.setStoreId(8783);
		List<CpOutSiteStore> showSiteList = cpOutSiteStoreDAO.getList(query);
		System.out.println(JSON.toJSONString(showSiteList));
	}

	@Test
	public void getPage() {
		StorePageRequst request = new StorePageRequst();
		request.setPageNumber(1);
		request.setPageSize(100);
		request.setValidCouponsCount(1);
		Page<StoreResponse> page = storeService.getPage(request);
		System.out.println(JSON.toJSONString(page));
	}

	@Test
	public void getList() {
		StorePageRequst request = new StorePageRequst();
		request.setCountry("US");
		request.setPageNumber(1);
		request.setPageSize(1);
		System.out.println(JSON.toJSONString(cpStoreDAO.getPageList(request)));
	}

	@Test
	public void edit() {
		CpStore cpStore = new CpStore();
		cpStore.setId(1);
		cpStore.setCountry("US");
		cpStore.setName("JUST 4 TEST");
		storeService.edit(cpStore);
	}

	@Test
	public void verify() {
		StoreVerifyRequest storeVerifyRequest = new StoreVerifyRequest();
		List<Integer> invalidList = new ArrayList<>();
		invalidList.add(8783);
		invalidList.add(8784);
		List<Integer> validList = new ArrayList<>();
		validList.add(8785);
		validList.add(8786);
		storeVerifyRequest.setValidList(validList);
		storeVerifyRequest.setInvalidList(invalidList);
		storeService.verifyBatch(storeVerifyRequest);
	}
}
