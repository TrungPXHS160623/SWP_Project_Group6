package dao;

import context.DBContext;
import entity.ProductPackaging;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductPackagingDAO {

    // Lấy tất cả các gói bao bì
    public List<ProductPackaging> getAllPackage() {
        List<ProductPackaging> listPackage = new ArrayList<>();
        String query = "SELECT * FROM ProductPackagingIter1";
        
        // Sử dụng try-with-resources để tự động đóng các tài nguyên
        try (Connection conn = new DBContext().getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                listPackage.add(new ProductPackaging(rs.getInt(1), rs.getString(2)));
            }

        } catch (Exception e) {
        }

        return listPackage;
    }

    public static void main(String[] args) {
        ProductPackagingDAO dao = new ProductPackagingDAO();
        try {
            List<ProductPackaging> list = dao.getAllPackage();
            // In ra thông tin từng gói bao bì
            for (ProductPackaging o : list) {
                System.out.println(o);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
