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
            }, 4000); // Thời gian 5000ms = 5 giây
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
            }, 4000);
        </script>
        <%
                session.removeAttribute("addMessage"); // Xóa thông báo sau khi hiển thị
            }
        %>

        <%
     String deactiveMessage = (String) session.getAttribute("deactiveMessage");
     if (deactiveMessage != null) {
        %>
        <div id="deactiveAlert" class="alert alert-success" style="display: flex; align-items: center; background-color: #d4edda; border-color: #c3e6cb; color: #155724; padding: 15px; border-radius: 5px; margin-bottom: 20px;">
            <i class="fas fa-check-circle" style="font-size: 24px; margin-right: 10px;"></i>
            <div>
                <strong>Thông Báo:</strong> <%= deactiveMessage %>
            </div>
            <button type="button" onclick="this.parentElement.style.display = 'none';" style="background: transparent; border: none; color: #155724; cursor: pointer; margin-left: auto;">
                <i class="fas fa-times-circle" style="font-size: 24px;"></i>
            </button>
        </div>
        <script>
            // Tự động ẩn thông báo sau 5 giây
            setTimeout(function () {
                document.getElementById('deactiveAlert').style.display = 'none';
            }, 4000);
        </script>
        <%
                session.removeAttribute("deactiveMessage"); // Đảm bảo xóa thông báo đúng tên
            }
        %>

        <% 
    String reactivateMessage = (String) session.getAttribute("reactivateMessage");
    if (reactivateMessage != null) {
        %>
        <div id="reactivateAlert" class="alert alert-success" style="display: flex; align-items: center; background-color: #d4edda; border-color: #c3e6cb; color: #155724; padding: 15px; border-radius: 5px; margin-bottom: 20px;">
            <i class="fas fa-check-circle" style="font-size: 24px; margin-right: 10px;"></i>
            <div>
                <strong>Thông Báo:</strong> <%= reactivateMessage %>
            </div>
            <button type="button" onclick="this.parentElement.style.display = 'none';" style="background: transparent; border: none; color: #155724; cursor: pointer; margin-left: auto;">
                <i class="fas fa-times-circle" style="font-size: 24px;"></i>
            </button>
        </div>
        <script>
            setTimeout(function () {
                document.getElementById('reactivateAlert').style.display = 'none';
            }, 4000);
        </script>
        <% 
                session.removeAttribute("reactivateMessage"); // Xóa thông báo sau khi hiển thị
            }
        %>


        <% 
    String searchErrorMessage = (String) session.getAttribute("searchErrorMessage");
    if (searchErrorMessage != null) { 
        %>
        <div id="searchErrorAlert" class="alert alert-danger" style="display: flex; align-items: center; background-color: #f8d7da; border-color: #f5c6cb; color: #721c24; padding: 15px; border-radius: 5px; margin-bottom: 20px;">
            <i class="fas fa-exclamation-circle" style="font-size: 24px; margin-right: 10px;"></i>
            <div>
                <strong>Thông Báo:</strong> <%= searchErrorMessage %>
            </div>
            <button type="button" onclick="this.parentElement.style.display = 'none';" style="background: transparent; border: none; color: #721c24; cursor: pointer; margin-left: auto;">
                <i class="fas fa-times-circle" style="font-size: 24px;"></i>
            </button>
        </div>
        <script>
            setTimeout(function () {
                document.getElementById('searchErrorAlert').style.display = 'none';
            }, 4000);
        </script>
        <% 
                session.removeAttribute("searchErrorMessage"); // Xóa thông báo sau khi hiển thị
            } 
        %>


    


        <div class="container">
            <a href="manager" style="text-decoration: none;">
                <h1>Quản Lý Sản Phẩm</h1>
            </a>
            <h2>(Đang hoạt động)</h2>
            <div class="back-home">
                <button class="btn-back-home" onclick="window.location.href = 'home'">
                    Trở Về Trang Chủ
                </button>
            </div>
            <div class="add-product">
                <!-- Phần tìm kiếm -->
                <div class="search-container" style="margin-bottom: 10px; margin-top: 20px">
                    <form action="search2" method="post" class="form-inline">
                        <div class="input-group" style="display: flex; align-items: center; width: 100%;">
                            <input value="${ValueOfSearch}" name="txt" type="text" class="form-control" 
                                   aria-label="Small" aria-describedby="inputGroup-sizing-sm" 
                                   placeholder="Tìm kiếm thuốc..." 
                                   style="height: 50px; font-size: 18px; flex: 1; max-width: 400px; margin-right: 5px;"> 
                            <button type="submit" class="btn btn-secondary btn-number" style="height: 50px; font-size: 18px;">
                                <i class="fa fa-search"></i>
                            </button>
                        </div>
                    </form>
                </div>


                <a href="managerdeactiveproduct"  style="margin-left: 10px;">Xem Sản Phẩm Đang Bị Vô Hiệu Hóa</a>
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
                                <form action="load" method="get" style="display:inline;">
                                    <input type="hidden" name="pid" value="${o.productID}">
                                    <button type="submit" class="button edit">Sửa</button>
                                </form>
                                <form action="deactive" method="post" style="display:inline;">
                                    <input type="hidden" name="pid2" value="${o.productID}">
                                    <button type="submit" class="button deactivate">Vô hiệu hóa</button>
                                </form>
                            </td>
                        </tr>  
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
