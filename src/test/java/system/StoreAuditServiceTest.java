package system;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gopher.system.dao.mysql.CpOutSiteStoreDAO;

public class StoreAuditServiceTest extends BaseTest{
	@Autowired
	private CpOutSiteStoreDAO cpOutSiteStoreDAO;
	@Test
	public void clearTest() {
		cpOutSiteStoreDAO.clearAdviseSort(1);
		cpOutSiteStoreDAO.clearHotSort(1);
	}
}
