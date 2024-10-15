/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import dao.DAO;
import entity.Customer;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import service.SendEmail;

/**
 *
 * @author Admin
 */
@WebServlet(name = "RegisterController", urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");  
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<String> errors = new ArrayList<>();
        DAO dao = new DAO();

        // Lấy thông tin từ request
        String fullName = request.getParameter("fullName");
        String username = request.getParameter("username");
        String dob = request.getParameter("dob");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String rePassword = request.getParameter("re_password");

        // Validate dữ liệu
        if (!isValidFullName(fullName) || !Pattern.matches("^[A-Za-zÀ-ỹ]+( [A-Za-zÀ-ỹ]+)*$", fullName) || fullName.length() > 25) {
            errors.add("Họ và tên không hợp lệ.");
        }
        if (!isValidUsername(username)) {
            errors.add("Tên đăng nhập không hợp lệ.");
        } else if (username.length() > 25) {
            errors.add("Tên đăng nhập không được dài quá 25 ký tự.");
        } else if (dao.checkUsernameExist(username)) {
            errors.add("Tên đăng nhập đã tồn tại.");
        }
        if (dao.checkEmailExist(email)) {
            errors.add("Email đã được đăng ký.");
        }
        if (!password.equals(rePassword)) {
            errors.add("Mật khẩu và xác nhận mật khẩu không khớp.");
        }
        if (!isValidPassword(password)) {
            errors.add("Mật khẩu không hợp lệ.");
        }
        if (!email.endsWith("@gmail.com") || email.length() > 30) {
            errors.add("Email phải là Gmail và không quá 30 ký tự.");
        }
        if (!isValidPhone(phone)) {
            errors.add("Số điện thoại không hợp lệ.");
        }
        if (!dao.isValidDob(dob)) {
            errors.add("Bạn phải từ 16 tuổi trở lên.");
        }

        // Nếu có lỗi, lưu lỗi vào session và chuyển hướng lại trang đăng ký
        if (!errors.isEmpty()) {
            HttpSession session = request.getSession();
            session.setAttribute("registerErrors", errors);
            request.setAttribute("fullName", fullName);
            request.setAttribute("username", username);
            request.setAttribute("dob", dob);
            request.setAttribute("gender", gender);
            request.setAttribute("phone", phone);
            request.setAttribute("email", email);
            request.getRequestDispatcher("Register.jsp").forward(request, response);
            return; // Dừng thực thi thêm
        }

        // Tạo đối tượng Customer
        Customer customer = new Customer(0, fullName, username, dob, gender, phone, email, password);
        String code = getRandom();
        SendEmail se = new SendEmail();
        se.sendEmail(email, "Your code is :", code);
        HttpSession session = request.getSession();
        session.setAttribute("customer", customer);
        session.setAttribute("code", code);

        request.getRequestDispatcher("verifyemail.jsp").forward(request, response);
    }

    // Các phương thức kiểm tra và xác thực
    private boolean isValidFullName(String fullName) {
        return fullName != null && fullName.length() <= 25 && fullName.matches("[a-zA-Z ]+")
                && !fullName.contains("  ") && !fullName.startsWith(" ") && !fullName.endsWith(" ");
    }

    private boolean isValidUsername(String username) {
        return username != null && username.length() <= 25 && username.matches("[a-zA-Z0-9]+")
                && !username.contains("  ") && !username.startsWith(" ") && !username.endsWith(" ");
    }

    private boolean isValidPassword(String password) {
        String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$";
        return password != null && password.matches(passwordPattern) && !password.contains(" ");
    }

    private boolean isValidPhone(String phone) {
        String phonePattern = "^(84|0[3|5|7|8|9])+([0-9]{8,9})$";
        return phone != null && phone.matches(phonePattern) && phone.length() <= 11;
    }

    private String getRandom() {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        return String.format("%06d", number);
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
