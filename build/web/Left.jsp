<%-- 
    Document   : Left
    Created on : Sep 25, 2024, 4:00:21 AM
    Author     : Acer
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="col-sm-3">
                    <div class="card bg-light mb-3">
                        <div class="card-header text-white text-uppercase"><i class="fa fa-list"></i> Danh mục sản phẩm</div>
                        <ul class="list-group category_block">
                            <c:forEach items="${ListCategory}" var="o">
                                <li class="list-group-item text-white">
                                    <c:choose>
                                        <c:when test="${Tag == o.categoryID}">
                                            <a class="active" href="category?cid=${o.categoryID}">${o.categoryName}</a>
                                        </c:when>
                                        <c:otherwise>
                                            <a href="category?cid=${o.categoryID}">${o.categoryName}</a>
                                        </c:otherwise>
                                    </c:choose>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                    <div class="card bg-light mb-3">
                        <div class="card-header bg-success text-white text-uppercase">Sản phẩm mới</div>
                        <div class="card-body">
                            <img class="img-fluid" src="${NewestProduct.productImage}" />
                            <h5 class="card-title">${NewestProduct.productName}</h5>
                            <p class="card-text">${NewestProduct.shortDescription}</p>
                            <p class="bloc_left_price">${NewestProduct.price} VNĐ</p>
                        </div>
                    </div>
                </div>


