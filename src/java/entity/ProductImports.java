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
public class ProductImports {
    private int id;                // ID duy nhất cho mỗi đợt nhập kho
    private int storeId;           // Liên kết tới cửa hàng
    private int employeeId;        // Liên kết tới nhân viên thực hiện nhập kho
    private int supplierId;        // Liên kết tới nhà cung cấp
    private Date importDate;        // Ngày nhập kho
    public Date created_at;
    public Date updated_at;
    private int status_id;

    public ProductImports() {
    }

    public ProductImports(int id, int storeId, int employeeId, int supplierId, Date importDate, Date created_at, Date updated_at, int status_id) {
        this.id = id;
        this.storeId = storeId;
        this.employeeId = employeeId;
        this.supplierId = supplierId;
        this.importDate = importDate;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.status_id = status_id;
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

    public int getSupplierId() {
        return supplierId;
    }

    public Date getImportDate() {
        return importDate;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public int getStatus_id() {
        return status_id;
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

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public void setImportDate(Date importDate) {
        this.importDate = importDate;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(Date updated_at) {
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
