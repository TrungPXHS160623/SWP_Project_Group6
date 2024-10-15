/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;



/**
 *
 * @author Acer
 */
public class ProductExportDetails {
   private int id;               // ID duy nhất cho chi tiết xuất kho
    private int exportId;         // Liên kết tới lần xuất kho
    private int productId;         // Liên kết tới sản phẩm
    private int packagingId;       // Liên kết tới loại bao bì (vỉ, viên, hộp)
    private int quantity;   // Số lượng theo đơn vị nhập
    private float unitPrice;  // Đơn giá
    

    public ProductExportDetails() {
    }

    public ProductExportDetails(int id, int exportId, int productId, int packagingId, int quantity, float unitPrice) {
        this.id = id;
        this.exportId = exportId;
        this.productId = productId;
        this.packagingId = packagingId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        
    }

    public int getId() {
        return id;
    }

    public int getExportId() {
        return exportId;
    }

    public int getProductId() {
        return productId;
    }

    public int getPackagingId() {
        return packagingId;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    

    public void setId(int id) {
        this.id = id;
    }

    public void setExportId(int exportId) {
        this.exportId = exportId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setPackagingId(int packagingId) {
        this.packagingId = packagingId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "ProductExportDetails{" + "id=" + id + ", exportId=" + exportId + ", productId=" + productId + ", packagingId=" + packagingId + ", quantity=" + quantity + ", unitPrice=" + unitPrice + '}';
    }

   

    
    
    
    
    
}
