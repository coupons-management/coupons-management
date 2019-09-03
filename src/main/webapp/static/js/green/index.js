$(document).ready(function () {

    init();

    function init() {
        bindEvent();
    }


    function bindEvent() {

        $('#index_search_input').focus(function () {
            if ($('#index_search_ul').val().trim().length > 0) {
                headerSearchInputChange();
            }
        });

        $('#index_search_input').blur(function () {
            setTimeout(function () {
                $('#index_search_ul').hide();
            }, 700)
        });

        $('#index_search_input').on('input', headerSearchInputChange);
    }

    function headerSearchInputChange() {
        var param = $('#index_search_input').val().trim();
        $('#index_search_ul').empty();
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
                $('#index_search_ul').append('<li class="">\n' +
                    '                            <a class="dropdown-item" href=' + basePath + '/green/store/' + webSite + '>\n' +
                    '                                <div class="typeahead search-result">\n' +
                    '                                    <div class="img-text-wrap">\n' +
                    '                                        <img src=' + store.logoUrl + ' class="pic">\n' +
                    '                                        <div>\n' +
                    '                                            <strong>' + store.name + '</strong> -- Store\n' +
                    '                                        </div>\n' +
                    '                                    </div>\n' +
                    '                                    <p class="count">'+store.couponCount+' offers</p>\n' +
                    '                                </div>\n' +
                    '                            </a>\n' +
                    '                        </li>')
            }
            $('#index_search_ul').show();
        }
        searchCategory();
    }


    function searchCategory() {
        var param = $('#index_search_input').val().trim();
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
    	var list = result.data.list;
        if (list && list.length > 0) {
            for (var i = 0; i < list.length; i++) {
                var category = list[i];
                $('#index_search_ul').append('<li class="active">\n' +
                    '                            <a class="dropdown-item" href=' + basePath + '/green/category/' + category.name + '>\n' +
                    '                                <div class="typeahead search-result">\n' +
                    '                                    <div>\n' +
                    '                                        <strong>' + category.name + '</strong>\n' +
                    '                                        <span> -- Category</span>\n' +
                    '                                    </div>\n' +
                    '                                    <p class="count">more stores</p>\n' +
                    '                                </div>\n' +
                    '                            </a>\n' +
                    '                        </li>')
            }
            $('#index_search_ul').show();
        }
    }

})