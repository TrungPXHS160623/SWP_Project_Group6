/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.math.BigDecimal;

/**
 *
 * @author Acer
 */
public class Inventory {
    private int productId;           // Liên kết tới sản phẩm
    private long warehouseId;        // Liên kết tới kho
    private int packagingId;         // Liên kết tới loại bao bì
    private BigDecimal currentQuantity; // Số lượng tồn kho theo loại bao bì

    public Inventory() {
    }

    public Inventory(int productId, long warehouseId, int packagingId, BigDecimal currentQuantity) {
        this.productId = productId;
        this.warehouseId = warehouseId;
        this.packagingId = packagingId;
        this.currentQuantity = currentQuantity;
    }

    public int getProductId() {
        return productId;
    }

    public long getWarehouseId() {
        return warehouseId;
    }

    public int getPackagingId() {
        return packagingId;
    }

    public BigDecimal getCurrentQuantity() {
        return currentQuantity;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setWarehouseId(long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public void setPackagingId(int packagingId) {
        this.packagingId = packagingId;
    }

    public void setCurrentQuantity(BigDecimal currentQuantity) {
        this.currentQuantity = currentQuantity;
    }

    @Override
    public String toString() {
        return "Inventory{" + "productId=" + productId + ", warehouseId=" + warehouseId + ", packagingId=" + packagingId + ", currentQuantity=" + currentQuantity + '}';
    }
    
    
}
