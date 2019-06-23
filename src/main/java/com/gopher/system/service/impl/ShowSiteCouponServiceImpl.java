package com.gopher.system.service.impl;

import java.util.Date;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
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
        final int siteId = showSiteCouponPageRequest.getSiteId();
        if (siteId <= 0) {
            throw new BusinessRuntimeException("非法的站点ID");
        }
        Page<ShowSiteCouponResponse> result = new Page<>();
        result.setPageNumber(showSiteCouponPageRequest.getPageNumber());
        result.setPageSize(showSiteCouponPageRequest.getPageSize());
        List<ShowSiteCouponResponse> list = cpOutSiteCouponDAO.getPageList(showSiteCouponPageRequest);
        final int count = cpOutSiteCouponDAO.getTotalCount(showSiteCouponPageRequest);
        if (null != list) {
            for (ShowSiteCouponResponse showSiteCouponResponse : list) {
                showSiteCouponResponse.setExpired(showSiteCouponResponse.getExpiryTime().getTime() < System.currentTimeMillis());
            }
        }
        result.setList(list);
        result.setTotalCount(count);
        return result;
    }

    @Transactional
    @Override
    public void edit(ShowSiteCouponRequest showSiteCouponRequest) {
        LOG.info("接收到的参数:{}", JSON.toJSONString(showSiteCouponRequest));
        this.parametervalidator(showSiteCouponRequest);
        final int id = showSiteCouponRequest.getId();
        final int mapId = showSiteCouponRequest.getMapId();
        final String title = showSiteCouponRequest.getCurrentTitle();
        if (StringUtils.hasText(title)) {
            CpOutSiteCoupon record = new CpOutSiteCoupon();
            record.setUpdateTime(new Date());
            record.setTitle(title);
            record.setId(mapId);
            int rows = cpOutSiteCouponDAO.updateByPrimaryKeySelective(record);
            LOG.info("更新的记录:{}", rows);
        }
        final String code = showSiteCouponRequest.getCode();
        final String isPass = showSiteCouponRequest.getIsPass();
        final long expriyTime = showSiteCouponRequest.getExpiryTime();
        final String desc = showSiteCouponRequest.getDescription();
        if (StringUtils.hasText(code) || expriyTime > 0) {
            CpCoupon cpCoupon = new CpCoupon();
            cpCoupon.setCode(code);
            cpCoupon.setIsPass(isPass);
            cpCoupon.setExpireAt(new Date(expriyTime));
            cpCoupon.setDes(desc);
            cpCoupon.setId(id);
            int rows = cpCouponDAO.updateByPrimaryKeySelective(cpCoupon);
            LOG.info("更新的记录:{}", rows);
        }

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
