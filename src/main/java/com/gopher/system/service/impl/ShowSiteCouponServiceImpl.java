package com.gopher.system.service.impl;

import java.util.Calendar;
import java.util.Date;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.gopher.system.constant.SystemConstants;
import com.gopher.system.dao.mysql.CpCouponDAO;
import com.gopher.system.dao.mysql.CpOutSiteCouponDAO;
import com.gopher.system.exception.BusinessRuntimeException;
import com.gopher.system.model.entity.CpCoupon;
import com.gopher.system.model.entity.CpOutSiteCoupon;
import com.gopher.system.model.vo.Page;
import com.gopher.system.model.vo.request.ShowSiteCouponPageRequest;
import com.gopher.system.model.vo.request.ShowSiteCouponRequest;
import com.gopher.system.model.vo.response.ShowSiteCouponResponse;
import com.gopher.system.service.ShowSiteCouponService;

/**
 * @author dongyangyang
 */
@Service
public class ShowSiteCouponServiceImpl implements ShowSiteCouponService {
    @Autowired
    private CpOutSiteCouponDAO cpOutSiteCouponDAO;
    @Autowired
    private CpCouponDAO cpCouponDAO;

    private static final Logger LOG = LoggerFactory.getLogger(ShowSiteCouponServiceImpl.class);

    @Override
    public Page<ShowSiteCouponResponse> getCouponPage(ShowSiteCouponPageRequest showSiteCouponPageRequest) {
        if (null == showSiteCouponPageRequest) {
            throw new BusinessRuntimeException("参数不能为空");
        }
//        final int siteId = showSiteCouponPageRequest.getSiteId();
//        if (siteId <= 0) {
//            throw new BusinessRuntimeException("非法的站点ID");
//        }
        Page<ShowSiteCouponResponse> result = new Page<>();
        result.setPageNumber(showSiteCouponPageRequest.getPageNumber());
        result.setPageSize(showSiteCouponPageRequest.getPageSize());
        
        List<ShowSiteCouponResponse> list = cpOutSiteCouponDAO.getPageList(showSiteCouponPageRequest);
        final int count = cpOutSiteCouponDAO.getTotalCount(showSiteCouponPageRequest);
        if (null != list) {
            for (ShowSiteCouponResponse showSiteCouponResponse : list) {
                Date expiryTime = showSiteCouponResponse.getExpiryTime();
                showSiteCouponResponse.setExpired(expiryTime != null && expiryTime.getTime() < System.currentTimeMillis());
            }
        }
        result.setList(list);
        result.setTotalCount(count);
        return result;
    }

    @Transactional
    @Override
    public void edit(ShowSiteCouponRequest request) {
        LOG.info("接收到的参数:{}", JSON.toJSONString(request));
        this.parametervalidator(request);
        final String title = request.getCurrentTitle();
        if (StringUtils.hasText(title)) {
            CpOutSiteCoupon record = new CpOutSiteCoupon();
            record.setId(request.getMapId());
            record.setTitle(title);
            record.setUpdateTime(new Date());
            cpOutSiteCouponDAO.updateByPrimaryKeySelective(record);
        }
        
        CpCoupon cpCoupon = new CpCoupon();
        cpCoupon.setId(request.getId());
        long expiryTime = request.getExpiryTime();
        if(expiryTime == 0){
          cpCoupon.setExpireAt(null);
        } else {
          Calendar calendar = Calendar.getInstance();
          calendar.setTimeInMillis(expiryTime);
          cpCoupon.setExpireAt(calendar.getTime());
        }
        cpCoupon.setDes(request.getDescription());
        cpCoupon.setIsPass(request.getIsPass());//有改动则自动到已审核状态
        if(request.getInType() == SystemConstants.IN_TEYE_MANUAL.getValue().intValue()){//人工
          cpCoupon.setName(request.getSourceTitle());
          String code = request.getCode();
          cpCoupon.setCode(code);
          if(StringUtils.hasText(code)){
            cpCoupon.setCouponType("CODE");  
          } else {
            cpCoupon.setCouponType("DEAL");  
          }
        }
        cpCouponDAO.updateByPrimaryKeySelective(cpCoupon);
        
//        final String code = request.getCode();
//        final long expriyTime = request.getExpiryTime();
//        if (StringUtils.hasText(code) || expriyTime > 0) {
//            CpCoupon cpCoupon = new CpCoupon();
//            cpCoupon.setId(request.getId());
//            cpCoupon.setCode(code);
//            cpCoupon.setIsPass(request.getIsPass());
//            cpCoupon.setExpireAt(new Date(expriyTime));
//            cpCoupon.setDes(request.getDescription());
//            int rows = cpCouponDAO.updateByPrimaryKeySelective(cpCoupon);
//            LOG.info("更新的记录:{}", rows);
//        }
    }

    private void parametervalidator(ShowSiteCouponRequest showSiteCouponRequest) {
        if (null == showSiteCouponRequest) {
            throw new BusinessRuntimeException("参数不能为空");
        }
        final int id = showSiteCouponRequest.getId();
        final int mapId = showSiteCouponRequest.getMapId();

        if (id <= 0 || mapId <= 0) {
            throw new BusinessRuntimeException("非法的ID");
        }
    }

    @Override
    public void delete(ShowSiteCouponRequest showSiteCouponRequest) {
        this.parametervalidator(showSiteCouponRequest);
        final int mapId = showSiteCouponRequest.getMapId();
        cpOutSiteCouponDAO.deleteByPrimaryKey(mapId);
    }

    @Override
    public List<ShowSiteCouponResponse> getCouponListWithSort(ShowSiteCouponPageRequest showSiteCouponPageRequest) {
        return  cpOutSiteCouponDAO.getCouponListWithSort(showSiteCouponPageRequest);
    }

}
