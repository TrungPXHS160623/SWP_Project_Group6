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
                color: #FF5733; /* Màu đỏ cam nổi bật */
                margin-bottom: 20px;
                text-align: center;
                font-family: 'Arial Black', sans-serif; /* Kiểu chữ đậm và nổi bật */
            }

            h2 {
                color: #28A745; /* Màu xanh lá cây tươi sáng */
                margin-bottom: 20px;
                text-align: center;
                font-family: 'Georgia', serif; /* Kiểu chữ serif thanh lịch */
                font-weight: bold; /* Chữ đậm hơn */
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
                color: #5a5a5a;
                font-weight: bold;
            }

            .button-group {
                display: flex;
                justify-content: center; /* Căn giữa nút */
                align-items: center;
                height: 100%;
            }

            .button {
                display: flex;
                justify-content: center; /* Căn giữa theo chiều ngang */
                align-items: center; /* Căn giữa theo chiều dọc */
                text-align: center; /* Căn giữa chữ */
                color: #fff;
                border: none;
                padding: 15px 20px;
                border-radius: 5px;
                cursor: pointer;
                transition: background-color 0.3s ease;
                margin: 0 5px;
                width: 100px;
                height: 50px; /* Chỉnh chiều cao nếu cần */
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

            .button.activate {
                background-color: #28a745; /* Màu xanh lá cho nút Tái kích hoạt */
            }

            .button.activate:hover {
                background-color: #218838; /* Màu xanh lá đậm khi hover */
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

        </style>
    </head>
    <body>
        <div class="container">
            <h1>Quản Lý Sản Phẩm</h1>
            <h2>(Đang bị vô hiệu hoá)</h2>
            <div class="back-home">
                <button class="btn-back-home" onclick="window.location.href = 'home'">
                    Trở Về Trang Chủ
                </button>
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
                        <th>Mô Tả Ngắn</th>
                        <th>Số Đăng Ký</th>
                        <th>Giá</th>
                        <th>Hành Động</th> 
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listP}" var="o">
                        <tr>
                            <td class="important-info">${o.productID}</td>
                            <td class="important-info">${o.productName}</td>
                            <td class="important-info">
                                <c:forEach items="${listC}" var="category">
                                    <c:if test="${category.categoryID == o.categoryId}">
                                        ${category.categoryName}
                                    </c:if>
                                </c:forEach>
                            </td>
                            <td><img src="${o.productImage}" alt="st" class="product-image" /></td>
                            <td class="important-info">${o.ingredients}</td>
                            <td class="important-info">${o.formulation}</td>
                            <td class="important-info">${o.specification}</td>
                            <td class="important-info">${o.shortDescription}</td>
                            <td class="important-info">${o.registrationNumber}</td>
                            <td class="important-info">${o.price}</td>
                            <td class="button-group">

                                <form action="managerdeactiveproduct" method="post" style="display:inline;">
                                    <input type="hidden" name="pid3" value="${o.productID}">
                                    <button type="submit" class="button activate">Tái kích hoạt</button>
                                </form>
                            </td>
                        </tr>  
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
