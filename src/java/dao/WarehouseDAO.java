/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import entity.WareHouse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class WarehouseDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    // Lấy tất cả kho/cửa hàng
    public List<WareHouse> getAllWarehouses() {
        List<WareHouse> list = new ArrayList<>();
        String query = "SELECT * FROM WareHouse_Final"; // Giả sử bảng WareHouse đã tồn tại trong DB
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new WareHouse(
                        rs.getInt("id"), // ID cửa hàng/kho
                        rs.getString("store_code"), // Mã cửa hàng
                        rs.getString("store_name"), // Tên cửa hàng
                        rs.getString("description"), // Mô tả cửa hàng
                        rs.getDate("created_at"),
                        rs.getDate("updated_at")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    

    // Thêm kho/cửa hàng
    public void insertWarehouse(String storeCode, String storeName, String description) {
        String query = "INSERT INTO WareHouse_Final (store_code, store_name, description, created_at, updated_at) VALUES (?, ?, ?, ?, ?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, storeCode);
            ps.setString(2, storeName);
            ps.setString(3, description);
            ps.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now())); // Thời gian tạo
            ps.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now())); // Thời gian cập nhật
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Cập nhật kho/cửa hàng
    public void updateWarehouse(int id, String storeCode, String storeName, String description) {
        String query = "UPDATE WareHouse_Final SET store_code = ?, store_name = ?, description = ?, updated_at = ? WHERE id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, storeCode);
            ps.setString(2, storeName);
            ps.setString(3, description);
            ps.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now())); // Cập nhật thời gian hiện tại
            ps.setInt(5, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Xóa kho/cửa hàng
    public void deleteWarehouse(int id) {
        String query = "DELETE FROM WareHouse_Final WHERE id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Lấy kho/cửa hàng theo ID
    public WareHouse getWarehouseById(int id) {
        String query = "SELECT * FROM WareHouse_Final WHERE id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new WareHouse(
                        rs.getInt("id"),
                        rs.getString("store_code"),
                        rs.getString("store_name"),
                        rs.getString("description"),
                        rs.getDate("created_at"),
                        rs.getDate("updated_at")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        WarehouseDAO warehouseDAO = new WarehouseDAO();

        // Kiểm tra chức năng lấy danh sách kho/cửa hàng
        List<WareHouse> warehouses = warehouseDAO.getAllWarehouses();
        for (WareHouse warehouse : warehouses) {
            System.out.println("Warehouse ID: " + warehouse.getId() +
                               ", Store Code: " + warehouse.getStore_code() +
                               ", Store Name: " + warehouse.getStore_name() +
                               ", Created At: " + warehouse.getCreated_at() +
                               ", Updated At: " + warehouse.getUpdated_at());
        }

//        // Thêm một kho/cửa hàng mới
//        warehouseDAO.insertWarehouse("S01", "Cửa hàng A", "Cửa hàng A nằm ở trung tâm thành phố");
//
//        // Cập nhật thông tin kho/cửa hàng
//        if (!warehouses.isEmpty()) {
//            WareHouse firstWarehouse = warehouses.get(0);
//            warehouseDAO.updateWarehouse(firstWarehouse.getId(), "S02", "Cửa hàng B", "Mô tả mới cho cửa hàng B");
//        }
//
//        // Lấy kho/cửa hàng theo ID
//        if (!warehouses.isEmpty()) {
//            WareHouse warehouseById = warehouseDAO.getWarehouseById(warehouses.get(0).getId());
//            System.out.println("\nThông tin kho/cửa hàng theo ID:");
//            System.out.println("Warehouse ID: " + warehouseById.getId() +
//                               ", Store Code: " + warehouseById.getStore_code() +
//                               ", Store Name: " + warehouseById.getStore_name() +
//                               ", Created At: " + warehouseById.getCreated_at() +
//                               ", Updated At: " + warehouseById.getUpdated_at());
//        }
//
//        // Xóa kho/cửa hàng
//        if (!warehouses.isEmpty()) {
//            warehouseDAO.deleteWarehouse(warehouses.get(0).getId());
//            System.out.println("\nĐã xóa kho/cửa hàng có ID: " + warehouses.get(0).getId());
//        }
    }
}

