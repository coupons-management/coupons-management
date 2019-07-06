package com.gopher.system.controller;

import java.util.List;

import com.gopher.system.model.entity.CpOutSite;
import com.gopher.system.model.entity.OutSitePageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gopher.system.controller.model.Result;
import com.gopher.system.model.vo.request.ShowSiteStoreRequest;
import com.gopher.system.service.ShowSiteService;
/**
 * 展示站点接口
 * @author dongyangyang
 *
 */
@RestController
@RequestMapping(path="/showSite")
public class ShowSiteController {
	@Autowired
	private ShowSiteService showSiteService;
	
	@RequestMapping(path="/getList")
	public Result getList() {
		Result result = new Result();
		result.setData(showSiteService.getSiteList());
		return result;
	}
	
	@RequestMapping(path="/addStoreToSiteBatch")
	public Result addSiteStore(@RequestBody List<ShowSiteStoreRequest> showSiteStoreList) {
		Result result = new Result();
		showSiteService.addStoreToSiteBatch(showSiteStoreList);
		return result;
	}

	/**
	 * 获取商家基本模板信息
	 * @param
	 * @return
	 */
	@RequestMapping(path="/getStoreTempalte")
	public Result getStoreTempalte() {
		Result result = new Result();
		result.setData(showSiteService.getStoreTemplate());
		return result;
	}

	@RequestMapping(path="/addStoreToSite")
	public Result addSiteStoreBatch(@RequestBody ShowSiteStoreRequest showSiteStoreRequest) {
		Result result = new Result();
		showSiteService.addStoreToSite(showSiteStoreRequest);
		return result;
	}
	
	@RequestMapping(path="/deleteStoreToSite")
	public Result deleteStoreToSite(@RequestBody ShowSiteStoreRequest showSiteStoreRequest) {
		Result result = new Result();
		showSiteService.deleteStoreInSite(showSiteStoreRequest);
		return result;
	}

	@RequestMapping(path="/saveSiteInfo")
	public Result saveSiteInfo(@RequestBody CpOutSite cpOutSite) {
		Result result = new Result();
		showSiteService.saveSiteInfo(cpOutSite);
		return result;
	}

	@RequestMapping(path="/getSiteInfo")
	public Result getSiteInfo(@RequestBody CpOutSite cpOutSite) {
		Result result = new Result();
		result.setData(showSiteService.findOne(cpOutSite.getId()));
		return result;
	}

	@RequestMapping(path="/savePageInfo")
	public Result saveSitePageInfo(@RequestBody OutSitePageInfo outSitePageInfo) {
		Result result = new Result();
		showSiteService.savePageInfo(outSitePageInfo);
		return result;
	}

	@RequestMapping(path="/getPageInfoList")
	public Result getPageInfoList(@RequestBody CpOutSite cpOutSite) {
		Result result = new Result();
		result.setData(showSiteService.findPageInfoList(cpOutSite.getId()));
		return result;
	}
	

}
