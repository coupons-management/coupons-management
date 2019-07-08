$(function() {
    var footerHeight = $('.js-site-footer').height();
    var headerHeight = $('.js-site-header').height();
    var viewportHeight = $(window).height();
    $('.js-site-main').css('min-height', viewportHeight - footerHeight - headerHeight);
    var typeaheadOptions = {
        source: function(query, process) {
            if (query !== '') {
                return $.get('/search_ajax?q=' + query, function(resp) {
                    console.log(resp);
                    data = resp.data;
                    store = false;
                    category = false;
                    return process(resp.data);
                });
            } else {
                return process([]);
            }
        },
        delay: 350,
        afterSelect: function(item) {
            if (item.type === 'store') {
                location.href = '/store/' + item.url_name + '/';
            } else {
                location.href = '/category/' + item.url_name + '/';
            }
        },
        showHintOnFocus: true,
        items: 10,
        highlighter: function(item) {
            var html = '';
            for (var i = 0; i < data.length; i++) {
                if (data[i].name === item) {
                    if (data[i].type === 'category') {
                        var count = data[i].count;

                        html = [
                            '<div class="typeahead search-result">',
                            '<div><strong>' + item + '</strong><span> -- Category</span></div>',
                            '<p class="count">' + count + ' stores</p>',
                            '</div>'
                        ].join('\n');
                        return html;
                    }
                }
            }
            for (var i = 0; i < data.length; i++) {
                if (data[i].name === item) {
                    if (data[i].type === 'store') {
                        var website = data[i].website;
                        var picture = data[i].picture;
                        var count = data[i].count;
                        html = [
                            '<div class="typeahead search-result">',
                            '<div class="img-text-wrap">',
                            '<img src="/static/media/' + picture + '" class="pic">',
                            '<div><strong>' + item + '</strong> -- Store</div>',
                            '</div>',
                            '<p class="count">' + count + ' offers</p>',
                            '</div>'
                        ].join('\n');
                    }
                }
            }
            return html;
        }
    };

    $('.js-search__input').typeahead(typeaheadOptions);

    // $('.js-head-search-form input')
    //     .on('focus', function() {
    //         $('.js-head-search-form')
    //             .parent()
    //             .css('width', '100%');
    //     })
    //     .on('blur', function() {
    //         $('.js-head-search-form')
    //             .parent()
    //             .css('width', '');
    //     });

    // 给 header 中的 navitem 添加 active 类
    // $('.nav-item-home').addClass('active');

    // initialization of go to
    $.HSCore.components.HSGoTo.init('.js-go-to', {});
});
