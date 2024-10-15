/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 *
 * @author Acer
 */
public class ProductExports {
    private int id;               // ID duy nhất cho lần xuất kho
    private int storeId;          // Liên kết tới cửa hàng (kho hàng)
    private int employeeId;       // Liên kết tới nhân viên thực hiện xuất kho
    private Date exportDate;       // Ngày xuất kho
    private int status_id;
    public Date created_at;
    public Date updated_at;

    public ProductExports() {
    }

    public ProductExports(int id, int storeId, int employeeId, Date exportDate, int status_id, Date created_at, Date updated_at) {
        this.id = id;
        this.storeId = storeId;
        this.employeeId = employeeId;
        this.exportDate = exportDate;
        this.status_id = status_id;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getId() {
        return id;
    }

    public int getStoreId() {
        return storeId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public Date getExportDate() {
        return exportDate;
    }

    public int getStatus_id() {
        return status_id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setExportDate(Date exportDate) {
        this.exportDate = exportDate;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "ProductExports{" + "id=" + id + ", storeId=" + storeId + ", employeeId=" + employeeId + ", exportDate=" + exportDate + ", status_id=" + status_id + ", created_at=" + created_at + ", updated_at=" + updated_at + '}';
    }

    
    
}
