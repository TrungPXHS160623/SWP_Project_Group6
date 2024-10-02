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
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String dob = request.getParameter("dob");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String re_password = request.getParameter("re_password");
        Customer customer = new Customer(0, firstName, lastName, username, dob, gender, phone, email, password);

        PrintWriter out = response.getWriter();

        DAO dao = new DAO();
        List<Customer> list;
        try {
            list = dao.getCustomers();
        } catch (Exception ex) {
            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (dao.checkUsernameExist(username)) {
            request.setAttribute("error", "This username is exist");
            request.getRequestDispatcher("Register.jsp").forward(request, response);
        } else if (dao.checkEmailExist(email)) {
            request.setAttribute("error", "This email is already registered");
            request.getRequestDispatcher("Register.jsp").forward(request, response);
        } else if (!password.equals(re_password)) {
            request.setAttribute("error", "Password not equal Repeat Password");
            request.getRequestDispatcher("Register.jsp").forward(request, response);
        } else if (!dao.isValidDob(dob)) {
            request.setAttribute("error", "You must be 16 years old or more");
            request.getRequestDispatcher("Register.jsp").forward(request, response);
        } else if (!email.endsWith("@gmail.com")) {
            request.setAttribute("error", "Email must be a gmail.com account");
            request.getRequestDispatcher("Register.jsp").forward(request, response);
        } else {
            String code = getRandom();
            SendEmail se = new SendEmail();
            se.sendEmail(email, "Your code is :", code);
            HttpSession session = request.getSession();
            session.setAttribute("customer", customer);
            session.setAttribute("code", code);

            request.getRequestDispatcher("verifyemail.jsp").forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private String hashPassword(String password) {
        return password;
    }

    private String getRandom() {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        return String.format("%06d", number);
    }

}
