/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Acer
 */
public class ProductPackagingDetails {
    public int ProductId;
    public int PackagingId;
    public int QuantityPerPackage;
    public float UnitPrice;
    public boolean IsActive;

    public ProductPackagingDetails() {
    }

    public ProductPackagingDetails(int ProductId, int PackagingId, int QuantityPerPackage, float UnitPrice, boolean IsActive) {
        this.ProductId = ProductId;
        this.PackagingId = PackagingId;
        this.QuantityPerPackage = QuantityPerPackage;
        this.UnitPrice = UnitPrice;
        this.IsActive = IsActive;
    }

    public int getProductId() {
        return ProductId;
    }

    public int getPackagingId() {
        return PackagingId;
    }

    public int getQuantityPerPackage() {
        return QuantityPerPackage;
    }

    public float getUnitPrice() {
        return UnitPrice;
    }

    public boolean isIsActive() {
        return IsActive;
    }

    public void setProductId(int ProductId) {
        this.ProductId = ProductId;
    }

    public void setPackagingId(int PackagingId) {
        this.PackagingId = PackagingId;
    }

    public void setQuantityPerPackage(int QuantityPerPackage) {
        this.QuantityPerPackage = QuantityPerPackage;
    }

    public void setUnitPrice(float UnitPrice) {
        this.UnitPrice = UnitPrice;
    }

    public void setIsActive(boolean IsActive) {
        this.IsActive = IsActive;
    }

    @Override
    public String toString() {
        return "ProductPackagingDetails{" + "ProductId=" + ProductId + ", PackagingId=" + PackagingId + ", QuantityPerPackage=" + QuantityPerPackage + ", UnitPrice=" + UnitPrice + ", IsActive=" + IsActive + '}';
    }

    

    
    
}
