<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Chỉnh Sửa Sản Phẩm - Nhà Thuốc Long Châu</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
        <style>
            body {
                font-family: 'Roboto', sans-serif;
                background: linear-gradient(to right, #00c6ff, #0072ff);
                color: #fff;
                margin: 0;
                padding: 20px;
            }

            .container {
                background-color: rgba(255, 255, 255, 0.95);
                padding: 20px;
                border-radius: 15px;
                box-shadow: 0 0 30px rgba(0, 0, 0, 0.2);
                max-width: 600px;
                margin: auto;
            }

            h1 {
                color: #0c64dc;
                margin-bottom: 20px;
                text-align: center;
            }

            .form-group {
                margin-bottom: 15px;
            }

            label {
                font-weight: bold;
                margin-bottom: 5px;
                display: block;
                color: #333;
            }

            input[type="text"], textarea, select {
                width: 100%;
                padding: 10px;
                border: 1px solid #ccc;
                border-radius: 5px;
                box-sizing: border-box;
                color: #333;
            }

            textarea {
                resize: vertical;
            }

            input[type="submit"] {
                background-color: #28a745;
                color: #fff;
                padding: 10px 20px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                transition: background-color 0.3s ease;
            }

            input[type="submit"]:hover {
                background-color: #218838;
            }
            .readonly-input {
                background-color: #fff3cd;
                padding: 10px;
                border: 1px solid #ffc107;
                border-radius: 5px;
                color: #856404;
            }

        </style>
    </head>
    <body>
        <%
    List<String> updateErrors = (List<String>) session.getAttribute("updateErrors");
    if (updateErrors != null && !updateErrors.isEmpty()) {
        %>
        <div class="alert alert-danger" style="padding: 15px; background-color: #f8d7da; color: #721c24; border: 1px solid #f5c6cb; border-radius: 5px; margin-bottom: 20px;">
            <h4 style="font-weight: bold; margin-bottom: 10px; color: #721c24;"><i class="fas fa-exclamation-circle"></i> Đã xảy ra lỗi:</h4>
            <ul style="list-style-type: disc; padding-left: 20px;">
                <c:forEach var="error" items="${updateErrors}">
                    <li style="margin-bottom: 5px;">${error}</li>
                    </c:forEach>
            </ul>
        </div>
        <%
                // Xóa thông báo lỗi sau khi hiển thị
                session.removeAttribute("updateErrors");
            }
        %>
        <div class="container">
            <h1>Chỉnh Sửa Sản Phẩm</h1>
            <form action="update" method="post">
                <div class="form-group">
                    <label for="productID">ID Sản Phẩm</label>
                    <input value="${load.productID}" id="productID" name="productID" type="text" readonly required class = "readonly-input">
                </div>
                <div class="form-group">
                    <label for="productName">Tên Sản Phẩm</label>
                    <input value="${load.productName}" id="productName" name="productName" type="text">
                </div>
                <div class="form-group">
                    <label for="productImage">Hình Ảnh</label>
                    <input value="${load.productImage}" id="productImage" name="productImage" type="text">
                </div>
                <div class="form-group">
                    <label for="price">Giá</label>
                    <input value="${load.price}" id="price" name="price" type="text">
                </div>
                <div class="form-group">
                    <label for="ingredients">Thành Phần</label>
                    <input value="${load.ingredients}" id="ingredients" name="ingredients" type="text" >
                </div>
                <div class="form-group">
                    <label for="formulation">Cách Bào Chế</label>
                    <input value="${load.formulation}" id="formulation" name="formulation" type="text" >
                </div>
                <div class="form-group">
                    <label for="specification">Thông Số Kỹ Thuật</label>
                    <input value="${load.specification}" id="specification" name="specification" type="text">
                </div>
                <div class="form-group">
                    <label for="targetAudience">Đối Tượng Sử Dụng</label>
                    <input value="${load.targetAudience}" id="targetAudience" name="targetAudience" type="text">
                </div>

                <div class="form-group">
                    <label for="prescriptionMedication">Thuốc Theo Đơn</label>
                    <select id="prescriptionMedication" name="prescriptionMedication" required>
                        <option value="1" <c:if test="${load.prescriptionMedication}">selected</c:if>>Có</option>
                        <option value="0" <c:if test="${!load.prescriptionMedication}">selected</c:if>>Không</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="shortDescription">Mô Tả Ngắn</label>
                        <textarea id="shortDescription" name="shortDescription">${load.shortDescription}</textarea>
                </div>
                <div class="form-group">
                    <label for="registrationNumber">Số Đăng Ký</label>
                    <input value="${load.registrationNumber}" id="registrationNumber" name="registrationNumber" type="text">
                </div>
                <div class="form-group">
                    <label for="category">Danh Mục</label>
                    <select id="category" name="category" class="form-select" aria-label="Default select example">
                        <c:forEach items="${ListCategory}" var="o">
                            <option value="${o.categoryID}" <c:if test="${o.categoryID == load.categoryId}">selected</c:if>>${o.categoryName}</option>
                        </c:forEach>
                    </select>
                </div>

                <input type="submit" value="Sửa Sản Phẩm">
            </form>
        </div>

    </body>
</html>
