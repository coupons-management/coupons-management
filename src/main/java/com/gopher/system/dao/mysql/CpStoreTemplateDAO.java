package com.gopher.system.dao.mysql;

import com.gopher.system.model.entity.CpStoreTemplate;
import org.springframework.stereotype.Repository;

/**
 * CpStoreTemplateDAO继承基类
 */
@Repository
public interface CpStoreTemplateDAO extends MyBatisBaseDao<CpStoreTemplate, Integer> {
}