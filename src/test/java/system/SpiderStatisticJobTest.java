package system;

import com.gopher.system.worker.SpiderStatisticJob;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class SpiderStatisticJobTest extends BaseTest{
    @Autowired
    private SpiderStatisticJob spiderStatisticJob;
    @Test
    public void test(){

        spiderStatisticJob.statisticBySpider();

    }
}
