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
public class ProductExportDetails {
   private long id;               // ID duy nhất cho chi tiết xuất kho
    private long exportId;         // Liên kết tới lần xuất kho
    private int productId;         // Liên kết tới sản phẩm
    private int packagingId;       // Liên kết tới loại bao bì (vỉ, viên, hộp)
    private BigDecimal quantity;   // Số lượng theo đơn vị nhập
    private BigDecimal unitPrice;  // Đơn giá
    

    public ProductExportDetails() {
    }

    public ProductExportDetails(long id, long exportId, int productId, int packagingId, BigDecimal quantity, BigDecimal unitPrice) {
        this.id = id;
        this.exportId = exportId;
        this.productId = productId;
        this.packagingId = packagingId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        
    }

    public long getId() {
        return id;
    }

    public long getExportId() {
        return exportId;
    }

    public int getProductId() {
        return productId;
    }

    public int getPackagingId() {
        return packagingId;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    

    public void setId(long id) {
        this.id = id;
    }

    public void setExportId(long exportId) {
        this.exportId = exportId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setPackagingId(int packagingId) {
        this.packagingId = packagingId;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "ProductExportDetails{" + "id=" + id + ", exportId=" + exportId + ", productId=" + productId + ", packagingId=" + packagingId + ", quantity=" + quantity + ", unitPrice=" + unitPrice + '}';
    }

   

    
    
    
    
    
}
