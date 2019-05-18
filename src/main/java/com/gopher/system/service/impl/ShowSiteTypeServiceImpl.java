package com.gopher.system.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gopher.system.dao.mysql.CpSitestoreTypeDAO;
import com.gopher.system.exception.BusinessRuntimeException;
import com.gopher.system.model.entity.CpSitestoreType;
import com.gopher.system.model.vo.response.SitestoreTypeTree;
import com.gopher.system.service.ShowSiteTypeService;
@Service
public class ShowSiteTypeServiceImpl implements ShowSiteTypeService{
	@Autowired
    private CpSitestoreTypeDAO cpSitestoreTypeDAO;
	@Override
	public List<CpSitestoreType> getList(int siteId, int level) {
		CpSitestoreType cpSitestoreType = new CpSitestoreType();
		return cpSitestoreTypeDAO.getList(cpSitestoreType);
	}

	@Override
	public void create(CpSitestoreType cpSitestoreType) {
		if(null == cpSitestoreType) {
			throw new BusinessRuntimeException("参数不能为空");
		}
		final Integer outSiteId = cpSitestoreType.getOutSiteId();
		final String name       = cpSitestoreType.getName();
		final Integer level     = cpSitestoreType.getLevel();
		final Integer pid       = cpSitestoreType.getPid();
		
		if(null == outSiteId || outSiteId<=0) {
			throw new BusinessRuntimeException("外站Id不能为空");
		}
		
		if(!StringUtils.hasText(name)) {
			throw new BusinessRuntimeException("名称不能为空");
		}
		
		if(null == level || level <= 0) {
			throw new BusinessRuntimeException("等级不能为空");
		}
		
		if(level>1) {
			if(pid == null || pid<=0) {
				throw new BusinessRuntimeException("父级ID不能为空");
			}
		}
		final Date now = new Date();
		cpSitestoreType.setCreateTime(now);
		cpSitestoreType.setUpdateTime(now);
		cpSitestoreTypeDAO.insert(cpSitestoreType);
		
	}

	@Override
	public void edit(CpSitestoreType cpSitestoreType) {
		if(null == cpSitestoreType) {
			throw new BusinessRuntimeException("参数不能为空");
		}
		final Integer id      = cpSitestoreType.getId();
		final String name     = cpSitestoreType.getName();
		final Integer level   = cpSitestoreType.getLevel();
		final Integer pid     = cpSitestoreType.getPid();
		if(null == id || id<=0) {
			throw new BusinessRuntimeException("无效的ID");
		}
		if(!StringUtils.hasText(name)) {
			throw new BusinessRuntimeException("名称不能为空");
		}
		if(null != level && level>1) {
			if(pid == null || pid<=0) {
				throw new BusinessRuntimeException("父级ID不能为空");
			}
		}
		final Date now = new Date();
		cpSitestoreType.setUpdateTime(now);
		cpSitestoreTypeDAO.updateByPrimaryKeySelective(cpSitestoreType);
	}


	@Override
	public SitestoreTypeTree getTree(final int siteId) {
		SitestoreTypeTree result = new SitestoreTypeTree();
		result.setName("ROOT");
		result.setLevel(0);
		result.setId(0);
		result.setPid(0);
		CpSitestoreType query = new CpSitestoreType();
		query.setOutSiteId(siteId);
		List<CpSitestoreType> list = cpSitestoreTypeDAO.getList(query);
		if(null != list) {
			List<SitestoreTypeTree> level1_all = new ArrayList<>();
			List<SitestoreTypeTree> level2_all = new ArrayList<>();
			for (CpSitestoreType cpSitestoreType : list) {
				if(Objects.equals(cpSitestoreType.getLevel(), 1)) {
					SitestoreTypeTree l1 = new SitestoreTypeTree();
					BeanUtils.copyProperties(cpSitestoreType, l1);
					level1_all.add(l1);
				}else if(Objects.equals(cpSitestoreType.getLevel(), 2)) {
					SitestoreTypeTree l2 = new SitestoreTypeTree();
					BeanUtils.copyProperties(cpSitestoreType, l2);
					level2_all.add(l2);
				}
			}
			result.setChildList(level1_all);
			
            for (SitestoreTypeTree l1 : level1_all) {
            	List<SitestoreTypeTree> level2 =  new ArrayList<>();
				for (SitestoreTypeTree l2 : level2_all) {
					if(Objects.equals(l1.getId(), l2.getPid())) {
						level2.add(l2);
					}
				}
				l1.setChildList(level2);
			}
		}
		return result;
	}

}
