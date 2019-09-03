$(function() {
  // 点击搜索框触发函数
  $('#search_input').typeahead({
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
            html += '<div class="typeahead store_result">';
            html += '<div style="width: 50%;display: inline-block;line-height: 22px;margin: 0 !important;"><strong>' + item + '</strong><span> -- Category</span></div>';
            html += '<p style="width: 50%;display: inline-block;text-align: right;line-height: 22px;margin: 0 !important;padding-right: 5px;">' + count + ' stores</p>';
            html += '<div class="clearfix"></div>';
            html += '</div>';
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
            html += '<div class="typeahead category_result">';
            html += '<img src="/static/media/' + picture + '" class="item_pic">';
            html += '<div class="pull-left margin-small" style="margin-left: 60px;">';
            html += '<div style="line-height: 42px;"><strong>' + item + '</strong> -- Store</div>';
            html += '</div>';
            html += '<p style="line-height: 44px;text-align: right;margin: 0;padding-right: 5px;">' + count + ' offers</p>';
            html += '<div class="clearfix"></div>';
            html += '</div>';
          }
        }
      }
      return html;
    }
  });
  // initialization of go to
  $.HSCore.components.HSGoTo.init('.js-go-to', {});
});
