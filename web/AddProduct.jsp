<%-- 
    Document   : AddProduct
    Created on : Sep 25, 2024
    Author     : Acer
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Thêm Sản Phẩm - Nhà Thuốc Long Châu</title>
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

        </style>
    </head>
    <body>

        <div class="container">
            <h1>Thêm Sản Phẩm</h1>
            <form action="add" method="post">
                <div class="form-group">
                    <label for="productName">Tên Sản Phẩm</label>
                    <input id="productName" name="productName" type="text" required>
                </div>
                <div class="form-group">
                    <label for="productImage">Hình Ảnh</label>
                    <input id="productImage" name="productImage" type="text" required>
                </div>
                <div class="form-group">
                    <label for="price">Giá</label>
                    <input id="price" name="price" type="text" required>
                </div>
                <div class="form-group">
                    <label for="ingredients">Thành Phần</label>
                    <input id="ingredients" name="ingredients" type="text" required>
                </div>
                <div class="form-group">
                    <label for="formulation">Cách Bào Chế</label>
                    <input id="formulation" name="formulation" type="text" required>
                </div>
                <div class="form-group">
                    <label for="specification">Thông Số Kỹ Thuật</label>
                    <input id="specification" name="specification" type="text" required>
                </div>
                <div class="form-group">
                    <label for="targetAudience">Đối Tượng Sử Dụng</label>
                    <input id="targetAudience" name="targetAudience" type="text" required>
                </div>
                <div class="form-group">
                    <label for="prescriptionMedication">Thuốc Theo Đơn</label>
                    <select id="prescriptionMedication" name="prescriptionMedication" required>
                        <option value="1">Có</option>
                        <option value="0">Không</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="shortDescription">Mô Tả Ngắn</label>
                    <textarea id="shortDescription" name="shortDescription" required></textarea>
                </div>
                <div class="form-group">
                    <label for="registrationNumber">Số Đăng Ký</label>
                    <input id="registrationNumber" name="registrationNumber" type="text" required>
                </div>
                <div class="form-group">
                    <label for="category">Danh Mục</label>
                    <select id="category" name="category" class="form-select" aria-label="Default select example">
                        <c:forEach items="${ListCategory}" var="o">
                            <option value="${o.categoryID}">${o.categoryName}</option>
                        </c:forEach>
                    </select>
                </div>
                <input type="submit" value="Thêm Sản Phẩm">
            </form>
        </div>

    </body>
</html>
