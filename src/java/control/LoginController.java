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
        String role = request.getParameter("role");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        DAO dao = new DAO();

        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            request.setAttribute("error", "Username or password cannot be empty");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        try {
            // Handle login based on role
            if (role.equals("customer")) {
                Customer customer = dao.checkLogin(username, password);
                if (customer != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("user", customer);
                    session.setAttribute("role", "customer");
                    request.getRequestDispatcher("home").forward(request, response);  // Redirect to customer home page
                } else {
                    request.setAttribute("error", "Invalid customer username or password");
                    request.getRequestDispatcher("Login.jsp").forward(request, response);
                }
            } else if (role.equals("doctor")) {
                Doctor doctor = dao.checkDoctorLogin(username, password);
                if (doctor != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("user", doctor);
                    session.setAttribute("role", "doctor");
                    request.getRequestDispatcher("home").forward(request, response);  // Redirect to doctor home page
                } else {
                    request.setAttribute("error", "Invalid doctor username or password");
                    request.getRequestDispatcher("Login.jsp").forward(request, response);
                }
            } else if (role.equals("admin")) {
                Admin admin = dao.checkAdminLogin(username, password);
                if (admin != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("user", admin);
                    session.setAttribute("role", "admin");
                    request.getRequestDispatcher("home").forward(request, response);  // Redirect to admin home page
                } else {
                    request.setAttribute("error", "Invalid admin username or password");
                    request.getRequestDispatcher("Login.jsp").forward(request, response);
                }
            } else {
                // If the role is unknown, return an error
                request.setAttribute("error", "Invalid role specified");
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("error", "An error occurred while processing the login");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Login Controller handling multiple roles (customer, doctor, admin)";
    }
}
