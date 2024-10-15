/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.InventoryDAO;
import dao.ProductImportDetailsDAO;
import dao.ProductImportsDAO;
import dao.ProductionBatchDAO;
import entity.ProductImportDetails;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Acer
 */
public class ImportProductService {

    private ProductImportsDAO productImportDAO = new ProductImportsDAO();
    private ProductionBatchDAO productionBatchDAO = new ProductionBatchDAO();
    private ProductImportDetailsDAO productImportDetailsDAO = new ProductImportDetailsDAO();
    private InventoryDAO inventoryDAO = new InventoryDAO();

    // Quy trình nhập kho hoàn chỉnh
    public boolean importProducts(int employeeId, int supplierId, int warehouseId, Date importDate, List<ProductImportDetails> importDetails, int statusId) throws Exception {
        // Bước 1: Tạo đơn nhập kho
        boolean createdImport = productImportDAO.createImport(warehouseId, employeeId, supplierId, importDate, statusId);
        if (!createdImport) {
            return false;
        }

        // Lấy ID của đơn nhập kho mới tạo
        int importId = productImportDAO.getLastInsertedImportId();
        if (importId == -1) {
            return false;
        }

        // Bước 2: Xử lý từng sản phẩm nhập kho
        for (ProductImportDetails detail : importDetails) {
            // Thêm lô sản xuất
            boolean addedBatch = productionBatchDAO.createProductionBatch(detail.getProduct_id(), importId, detail.getBatchNumber(), detail.getManufactureDate(), detail.getManufactureDate(), true); // isActive = true
            if (!addedBatch) {
                return false;
            }

            // Ghi nhận chi tiết sản phẩm nhập kho
            boolean addedDetail = productImportDetailsDAO.createProductImportDetail(importId, detail.getProduct_id(), detail.getPackaging_id(), detail.getQuantity(), detail.getUnitPrice(), detail.getBatchNumber(), detail.getManufactureDate(), detail.getManufactureDate());
            if (!addedDetail) {
                return false;
            }

            // Cập nhật tồn kho
            boolean updatedInventory = inventoryDAO.createOrUpdateInventory(detail.getProduct_id(), warehouseId, detail.getPackaging_id(), detail.getQuantity());
            if (!updatedInventory) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // Tạo một danh sách chi tiết nhập sản phẩm
        List<ProductImportDetails> importDetails = new ArrayList<>();

        // Thêm chi tiết sản phẩm vào danh sách
        importDetails.add(new ProductImportDetails(1, 1, 68, 1, 10, 10.00f, // Sử dụng 10.00f cho float
                "Batch001",
                new Date(),
                new Date()));

        // Thêm chi tiết sản phẩm thứ hai
        importDetails.add(new ProductImportDetails(2, 1, 69, 1, 20, 20.00f, // Sử dụng 20.00f cho float
                "Batch002",
                new Date(),
                new Date()));

        // Thực hiện nhập sản phẩm
        ImportProductService importProductService = new ImportProductService();
        try {
            boolean success = importProductService.importProducts(
                    1, // employeeId
                    1, // supplierId
                    1, // warehouseId
                    new Date(), // importDate
                    importDetails, // danh sách chi tiết nhập
                    1 // statusId
            );

            if (success) {
                System.out.println("Nhập sản phẩm thành công!");
            } else {
                System.out.println("Nhập sản phẩm thất bại.");
            }
        } catch (Exception e) {
            System.out.println("Đã xảy ra lỗi: " + e.getMessage());
        }
    }

}
