package com.gopher.system.controller;

import com.gopher.system.constant.SiteEnum;
import com.gopher.system.model.vo.request.*;
import com.gopher.system.model.vo.response.StoreDetailResponse;
import com.gopher.system.service.OfficialWebsiteService;
import com.gopher.system.service.ShowSiteTypeService;
import com.gopher.system.service.WebSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 1500
 * @Date 2019/7/15.
 */
@Controller
@RequestMapping("/yellow")
public class YellowIndexController {

    @Autowired
    private OfficialWebsiteService officialWebsiteService;

    @Autowired
    private ShowSiteTypeService showSiteTypeService;


    @Autowired
    private WebSiteService webSiteService;


    @RequestMapping("/")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        CpSitestoreRequest cpSitestoreRequest = new CpSitestoreRequest();
        cpSitestoreRequest.setSiteId(SiteEnum.YELLOW.getId());
        modelAndView.addObject("topStoreList",officialWebsiteService.getTopStoreList(cpSitestoreRequest));
        modelAndView.addObject("categoryList",showSiteTypeService.getList(SiteEnum.GREEN.getId(), 1));
        CouponPageRequest couponPageRequest = new CouponPageRequest();
        couponPageRequest.setOutSiteId(SiteEnum.YELLOW.getId());
        modelAndView.addObject("topCouponList",officialWebsiteService.getTopCouponList(couponPageRequest));
        modelAndView.setViewName("/yellow/index");
        return modelAndView;
    }

    @RequestMapping("/aboutUs")
    public ModelAndView aboutUs(){
        return new ModelAndView("/yellow/about");
    }

    @RequestMapping("/contactUs")
    public ModelAndView contactUs(){
        return new ModelAndView("/yellow/contact");
    }

    @RequestMapping("/stores")
    public ModelAndView storeList(StorePageRequst storePageRequst){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("stores",officialWebsiteService.getStorePageList(storePageRequst));
        modelAndView.setViewName("/green/store");
        return modelAndView;
    }
    @RequestMapping("/storeDetail")
    public ModelAndView storeDetail(StoreRequest storeRequest){
        ModelAndView modelAndView = new ModelAndView();
        CpSitestoreRequest cpSitestoreRequest = new CpSitestoreRequest();
        cpSitestoreRequest.setSiteId(storeRequest.getSiteId());
        modelAndView.addObject("topStoreList",officialWebsiteService.getTopStoreList(cpSitestoreRequest));
        StoreDetailResponse storeDetail = webSiteService.getStoreDetail(storeRequest);
        modelAndView.addObject("storeDetail",storeDetail);
        StoreRequest visitStoreRequest = new StoreRequest();
        visitStoreRequest.setId(storeDetail.getId());
        webSiteService.updateStoreVisitCount(visitStoreRequest);
        modelAndView.setViewName("/green/storeDetail");
        return modelAndView;
    }

    @RequestMapping("/category")
    public ModelAndView categories(CpSitestoreRequest cpSitestoreRequest){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("categories",showSiteTypeService.getList(cpSitestoreRequest.getSiteId(), 1));
        modelAndView.setViewName("/green/category");
        return modelAndView;
    }


    @RequestMapping("/categoryDetail")
    public ModelAndView categoryDetail(CategoryRequest categoryRequest){
        ModelAndView modelAndView = new ModelAndView();
        CpSitestoreRequest cpSitestoreRequest = new CpSitestoreRequest();
        cpSitestoreRequest.setSiteId(categoryRequest.getSiteId());
        modelAndView.addObject("topStoreList",officialWebsiteService.getTopStoreList(cpSitestoreRequest));
        modelAndView.addObject("coupons",webSiteService.getCouponListByCategory(categoryRequest));
        modelAndView.addObject("children",showSiteTypeService.getSonList(categoryRequest.getId()));
        modelAndView.setViewName("/green/categoryDetail");
        return modelAndView;
    }



}
