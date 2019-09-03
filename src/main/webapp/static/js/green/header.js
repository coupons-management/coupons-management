$(document).ready(function () {

    init();

    function init() {
        bindEvent();
    }


    function bindEvent() {

        $('#header_search_input').focus(function () {
            $('#js-header li.nav-item.nav-item__search').css('width', '100%');
            if ($('#header_search_input').val().trim().length > 0) {
                headerSearchInputChange();
            }
        });

        $('#header_search_input').blur(function () {
            $('#js-header li.nav-item.nav-item__search').css('width', '300px');
            setTimeout(function () {
                $('#header_search_ul').hide();
            }, 700)
        });

        $('#header_search_input').on('input', headerSearchInputChange);
    }

    function headerSearchInputChange() {
        var param = $('#header_search_input').val().trim();
        $('#header_search_ul').empty();
        if (param.length > 0) {
            $.ajax({
                url: basePath + "/officialWebsite/searchStorePageList",
                method: 'post',
                contentType: "application/json;charset=UTF-8",
                data: JSON.stringify({pageNumber: 1, pageSize: 5, name: param, siteId:1}),
                dataType: 'json',
                success: headerStoreSearchSuccess
            })
        }
    }

    function headerStoreSearchSuccess(result) {
    	var list = result.data.list;
        if (list && list.length > 0) {
            for (var i = 0; i < list.length; i++) {
                var store = list[i];
                var webSite = store.webSite.replace("https://","").replace("http://","").replace("www.","");
                $('#header_search_ul').append('<li class="">\n' +
                    '                                        <a class="dropdown-item" href=' + basePath + '/green/store/' + webSite + '>\n' +
                    '                                            <div class="typeahead search-result">\n' +
                    '                                                <div class="img-text-wrap">\n' +
                    '                                                    <img src=' + store.logoUrl + '\n' +
                    '                                                         class="pic">\n' +
                    '                                                    <div><strong>' + store.name + '</strong> -- Store</div>\n' +
                    '                                                </div>\n' +
                    '                                                <p class="count">'+store.couponCount+' offers</p>\n' +
                    '                                            </div>\n' +
                    '                                        </a>\n' +
                    '                                    </li>');


            }
            $('#header_search_ul').show();
        }
        searchCategory();
    }

    function searchCategory() {
        var param = $('#header_search_input').val().trim();
        $.ajax({
            url: basePath + "/officialWebsite/getStoreCategoryPage",
            method: 'post',
            contentType: "application/json;charset=UTF-8",
            data: JSON.stringify({pageNumber: 1, pageSize: 5, name: param, siteId: 1}),
            dataType: 'json',
            success: headerCategorySearchSuccess
        })
    }

    function headerCategorySearchSuccess(result) {
    	$('#header_search_ul').html("");
    	var list = result.data.list;
        if (list && list.length > 0) {
            for (var i = 0; i < list.length; i++) {
                var category = list[i];

                $('#header_search_ul').append('<li class=""><a class="dropdown-item" href=' + basePath + '/green/category/' + category.name + '><div class="typeahead search-result">\n' +
                    '<div><strong>' + category.name + '</strong><span> -- Category</span></div>\n' +
                    '<p class="count"> more categories</p>\n' +
                    '</div></a></li>')
            }
            $('#header_search_ul').show();
        }
    }

})