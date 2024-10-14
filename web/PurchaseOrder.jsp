<!-- purchaseOrder.jsp -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Quản lý Nhập hàng</title>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
        }
        .form-group {
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
    <h1>Danh sách Đơn Nhập Hàng</h1>
    <table>
        <thead>
            <tr>
                <th>Mã Đơn</th>
                <th>Nhà Cung Cấp</th>
                <th>Ngày Đặt Hàng</th>
                <th>Tổng Tiền</th>
                <th>Ngày Tạo</th>
                <th>Ngày Cập Nhật</th>
                <th>Hành Động</th>
            </tr>
        </thead>
        <tbody>
            <!-- Vòng lặp để hiển thị danh sách các đơn nhập hàng -->
            <c:forEach var="order" items="${purchaseOrders}">
                <tr>
                    <td>${order.purchaseOrderId}</td>
                    <td>${order.supplier.supplierName}</td>
                    <td>${order.orderDate}</td>
                    <td>${order.totalAmount}</td>
                    <td>${order.createDate}</td>
                    <td>${order.updateDate}</td>
                    <td>
                        <a href="editPurchaseOrder?orderId=${order.purchaseOrderId}">Sửa</a> |
                        <a href="deletePurchaseOrder?orderId=${order.purchaseOrderId}" onclick="return confirm('Bạn có chắc chắn muốn xóa?')">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <h2>Thêm Đơn Nhập Hàng Mới</h2>
    <form action="addPurchaseOrder" method="post">
        <div class="form-group">
            <label for="supplierId">Nhà Cung Cấp:</label>
            <select name="supplierId" id="supplierId">
                <c:forEach var="supplier" items="${suppliers}">
                    <option value="${supplier.supplierId}">${supplier.supplierName}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="orderDate">Ngày Đặt Hàng:</label>
            <input type="date" id="orderDate" name="orderDate" required>
        </div>
        <div class="form-group">
            <label for="totalAmount">Tổng Tiền:</label>
            <input type="number" id="totalAmount" name="totalAmount" required>
        </div>
        <button type="submit">Thêm Đơn Hàng</button>
    </form>
</body>
</html>
