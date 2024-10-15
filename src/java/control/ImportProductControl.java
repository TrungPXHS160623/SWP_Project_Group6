/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import dao.EmployeeDAO;
import dao.ProductPackagingDAO;
import dao.StatusDAO;
import dao.SupplierDAO;
import dao.WarehouseDAO;
import entity.ProductImportDetails;
import entity.ProductPackaging;
import entity.Status;
import entity.Supplier;
import entity.WareHouse;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import service.ImportProductService;

/**
 *
 * @author Acer
 */
public class ImportProductControl extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ImportProductControl</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ImportProductControl at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        SupplierDAO daoSupplier = new SupplierDAO();
        List<Supplier> listS = daoSupplier.getAllSuppliers();
        ProductPackagingDAO daoPackage = new ProductPackagingDAO();
        List<ProductPackaging> listP = daoPackage.getAllPackage();
        WarehouseDAO daoWarehouse = new WarehouseDAO();
        List<WareHouse> listW = daoWarehouse.getAllWarehouses();
        String x = "1";
        StatusDAO daoStatus = new StatusDAO();
        Status status = daoStatus.getStatusById(x);
        //lấy ngày hiện tại
        LocalDate today = LocalDate.now();
        String todayString = today.toString();

        request.setAttribute("Status", status);
        request.setAttribute("listW", listW);
        request.setAttribute("listS", listS);
        request.setAttribute("listP", listP);
        request.setAttribute("DateOfToday", todayString);
        request.getRequestDispatcher("ImportProduct.jsp").forward(request, response);
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
        ImportProductService dao = new ImportProductService();
        EmployeeDAO dao1 = new EmployeeDAO();
        SupplierDAO dao2 = new SupplierDAO();
        WarehouseDAO dao3 = new WarehouseDAO();
        try {
            // Lấy các danh sách các thông tin của sản phẩm bên phần import
            int employeeId = Integer.parseInt(request.getParameter("employeeId"));
            int supplierId = Integer.parseInt(request.getParameter("supplier"));
            int warehouseId = Integer.parseInt(request.getParameter("warehouse"));
            String importDateString = request.getParameter("importDate");
            SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd"); // Định dạng ngày
            Date importDate = dateformat.parse(importDateString);
            int statusId = Integer.parseInt(request.getParameter("statusId")); // Thay đổi để lấy statusId

            StringBuilder errorMessage = new StringBuilder();
            boolean isValid = true;

            //kiểm tra mã nhân viên
            if (String.valueOf(employeeId) == null || String.valueOf(employeeId).isEmpty()) {
                errorMessage.append("Mã nhân viên không được để trống. ");
                isValid = false;
            } else if (dao1.getEmployeeById(employeeId) == null) {
                errorMessage.append("Mã nhân viên không tồn tại. ");
                isValid = false;
            }

            //kiểm tra mã nhà cung cấp
            if (String.valueOf(supplierId) == null || String.valueOf(supplierId).isEmpty()) {
                errorMessage.append("Mã nhà cung cấp không được để trống. ");
                isValid = false;
            } else if (dao2.getSupplierById(supplierId) == null) {
                errorMessage.append("Mã nhà cung cấp không tồn tại. ");
                isValid = false;
            }

            //kiểm tra mã kho
            if (String.valueOf(warehouseId) == null || String.valueOf(warehouseId).isEmpty()) {
                errorMessage.append("Mã nhà kho không được để trống. ");
                isValid = false;
            } else if (dao3.getWarehouseById(warehouseId) == null) {
                errorMessage.append("Mã nhà kho không tồn tại. ");
                isValid = false;
            }

            // Danh sách sản phẩm nhập
            List<ProductImportDetails> importDetails = new ArrayList<>();
            // Lặp qua các chi tiết sản phẩm trong request
            String[] productIds = request.getParameterValues("product_id");
            String[] packagingIds = request.getParameterValues("packaging_id");
            String[] quantities = request.getParameterValues("quantity");
            String[] unitPrices = request.getParameterValues("unitPrice");
            String[] batchNumbers = request.getParameterValues("batchNumber");
            String[] manufactureDates = request.getParameterValues("manufactureDate");
            String[] expirationDates = request.getParameterValues("expirationDate");
            //validate mã sản phẩm

            if (productIds != null && productIds.length > 0) {
                for (int i = 0; i < productIds.length; i++) {
                    ProductImportDetails detail = new ProductImportDetails();

                    // Validate mã sản phẩm
                    if (productIds[i] == null || productIds[i].trim().isEmpty()) {
                        errorMessage.append("Mã sản phẩm không được để trống. ");
                        isValid = false;
                        break; // Dừng quá trình nếu phát hiện lỗi
                    }
                    detail.setProduct_id(Integer.parseInt(productIds[i]));
                    // do đã dùng selection box nên không cần validate
                    detail.setPackaging_id(Integer.parseInt(packagingIds[i]));

                    // Validate số lượng
                    if (quantities[i] == null || quantities[i].trim().isEmpty()) {
                        errorMessage.append("Số lượng không được để trống. ");
                        isValid = false;
                        break;
                    }

                    int quantity = Integer.parseInt(quantities[i]);
                    if (quantity <= 0) {
                        errorMessage.append("Số lượng phải lớn hơn 0. ");
                        isValid = false;
                        break;
                    }
                    detail.setQuantity(Integer.parseInt(quantities[i]));
                    // Validate giá nhập
                    if (unitPrices[i] == null || unitPrices[i].trim().isEmpty()) {
                        errorMessage.append("Giá nhập không được để trống. ");
                        isValid = false;
                        break;
                    }

                    float unitPrice = Float.parseFloat(unitPrices[i]);
                    if (unitPrice < 0) {
                        errorMessage.append("Giá nhập không được nhỏ hơn 0. ");
                        isValid = false;
                        break;
                    }
                    detail.setUnitPrice(Float.parseFloat(unitPrices[i]));

                    // Validate số lô sản xuất
                    if (batchNumbers[i] == null || batchNumbers[i].trim().isEmpty()) {
                        errorMessage.append("Số lô sản xuất không được để trống. ");
                        isValid = false;
                        break;
                    }
                    detail.setBatchNumber(batchNumbers[i]);

                    // Validate ngày sản xuất
                    if (manufactureDates[i] == null || manufactureDates[i].trim().isEmpty()) {
                        errorMessage.append("Ngày sản xuất không được để trống. ");
                        isValid = false;
                        break;
                    }
                    detail.setManufactureDate(dateformat.parse(manufactureDates[i]));

                    // Validate ngày hết hạn
                    if (expirationDates[i] == null || expirationDates[i].trim().isEmpty()) {
                        errorMessage.append("Ngày hết hạn không được để trống. ");
                        isValid = false;
                        break;
                    }
                    detail.setExpirationDate(dateformat.parse(expirationDates[i]));

                    // Kiểm tra xem ngày hết hạn có sau ngày sản xuất không
                    if (detail.getExpirationDate().before(detail.getManufactureDate())) {
                        errorMessage.append("Ngày hết hạn phải lớn hơn hoặc bằng ngày sản xuất. ");
                        isValid = false;
                        break;
                    }

                    importDetails.add(detail);
                }
            }

            HttpSession session = request.getSession();

            // Kiểm tra tính hợp lệ trước khi nhập hàng
            if (!isValid) {
                session.setAttribute("importFailMessage", "Bạn đã nhập kho thất bại");
                session.setAttribute("errorMessages", errorMessage.toString());
                response.sendRedirect("ImportProduct.jsp");
                return;
            }

            // Gọi hàm importProducts để nhập hàng
            boolean result = dao.importProducts(employeeId, supplierId, warehouseId, importDate, importDetails, statusId);
            if (result) {
                session.setAttribute("importSuccessMessage", "Bạn đã nhập kho thành công");
                response.sendRedirect("importproductlistcontrol"); // Chuyển tới trang ImportProductList.jsp
            } else {
                session.setAttribute("importFailMessage", "Bạn đã nhập kho thất bại");
                response.sendRedirect("ImportProduct.jsp"); // Ở lại trang ImportProduct.jsp
            }
        } catch (Exception e) {
            e.printStackTrace(); // In ra lỗi vào console để gỡ lỗi
            HttpSession session = request.getSession();
            session.setAttribute("importFailMessage", "Đã xảy ra lỗi: " + e.getMessage());
            response.sendRedirect("ImportProduct.jsp");
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
