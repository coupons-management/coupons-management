<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../common/public.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="keywords" content="keywords"/>
    <meta name="description" content="description"/>
    <meta name="google-site-verification" content="AV6k9uxlDcEFufTdl0rM5Aetr5U9uvxCRcw0u3gYf8I"/>
    <meta name='webgains-site-verification' content='ambcr9xy'/>
    <title>绿站</title>
    <!-- bootstrap -->
    <link rel="stylesheet" href="${basePath}/static/css/green/custom.css"/>
</head>

<%
    request.setAttribute("word", (request.getParameter("word") == null || request.getParameter("word") == "") ? null : request.getParameter("word"));
%>

<body>
<!-- Header -->
<%@ include file="header.jsp" %>
<!-- End Header -->
<div class="js-site-main site-main">
    <section class="page-title-banner category-banner d-none d-md-block">
        <div class="container text-center">
            <h1 class="">Stores in <a href="${basePath}/green/">Cannabispromocodes.com</a></h1>
        </div>
    </section>

    <!-- Blog Background Overlay Blocks -->
    <section class="paginate-list-container-wrap mb-2 mb-md-2">
        <div class="container">
            <div class="row justify-content-center">
                <ul class="paginate-list col-12 d-flex flex-wrap justify-content-lg-center">
                    <!-- 增加 TOP 选项 -->

                    <li>
                        <a class="word-*" href="${basePath}/green/store?word=*">
                            TOP
                        </a>
                    </li>

                    <li>
                        <a class="word-A <c:if test="${word == 'A'}">active</c:if> "
                           href="${basePath}/green/store?word=A">
                            A
                        </a>
                    </li>

                    <li>
                        <a class="word-B <c:if test="${word == 'B'}">active</c:if>"
                           href="${basePath}/green/store?word=B">
                            B
                        </a>
                    </li>

                    <li>
                        <a class="word-C <c:if test="${word == 'C'}">active</c:if>"
                           href="${basePath}/green/store?word=C">
                            C
                        </a>
                    </li>

                    <li>
                        <a class="word-D <c:if test="${word == 'D'}">active</c:if>"
                           href="${basePath}/green/store?word=D">
                            D
                        </a>
                    </li>

                    <li>
                        <a class="word-E <c:if test="${word == 'E'}">active</c:if>"
                           href="${basePath}/green/store?word=E">
                            E
                        </a>
                    </li>

                    <li>
                        <a class="word-F <c:if test="${word == 'F'}">active</c:if>"
                           href="${basePath}/green/store?word=F">
                            F
                        </a>
                    </li>

                    <li>
                        <a class="word-G <c:if test="${word == 'G'}">active</c:if>"
                           href="${basePath}/green/store?word=G">
                            G
                        </a>
                    </li>

                    <li>
                        <a class="word-H <c:if test="${word == 'H'}">active</c:if>"
                           href="${basePath}/green/store?word=H">
                            H
                        </a>
                    </li>

                    <li>
                        <a class="word-I <c:if test="${word == 'I'}">active</c:if>"
                           href="${basePath}/green/store?word=I">
                            I
                        </a>
                    </li>

                    <li>
                        <a class="word-J <c:if test="${word == 'J'}">active</c:if>"
                           href="${basePath}/green/store?word=J">
                            J
                        </a>
                    </li>

                    <li>
                        <a class="word-K <c:if test="${word == 'K'}">active</c:if>"
                           href="${basePath}/green/store?word=K">
                            K
                        </a>
                    </li>

                    <li>
                        <a class="word-L <c:if test="${word == 'L'}">active</c:if>"
                           href="${basePath}/green/store?word=L">
                            L
                        </a>
                    </li>

                    <li>
                        <a class="word-M <c:if test="${word == 'M'}">active</c:if>"
                           href="${basePath}/green/store?word=M">
                            M
                        </a>
                    </li>

                    <li>
                        <a class="word-N <c:if test="${word == 'N'}">active</c:if>"
                           href="${basePath}/green/store?word=N">
                            N
                        </a>
                    </li>

                    <li>
                        <a class="word-O <c:if test="${word == 'O'}">active</c:if>"
                           href="${basePath}/green/store?word=O">
                            O
                        </a>
                    </li>

                    <li>
                        <a class="word-P <c:if test="${word == 'P'}">active</c:if>"
                           href="${basePath}/green/store?word=P">
                            P
                        </a>
                    </li>

                    <li>
                        <a class="word-Q <c:if test="${word == 'Q'}">active</c:if>"
                           href="${basePath}/green/store?word=Q">
                            Q
                        </a>
                    </li>

                    <li>
                        <a class="word-R <c:if test="${word == 'R'}">active</c:if>"
                           href="${basePath}/green/store?word=R">
                            R
                        </a>
                    </li>

                    <li>
                        <a class="word-S <c:if test="${word == 'S'}">active</c:if>"
                           href="${basePath}/green/store?word=S">
                            S
                        </a>
                    </li>

                    <li>
                        <a class="word-T <c:if test="${word == 'T'}">active</c:if>"
                           href="${basePath}/green/store?word=T">
                            T
                        </a>
                    </li>

                    <li>
                        <a class="word-U <c:if test="${word == 'U'}">active</c:if>"
                           href="${basePath}/green/store?word=U">
                            U
                        </a>
                    </li>

                    <li>
                        <a class="word-V <c:if test="${word == 'V'}">active</c:if>"
                           href="${basePath}/green/store?word=V">
                            V
                        </a>
                    </li>

                    <li>
                        <a class="word-W <c:if test="${word == 'W'}">active</c:if>"
                           href="${basePath}/green/store?word=W">
                            W
                        </a>
                    </li>

                    <li>
                        <a class="word-X <c:if test="${word == 'X'}">active</c:if>"
                           href="${basePath}/green/store?word=X">
                            X
                        </a>
                    </li>

                    <li>
                        <a class="word-Y <c:if test="${word == 'Y'}">active</c:if>"
                           href="${basePath}/green/store?word=Y">
                            Y
                        </a>
                    </li>

                    <li>
                        <a class="word-Z <c:if test="${word == 'Z'}">active</c:if>"
                           href="${basePath}/green/store?word=Z">
                            Z
                        </a>
                    </li>

                    <li>
                        <a class="word-0 <c:if test="${word == '0'}">active</c:if>"
                           href="${basePath}/green/store?word=0">
                            0
                        </a>
                    </li>

                    <li>
                        <a class="word-1 <c:if test="${word == '1'}">active</c:if>"
                           href="${basePath}/green/store?word=1">
                            1
                        </a>
                    </li>

                    <li>
                        <a class="word-2 <c:if test="${word == '2'}">active</c:if>"
                           href="${basePath}/green/store?word=2">
                            2
                        </a>
                    </li>

                    <li>
                        <a class="word-3 <c:if test="${word == '3'}">active</c:if>"
                           href="${basePath}/green/store?word=3">
                            3
                        </a>
                    </li>

                    <li>
                        <a class="word-4 <c:if test="${word == '4'}">active</c:if>"
                           href="${basePath}/green/store?word=4">
                            4
                        </a>
                    </li>

                    <li>
                        <a class="word-5 <c:if test="${word == '5'}">active</c:if>"
                           href="${basePath}/green/store?word=5">
                            5
                        </a>
                    </li>

                    <li>
                        <a class="word-6 <c:if test="${word == '6'}">active</c:if>"
                           href="${basePath}/green/store?word=6">
                            6
                        </a>
                    </li>

                    <li>
                        <a class="word-7 <c:if test="${word == '7'}">active</c:if>"
                           href="${basePath}/green/store?word=7">
                            7
                        </a>
                    </li>

                    <li>
                        <a class="word-8 <c:if test="${word == '8'}">active</c:if>"
                           href="${basePath}/green/store?word=8">
                            8
                        </a>
                    </li>

                    <li>
                        <a class="word-9 <c:if test="${word == '9'}">active</c:if>"
                           href="${basePath}/green/store?word=9">
                            9
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </section>
    <section class="container-wrap mb-2">

        <c:choose>
            <c:when test="${word == null || word == '*'}">
                <div class="container store-grid-container">
                    <div class="row">
                        <c:forEach items="${stores.list}" var="store">
                            <div class="col-lg-2 col-md-3 col-sm-4 col-6 p-md-2 p-0">

                                <a class="cover-wrap" style="height: 176px;"
                                   href="${basePath}/green/store/<c:choose><c:when test="${store.webSite.indexOf(\"//www.\") >=0}"><c:choose><c:when test="${store.webSite.endsWith(\"/\")}">${store.webSite.substring(store.webSite.indexOf("//www.") + 6)}</c:when><c:otherwise>${store.webSite.substring(store.webSite.indexOf("//www.") + 6)}/</c:otherwise></c:choose></c:when><c:otherwise><c:choose><c:when test="${store.webSite.endsWith(\"/\")}">${store.webSite.substring(store.webSite.indexOf("//") + 2)}</c:when><c:otherwise>${store.webSite.substring(store.webSite.indexOf("//") + 2)}/</c:otherwise></c:choose></c:otherwise></c:choose>">
                                    <%--href="${basePath}/green/storeDetail?storeId=${store.storeId}&siteId=1">--%>
                                    <div class="cover">
                                        <img src="${store.logoUrl}" alt="${store.name} coupons" title="${store.name}"/>
                                    </div>
                                </a>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </c:when>
            <c:otherwise>
                <div style="background-color: #fff">
                    <div class="container store-list-container p-3">
                        <div class="row text-left text-md-center">
                            <c:forEach items="${stores.list}" var="store">
                                <div class="col-md-3 col-6">
                                    <a href="${basePath}/green/store/<c:choose><c:when test="${store.webSite.indexOf(\"//www.\") >=0}"><c:choose><c:when test="${store.webSite.endsWith(\"/\")}">${store.webSite.substring(store.webSite.indexOf("//www.") + 6)}</c:when><c:otherwise>${store.webSite.substring(store.webSite.indexOf("//www.") + 6)}/</c:otherwise></c:choose></c:when><c:otherwise><c:choose><c:when test="${store.webSite.endsWith(\"/\")}">${store.webSite.substring(store.webSite.indexOf("//") + 2)}</c:when><c:otherwise>${store.webSite.substring(store.webSite.indexOf("//") + 2)}/</c:otherwise></c:choose></c:otherwise></c:choose>">
                                            ${store.name}
                                    </a>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </c:otherwise>
        </c:choose>

    </section>
</div>

<%@ include file="footer.jsp" %>
<script src="${basePath}/static/js/green/custom.js"></script>
</body>
</html>
