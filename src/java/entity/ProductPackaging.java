/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Acer
 */
public class ProductPackaging {
    public int PackagingId;
    public String PackagingType;

    public ProductPackaging() {
    }

    public ProductPackaging(int PackagingId, String PackagingType) {
        this.PackagingId = PackagingId;
        this.PackagingType = PackagingType;
    }

    public int getPackagingId() {
        return PackagingId;
    }

    public String getPackagingType() {
        return PackagingType;
    }

    public void setPackagingId(int PackagingId) {
        this.PackagingId = PackagingId;
    }

    public void setPackagingType(String PackagingType) {
        this.PackagingType = PackagingType;
    }

    @Override
    public String toString() {
        return "ProductPackaging{" + "PackagingId=" + PackagingId + ", PackagingType=" + PackagingType + '}';
    }
    
    
}
