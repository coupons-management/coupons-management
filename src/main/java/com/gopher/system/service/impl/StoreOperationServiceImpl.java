package com.gopher.system.service.impl;

import com.gopher.system.dao.mysql.CpOutSiteCouponDAO;
import com.gopher.system.dao.mysql.CpSitestoreTypeDAO;
import com.gopher.system.dao.mysql.CpTypeStoreDAO;
import com.gopher.system.dao.mysql.StoreOperationDAO;
import com.gopher.system.exception.BusinessRuntimeException;
import com.gopher.system.model.entity.CpSitestoreType;
import com.gopher.system.model.entity.CpStore;
import com.gopher.system.model.entity.CpTypeStore;
import com.gopher.system.model.vo.Page;
import com.gopher.system.model.vo.request.ShowSiteCouponPageRequest;
import com.gopher.system.model.vo.request.StorePageRequst;
import com.gopher.system.model.vo.response.StoreResponse;
import com.gopher.system.service.StoreOperationService;
import com.gopher.system.service.StoreService;
import com.gopher.system.util.DateUtils;
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

    @Override
    public Page<StoreResponse> getPageInSpider(StorePageRequst storePageRequest) {

        Page<StoreResponse> result = new Page<>();
        this.setParam(storePageRequest);
        List<CpStore> list = storeOperationDAO.getPageList(storePageRequest);
        result.setTotalCount(storeOperationDAO.getCount(storePageRequest));
        result.setList(storeService.getShowValue(list, true));
        result.setPageNumber(storePageRequest.getPageNumber());
        result.setPageSize(storePageRequest.getPageSize());
        return result;
    }

    private void setParam(StorePageRequst storePageRequest){
        if (null == storePageRequest) {
            throw new BusinessRuntimeException("参数不能为空");
        }
        storePageRequest.setBeginDate(DateUtils.getOneDayStartDate(storePageRequest.getBeginTime()));
        storePageRequest.setEndDate(DateUtils.getOneDayEndDate(storePageRequest.getEndTime()));
        storePageRequest.setScrapyId(storePageRequest.getSpiderId());
    }

    @Autowired
    private CpTypeStoreDAO cpTypeStoreDAO;
    @Autowired
    private CpSitestoreTypeDAO cpSitestoreTypeDAO;
    @Autowired
    private CpOutSiteCouponDAO cpOutSiteCouponDAO;

    @Override
    public Page<StoreResponse> getPageInSite(StorePageRequst storePageRequest) {
        final Integer siteId = storePageRequest.getSiteId();
        if(null == siteId  || siteId <= 0){
            throw new BusinessRuntimeException("站点ID不能为空");
        }
        Page<StoreResponse> result = new Page<>();
        this.setParam(storePageRequest);
        List<CpStore> list = storeOperationDAO.getPageListInSite(storePageRequest);
        result.setTotalCount(storeOperationDAO.getCountInSite(storePageRequest));
        result.setList(storeService.getShowValue(list, false));
        List<StoreResponse> li = result.getList();
        if(li != null && !li.isEmpty()) {
            li.forEach(vo -> {
                vo.setScrapyType("");
                CpTypeStore type = cpTypeStoreDAO.getByStore(vo.getStoreId(), siteId);
                if(null != type){
                    CpSitestoreType cpSitestoreType = cpSitestoreTypeDAO.selectByPrimaryKey(type.getTypeId());
                    if(null != cpSitestoreType){
                        vo.setScrapyType(cpSitestoreType.getName());
                    }
                }
                ShowSiteCouponPageRequest showSiteCouponPageRequest = new ShowSiteCouponPageRequest();
                showSiteCouponPageRequest.setStoreId(vo.getStoreId());
                showSiteCouponPageRequest.setSiteId(siteId);
                final int totalCount = cpOutSiteCouponDAO.getTotalCount(showSiteCouponPageRequest);
                showSiteCouponPageRequest.setExpiryDate(new Date(storePageRequest.getEndTime()));
                final int validCount = cpOutSiteCouponDAO.getTotalCount(showSiteCouponPageRequest);
                vo.setValidCouponsCount(validCount+"/"+totalCount);
            });
        }
        result.setPageNumber(storePageRequest.getPageNumber());
        result.setPageSize(storePageRequest.getPageSize());
        return result;
    }

}
