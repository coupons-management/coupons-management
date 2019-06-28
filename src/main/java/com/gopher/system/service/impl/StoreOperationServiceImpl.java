package com.gopher.system.service.impl;

import com.gopher.system.dao.mysql.StoreOperationDAO;
import com.gopher.system.exception.BusinessRuntimeException;
import com.gopher.system.model.entity.CpStore;
import com.gopher.system.model.vo.Page;
import com.gopher.system.model.vo.request.StorePageRequst;
import com.gopher.system.model.vo.response.StoreResponse;
import com.gopher.system.service.StoreOperationService;
import com.gopher.system.service.StoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StoreOperationServiceImpl implements StoreOperationService {
    @Autowired
    private StoreOperationDAO storeOperationDAO;
    @Autowired
    private StoreService storeService;
    @Autowired
    private static final Logger LOG = LoggerFactory.getLogger(StoreOperationServiceImpl.class);

    @Override
    public Page<StoreResponse> getPage(StorePageRequst storePageRequest) {
        if (null == storePageRequest) {
            throw new BusinessRuntimeException("参数不能为空");
        }
        Page<StoreResponse> result = new Page<>();
        storePageRequest.setBeginDate(new Date(storePageRequest.getBeginTime()));
        storePageRequest.setEndDate(new Date(storePageRequest.getEndTime()));
        List<CpStore> list = storeOperationDAO.getPageList(storePageRequest);
        result.setTotalCount(storeOperationDAO.getCount(storePageRequest));
        result.setList(storeService.getShowValue(list));
        result.setPageNumber(storePageRequest.getPageNumber());
        result.setPageSize(storePageRequest.getPageSize());
        return result;
    }
}
