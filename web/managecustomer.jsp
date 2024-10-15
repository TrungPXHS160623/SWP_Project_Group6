<%-- 
    Document   : managecustomer
    Created on : Oct 13, 2024, 10:38:07 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Quản lý khách hàng - Nhà Thuốc Long Châu</title>
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

            .add-product a:hover {
                background-color: #218838;
            }

            .button.edit {
                background-color: #ffc107; /* Màu vàng cho nút Sửa */
            }

            .button.edit:hover {
                background-color: #e0a800; /* Màu vàng đậm khi hover */
            }

            .button.deactivate {
                background-color: #dc3545; /* Màu đỏ cho nút Vô hiệu hóa */
            }

            .button.deactivate:hover {
                background-color: #c82333; /* Màu đỏ đậm khi hover */
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
        <c:set var="c" value="${sessionScope.customer}"></c:set>
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">Customer Name</th>
                        <th scope="col">Username</th>
                        <th scope="col">Date of Birth</th>
                        <th scope="col">Gender</th>
                        <th scope="col">Phone</th>
                        <th scope="col">Email</th>
                        <th scope="col">Is Active</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${listC}" var="cus">
                    <c:if test="${customer.username != c.username}">
                    <tr>
                        <th>${cus.fullName}</th>
                        <td>${cus.username}</td>
                        <td>${cus.dob}</td>
                        <td>${cus.gender}</td>
                        <td>${cus.phone}</td>
                        <td>${cus.email}</td>
                        <td>${cus.isActive}</td>
                    </tr>
                    </c:if>
                </c:forEach>
            </tbody>
        </table>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
                integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
                integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
    </body>
    </body>
</html>
