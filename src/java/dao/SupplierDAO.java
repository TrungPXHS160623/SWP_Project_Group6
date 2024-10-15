/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import entity.Supplier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.Timestamp;

public class SupplierDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    // Lấy tất cả nhà cung cấp
    public List<Supplier> getAllSuppliers() {
        List<Supplier> list = new ArrayList<>();
        String query = "SELECT * FROM Suppliers_Final"; // Giả sử bảng Supplier đã tồn tại trong DB
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Supplier(
                        rs.getInt("supplier_id"), // ID nhà cung cấp
                        rs.getString("supplier_name"), // Tên nhà cung cấp
                        rs.getString("contact_name"), // Tên người liên hệ
                        rs.getString("contact_email"), // Email người liên hệ
                        rs.getString("address"), // Địa chỉ
                        rs.getDate("created_at"),
                        rs.getDate("updated_at")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public Supplier getSupplierById(String sid)
    {
        String query = "select * from Suppliers_Final where supplier_id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, sid);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Supplier(rs.getInt(1)
                        , rs.getString(2)
                        , rs.getString(3)
                        , rs.getString(4)
                        , rs.getString(5)
                        , rs.getDate("created_at")
                        , rs.getDate("updated_at"));
            }
        } catch (Exception e) {
        }
        return null;
    }

    // Thêm nhà cung cấp
    public void insertSupplier(String supplierName, String contactName, String contactEmail, String address) {
        String query = "INSERT INTO Suppliers_Final (supplier_name, contact_name, contact_email, address, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, supplierName);
            ps.setString(2, contactName);
            ps.setString(3, contactEmail);
            ps.setString(4, address);
            ps.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now())); // Thời gian tạo
            ps.setTimestamp(6, Timestamp.valueOf(LocalDateTime.now())); // Thời gian cập nhật
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Cập nhật nhà cung cấp
    public void updateSupplier(int supplierId, String supplierName, String contactName, String contactEmail, String address) {
        String query = "UPDATE Suppliers_Final SET supplier_name = ?, contact_name = ?, contact_email = ?, address = ?, updated_at = ? WHERE supplier_id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, supplierName);
            ps.setString(2, contactName);
            ps.setString(3, contactEmail);
            ps.setString(4, address);
            ps.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now())); // Cập nhật thời gian hiện tại
            ps.setInt(6, supplierId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Xóa nhà cung cấp
    public void deleteSupplier(int supplierId) {
        String query = "DELETE FROM Suppliers_Final WHERE supplier_id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, supplierId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Lấy nhà cung cấp theo ID
    public Supplier getSupplierById(int supplierId) {
        String query = "SELECT * FROM Suppliers_Final WHERE supplier_id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, supplierId);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Supplier(
                        rs.getInt("supplier_id"),
                        rs.getString("supplier_name"),
                        rs.getString("contact_name"),
                        rs.getString("contact_email"),
                        rs.getString("address"),
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
        SupplierDAO supplierDAO = new SupplierDAO();

        // Kiểm tra chức năng lấy danh sách nhà cung cấp
        List<Supplier> suppliers = supplierDAO.getAllSuppliers();
        for (Supplier supplier : suppliers) {
            System.out.println("Supplier ID: " + supplier.getSupplier_id()
                    + ", Supplier Name: " + supplier.getSupplier_name()
                    + ", Contact Name: " + supplier.getContact_name()
                    + ", Contact Email: " + supplier.getContact_email()
                    + ", Address: " + supplier.getAddress()
                    + ", Created At: " + supplier.getCreated_at()
                    + ", Updated At: " + supplier.getUpdated_at());
        }
        Supplier ok = supplierDAO.getSupplierById(1);
        System.out.println(ok);
        

//        // Thêm một nhà cung cấp mới
//        supplierDAO.insertSupplier("Nhà cung cấp A", "Người liên hệ A", "contactA@example.com", "123 Địa chỉ A");
//
//        // Cập nhật thông tin nhà cung cấp
//        if (!suppliers.isEmpty()) {
//            Supplier firstSupplier = suppliers.get(0);
//            supplierDAO.updateSupplier(firstSupplier.getSupplier_id(), "Nhà cung cấp B", "Người liên hệ B", "contactB@example.com", "456 Địa chỉ B");
//        }
//
//        // Lấy nhà cung cấp theo ID
//        if (!suppliers.isEmpty()) {
//            Supplier supplierById = supplierDAO.getSupplierById(suppliers.get(0).getSupplier_id());
//            System.out.println("\nThông tin nhà cung cấp theo ID:");
//            System.out.println("Supplier ID: " + supplierById.getSupplier_id() +
//                               ", Supplier Name: " + supplierById.getSupplier_name() +
//                               ", Contact Name: " + supplierById.getContact_name() +
//                               ", Contact Email: " + supplierById.getContact_email() +
//                               ", Address: " + supplierById.getAddress() +
//                               ", Created At: " + supplierById.getCreated_at() +
//                               ", Updated At: " + supplierById.getUpdated_at());
//        }
//
//        // Xóa nhà cung cấp
//        if (!suppliers.isEmpty()) {
//            supplierDAO.deleteSupplier(suppliers.get(0).getSupplier_id());
//            System.out.println("\nĐã xóa nhà cung cấp có ID: " + suppliers.get(0).getSupplier_id());
//        }
    }
}
