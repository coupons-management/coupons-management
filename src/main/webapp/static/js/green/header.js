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
                url: basePath + "/officialWebsite/getStorePageList",
                method: 'post',
                contentType: "application/json;charset=UTF-8",
                data: JSON.stringify({pageNumber: 1, pageSize: 5, name: param}),
                dataType: 'json',
                success: headerStoreSearchSuccess
            })
        }
    }


    function headerStoreSearchSuccess(result) {
        if (result.data.list.length > 0) {
            var list = result.data.list;
            for (var i = 0; i < list.length; i++) {
                var store = list[i];

                $('#header_search_ul').append('<li class="">\n' +
                    '                                        <a class="dropdown-item" href=' + basePath + '/green/storeDetail?storeId=' + store.storeId + '&siteId=1 role="option">\n' +
                    '                                            <div class="typeahead search-result">\n' +
                    '                                                <div class="img-text-wrap">\n' +
                    '                                                    <img src=' + store.logoUrl + '\n' +
                    '                                                         class="pic">\n' +
                    '                                                    <div><strong>' + store.name + '</strong> -- Store</div>\n' +
                    '                                                </div>\n' +
                    //todo offers数量接口未返回
                    '                                                <p class="count">5 offers</p>\n' +
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
            data: JSON.stringify({pageNumber: 1, pageSize: 5, name: param, level: 1, siteId: 1}),
            dataType: 'json',
            success: headerCategorySearchSuccess
        })

    }

    function headerCategorySearchSuccess(result) {
        if (result.data.list.length > 0) {
            var list = result.data.list;
            for (var i = 0; i < list.length; i++) {
                var cagegory = list[i];

                $('#header_search_ul').append('<li class=""><a class="dropdown-item" href=' + basePath + '/green/categoryDetail?pageNumber=1&pageSize=5&siteId=1&id=' + cagegory.id + '&name=' + cagegory.name + ' role="option"><div class="typeahead search-result">\n' +
                    '<div><strong>cagegory.name</strong><span> -- Category</span></div>\n' +
                    '<p class="count">more stores</p>\n' +
                    '</div></a></li>')
            }
            $('#header_search_ul').show();
        }
    }

})