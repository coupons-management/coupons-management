<header id="js-header" class="js-site-header u-header mb-2 mb-lg-0">
    <nav class="navbar navbar-expand-lg">
        <div class="container">
            <!-- Logo -->
            <a href="${basePath}/green/" class="navbar-brand mr-4">
                <!-- TODO 更换真实的 logo url -->
                <img alt="cannabis coupons - cannabispromocodes.com" src="${basePath}/static/common/img/cannabis.jpg"/>
            </a>
            <!-- End Logo -->

            <!-- Navigation -->
            <div class="flex-grow-1">
                <ul class="navbar-nav justify-content-end ">
                    <li class="nav-item-top-stores  nav-item ml-0 d-none d-lg-inline-block ${isStore?'active':'' }">
                        <div class="nav-link">
                            <a href="${basePath}/green/store/"
                               style="text-decoration: none;color: #151515;font-size: 15px;font-weight: 500;">
                                Top Stores
                            </a>
                        </div>
                    </li>

                    <li class="nav-item nav-item-category  d-none d-lg-inline-block ${isCategory?'active':'' }">
                        <div class="nav-link">
                            <a href="${basePath}/green/category/"
                               style="text-decoration: none;color: #151515;font-size: 15px;font-weight: 500;">
                                Categories
                            </a>
                        </div>
                        <ul class="list-group category-list">
                          <c:forEach items="${categoryList}" var="category">
                              <a href="${basePath}/green/category/${category.name}/" class="list-group-item list-group-item-action">${category.name}</a>
                          </c:forEach>
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
                                        id="header_search_input"
                                />
                                <input style="display:none"/>
                                <ul class="typeahead dropdown-menu" role="listbox" id="header_search_ul"
                                    style="top: 34px; left: 0px; display: none;">
                                    <%--<li class="">--%>
                                        <%--<a class="dropdown-item" href="#" role="option">--%>
                                            <%--<div class="typeahead search-result">--%>
                                                <%--<div class="img-text-wrap">--%>
                                                    <%--<img src="/static/media/spider/good_search/Pure Hemp Botanicals.png"--%>
                                                         <%--class="pic">--%>
                                                    <%--<div><strong>Pure Hemp Botanicals</strong> -- Store</div>--%>
                                                <%--</div>--%>
                                                <%--<p class="count">5 offers</p>--%>
                                            <%--</div>--%>
                                        <%--</a>--%>
                                    <%--</li>--%>
                                    <%--<li><a class="dropdown-item" href="#" role="option">--%>
                                        <%--<div class="typeahead search-result">--%>
                                            <%--<div class="img-text-wrap">--%>
                                                <%--<img src="/static/media/spider/good_search/Pure Relief.png" class="pic">--%>
                                                <%--<div><strong>Pure Relief</strong> -- Store</div>--%>
                                            <%--</div>--%>
                                            <%--<p class="count">18 offers</p>--%>
                                        <%--</div>--%>
                                    <%--</a></li>--%>
                                    <%--<li><a class="dropdown-item" href="#" role="option">--%>
                                        <%--<div class="typeahead search-result">--%>
                                            <%--<div class="img-text-wrap">--%>
                                                <%--<img src="/static/media/spider/good_search/Physicians Grade CBD.png"--%>
                                                     <%--class="pic">--%>
                                                <%--<div><strong>Physicians Grade CBD</strong> -- Store</div>--%>
                                            <%--</div>--%>
                                            <%--<p class="count">5 offers</p>--%>
                                        <%--</div>--%>
                                    <%--</a></li>--%>
                                    <%--<li class=""><a class="dropdown-item" href="#" role="option">--%>
                                        <%--<div class="typeahead search-result">--%>
                                            <%--<div class="img-text-wrap">--%>
                                                <%--<img src="/static/media/spider/good_search/Provincial Farms.png"--%>
                                                     <%--class="pic">--%>
                                                <%--<div><strong>Provincial Farms</strong> -- Store</div>--%>
                                            <%--</div>--%>
                                            <%--<p class="count">12 offers</p>--%>
                                        <%--</div>--%>
                                    <%--</a></li>--%>
                                    <%--<li class=""><a class="dropdown-item" href="#" role="option">--%>
                                        <%--<div class="typeahead search-result">--%>
                                            <%--<div class="img-text-wrap">--%>
                                                <%--<img src="/static/media/spider/good_search/PuraHemp.png" class="pic">--%>
                                                <%--<div><strong>PuraHemp</strong> -- Store</div>--%>
                                            <%--</div>--%>
                                            <%--<p class="count">6 offers</p>--%>
                                        <%--</div>--%>
                                    <%--</a></li>--%>
                                    <%--<li class=""><a class="dropdown-item" href="#" role="option">--%>
                                        <%--<div class="typeahead search-result">--%>
                                            <%--<div><strong>CBD Topical</strong><span> -- Category</span></div>--%>
                                            <%--<p class="count">more stores</p>--%>
                                        <%--</div>--%>
                                    <%--</a></li>--%>
                                    <%--<li class="active"><a class="dropdown-item" href="#" role="option">--%>
                                        <%--<div class="typeahead search-result">--%>
                                            <%--<div><strong>CBD Capsules</strong><span> -- Category</span></div>--%>
                                            <%--<p class="count">more stores</p>--%>
                                        <%--</div>--%>
                                    <%--</a></li>--%>
                                    <%--<li><a class="dropdown-item" href="#" role="option">--%>
                                        <%--<div class="typeahead search-result">--%>
                                            <%--<div><strong>CBD Syrups</strong><span> -- Category</span></div>--%>
                                            <%--<p class="count">more stores</p>--%>
                                        <%--</div>--%>
                                    <%--</a></li>--%>
                                    <%--<li><a class="dropdown-item" href="#" role="option">--%>
                                        <%--<div class="typeahead search-result">--%>
                                            <%--<div><strong>CBD Oil for pets</strong><span> -- Category</span></div>--%>
                                            <%--<p class="count">more stores</p>--%>
                                        <%--</div>--%>
                                    <%--</a></li>--%>
                                    <%--<li><a class="dropdown-item" href="#" role="option">--%>
                                        <%--<div class="typeahead search-result">--%>
                                            <%--<div><strong>CBD Pain cream</strong><span> -- Category</span></div>--%>
                                            <%--<p class="count">more stores</p>--%>
                                        <%--</div>--%>
                                    <%--</a></li>--%>
                                </ul>
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
                <a href="${basePath}/green/" class="nav-item-home nav-link active">Home</a>
                <a href="${basePath}/green/store/" class="nav-item-top-stores nav-link">Top Stores</a>
                <a href="${basePath}/green/topcoupons" class="nav-item-top-coupons nav-link">Top Coupons</a>
                <a href="${basePath}/green/category/" class="nav-item-category nav-link">Category</a>
            </nav>
        </div>
    </nav>
</header>
<script src="${basePath}/static/js/green/header.js"></script>
