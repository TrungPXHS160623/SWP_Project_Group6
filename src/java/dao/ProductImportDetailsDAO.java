package dao;

import context.DBContext;
import entity.ProductImportDetails;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductImportDetailsDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    // Thêm chi tiết nhập kho mới
    public boolean createProductImportDetail(long importId, int productId, int packagingId, BigDecimal quantity, BigDecimal unitPrice, String batchNumber, Date manufactureDate, Date expirationDate) throws Exception {
        String query = "INSERT INTO Product_Import_Details_Final (import_id, product_id, packaging_id, quantity, unit_price, batchNumber, manufactureDate, expirationDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setLong(1, importId);
            ps.setInt(2, productId);
            ps.setInt(3, packagingId);
            ps.setBigDecimal(4, quantity);
            ps.setBigDecimal(5, unitPrice);
            ps.setString(6, batchNumber);
            ps.setDate(7, new java.sql.Date(manufactureDate.getTime())); // Chuyển đổi Date sang java.sql.Date
            ps.setDate(8, new java.sql.Date(expirationDate.getTime())); // Chuyển đổi Date sang java.sql.Date
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return false;
    }

    // Lấy tất cả các chi tiết nhập kho
    public List<ProductImportDetails> getAllProductImportDetails() throws Exception {
        List<ProductImportDetails> detailsList = new ArrayList<>();
        String query = "SELECT * FROM Product_Import_Details_Final";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                ProductImportDetails detail = new ProductImportDetails();
                detail.setId(rs.getLong("id"));
                detail.setImport_id(rs.getLong("import_id"));
                detail.setProduct_id(rs.getInt("product_id"));
                detail.setPackaging_id(rs.getInt("packaging_id"));
                detail.setQuantity(rs.getBigDecimal("quantity"));
                detail.setUnitPrice(rs.getBigDecimal("unit_price"));
                detail.setBatchNumber(rs.getString("batchNumber")); // Lấy giá trị số lô sản xuất
                detail.setManufactureDate(rs.getDate("manufactureDate")); // Lấy ngày sản xuất
                detail.setExpirationDate(rs.getDate("expirationDate")); // Lấy ngày hết hạn
                detailsList.add(detail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return detailsList;
    }

    // Cập nhật chi tiết nhập kho
    public boolean updateProductImportDetail(long id, long importId, int productId, int packagingId, BigDecimal quantity, BigDecimal unitPrice, String batchNumber, Date manufactureDate, Date expirationDate) throws Exception {
        String query = "UPDATE Product_Import_Details_Final SET import_id = ?, product_id = ?, packaging_id = ?, quantity = ?, unit_price = ?, batchNumber = ?, manufactureDate = ?, expirationDate = ? WHERE id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setLong(1, importId);
            ps.setInt(2, productId);
            ps.setInt(3, packagingId);
            ps.setBigDecimal(4, quantity);
            ps.setBigDecimal(5, unitPrice);
            ps.setString(6, batchNumber); // Cập nhật số lô sản xuất
            ps.setDate(7, new java.sql.Date(manufactureDate.getTime())); // Chuyển đổi Date sang java.sql.Date
            ps.setDate(8, new java.sql.Date(expirationDate.getTime())); // Chuyển đổi Date sang java.sql.Date
            ps.setLong(9, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return false;
    }

    // Xóa chi tiết nhập kho
    public boolean deleteProductImportDetail(long id) throws Exception {
        String query = "DELETE FROM Product_Import_Details_Final WHERE id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setLong(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
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

    public static void main(String[] args) throws Exception {
        ProductImportDetailsDAO dao = new ProductImportDetailsDAO();

        // Thêm chi tiết nhập kho
        boolean isCreated = dao.createProductImportDetail(1L, 60, 2, new BigDecimal("100"), new BigDecimal("50.0"), "BATCH123", new Date(), new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 30)); // 30 ngày sau
        if (isCreated) {
            System.out.println("Chi tiết nhập kho đã được thêm thành công.");
        } else {
            System.out.println("Không thể thêm chi tiết nhập kho.");
        }

        // Lấy tất cả chi tiết nhập kho
        List<ProductImportDetails> detailsList = dao.getAllProductImportDetails();
        for (ProductImportDetails detail : detailsList) {
            System.out.println("Chi tiết nhập kho ID: " + detail.getId() + ", Số lượng: " + detail.getQuantity() + ", Số lô: " + detail.getBatchNumber());
        }

//        // Cập nhật chi tiết nhập kho
//        if (!detailsList.isEmpty()) {
//            ProductImportDetails detailToUpdate = detailsList.get(0);
//            boolean isUpdated = dao.updateProductImportDetail(detailToUpdate.getId(), 1L, 60, 2, new BigDecimal("150"), new BigDecimal("60.0"), "BATCH456", new Date(), new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 60)); // 60 ngày sau
//            if (isUpdated) {
//                System.out.println("Chi tiết nhập kho đã được cập nhật thành công.");
//            } else {
//                System.out.println("Không thể cập nhật chi tiết nhập kho.");
//            }
//        }
//
//        // Xóa chi tiết nhập kho
//        if (!detailsList.isEmpty()) {
//            long idToDelete = detailsList.get(0).getId();
//            boolean isDeleted = dao.deleteProductImportDetail(idToDelete);
//            if (isDeleted) {
//                System.out.println("Chi tiết nhập kho đã được xóa thành công.");
//            } else {
//                System.out.println("Không thể xóa chi tiết nhập kho.");
//            }
//        }
    }
}
