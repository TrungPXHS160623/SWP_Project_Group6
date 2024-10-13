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
public class ProductImports {
    private long id;                // ID duy nhất cho mỗi đợt nhập kho
    private long storeId;           // Liên kết tới cửa hàng
    private long employeeId;        // Liên kết tới nhân viên thực hiện nhập kho
    private long supplierId;        // Liên kết tới nhà cung cấp
    private Date importDate;        // Ngày nhập kho
    public LocalDateTime created_at;
    public LocalDateTime updated_at;
    private int status_id;

    public ProductImports() {
    }

    public ProductImports(long id, long storeId, long employeeId, long supplierId, Date importDate, LocalDateTime created_at, LocalDateTime updated_at, int status_id) {
        this.id = id;
        this.storeId = storeId;
        this.employeeId = employeeId;
        this.supplierId = supplierId;
        this.importDate = importDate;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.status_id = status_id;
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

    public long getSupplierId() {
        return supplierId;
    }

    public Date getImportDate() {
        return importDate;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public int getStatus_id() {
        return status_id;
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

    public void setSupplierId(long supplierId) {
        this.supplierId = supplierId;
    }

    public void setImportDate(Date importDate) {
        this.importDate = importDate;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    @Override
    public String toString() {
        return "ProductImports{" + "id=" + id + ", storeId=" + storeId + ", employeeId=" + employeeId + ", supplierId=" + supplierId + ", importDate=" + importDate + ", created_at=" + created_at + ", updated_at=" + updated_at + ", status_id=" + status_id + '}';
    }

   
    
    

    
    
}
