package com.gopher.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gopher.system.dao.mysql.CpOutSiteDAO;
import com.gopher.system.model.entity.CpOutSite;
import com.gopher.system.service.ShowSiteService;
/**
 * 展示站点接口(内站)
 * @author dongyangyang
 *
 */
@Service
public class ShowSiteServiceImpl implements ShowSiteService{
    @Autowired
    private CpOutSiteDAO cpOutSiteDAO;
	@Override
	public List<CpOutSite> getSiteList() {
		return cpOutSiteDAO.getList();
	}

}
