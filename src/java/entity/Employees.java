/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Acer
 */
public class Employees {
    private long employee_id;         // ID duy nhất cho nhân viên
    private String employee_name;     // Tên nhân viên
    private String PasswordHash;     // Mã băm mật khẩu
    private String employee_email;    // Địa chỉ email của nhân viên
    private String employee_phone;    // Số điện thoại của nhân viên (không bắt buộc)
    private boolean isActive;        // Trạng thái hoạt động của nhân viên (không bắt buộc)
    private int pharmacyId;          // Liên kết tới nhà thuốc 
    private int roleId;              // Liên kết tới vai trò của nhân viên

    public Employees() {
    }

    public Employees(long employee_id, String employee_name, String PasswordHash, String employee_email, String employee_phone, boolean isActive, int pharmacyId, int roleId) {
        this.employee_id = employee_id;
        this.employee_name = employee_name;
        this.PasswordHash = PasswordHash;
        this.employee_email = employee_email;
        this.employee_phone = employee_phone;
        this.isActive = isActive;
        this.pharmacyId = pharmacyId;
        this.roleId = roleId;
    }

    public long getEmployee_id() {
        return employee_id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public String getPasswordHash() {
        return PasswordHash;
    }

    public String getEmployee_email() {
        return employee_email;
    }

    public String getEmployee_phone() {
        return employee_phone;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public int getPharmacyId() {
        return pharmacyId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setEmployee_id(long employee_id) {
        this.employee_id = employee_id;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public void setPasswordHash(String PasswordHash) {
        this.PasswordHash = PasswordHash;
    }

    public void setEmployee_email(String employee_email) {
        this.employee_email = employee_email;
    }

    public void setEmployee_phone(String employee_phone) {
        this.employee_phone = employee_phone;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public void setPharmacyId(int pharmacyId) {
        this.pharmacyId = pharmacyId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "Employees{" + "employee_id=" + employee_id + ", employee_name=" + employee_name + ", PasswordHash=" + PasswordHash + ", employee_email=" + employee_email + ", employee_phone=" + employee_phone + ", isActive=" + isActive + ", pharmacyId=" + pharmacyId + ", roleId=" + roleId + '}';
    }

    
    
}
