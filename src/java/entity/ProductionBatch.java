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
public class ProductionBatch {
    private int batchId;              // ID lô sản xuất
    private int productId;             // ID sản phẩm
    private int importId;             // ID nhập hàng
    private String batchNumber;         // Số lô sản xuất
    private Date manufactureDate;       // Ngày sản xuất
    private Date expirationDate;        // Ngày hết hạn
    private boolean isActive;           // Trạng thái hoạt động của lô sản xuất

    public ProductionBatch(int batchId, int productId, int importId, String batchNumber, Date manufactureDate, Date expirationDate, boolean isActive) {
        this.batchId = batchId;
        this.productId = productId;
        this.importId = importId;
        this.batchNumber = batchNumber;
        this.manufactureDate = manufactureDate;
        this.expirationDate = expirationDate;
        this.isActive = isActive;
    }

    public ProductionBatch() {
    }

    public int getBatchId() {
        return batchId;
    }

    public int getProductId() {
        return productId;
    }

    public int getImportId() {
        return importId;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setImportId(int importId) {
        this.importId = importId;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "ProductionBatch{" + "batchId=" + batchId + ", productId=" + productId + ", importId=" + importId + ", batchNumber=" + batchNumber + ", manufactureDate=" + manufactureDate + ", expirationDate=" + expirationDate + ", isActive=" + isActive + '}';
    }
    
    
}
