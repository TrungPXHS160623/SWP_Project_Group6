/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import entity.Inventory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class InventoryDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    // Kiểm tra tồn tại của Inventory dựa trên productId, warehouseId, và packagingId
    public Inventory getInventory(int productId, int warehouseId, int packagingId) {
        String query = "SELECT * FROM Inventory_Final WHERE ProductID = ? AND WarehouseID = ? AND PackagingID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, productId);
            ps.setInt(2, warehouseId);
            ps.setInt(3, packagingId);
            rs = ps.executeQuery();

            if (rs.next()) {
                return new Inventory(
                        rs.getInt("ProductID"),
                        rs.getInt("WarehouseID"),
                        rs.getInt("PackagingID"),
                        rs.getInt("CurrentQuantity")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return null; // Không tìm thấy Inventory
    }
    // Hàm cập nhật số lượng tồn kho

    public boolean updateInventoryQuantity(int productId, int warehouseId, int packagingId, int updatedQuantity) {
        String query = "UPDATE Inventory_Final SET CurrentQuantity = ? WHERE ProductID = ? AND WarehouseID = ? AND PackagingID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, updatedQuantity);
            ps.setInt(2, productId);
            ps.setInt(3, warehouseId);
            ps.setInt(4, packagingId);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return false;
    }

    // Hàm thêm hoặc cập nhật Inventory
    public boolean createOrUpdateInventory(int productId, int warehouseId, int packagingId, int newQuantity) {
        Inventory existingInventory = getInventory(productId, warehouseId, packagingId);

        if (existingInventory == null) {
            // Nếu Inventory chưa tồn tại, thêm mới
            return createInventory(productId, warehouseId, packagingId, newQuantity);
        } else {
            // Nếu Inventory đã tồn tại, cập nhật số lượng
            int updatedQuantity = existingInventory.getCurrentQuantity() + newQuantity;
            return updateInventoryQuantity(productId, warehouseId, packagingId, updatedQuantity);
        }
    }

    // Thêm một mục tồn kho mới
    public boolean createInventory(int productId, int warehouseId, int packagingId, int currentQuantity) {
        String query = "INSERT INTO Inventory_Final (ProductID, WarehouseID, PackagingID, CurrentQuantity) VALUES (?, ?, ?, ?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, productId);
            ps.setInt(2, warehouseId);
            ps.setInt(3, packagingId);
            ps.setInt(4, currentQuantity);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
        } finally {
            closeResources();
        }
        return false;
    }

    // Lấy tất cả hàng tồn kho
    public List<Inventory> getAllInventories() {
        List<Inventory> inventoryList = new ArrayList<>();
        String query = "SELECT * FROM Inventory_Final";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Inventory inventory = new Inventory();
                inventory.setProductId(rs.getInt("ProductID"));
                inventory.setWarehouseId(rs.getInt("WarehouseID"));
                inventory.setPackagingId(rs.getInt("PackagingID"));
                inventory.setCurrentQuantity(rs.getInt("CurrentQuantity"));
                inventoryList.add(inventory);
            }
        } catch (Exception e) {
        } finally {
            closeResources();
        }
        return inventoryList;
    }

    // Cập nhật thông tin hàng tồn kho
    public boolean updateInventory(int productId, int warehouseId, int packagingId, int currentQuantity) throws Exception {
        String query = "UPDATE Inventory_Final SET CurrentQuantity = ? WHERE ProductID = ? AND WarehouseID = ? AND PackagingID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, currentQuantity);
            ps.setInt(2, productId);
            ps.setInt(3, warehouseId);
            ps.setInt(4, packagingId);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
        } finally {
            closeResources();
        }
        return false;
    }

    // Xóa hàng tồn kho
    public boolean deleteInventory(int productId, int warehouseId, int packagingId) {
        String query = "DELETE FROM Inventory_Final WHERE ProductID = ? AND WarehouseID = ? AND PackagingID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, productId);
            ps.setInt(2, warehouseId);
            ps.setInt(3, packagingId);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
        } finally {
            closeResources();
        }
        return false;
    }

    // Đóng các tài nguyên
    private void closeResources() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        InventoryDAO dao = new InventoryDAO();

        // Thêm một mục tồn kho
        boolean isCreated = dao.createInventory(60, 1, 2, 500);
        if (isCreated) {
            System.out.println("Mục tồn kho đã được thêm thành công.");
        } else {
            System.out.println("Không thể thêm mục tồn kho.");
        }

        // Lấy tất cả hàng tồn kho
        List<Inventory> inventoryList = dao.getAllInventories();
        for (Inventory inventory : inventoryList) {
            System.out.println("Hàng tồn kho - Sản phẩm ID: " + inventory.getProductId() + ", Kho ID: " + inventory.getWarehouseId() + ", Số lượng: " + inventory.getCurrentQuantity());
        }

//        // Cập nhật hàng tồn kho
//        if (!inventoryList.isEmpty()) {
//            Inventory inventoryToUpdate = inventoryList.get(0);
//            boolean isUpdated = dao.updateInventory(inventoryToUpdate.getProductId(), inventoryToUpdate.getWarehouseId(), inventoryToUpdate.getPackagingId(), new int("600"));
//            if (isUpdated) {
//                System.out.println("Mục tồn kho đã được cập nhật thành công.");
//            } else {
//                System.out.println("Không thể cập nhật mục tồn kho.");
//            }
//        }
//
//        // Xóa hàng tồn kho
//        if (!inventoryList.isEmpty()) {
//            Inventory inventoryToDelete = inventoryList.get(0);
//            boolean isDeleted = dao.deleteInventory(inventoryToDelete.getProductId(), inventoryToDelete.getWarehouseId(), inventoryToDelete.getPackagingId());
//            if (isDeleted) {
//                System.out.println("Mục tồn kho đã được xóa thành công.");
//            } else {
//                System.out.println("Không thể xóa mục tồn kho.");
//            }
//        }
    }
}
