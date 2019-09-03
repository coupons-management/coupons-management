<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/yellowPublic.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="keywords" content="keywords"/>
    <meta name="description" content="description"/>
    <title>黄站</title>

</head>
<body>
<%@ include file="header.jsp" %>
<!-- end header -->

<div>
    <div class="g-bg-white">
        <section class="container  g-pb-30 ">
            <div class="row">
                <h2 class="h3 g-color-black mb-0 index_h2 col-lg-4">Top Stores</h2>
            </div>
            <div class="row">
                <c:forEach items="${topStoreList}" var="store">
                    <div class="col-6 masonry-grid-item col-sm-6 col-lg-2 g-px-10 g-mb-15">
                        <article class="u-block-hover" style="width: 90%;margin: 0 auto;">
                            <a href="${basePath}/yellow/storeDetail?storeId=${store.storeId}&siteId=2">
                                <div class="g-bg-cover index_store" style="width: 100%;">
                                    <div class="index_store_hover">
                                        <img src="${store.logoUrl}" class="align-self-center"
                                             style="width: 100%;" alt="${store.name}" title="${store.title}"/>
                                    </div>
                                </div>
                            </a>
                            <div class="u-block-hover__additional--partially-slide-up g-z-index-1">
                                <a
                                        class="g-brd-bottom g-brd-white g-color-white g-font-weight-600 g-font-size-12 text-uppercase g-text-underline--none--hover g-mb-30"
                                        href="${basePath}/yellow/storeDetail?storeId=${store.storeId}&siteId=2"
                                        style="font-size: 12px !important;display: block;text-align: center;margin: 0 20px"
                                >
                                        ${store.name}
                                </a>
                            </div>
                        </article>
                    </div>
                </c:forEach>
            </div>
        </section>
    </div>

    <section class=" container">
        <div class="row">
            <h2 class="h3 g-color-black mb-0 index_h2 col-lg-4">Top Coupons</h2>
        </div>
        <div class="row">
            <c:forEach items="${topCouponList}" var="coupon">
                <div class="col-6  col-lg-6 "
                     style="margin-bottom: 10px!important;padding-left: 20px; padding-right: 20px;">
                    <article class="u-shadow-v19 media g-bg-white rounded g-pa-20 g-pb-10">
                        <div class="media-body text-center row">
                            <div class="col-lg-3" style="border-right: 1px solid #ececec">
                                <a href="${basePath}/yellow/storeDetail?storeId=${coupon.storeId}&siteId=2">
                                    <img src="${coupon.storeLogo}"
                                         style="width: 100%;border:1px solid #efefef" alt="${coupon.name}"/>
                                </a>
                            </div>
                            <div class="col-lg-9 "
                                 style="text-align: left;padding-left: 0 !important;padding-right: 0 !important;">
                                <div style="height: 50px;">
                                    <h3 class="g-color-black g-font-size-17 col-lg-12">
                                        <a
                                                target="_blank"
                                                rel="nofollow"
                                                href=""
                                                class="g-color-black  g-text-underline--none--hover get_code"
                                                url="${basePath}/yellow/storeDetail?storeId=${coupon.storeId}&siteId=2"
                                                style="font-weight: 600;font-size: 16px;"
                                        >
                                                ${coupon.name}
                                        </a>
                                    </h3>
                                </div>
                                <div class="align-self-center">
                                    <div class="col-lg-4">
                                        <a class="btn-block u-btn-primary  get_code" rel="nofollow"
                                           href="./storeDetail.html/?c=4399#get_code_4399" target="_blank" url="xxx">
                                            <c:choose>
                                                <c:when test="${coupon.couponType == 'CODE'}">
                                                    <p class="get_code_p">
                                                        WELCOME
                                                    </p>

                                                    <div class="get_code  get_code_btn" url="${coupon.storeWebSite}">
                                                        Get Code
                                                    </div>

                                                </c:when>
                                                <c:otherwise>
                                                    <p class="get_code_p"></p>
                                                    <div class="get_code  get_code_btn_deal"
                                                         url="${coupon.storeWebSite}">
                                                        Get Deal
                                                    </div>
                                                </c:otherwise>
                                            </c:choose>

                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </article>
                </div>
            </c:forEach>

        </div>
    </section>

    <section class="container g-pb-40 ">
        <div class="row">
            <h2 class="h3 g-color-black index_h2 col-lg-4">Top Categories</h2>
        </div>

        <div class="row  g-bg-white"
             style="justify-content:center; padding: 42px 0;margin:0 10px;overflow: hidden;width:102%">
            <div class="col-4 col-lg-5ths g-mb-0 " style="padding:0">
                <c:forEach var="i" begin="0" end="${categoryList.size()}" step="5">
                    <c:if test="${i < categoryList.size()}">
                        <a class="top_cate_a" href="${basePath}/yellow/categoryDetail?pageNumber=1&pageSize=10&siteId=1&id=${categoryList.get(i).id}&name=${categoryList.get(i).name}">
                            <span class="row  top_cate_item_icon"
                                  style="justify-content:center;align-items:center;width:100%;margin: 0">
                              <i class="fa icon-clothes-027 icon-clothes-027 u-line-icon-pro" style="color:#808080"></i>
                            </span>
                            <p class=" row align-items-center" style="justify-content:center;color: #5d5d5d">
                                    ${categoryList.get(i).name}
                            </p>
                        </a>
                    </c:if>
                </c:forEach>
            </div>
            <div class="col-4 col-lg-5ths g-mb-0 " style="padding:0">
                <c:forEach var="i" begin="1" end="${categoryList.size()}" step="5">
                    <c:if test="${i < categoryList.size()}">
                        <a class="top_cate_a"
                           href="${basePath}/yellow/categoryDetail?pageNumber=1&pageSize=10&siteId=1&id=${categoryList.get(i).id}&name=${categoryList.get(i).name}">
                            <span class="row  top_cate_item_icon"
                                  style="justify-content:center;align-items:center;width:100%;margin: 0">
                              <i class="fa icon-clothes-027 icon-clothes-027 u-line-icon-pro" style="color:#808080"></i>
                            </span>
                            <p class=" row align-items-center" style="justify-content:center;color: #5d5d5d">
                                    ${categoryList.get(i).name}
                            </p>
                        </a>
                    </c:if>
                </c:forEach>
            </div>

            <div class="col-4 col-lg-5ths g-mb-0 " style="padding:0">
                <c:forEach var="i" begin="2" end="${categoryList.size()}" step="5">
                    <%--<div>${i < categoryList.size()}</div>--%>
                    <c:if test="${i < categoryList.size()}">
                        <a class="top_cate_a"
                           href="${basePath}/yellow/categoryDetail?pageNumber=1&pageSize=10&siteId=1&id=${categoryList.get(i).id}&name=${categoryList.get(i).name}">
                            <span class="row  top_cate_item_icon"
                                  style="justify-content:center;align-items:center;width:100%;margin: 0">
                              <i class="fa icon-clothes-027 icon-clothes-027 u-line-icon-pro" style="color:#808080"></i>
                            </span>
                            <p class=" row align-items-center" style="justify-content:center;color: #5d5d5d">
                                    ${categoryList.get(i).name}
                            </p>
                        </a>
                    </c:if>
                </c:forEach>

            </div>

            <div class="col-4 col-lg-5ths g-mb-0 " style="padding:0">
                <c:forEach var="i" begin="3" end="${categoryList.size()}" step="5">
                    <c:if test="${i < categoryList.size()}">
                        <a class="top_cate_a"
                           href="${basePath}/yellow/categoryDetail?pageNumber=1&pageSize=10&siteId=1&id=${categoryList.get(i).id}&name=${categoryList.get(i).name}">
                            <span class="row  top_cate_item_icon"
                                  style="justify-content:center;align-items:center;width:100%;margin: 0">
                              <i class="fa icon-clothes-027 icon-clothes-027 u-line-icon-pro" style="color:#808080"></i>
                            </span>
                            <p class=" row align-items-center" style="justify-content:center;color: #5d5d5d">
                                    ${categoryList.get(i).name}
                            </p>
                        </a>
                    </c:if>
                </c:forEach>
            </div>

            <div class="col-4 col-lg-5ths g-mb-0 " style="padding:0">
                <c:forEach var="i" begin="4" end="${categoryList.size()}" step="5">
                    <c:if test="${i < categoryList.size()}">
                        <a class="top_cate_a"
                           href="${basePath}/yellow/categoryDetail?pageNumber=1&pageSize=10&siteId=1&id=${categoryList.get(i).id}&name=${categoryList.get(i).name}">
                        <span class="row  top_cate_item_icon"
                              style="justify-content:center;align-items:center;width:100%;margin: 0">
                        <i class="fa icon-clothes-027 icon-clothes-027 u-line-icon-pro" style="color:#808080"></i>
                        </span>
                            <p class=" row align-items-center" style="justify-content:center;color: #5d5d5d">
                                    ${categoryList.get(i).name}
                            </p>
                        </a>
                    </c:if>
                </c:forEach>
            </div>


        </div>
    </section>
</div>

<!-- footer -->
<%@ include file="footer.jsp" %>
<!-- jQuery popper bootstrap typeahead -->
<script src="${basePath}/static/js/yellow/custom.js"></script>
</body>
</html>
