/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import entity.Employees;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    // Lấy tất cả nhân viên
    public List<Employees> getAllEmployees() {
        List<Employees> list = new ArrayList<>();
        String query = "SELECT * FROM Employees_Final where isActive = 1"; // Giả sử bảng Employees tồn tại trong cơ sở dữ liệu
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Employees(
                        rs.getInt("employee_id"), // ID nhân viên
                        rs.getString("employee_name"), // Tên nhân viên
                        rs.getString("PasswordHash"), // Mã băm mật khẩu
                        rs.getString("employee_email"), // Địa chỉ email
                        rs.getString("employee_phone"), // Số điện thoại
                        rs.getBoolean("isActive"), // Trạng thái hoạt động
                        rs.getInt("pharmacyId"), // ID nhà thuốc
                        rs.getInt("roleId") // ID vai trò
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    // Lấy tất cả nhân viên đang bị vô hiệu hoá
    public List<Employees> getAllDeactiveEmployees() {
        List<Employees> list = new ArrayList<>();
        String query = "SELECT * FROM Employees_Final where isActive = 0"; // Giả sử bảng Employees tồn tại trong cơ sở dữ liệu
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Employees(
                        rs.getInt("employee_id"), // ID nhân viên
                        rs.getString("employee_name"), // Tên nhân viên
                        rs.getString("PasswordHash"), // Mã băm mật khẩu
                        rs.getString("employee_email"), // Địa chỉ email
                        rs.getString("employee_phone"), // Số điện thoại
                        rs.getBoolean("isActive"), // Trạng thái hoạt động
                        rs.getInt("pharmacyId"), // ID nhà thuốc
                        rs.getInt("roleId") // ID vai trò
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // Thêm nhân viên
    public void insertEmployee(String employeeName, String passwordHash, String employeeEmail, String employeePhone, boolean isActive, int pharmacyId, int roleId) {
        String query = "INSERT INTO Employees_Final (employee_name, PasswordHash, employee_email, employee_phone, isActive, pharmacyId, roleId) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, employeeName);
            ps.setString(2, passwordHash);
            ps.setString(3, employeeEmail);
            ps.setString(4, employeePhone);
            ps.setBoolean(5, isActive);
            ps.setInt(6, pharmacyId);
            ps.setInt(7, roleId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Cập nhật nhân viên
    public void updateEmployee(int employeeId, String employeeName, String passwordHash, String employeeEmail, String employeePhone, boolean isActive, int pharmacyId, int roleId) {
        String query = "UPDATE Employees_Final SET employee_name = ?, PasswordHash = ?, employee_email = ?, employee_phone = ?, isActive = ?, pharmacyId = ?, roleId = ? WHERE employee_id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, employeeName);
            ps.setString(2, passwordHash);
            ps.setString(3, employeeEmail);
            ps.setString(4, employeePhone);
            ps.setBoolean(5, isActive);
            ps.setInt(6, pharmacyId);
            ps.setInt(7, roleId);
            ps.setInt(8, employeeId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Xóa nhân viên
    public void deleteEmployee(int employeeId) {
        String query = "DELETE FROM Employees_Final WHERE employee_id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, employeeId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Lấy nhân viên theo ID
    public Employees getEmployeeById(int employeeId) {
        String query = "SELECT * FROM Employees_Final WHERE employee_id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, employeeId);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Employees(
                        rs.getInt("employee_id"),
                        rs.getString("employee_name"),
                        rs.getString("PasswordHash"),
                        rs.getString("employee_email"),
                        rs.getString("employee_phone"),
                        rs.getBoolean("isActive"),
                        rs.getInt("pharmacyId"),
                        rs.getInt("roleId")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Kích hoạt nhân viên
    public void activateEmployee(int employeeId) {
        String query = "UPDATE Employees_Final SET isActive = ? WHERE employee_id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setBoolean(1, true); // Kích hoạt
            ps.setInt(2, employeeId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Khóa nhân viên
    public void deactivateEmployee(int employeeId) {
        String query = "UPDATE Employees_Final SET isActive = ? WHERE employee_id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setBoolean(1, false); // Khóa
            ps.setInt(2, employeeId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAO();

        // Kiểm tra các chức năng
        System.out.println("Danh sách nhân viên:");
        List<Employees> employeesList = employeeDAO.getAllEmployees();
        for (Employees employee : employeesList) {
            System.out.println("Employee ID: " + employee.getEmployee_id()
                    + ", Employee Name: " + employee.getEmployee_name()
                    + ", Email: " + employee.getEmployee_email()
                    + ", Active: " + employee.getIsActive());
        }

//        // Thêm một nhân viên mới
//        employeeDAO.insertEmployee("New Employee", "hashed_password", "newemployee@example.com", "1234567890", true, 1, 1);
//
//        // Cập nhật nhân viên
//        if (!employeesList.isEmpty()) {
//            Employees firstEmployee = employeesList.get(0);
//            employeeDAO.updateEmployee(firstEmployee.getEmployee_id(), "Updated Employee", "updated_password", "updatedemail@example.com", "0987654321", false, 1, 1);
//        }
//
//        // Kích hoạt nhân viên
//        if (!employeesList.isEmpty()) {
//            employeeDAO.activateEmployee(employeesList.get(0).getEmployee_id());
//        }
//
//        // Khóa nhân viên
//        if (!employeesList.isEmpty()) {
//            employeeDAO.deactivateEmployee(employeesList.get(0).getEmployee_id());
//        }
//
//        // Lấy và hiển thị nhân viên theo ID
//        if (!employeesList.isEmpty()) {
//            Employees employeeById = employeeDAO.getEmployeeById(employeesList.get(0).getEmployee_id());
//            System.out.println("\nNhân viên theo ID:");
//            System.out.println("Employee ID: " + employeeById.getEmployee_id()+
//                               ", Employee Name: " + employeeById.getEmployee_name()+
//                               ", Email: " + employeeById.getEmployee_email()+
//                               ", Active: " + employeeById.getIsActive());
//        }
//
//        // Xóa nhân viên
//        if (!employeesList.isEmpty()) {
//            employeeDAO.deleteEmployee(employeesList.get(0).getEmployee_id());
//            System.out.println("\nĐã xóa nhân viên có ID: " + employeesList.get(0).getEmployee_id());
//        }
    }
}
