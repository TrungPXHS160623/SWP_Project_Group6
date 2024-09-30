/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import entity.Category;
import entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Acer
 */
public class DAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        String query = "select * from ProductsIter1 where isActive = 1";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(
                        rs.getInt(1), // ProductID
                        rs.getString(2), // ProductName
                        rs.getInt(3), // CategoryId
                        rs.getString(4), // ProductImage
                        rs.getString(5), // Ingredients
                        rs.getString(6), // Formulation
                        rs.getString(7), // Specification
                        rs.getString(8), // TargetAudience
                        rs.getBoolean(9), // PrescriptionMedication
                        rs.getString(10), // ShortDescription
                        rs.getString(11), // RegistrationNumber
                        rs.getFloat(12), // Price
                        rs.getBoolean(13) // isActive
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> getAllDeactiveProduct() {
        List<Product> list = new ArrayList<>();
        String query = "select * from ProductsIter1 where isActive = 0";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(
                        rs.getInt(1), // ProductID
                        rs.getString(2), // ProductName
                        rs.getInt(3), // CategoryId
                        rs.getString(4), // ProductImage
                        rs.getString(5), // Ingredients
                        rs.getString(6), // Formulation
                        rs.getString(7), // Specification
                        rs.getString(8), // TargetAudience
                        rs.getBoolean(9), // PrescriptionMedication
                        rs.getString(10), // ShortDescription
                        rs.getString(11), // RegistrationNumber
                        rs.getFloat(12), // Price
                        rs.getBoolean(13) // isActive
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        String query = "select * from CategoriesIter1";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt(1),
                        rs.getString(2),
                        rs.getBoolean(3)));
            }
        } catch (Exception e) {

        }
        return list;
    }

    public Product getLastProduct() {
        String query = "select top 1 * from ProductsIter1 order by ProductID desc";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getBoolean(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getFloat(12),
                        rs.getBoolean(13));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public static void main(String[] args) {
        DAO dao = new DAO();
        List<Product> list = dao.getAllProduct();
        List<Category> listc = dao.getAllCategory();
        Product c = dao.getLastProduct();

        for (Product o : list) {
            System.out.println(o);
        }

        /*
        for (Category o : listc) {
            System.out.println(o);
        }
         */
        //System.out.println(c);
    }

    public List<Product> getProductWithCategoryId(String cid) {
        List<Product> list = new ArrayList<>();
        String query = "select * from ProductsIter1 where CategoryID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(
                        rs.getInt(1), // ProductID
                        rs.getString(2), // ProductName
                        rs.getInt(3), // CategoryId
                        rs.getString(4), // ProductImage
                        rs.getString(5), // Ingredients
                        rs.getString(6), // Formulation
                        rs.getString(7), // Specification
                        rs.getString(8), // TargetAudience
                        rs.getBoolean(9), // PrescriptionMedication
                        rs.getString(10), // ShortDescription
                        rs.getString(11), // RegistrationNumber
                        rs.getFloat(12), // Price
                        rs.getBoolean(13) // isActive
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Product getProductWithProductId(String cid) {

        String query = "select * from ProductsIter1 where ProductID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getBoolean(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getFloat(12),
                        rs.getBoolean(13));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<Product> SearchProductByName(String txtSearch) {
        List<Product> list = new ArrayList<>();
        String query = "select * from ProductsIter1 where ProductName like ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, '%' + txtSearch + '%');
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(
                        rs.getInt(1), // ProductID
                        rs.getString(2), // ProductName
                        rs.getInt(3), // CategoryId
                        rs.getString(4), // ProductImage
                        rs.getString(5), // Ingredients
                        rs.getString(6), // Formulation
                        rs.getString(7), // Specification
                        rs.getString(8), // TargetAudience
                        rs.getBoolean(9), // PrescriptionMedication
                        rs.getString(10), // ShortDescription
                        rs.getString(11), // RegistrationNumber
                        rs.getFloat(12), // Price
                        rs.getBoolean(13) // isActive
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void DeleteProduct(String pid) {
        String query = "Delete from ProductsIter1 where ProductID = ? ";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, pid);
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }

    public void activateProduct(String ProductID) {
        String query = "UPDATE [dbo].[ProductsIter1] SET isActive = 1 WHERE ProductID = ?";
        try (Connection conn = new DBContext().getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, ProductID);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deactivateProduct(String ProductID) {
        String query = "UPDATE [dbo].[ProductsIter1] SET isActive = 0 WHERE ProductID = ?";
        try (Connection conn = new DBContext().getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, ProductID);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void InsertProduct(String ProductName,
            int CategoryId,
            String ProductImage,
            String Ingredients,
            String Formulation,
            String Specification,
            String TargetAudience,
            boolean PrescriptionMedication,
            String ShortDescription,
            String RegistrationNumber,
            float Price) {

        boolean isActive = true;

        String query = "INSERT INTO [dbo].[ProductsIter1] "
                + "([ProductName], [CategoryID], [ProductImage], [Ingredients], "
                + "[Formulation], [Specification], [TargetAudience], "
                + "[PrescriptionMedication], [ShortDescription], [RegistrationNumber], [Price], [isActive]) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);

            ps.setString(1, ProductName);
            ps.setInt(2, CategoryId);
            ps.setString(3, ProductImage);
            ps.setString(4, Ingredients);
            ps.setString(5, Formulation);
            ps.setString(6, Specification);
            ps.setString(7, TargetAudience);
            ps.setBoolean(8, PrescriptionMedication);
            ps.setString(9, ShortDescription);
            ps.setString(10, RegistrationNumber);
            ps.setFloat(11, Price);
            ps.setBoolean(12, isActive);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void UpdateProduct(String ProductName,
            int CategoryId,
            String ProductImage,
            String Ingredients,
            String Formulation,
            String Specification,
            String TargetAudience,
            boolean PrescriptionMedication,
            String ShortDescription,
            String RegistrationNumber,
            float Price,
            int ProductID) {
        String query = "UPDATE [dbo].[ProductsIter1]\n"
                + "   SET [ProductName] = ?\n"
                + "      ,[CategoryID] = ?\n"
                + "      ,[ProductImage] = ?\n"
                + "      ,[Ingredients] = ?\n"
                + "      ,[Formulation] = ?\n"
                + "      ,[Specification] = ?\n"
                + "      ,[TargetAudience] = ?\n"
                + "      ,[PrescriptionMedication] = ?\n"
                + "      ,[ShortDescription] = ?\n"
                + "      ,[RegistrationNumber] = ?\n"
                + "      ,[Price] = ?\n"
                + " WHERE ProductID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);

            ps.setString(1, ProductName);         // OK
            ps.setInt(2, CategoryId);             // OK
            ps.setString(3, ProductImage);        // OK
            ps.setString(4, Ingredients);         // OK
            ps.setString(5, Formulation);         // OK
            ps.setString(6, Specification);       // OK
            ps.setString(7, TargetAudience);      // OK
            ps.setBoolean(8, PrescriptionMedication); // OK
            ps.setString(9, ShortDescription);    // OK
            ps.setString(10, RegistrationNumber); // OK
            ps.setFloat(11, Price);               // OK
            ps.setInt(12, ProductID);             // Cập nhật vị trí ProductID

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
