<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/public.jsp"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="keywords" content="keywords" />
    <meta name="description" content="description" />
    <meta name="google-site-verification" content="AV6k9uxlDcEFufTdl0rM5Aetr5U9uvxCRcw0u3gYf8I" />
    <meta name="webgains-site-verification" content="ambcr9xy" />

    <title>绿站</title>
    <!-- bootstrap -->
    <%--<link rel="stylesheet" href="../static/css/bootstrap.min.css" />--%>
    <%--<link rel="stylesheet" href="../static/css/font-awesome.min.css" />--%>
    <link rel="stylesheet" href="${basePath}/static/css/green/custom.css" />

    <!-- Global site tag (gtag.js) - Google Analytics -->
    <%--<script async src="https://www.googletagmanager.com/gtag/js?id=UA-106211927-10"></script>--%>
    <%--<script async src="https://pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>--%>
    <script>
      (adsbygoogle = window.adsbygoogle || []).push({
        google_ad_client: 'ca-pub-2669162039689132',
        enable_page_level_ads: true
      });
    </script>
    <script>
      window.dataLayer = window.dataLayer || [];
      function gtag() {
        dataLayer.push(arguments);
      }
      gtag('js', new Date());

      gtag('config', 'UA-106211927-10');
    </script>
  </head>
  <body>
    <!-- Header -->
    <header id="js-header" class="js-site-header u-header mb-2 mb-lg-0">
      <nav class="navbar navbar-expand-lg">
        <div class="container">
          <!-- Logo -->
          <a href="./index.jsp" class="navbar-brand mr-4">
            <!-- TODO 更换真实的 logo url -->
            <img alt="cannabis coupons - cannabispromocodes.com" src="${basePath}/static/common/img/cannabis.jpg" />
          </a>
          <!-- End Logo -->

          <!-- Navigation -->
          <div class="flex-grow-1">
            <ul class="navbar-nav justify-content-end ">
              <li class="nav-item-top-stores  nav-item ml-0 d-none d-lg-inline-block">
                <div class="nav-link">
                  <a href="./store.html" style="text-decoration: none;color: #151515;font-size: 15px;font-weight: 500;line-height: 35px">
                    Top Stores
                  </a>
                </div>
              </li>

              <li class="nav-item nav-item-category  d-none d-lg-inline-block">
                <div class="nav-link">
                  <a href="./category.html" style="text-decoration: none;color: #151515;font-size: 15px;font-weight: 500;line-height: 35px">
                    Categories
                  </a>
                </div>
                <ul class="list-group category-list">
                  <a href="./categoryDetail.html" class="list-group-item list-group-item-action">CBD</a
                  ><a href="./categoryDetail.html" class="list-group-item list-group-item-action">Cannabis Seeds</a
                  ><a href="./categoryDetail.html" class="list-group-item list-group-item-action">Dabbing tools</a
                  ><a href="./categoryDetail.html" class="list-group-item list-group-item-action">Growing equipment</a
                  ><a href="./categoryDetail.html" class="list-group-item list-group-item-action">Smoking tools</a
                  ><a href="./categoryDetail.html" class="list-group-item list-group-item-action">Vaporizers</a>
                </ul>
              </li>

              <li class="nav-item nav-item__search">
                <form class="js-head-search-form">
                  <!-- Search Field -->
                  <div class="input-group">
                    <input
                      type="search"
                      class="js-search__input form-control"
                      placeholder="Search for stores, offers or brands"
                      data-provide="typeahead"
                      required=""
                      autocomplete="off"
                      aria-label="Search for stores, offers or brands"
                      name="search"
                    />
                    <input style="display:none" />
                    <button class="btn" type="button"><i class="fa fa-search"></i></button>
                  </div>
                  <!-- End Search Field -->
                </form>
              </li>
            </ul>
          </div>
          <!-- End Navigation -->
        </div>

        <!-- for mobile -->
        <div class="container d-flex d-lg-none">
          <nav class="nav mobile-nav">
            <a href="./index.jsp" class="nav-item-home nav-link active">Home</a>
            <a href="./store.html" class="nav-item-top-stores nav-link">Top Stores</a>
            <a href="./topCoupon.html" class="nav-item-top-coupons nav-link">Top Coupons</a>
            <a href="./category.html" class="nav-item-category nav-link">Category</a>
          </nav>
        </div>
      </nav>
    </header>
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
      <section class="container-fluid search-banner d-none d-md-block" style="background-image: url(${basePath}/static/common/img/search-bg.jpg)">
        <div class="row justify-content-center align-items-center">
          <div class="col-lg-12">
            <!-- Search Field -->
            <h1 class="" style="font-size: 38px;color: #fff; letter-spacing: 0;text-align: center;margin-bottom: 18px">Various Cannabis Coupon Codes Online all Web</h1>

            <div class="input-group input-group-lg">
              <input
                type="search"
                class="js-search__input form-control"
                placeholder="Search for stores, offers or brands"
                data-provide="typeahead"
                required=""
                autocomplete="off"
                aria-label="Search for stores, offers or brands"
                name="search"
              />
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
                <a class="store-grid-item cover-wrap" href="./storeDetail.html">
                  <div class="cover">
                    <img src="${store.logoUrl}" class="align-self-center" alt="${store.name}" title="${store.title}" />
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
                    <a class="cover-wrap position-relative" href="./storeDetail.html">
                      <div class="cover">
                        <img src="${coupon.storeLogo}" alt="${coupon.name}" />
                      </div>

                      <span class="coupon-label coupon-label--deal">DEAL</span>
                    </a>
                  </div>

                  <div class="info-box col-9 col-sm-12 d-flex flex-wrap align-content-between">
                    <a target="_self" rel="nofollow" url="" class="get_deal coupon-title text-left text-sm-center" href="./storeDetail.html">
                      <h3>${coupon.name}</h3>
                    </a>

                    <div class="extra-info">
                      <span class="use-info"><i class="fa fa-user mr-1" aria-hidden="true"></i>0 USED</span>
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
            <a href="#top-categories-content" data-toggle="collapse" role="button" aria-expanded="false" class="collapsed" aria-controls="top-categories-content">
              <i class="fa fa-chevron-up d-inline d-sm-none float-right" aria-hidden="true"></i>
            </a>
          </h2>

          <div class="show visible-md">
            <div class="row">
              <c:forEach items="${categoryList}" var="category">
                <div class="col-12 col-sm-4 col-md-3 col-lg-2 p-sm-2">
                  <div class="category-item">
                    <a class="category-title" href="./categoryDetail.html">
                      <p>${category.name}</p>
                    </a>
                  </div>
                </div>
              </c:forEach>
            </div>
          </div>

          <div id="top-categories-content" class="collapse">
            <div class="row">
              <div class="col-12 col-sm-4 col-md-3 col-lg-2 p-sm-2">
                <div class="category-item">
                  <a class="category-title" href="./categoryDetail.html">
                    <p>CBD</p>
                  </a>
                </div>
              </div>

              <div class="col-12 col-sm-4 col-md-3 col-lg-2 p-sm-2">
                <div class="category-item">
                  <a class="category-title" href="./categoryDetail.html">
                    <p>Cannabis Seeds</p>
                  </a>
                </div>
              </div>

              <div class="col-12 col-sm-4 col-md-3 col-lg-2 p-sm-2">
                <div class="category-item">
                  <a class="category-title" href="./categoryDetail.html">
                    <p>Dabbing tools</p>
                  </a>
                </div>
              </div>

              <div class="col-12 col-sm-4 col-md-3 col-lg-2 p-sm-2">
                <div class="category-item">
                  <a class="category-title" href="./categoryDetail.html">
                    <p>Growing equipment</p>
                  </a>
                </div>
              </div>

              <div class="col-12 col-sm-4 col-md-3 col-lg-2 p-sm-2">
                <div class="category-item">
                  <a class="category-title" href="./categoryDetail.html">
                    <p>Smoking tools</p>
                  </a>
                </div>
              </div>

              <div class="col-12 col-sm-4 col-md-3 col-lg-2 p-sm-2">
                <div class="category-item">
                  <a class="category-title" href="./categoryDetail.html">
                    <p>Vaporizers</p>
                  </a>
                </div>
              </div>
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
            <a href="#popular-store-content" data-toggle="collapse" role="button" aria-expanded="false" class="collapsed" aria-controls="popular-store-content">
              <i class="fa fa-chevron-up d-inline d-sm-none float-right" aria-hidden="true"></i>
            </a>
          </h2>

          <div class="popular-store-content show visible-md">
            <div class="row">

              <c:forEach items="${popularStoreList}" var="popularStore">
                <div class="store-name-wrap col-12 col-md-4 col-lg-5-1 mb-3 mb-md-4">
                  <a href="./storeDetail.html">${popularStore.name}</a>
                </div>
              </c:forEach>
              <%--<div class="store-name-wrap col-12 col-md-4 col-lg-5-1 mb-3 mb-md-4">--%>
                <%--<a href="./storeDetail.html">Dr. Hemps CBD</a>--%>
              <%--</div>--%>

              <%--<div class="store-name-wrap col-12 col-md-4 col-lg-5-1 mb-3 mb-md-4">--%>
                <%--<a href="./storeDetail.html">LED Grow Lights Depot</a>--%>
              <%--</div>--%>

              <%--<div class="store-name-wrap col-12 col-md-4 col-lg-5-1 mb-3 mb-md-4">--%>
                <%--<a href="./storeDetail.html">Quebec Cannabis Seeds</a>--%>
              <%--</div>--%>

              <%--<div class="store-name-wrap col-12 col-md-4 col-lg-5-1 mb-3 mb-md-4">--%>
                <%--<a href="./storeDetail.html">DopeBoo</a>--%>
              <%--</div>--%>

              <%--<div class="store-name-wrap col-12 col-md-4 col-lg-5-1 mb-3 mb-md-4">--%>
                <%--<a href="./storeDetail.html">NewVape</a>--%>
              <%--</div>--%>

              <%--<div class="store-name-wrap col-12 col-md-4 col-lg-5-1 mb-3 mb-md-4">--%>
                <%--<a href="./storeDetail.html">Growers Choice Seeds</a>--%>
              <%--</div>--%>

              <%--<div class="store-name-wrap col-12 col-md-4 col-lg-5-1 mb-3 mb-md-4">--%>
                <%--<a href="./storeDetail.html">Ali Bongo</a>--%>
              <%--</div>--%>
              <%--<div class="store-name-wrap col-12 col-md-4 col-lg-5-1 mb-3 mb-md-4">--%>
                <%--<a href="./storeDetail.html">Dr. Hemps CBD</a>--%>
              <%--</div>--%>

              <%--<div class="store-name-wrap col-12 col-md-4 col-lg-5-1 mb-3 mb-md-4">--%>
                <%--<a href="./storeDetail.html">LED Grow Lights Depot</a>--%>
              <%--</div>--%>

              <%--<div class="store-name-wrap col-12 col-md-4 col-lg-5-1 mb-3 mb-md-4">--%>
                <%--<a href="./storeDetail.html">Quebec Cannabis Seeds</a>--%>
              <%--</div>--%>

              <%--<div class="store-name-wrap col-12 col-md-4 col-lg-5-1 mb-3 mb-md-4">--%>
                <%--<a href="./storeDetail.html">DopeBoo</a>--%>
              <%--</div>--%>

              <%--<div class="store-name-wrap col-12 col-md-4 col-lg-5-1 mb-3 mb-md-4">--%>
                <%--<a href="./storeDetail.html">NewVape</a>--%>
              <%--</div>--%>

              <%--<div class="store-name-wrap col-12 col-md-4 col-lg-5-1 mb-3 mb-md-4">--%>
                <%--<a href="./storeDetail.html">Growers Choice Seeds</a>--%>
              <%--</div>--%>

              <%--<div class="store-name-wrap col-12 col-md-4 col-lg-5-1 mb-3 mb-md-4">--%>
                <%--<a href="./storeDetail.html">Ali Bongo</a>--%>
              <%--</div>--%>
              <%--<div class="store-name-wrap col-12 col-md-4 col-lg-5-1 mb-3 mb-md-4">--%>
                <%--<a href="./storeDetail.html">Dr. Hemps CBD</a>--%>
              <%--</div>--%>

              <%--<div class="store-name-wrap col-12 col-md-4 col-lg-5-1 mb-3 mb-md-4">--%>
                <%--<a href="./storeDetail.html">LED Grow Lights Depot</a>--%>
              <%--</div>--%>

              <%--<div class="store-name-wrap col-12 col-md-4 col-lg-5-1 mb-3 mb-md-4">--%>
                <%--<a href="./storeDetail.html">Quebec Cannabis Seeds</a>--%>
              <%--</div>--%>

              <%--<div class="store-name-wrap col-12 col-md-4 col-lg-5-1 mb-3 mb-md-4">--%>
                <%--<a href="./storeDetail.html">DopeBoo</a>--%>
              <%--</div>--%>

              <%--<div class="store-name-wrap col-12 col-md-4 col-lg-5-1 mb-3 mb-md-4">--%>
                <%--<a href="./storeDetail.html">NewVape</a>--%>
              <%--</div>--%>

              <%--<div class="store-name-wrap col-12 col-md-4 col-lg-5-1 mb-3 mb-md-4">--%>
                <%--<a href="./storeDetail.html">Growers Choice Seeds</a>--%>
              <%--</div>--%>

              <%--<div class="store-name-wrap col-12 col-md-4 col-lg-5-1 mb-3 mb-md-4">--%>
                <%--<a href="./storeDetail.html">Ali Bongo</a>--%>
              <%--</div>--%>
            </div>
          </div>

          <div id="popular-store-content" class="popular-store-content collapse">
            <div class="row">
              <div class="store-name-wrap col-12 col-md-4 col-lg-5-1 mb-3 mb-md-4">
                <a href="./storeDetail.html">Dr. Hemps CBD</a>
              </div>

              <div class="store-name-wrap col-12 col-md-4 col-lg-5-1 mb-3 mb-md-4">
                <a href="./storeDetail.html">LED Grow Lights Depot</a>
              </div>

              <div class="store-name-wrap col-12 col-md-4 col-lg-5-1 mb-3 mb-md-4">
                <a href="./storeDetail.html">Quebec Cannabis Seeds</a>
              </div>

              <div class="store-name-wrap col-12 col-md-4 col-lg-5-1 mb-3 mb-md-4">
                <a href="./storeDetail.html">DopeBoo</a>
              </div>

              <div class="store-name-wrap col-12 col-md-4 col-lg-5-1 mb-3 mb-md-4">
                <a href="./storeDetail.html">NewVape</a>
              </div>

              <div class="store-name-wrap col-12 col-md-4 col-lg-5-1 mb-3 mb-md-4">
                <a href="./storeDetail.html">Growers Choice Seeds</a>
              </div>

              <div class="store-name-wrap col-12 col-md-4 col-lg-5-1 mb-3 mb-md-4">
                <a href="./storeDetail.html">Ali Bongo</a>
              </div>

              <div class="store-name-wrap col-12 col-md-4 col-lg-5-1 mb-3 mb-md-4">
                <a href="./storeDetail.html">Hippie Butler</a>
              </div>

              <div class="store-name-wrap col-12 col-md-4 col-lg-5-1 mb-3 mb-md-4">
                <a href="./storeDetail.html">BadassGlass</a>
              </div>

              <div class="store-name-wrap col-12 col-md-4 col-lg-5-1 mb-3 mb-md-4">
                <a href="./storeDetail.html">Cannastick</a>
              </div>
            </div>
          </div>
        </section>
      </div>
      <!-- End Top Stores -->
    </div>

    <!-- Footer -->
    <div class="js-site-footer site-footer">
      <div class="container pt-md-5 pt-3">
        <div class="row">
          <!-- Footer Content -->
          <div class="col-md-3 col-12 mb-4 d-none d-md-block">
            <a rel="nofollow">
              <img class="img-fluid logo" alt="Cannabis Promo Codes" src="${basePath}/static/common/img/cannabis.jpg" />
            </a>
            <!-- <p>Help you get best deal.</p> -->
          </div>
          <!-- End Footer Content -->

          <!-- Footer Content -->
          <div class="col-md-3 col-6 mb-4">
            <p>Cannabispromocodes.com</p>

            <ul>
              <li><a rel="nofollow" class="link" href="./about.html">About us</a></li>
              <li><a rel="nofollow" class="" href="./contact.html">Contact us</a></li>
            </ul>
          </div>
          <!-- End Footer Content -->

          <!-- Footer Content -->
          <div class="col-md-3 col-6 mb-4">
            <p class="">Sitemap</p>

            <ul>
              <li><a rel="nofollow" class="" href="">Home</a></li>
              <li><a rel="nofollow" class="" href="./store.html">Stores</a></li>
            </ul>
          </div>
          <!-- End Footer Content -->

          <!-- Footer Content -->
          <div class="col-md-3 col-12 mb-4">
            <p>Our Contacts</p>

            <address class="">
              <p class="mb-0">552 Franklin Street, Orange California, US</p>
              <a rel="nofollow" href="mailto:cannabispromocodes@gmail.com" class=""><i class="fa fa-envelope-o mr-1"></i> cannabispromocodes@gmail.com</a>
            </address>
          </div>
          <!-- End Footer Content -->
        </div>
      </div>
      <!-- End Footer -->

      <!-- Copyright Footer -->
      <footer class="site-copyright container-wrap">
        <div class="container">
          <div class="row">
            <div class="col-8 col-md-6 px-0 px-md-4">
              <div class="text-right">
                <small class="">Copyright @ 2019. All Rights Reserved.</small>
              </div>
            </div>

            <div class="col-4 col-md-6">
              <ul class="list-inline m-0 text-left">
                <li class="list-inline-item mr-3 mr-md-5" data-toggle="tooltip" data-placement="top" title="" data-original-title="Facebook">
                  <a href="https://www.facebook.com/CPA-136028583717425/" rel="nofollow" class="g-color-white-opacity-0_5 g-color-white--hover">
                    <i class="fa fa-facebook"></i>
                  </a>
                </li>
                <li class="list-inline-item" data-toggle="tooltip" data-placement="top" title="" data-original-title="Twitter">
                  <a href="https://twitter.com/CouponPa" rel="nofollow" class="g-color-white-opacity-0_5 g-color-white--hover">
                    <i class="fa fa-twitter"></i>
                  </a>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </footer>
      <!-- End Copyright Footer -->

      <a
        rel="nofollow"
        class="js-go-to u-go-to-top u-go-to-v1 animated"
        href="#"
        data-type="fixed"
        data-position='{
                    "bottom": 15,
                    "right": 15
                  }'
        data-offset-top="400"
        data-compensation="#js-header"
        data-show-effect="zoomIn"
        style="display: inline-block; position: fixed; opacity: 0; bottom: 15px; right: 15px;"
      >
        <i class="fa fa-angle-up"></i>
      </a>
    </div>
    <!-- jQuery popper bootstrap typeahead -->
    <%--<script src="../static/js/base.js"></script>--%>
    <%--<script src="../static/js/hs.core.js"></script>--%>
    <%--<script src="../static/js/hs.go-to.js"></script>--%>
    <script src="${basePath}/static/js/green/custom.js"></script>
  </body>
</html>
