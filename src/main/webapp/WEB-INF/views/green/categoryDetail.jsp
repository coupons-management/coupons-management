<%@ page import="com.gopher.system.model.vo.CpCouponVo" %>
<%@ page import="com.gopher.system.model.vo.Page" %>
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
<%
    String commonUrl = basePath + "/green/categoryDetail?id="
            + request.getParameter("id") + "&pageSize=" + Integer.parseInt(request.getParameter("pageSize"))
            + "&siteId=" + Integer.parseInt(request.getParameter("siteId"));
    if(request.getParameter("pId") != null && request.getParameter("pId") != ""){
        commonUrl += "&pId=" + request.getParameter("pId");
    }
    String noCouponTypeUrl = commonUrl;
    if (request.getParameter("couponType") != null && request.getParameter("couponType") != "") {
        commonUrl += "&couponType=" + request.getParameter("couponType");
    }
    Page<CpCouponVo> cpCouponVoPage = (Page<CpCouponVo>) request.getAttribute("coupons");
    Integer pageNumber = cpCouponVoPage.getTotalCount() == 0 ? 0 : Integer.parseInt(request.getParameter("pageNumber"));
    Integer preNumber = pageNumber - 1;
    Integer nextNumber = pageNumber + 1;
    request.setAttribute("commonUrl", commonUrl);
    request.setAttribute("preNumber", preNumber);
    request.setAttribute("nextNumber", nextNumber);
    request.setAttribute("noCouponTypeUrl", noCouponTypeUrl);
    request.setAttribute("couponType", request.getParameter("couponType"));
%>

<body>
<!-- Header -->
<%@ include file="header.jsp" %>
<!-- End Header -->

<div class="js-site-main site-main">

    <section class="page-title-banner ">
        <div class="container">
            <div class="row">
                <!-- Profle Content -->
                <div class="col-12">
                    <h1>${category.name}
                    </h1>
                    <p>Update the most popular stores daily, Have the best coupons &amp; Deals!</p>
                </div>
            </div>
        </div>
    </section>

    <div class="container-wrap category-detail-container">
        <div class="container">
            <div class="row py-3">
                <!-- left side -->
                <div class="col-lg-3 pr-lg-0 d-none d-md-block">
                    <div class="card mb-3">
                        <div class="coupon-count">
                            <p class="mb-0">${coupons.totalCount} Offers </p>
                        </div>
                    </div>

                    <!-- Panel Header -->
                    <div class="card category-list-card mb-3">
                        <p class="card-title" style="font-size: 1.75rem">Categories</p>
                        <div class="card-body">
                            <div class="ml-4">
                                <c:choose>
                                    <c:when test="${pCategory.id == currentCategory.id}">
                                        <p class="font-weight-bold" style="font-size:16px;">${pCategory.name}</p>
                                    </c:when>
                                    <c:otherwise>
                                        <a href="${basePath}/green/categoryDetail?pageNumber=1&pageSize=30&siteId=1&id=${pCategory.id}"
                                           class="font-weight-bold text-dark mb-3 d-block"
                                           style="font-size:16px;">${pCategory.name}</a>
                                    </c:otherwise>
                                </c:choose>
                                <ul class="list-group list-group-flush">


                                    <c:forEach items="${children}" var="category">
                                        <!-- 列表中的 category 等于当前页面的所属 category 的时候增加 active 类 -->
                                        <c:choose>
                                            <c:when test="${category.id == currentCategory.id}">
                                                <li class="list-group-item active">
                                                    <a href="${basePath}/green/categoryDetail?pageNumber=1&pageSize=30&siteId=1&id=${category.id}&pId=${pCategory.id}">${category.name}</a>
                                                </li>
                                            </c:when>
                                            <c:otherwise>
                                                <li class="list-group-item">
                                                    <a href="${basePath}/green/categoryDetail?pageNumber=1&pageSize=30&siteId=1&id=${category.id}&pId=${pCategory.id}">${category.name}</a>
                                                </li>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </ul>

                                <%--<p class="font-weight-bold mt-3">--%>
                                <%--<a style="color:inherit;font-size:16px;"--%>
                                <%--href="${basePath}/green/categoryDetail?pageNumber=1&pageSize=30&siteId=1&id=${category.id}&name=${category.name}">${category.name}</a>--%>
                                <%--</p>--%>

                            </div>
                        </div>


                    </div>

                    <!-- Panel Header -->
                    <div class="card store-list-card">
                        <p class="card-title" style="font-size: 1.75rem">Stores</p>

                        <div class="card-body js-store-list">
                            <ul class="list-group list-group-flush">
                                <c:forEach items="${topStoreList}" var="store1">
                                    <li class="list-group-item">
                                        <a href="${basePath}/green/storeDetail?storeId=${store1.storeId}&siteId=1">${store1.name}</a>
                                    </li>
                                </c:forEach>

                            </ul>
                        </div>
                    </div>
                </div>


                <div class="col-lg-9 coupon-container">
                    <div class="row">
                        <div class="col-12 choice">
                            <c:choose>
                                <c:when test="${couponType == null}">
                                    <a href="${noCouponTypeUrl}&pageNumber=1">
                                        <button class="btn btn-sm btn-active btn-all">
                                            All<span class="d-none d-md-inline">  Offers</span>
                                        </button>
                                    </a>
                                </c:when>
                                <c:otherwise>
                                    <a href="${noCouponTypeUrl}&pageNumber=1">
                                        <button class="btn btn-sm btn-all">
                                            All<span class="d-none d-md-inline">  Offers</span>
                                        </button>
                                    </a>
                                </c:otherwise>
                            </c:choose>

                            <c:choose>
                                <c:when test="${couponType == 'CODE'}">
                                    <a href="${noCouponTypeUrl}&pageNumber=1&couponType=CODE">
                                        <button class="btn btn-sm  btn-code btn-active">
                                            <span class="d-none d-md-inline">Coupon </span>Codes
                                        </button>
                                    </a>
                                </c:when>
                                <c:otherwise>
                                    <a href="${noCouponTypeUrl}&pageNumber=1&couponType=CODE">
                                        <button class="btn btn-sm  btn-code">

                                            <span class="d-none d-md-inline">Coupon </span>Codes
                                        </button>
                                    </a>
                                </c:otherwise>
                            </c:choose>


                            <c:choose>
                                <c:when test="${couponType == 'DEAL'}">
                                    <a href="${noCouponTypeUrl}&pageNumber=1&couponType=DEAL">
                                        <button class="btn btn-sm  btn-deal btn-active">
                                            Deals
                                        </button>
                                    </a>
                                </c:when>
                                <c:otherwise>
                                    <a href="${noCouponTypeUrl}&pageNumber=1&couponType=DEAL">
                                        <button class="btn btn-sm btn-deal">
                                            Deals
                                        </button>
                                    </a>
                                </c:otherwise>
                            </c:choose>

                            <button id="type_verify" class="btn btn-sm  btn-verify">
                                <i class="fa fa-shield d-inline d-md-none" aria-hidden="true"></i>
                                <div class="custom-check-box  d-none d-md-block">
                                    <input type="checkbox" id="verify-">
                                    <label for="verify-">
                                        <i class="fa fa-check" aria-hidden="true"></i>
                                        VERIFIED
                                    </label>
                                </div>

                            </button>
                        </div>
                    </div>

                    <div class="row" style="margin: 1rem -.5rem">
                        <!-- User Block -->
                        <c:forEach items="${coupons.list}" var="coupon">
                            <div class="col-sm-6 col-md-4 col-12 py-1 py-sm-2 px-2">

                                <div class="coupon-item row no-gutters">
                                    <div class="pic-box col-3 col-sm-12 d-flex flex-grow-0 justify-content-center">
                                        <a class="cover-wrap position-relative"
                                           href="${basePath}/green/storeDetail?storeId=${coupon.storeId}&siteId=1">
                                            <div class="cover">
                                                <img src="${coupon.storeLogo}"
                                                     alt="${coupon.storeName}">
                                            </div>

                                            <span class="coupon-label coupon-label--code">${coupon.couponType}</span>

                                        </a>
                                    </div>


                                    <div class="info-box col-9 col-sm-12 d-flex flex-wrap align-content-between">
                                        <a target="_blank" rel="nofollow" href=""
                                           class="coupon-title text-left text-sm-center" url="">
                                            <h3>${coupon.title}</h3>
                                        </a>


                                        <div class="extra-info">
                                        <span class="use-info"><i class="fa fa-user mr-1"
                                                                  aria-hidden="true"></i> USED</span>
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
                        <!-- pages.paginated -->

                        <div class="col-12">
                            <c:choose>
                                <c:when test="${coupons.list.size() > 0}">

                                    <p class="ui-pagination">
                                        <!-- disable为禁用 active为激活 -->
                                        <c:choose>
                                            <c:when test="${preNumber <= 0}">
                                                <a id="pre-page" class="disable">
                                                    <i class="fa fa-angle-left" aria-hidden="true"></i>
                                                </a>
                                            </c:when>
                                            <c:otherwise>
                                                <a id="pre-page"
                                                   href="${commonUrl}&pageNumber=${preNumber}"
                                                   class="active">
                                                    <i class="fa fa-angle-left" aria-hidden="true"></i>
                                                </a>
                                            </c:otherwise>
                                        </c:choose>
                                            <%--<a id="pre-page" href="./categoryDetail.jsp?page=1" class="disable">--%>
                                            <%--<i class="fa fa-angle-left" aria-hidden="true"></i>--%>
                                            <%--</a>--%>
                                        <span>${coupons.pageNumber} / ${coupons.totalPage}</span>
                                        <c:choose>
                                            <c:when test="${nextNumber > coupons.totalPage && coupons.totalPage != 0}">
                                                <a id="next-page" href="" class="disable">
                                                    <i class="fa fa-angle-right" aria-hidden="true"></i>
                                                </a>
                                            </c:when>
                                            <c:otherwise>
                                                <a id="next-page"
                                                   href="${commonUrl}&pageNumber=${nextNumber}"
                                                   class="active">
                                                    <i class="fa fa-angle-right" aria-hidden="true"></i>
                                                </a>
                                            </c:otherwise>
                                        </c:choose>
                                            <%--<a id="next-page" href="./categoryDetail.jsp?page=2" class="active">--%>
                                            <%--<i class="fa fa-angle-right" aria-hidden="true"></i>--%>
                                            <%--</a>--%>
                                    </p>
                                </c:when>
                                <c:otherwise>
                                    <h1 class="no-result">No Result!</h1>
                                </c:otherwise>

                            </c:choose>
                            <%--<div class="col-12">--%>
                            <%--</div>--%>
                        </div>

                    </div>
                </div>
                <!-- End Profile Sidebar -->
            </div>
        </div>
    </div>
</div>

<!-- Footer -->
<%@ include file="footer.jsp" %>
<script src="${basePath}/static/js/green/custom.js"></script>
</body>

</html>