/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author Acer
 */
import context.DBContext;
import entity.Pharamcies;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PharmacyDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    //Lấy tất cả các nhà thuốc
    public List<Pharamcies> getAllPharamacies() {
        List<Pharamcies> list = new ArrayList<>();
        String query = "Select * from Pharmacies_Final where isactive = 1";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Pharamcies(
                        rs.getInt(1), // PharmacyID
                        rs.getString(2), // PharmacyName
                        rs.getString(3), // Address
                        rs.getString(4), // PhoneNumber
                        rs.getBoolean(5) // isActive
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // Lấy tất cả các nhà thuốc không hoạt động
    public List<Pharamcies> getAllDeactivePharamacies() {
        List<Pharamcies> list = new ArrayList<>();
        String query = "SELECT * FROM Pharmacies_Final WHERE isActive = 0";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Pharamcies(
                        rs.getInt(1), // PharmacyID
                        rs.getString(2), // PharmacyName
                        rs.getString(3), // Address
                        rs.getString(4), // PhoneNumber
                        rs.getBoolean(5) // isActive
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // Lấy nhà thuốc cuối cùng
    public Pharamcies getLastPharmacy() {
        String query = "SELECT TOP 1 * FROM Pharmacies_Final ORDER BY pharmacy_id DESC";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Pharamcies(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getBoolean(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Thêm nhà thuốc
    public void InsertPharamcy(String PharamcyName, String Address, String PhoneNumber) {
        boolean isActive = true;
        String query = "INSERT INTO Pharmacies_Final (pharmacy_name, Address, PhoneNumber, isActive) VALUES (?, ?, ?, ?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, PharamcyName);
            ps.setString(2, Address);
            ps.setString(3, PhoneNumber);
            ps.setBoolean(4, isActive);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Cập nhật nhà thuốc
    public void UpdatePharamcy(int PharmacyID, String PharmacyName, String Address, String PhoneNumber) {
        String query = "UPDATE Pharmacies_Final SET pharmacy_name = ?, Address = ?, PhoneNumber = ? WHERE pharmacy_id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, PharmacyName);
            ps.setString(2, Address);
            ps.setString(3, PhoneNumber);
            ps.setInt(4, PharmacyID);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Xóa nhà thuốc
    public void DeletePharmacy(int PharmacyID) {
        String query = "DELETE FROM Pharmacies_Final WHERE pharmacy_id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, PharmacyID);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Kích hoạt nhà thuốc
    public void activatePharmacy(int PharmacyID) {
        String query = "UPDATE Pharmacies_Final SET isActive = 1 WHERE pharmacy_id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, PharmacyID);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Vô hiệu hóa nhà thuốc
    public void deactivatePharmacy(int PharmacyID) {
        String query = "UPDATE Pharmacies_Final SET isActive = 0 WHERE pharmacy_id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, PharmacyID);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        PharmacyDAO dao = new PharmacyDAO();
        // Kiểm tra các chức năng
        
        List<Pharamcies> activePharmacies = dao.getAllPharamacies();
        
        // Hiển thị thông tin nhà thuốc
        System.out.println("Danh sách nhà thuốc đang hoạt động:");
        for (Pharamcies pharmacy : activePharmacies) {
             
            System.out.println(pharmacy);
        }

        // Kiểm tra và lấy danh sách nhà thuốc không hoạt động
        List<Pharamcies> deactivePharmacies = dao.getAllDeactivePharamacies();

        // Hiển thị thông tin nhà thuốc không hoạt động
        System.out.println("\nDanh sách nhà thuốc không hoạt động:");
        if (deactivePharmacies.isEmpty()) {
            System.out.println("Không có nhà thuốc nào không hoạt động.");
        } else {
            for (Pharamcies pharmacy : deactivePharmacies) {
                System.out.println("Pharmacy ID: " + pharmacy.getPharmacy_id()
                        + ", Name: " + pharmacy.getPharmacy_name()
                        + ", Address: " + pharmacy.getAddress()
                        + ", Phone Number: " + pharmacy.getPhoneNumber());
            }
        }

         
        // Kiểm tra nhà thuốc cuối cùng
        Pharamcies lastPharmacy = dao.getLastPharmacy();
        System.out.println("\nNhà thuốc cuối cùng:");
        if (lastPharmacy != null) {
            System.out.println("Pharmacy ID: " + lastPharmacy.getPharmacy_id()
                    + ", Name: " + lastPharmacy.getPharmacy_name()
                    + ", Address: " + lastPharmacy.getAddress()
                    + ", Phone Number: " + lastPharmacy.getPhoneNumber());
        } else {
            System.out.println("Không có nhà thuốc nào để hiển thị.");
        }
    }

}
