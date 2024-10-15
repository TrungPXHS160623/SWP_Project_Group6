<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Nhập Sản Phẩm</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <style>
            body {
                background-color: #f8f9fa;
            }
            .container {
                background-color: #fff;
                border-radius: 5px;
                padding: 30px;
                box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            }
            h2 {
                margin-bottom: 20px;
                color: #343a40;
            }
            h3 {
                margin-top: 30px;
                margin-bottom: 20px;
                color: #007bff;
            }
            .btn-custom {
                background-color: #007bff;
                color: white;
            }
            .btn-custom:hover {
                background-color: #0056b3;
                color: white;
            }
            .productDetail {
                margin-bottom: 20px;
                padding: 20px;
                border: 1px solid #e0e0e0;
                border-radius: 5px;
                background-color: #f9f9f9;
            }
            .product-container {
                display: flex;
                flex-wrap: wrap; /* Cho phép các form xuống dòng khi không đủ không gian */
                gap: 15px; /* Khoảng cách giữa các form */
            }

            .productDetail {
                flex: 1 1 calc(30% - 15px); /* Tạo chiều rộng tối đa cho mỗi form */
                border: 1px solid #ccc; /* Đường viền cho form */
                padding: 10px; /* Padding cho form */
                border-radius: 5px; /* Bo tròn góc */
            }
            .readonly-input {
                background-color: #f8f9fa; /* Màu nền nhẹ (xám nhạt) */
                color: #495057; /* Màu chữ tối */
                border: 1px solid #ced4da; /* Viền nhẹ */
                font-weight: bold; /* Chữ đậm */
            }

            /* Thay đổi màu sắc khi di chuột */
            .readonly-input:hover {
                background-color: #e2e6ea; /* Màu nền khi di chuột */
            }
        </style>
    </head>
    <body>




        <%
    String importFailMessage = (String) session.getAttribute("importFailMessage");
    String errorMessages = (String) session.getAttribute("errorMessages");

    if (importFailMessage != null) { 
        %>
        <div id="importFailAlert" class="alert alert-danger" style="display: flex; align-items: center; background-color: #f8d7da; border-color: #f5c6cb; color: #721c24; padding: 15px; border-radius: 5px; margin-bottom: 20px;">
            <i class="fas fa-exclamation-circle" style="font-size: 24px; margin-right: 10px;"></i>
            <div>
                <strong>Thông Báo:</strong> <%= importFailMessage %>
                <br/>
                <% if (errorMessages != null) { %>
                <strong>Lỗi:</strong> <%= errorMessages %>
                <% } %>
            </div>
            <button type="button" onclick="this.parentElement.style.display = 'none';" style="background: transparent; border: none; color: #721c24; cursor: pointer; margin-left: auto;">
                <i class="fas fa-times-circle" style="font-size: 24px;"></i>
            </button>
        </div>
        <script>
            setTimeout(function () {
                document.getElementById('importFailAlert').style.display = 'none';
            }, 4000);
        </script>
        <%
                session.removeAttribute("importFailMessage"); // Xóa thông báo sau khi hiển thị
                session.removeAttribute("errorMessages"); // Xóa danh sách lỗi sau khi hiển thị
            }
        %>
        

        <div class="text-center">
            <a href="home" class="btn">Trở về trang chủ</a>
        </div>
        <div class="container">
            <h2>Nhập Sản Phẩm</h2>

            <!-- Form nhập sản phẩm -->
            <form action="importproduct" method="post">
                <!-- Thông tin chung -->

                <div class="form-group">
                    <label for="employeeId">Mã nhân viên:</label>
                    <input type="text" class="form-control" id="employeeId" name="employeeId" required>
                </div>

                <div class="form-group">
                    <label for="supplier">Nhà cung cấp:</label>
                    <select class="form-control" id="supplier" name="supplier" required aria-label="Default select example">
                        <c:forEach items="${listS}" var="o">
                            <option value="${o.supplier_id}">${o.supplier_name}</option>          
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group">
                    <label for="warehouse">Nhà kho:</label>
                    <select class="form-control" id="warehouse" name="warehouse" required>
                        <c:forEach items="${listW}" var="o">
                            <option value="${o.id}">${o.store_name}</option>          
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group">
                    <!-- Trường ngày nhập hàng (readonly) và hidden field chứa giá trị này -->
                    <label for="importDate">Ngày nhập hàng:</label>
                    <input type="text" class="form-control" id="importDate" name="displayImportDate" value="${DateOfToday}" readonly />

                    <!-- Trường hidden để gửi giá trị ngày nhập về server -->
                    <input type="hidden" id="hiddenImportDate" name="importDate" value="${DateOfToday}" />
                </div>

                <div class="form-group">
                    <label for="statusId">Trạng thái:</label>
                    <input type="hidden" name="statusId" value="${Status.statusId}" />
                    <input type="text" class="form-control readonly-input" id="statusName" name="statusName" value="${Status.statusName}" readonly required />
                </div>

                <!-- Chi tiết sản phẩm nhập -->
                <h3>Chi tiết sản phẩm</h3>
                <div id="productDetails">
                    <div class="productDetail">
                        <label for="product_id">Mã sản phẩm:</label>
                        <input type="text" class="form-control" name="product_id" required>

                        <label for="packaging_id">Mã bao bì:</label>
                        <select class="form-control" id="package" name="packaging_id" required>
                            <c:forEach items="${listP}" var="o">
                                <option value="${o.packagingId}">${o.packagingType}</option>          
                            </c:forEach>
                        </select>

                        <label for="quantity">Số lượng:</label>
                        <input type="number" class="form-control" name="quantity" required>

                        <label for="unitPrice">Giá nhập:</label>
                        <input type="text" class="form-control" name="unitPrice" required>

                        <label for="batchNumber">Số lô sản xuất:</label>
                        <input type="text" class="form-control" name="batchNumber" required>

                        <label for="manufactureDate">Ngày sản xuất:</label>
                        <input type="date" class="form-control" name="manufactureDate" required>

                        <label for="expirationDate">Ngày hết hạn:</label>
                        <input type="date" class="form-control" name="expirationDate" required>
                    </div>
                </div>

                <!-- Nút thêm sản phẩm -->
                <button type="button" class="btn btn-info" id="addProduct">Thêm sản phẩm</button>

                <!-- Nút submit -->
                <button type="submit" class="btn btn-custom">Nhập sản phẩm</button>
            </form>
        </div>

        <script>
            document.getElementById("addProduct").addEventListener("click", function () {
                let productDetailDiv = document.createElement("div");
                productDetailDiv.classList.add("productDetail", "form-group");
                productDetailDiv.style.marginBottom = "20px"; // Thêm khoảng cách dưới mỗi form

                productDetailDiv.innerHTML = `
                    <div class="form-section" style="border: 1px solid #ccc; padding: 10px; border-radius: 5px;">
                        <label for="product_id">Mã sản phẩm:</label>
                        <input type="text" class="form-control" name="product_id" required>

                        <label for="packaging_id">Mã bao bì:</label>
                        <select class="form-control" name="packaging_id" required>
            <c:forEach items="${listP}" var="o">
                                <option value="${o.packagingId}">${o.packagingType}</option>          
            </c:forEach>
                        </select>

                        <label for="quantity">Số lượng:</label>
                        <input type="number" class="form-control" name="quantity" required>

                        <label for="unitPrice">Đơn giá:</label>
                        <input type="text" class="form-control" name="unitPrice" required>

                        <label for="batchNumber">Số lô sản xuất:</label>
                        <input type="text" class="form-control" name="batchNumber" required>

                        <label for="manufactureDate">Ngày sản xuất:</label>
                        <input type="date" class="form-control" name="manufactureDate" required>

                        <label for="expirationDate">Ngày hết hạn:</label>
                        <input type="date" class="form-control" name="expirationDate" required>
                    </div>
                    <hr style="margin: 10px 0;"> <!-- Thêm ngăn cách giữa các form -->
                `;
                document.getElementById("productDetails").appendChild(productDetailDiv);
            });
        </script>

    </body>
</html>
