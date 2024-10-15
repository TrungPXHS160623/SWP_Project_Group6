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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
@WebServlet(name = "ProfileCustomerControl", urlPatterns = {"/profile-customer"})
public class ProfileCustomerControl extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        List<String> errors = new ArrayList<>();
        HttpSession session = request.getSession();

        String fullName = request.getParameter("fullName").trim();
        String username = request.getParameter("username");
        String dob = request.getParameter("dob");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");

        // Validate dữ liệu
        if (fullName == null || !Pattern.matches("^[A-Za-zÀ-ỹ]+( [A-Za-zÀ-ỹ]+)*$", fullName) || fullName.length() > 25) {
            errors.add("Họ và tên không hợp lệ");
        }
        if (username == null || username.length() > 25 || username.contains(" ")) {
            errors.add("Tên đăng nhập không hợp lệ.");
        }
        if (!isOlderThan13(dob)) {
            errors.add("Ngày sinh không hợp lệ. Bạn phải ít nhất 13 tuổi.");
        }
        if (phone == null || !phone.matches("^(84|0[3|5|7|8|9])([0-9]{8,9})$")) {
            errors.add("Số điện thoại không hợp lệ. Vui lòng nhập đúng định dạng");
        }
        if (email == null || email.length() > 30 || !email.endsWith("@gmail.com")) {
            errors.add("Email không hợp lệ. Vui lòng nhập đúng định dạng gmail.");
        }

        // Nếu có lỗi, lưu lỗi vào session và chuyển hướng lại trang hồ sơ
        if (!errors.isEmpty()) {
            session.setAttribute("profileErrors", errors);
            request.getRequestDispatcher("profilecustomer.jsp").forward(request, response);
            return;
        }

        // Không có lỗi, tiếp tục cập nhật thông tin
        try {
            DAO dao = new DAO();
            dao.updateProfile(fullName, username, dob, gender, phone, email);

            // Lấy lại thông tin khách hàng từ cơ sở dữ liệu
            Customer updatedCustomer = dao.getCustomerByUsername(username);
            session.setAttribute("customer", updatedCustomer);

            // Thông báo thành công
            session.setAttribute("profileMessage", "Cập nhật hồ sơ thành công!");
            response.sendRedirect("profilecustomer.jsp");

        } catch (Exception e) {
            // Thông báo lỗi nếu có ngoại lệ xảy ra
            session.setAttribute("profileErrorMessage", "Cập nhật hồ sơ thất bại: " + e.getMessage());
            response.sendRedirect("profilecustomer.jsp");
        }
    }

    // Kiểm tra người dùng phải trên 13 tuổi
    private boolean isOlderThan13(String dob) {
        LocalDate birthDate = LocalDate.parse(dob);
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthDate, currentDate).getYears() >= 13;
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
