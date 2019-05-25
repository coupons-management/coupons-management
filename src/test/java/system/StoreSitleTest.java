package system;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gopher.system.model.entity.CpOutSiteStore;
import com.gopher.system.model.entity.CpSiteStore;
import com.gopher.system.service.StoreAuditService;

public class StoreSitleTest extends BaseTest{
	@Autowired
	private StoreAuditService storeAuditService;
	
	@Test
	public void addSite() {
		CpOutSiteStore cpOutSiteStore = new CpOutSiteStore();
		cpOutSiteStore.setOutId(1);
		cpOutSiteStore.setStoreId(1);
		 storeAuditService.addSite(cpOutSiteStore);
       // System.out.println(JSON.toJSONString(rsp));
	}
}
