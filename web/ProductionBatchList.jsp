<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Production Batch List</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f4f4f9;
            font-family: Arial, sans-serif;
        }
        .container {
            margin-top: 50px;
            background: #fff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h2 {
            text-align: center;
            margin-bottom: 30px;
        }
        table {
            width: 100%;
        }
        .badge-active {
            background-color: #28a745;
        }
        .badge-inactive {
            background-color: #dc3545;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Danh Sách Lô Sản Xuất</h2>
        <table class="table table-bordered table-striped">
            <thead>
                <tr>
                    <th>ID Lô Sản Xuất</th>
                    <th>ID Sản Phẩm</th>
                    <th>ID Đợt Nhập Kho</th>
                    <th>Số Lô</th>
                    <th>Ngày Sản Xuất</th>
                    <th>Ngày Hết Hạn</th>
                    <th>Trạng Thái</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="batch" items="${listBatches}">
                    <tr>
                        <td>${batch.batchId}</td>
                        <td>${batch.productId}</td>
                        <td>${batch.importId}</td>
                        <td>${batch.batchNumber}</td>
                        <td>${batch.manufactureDate}</td>
                        <td>${batch.expirationDate}</td>
                        <td>
                            <c:choose>
                                <c:when test="${batch.isActive}">
                                    <span class="badge badge-pill badge-active">Hoạt Động</span>
                                </c:when>
                                <c:otherwise>
                                    <span class="badge badge-pill badge-inactive">Ngưng Hoạt Động</span>
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
