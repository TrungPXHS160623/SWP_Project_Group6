/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 *
 * @author Admin
 */
public class Encryption {
    public static String MD5Encryption(String password) {
        try {
            if (password != null) {
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(password.getBytes());
                
                // Chuyển kết quả từ byte array sang chuỗi thập lục phân
                byte[] digest = md.digest();
                StringBuilder sb = new StringBuilder();
                for (byte b : digest) {
                    sb.append(String.format("%02x", b));  // %02x: chuyển byte sang chuỗi hex, đảm bảo 2 ký tự
                }
                return sb.toString();
            }
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}


