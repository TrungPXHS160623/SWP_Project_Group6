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
public class ProductImportDetails {
    private int id;               // ID duy nhất cho chi tiết nhập kho
    private int import_id;         // Liên kết tới đợt nhập kho
    private int product_id;         // Liên kết tới sản phẩm
    private int packaging_id;       // Liên kết tới loại bao bì (vỉ, viên, hộp)
    private int quantity;   // Số lượng theo đơn vị nhập (hộp, vỉ, viên)
    private float unitPrice;  // Giá đơn vị
    private String batchNumber;         // Số lô sản xuất
    private Date manufactureDate;       // Ngày sản xuất
    private Date expirationDate;        // Ngày hết hạn

    public ProductImportDetails() {
    }

    public ProductImportDetails(int id, int import_id, int product_id, int packaging_id, int quantity, float unitPrice, String batchNumber, Date manufactureDate, Date expirationDate) {
        this.id = id;
        this.import_id = import_id;
        this.product_id = product_id;
        this.packaging_id = packaging_id;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.batchNumber = batchNumber;
        this.manufactureDate = manufactureDate;
        this.expirationDate = expirationDate;
    }

    public int getId() {
        return id;
    }

    public int getImport_id() {
        return import_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public int getPackaging_id() {
        return packaging_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getUnitPrice() {
        return unitPrice;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setImport_id(int import_id) {
        this.import_id = import_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public void setPackaging_id(int packaging_id) {
        this.packaging_id = packaging_id;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
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

    @Override
    public String toString() {
        return "ProductImportDetails{" + "id=" + id + ", import_id=" + import_id + ", product_id=" + product_id + ", packaging_id=" + packaging_id + ", quantity=" + quantity + ", unitPrice=" + unitPrice + ", batchNumber=" + batchNumber + ", manufactureDate=" + manufactureDate + ", expirationDate=" + expirationDate + '}';
    }     
    
}
