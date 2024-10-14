package control;

import dao.DAO;
import entity.Customer;
import entity.Doctor;  // Assuming you have a Doctor entity
import entity.Admin;   // Assuming you have an Admin entity
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Handles login requests for multiple roles (customer, doctor, admin)
 */
@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String role = request.getParameter("role");
        if (role.equals("doctor")) {
            request.getRequestDispatcher("loginDoctor.jsp").forward(request, response);
        } else if (role.equals("customer")) {
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("loginAdmin.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the role parameter to distinguish between customer, doctor, or admin login
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        DAO dao = new DAO();

        try {
            Customer c = dao.checkLogin(username, password);
            if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
                request.getRequestDispatcher("login.jsp").forward(request, response);
                return;
            } 
            
            if (c == null) {
                request.setAttribute("error", "Wrong username or password");
                request.getRequestDispatcher("login.jsp").forward(request, response);

            } else {
                // If the user credentials are valid, create a new session
                HttpSession session = request.getSession();
                session.setAttribute("customer", c);
                request.getRequestDispatcher("home").forward(request, response);
            }

        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Login Controller handling multiple roles (customer, doctor, admin)";
    }
}
