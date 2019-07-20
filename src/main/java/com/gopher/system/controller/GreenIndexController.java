package com.gopher.system.controller;

import com.gopher.system.constant.SiteEnum;
import com.gopher.system.model.entity.CpSitestoreType;
import com.gopher.system.model.vo.CpCouponVo;
import com.gopher.system.model.vo.request.*;
import com.gopher.system.model.vo.response.StoreDetailResponse;
import com.gopher.system.service.OfficialWebsiteService;
import com.gopher.system.service.ShowSiteTypeService;
import com.gopher.system.service.WebSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 1500
 * @Date 2019/7/8.
 */
@Controller
@RequestMapping("/green")
public class GreenIndexController {

    @Autowired
    private OfficialWebsiteService officialWebsiteService;

    @Autowired
    private ShowSiteTypeService showSiteTypeService;


    @Autowired
    private WebSiteService webSiteService;


    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        CpSitestoreRequest cpSitestoreRequest = new CpSitestoreRequest();
        cpSitestoreRequest.setSiteId(SiteEnum.GREEN.getId());
        modelAndView.addObject("topStoreList", officialWebsiteService.getTopStoreList(cpSitestoreRequest));
        modelAndView.addObject("categoryList", showSiteTypeService.getList(SiteEnum.GREEN.getId(), 1));
        modelAndView.addObject("popularStoreList", showSiteTypeService.getList(SiteEnum.GREEN.getId(), 2));
        CouponPageRequest couponPageRequest = new CouponPageRequest();
        couponPageRequest.setOutSiteId(SiteEnum.GREEN.getId());
        modelAndView.addObject("topCouponList", officialWebsiteService.getTopCouponList(couponPageRequest));
        modelAndView.setViewName("/green/index");
        return modelAndView;
    }

    @RequestMapping("/aboutUs")
    public ModelAndView aboutUs() {
        return new ModelAndView("/green/about");
    }

    @RequestMapping("/contactUs")
    public ModelAndView contactUs() {
        return new ModelAndView("/green/contact");
    }

    @RequestMapping("/stores")
    public ModelAndView storeList(StorePageRequst storePageRequst) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("stores", officialWebsiteService.getStorePageList(storePageRequst));
        modelAndView.setViewName("/green/store");
        return modelAndView;
    }

    @RequestMapping("/storeDetail")
    public ModelAndView storeDetail(StoreRequest storeRequest) {
        ModelAndView modelAndView = new ModelAndView();
        CpSitestoreRequest cpSitestoreRequest = new CpSitestoreRequest();
        cpSitestoreRequest.setSiteId(storeRequest.getSiteId());
        modelAndView.addObject("topStoreList", officialWebsiteService.getTopStoreList(cpSitestoreRequest));
        StoreDetailResponse storeDetail = webSiteService.getStoreDetail(storeRequest);
        if (storeRequest.getC() != null && !CollectionUtils.isEmpty(storeDetail.getCouponList().getList())) {
            for (CpCouponVo cpCouponVo : storeDetail.getCouponList().getList()) {
                if (storeRequest.getC().equals(cpCouponVo.getId())) {
                    modelAndView.addObject("coupon", cpCouponVo);
                    break;
                }
            }
        }
        modelAndView.addObject("storeDetail", storeDetail);
        StoreRequest visitStoreRequest = new StoreRequest();
        visitStoreRequest.setId(storeDetail.getId());
        webSiteService.updateStoreVisitCount(visitStoreRequest);
        modelAndView.setViewName("/green/storeDetail");
        return modelAndView;
    }

    @RequestMapping("/categories")
    public ModelAndView categories(CpSitestoreRequest cpSitestoreRequest) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("categories", showSiteTypeService.getList(SiteEnum.GREEN.getId(), 1));
        modelAndView.setViewName("/green/category");
        return modelAndView;
    }

    @RequestMapping("/topCoupons")
    public ModelAndView topCoupons() {
        ModelAndView modelAndView = new ModelAndView();
        CouponPageRequest couponPageRequest = new CouponPageRequest();
        couponPageRequest.setOutSiteId(SiteEnum.GREEN.getId());
        modelAndView.addObject("topCouponList", officialWebsiteService.getTopCouponList(couponPageRequest));
        modelAndView.setViewName("/green/topCoupon");
        return modelAndView;
    }


    @RequestMapping("/categoryDetail")
    public ModelAndView categoryDetail(CategoryDetailJspRequest categoryRequest) {
        ModelAndView modelAndView = new ModelAndView();
        CpSitestoreRequest cpSitestoreRequest = new CpSitestoreRequest();
        cpSitestoreRequest.setSiteId(categoryRequest.getSiteId());
        modelAndView.addObject("topStoreList", officialWebsiteService.getTopStoreList(cpSitestoreRequest));
        modelAndView.addObject("coupons", webSiteService.getCouponListByCategory(categoryRequest));
        CpSitestoreType category = showSiteTypeService.getById(categoryRequest.getId());
        modelAndView.addObject("currentCategory", category);
        if (categoryRequest.getpId() != null) {
            modelAndView.addObject("children", showSiteTypeService.getSonList(categoryRequest.getpId()));
            modelAndView.addObject("pCategory", showSiteTypeService.getById(categoryRequest.getpId()));
        } else {
            modelAndView.addObject("children", showSiteTypeService.getSonList(categoryRequest.getId()));
            modelAndView.addObject("pCategory", category);
        }


        modelAndView.setViewName("/green/categoryDetail");
        return modelAndView;
    }


}
