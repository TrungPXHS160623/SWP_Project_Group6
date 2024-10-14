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
    private String ShortDescription;
    private String RegistrationNumber;
    private float Price;
    private Boolean isActive;
    
    public Product() {
    }

    public Product(int ProductID, String ProductName, int CategoryId, String ProductImage, String Ingredients, String Formulation, String Specification, String ShortDescription, String RegistrationNumber, float Price, Boolean isActive) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.CategoryId = CategoryId;
        this.ProductImage = ProductImage;
        this.Ingredients = Ingredients;
        this.Formulation = Formulation;
        this.Specification = Specification;
        this.ShortDescription = ShortDescription;
        this.RegistrationNumber = RegistrationNumber;
        this.Price = Price;
        this.isActive = isActive;
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

    public String getShortDescription() {
        return ShortDescription;
    }

    public String getRegistrationNumber() {
        return RegistrationNumber;
    }

    public float getPrice() {
        return Price;
    }

    public Boolean getIsActive() {
        return isActive;
    }

     // Setters
    public void setProductID(int productID) {
        this.ProductID = productID;
    }

    public void setProductName(String productName) {
        this.ProductName = productName;
    }

    public void setCategoryId(int categoryId) {
        this.CategoryId = categoryId;
    }

    public void setProductImage(String productImage) {
        this.ProductImage = productImage;
    }

    public void setIngredients(String ingredients) {
        this.Ingredients = ingredients;
    }

    public void setFormulation(String formulation) {
        this.Formulation = formulation;
    }

    public void setSpecification(String specification) {
        this.Specification = specification;
    }

    public void setShortDescription(String shortDescription) {
        this.ShortDescription = shortDescription;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.RegistrationNumber = registrationNumber;
    }

    public void setPrice(float price) {
        this.Price = price;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    // toString method
    @Override
    public String toString() {
        return "Product{" +
                "ProductID=" + ProductID +
                ", ProductName='" + ProductName + '\'' +
                ", CategoryId=" + CategoryId +
                ", ProductImage='" + ProductImage + '\'' +
                ", Ingredients='" + Ingredients + '\'' +
                ", Formulation='" + Formulation + '\'' +
                ", Specification='" + Specification + '\'' +
                ", ShortDescription='" + ShortDescription + '\'' +
                ", RegistrationNumber='" + RegistrationNumber + '\'' +
                ", Price=" + Price +
                ", isActive=" + isActive +
                '}';
    }
    
            
}
