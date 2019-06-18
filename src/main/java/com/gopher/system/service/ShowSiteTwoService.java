package com.gopher.system.service;

import com.gopher.system.model.entity.CpCoupon;
import com.gopher.system.model.entity.CpOutSite;
import com.gopher.system.model.entity.CpOutSiteStore;
import com.gopher.system.model.entity.CpSitestoreType;
import com.gopher.system.model.vo.CpOutSiteStoreVo;
import com.gopher.system.model.vo.Page;
import com.gopher.system.model.vo.request.CpSitestoreRequest;
import com.gopher.system.model.vo.request.ShowSiteStoreRequest;
import com.gopher.system.model.vo.response.OutSiteStoreRsp;

import java.util.List;

public interface ShowSiteTwoService {

    /**
     * 查站点2中商家与站点关系
     *
     * @param siteStore
     * @return
     */


    Page<CpOutSiteStoreVo> getTwoList(ShowSiteStoreRequest siteStore);

    /**
     * 修改外站商家关系
     *
     * @param cpOutSiteStore
     */
    void updateOutSiteStore(OutSiteStoreRsp cpOutSiteStore);


    /**
     * 删除外站商家关系
     *
     * @param cpOutSiteStore
     */
    void deleteOutSiteStore(CpOutSiteStore cpOutSiteStore);

    /**
     * 查看优惠卷
     *
     * @return
     */
    Page<CpCoupon> getCouponList(ShowSiteStoreRequest request);

    /**
     * 查看新增的优惠卷
     *
     * @return
     */
    Page<CpCoupon> getNewCouponList(ShowSiteStoreRequest request);

    /**
     * 商家分类
     *
     * @param request
     * @return
     */
    List<CpSitestoreType> getStoreSort(CpSitestoreRequest request);

    /**
     * 根据ID取出站点商家数据
     *
     * @param request
     * @return
     */
    OutSiteStoreRsp getSiteStroreById(CpOutSiteStore request);

    /**
     * 增加优惠卷
     *
     * @param bean
     * @return
     */
    void addCoupon(CpCoupon bean);


    List<CpOutSite> getSiteList();

}
