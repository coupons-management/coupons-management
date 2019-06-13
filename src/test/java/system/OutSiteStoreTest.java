package system;

import com.gopher.system.dao.mysql.CpOutSiteStoreDAO;
import com.gopher.system.model.entity.CpOutSiteStore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class OutSiteStoreTest extends BaseTest {
    @Autowired
    private CpOutSiteStoreDAO cpOutSiteStoreDAO;
    @Test
    public void test(){
        CpOutSiteStore store = cpOutSiteStoreDAO.selectByPrimaryKey(72);
        store.setVisitCount(store.getVisitCount() + 1);
        cpOutSiteStoreDAO.updateByPrimaryKeySelective(store);
    }
}
