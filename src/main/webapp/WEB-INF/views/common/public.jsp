<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    int port = request.getServerPort();
    String basePath = "";
    if(port==80){
        basePath = request.getScheme()+"://"+request.getServerName()+path;
    }else{
        basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
    }
    request.setAttribute("basePath", basePath);
%>

<link rel="stylesheet" type="text/css" href="${basePath}/static/common/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="${basePath}/static/common/css/font-awesome.min.css"/>
<script async src="https://www.googletagmanager.com/gtag/js?id=UA-106211927-10"></script>
<script async src="https://pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
<script type="text/javascript" src="${basePath}/static/common/js/base.js"></script>
<script type="text/javascript" src="${basePath}/static/common/js/hs.core.js"></script>
<script type="text/javascript" src="${basePath}/static/common/js/hs.go-to.js"></script>
<script type="text/javascript">
    var basePath="${basePath}";
</script>
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
