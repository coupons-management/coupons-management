package com.gopher.system.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gopher.system.constant.SystemConstants;
import com.gopher.system.dao.mysql.CpTypeDAO;
import com.gopher.system.exception.BusinessRuntimeException;
import com.gopher.system.model.entity.CpType;
import com.gopher.system.model.vo.response.TypeResponse;
import com.gopher.system.service.TypeService;
/**
 * 
 * @author dongyangyang
 *
 */
@Service
public class TypeServiceImpl implements TypeService{
	@Autowired
	private CpTypeDAO cpTypeDAO;

	@Override
	public TypeResponse getList() {
		TypeResponse result = new TypeResponse();
		List<CpType> list = cpTypeDAO.getList();
		if(null != list) {
			for (CpType cpType : list) {
				if(Objects.equals(cpType.getInType(), SystemConstants.IN_TEYE_MANUAL.getValue().toString())) {
					result.getManualList().add(cpType);
				}else if(Objects.equals(cpType.getInType(), SystemConstants.IN_TEYE_SPIDER.getValue().toString())) {
					result.getSpiderList().add(cpType);
				}
			}
		}
		return result;
	}

	@Override
	public void create(CpType cpType) {
		if(null == cpType) {
			throw new BusinessRuntimeException("参数不能为空");
		}
		// 通过名称检验是否存在同名的分类,如果存在不允许添加
		final String name = cpType.getName();
		CpType DB_OBJ = cpTypeDAO.getBeanByName(name);
		if(null != DB_OBJ) {
			throw new BusinessRuntimeException("分类已存在,请检查后重新填写");
		}
		final Date now = new Date();
		cpType.setCreateTime(now);
		cpType.setUpdateTime(now);
		cpType.setInType(SystemConstants.IN_TEYE_MANUAL.getValue().toString());
		cpTypeDAO.insert(cpType);
	}

	@Override
	public void delete(int id) {
		if(id <= 0) {
			throw new BusinessRuntimeException("id不能为空");
		}
		cpTypeDAO.deleteByPrimaryKey(id);
	}

	@Override
	public void edit(CpType cpType) {
		if(null == cpType) {
			throw new BusinessRuntimeException("参数不能为空");
		}
		final Integer id  = cpType.getId();
		final String name = cpType.getName();
		if(null == id || id<=0) {
			throw new BusinessRuntimeException("ID不能为空");
		}
		if(!StringUtils.hasText(name)) {
			throw new BusinessRuntimeException("名称不能为空");
		}
		cpTypeDAO.updateByPrimaryKeySelective(cpType);
	}

}
