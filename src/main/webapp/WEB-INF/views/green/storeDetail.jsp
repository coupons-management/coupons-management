<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../common/public.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="keywords" content="${storeDetail.keyWords}"/>
    <meta name="description" content="${storeDetail.description}"/>
    <meta name="google-site-verification" content="AV6k9uxlDcEFufTdl0rM5Aetr5U9uvxCRcw0u3gYf8I"/>
    <meta name='webgains-site-verification' content='ambcr9xy'/>
    <title>${storeDetail.title}</title>
    <!-- bootstrap -->
    <link rel="stylesheet" href="${basePath}/static/css/green/custom.css"/>
</head>
<%
    request.setAttribute("coupon_type", (request.getParameter("coupon_type") == null || request.getParameter("coupon_type") == "") ? null : request.getParameter("coupon_type"));
%>
<body>
<!-- Header -->
<%@ include file="header.jsp" %>
<!-- End Header -->


<div class="js-site-main site-main">
    <c:if test="${coupon != null}">
        <div class="modal fade store-detail-modal js-modal get_code_121525 show" id="exampleModalCenter" tabindex="-1"
             role="dialog" aria-labelledby="exampleModalCenterTitle" style="margin: 20px;position: absolute;top: 30%;display: none;">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-body" style="padding: 30px;">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">×</span>
                        </button>
                        <div class="row">
                            <div class="col-12 col-md-3 d-flex justify-content-center align-items-center">
                                <a class="cover"
                                   href="${basePath}/green/store/${fn:replace(fn:replace(fn:replace(storeDetail.website,'www.',''),'http://',''),'https://','')}">
                                   <%--href="${basePath}/green/storeDetail?storeId=${coupon.storeId}&siteId=1">--%>
                                    <img alt="${coupon.name}"
                                         src="${coupon.storeLogo}">
                                </a>
                            </div>
                            <div class="text-content col-12 col-md-9">
                                <p class="coupon-title" style="font-size: 1.75rem">${coupon.description}</p>
                                <p class="coupon-source">
                                    <span style="color: #7D7D7D;" class="mr-1">${coupon.storeName}</span>
                                    <a style="color: #269AC8;font-size: 12px;" rel="nofollow"
                                       href="${storeDetail.website}">
                                            ${fn:replace(fn:replace(fn:replace(storeDetail.website,'www.',''),'http://',''),'https://','')}
                                    </a>
                                </p>
                                <c:choose>
                                    <c:when test="${coupon.couponType=='CODE'}">
                                        <div class="code-box">
                                            <p>${coupon.code}</p>
                                            <button class="btn copy_code" id="copy_code"
                                                    data-clipboard-text="${coupon.code}">
                                                COPY<span class="d-none d-md-inline"> CODE</span>
                                            </button>
                                        </div>
                                        <p class="n-people-used">11 people used</p>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="link-box">
                                            <a href="${storeDetail.advertising}" class="btn">
                                                GO TO WEBSITE
                                            </a>
                                            <p class="n-people-used d-block d-md-none">3 people used</p>
                                        </div>
                                    </c:otherwise>
                                </c:choose>


                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </c:if>

    <section class="page-title-banner ">
        <div class="container store-info-container">
            <div class="row">
                <!-- Profle Content -->
                <div class="col-lg-2 col-md-3 col-5 d-flex align-items-center">
                    <!-- Store Image -->
                    <div class="store-brand cover-wrap">
                        <a class="cover" href="${storeDetail.advertising}"
                           target="_blank" rel="nofollow">
                            <img class="img-fluid" src="${storeDetail.logo}" alt="${storeDetail.name} coupons">
                        </a>
                    </div>
                </div>
                <div class="col-lg-8 col-md-9 col-7 d-flex d-lg-block align-items-center">
                    <h1 class="store-name">${storeDetail.showName}</h1>
                    <p class="store-description d-none d-lg-block">${storeDetail.storeDescription}</p>

                    <div class="d-none d-lg-block">
                      <span class="store-info-item">
                      <em>${storeDetail.couponCount}</em> Offers Available
                      </span>
                      <!-- <span class="store-info-item">
                      <em>2</em> Verified Coupons
                      </span> -->
                      <span class="store-info-item">
                      <em>${codeCnt}</em> Coupon Codes
                      </span>
                      <span class="store-info-item">
                      <em>${dealCnt}</em> Sales
                      </span>
                      <span class="store-info-item">
                        ${storeDetail.lastUpdateTime}
                      </span>
                    </div>
                    <!-- Project Progress -->
                </div>
                <div class="col-lg-2 d-none d-lg-flex align-items-end justify-content-end">
                    <a class="visit-btn" href="${storeDetail.advertising}" target="_blank" rel="nofollow">Visit Website</a>
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
                                       href="${basePath}/green/store/${fn:replace(fn:replace(fn:replace(store.webSite,'www.',''),'http://',''),'https://','')}">
                                        <div class="cover">
                                            <img class="img-fluid"
                                                 style="height: 96px;max-width: 100%;max-height: 100%;"
                                                 alt="${store.name} coupons" src="${store.logoUrl}">
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
                            <button id="type_all"
                                    class="btn btn-sm btn-all <c:if test="${coupon_type == null || coupon_type =='all'}">btn-active</c:if> ">
                                    <%--url="${basePath}/green/storeDetail?storeId=${storeDetail.storeId}&siteId=1">--%>
                                All<span class="d-none d-md-inline">  Offers</span>
                            </button>
                            <button id="type_code"
                                    class="btn btn-sm  btn-code <c:if test="${coupon_type == 'CODE'}">btn-active</c:if>">
                                    <%--url="${basePath}/green/storeDetail?storeId=${storeDetail.storeId}&siteId=1&coupon_type=CODE">--%>
                                <span class="d-none d-md-inline">Coupon </span>Codes
                            </button>
                            <button id="type_deal"
                                    class="btn btn-sm  btn-deal <c:if test="${coupon_type == 'DEAL'}">btn-active</c:if>">
                                    <%--url="${basePath}/green/storeDetail?storeId=${storeDetail.storeId}&siteId=1&coupon_type=DEAL">--%>
                                Deals
                            </button>
                            <!-- <button id="type_verify" class="btn btn-sm  btn-verify">
                                <i class="fa fa-shield d-inline d-md-none" aria-hidden="true"></i>
                                <div class="custom-check-box d-none d-md-block">
                                    <input type="checkbox" id="verify-2">
                                    <label for="verify-2">
                                        <i class="fa fa-check" aria-hidden="true"></i>
                                        VERIFIED 2
                                    </label>
                                </div>
                            </button> -->
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-12">
                            <!-- User Block -->
                            <c:forEach items="${storeDetail.couponList.list}" var="coupon">
                                <div class="box d-flex my-2 my-sm-3" data-coupon-type="${coupon.couponType}">
                                    <div class="offer d-none d-sm-block">
                                        <div class="offer-anchor d-flex flex-column justify-content-center align-items-center"
                                             style="max-height: 100px">
                                            <!-- TODO 将 30% off 替换为真实的值 这里先不换, 具体规则未定-->
                                            <span class="offer-anchor-text">${coupon.sale}</span>
                                            <span class="label ${coupon.couponType == 'CODE' ? 'code' : 'deal'}">${coupon.couponType}</span>
                                        </div>
                                    </div>

                                    <div class="detail-info">
                                        <a class="get_code" url="${storeDetail.advertising}" href="${basePath}/green/store/${fn:replace(fn:replace(fn:replace(storeDetail.website,'www.',''),'http://',''),'https://','')}?c=${coupon.id}#get_code_${coupon.id}"
                                           target="_blank"
                                           rel="nofollow">
                                            <h3 class="paddl">
                                            <span class="label ${coupon.couponType == 'CODE' ? 'code' : 'deal'} d-inline d-sm-none">
                                            ${coupon.couponType}</span>${coupon.title}
                                            </h3>
                                        </a>
                                        <c:if test="${not empty storeDetail.storeDescription}">
                                          <p class="coupon-description">${storeDetail.storeDescription}</p>
                                        </c:if>
                                        <div class="foot">
                        <span class="use-info d-inline d-sm-none"><i class="fa fa-user mr-1" aria-hidden="true"></i>

                                19

                             USED</span>
                                        </div>

                                        <c:choose>
                                            <c:when test="${coupon.couponType == 'CODE'}">
                                                <a href="${basePath}/green/store/${fn:replace(fn:replace(fn:replace(storeDetail.website,'www.',''),'http://',''),'https://','')}?c=${coupon.id}#get_code_${coupon.id}"
                                                   rel="nofollow" class="get_code"
                                                   data-id="120705" data-clipboard-text="save10" target="_blank"
                                                   url="${storeDetail.advertising}">
                                                    <div class="coupon-hop">
                                                        <div class="partial-code">${(coupon.code != null && coupon.code != "") ? coupon.code.substring(coupon.code.length()-1):""}</div>
                                                        <div class="hide-btn d-flex align-items-center justify-content-center">
                                                <span>Show Code<br><small
                                                        class="d-none d-sm-inline">&amp; visit site</small></span>
                                                        </div>
                                                    </div>
                                                </a>
                                            </c:when>
                                            <c:otherwise>
                                                <a class="btn-get-deal get_deal" data-id="439552"
                                                   href="${basePath}/green/store/${fn:replace(fn:replace(fn:replace(storeDetail.website,'www.',''),'http://',''),'https://','')}?c=${coupon.id}#get_code_${coupon.id}"
                                                   rel="nofollow" target="_blank"
                                                   url="${storeDetail.advertising}">
                                                    GET DEAL
                                                </a>
                                            </c:otherwise>
                                        </c:choose>


                                    </div>
                                </div>
                            </c:forEach>
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
<script src="${basePath}/static/js/green/storeDetail.js"></script>
<script type="text/javascript" src="${basePath}/static/common/js/clipboard.min.js"></script>
</body>
</html>
<script>
    $(document).ready(function () {
        $('#exampleModalCenter').modal('show');
        var btn = new ClipboardJS('.copy_code', {
            container: document.getElementById('exampleModalCenter')
        });
        btn.on('success', function (e) {
            $('.copy_code').text('Copied!');
            $('.copy_code').removeClass('u-btn-primary').addClass('u-btn-blue');
        });
        $('.get_code,.get_deal').on('click', function () {
            var $this = $(this);

            var url = $this.attr('url');
            window.location.replace(url);

        });


        // $('#type_all,#type_code,#type_deal').on('click', function () {
        //     location.href = $(this).attr('url');
        // });


        //根据路由判断是否显示弹出层
        var coupon_id = null;

        var coupon_type = 'CODE',
            verify = 'False',
            name__icontains = '';
        $('#type_all').on('click', function () {
            coupon_type = 'all';
            location.href = '?coupon_type=all';
        });
        $('#type_code').on('click', function () {
            coupon_type = 'CODE';
            show_div(coupon_type, verify, name__icontains);
        });
        $('#type_deal').on('click', function () {
            coupon_type = 'DEAL';
            show_div(coupon_type, verify, name__icontains);
        });
        $('#type_verify').on('click', function () {
            var verify = !$('#type_verify').hasClass('btn-active');

            show_div(coupon_type, verify, name__icontains);
        });
        $('.search_input').keypress(function (e) {
            if (e.which === 13 || e.keyCode == 13) {
                name__icontains = $('.search_input').val();
                show_div(coupon_type, verify, name__icontains);
            }
        });

        function show_div(coupon_type, verify, name__icontains) {
            location.href = '?coupon_type=' + coupon_type + '&verify=' + verify + '&name__icontains=' + name__icontains
        }


        // $('.get_code,.get_deal').on('click', function () {
        //     var $this = $(this);
        //
        //     var url = $this.attr('url');
        //     var newWindow = window.open(url);
        //     var itemId = $this.data('id');
        //     if (coupon_id && itemId == coupon_id) {
        //         $('.js-modal').modal && $('.js-modal').modal();
        //     } else {
        //         newWindow.location = url;
        //     }
        // });

        // var btn = new ClipboardJS('.copy_code', {
        //     container: document.getElementById('exampleModalCenter')
        // });
        // btn.on('success', function (e) {
        //     $('.copy_code').text('Copied!');
        //     $('.copy_code').removeClass('u-btn-primary').addClass('u-btn-blue');
        // });
        // $('.copy_code').on('click', function () {
        //     $(this).text('Copied!');
        //     $(this).removeClass('u-btn-primary').addClass('u-btn-blue');
        // });

        // 弹框中的 copy code 按钮

        // 列表中的 get code 按钮
        // new ClipboardJS(".get_code");


    })
</script>