/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Acer
 */
public class Pharamcies {
    private int pharmacy_id;             // ID duy nhất cho nhà thuốc
    private String pharmacy_name;        // Tên nhà thuốc
    private String address;             // Địa chỉ của nhà thuốc
    private String phoneNumber;         // Số điện thoại của nhà thuốc
    private boolean isActive;           // Trạng thái hoạt động của nhà thuốc

    
    public Pharamcies() {
    }
    
    public Pharamcies(int pharmacy_id, String pharmacy_name, String address, String phoneNumber, boolean isActive) {
        this.pharmacy_id = pharmacy_id;
        this.pharmacy_name = pharmacy_name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.isActive = isActive;
    }

    public int getPharmacy_id() {
        return pharmacy_id;
    }

    public String getPharmacy_name() {
        return pharmacy_name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setPharmacy_id(int pharmacy_id) {
        this.pharmacy_id = pharmacy_id;
    }

    public void setPharmacy_name(String pharmacy_name) {
        this.pharmacy_name = pharmacy_name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "Pharamcies{" + "pharmacy_id=" + pharmacy_id + ", pharmacy_name=" + pharmacy_name + ", address=" + address + ", phoneNumber=" + phoneNumber + ", isActive=" + isActive + '}';
    }

    
    
    
}
