package com.gopher.system.controller;

import com.gopher.system.constant.SiteEnum;
import com.gopher.system.exception.BusinessRuntimeException;
import com.gopher.system.model.entity.CpOutSite;
import com.gopher.system.model.entity.CpOutSiteStore;
import com.gopher.system.model.entity.CpSitestoreType;
import com.gopher.system.model.entity.CpStore;
import com.gopher.system.model.entity.OutSitePageInfo;
import com.gopher.system.model.vo.CpCouponVo;
import com.gopher.system.model.vo.request.*;
import com.gopher.system.model.vo.response.StoreDetailResponse;
import com.gopher.system.service.OfficialWebsiteService;
import com.gopher.system.service.ShowSiteService;
import com.gopher.system.service.ShowSiteTwoService;
import com.gopher.system.service.ShowSiteTypeService;
import com.gopher.system.service.StoreAuditService;
import com.gopher.system.service.StoreService;
import com.gopher.system.service.WebSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private StoreService storeService;
    
    @Autowired
    private StoreAuditService storeAuditService;
    
    @Autowired
    private ShowSiteTwoService showSiteTwoService;

    @Autowired
    private ShowSiteService showSiteService;

    
    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        CpSitestoreRequest cpSitestoreRequest = new CpSitestoreRequest();
        cpSitestoreRequest.setSiteId(SiteEnum.GREEN.getId());
        modelAndView.addObject("topStoreList", officialWebsiteService.getTopStoreList(cpSitestoreRequest));
        modelAndView.addObject("categoryList", showSiteTypeService.getList(SiteEnum.GREEN.getId(), 1));
        
        CpOutSiteStore cpOutSiteStore = new CpOutSiteStore();
        cpOutSiteStore.setOutId(SiteEnum.GREEN.getId());
        
        modelAndView.addObject("popularStoreList", storeAuditService.getTopAdviseStroreList(cpOutSiteStore));
        
        CouponPageRequest couponPageRequest = new CouponPageRequest();
        couponPageRequest.setOutSiteId(SiteEnum.GREEN.getId());
        modelAndView.addObject("topCouponList", officialWebsiteService.getTopCouponList(couponPageRequest));
        modelAndView.addObject("tdkInfo", showSiteService.findOneByType(SiteEnum.GREEN.getId(), OutSitePageInfo.TYPE_INDEX));//关键词等页面描述信息
        modelAndView.setViewName("/green/index");
        return modelAndView;
    }

    @RequestMapping("/about")
    public ModelAndView aboutUs() {
        ModelAndView modelAndView = new ModelAndView("/green/about");
        modelAndView.addObject("categoryList", showSiteTypeService.getList(SiteEnum.GREEN.getId(), 1));
        CpOutSite outSite = showSiteService.findOne(SiteEnum.GREEN.getId());
        if(outSite == null){
          throw new BusinessRuntimeException("网站信息不存在");
        }
        modelAndView.addObject("content", outSite.getAboutUs());
        modelAndView.addObject("tdkInfo", showSiteService.findOneByType(SiteEnum.GREEN.getId(), OutSitePageInfo.TYPE_ABOUT_US));//关键词等页面描述信息
        return modelAndView;
    }

    @RequestMapping("/contact")
    public ModelAndView contactUs() {
      ModelAndView modelAndView = new ModelAndView("/green/contact");
      modelAndView.addObject("categoryList", showSiteTypeService.getList(SiteEnum.GREEN.getId(), 1));
      CpOutSite outSite = showSiteService.findOne(SiteEnum.GREEN.getId());
      if(outSite == null){
        throw new BusinessRuntimeException("网站信息不存在");
      }
      modelAndView.addObject("content", outSite.getContactUs());
      modelAndView.addObject("tdkInfo", showSiteService.findOneByType(SiteEnum.GREEN.getId(), OutSitePageInfo.TYPE_CONTACT_US));//关键词等页面描述信息
      return modelAndView;
    }

    @RequestMapping("/store")
    public ModelAndView storeList(String word) {
        ModelAndView modelAndView = new ModelAndView();
        StorePageRequst storePageRequst = new StorePageRequst();
        //todo 全部数据？
        storePageRequst.setPageSize(100);
        storePageRequst.setSiteId(SiteEnum.GREEN.getId());
        if (StringUtils.hasText(word) && !"*".equals(word)) {
            storePageRequst.setName(word);
        }
        modelAndView.addObject("stores", officialWebsiteService.getStorePageList(storePageRequst));
        modelAndView.addObject("categoryList", showSiteTypeService.getList(SiteEnum.GREEN.getId(), 1));
        modelAndView.addObject("isStore", true);
        modelAndView.addObject("tdkInfo", showSiteService.findOneByType(SiteEnum.GREEN.getId(), OutSitePageInfo.TYPE_STORE_LIST));//关键词等页面描述信息
        modelAndView.setViewName("/green/store");
        return modelAndView;
    }

    @RequestMapping("/store/{website}")
    public ModelAndView storeDetail(@PathVariable String website, @RequestParam(value = "coupon_type", required = false) String couponType,
                                    Boolean verify, @RequestParam(value = "name__icontains", required = false) String name, Integer c) {
        CpStore store = storeService.findByWebsite(new StoreDetailJspRequest(website, SiteEnum.GREEN.getId()));
        if(store == null){
          throw new BusinessRuntimeException("店铺信息不存在,请确认网址输入正确");
        }
        ModelAndView modelAndView = new ModelAndView();
        CpSitestoreRequest cpSitestoreRequest = new CpSitestoreRequest();
        cpSitestoreRequest.setSiteId(SiteEnum.GREEN.getId());
        modelAndView.addObject("topStoreList", officialWebsiteService.getTopStoreList(cpSitestoreRequest));
        StoreRequest storeRequest = new StoreRequest();
        storeRequest.setSiteId(SiteEnum.GREEN.getId());
        storeRequest.setStoreId(store.getId());
        storeRequest.setPageSize(StoreRequest.COUPON_PAGE_SIZE);

        StoreDetailResponse storeDetail = webSiteService.getStoreDetail(storeRequest);
        Integer codeCnt = 0;//code数量 
        Integer dealCnt = 0;//deal数量
        if (!CollectionUtils.isEmpty(storeDetail.getCouponList().getList())) {
            List<CpCouponVo> couponVoList = new ArrayList<>();
            for (CpCouponVo cpCouponVo : storeDetail.getCouponList().getList()) {
                if (c != null && c.equals(cpCouponVo.getId())) {
                    modelAndView.addObject("coupon", cpCouponVo);
                }
                if (StringUtils.hasText(couponType) && !"all".equals(couponType)) {
                    if (couponType.equals(cpCouponVo.getCouponType())) {
                        couponVoList.add(cpCouponVo);
                    }
                }
                //计数
                if(StringUtils.hasText(cpCouponVo.getCouponType())){
                  if(cpCouponVo.getCouponType().equals("CODE")){
                    codeCnt++;
                  } else {
                    dealCnt++;
                  }
                }
            }
            if(StringUtils.hasText(couponType)&& !"all".equals(couponType)){
                storeDetail.getCouponList().setList(couponVoList);
            }
        }
        modelAndView.addObject("storeDetail", storeDetail);
        modelAndView.addObject("codeCnt", codeCnt);
        modelAndView.addObject("dealCnt", dealCnt);
        modelAndView.addObject("categoryList", showSiteTypeService.getList(SiteEnum.GREEN.getId(), 1));
        StoreRequest visitStoreRequest = new StoreRequest();
        visitStoreRequest.setId(storeDetail.getId());
        webSiteService.updateStoreVisitCount(visitStoreRequest);
        modelAndView.setViewName("/green/storeDetail");
        return modelAndView;
    }

//    @RequestMapping("/storeDetail")
//    public ModelAndView storeDetail(StoreRequest storeRequest) {
//        String couponType = storeRequest.getCoupon_type();
//        ModelAndView modelAndView = new ModelAndView();
//        CpSitestoreRequest cpSitestoreRequest = new CpSitestoreRequest();
//        cpSitestoreRequest.setSiteId(storeRequest.getSiteId());
//        modelAndView.addObject("topStoreList", officialWebsiteService.getTopStoreList(cpSitestoreRequest));
//        StoreDetailResponse storeDetail = webSiteService.getStoreDetail(storeRequest);
//        if (!CollectionUtils.isEmpty(storeDetail.getCouponList().getList())) {
//            List<CpCouponVo> couponVoList = new ArrayList<>();
//            for (CpCouponVo cpCouponVo : storeDetail.getCouponList().getList()) {
//                if (storeRequest.getC() != null && storeRequest.getC().equals(cpCouponVo.getId())) {
//                    modelAndView.addObject("coupon", cpCouponVo);
//                }
//                if (StringUtils.hasText(couponType)) {
//                    if (couponType.equals(cpCouponVo.getCouponType())) {
//                        couponVoList.add(cpCouponVo);
//                    }
//                }
//            }
//            if(StringUtils.hasText(couponType)){
//                storeDetail.getCouponList().setList(couponVoList);
//            }
//        }
//        modelAndView.addObject("storeDetail", storeDetail);
//        StoreRequest visitStoreRequest = new StoreRequest();
//        visitStoreRequest.setId(storeDetail.getId());
//        webSiteService.updateStoreVisitCount(visitStoreRequest);
//        modelAndView.setViewName("/green/storeDetail");
//        return modelAndView;
//    }

    @RequestMapping("/category")
    public ModelAndView category() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("categoryList", showSiteTypeService.getList(SiteEnum.GREEN.getId(), 1));
        modelAndView.addObject("isCategory", true);
        modelAndView.addObject("tdkInfo", showSiteService.findOneByType(SiteEnum.GREEN.getId(), OutSitePageInfo.TYPE_CATEGORY_LIST));//关键词等页面描述信息
        modelAndView.setViewName("/green/category");
        return modelAndView;
    }

    @RequestMapping("/topcoupons")
    public ModelAndView topCoupons() {
        ModelAndView modelAndView = new ModelAndView();
        CouponPageRequest couponPageRequest = new CouponPageRequest();
        couponPageRequest.setOutSiteId(SiteEnum.GREEN.getId());
        modelAndView.addObject("topCouponList", officialWebsiteService.getTopCouponList(couponPageRequest));
        modelAndView.setViewName("/green/topCoupon");
        return modelAndView;
    }

    @RequestMapping("/category/{name}")
    public ModelAndView categoryDetail(@PathVariable String name, @RequestParam(value = "coupon_type", required = false) String couponType, Integer page) {
        ModelAndView modelAndView = new ModelAndView();
        CategoryDetailJspRequest categoryRequest = new CategoryDetailJspRequest();
        categoryRequest.setSiteId(SiteEnum.GREEN.getId());
        categoryRequest.setName(name);
        CpSitestoreType category = showSiteTypeService.selectByName(categoryRequest);
        if(category == null){
          throw new BusinessRuntimeException("分类信息不存在");
        }
        categoryRequest.setId(category.getId());
        categoryRequest.setPageSize(30);
        if (StringUtils.hasText(couponType) && !"all".equals(couponType)) {
            categoryRequest.setCouponType(couponType);
        }
        if (page != null) {
            categoryRequest.setPageNumber(page);
        }
        CpSitestoreRequest cpSitestoreRequest = new CpSitestoreRequest();
        cpSitestoreRequest.setSiteId(SiteEnum.GREEN.getId());
        //分类所有店铺?(前10)
        //modelAndView.addObject("topStoreList", officialWebsiteService.getTopStoreList(cpSitestoreRequest));
        
//        StorePageRequst storePageRequst = new StorePageRequst();
//        storePageRequst.setPageSize(10);
//        storePageRequst.setSiteId(SiteEnum.GREEN.getId());
        
        ShowSiteStoreRequest showSiteStoreRequest = new ShowSiteStoreRequest();
        showSiteStoreRequest.setOutId(SiteEnum.GREEN.getId());
        showSiteStoreRequest.setTypeId(category.getId());

        modelAndView.addObject("stores", showSiteTwoService.getTwoList(showSiteStoreRequest).getList());
        
        modelAndView.addObject("coupons", webSiteService.getCouponListByCategory(categoryRequest));
        modelAndView.addObject("currentCategory", category);
        if (category.getPid() != null) {
            modelAndView.addObject("children", showSiteTypeService.getSonList(category.getPid()));
            modelAndView.addObject("pCategory", showSiteTypeService.getById(category.getPid()));
        } else {
            modelAndView.addObject("children", showSiteTypeService.getSonList(category.getId()));
            modelAndView.addObject("pCategory", category);
        }
        
        modelAndView.addObject("categoryList", showSiteTypeService.getList(SiteEnum.GREEN.getId(), 1));
        modelAndView.addObject("isCategory", true);
        
        //关键词等页面描述信息(需要替换分类)
        OutSitePageInfo tdkInfo = showSiteService.findOneByType(SiteEnum.GREEN.getId(), OutSitePageInfo.TYPE_CATEGORY_DETAIL);
        String title = tdkInfo.getTitle();
        if(StringUtils.hasText(title) && title.contains("{{category_name}}")){
          tdkInfo.setTitle(title.replace("{{category_name}}", name));
        }
        modelAndView.addObject("tdkInfo", tdkInfo);
        
        modelAndView.setViewName("/green/categoryDetail");
        return modelAndView;
    }

//    @RequestMapping("/categoryDetail")
//    public ModelAndView categoryDetail(CategoryDetailJspRequest categoryRequest) {
//        ModelAndView modelAndView = new ModelAndView();
//        CpSitestoreRequest cpSitestoreRequest = new CpSitestoreRequest();
//        cpSitestoreRequest.setSiteId(categoryRequest.getSiteId());
//        modelAndView.addObject("topStoreList", officialWebsiteService.getTopStoreList(cpSitestoreRequest));
//        modelAndView.addObject("coupons", webSiteService.getCouponListByCategory(categoryRequest));
//        CpSitestoreType category = showSiteTypeService.getById(categoryRequest.getId());
//        modelAndView.addObject("currentCategory", category);
//        if (categoryRequest.getpId() != null) {
//            modelAndView.addObject("children", showSiteTypeService.getSonList(categoryRequest.getpId()));
//            modelAndView.addObject("pCategory", showSiteTypeService.getById(categoryRequest.getpId()));
//        } else {
//            modelAndView.addObject("children", showSiteTypeService.getSonList(categoryRequest.getId()));
//            modelAndView.addObject("pCategory", category);
//        }
//
//
//        modelAndView.setViewName("/green/categoryDetail");
//        return modelAndView;
//    }


}
