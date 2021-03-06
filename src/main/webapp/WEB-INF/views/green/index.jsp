<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../common/public.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="keywords" content="${tdkInfo.keyWords}"/>
    <meta name="description" content="${tdkInfo.description}"/>
    <meta name="google-site-verification" content="AV6k9uxlDcEFufTdl0rM5Aetr5U9uvxCRcw0u3gYf8I"/>
    <meta name="webgains-site-verification" content="ambcr9xy"/>

    <title>${tdkInfo.title}</title>
    <link rel="stylesheet" href="${basePath}/static/css/green/custom.css"/>
</head>
<body>
<!-- Header -->
<%@ include file="header.jsp" %>

<!-- End Header -->
<div class="js-site-main site-main">
    <style>
        .not_show {
            display: none;
        }

        .show {
            display: block;
        }

        .section-padding {
            padding-top: 1rem !important;
            padding-bottom: 1rem !important;
        }
    </style>

    <!-- Search Banner -->
    <section class="container-fluid search-banner d-none d-md-block"
             style="background-image: url(${basePath}/static/common/img/search-bg.jpg)">
        <div class="row justify-content-center align-items-center">
            <div class="col-lg-12">
                <!-- Search Field -->
                <h1 class=""
                    style="font-size: 38px;color: #fff; letter-spacing: 0;text-align: center;margin-bottom: 18px">
                    Various Cannabis Coupon Codes Online all Web</h1>

                <div class="input-group input-group-lg">
                    <input
                            type="search"
                            class="js-search__input form-control"
                            placeholder="Search for stores, offers or brands"
                            data-provide="typeahead"
                            autocomplete="off"
                            aria-label="Search for stores, offers or brands"
                            name="search"
                            id="index_search_input"
                    />
                    <ul class="typeahead dropdown-menu" role="listbox" style="top: 44px; left: 0px; display: none;"
                        id="index_search_ul">
                        <%--<li class="">--%>
                        <%--<a class="dropdown-item" href="#" role="option">--%>
                        <%--<div class="typeahead search-result">--%>
                        <%--<div class="img-text-wrap">--%>
                        <%--<img src="/static/media/spider/good_search/Foria Wellness.png" class="pic">--%>
                        <%--<div>--%>
                        <%--<strong>Foria Wellness</strong> -- Store--%>
                        <%--</div>--%>
                        <%--</div>--%>
                        <%--<p class="count">6 offers</p>--%>
                        <%--</div>--%>
                        <%--</a>--%>
                        <%--</li>--%>
                        <%--<li><a class="dropdown-item" href="#" role="option">--%>
                        <%--<div class="typeahead search-result">--%>
                        <%--<div class="img-text-wrap">--%>
                        <%--<img src="/static/media/spider/good_search/Flawless Vape Shop.jpg" class="pic">--%>
                        <%--<div><strong>Flawless Vape Shop</strong> -- Store</div>--%>
                        <%--</div>--%>
                        <%--<p class="count">15 offers</p>--%>
                        <%--</div>--%>
                        <%--</a></li>--%>
                        <%--<li><a class="dropdown-item" href="#" role="option">--%>
                        <%--<div class="typeahead search-result">--%>
                        <%--<div class="img-text-wrap">--%>
                        <%--<img src="/static/media/spider/good_search/Frontier Jackson.png" class="pic">--%>
                        <%--<div><strong>Frontier Jackson</strong> -- Store</div>--%>
                        <%--</div>--%>
                        <%--<p class="count">12 offers</p>--%>
                        <%--</div>--%>
                        <%--</a></li>--%>
                        <%--<li class=""><a class="dropdown-item" href="#" role="option">--%>
                        <%--<div class="typeahead search-result">--%>
                        <%--<div class="img-text-wrap">--%>
                        <%--<img src="/static/media/spider/good_search/Fuggin Vapor Co..png" class="pic">--%>
                        <%--<div><strong>Fuggin Vapor Co.</strong> -- Store</div>--%>
                        <%--</div>--%>
                        <%--<p class="count">47 offers</p>--%>
                        <%--</div>--%>
                        <%--</a></li>--%>
                        <%--<li class=""><a class="dropdown-item" href="#" role="option">--%>
                        <%--<div class="typeahead search-result">--%>
                        <%--<div class="img-text-wrap">--%>
                        <%--<img src="/static/media/spider/good_search/Freedom Seeds.png" class="pic">--%>
                        <%--<div><strong>Freedom Seeds</strong> -- Store</div>--%>
                        <%--</div>--%>
                        <%--<p class="count">6 offers</p>--%>
                        <%--</div>--%>
                        <%--</a></li>--%>
                        <%--<li class="active">--%>
                        <%--<a class="dropdown-item" href="#" role="option">--%>
                        <%--<div class="typeahead search-result">--%>
                        <%--<div>--%>
                        <%--<strong>CBD Oil for pets</strong>--%>
                        <%--<span> -- Category</span>--%>
                        <%--</div>--%>
                        <%--<p class="count">more stores</p>--%>
                        <%--</div>--%>
                        <%--</a>--%>
                        <%--</li>--%>
                    </ul>
                    <div class="input-group-append">
                        <button class="btn btn-outline-secondary" type="button"><i class="fa fa-search"></i></button>
                    </div>
                </div>
            </div>
            <!-- End Search Field -->
        </div>
    </section>
    <!-- End Search Banner -->

    <!-- Top Stores -->
    <div class="top-store-container-wrap mb-2 mb-sm-0">
        <section class="container">
            <h2 class="section-title">Top Stores</h2>
            <div class="row">
                <c:forEach items="${topStoreList}" var="store">
                    <div class="col-6 col-md-4 col-lg-5-1 p-2" style="height: 187px">
                        <a class="store-grid-item cover-wrap"
                           href="${basePath}/green/store/${fn:replace(fn:replace(fn:replace(store.webSite,'www.',''),'http://',''),'https://','')}">
                           
                           <%--href="${basePath}/green/storeDetail?storeId=${store.storeId}&siteId=1">--%>
                            <div class="cover">
                                <img src="${store.logoUrl}" class="align-self-center" alt="${store.name} coupons"
                                     title="${store.name}"/>
                            </div>
                        </a>
                    </div>
                </c:forEach>
            </div>
        </section>
    </div>
    <!-- End Top Stores -->

    <!-- Top Coupons -->
    <div class="container-wrap mb-2 mb-sm-0">
        <section class="container top-coupon-section">
            <h2 class="section-title">Top Coupons</h2>
            <div class="row">

                <c:forEach items="${topCouponList}" var="coupon">

                    <div class="col-12 col-sm-6 col-md-4 col-lg-3 px-2 py-0 py-sm-2">
                        <div class="coupon-item row no-gutters">
                            <div class="pic-box col-3 col-sm-12 d-flex flex-grow-0 justify-content-center">
                                <a class="cover-wrap position-relative"
                                   href="${basePath}/green/store/${fn:replace(fn:replace(fn:replace(coupon.storeWebSite,'www.',''),'http://',''),'https://','')}">
                                    <div class="cover">
                                        <img src="${coupon.storeLogo}" alt="${coupon.storeName} coupons"/>
                                    </div>
                                    <c:choose>
                                        <c:when test="${coupon.couponType == 'DEAL'}">
                                            <span class="coupon-label coupon-label--deal">DEAL</span>
                                        </c:when>
                                        <c:otherwise>
                                            <span class="coupon-label coupon-label--code">CODE</span>
                                        </c:otherwise>
                                    </c:choose>
                                </a>
                            </div>

                            <div class="info-box col-9 col-sm-12 d-flex flex-wrap align-content-between">
                                <a target="_blank" rel="nofollow" url="${coupon.storeWebSite}"
                                   class="get_deal coupon-title text-left text-sm-center"
                                   href="${basePath}/green/store/${fn:replace(fn:replace(fn:replace(coupon.storeWebSite,'www.',''),'http://',''),'https://','')}?c=${coupon.outSiteCouponId}">
                                    <h3>${coupon.name}</h3>
                                </a>

                                <div class="extra-info">
                                    <span class="use-info"><i class="fa fa-user mr-1"
                                                              aria-hidden="true"></i>0 USED</span>
                                    <span class="d-none d-sm-block">
                      <span class="rate">
                        <i class="fa fa-star" aria-hidden="true"></i>
                        <i class="fa fa-star" aria-hidden="true"></i>
                        <i class="fa fa-star" aria-hidden="true"></i>
                        <i class="fa fa-star" aria-hidden="true"></i>
                        <i class="fa fa-star" aria-hidden="true"></i>
                      </span>
                      <span class="success">SUCCESS</span>
                    </span>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>

            </div>
        </section>
    </div>
    <!-- End Top Coupons -->

    <!-- Top Categories -->
    <div class="container-wrap expand-container-wrap mb-2">
        <section class="container top-categories-section">
            <h2 class="section-title">
                Top Categories
                <a href="#top-categories-content" data-toggle="collapse" role="button" aria-expanded="false"
                   class="collapsed" aria-controls="top-categories-content">
                    <c:if test="${fn:length(categoryList)> 5}">
                      <i class="fa fa-chevron-up d-inline d-sm-none float-right"></i>
                    </c:if>
                </a>
            </h2>

            <div class="show visible-md">
              <div class="row">
                 <c:forEach items="${categoryList}" var="category" end="4">
                   <div class="col-12 col-sm-4 col-md-3 col-lg-2 p-sm-2">
                      <div class="category-item">
                          <a class="category-title"
                             href="${basePath}/green/category/${category.name}/">
                              <p>${category.name}</p>
                          </a>
                      </div>
                   </div>
                 </c:forEach>
              </div>
            </div>

            <div id="top-categories-content" class="collapse">
                <div class="row">
                  <c:forEach items="${categoryList}" var="category" begin="5">
                    <div class="col-12 col-sm-4 col-md-3 col-lg-2 p-sm-2">
                       <div class="category-item">
                          <a class="category-title"
                             href="${basePath}/green/category/${category.name}/">
                              <p>${category.name}</p>
                          </a>
                        </div>
                    </div>
                  </c:forEach>
                </div>
            </div>
        </section>
    </div>
    <!-- End Top Categories -->

    <!-- Top Stores -->
    <div class="popular-store-container-wrap expand-container-wrap mb-2 mb-md-3">
        <section class="container">
            <h2 class="section-title">
                Popular Stores
                <a href="#popular-store-content" data-toggle="collapse" role="button" aria-expanded="false"
                   class="collapsed" aria-controls="popular-store-content">
                   <c:if test="${fn:length(popularStoreList)> 5}">
                    <i class="fa fa-chevron-up d-inline d-sm-none float-right"></i>
                   </c:if>
                </a>
            </h2>

            <div class="popular-store-content show visible-md">
                <div class="row">
                    <c:forEach items="${popularStoreList}" var="popularStore" end="4">
                        <div class="store-name-wrap col-12 col-md-4 col-lg-5-1 mb-3 mb-md-4">
                            <a href="${basePath}/green/store/${fn:replace(fn:replace(fn:replace(popularStore.website,'www.',''),'http://',''),'https://','')}">${popularStore.showName}</a>
                        </div>
                    </c:forEach>
                </div>
            </div>

           <div id="popular-store-content" class="popular-store-content collapse">
                <div class="row">
                    <c:forEach items="${popularStoreList}" var="popularStore" begin="5">
                        <div class="store-name-wrap col-12 col-md-4 col-lg-5-1 mb-3 mb-md-4">
                            <a href="${basePath}/green/store/${fn:replace(fn:replace(fn:replace(popularStore.website,'www.',''),'http://',''),'https://','')}">${popularStore.showName}</a>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </section>
    </div>
    <!-- End Top Stores -->
</div>

<!-- Footer -->
<%@ include file="footer.jsp" %>
<script src="${basePath}/static/js/green/custom.js"></script>
<script src="${basePath}/static/js/green/index.js"></script>
</body>
</html>
<script>
    $(document).ready(function () {
        $('.get_code,.get_deal').on('click', function () {
            var $this = $(this);

            var url = $this.attr('url');
            window.location.replace(url);

        });
    })
</script>
