/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package control;

import dao.EmployeeDAO;
import dao.ProductImportsDAO;
import dao.StatusDAO;
import dao.SupplierDAO;
import dao.WarehouseDAO;
import entity.Employees;
import entity.ProductImports;
import entity.Status;
import entity.Supplier;
import entity.WareHouse;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author Acer
 */
@WebServlet(name="ImportProductListControl", urlPatterns={"/importproductlistcontrol"})
public class ImportProductListControl extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ImportProductListControl</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ImportProductListControl at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        // Lấy danh sách nhập hàng từ DAO
        ProductImportsDAO dao = new ProductImportsDAO();
        List<ProductImports> listImports = dao.getAllImports();
        WarehouseDAO dao1 = new WarehouseDAO();
        List<WareHouse> listW = dao1.getAllWarehouses();
        EmployeeDAO dao2 = new EmployeeDAO();
        List<Employees> listE = dao2.getAllEmployees();
        SupplierDAO dao3 = new SupplierDAO();
        List<Supplier> listS = dao3.getAllSuppliers();
        StatusDAO dao4 = new StatusDAO();
        List<Status> listSS = dao4.getAllStatus();
                
        // Truyền dữ liệu vào request
        request.setAttribute("listSS", listSS);
        request.setAttribute("listW", listW);
        request.setAttribute("listE", listE);
        request.setAttribute("listS", listS);
        request.setAttribute("listImports", listImports);

        // Forward tới JSP để hiển thị
        request.getRequestDispatcher("ImportProductList.jsp").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
