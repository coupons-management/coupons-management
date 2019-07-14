<header id="js-header" class="js-site-header u-header mb-2 mb-lg-0">
    <nav class="navbar navbar-expand-lg">
        <div class="container">
            <!-- Logo -->
            <a href="${basePath}/green/" class="navbar-brand mr-4">
                <!-- TODO 更换真实的 logo url -->
                <img alt="cannabis coupons - cannabispromocodes.com" src="${basePath}/static/common/img/cannabis.jpg" />
            </a>
            <!-- End Logo -->

            <!-- Navigation -->
            <div class="flex-grow-1">
                <ul class="navbar-nav justify-content-end ">
                    <li class="nav-item-top-stores  nav-item ml-0 d-none d-lg-inline-block">
                        <div class="nav-link">
                            <a href="${basePath}/green/stores" style="text-decoration: none;color: #151515;font-size: 15px;font-weight: 500;line-height: 35px">
                                Top Stores
                            </a>
                        </div>
                    </li>

                    <li class="nav-item nav-item-category  d-none d-lg-inline-block">
                        <div class="nav-link">
                            <a href="${basePath}/green/categories" style="text-decoration: none;color: #151515;font-size: 15px;font-weight: 500;line-height: 35px">
                                Categories
                            </a>
                        </div>
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
                <a href="${basePath}/green/" class="nav-item-home nav-link active">Home</a>
                <a href="${basePath}/green/stores" class="nav-item-top-stores nav-link">Top Stores</a>
                <a href="./topCoupon.html" class="nav-item-top-coupons nav-link">Top Coupons</a>
                <a href="./category.jsp" class="nav-item-category nav-link">Category</a>
            </nav>
        </div>
    </nav>
</header>
