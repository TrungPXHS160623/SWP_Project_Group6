/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import entity.Category;
import entity.Product;
import entity.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
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
        String query = "select * from ProductsIter1";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
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
                        rs.getFloat(12)));
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
                        rs.getFloat(12));
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
                list.add(new Product(rs.getInt(1),
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
                        rs.getFloat(12)));
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
                        rs.getFloat(12));
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
                list.add(new Product(rs.getInt(1),
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
                        rs.getFloat(12)));
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
        String query = "INSERT INTO [dbo].[ProductsIter1] "
                + "([ProductName], [CategoryID], [ProductImage], [Ingredients], "
                + "[Formulation], [Specification], [TargetAudience], "
                + "[PrescriptionMedication], [ShortDescription], [RegistrationNumber], [Price]) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
            ps.setInt(12, ProductID);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Customer checkLogin(String username, String password) throws Exception {
        String sql = "select * from [dbo].[Customers] where [Username] = ? and [PasswordHash] = ?;";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);

            // Đặt giá trị cho các tham số
            ps.setString(1, username);
            ps.setString(2, password);

            // Thực thi câu lệnh SQL
            rs = ps.executeQuery();

            // Xử lý kết quả
            while (rs.next()) {
                return new Customer(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getTimestamp(10).toLocalDateTime(),
                        rs.getTimestamp(11).toLocalDateTime(),
                        rs.getInt(12)
                );
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            // Đóng tài nguyên
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return null;
    }

    public List<Customer> getCustomers() throws Exception {
        List<Customer> list = new ArrayList<>();
        String sql = "select * from [Customers]";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Customer customer = new Customer(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getTimestamp(10).toLocalDateTime(),
                        rs.getTimestamp(11).toLocalDateTime(),
                        rs.getInt(12)
                );
                list.add(customer);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public boolean checkUsernameExist(String username) {
        String query = "select * from [dbo].[Customers] where [Username] = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
        }

        return false;
    }

    public boolean checkEmailExist(String email) {
        String query = "SELECT * FROM [dbo].[Customers] WHERE [Email] = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public boolean addCustomer(Customer customer) throws Exception {
        if (customer == null || customer.getUsername() == null) {
            throw new IllegalArgumentException("User hoặc username không thể null");
        }

        String query = "INSERT INTO [dbo].[Customers]\n"
                + "           ([FirstName]\n"
                + "           ,[LastName]\n"
                + "           ,[Username]\n"
                + "           ,[DateOfBirth]\n"
                + "           ,[Gender]\n"
                + "           ,[Phone]\n"
                + "           ,[Email]\n"
                + "           ,[PasswordHash])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?)";

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);

            // Set giá trị cho các tham số
            ps.setString(1, customer.getFirstName());
            ps.setString(2, customer.getLastName());
            ps.setString(3, customer.getUsername());
            ps.setString(4, customer.getDob());
            ps.setInt(5, customer.getGender());
            ps.setString(6, customer.getPhone());
            ps.setString(7, customer.getEmail());
            ps.setString(8, customer.getPassword());

            // Sử dụng executeUpdate cho các câu lệnh INSERT
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            // Đảm bảo đóng PreparedStatement và Connection sau khi sử dụng
            if (ps != null) {
                try {
                    ps.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean isValidDob(String dob) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birthDate = LocalDate.parse(dob, formatter);
        LocalDate currentDate = LocalDate.now();

        // Kiểm tra khoảng cách thời gian (tính theo năm)
        long yearsBetween = ChronoUnit.YEARS.between(birthDate, currentDate);

        return yearsBetween >= 13 && yearsBetween < 100;  // Người dùng phải ít nhất 16 tuổi
    }
}
