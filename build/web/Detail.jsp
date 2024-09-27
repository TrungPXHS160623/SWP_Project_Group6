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
        <title>Product Detail - Pharmacy</title>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <style>
            .gallery-wrap .img-big-wrap img {
                height: 450px;
                width: auto;
                display: inline-block;
                cursor: zoom-in;
            }

            .gallery-wrap .img-small-wrap .item-gallery {
                width: 60px;
                height: 60px;
                border: 1px solid #ddd;
                margin: 7px 2px;
                display: inline-block;
                overflow: hidden;
            }

            .gallery-wrap .img-small-wrap {
                text-align: center;
            }

            .gallery-wrap .img-small-wrap img {
                max-width: 100%;
                max-height: 100%;
                object-fit: cover;
                border-radius: 4px;
                cursor: zoom-in;
            }

            .img-big-wrap img {
                width: 100% !important;
                height: auto !important;
            }
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


        <!-- Product Detail -->
        <div class="container">
            <div class="row">
                <!-- Sidebar for Categories -->
                <jsp:include page ="Left.jsp"></jsp:include>
                <!-- Product Detail Section -->
                <div class="col-sm-9">
                    <div class="card">
                        <div class="row">
                            <aside class="col-sm-5 border-right">
                                <article class="gallery-wrap">
                                    <div class="img-big-wrap">
                                        <div><a href="#"><img src="${detail.productImage}" alt="${detail.productName}"></a></div>
                                    </div>
                                </article>
                            </aside>

                            <aside class="col-sm-7">
                                <article class="card-body p-5 text-left"> <!-- Thêm class text-left -->
                                    <h3 class="title mb-3">${detail.productName}</h3>

                                    <p class="price-detail-wrap">
                                        <span class="price h3 text-warning">
                                            <span class="currency">US $</span><span class="num">${detail.price}</span>
                                        </span>
                                    </p>

                                    <dl class="item-property">
                                        <dt>Ingredients:</dt>
                                        <dd><p>${detail.ingredients}</p></dd>

                                        <dt>Formulation:</dt>
                                        <dd><p>${detail.formulation}</p></dd>

                                        <dt>Specification:</dt>
                                        <dd><p>${detail.specification}</p></dd>

                                        <dt>Target Audience:</dt>
                                        <dd><p>${detail.targetAudience}</p></dd>

                                        <dt>Prescription Medication:</dt>
                                        <dd><p>${detail.prescriptionMedication ? 'Yes' : 'No'}</p></dd>

                                        <dt>Registration Number:</dt>
                                        <dd><p>${detail.registrationNumber}</p></dd>

                                        <dt>Short Description:</dt>
                                        <dd><p>${detail.shortDescription}</p></dd>
                                    </dl>

                                    <hr>

                                    <div class="row">
                                        <div class="col-sm-5">
                                            <dl class="param param-inline">
                                                <dt>Quantity:</dt>
                                                <dd>
                                                    <select class="form-control form-control-sm" style="width:70px;">
                                                        <option> 1 </option>
                                                        <option> 2 </option>
                                                        <option> 3 </option>
                                                    </select>
                                                </dd>
                                            </dl>
                                        </div>
                                    </div>

                                    <hr>

                                    <a href="#" class="btn btn-lg btn-primary text-uppercase">Buy now</a>
                                    <a href="#" class="btn btn-lg btn-outline-primary text-uppercase">
                                        <i class="fas fa-shopping-cart"></i> Add to cart
                                    </a>
                                </article>
                            </aside>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <jsp:include page ="Footer.jsp"></jsp:include>      
    </body>
</html>
