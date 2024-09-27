/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Acer
 */
public class Category {
    private int CategoryID;
    
    private String CategoryName;
    
    private boolean IsActive;

    public Category() {
    }

    public Category(int CategoryID, String CategoryName, boolean IsActive) {
        this.CategoryID = CategoryID;
        this.CategoryName = CategoryName;
        this.IsActive = IsActive;
    }

    public int getCategoryID() {
        return CategoryID;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public boolean isIsActive() {
        return IsActive;
    }

    public void setCategoryID(int CategoryID) {
        this.CategoryID = CategoryID;
    }

    public void setCategoryName(String CategoryName) {
        this.CategoryName = CategoryName;
    }

    public void setIsActive(boolean IsActive) {
        this.IsActive = IsActive;
    }

    @Override
    public String toString() {
        return "Category{" + "CategoryID=" + CategoryID + ", CategoryName=" + CategoryName + ", IsActive=" + IsActive + '}';
    }

    
    
}
