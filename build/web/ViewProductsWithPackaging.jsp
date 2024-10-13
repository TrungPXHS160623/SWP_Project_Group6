<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>View Products with Packaging - Nhà Thuốc Long Châu</title>
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
                color: #FF5733;
                margin-bottom: 20px;
                text-align: center;
                font-family: 'Arial Black', sans-serif;
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

            img.product-image {
                width: 50px;
                height: auto;
                border-radius: 5px;
            }

            .btn-back-home {
                background-color: #ff4500;
                color: #fff;
                padding: 10px 20px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                transition: background-color 0.3s ease;
            }

            .btn-back-home:hover {
                background-color: #f39c12;
            }
            .important-info {
                color: #5a5a5a;
                font-weight: bold;
            }
            .edit-button {
                background-color: #007bff; /* Màu nền xanh dương */
                color: white; /* Màu chữ trắng */
                padding: 10px 20px; /* Tăng kích thước nút */
                font-size: 16px; /* Tăng kích thước chữ */
                border: none; /* Bỏ viền */
                border-radius: 5px; /* Bo tròn góc */
                cursor: pointer; /* Thay đổi con trỏ khi hover */
                box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1); /* Thêm đổ bóng */
                transition: background-color 0.3s ease; /* Hiệu ứng chuyển màu khi hover */
            }

            .edit-button:hover {
                background-color: #0056b3; /* Màu khi hover (xanh đậm hơn) */
            }

            .edit-button:active {
                background-color: #003f7f; /* Màu khi bấm giữ nút */
                box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.2); /* Giảm đổ bóng khi bấm */
            }
        </style>
    </head>
        <body>
            <div class="container">
                <h1>Xem Danh Sách Sản Phẩm Kèm Bao Bì</h1>
                <div class="back-home">
                    <button class="btn-back-home" onclick="window.location.href = 'manager'">
                        Trở Về Trang Quản Lý Sản phẩm
                    </button>
                </div>

                <table>
                    <thead>
                        <tr>
                            <th>Tên Sản Phẩm</th>
                            <th>Hình Ảnh</th>
                            <th>Tên Danh Mục</th>
                            <th>Loại Bao bì</th>
                            <th>Số lượng mỗi gói </th>
                            <th>Giá</th>
                            <th>Hành Động</th> 
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="o" items="${listP}">
                            <tr>
                                <td class="important-info">${o.ProductId}</td>
                                <td><img class="product-image" src="${o.productImage}" alt="Product Image"></td>
                                <td class="important-info">${o.categoryName}</td>
                                <td class="important-info">${o.packagingType}</td>
                                <td class="important-info">${o.quantityPerPackage}</td>
                                <td class="important-info">${o.unitPrice}</td>
                                <td>
                                    <form action="packageload" method="get">
                                        <input type="hidden" name="productId" value="${o.productId}" />
                                        <input type="hidden" name="packagingId" value="${o.packagingId}" />
                                        <button type="submit" class="edit-button">Sửa</button>
                                    </form>
                                </td>
                            </tr>         
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </body>
</html>
