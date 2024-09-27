/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import dao.DAO;
import entity.Category;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import org.apache.catalina.connector.Response;

/**
 *
 * @author Acer
 */
@WebServlet(name = "AddProduct", urlPatterns = {"/add"})
public class AddProduct extends HttpServlet {

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
        DAO dao = new DAO();
        List<Category> listCategory = dao.getAllCategory();
        request.setAttribute("ListCategory", listCategory);
        request.getRequestDispatcher("AddProduct.jsp").forward(request, response);
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
    request.setCharacterEncoding("UTF-8");
    
    try {
        // Lấy thông tin từ request
        String ProductName = request.getParameter("productName");
        int CategoryId = Integer.parseInt(request.getParameter("category")); // Chuyển đổi thành int
        String ProductImage = request.getParameter("productImage");
        String Ingredients = request.getParameter("ingredients");
        String Formulation = request.getParameter("formulation");
        String Specification = request.getParameter("specification");
        String TargetAudience = request.getParameter("targetAudience");
        boolean PrescriptionMedication = Boolean.parseBoolean(request.getParameter("prescriptionMedication")); // Chuyển đổi thành boolean
        String ShortDescription = request.getParameter("shortDescription");
        String RegistrationNumber = request.getParameter("registrationNumber");
        float Price = Float.parseFloat(request.getParameter("price")); // Chuyển đổi thành float
        
        
        DAO dao = new DAO();

        // Gọi hàm InsertProduct với đúng thứ tự các tham số
        dao.InsertProduct(ProductName, CategoryId, ProductImage, Ingredients, Formulation, Specification, TargetAudience, PrescriptionMedication, ShortDescription, RegistrationNumber, Price);
        
        // Chuyển hướng đến trang quản lý
        response.sendRedirect("manager");
        
        
    } catch (NumberFormatException e) {
        e.printStackTrace(); // Xử lý lỗi nếu không thể chuyển đổi số
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid input for CategoryId, Price or PrescriptionMedication.");
    } catch (Exception e) {
        e.printStackTrace(); // Xử lý lỗi khác
        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while processing your request.");
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
    

}
