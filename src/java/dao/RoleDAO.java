/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import entity.Roles;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    // Lấy tất cả các vai trò
    public List<Roles> getAllRoles() {
        List<Roles> list = new ArrayList<>();
        String query = "SELECT * FROM Roles_Final"; // Giả sử bảng Roles tồn tại trong cơ sở dữ liệu
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Roles(
                        rs.getInt("role_id"), // ID vai trò
                        rs.getString("role_name"), // Tên vai trò
                        rs.getString("description") // Mô tả vai trò
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // Thêm vai trò
    public void insertRole(String roleName, String description) {
        String query = "INSERT INTO Roles_Final (role_name, description) VALUES (?, ?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, roleName);
            ps.setString(2, description);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Cập nhật vai trò
    public void updateRole(int roleId, String roleName, String description) {
        String query = "UPDATE Roles_Final SET role_name = ?, description = ? WHERE role_id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, roleName);
            ps.setString(2, description);
            ps.setInt(3, roleId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Xóa vai trò
    public void deleteRole(int roleId) {
        String query = "DELETE FROM Roles_Final WHERE role_id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, roleId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Lấy vai trò theo ID
    public Roles getRoleById(int roleId) {
        String query = "SELECT * FROM Roles_Final WHERE role_id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, roleId);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Roles(
                        rs.getInt("role_id"),
                        rs.getString("role_name"),
                        rs.getString("description")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        RoleDAO roleDAO = new RoleDAO();

        // Kiểm tra các chức năng
        System.out.println("Danh sách các vai trò:");
        List<Roles> rolesList = roleDAO.getAllRoles();
        
        
        for (Roles role : rolesList) {
            System.out.println("Role ID: " + role.getRole_id()
                    + ", Role Name: " + role.getRole_name()
                    + ", Description: " + role.getDescription());
        }
        
        // Thêm một vai trò mới
        roleDAO.insertRole("New Role", "This is a new role");

        // Cập nhật vai trò
        if (!rolesList.isEmpty()) {
            Roles firstRole = rolesList.get(0);
            roleDAO.updateRole(firstRole.getRole_id(), "Updated Role", "Updated description");
        }

        // Lấy và hiển thị vai trò theo ID
        if (!rolesList.isEmpty()) {
            Roles roleById = roleDAO.getRoleById(rolesList.get(0).getRole_id());
            System.out.println("\nVai trò theo ID:");
            System.out.println("Role ID: " + roleById.getRole_id()
                    + ", Role Name: " + roleById.getRole_name()
                    + ", Description: " + roleById.getDescription());
        }

        // Xóa vai trò
        if (!rolesList.isEmpty()) {
            roleDAO.deleteRole(rolesList.get(0).getRole_id());
            System.out.println("\nĐã xóa vai trò có ID: " + rolesList.get(0).getRole_id());
        }
    }
}
