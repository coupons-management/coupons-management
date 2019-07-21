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
    <meta name ='webgains-site-verification'content ='ambcr9xy'/>
    <title>绿站</title>
    <!-- bootstrap -->
    <link rel="stylesheet" href="${basePath}/static/css/green/custom.css" />
</head>

<body>
    <!-- Header -->
    <%@ include file="header.jsp" %>
    <!-- End Header -->

    <div class="js-site-main site-main">

        <section class="page-title-banner category-banner d-none d-md-block">
            <div class="container text-center">
                <h1 class="">Categories in <a href="${basePath}/green/">Cannabispromocodes.com</a>
                </h1>
            </div>
        </section>
        <section class="container-wrap category-container-wrap mb-2 mb-lg-0">
            <div class="container category-container">
                <p class="container-title d-block d-sm-none">Category</p>
                <div class="row">

                    <c:forEach items="${categories}" var="category">
                        <div class="col-6 col-sm-4 col-md-3 col-lg-2 p-3 p-sm-2">
                            <div class="category-item">
                                <a href="${basePath}/green/category/${category.name}/">
                                    ${category.name}
                                </a>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </section>

    </div>

    <!-- Footer -->
    <%@ include file="footer.jsp" %>
    <script src="${basePath}/static/js/green/custom.js"></script>
</body>

</html>