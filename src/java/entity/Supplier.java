/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.time.LocalDateTime;



/**
 *
 * @author Acer
 */
public class Supplier {
    
    public long supplier_id;
    public String supplier_name;
    public String contact_name;
    public String contact_email;
    public String address;
    public LocalDateTime created_at;
    public LocalDateTime updated_at;

    public Supplier() {
    }

    public Supplier(long supplier_id, String supplier_name, String contact_name, String contact_email, String address, LocalDateTime created_at, LocalDateTime updated_at) {
        this.supplier_id = supplier_id;
        this.supplier_name = supplier_name;
        this.contact_name = contact_name;
        this.contact_email = contact_email;
        this.address = address;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public long getSupplier_id() {
        return supplier_id;
    }

    public String getSupplier_name() {
        return supplier_name;
    }

    public String getContact_name() {
        return contact_name;
    }

    public String getContact_email() {
        return contact_email;
    }

    public String getAddress() {
        return address;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setSupplier_id(long supplier_id) {
        this.supplier_id = supplier_id;
    }

    public void setSupplier_name(String supplier_name) {
        this.supplier_name = supplier_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }

    public void setContact_email(String contact_email) {
        this.contact_email = contact_email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "Supplier{" + "supplier_id=" + supplier_id + ", supplier_name=" + supplier_name + ", contact_name=" + contact_name + ", contact_email=" + contact_email + ", address=" + address + ", created_at=" + created_at + ", updated_at=" + updated_at + '}';
    }  
}
