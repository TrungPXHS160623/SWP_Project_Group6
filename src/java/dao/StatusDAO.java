/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import entity.Status;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Acer
 */
public class StatusDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Status> getAllStatus() {
        List<Status> list = new ArrayList<>();
        String query = "Select * from Status_Final ";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Status(rs.getInt(1),
                         rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4),
                        rs.getDate(5)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Status getStatusById(String sid) {
        Status status = new Status();
        String query = "Select * from Status_Final where statusId = ? ";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, sid);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Status(rs.getInt(1),
                         rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4),
                        rs.getDate(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        StatusDAO statusDAO = new StatusDAO();
        List<Status> statusList = statusDAO.getAllStatus();
        Status ok = statusDAO.getStatusById("1");

        System.out.println(ok);

        // In kết quả ra màn hình
        if (statusList != null && !statusList.isEmpty()) {
            for (Status o : statusList) {
                System.out.println(o);
            }
        } else {
            System.out.println("No statuses found.");
        }
    }

}
