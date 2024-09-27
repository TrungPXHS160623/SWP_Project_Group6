/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Acer
 */
public class Product {
    private int ProductID;
    private String ProductName;
    private int CategoryId;
    private String ProductImage;
    private String Ingredients;
    private String Formulation;
    private String Specification;
    private String TargetAudience;
    private boolean PrescriptionMedication;
    private String ShortDescription;
    private String RegistrationNumber;
    private float Price;
    
    public Product() {
    }

    public Product(int ProductID, String ProductName, int CategoryId, String ProductImage, String Ingredients, String Formulation, String Specification, String TargetAudience, boolean PrescriptionMedication, String ShortDescription, String RegistrationNumber, float Price) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.CategoryId = CategoryId;
        this.ProductImage = ProductImage;
        this.Ingredients = Ingredients;
        this.Formulation = Formulation;
        this.Specification = Specification;
        this.TargetAudience = TargetAudience;
        this.PrescriptionMedication = PrescriptionMedication;
        this.ShortDescription = ShortDescription;
        this.RegistrationNumber = RegistrationNumber;
        this.Price = Price;
    }

    public int getProductID() {
        return ProductID;
    }

    public String getProductName() {
        return ProductName;
    }

    public int getCategoryId() {
        return CategoryId;
    }

    public String getProductImage() {
        return ProductImage;
    }

    public String getIngredients() {
        return Ingredients;
    }

    public String getFormulation() {
        return Formulation;
    }

    public String getSpecification() {
        return Specification;
    }

    public String getTargetAudience() {
        return TargetAudience;
    }

    public boolean isPrescriptionMedication() {
        return PrescriptionMedication;
    }

    public String getShortDescription() {
        return ShortDescription;
    }

    public String getRegistrationNumber() {
        return RegistrationNumber;
    }

    public float getPrice() {
        return Price;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public void setCategoryId(int CategoryId) {
        this.CategoryId = CategoryId;
    }

    public void setProductImage(String ProductImage) {
        this.ProductImage = ProductImage;
    }

    public void setIngredients(String Ingredients) {
        this.Ingredients = Ingredients;
    }

    public void setFormulation(String Formulation) {
        this.Formulation = Formulation;
    }

    public void setSpecification(String Specification) {
        this.Specification = Specification;
    }

    public void setTargetAudience(String TargetAudience) {
        this.TargetAudience = TargetAudience;
    }

    public void setPrescriptionMedication(boolean PrescriptionMedication) {
        this.PrescriptionMedication = PrescriptionMedication;
    }

    public void setShortDescription(String ShortDescription) {
        this.ShortDescription = ShortDescription;
    }

    public void setRegistrationNumber(String RegistrationNumber) {
        this.RegistrationNumber = RegistrationNumber;
    }

    public void setPrice(float Price) {
        this.Price = Price;
    }

    @Override
    public String toString() {
        return "Product{" + "ProductID=" + ProductID + ", ProductName=" + ProductName + ", CategoryId=" + CategoryId + ", ProductImage=" + ProductImage + ", Ingredients=" + Ingredients + ", Formulation=" + Formulation + ", Specification=" + Specification + ", TargetAudience=" + TargetAudience + ", PrescriptionMedication=" + PrescriptionMedication + ", ShortDescription=" + ShortDescription + ", RegistrationNumber=" + RegistrationNumber + ", Price=" + Price + '}';
    }

    
            
}
