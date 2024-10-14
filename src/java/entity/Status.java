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
public class Status {
    private int statusId;                   // ID duy nhất cho trạng thái
    private String statusName;               // Tên trạng thái
    private String description;               // Mô tả trạng thái
    public LocalDateTime created_at;
    public LocalDateTime updated_at;

    public Status() {
    }

    public Status(int statusId, String statusName, String description, LocalDateTime created_at, LocalDateTime updated_at) {
        this.statusId = statusId;
        this.statusName = statusName;
        this.description = description;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getStatusId() {
        return statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "Status{" + "statusId=" + statusId + ", statusName=" + statusName + ", description=" + description + ", created_at=" + created_at + ", updated_at=" + updated_at + '}';
    }
    
    
}
