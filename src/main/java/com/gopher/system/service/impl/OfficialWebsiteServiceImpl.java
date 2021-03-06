package com.gopher.system.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.gopher.system.dao.mysql.CpOutSiteCouponDAO;
import com.gopher.system.model.vo.CpSearchStoreVo;
import com.gopher.system.model.vo.request.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gopher.system.dao.mysql.CpCouponDAO;
import com.gopher.system.dao.mysql.CpStoreDAO;
import com.gopher.system.dao.mysql.CpTypeDAO;
import com.gopher.system.model.entity.CpType;
import com.gopher.system.model.vo.CpCouponVo;
import com.gopher.system.model.vo.CpStoreVo;
import com.gopher.system.model.vo.Page;
import com.gopher.system.service.OfficialWebsiteService;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

@Service
public class OfficialWebsiteServiceImpl implements OfficialWebsiteService {
    @Autowired
    private CpTypeDAO cpTypeDAO;
    @Autowired
    private CpStoreDAO cpStoreDAO;
    @Autowired
    private CpCouponDAO cpCouponDAO;
    @Autowired
    private CpOutSiteCouponDAO cpOutSiteCouponDAO;


    @Override
    public List<CpType> getCategoriesList() {
        return cpTypeDAO.getList();
    }

    @Override
    public Page<CpCouponVo> getCouponPageList(CouponPageRequest quest) {

        Page<CpCouponVo> result = new Page<>();
        result.setPageNumber(quest.getPageNumber());
        result.setPageSize(quest.getPageSize());
        List<CpCouponVo> list = cpCouponDAO.getOffWebCouponPageList(quest);
        final int count = cpCouponDAO.getOffWebTotalCount(quest);

        result.setList(list);
        result.setTotalCount(count);
        return result;
    }

    @Override
    public Page<CpType> getCategoriesPageList(CpTypePageRequest quest) {
        Page<CpType> result = new Page<>();
        result.setPageNumber(quest.getPageNumber());
        result.setPageSize(quest.getPageSize());
        List<CpType> list = cpTypeDAO.getCategoriesPageList(quest);
        final int count = cpTypeDAO.getTotalCount(quest);
        result.setList(list);
        result.setTotalCount(count);
        return result;
    }

    @Override
    public Page<CpStoreVo> getStorePageList(StorePageRequst quest) {
        Page<CpStoreVo> result = new Page<>();
        result.setPageNumber(quest.getPageNumber());
        result.setPageSize(quest.getPageSize());
        List<CpStoreVo> list = cpStoreDAO.getOffWebStorePageList(quest);
        if (null != list) {
            list.forEach(e -> {
                final String showName = e.getShowName();
                final String title = e.getTitle();
                if (StringUtils.hasText(showName)) {
                    e.setShowName(showName.replace("{{store_name}}", e.getName()));
                } else {
                    e.setShowName(e.getName());
                }

                if (StringUtils.hasText(title)) {
                    //TODO
                }
            });
        }
        final int count = cpStoreDAO.getOffWebTotalCount(quest);
        result.setList(list);
        result.setTotalCount(count);
        return result;
    }

    @Override
    public List<CpType> getAllCategoriesList() {
        return cpTypeDAO.getList();
    }

    @Override
    public List<CpStoreVo> getTopStoreList(CpSitestoreRequest quest) {
        return cpStoreDAO.getTopStoreList(quest);
    }

    @Override
    public List<CpCouponVo> getTopCouponList(CouponPageRequest quest) {
        return cpCouponDAO.getTopCouponList(quest);
    }

    @Override
    public List<CpCouponVo> getStoreExpCouponList(CouponPageRequest quest) {
        return cpCouponDAO.getStoreExpCouponList(quest);
    }

    @Override
    public List<CpCouponVo> getStoreCouponList(CouponPageRequest quest) {
        return cpCouponDAO.getStoreCouponList(quest);
    }

    @Override
    public List<CpCouponVo> getStoreCategoryCouponList(CouponPageRequest quest) {
        return cpCouponDAO.getStoreCategoryCouponList(quest);

    }

    @Override
    public Page<CpSearchStoreVo> searchStorePageList(StorePageRequst quest) {
        Page<CpSearchStoreVo> cpSearchStoreVoPage = new Page<>();
        Page<CpStoreVo> storePageList = this.getStorePageList(quest);
        cpSearchStoreVoPage.setPageSize(storePageList.getPageSize());
        cpSearchStoreVoPage.setPageNumber(storePageList.getPageNumber());
        cpSearchStoreVoPage.setTotalCount(storePageList.getTotalCount());
        if(!CollectionUtils.isEmpty(storePageList.getList())){
            List<CpSearchStoreVo> collect = storePageList.getList().stream().map(p -> {
                CpSearchStoreVo cpSearchStoreVo = new CpSearchStoreVo();
                BeanUtils.copyProperties(p, cpSearchStoreVo);
                List<Integer> list = new ArrayList<>(1);
                list.add(p.getStoreId());
                ShowSiteCouponPageRequest showSiteCouponPageRequest = new ShowSiteCouponPageRequest();
                showSiteCouponPageRequest.setSiteId(quest.getSiteId());
                showSiteCouponPageRequest.setStoreIdList(list);
                cpSearchStoreVo.setCouponCount(cpOutSiteCouponDAO.getCountByCategory(showSiteCouponPageRequest));
                return cpSearchStoreVo;
            }).collect(Collectors.toList());
            cpSearchStoreVoPage.setList(collect);
        }
        return cpSearchStoreVoPage;
    }
}
