/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author Acer
 */
public class ProductExports {
    private long id;               // ID duy nhất cho lần xuất kho
    private long storeId;          // Liên kết tới cửa hàng (kho hàng)
    private long employeeId;       // Liên kết tới nhân viên thực hiện xuất kho
    private Date exportDate;       // Ngày xuất kho
    private int status_id;
    public LocalDateTime created_at;
    public LocalDateTime updated_at;

    public ProductExports() {
    }

    public ProductExports(long id, long storeId, long employeeId, Date exportDate, int status_id, LocalDateTime created_at, LocalDateTime updated_at) {
        this.id = id;
        this.storeId = storeId;
        this.employeeId = employeeId;
        this.exportDate = exportDate;
        this.status_id = status_id;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public long getId() {
        return id;
    }

    public long getStoreId() {
        return storeId;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public Date getExportDate() {
        return exportDate;
    }

    public int getStatus_id() {
        return status_id;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setStoreId(long storeId) {
        this.storeId = storeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public void setExportDate(Date exportDate) {
        this.exportDate = exportDate;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "ProductExports{" + "id=" + id + ", storeId=" + storeId + ", employeeId=" + employeeId + ", exportDate=" + exportDate + ", status_id=" + status_id + ", created_at=" + created_at + ", updated_at=" + updated_at + '}';
    }

    
    
}
