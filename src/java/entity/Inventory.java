/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;



/**
 *
 * @author Acer
 */
public class Inventory {
    private int productId;           // Liên kết tới sản phẩm
    private int warehouseId;        // Liên kết tới kho
    private int packagingId;         // Liên kết tới loại bao bì
    private int currentQuantity; // Số lượng tồn kho theo loại bao bì

    public Inventory() {
    }

    public Inventory(int productId, int warehouseId, int packagingId, int currentQuantity) {
        this.productId = productId;
        this.warehouseId = warehouseId;
        this.packagingId = packagingId;
        this.currentQuantity = currentQuantity;
    }

    public int getProductId() {
        return productId;
    }

    public int getWarehouseId() {
        return warehouseId;
    }

    public int getPackagingId() {
        return packagingId;
    }

    public int getCurrentQuantity() {
        return currentQuantity;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    public void setPackagingId(int packagingId) {
        this.packagingId = packagingId;
    }

    public void setCurrentQuantity(int currentQuantity) {
        this.currentQuantity = currentQuantity;
    }

    @Override
    public String toString() {
        return "Inventory{" + "productId=" + productId + ", warehouseId=" + warehouseId + ", packagingId=" + packagingId + ", currentQuantity=" + currentQuantity + '}';
    }
    
    
}
