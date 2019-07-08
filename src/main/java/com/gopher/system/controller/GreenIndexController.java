package com.gopher.system.controller;

import com.gopher.system.constant.SiteEnum;
import com.gopher.system.model.vo.request.CouponPageRequest;
import com.gopher.system.model.vo.request.CpSitestoreRequest;
import com.gopher.system.service.OfficialWebsiteService;
import com.gopher.system.service.ShowSiteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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


    @RequestMapping("/")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        CpSitestoreRequest cpSitestoreRequest = new CpSitestoreRequest();
        cpSitestoreRequest.setSiteId(SiteEnum.GREEN.getId());
        modelAndView.addObject("topStoreList",officialWebsiteService.getTopStoreList(cpSitestoreRequest));
        modelAndView.addObject("categoryList",showSiteTypeService.getList(0, 1));
        modelAndView.addObject("popularStoreList",showSiteTypeService.getList(0, 2));
        CouponPageRequest couponPageRequest = new CouponPageRequest();
        couponPageRequest.setOutSiteId(SiteEnum.GREEN.getId());
        modelAndView.addObject("topCouponList",officialWebsiteService.getTopCouponList(couponPageRequest));
        modelAndView.setViewName("/green/index");
        return modelAndView;
    }

}
