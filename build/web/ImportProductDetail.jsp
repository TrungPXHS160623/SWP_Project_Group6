<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Chi Tiết Nhập Hàng - Nhà Thuốc Long Châu</title>
        <link rel="stylesheet" href="css/style.css">
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f5f5f5;
                margin: 0;
                padding: 0;
            }

            .container {
                width: 80%;
                margin: 20px auto;
                background-color: white;
                padding: 20px;
                border-radius: 8px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }

            h2 {
                color: #2a9df4;
            }

            table {
                width: 100%;
                border-collapse: collapse;
            }

            th, td {
                padding: 12px;
                text-align: left;
                border-bottom: 1px solid #ddd;
            }

            th {
                background-color: #2a9df4;
                color: white;
            }

            tr:hover {
                background-color: #f1f1f1;
            }

            .table {
                width: 100%;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h2>Danh Sách Chi Tiết Nhập Hàng</h2>

            <table border="1" class="table table-striped">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Đợt Nhập Kho</th>
                        <th>Sản Phẩm</th>
                        <th>Loại Bao Bì</th>
                        <th>Số Lượng</th>
                        <th>Giá Đơn Vị</th>
                        <th>Số Lô Sản Xuất</th>
                        <th>Ngày Sản Xuất</th>
                        <th>Ngày Hết Hạn</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="detail" items="${listDetails}">
                        <tr>
                            <td>${detail.id}</td>
                            <td>${detail.import_id}</td>
                            <td>${detail.product_id}</td>
                            <!-- Lấy tên bao bì từ listP dựa trên packagingId -->
                            <td>
                                <c:forEach var="packaging" items="${listP}">
                                    <c:if test="${packaging.packagingId == detail.packaging_id}">
                                        ${packaging.packagingType}
                                    </c:if>
                                </c:forEach>
                            </td>
                            <td>${detail.quantity}</td>
                            <td>${detail.unitPrice}</td>
                            <td>${detail.batchNumber}</td>
                            <td>${detail.manufactureDate}</td>
                            <td>${detail.expirationDate}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
