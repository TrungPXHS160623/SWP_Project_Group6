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
        <% 
    String updateMessage = (String) session.getAttribute("updateMessage");
    if (updateMessage != null) {
        %>
        <div id="updateAlert" class="alert alert-info" style="display: flex; align-items: center; background-color: #d1ecf1; border-color: #bee5eb; color: #0c5460; padding: 15px; border-radius: 5px; margin-bottom: 20px;">
            <i class="fas fa-info-circle" style="font-size: 24px; margin-right: 10px;"></i>
            <div>
                <strong>Thông Báo:</strong> <%= updateMessage %>
            </div>
            <button type="button" onclick="this.parentElement.style.display = 'none';" style="background: transparent; border: none; color: #0c5460; cursor: pointer; margin-left: auto;">
                <i class="fas fa-times-circle" style="font-size: 24px;"></i>
            </button>
        </div>

        <script>
            // Tự động ẩn thông báo sau 5 giây
            setTimeout(function () {
                document.getElementById('updateAlert').style.display = 'none';
            }, 5000); // Thời gian 5000ms = 5 giây
        </script>
        <% 
                session.removeAttribute("updateMessage"); // Xóa thông báo sau khi hiển thị
            }
        %>
        <script>
            function confirmDelete() {
                return confirm("Bạn có chắc chắn muốn xóa sản phẩm này không?");
            }
        </script>


        <% 
    String addMessage = (String) session.getAttribute("addMessage");
    if (addMessage != null) {
        %>
        <div id="addAlert" class="alert alert-success" style="display: flex; align-items: center; background-color: #d4edda; border-color: #c3e6cb; color: #155724; padding: 15px; border-radius: 5px; margin-bottom: 20px;">
            <i class="fas fa-check-circle" style="font-size: 24px; margin-right: 10px;"></i>
            <div>
                <strong>Thông Báo:</strong> <%= addMessage %>
            </div>
            <button type="button" onclick="this.parentElement.style.display = 'none';" style="background: transparent; border: none; color: #155724; cursor: pointer; margin-left: auto;">
                <i class="fas fa-times-circle" style="font-size: 24px;"></i>
            </button>
        </div>
        <script>
            // Tự động ẩn thông báo sau 5 giây
            setTimeout(function () {
                document.getElementById('addAlert').style.display = 'none';
            }, 5000);
        </script>
        <%
                session.removeAttribute("addMessage"); // Xóa thông báo sau khi hiển thị
            }
        %>

        <div class="container">
            <h1>Quản Lý Sản Phẩm</h1>
            <div class="back-home">
                <button class="btn-back-home" onclick="window.location.href = 'home'">
                    Trở Về Trang Chủ
                </button>
            </div>
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
                            <td class="important-info">${o.targetAudience}</td>
                            <td class="important-info">
                                <c:choose>
                                    <c:when test="${o.prescriptionMedication}">
                                        Có
                                    </c:when>
                                    <c:otherwise>
                                        Không
                                    </c:otherwise>
                                </c:choose>
                            </td>

                            <td class="important-info">${o.shortDescription}</td>
                            <td class="important-info">${o.registrationNumber}</td>
                            <td class="important-info">${o.price}</td>
                            <td class="button-group">
                                <a href="load?pid=${o.productID}" class="button edit">Sửa</a>
                                <a href="delete?pid=${o.productID}" class="button delete" onclick="return confirmDelete();">Xóa</a> 
                            </td>
                        </tr>  
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
