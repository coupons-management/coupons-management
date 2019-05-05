package com.gopher.coupon;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.gopher.coupon.service.SynDataService;
import com.gopher.system.model.TMessageStore;

public class SynData {
  private	SynDataService synDataService;
//1:同步数据
//2：删除已经同步的数据
	ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200,
            TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>(5));
void sysData()
{
	List<TMessageStore>list=new ArrayList<TMessageStore>();
	for(TMessageStore message:list)
	{
		// 好像是tomcat不一致 我是jdk8 tomcat8 我看他服务器环境也是这个 
//		message.executor.execute(new Thread(new Runnable() {
//             @Override
//             public void run() {
//                 
//             
//             }
//         }, "name"));
// 
     }


	}


}
