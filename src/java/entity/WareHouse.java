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
public class WareHouse {
    private int id;                // ID duy nhất cho cửa hàng/kho
    private String store_code;       // Mã cửa hàng (store_code)
    private String store_name;       // Tên cửa hàng (store_name)
    private String description;     // Mô tả cửa hàng (description)
    public Date created_at;
    public Date updated_at;    

    public WareHouse() {
    }

    public WareHouse(int id, String store_code, String store_name, String description, Date created_at, Date updated_at) {
        this.id = id;
        this.store_code = store_code;
        this.store_name = store_name;
        this.description = description;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getId() {
        return id;
    }

    public String getStore_code() {
        return store_code;
    }

    public String getStore_name() {
        return store_name;
    }

    public String getDescription() {
        return description;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStore_code(String store_code) {
        this.store_code = store_code;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "WareHouse{" + "id=" + id + ", store_code=" + store_code + ", store_name=" + store_name + ", description=" + description + ", created_at=" + created_at + ", updated_at=" + updated_at + '}';
    }
       
}
