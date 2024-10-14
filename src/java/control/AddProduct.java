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
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
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
        List<String> errors = new ArrayList<>();

        try {
            // Lấy thông tin từ request
            String ProductName = request.getParameter("productName");
            int CategoryId = Integer.parseInt(request.getParameter("category"));
            String ProductImage = request.getParameter("productImage");
            String Ingredients = request.getParameter("ingredients");
            String Formulation = request.getParameter("formulation");
            String Specification = request.getParameter("specification");
            String ShortDescription = request.getParameter("shortDescription");
            String RegistrationNumber = request.getParameter("registrationNumber");
            float Price = Float.parseFloat(request.getParameter("price"));
            boolean isActive = Boolean.parseBoolean(request.getParameter("isActive"));
            // Validate dữ liệu
            if (ProductName == null || ProductName.isEmpty() || ProductName.length() > 100) {
                errors.add("Tên sản phẩm không được để trống và phải dưới 100 ký tự.");
            }

            if (CategoryId <= 0) {
                errors.add("Danh mục không hợp lệ.");
            }

            if (ProductImage == null || ProductImage.isEmpty() || !ProductImage.startsWith("http://") && !ProductImage.startsWith("https://")) {
                errors.add("Hình ảnh không được để trống và phải có định dạng URL hợp lệ.");
            }

            if (Ingredients == null || Ingredients.isEmpty()) {
                errors.add("Thành phần không được để trống.");
            }

            if (Formulation == null || Formulation.isEmpty()) {
                errors.add("Cách bào chế không được để trống.");
            }

            if (Specification == null || Specification.isEmpty()) {
                errors.add("Thông số kỹ thuật không được để trống.");
            }


            if (ShortDescription == null || ShortDescription.isEmpty() || ShortDescription.length() > 250) {
                errors.add("Mô tả ngắn không được để trống và phải dưới 250 ký tự.");
            }

            if (RegistrationNumber == null || RegistrationNumber.isEmpty()) {
                errors.add("Số đăng ký không được để trống.");
            }

            try {
                if (Price <= 0) {
                    errors.add("Giá phải lớn hơn 0.");
                }
            } catch (NumberFormatException e) {
                errors.add("Giá không hợp lệ.");
            }

            // Nếu có lỗi, lưu lỗi vào session và chuyển hướng lại trang AddProduct.jsp
            if (!errors.isEmpty()) {
                HttpSession session = request.getSession();
                session.setAttribute("addErrors", errors);
                request.setAttribute("ListCategory", new DAO().getAllCategory());
                request.getRequestDispatcher("AddProduct.jsp").forward(request, response);
                return; // Dừng thực thi thêm
            }

            // Gọi hàm InsertProduct
            DAO dao = new DAO();
            dao.InsertProduct(ProductName, CategoryId, ProductImage, Ingredients, Formulation, Specification, ShortDescription, RegistrationNumber, Price);

            // Lưu thông báo thành công vào session
            HttpSession session = request.getSession();
            session.setAttribute("addMessage", "Thêm sản phẩm thành công!");
            response.sendRedirect("manager");

        } catch (Exception e) {
            // Lưu thông báo thất bại vào session
            HttpSession session = request.getSession();
            session.setAttribute("addErrorMessage", "Thêm sản phẩm thất bại: " + e.getMessage());
            response.sendRedirect("AddProduct.jsp");
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
