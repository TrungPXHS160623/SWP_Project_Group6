<%-- 
    Document   : Menu
    Created on : Sep 25, 2024, 3:45:01 AM
    Author     : Acer
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nhà Thuốc Long Châu</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <style>
            .navbar {
                background-color: #004080;
            } /* Xanh đậm */
            .navbar-brand {
                font-size: 1.5em;
                font-weight: bold;
            }
            .jumbotron {
                background-color: #f0f8ff;
            } /* Xanh nhạt */
            .card-header {
                background-color: #0080ff;
            } /* Màu của các tiêu đề category */
            .card-body {
                text-align: center;
            }
            .footer {
                background-color: #004080;
                color: white;
                padding: 20px 0;
            }
            .footer a {
                color: white;
            }
        </style>
    </head>
    <body>
        <jsp:include page ="Menu.jsp"></jsp:include>
        <!-- Breadcrumb -->
        <div class="container">
            <div class="row">
                <div class="col">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="Home.jsp">Trang chủ</a></li>
                            <li class="breadcrumb-item"><a href="#">Danh mục</a></li>
                            <li class="breadcrumb-item active" aria-current="#">Thuốc bổ</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>

        <!-- Main content -->
        <div class="container">
            <div class="row">
                <!-- Sidebar for Categories -->
                <jsp:include page ="Left.jsp"></jsp:include>

                <div class="col-sm-9">
                    <div class="row">
                        <c:forEach items="${ListProduct}" var="o">
                            <div class="col-12 col-md-6 col-lg-4">
                                <div class="card">
                                    <img class="card-img-top" src="${o.productImage}" alt="Card image cap">
                                    <div class="card-body">
                                        <h4 class="card-title show_txt"><a href="detail?pid=${o.productID}" title="Xem chi tiết">${o.productName}</a></h4>
                                        <p class="card-text show_txt">${o.shortDescription}</p>
                                        <div class="row">
                                            <div class="col">
                                                <p class="btn btn-danger btn-block">${o.price} VNĐ</p>
                                            </div>
                                            <div class="col">
                                                <a href="#" class="btn btn-success btn-block">Thêm vào giỏ hàng</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
         <jsp:include page ="Footer.jsp"></jsp:include>               
    </body>
</html>
