/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import entity.ProductImports;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Acer
 */
public class ProductImportsDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    // Thêm đơn nhập kho mới
    public boolean createImport(int storeId, int employeeId, int supplierId, Date importDate, int statusId) {
        String query = "INSERT INTO Product_Imports_Final (store_id, employee_id, supplier_id, import_date, created_at, updated_at, status_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);

            ps.setInt(1, storeId);
            ps.setInt(2, employeeId);
            ps.setInt(3, supplierId);
            ps.setDate(4, new java.sql.Date(importDate.getTime())); // Chuyển đổi Date sang java.sql.Date
            ps.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now())); // Ngày tạo
            ps.setTimestamp(6, Timestamp.valueOf(LocalDateTime.now())); // Ngày cập nhật
            ps.setInt(7, statusId);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return false;
    }

    // Lấy ID của đơn nhập kho vừa tạo
    public int getLastInsertedImportId() {
        String query = "SELECT MAX(id) FROM Product_Imports_Final";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return -1;
    }

    // Lấy tất cả đơn nhập kho
    public List<ProductImports> getAllImports() {
        List<ProductImports> list = new ArrayList<>();
        String query = "SELECT * FROM Product_Imports_Final";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ProductImports(
                        rs.getInt("id"),
                        rs.getInt("store_id"),
                        rs.getInt("employee_id"),
                        rs.getInt("supplier_id"),
                        rs.getDate("import_date"),
                        rs.getDate("created_at"),
                        rs.getDate("updated_at"),
                        rs.getInt("status_id")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return list;
    }

    // Cập nhật đơn nhập kho
    public boolean updateImport(int importId, int storeId, int employeeId, int supplierId, Date importDate, int statusId) {
        String query = "UPDATE Product_Imports_Final SET store_id = ?, employee_id = ?, supplier_id = ?, import_date = ?, updated_at = ? ,status_id = ? WHERE id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, storeId);
            ps.setInt(2, employeeId);
            ps.setInt(3, supplierId);
            ps.setDate(4, new java.sql.Date(importDate.getTime())); // Chuyển đổi Date sang java.sql.Date
            ps.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now())); // Ngày cập nhật
            ps.setInt(6, statusId);
            ps.setInt(7, importId);

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return false;
    }

    // Xóa đơn nhập kho
    public boolean deleteImport(int importId) {
        String query = "DELETE FROM Product_Imports_Final WHERE id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, importId);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
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

    public static void main(String[] args) {
        ProductImportsDAO productImportsDAO = new ProductImportsDAO();
        
        List<ProductImports> imports2 = productImportsDAO.getAllImports();
        for (ProductImports productImports : imports2) {
            System.out.println(productImports);
        }
        
        

//        // Thêm một đơn nhập kho mới
//        int storeId = 1; // Giả sử ID của cửa hàng
//        int employeeId = 1; // Giả sử ID của nhân viên
//        int supplierId = 1; // Giả sử ID của nhà cung cấp
//        Date importDate = new Date(); // Ngày nhập kho
//        int statusId = 1; // Giả sử trạng thái của đơn nhập kho
//
//        boolean isCreated = productImportsDAO.createImport(storeId, employeeId, supplierId, importDate, statusId);
//        if (isCreated) {
//            System.out.println("Đơn nhập kho đã được thêm thành công.");
//
//            // Lấy ID của đơn nhập kho vừa tạo
//            int importId = productImportsDAO.getLastInsertedImportId();
//            System.out.println("ID của đơn nhập kho vừa tạo: " + importId);
//
//            // Lấy tất cả đơn nhập kho
//            List<ProductImports> imports = productImportsDAO.getAllImports();
//            for (ProductImports productImport : imports) {
//                System.out.println("Import ID: " + productImport.getId() +
//                                   ", Store ID: " + productImport.getStoreId() +
//                                   ", Employee ID: " + productImport.getEmployeeId() +
//                                   ", Supplier ID: " + productImport.getSupplierId() +
//                                   ", Import Date: " + productImport.getImportDate() +
//                                   ", Created At: " + productImport.getCreated_at()+
//                                   ", Updated At: " + productImport.getUpdated_at()+
//                                   ", Status ID: " + productImport.getStatus_id());
//                        
//            }
//
////            // Cập nhật đơn nhập kho
////            boolean isUpdated = productImportsDAO.updateImport(importId, storeId, employeeId, supplierId, importDate, statusId);
////            if (isUpdated) {
////                System.out.println("Đơn nhập kho đã được cập nhật thành công.");
////            }
////
////            // Xóa đơn nhập kho
////            boolean isDeleted = productImportsDAO.deleteImport(importId);
////            if (isDeleted) {
////                System.out.println("Đơn nhập kho đã được xóa thành công.");
////            }
//        } else {
//            System.out.println("Không thể thêm đơn nhập kho.");
//        }
    }
}
