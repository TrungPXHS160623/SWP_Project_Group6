/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import dao.DAO;
import entity.Category;
import entity.Product;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Acer
 */
@WebServlet(name = "UpdateControl", urlPatterns = {"/update"})
public class UpdateControl extends HttpServlet {

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
        // Tạo một danh sách để chứa các thông báo lỗi
        List<String> errors = new ArrayList<>();
        try {
            //Get toàn bộ thông tin của thằng product muốn thay đổi
            int ProductID = Integer.parseInt(request.getParameter("productID"));
            String ProductName = request.getParameter("productName");
            int CategoryId = Integer.parseInt(request.getParameter("category")); // Chuyển đổi thành int
            String ProductImage = request.getParameter("productImage");
            String Ingredients = request.getParameter("ingredients");
            String Formulation = request.getParameter("formulation");
            String Specification = request.getParameter("specification");
            String ShortDescription = request.getParameter("shortDescription");
            String RegistrationNumber = request.getParameter("registrationNumber");
            float Price = Float.parseFloat(request.getParameter("price")); // Chuyển đổi thành float
            boolean isActive = Boolean.parseBoolean(request.getParameter("isActive"));

            // Validate dữ liệu
            if (ProductName == null || ProductName.isEmpty()) {
                errors.add("Tên sản phẩm không được để trống.");
            }

            if (ProductImage == null || ProductImage.isEmpty()) {
                errors.add("Hình ảnh không được để trống.");
            }

            if (!ProductImage.startsWith("http://") && !ProductImage.startsWith("https://")) {
                errors.add("Hình ảnh phải có định dạng URL hợp lệ (http:// hoặc https://).");
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


            if (ShortDescription == null || ShortDescription.isEmpty()) {
                errors.add("Mô tả ngắn không được để trống.");
            }

            if (RegistrationNumber == null || RegistrationNumber.isEmpty()) {
                errors.add("Số đăng ký không được để trống.");
            }

            try {
                Price = Float.parseFloat(request.getParameter("price"));
                if (Price <= 0) {
                    errors.add("Giá phải lớn hơn 0.");
                }
            } catch (NumberFormatException e) {
                errors.add("Giá không hợp lệ.");
            }

            // Nếu có lỗi, lưu lỗi vào session và chuyển hướng về Update.jsp
            if (!errors.isEmpty()) {
                HttpSession session = request.getSession();
                session.setAttribute("updateErrors", errors);
                request.setAttribute("load", new Product(ProductID, ProductName, CategoryId, ProductImage, Ingredients, Formulation, Specification, ShortDescription, RegistrationNumber, Price,isActive));
                // Lấy danh sách danh mục để hiển thị lại
                DAO dao = new DAO();
                List<Category> listCategory = dao.getAllCategory();
                request.setAttribute("ListCategory", listCategory);
                // Chuyển hướng lại trang Update.jsp với thông tin đã nhập
                request.getRequestDispatcher("Update.jsp").forward(request, response);
                return; // Dừng thực thi thêm
            }
            //thực hiện thay đổi
            DAO dao = new DAO();
            //dao.UpdateProduct(ProductName, CategoryId, ProductImage, Ingredients, Formulation, Specification, TargetAudience, PrescriptionMedication, ShortDescription, RegistrationNumber, Price, ProductID, isActive);
            dao.UpdateProduct(ProductName, CategoryId, ProductImage, Ingredients, Formulation, Specification, ShortDescription, RegistrationNumber, Price, ProductID);
            //gửi thông báo thành công về trang managerProductManager nếu thành công
            HttpSession session = request.getSession();
            session.setAttribute("updateMessage", "Cập nhật sản phẩm ID " + ProductID + " thành công!");
            response.sendRedirect("manager");

        } catch (Exception e) {
            HttpSession session = request.getSession();
            session.setAttribute("updateMessage", "Cập nhật sản phẩm thất bại: " + e.getMessage());
            response.sendRedirect("Update.jsp");
        }

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
        processRequest(request, response);
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
