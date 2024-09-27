<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Quản Lý Sản Phẩm - Nhà Thuốc Long Châu</title>
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
        }

        h1 {
            color: #0c64dc;
            margin-bottom: 20px;
            text-align: center;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
        }

        th, td {
            padding: 10px;
            text-align: left;
            border: 1px solid #ccc;
            vertical-align: middle;
        }

        th {
            background-color: #0c64dc;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        .important-info {
            color: #d9534f;
            font-weight: bold;
        }

        .button-group {
            display: flex;
            justify-content: space-around;
            align-items: center;
            height: 100%;
        }

        .button {
            color: #fff;
            border: none;
            padding: 15px 20px;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
            margin: 0 5px;
            width: 100px;
            height: 95px;
        }

        .add-product {
            text-align: right;
        }

        .add-product a {
            text-decoration: none;
            color: #fff;
            background-color: #28a745;
            padding: 10px 20px;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }

        .add-product a:hover {
            background-color: #218838;
        }

        .button.edit {
            background-color: #ffc107;
        }

        .button.edit:hover {
            background-color: #e0a800;
        }

        .button.delete {
            background-color: #dc3545;
        }

        .button.delete:hover {
            background-color: #c82333;
        }

        img.product-image {
            width: 50px;
            height: auto;
            border-radius: 5px;
        }
    </style>
</head>
<body>

    <div class="container">

        <h1>Quản Lý Sản Phẩm</h1>

        <div class="add-product">
            <a href="add">Thêm Sản Phẩm</a>
        </div>

        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Tên Sản Phẩm</th>
                    <th>Danh Mục</th>
                    <th>Hình Ảnh</th>
                    <th>Thành Phần</th>
                    <th>Cách Bào Chế</th>
                    <th>Thông Số Kỹ Thuật</th>
                    <th>Đối Tượng Sử Dụng</th>
                    <th>Thuốc Theo Đơn</th>
                    <th>Mô Tả Ngắn</th>
                    <th>Số Đăng Ký</th>
                    <th>Giá</th>
                    <th style="width: 80px;">Hành Động</th> 
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listP}" var="o">
                    <tr>
                        <td class="important-info">${o.productID}</td>
                        <td class="important-info">${o.productName}</td>
                        <td class="important-info">${o.categoryId}</td>
                        <td><img src="${o.productImage}" alt="st" class="product-image" /></td>
                        <td class="important-info">${o.ingredients}</td>
                        <td class="important-info">${o.formulation}</td>
                        <td class="important-info">${o.specification}</td>
                        <td class="important-info">${o.targetAudience}</td>
                        <td class="important-info">${o.prescriptionMedication}</td>
                        <td class="important-info">${o.shortDescription}</td>
                        <td class="important-info">${o.registrationNumber}</td>
                        <td class="important-info">${o.price}</td>
                        <td class="button-group">
                            <a href="load?pid=${o.productID}" class="button edit">Sửa</a>
                            <a href="delete?pid=${o.productID}" class="button delete">Xóa</a 
                        </td>
                    </tr>  
                </c:forEach>

            </tbody>
        </table>
    </div>
</body>
</html>
