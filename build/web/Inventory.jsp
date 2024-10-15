<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <title>Quản lý kho</title>
        <style>
            body {
                font-family: Arial, sans-serif;
            }
            .container {
                width: 80%;
                margin: auto;
            }
            h1 {
                text-align: center;
                color: #004080;
            }
            form {
                margin-bottom: 20px;
                padding: 20px;
                border: 1px solid #ddd;
                background-color: #f9f9f9;
            }
            label {
                display: block;
                margin-bottom: 10px;
            }
            input[type="text"], input[type="number"] {
                width: 100%;
                padding: 10px;
                margin-bottom: 10px;
                border: 1px solid #ddd;
            }
            table {
                width: 100%;
                border-collapse: collapse;
                margin-top: 20px;
            }
            table, th, td {
                border: 1px solid #ddd;
            }
            th, td {
                padding: 15px;
                text-align: left;
            }
            th {
                background-color: #004080;
                color: white;
            }
            .btn {
                background-color: #004080;
                color: white;
                padding: 10px 20px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                border: none;
            }
            .btn:hover {
                background-color: #0059b3;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1>Quản lý kho</h1>
            <!-- Danh sách tồn kho -->
            <h2>Danh sách tồn kho</h2>
            <table>
                <thead>
                    <tr>
                        <th>Mã sản phẩm</th>
                        <th>Mã kho</th>
                        <th>Mã bao bì</th>
                        <th>Số lượng hiện tại</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- Lặp qua danh sách Inventory được gửi từ servlet -->
                    <c:forEach var="inventory" items="${listI}">
                        <tr>
                            <td>${inventory.productId}</td>
                            <!-- Lấy tên kho từ listW dựa trên warehouseId -->
                            <td>
                                <c:forEach var="warehouse" items="${listW}">
                                    <c:if test="${warehouse.id == inventory.warehouseId}">
                                        ${warehouse.store_name}
                                    </c:if>
                                </c:forEach>
                            </td>

                            <!-- Lấy tên bao bì từ listP dựa trên packagingId -->
                            <td>
                                <c:forEach var="packaging" items="${listP}">
                                    <c:if test="${packaging.packagingId == inventory.packagingId}">
                                        ${packaging.packagingType}
                                    </c:if>
                                </c:forEach>
                            </td>
                            <td>${inventory.currentQuantity}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
