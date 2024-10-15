<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Danh Sách Nhập Hàng</title>

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

        <!-- Custom CSS -->
        <style>
            body {
                background-color: #f4f8fb;
                font-family: 'Arial', sans-serif;
            }
            .container {
                margin-top: 50px;
                background-color: white;
                padding: 30px;
                border-radius: 8px;
                box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
            }
            h2 {
                font-weight: bold;
                color: #007bff;
                text-align: center;
                margin-bottom: 30px;
            }
            .table {
                margin-bottom: 30px;
                border-collapse: collapse;
                background-color: #ffffff;
            }
            .table thead {
                background-color: #007bff;
                color: white;
            }
            .table th, .table td {
                text-align: center;
                vertical-align: middle;
                padding: 12px;
            }
            .table tbody tr:hover {
                background-color: #f1f3f5;
            }
            .table-striped tbody tr:nth-of-type(odd) {
                background-color: #f9f9f9;
            }
            .btn {
                background-color: #007bff;
                color: white;
                font-weight: bold;
                border: none;
                padding: 10px 20px;
                border-radius: 5px;
                transition: background-color 0.3s;
            }
            .btn:hover {
                background-color: #0056b3;
                color: white;
            }
            .text-small {
                font-size: 0.875rem;
                color: #6c757d;
            }
        </style>
    </head>
    <body>
        <% 
   String importSuccessMessage = (String) session.getAttribute("importSuccessMessage");

   if (importSuccessMessage != null) { 
        %>
        <div id="importSuccessAlert" class="alert alert-success" style="display: flex; align-items: center; background-color: #d4edda; border-color: #c3e6cb; color: #155724; padding: 15px; border-radius: 5px; margin-bottom: 20px;">
            <i class="fas fa-check-circle" style="font-size: 24px; margin-right: 10px;"></i>
            <div>
                <strong>Thông Báo:</strong> <%= importSuccessMessage %>
            </div>
            <button type="button" onclick="this.parentElement.style.display = 'none';" style="background: transparent; border: none; color: #155724; cursor: pointer; margin-left: auto;">
                <i class="fas fa-times-circle" style="font-size: 24px;"></i>
            </button>
        </div>
        <script>
            setTimeout(function () {
                document.getElementById('importSuccessAlert').style.display = 'none';
            }, 4000);
        </script>
        <%
                session.removeAttribute("importSuccessMessage"); // Xóa thông báo sau khi hiển thị
            }
        %>
        <div class="text-center">
            <a href="home" class="btn">Trở về trang chủ</a>
        </div>
        <div class="container">
            <h2>Danh Sách Nhập Hàng</h2>

            <table class="table table-bordered table-striped">
                <thead>
                    <tr>
                        <th>ID Đợt Nhập</th>
                        <th>Kho</th>
                        <th>Nhân Viên Thực Hiện</th>
                        <th>Nhà Cung Cấp</th>
                        <th>Ngày Nhập</th>
                        <th>Trạng Thái</th>
                        <th>Ngày Tạo</th>
                        <th>Ngày Cập Nhật</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="productImport" items="${listImports}">
                        <tr>
                            <td>${productImport.id}</td>
                            <td>
                                <c:forEach var="warehouse" items="${listW}">
                                    <c:if test="${warehouse.id == productImport.storeId}">
                                        ${warehouse.store_name}
                                    </c:if>
                                </c:forEach>
                            </td>
                            <td>
                                <c:forEach var="employee" items="${listE}">
                                    <c:if test="${employee.employee_id == productImport.employeeId}">
                                        ${employee.employee_name}
                                    </c:if>
                                </c:forEach>
                            </td>
                            <td>
                                <c:forEach var="supplier" items="${listS}">
                                    <c:if test="${supplier.supplier_id == productImport.supplierId}">
                                        ${supplier.supplier_name}
                                    </c:if>
                                </c:forEach>
                            </td>
                            <td>${productImport.importDate}</td>
                            <td>
                                <c:forEach var="status" items="${listSS}">
                                    <c:if test="${status.statusId == productImport.status_id}">
                                        ${status.statusName}
                                    </c:if>
                                </c:forEach>
                            </td>
                            <td>${productImport.created_at}</td>
                            <td>${productImport.updated_at}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <div class="text-center">
                <a href="importproduct" class="btn">Thêm Đợt Nhập Mới</a>
            </div>

            <div class="text-small text-center mt-4">
                <p>&copy; 2024 Nhà Thuốc Long Châu. All Rights Reserved.</p>
            </div>
        </div>

        <!-- Bootstrap JS and dependencies -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    </body>
</html>
