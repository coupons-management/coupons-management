<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/public.jsp"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="keywords" content="${tdkInfo.keyWords}"/>
        <meta name="description" content="${tdkInfo.description}"/>
        <meta name="google-site-verification" content="AV6k9uxlDcEFufTdl0rM5Aetr5U9uvxCRcw0u3gYf8I"/>
        <meta name="webgains-site-verification" content="ambcr9xy"/>
    
        <title>${tdkInfo.title}</title>
        <!-- bootstrap -->
        <link rel="stylesheet" href="${basePath}/static/css/green/custom.css" />
    </head>
    <body>
        <!-- Header -->

        <%@ include file="header.jsp" %>
        <!-- End Header -->

        <div class="js-site-main site-main">
            <section class="page-title-banner about-banner">
                <div class="container text-center">
                    <h1>About us</h1>
                </div>
            </section>

            <div class="about-container-wrap py-0 py-md-5 mb-2">
                <div class="container about-container">
                    <div class="row">
                        <!-- Profile Sidebar -->
                        <div class="col-12">
                            ${content}
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Footer -->
        <%@ include file="footer.jsp" %>
        <script src="${basePath}/static/js/green/custom.js"></script>
    </body>
</html>
