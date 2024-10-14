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
    private long batchId;              // ID lô sản xuất
    private int productId;             // ID sản phẩm
    private long importId;             // ID nhập hàng
    private String batchNumber;         // Số lô sản xuất
    private Date manufactureDate;       // Ngày sản xuất
    private Date expirationDate;        // Ngày hết hạn
    private boolean isActive;           // Trạng thái hoạt động của lô sản xuất

    public ProductionBatch(long batchId, int productId, long importId, String batchNumber, Date manufactureDate, Date expirationDate, boolean isActive) {
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

    public long getBatchId() {
        return batchId;
    }

    public int getProductId() {
        return productId;
    }

    public long getImportId() {
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

    public void setBatchId(long batchId) {
        this.batchId = batchId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setImportId(long importId) {
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
