package dao;

import context.DBContext;
import entity.ProductionBatch;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Acer
 */
public class ProductionBatchDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public boolean createProductionBatch(int productId, long importId, String batchNumber, Date manufactureDate, Date expirationDate, boolean isActive) throws Exception {
        
        String query = "INSERT INTO ProductionBatch_Final (ProductID, ImportID, BatchNumber, ManufactureDate, ExpirationDate, IsActive) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);

            ps.setInt(1, productId);
            ps.setLong(2, importId);
            ps.setString(3, batchNumber);
            ps.setDate(4, new java.sql.Date(manufactureDate.getTime()));  // Chuyển từ java.util.Date sang java.sql.Date
            ps.setDate(5, new java.sql.Date(expirationDate.getTime()));   // Chuyển từ java.util.Date sang java.sql.Date
            ps.setBoolean(6, isActive);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return false;
    }

    public List<ProductionBatch> getAllProductionBatches() throws Exception {
        List<ProductionBatch> batches = new ArrayList<>();
        // Sửa tên cột cho khớp với cơ sở dữ liệu
        String query = "SELECT * FROM ProductionBatch_Final";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                ProductionBatch batch = new ProductionBatch();
                batch.setBatchId(rs.getLong("BatchID"));  // Đúng với tên cột trong DB
                batch.setProductId(rs.getInt("ProductID"));  // Đúng với tên cột trong DB
                batch.setImportId(rs.getLong("ImportID"));  // Đúng với tên cột trong DB
                batch.setBatchNumber(rs.getString("BatchNumber"));
                batch.setManufactureDate(rs.getDate("ManufactureDate"));
                batch.setExpirationDate(rs.getDate("ExpirationDate"));
                batch.setIsActive(rs.getBoolean("IsActive"));
                batches.add(batch);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return batches;
    }

    public boolean updateProductionBatch(long batchId, int productId, long importId, String batchNumber, Date manufactureDate, Date expirationDate, boolean isActive) throws Exception {
        // Sửa tên cột cho khớp với cơ sở dữ liệu
        String query = "UPDATE ProductionBatch_Final SET ProductID = ?, ImportID = ?, BatchNumber = ?, ManufactureDate = ?, ExpirationDate = ?, IsActive = ? WHERE BatchID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);

            ps.setInt(1, productId);
            ps.setLong(2, importId);
            ps.setString(3, batchNumber);
            ps.setDate(4, new java.sql.Date(manufactureDate.getTime())); // Chuyển từ java.util.Date sang java.sql.Date
            ps.setDate(5, new java.sql.Date(expirationDate.getTime()));  // Chuyển từ java.util.Date sang java.sql.Date
            ps.setBoolean(6, isActive);
            ps.setLong(7, batchId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return false;
    }

    public boolean deleteProductionBatch(long batchId) throws Exception {
        // Sửa tên cột cho khớp với cơ sở dữ liệu
        String query = "DELETE FROM ProductionBatch_Final WHERE BatchID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setLong(1, batchId);
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
        ProductionBatchDAO productionBatchDAO = new ProductionBatchDAO();

        // Tạo một lô sản xuất mới
        int productId = 60;
        long importId = 1;
        String batchNumber = "BATCH001";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date manufactureDate = sdf.parse("2024-10-10"); // Ví dụ ngày sản xuất là 10/10/2024
        Date expirationDate = new Date(System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 30);
        boolean isActive = true;

        boolean isCreated = productionBatchDAO.createProductionBatch(productId, importId, batchNumber, manufactureDate, expirationDate, isActive);
        if (isCreated) {
            System.out.println("Lô sản xuất đã được thêm thành công.");
        } else {
            System.out.println("Không thể thêm lô sản xuất.");
        }

        // Lấy tất cả các lô sản xuất
        List<ProductionBatch> batches = productionBatchDAO.getAllProductionBatches();
        for (ProductionBatch batch : batches) {
            System.out.println("Lô sản xuất ID: " + batch.getBatchId() + ", Số lô: " + batch.getBatchNumber());
        }

//        // Cập nhật lô sản xuất
//        if (!batches.isEmpty()) {
//            ProductionBatch batchToUpdate = batches.get(0);
//            boolean isUpdated = productionBatchDAO.updateProductionBatch(batchToUpdate.getBatchId(), productId, importId, "BATCH001_UPDATED", manufactureDate, expirationDate, isActive);
//            if (isUpdated) {
//                System.out.println("Lô sản xuất đã được cập nhật thành công.");
//            } else {
//                System.out.println("Không thể cập nhật lô sản xuất.");
//            }
//        }
//
//        // Xóa lô sản xuất
//        if (!batches.isEmpty()) {
//            long batchIdToDelete = batches.get(0).getBatchId();
//            boolean isDeleted = productionBatchDAO.deleteProductionBatch(batchIdToDelete);
//            if (isDeleted) {
//                System.out.println("Lô sản xuất đã được xóa thành công.");
//            } else {
//                System.out.println("Không thể xóa lô sản xuất.");
//            }
//        }
    }

}
