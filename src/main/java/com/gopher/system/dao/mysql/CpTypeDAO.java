package com.gopher.system.dao.mysql;

import com.gopher.system.model.CpType;
import org.springframework.stereotype.Repository;

/**
 * CpTypeDAO继承基类
 */
@Repository
public interface CpTypeDAO extends MyBatisBaseDao<CpType, String> {
}