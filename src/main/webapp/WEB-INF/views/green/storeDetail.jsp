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
    <!-- bootstrap -->
    <link rel="stylesheet" href="${basePath}/static/css/green/custom.css"/>
</head>
<body>
<!-- Header -->
<%@ include file="header.jsp" %>
<!-- End Header -->


<div class="js-site-main site-main">

    <section class="page-title-banner ">
        <div class="container store-info-container">
            <div class="row">
                <!-- Profle Content -->
                <div class="col-lg-2 col-md-3 col-5 d-flex align-items-center">
                    <!-- User Image -->
                    <div class="store-brand cover-wrap">
                        <a class="cover" href="href="${basePath}/green/storeDetail?storeId=${store.id}&siteId=1"" target="_blank" rel="nofollow">
                            <img class="img-fluid" src="${storeDetail.logo}" alt="">
                        </a>
                    </div>
                </div>
                <div class="col-lg-8 col-md-9 col-7 d-flex d-lg-block align-items-center">
                    <h1 class="store-name">${storeDetail.name}</h1>
                    <p class="store-description d-none d-lg-block">${storeDetail.storeDescription}</p>

                    <%--<div class="d-none d-lg-block">--%>
                                <%--<span class="store-info-item">--%>
                                    <%--<em>5</em> Offers Available--%>
                                <%--</span>--%>
                        <%--<span class="store-info-item">--%>
                                    <%--<em>2</em> Verified Coupons--%>
                                <%--</span>--%>
                        <%--<span class="store-info-item">--%>
                                    <%--<em>1</em> Coupon Codes--%>
                                <%--</span>--%>
                        <%--<span class="store-info-item">--%>
                                    <%--<em>3</em> Sales--%>
                                <%--</span>--%>
                        <%--<span class="store-info-item">--%>
                                    <%--May 20, 2019--%>
                                <%--</span>--%>
                    <%--</div>--%>
                    <!-- Project Progress -->
                </div>
                <div class="col-lg-2 d-none d-lg-flex align-items-end justify-content-end">
                    <a class="visit-btn" href="${storeDetail.website}" target="_blank" rel="nofollow">Visit Website</a>
                </div>
            </div>
        </div>
    </section>

    <div class="container-wrap store-detail-main-wrap">
        <div class="container">
            <div class="row">
                <!-- left side -->
                <div class="col-lg-3 col-12 pr-lg-0 d-none d-lg-block">

                    <!-- Panel Header -->
                    <div class="card top-store-card">
                        <p style="font-size: 28px;color: #444;font-weight: normal;margin-bottom: 26px;">Top Stores</p>

                        <!-- Panel Body -->
                        <div class="row">
                            <c:forEach items="${topStoreList}" var="store">
                                <div class="col-6 p-2">
                                    <a class="cover-wrap store-item" style="max-height: 100px"
                                       href="${basePath}/green/storeDetail?storeId=${store.storeId}&siteId=1">
                                        <div class="cover">
                                            <img class="img-fluid"
                                                 style="height: 96px;max-width: 100%;max-height: 100%;"
                                                 alt="${store.name}" src="${store.logoUrl}">
                                        </div>
                                    </a>
                                </div>
                            </c:forEach>

                        </div>
                        <!-- End Panel Body -->
                    </div>

                </div>

                <div class="col-lg-9 col-12 coupon-container">
                    <div class="row">
                        <div class="col-12 choice">
                            <button id="type_all" class="btn btn-sm btn-active btn-all">
                                All<span class="d-none d-md-inline">  Offers</span>
                            </button>
                            <button id="type_code" class="btn btn-sm  btn-code">
                                <span class="d-none d-md-inline">Coupon </span>Codes
                            </button>
                            <button id="type_deal" class="btn btn-sm  btn-deal">Deals</button>
                            <button id="type_verify" class="btn btn-sm  btn-verify">
                                <i class="fa fa-shield d-inline d-md-none" aria-hidden="true"></i>
                                <div class="custom-check-box d-none d-md-block">
                                    <input type="checkbox" id="verify-2">
                                    <label for="verify-2">
                                        <i class="fa fa-check" aria-hidden="true"></i>
                                        VERIFIED 2
                                    </label>
                                </div>
                            </button>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-12">
                            <!-- User Block -->
                            <c:forEach items="${storeDetail.couponList.list}" var="coupon">
                                <div class="box d-flex my-2 my-sm-3">
                                    <div class="offer d-none d-sm-block">
                                        <div class="offer-anchor d-flex flex-column justify-content-center align-items-center" style="max-height: 100px">
                                            <!-- TODO 将 30% off 替换为真实的值 这里先不换, 具体规则未定-->
                                            <span class="offer-anchor-text">${coupon.sale}</span>
                                            <span class="label code">${coupon.couponType}</span>

                                        </div>
                                    </div>

                                    <div class="detail-info">
                                        <a class="get_code" url="xxx" href="./storeDetail.jsp?c=120705" target="_self"
                                           rel="nofollow">
                                            <h3 class="paddl"><span class="label code d-inline d-sm-none">${coupon.couponType}</span>${coupon.description}</h3>
                                        </a>

                                        <p class="coupon-description">&nbsp;&nbsp;&nbsp;</p>
                                        <div class="foot">
                        <span class="use-info d-inline d-sm-none"><i class="fa fa-user mr-1" aria-hidden="true"></i>

                                19

                             USED</span>
                                        </div>

                                        <a href="./storeDetail.jsp?c=120705" rel="nofollow" class="get_code"
                                           data-id="120705" data-clipboard-text="save10" target="_self"
                                           url="${storeDetail.website}">
                                            <div class="coupon-hop">
                                                <div class="partial-code">0</div>
                                                <div class="hide-btn d-flex align-items-center justify-content-center">
                                                <span>Show Code<br><small
                                                        class="d-none d-sm-inline">&amp; visit site</small></span>
                                                </div>
                                            </div>
                                        </a>

                                    </div>
                                </div>
                            </c:forEach>





                            <%--<div class="box d-flex my-2 my-sm-3">--%>
                                <%--<div class="offer d-none d-sm-block">--%>
                                    <%--<div class="offer-anchor d-flex flex-column justify-content-center align-items-center">--%>
                                        <%--<!-- TODO 将 30% off 替换为真实的值 这里先不换, 具体规则未定-->--%>

                                        <%--<span class="offer-anchor-text">10%<br>OFF</span>--%>

                                        <%--<span class="label code">CODE</span>--%>

                                    <%--</div>--%>
                                <%--</div>--%>

                                <%--<div class="detail-info">--%>
                                    <%--<a class="get_code" url="xxx" href="./storeDetail.jsp?c=120705" target="_self"--%>
                                       <%--rel="nofollow">--%>
                                        <%--<h3 class="paddl"><span class="label code d-inline d-sm-none">CODE</span>Extra--%>
                                            <%--10% Off With Our Exclusive Code</h3>--%>
                                    <%--</a>--%>

                                    <%--<p class="coupon-description">&nbsp;&nbsp;&nbsp;</p>--%>
                                    <%--<div class="foot">--%>
                        <%--<span class="use-info d-inline d-sm-none"><i class="fa fa-user mr-1" aria-hidden="true"></i>--%>
                            <%----%>
                                <%--19--%>
                            <%----%>
                             <%--USED</span>--%>
                                    <%--</div>--%>

                                    <%--<a href="./storeDetail.jsp?c=120705" rel="nofollow" class="get_code"--%>
                                       <%--data-id="120705" data-clipboard-text="save10" target="_self"--%>
                                       <%--url="./storeDetail.html?c=120705#get_code_120705">--%>
                                        <%--<div class="coupon-hop">--%>
                                            <%--<div class="partial-code">0</div>--%>
                                            <%--<div class="hide-btn d-flex align-items-center justify-content-center">--%>
                                                <%--<span>Show Code<br><small--%>
                                                        <%--class="d-none d-sm-inline">&amp; visit site</small></span>--%>
                                            <%--</div>--%>
                                        <%--</div>--%>
                                    <%--</a>--%>

                                <%--</div>--%>
                            <%--</div>--%>

                            <%--<div class="box d-flex my-2 my-sm-3">--%>
                                <%--<div class="offer d-none d-sm-block">--%>
                                    <%--<div class="offer-anchor d-flex flex-column justify-content-center align-items-center">--%>
                                        <%--<!-- TODO 将 30% off 替换为真实的值 这里先不换, 具体规则未定-->--%>

                                        <%--<span class="offer-anchor-text">10%<br>OFF</span>--%>

                                        <%--<span class="label code">CODE</span>--%>

                                    <%--</div>--%>
                                <%--</div>--%>

                                <%--<div class="detail-info">--%>
                                    <%--<a class="get_code" url="xxx" href="./storeDetail.jsp?c=120705" target="_self"--%>
                                       <%--rel="nofollow">--%>
                                        <%--<h3 class="paddl"><span class="label code d-inline d-sm-none">CODE</span>Extra--%>
                                            <%--10% Off With Our Exclusive Code</h3>--%>
                                    <%--</a>--%>

                                    <%--<p class="coupon-description">&nbsp;&nbsp;&nbsp;</p>--%>
                                    <%--<div class="foot">--%>
                        <%--<span class="use-info d-inline d-sm-none"><i class="fa fa-user mr-1" aria-hidden="true"></i>--%>
                            <%----%>
                                <%--19--%>
                            <%----%>
                             <%--USED</span>--%>
                                    <%--</div>--%>

                                    <%--<a href="./storeDetail.jsp?c=120705" rel="nofollow" class="get_code"--%>
                                       <%--data-id="120705" data-clipboard-text="save10" target="_self"--%>
                                       <%--url="./storeDetail.html?c=120705#get_code_120705">--%>
                                        <%--<div class="coupon-hop">--%>
                                            <%--<div class="partial-code">0</div>--%>
                                            <%--<div class="hide-btn d-flex align-items-center justify-content-center">--%>
                                                <%--<span>Show Code<br><small--%>
                                                        <%--class="d-none d-sm-inline">&amp; visit site</small></span>--%>
                                            <%--</div>--%>
                                        <%--</div>--%>
                                    <%--</a>--%>

                                <%--</div>--%>
                            <%--</div>--%>
                            <%--<div class="box d-flex my-2 my-sm-3">--%>
                                <%--<div class="offer d-none d-sm-block">--%>
                                    <%--<div class="offer-anchor d-flex flex-column justify-content-center align-items-center">--%>
                                        <%--<!-- TODO 将 30% off 替换为真实的值 这里先不换, 具体规则未定-->--%>

                                        <%--<span class="offer-anchor-text">10%<br>OFF</span>--%>

                                        <%--<span class="label code">CODE</span>--%>

                                    <%--</div>--%>
                                <%--</div>--%>

                                <%--<div class="detail-info">--%>
                                    <%--<a class="get_code" url="xxx" href="./storeDetail.jsp?c=120705" target="_self"--%>
                                       <%--rel="nofollow">--%>
                                        <%--<h3 class="paddl"><span class="label code d-inline d-sm-none">CODE</span>Extra--%>
                                            <%--10% Off With Our Exclusive Code</h3>--%>
                                    <%--</a>--%>

                                    <%--<p class="coupon-description">&nbsp;&nbsp;&nbsp;</p>--%>
                                    <%--<div class="foot">--%>
                        <%--<span class="use-info d-inline d-sm-none"><i class="fa fa-user mr-1" aria-hidden="true"></i>--%>
                            <%----%>
                                <%--19--%>
                            <%----%>
                             <%--USED</span>--%>
                                    <%--</div>--%>

                                    <%--<a href="./storeDetail.jsp?c=120705" rel="nofollow" class="get_code"--%>
                                       <%--data-id="120705" data-clipboard-text="save10" target="_self"--%>
                                       <%--url="./storeDetail.html?c=120705#get_code_120705">--%>
                                        <%--<div class="coupon-hop">--%>
                                            <%--<div class="partial-code">0</div>--%>
                                            <%--<div class="hide-btn d-flex align-items-center justify-content-center">--%>
                                                <%--<span>Show Code<br><small--%>
                                                        <%--class="d-none d-sm-inline">&amp; visit site</small></span>--%>
                                            <%--</div>--%>
                                        <%--</div>--%>
                                    <%--</a>--%>

                                <%--</div>--%>
                            <%--</div>--%>
                            <%--<div class="box d-flex my-2 my-sm-3">--%>
                                <%--<div class="offer d-none d-sm-block">--%>
                                    <%--<div class="offer-anchor d-flex flex-column justify-content-center align-items-center">--%>
                                        <%--<!-- TODO 将 30% off 替换为真实的值 这里先不换, 具体规则未定-->--%>

                                        <%--<span class="offer-anchor-text">10%<br>OFF</span>--%>

                                        <%--<span class="label code">CODE</span>--%>

                                    <%--</div>--%>
                                <%--</div>--%>

                                <%--<div class="detail-info">--%>
                                    <%--<a class="get_code" url="xxx" href="./storeDetail.jsp?c=120705" target="_self"--%>
                                       <%--rel="nofollow">--%>
                                        <%--<h3 class="paddl"><span class="label code d-inline d-sm-none">CODE</span>Extra--%>
                                            <%--10% Off With Our Exclusive Code</h3>--%>
                                    <%--</a>--%>

                                    <%--<p class="coupon-description">&nbsp;&nbsp;&nbsp;</p>--%>
                                    <%--<div class="foot">--%>
                        <%--<span class="use-info d-inline d-sm-none"><i class="fa fa-user mr-1" aria-hidden="true"></i>--%>
                            <%----%>
                                <%--19--%>
                            <%----%>
                             <%--USED</span>--%>
                                    <%--</div>--%>

                                    <%--<a href="./storeDetail.jsp?c=120705" rel="nofollow" class="get_code"--%>
                                       <%--data-id="120705" data-clipboard-text="save10" target="_self"--%>
                                       <%--url="./storeDetail.html?c=120705#get_code_120705">--%>
                                        <%--<div class="coupon-hop">--%>
                                            <%--<div class="partial-code">0</div>--%>
                                            <%--<div class="hide-btn d-flex align-items-center justify-content-center">--%>
                                                <%--<span>Show Code<br><small--%>
                                                        <%--class="d-none d-sm-inline">&amp; visit site</small></span>--%>
                                            <%--</div>--%>
                                        <%--</div>--%>
                                    <%--</a>--%>

                                <%--</div>--%>
                            <%--</div>--%>

                            <%--<div class="box d-flex my-2 my-sm-3">--%>
                                <%--<div class="offer d-none d-sm-block">--%>
                                    <%--<div class="offer-anchor d-flex flex-column justify-content-center align-items-center">--%>
                                        <%--<!-- TODO 将 30% off 替换为真实的值 这里先不换, 具体规则未定-->--%>

                                        <%--<span class="offer-anchor-text">SALE</span>--%>

                                        <%--<span class="label deal">DEAL</span>--%>

                                    <%--</div>--%>
                                <%--</div>--%>

                                <%--<div class="detail-info">--%>
                                    <%--<a class="get_deal" href="./categoryDetail.html?=123594"--%>
                                       <%--url="./categoryDetail.html?c=123594#get_code_123594" target="_self"--%>
                                       <%--rel="nofollow">--%>
                                        <%--<h3 class="paddl"><span class="label code d-inline d-sm-none">CODE</span>Free--%>
                                            <%--Shipping On $149+ Order</h3>--%>
                                    <%--</a>--%>

                                    <%--<p class="coupon-description">&nbsp;&nbsp;&nbsp;</p>--%>
                                    <%--<div class="foot">--%>
                        <%--<span class="use-info d-inline d-sm-none"><i class="fa fa-user mr-1" aria-hidden="true"></i>--%>
                            <%----%>
                                <%--10--%>
                            <%----%>
                             <%--USED</span>--%>
                                    <%--</div>--%>

                                    <%--<a class="btn-get-deal get_deal" data-id="123594"--%>
                                       <%--href="./categoryDetail.html?c=123594" rel="nofollow" target="_self"--%>
                                       <%--url="./categoryDetail.html?c=123594#get_code_123594">--%>
                                        <%--GET DEAL--%>
                                    <%--</a>--%>

                                <%--</div>--%>
                            <%--</div>--%>
                        </div>
                    </div>
                    <!-- End Profile Sidebar -->
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Footer -->
<%@ include file="footer.jsp" %>
<script src="${basePath}/static/js/green/custom.js"></script>
</body>
</html>
