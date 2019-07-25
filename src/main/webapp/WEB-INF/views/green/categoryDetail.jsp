<%@ page import="com.gopher.system.model.vo.CpCouponVo" %>
<%@ page import="com.gopher.system.model.vo.Page" %>
<%@ page import="com.gopher.system.model.entity.CpSitestoreType" %>
<%@ page import="org.springframework.util.StringUtils" %>
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
    CpSitestoreType currentCategory = (CpSitestoreType) request.getAttribute("currentCategory");
    String commonUrl = basePath + "/green/category/" + currentCategory.getName();

    String noCouponTypeUrl = commonUrl;
    if (request.getParameter("coupon_type") != null && request.getParameter("coupon_type") != "") {
        commonUrl += "?coupon_type=" + request.getParameter("coupon_type");
        commonUrl += "&verify=" + request.getParameter("verify");
        commonUrl += "&name__icontains=" + request.getParameter("name__icontains");
        commonUrl += "&";
    } else {
        commonUrl += "?";
    }
    Page<CpCouponVo> cpCouponVoPage = (Page<CpCouponVo>) request.getAttribute("coupons");
    Integer pageNumber = cpCouponVoPage.getTotalCount() == 0 ? 0 : (StringUtils.hasText(request.getParameter("page")) ? Integer.parseInt(request.getParameter("page")) : 1);
    Integer preNumber = pageNumber - 1;
    Integer nextNumber = pageNumber + 1;
    request.setAttribute("commonUrl", commonUrl);
    request.setAttribute("preNumber", preNumber);
    request.setAttribute("nextNumber", nextNumber);
    request.setAttribute("noCouponTypeUrl", noCouponTypeUrl);
    request.setAttribute("couponType", request.getParameter("coupon_type"));
%>
<script>

</script>

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
                                        <a href="${basePath}/green/category/${pCategory.name}/"
                                           class="font-weight-bold text-dark mb-3 d-block"
                                           style="font-size:16px;">${pCategory.name}</a>
                                    </c:otherwise>
                                </c:choose>
                                <ul class="list-group list-group-flush">


                                    <c:forEach items="${children}" var="category">
                                        <!-- 列表中的 category 等于当前页面的所属 category 的时候增加 active 类 -->
                                        <%--<c:choose>--%>
                                        <%--<c:when test="${category.id == currentCategory.id}">--%>
                                        <li class="list-group-item <c:if test="${category.id == currentCategory.id}">active</c:if> ">
                                            <a href="${basePath}/green/category/${category.name}/">${category.name}</a>
                                        </li>
                                        <%--</c:when>--%>
                                        <%--<c:otherwise>--%>
                                        <%--<li class="list-group-item">--%>
                                        <%--<a href="${basePath}/green/category/${category.name}/">${category.name}</a>--%>
                                        <%--</li>--%>
                                        <%--</c:otherwise>--%>
                                        <%--</c:choose>--%>
                                    </c:forEach>
                                </ul>

                                <p class="font-weight-bold mt-3">
                                    <a style="color:inherit;font-size:16px;" href="${basePath}/green/category/">All
                                        Categories</a>
                                </p>

                            </div>
                        </div>


                    </div>

                    <!-- Panel Header -->
                    <div class="card store-list-card">
                        <p class="card-title" style="font-size: 1.75rem">Stores</p>

                        <div class="card-body js-store-list">
                            <ul class="list-group list-group-flush">
                                <c:forEach items="${topStoreList}" var="store">
                                    <li class="list-group-item">
                                        <a href="${basePath}/green/store/<c:choose><c:when test="${store.webSite.indexOf(\"//www.\") >=0}"><c:choose><c:when test="${store.webSite.endsWith(\"/\")}">${store.webSite.substring(store.webSite.indexOf("//www.") + 6)}</c:when><c:otherwise>${store.webSite.substring(store.webSite.indexOf("//www.") + 6)}/</c:otherwise></c:choose></c:when><c:otherwise><c:choose><c:when test="${store.webSite.endsWith(\"/\")}">${store.webSite.substring(store.webSite.indexOf("//") + 2)}</c:when><c:otherwise>${store.webSite.substring(store.webSite.indexOf("//") + 2)}/</c:otherwise></c:choose></c:otherwise></c:choose>">${store.name}</a>
                                    </li>
                                </c:forEach>

                            </ul>
                        </div>
                    </div>
                </div>


                <div class="col-lg-9 coupon-container">
                    <div class="row">
                        <div class="col-12 choice">
                            <%--<c:choose>--%>
                            <%--<c:when test="${couponType == null}">--%>
                            <%--<a href="${noCouponTypeUrl}&pageNumber=1">--%>
                            <button id="type_all"
                                    class="btn btn-sm btn-all <c:if test="${couponType == null || couponType == 'all'}">btn-active</c:if> ">
                                All<span class="d-none d-md-inline">  Offers</span>
                            </button>
                            <%--</a>--%>
                            <%--</c:when>--%>
                            <%--<c:otherwise>--%>
                            <%--&lt;%&ndash;<a href="${noCouponTypeUrl}&pageNumber=1">&ndash;%&gt;--%>
                            <%--<button id="type_all" class="btn btn-sm btn-all">--%>
                            <%--All<span class="d-none d-md-inline">  Offers</span>--%>
                            <%--</button>--%>
                            <%--&lt;%&ndash;</a>&ndash;%&gt;--%>
                            <%--</c:otherwise>--%>
                            <%--</c:choose>--%>

                            <%--<c:choose>--%>
                            <%--<c:when test="${couponType == 'CODE'}">--%>
                            <%--<a href="${noCouponTypeUrl}&pageNumber=1&couponType=CODE">--%>
                            <button id="type_code"
                                    class="btn btn-sm  btn-code <c:if test="${couponType == 'CODE'}">btn-active</c:if> ">
                                <span class="d-none d-md-inline">Coupon </span>Codes
                            </button>
                            <%--</a>--%>
                            <%--</c:when>--%>
                            <%--<c:otherwise>--%>
                            <%--&lt;%&ndash;<a href="${noCouponTypeUrl}&pageNumber=1&couponType=CODE">&ndash;%&gt;--%>
                            <%--<button id="type_code" class="btn btn-sm  btn-code">--%>

                            <%--<span class="d-none d-md-inline">Coupon </span>Codes--%>
                            <%--</button>--%>
                            <%--&lt;%&ndash;</a>&ndash;%&gt;--%>
                            <%--</c:otherwise>--%>
                            <%--</c:choose>--%>


                            <%--<c:choose>--%>
                            <%--<c:when test="${couponType == 'DEAL'}">--%>
                            <%--<a href="${noCouponTypeUrl}&pageNumber=1&couponType=DEAL">--%>
                            <button id="type_deal"
                                    class="btn btn-sm  btn-deal <c:if test="${couponType == 'DEAL'}">btn-active</c:if> ">
                                Deals
                            </button>
                            <%--</a>--%>
                            <%--</c:when>--%>
                            <%--<c:otherwise>--%>
                            <%--&lt;%&ndash;<a href="${noCouponTypeUrl}&pageNumber=1&couponType=DEAL">&ndash;%&gt;--%>
                            <%--<button id="type_deal" class="btn btn-sm btn-deal">--%>
                            <%--Deals--%>
                            <%--</button>--%>
                            <%--&lt;%&ndash;</a>&ndash;%&gt;--%>
                            <%--</c:otherwise>--%>
                            <%--</c:choose>--%>

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
                                           href="${basePath}/green/store/<c:choose><c:when test="${coupon.storeWebSite.indexOf(\"//www.\") >=0}"><c:choose><c:when test="${coupon.storeWebSite.endsWith(\"/\")}">${coupon.storeWebSite.substring(coupon.storeWebSite.indexOf("//www.") + 6)}</c:when><c:otherwise>${coupon.storeWebSite.substring(coupon.storeWebSite.indexOf("//www.") + 6)}/</c:otherwise></c:choose></c:when><c:otherwise><c:choose><c:when test="${coupon.storeWebSite.endsWith(\"/\")}">${coupon.storeWebSite.substring(coupon.storeWebSite.indexOf("//") + 2)}</c:when><c:otherwise>${coupon.storeWebSite.substring(coupon.storeWebSite.indexOf("//") + 2)}/</c:otherwise></c:choose></c:otherwise></c:choose>">
                                            <div class="cover">
                                                <img src="${coupon.storeLogo}"
                                                     alt="${coupon.storeName}">
                                            </div>
                                            <c:choose>
                                                <c:when test="${coupon.couponType == 'CODE'}">
                                                    <span class="coupon-label coupon-label--code">${coupon.couponType}</span>
                                                </c:when>
                                                <c:otherwise>
                                                    <span class="coupon-label coupon-label--deal">${coupon.couponType}</span>
                                                </c:otherwise>
                                            </c:choose>

                                        </a>
                                    </div>


                                    <div class="info-box col-9 col-sm-12 d-flex flex-wrap align-content-between">
                                        <a target="_blank" rel="nofollow" href="${basePath}/green/store/<c:choose><c:when test="${coupon.storeWebSite.indexOf(\"//www.\") >=0}"><c:choose><c:when test="${coupon.storeWebSite.endsWith(\"/\")}">${coupon.storeWebSite.substring(coupon.storeWebSite.indexOf("//www.") + 6)}</c:when><c:otherwise>${coupon.storeWebSite.substring(coupon.storeWebSite.indexOf("//www.") + 6)}/</c:otherwise></c:choose></c:when><c:otherwise><c:choose><c:when test="${coupon.storeWebSite.endsWith(\"/\")}">${coupon.storeWebSite.substring(coupon.storeWebSite.indexOf("//") + 2)}</c:when><c:otherwise>${coupon.storeWebSite.substring(coupon.storeWebSite.indexOf("//") + 2)}/</c:otherwise></c:choose></c:otherwise></c:choose>?c=${coupon.id}"
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
                                                   href="${commonUrl}page=${preNumber}"
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
                                                   href="${commonUrl}page=${nextNumber}"
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
<script>

    var coupon_type = 'CODE', verify = 'false', name__icontains = '', selected = '';
    $('#type_all').on('click', function () {
        // coupon_type = 'all';
        location.href = '?coupon_type=all';
    });
    $('#type_code').on('click', function () {
        coupon_type = 'CODE';
        show_div(coupon_type, verify, name__icontains, selected);
    });
    $('#type_deal').on('click', function () {
        coupon_type = 'DEAL';
        show_div(coupon_type, verify, name__icontains, selected);
    });
    $('#type_verify').on('click', function () {
        verify = !!$('#type_verify').hasClass('u-btn-outline-purple');
        show_div(coupon_type, verify, name__icontains, selected);
    });
    $('.search_input').keypress(function (e) {
        if (e.which === 13) {
            name__icontains = $('.search_input').val();
            show_div(coupon_type, verify, name__icontains, selected);
        }
    });
    $('.check_store').change(function () {
        selected = [];
        $('input.check_store:checked').each(function () {
            selected.push($(this).attr('name'));
        });
        show_div(coupon_type, verify, name__icontains, selected)
    });

    function show_div(coupon_type, verify, name__icontains, selected) {
        ssss = '';
        for (var i = 0; i < selected.length; i++) {
            ssss = ssss + '&store=' + selected[i];
        }
        location.href = '?coupon_type=' + coupon_type + '&verify=' + verify + '&name__icontains=' + name__icontains + ssss
    }

</script>