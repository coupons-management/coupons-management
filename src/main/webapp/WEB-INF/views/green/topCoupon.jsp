<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../common/public.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="keywords" content="keywords"/>
    <meta name="description" content="description"/>
    <meta name="google-site-verification" content="AV6k9uxlDcEFufTdl0rM5Aetr5U9uvxCRcw0u3gYf8I"/>
    <meta name='webgains-site-verification' content='ambcr9xy'/>
    <title>绿站</title>
    <link rel="stylesheet" href="${basePath}/static/css/green/custom.css"/>
</head>
<body>
<!-- Header -->
<%@ include file="header.jsp" %>
<!-- End Header -->

<div class="js-site-main site-main">

    <section class="page-title-banner category-banner">
        <div class="container">
            <h1 class="text-center">TOP COUPONS</h1>
        </div>
    </section>

    <!-- Top Coupons -->
    <div class="container-wrap py-2">
        <section class="container top-coupon-section search-coupon-container">
            <div class="row">

                <c:forEach items="${topCouponList}" var="coupon">
                    <div class="coupon-item-wrap col-12 col-sm-6 col-md-4 col-lg-3 px-2 py-0 py-md-2">

                        <div class="coupon-item row no-gutters">
                            <div class="pic-box col-3 col-sm-12 d-flex flex-grow-0 justify-content-center">
                                <a class="cover-wrap position-relative" href="${basePath}/green/store/<c:choose><c:when test="${coupon.storeWebSite.indexOf(\"//www.\") >=0}"><c:choose><c:when test="${coupon.storeWebSite.endsWith(\"/\")}">${coupon.storeWebSite.substring(coupon.storeWebSite.indexOf("//www.") + 6)}</c:when><c:otherwise>${coupon.storeWebSite.substring(coupon.storeWebSite.indexOf("//www.") + 6)}/</c:otherwise></c:choose></c:when><c:otherwise><c:choose><c:when test="${coupon.storeWebSite.endsWith(\"/\")}">${coupon.storeWebSite.substring(coupon.storeWebSite.indexOf("//") + 2)}</c:when><c:otherwise>${coupon.storeWebSite.substring(coupon.storeWebSite.indexOf("//") + 2)}/</c:otherwise></c:choose></c:otherwise></c:choose>">
                                    <div class="cover">
                                        <img src="${coupon.storeLogo}" alt="${coupon.name}">
                                    </div>

                                    <c:choose>
                                        <c:when test="${coupon.couponType == 'DEAL'}">
                                            <span class="coupon-label coupon-label--deal">DEAL</span>
                                        </c:when>
                                        <c:otherwise>
                                            <span class="coupon-label coupon-label--deal">CODE</span>
                                        </c:otherwise>
                                    </c:choose>

                                </a>
                            </div>

                            <div class="info-box col-9 col-sm-12 d-flex flex-wrap align-content-between">
                                <a target="_self" rel="nofollow" url=""
                                   class="get_deal coupon-title text-left text-sm-center"
                                   href="${basePath}/green/store/<c:choose><c:when test="${coupon.storeWebSite.indexOf(\"//www.\") >=0}"><c:choose><c:when test="${coupon.storeWebSite.endsWith(\"/\")}">${coupon.storeWebSite.substring(coupon.storeWebSite.indexOf("//www.") + 6)}</c:when><c:otherwise>${coupon.storeWebSite.substring(coupon.storeWebSite.indexOf("//www.") + 6)}/</c:otherwise></c:choose></c:when><c:otherwise><c:choose><c:when test="${coupon.storeWebSite.endsWith(\"/\")}">${coupon.storeWebSite.substring(coupon.storeWebSite.indexOf("//") + 2)}</c:when><c:otherwise>${coupon.storeWebSite.substring(coupon.storeWebSite.indexOf("//") + 2)}/</c:otherwise></c:choose></c:otherwise></c:choose>">
                                    <p>${coupon.name}</p>
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


</div>
<!-- Footer -->
<%@ include file="footer.jsp" %>
<!-- jQuery popper bootstrap typeahead -->
<script src="${basePath}/static/js/green/custom.js"></script>
</body>
</html>
