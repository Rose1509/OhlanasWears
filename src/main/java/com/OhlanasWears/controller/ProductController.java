package com.OhlanasWears.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import com.OhlanasWears.model.ClothesModel;
import com.OhlanasWears.service.ProductService;
import com.OhlanasWears.util.ValidationUtil;

@WebServlet(
    asyncSupported = true,
    urlPatterns = { "/product" }
)
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 2, // 2MB
    maxFileSize = 1024 * 1024 * 10,      // 10MB
    maxRequestSize = 1024 * 1024 * 50    // 50MB
)
public class ProductController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private ProductService service;

    public ProductController() {
        super();
        this.service = new ProductService();
    }

    /**
     * Handles HTTP GET requests.
     *
     * @param request  The HttpServletRequest object that contains the request the client has made.
     * @param response The HttpServletResponse object that contains the response the servlet sends to the client.
     * @throws ServletException If an error occurs while processing the request.
     * @throws IOException      If an input or output error occurs during the request-response cycle.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<ClothesModel> products = service.getAllClothes();
        request.setAttribute("products", products);
        request.getRequestDispatcher("/WEB-INF/pages/product.jsp").forward(request, response);
    }

    /**
     * Handles HTTP POST requests.
     *
     * @param request  The HttpServletRequest object that contains the request the client has made.
     * @param response The HttpServletResponse object that contains the response the servlet sends to the client.
     * @throws ServletException If an error occurs while processing the request.
     * @throws IOException      If an input or output error occurs during the request-response cycle.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String action = request.getParameter("action");

            if ("delete".equals(action)) {
                handleDelete(request, response);
            } else {
                handleAddProduct(request, response);
            }

        } catch (Exception e) {
            handleError(request, response, "An unexpected error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Handles product deletion.
     *
     * @param request  The HttpServletRequest object that contains the request the client has made.
     * @param response The HttpServletResponse object that contains the response the servlet sends to the client.
     * @throws ServletException If an error occurs while processing the request.
     * @throws IOException      If an input or output error occurs during the request-response cycle.
     */
    private void handleDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int deleteId = Integer.parseInt(request.getParameter("productId"));
        service.deleteClothesById(deleteId);

        List<ClothesModel> products = service.getAllClothes();
        request.setAttribute("products", products);
        request.getRequestDispatcher("/WEB-INF/pages/product.jsp").forward(request, response);
    }

    /**
     * Handles adding a new product.
     *
     * @param request  The HttpServletRequest object that contains the request the client has made.
     * @param response The HttpServletResponse object that contains the response the servlet sends to the client.
     * @throws ServletException If an error occurs while processing the request.
     * @throws IOException      If an input or output error occurs during the request-response cycle.
     */
    private void handleAddProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String validationMessage = validateProductForm(request);
        if (validationMessage != null) {
            handleError(request, response, validationMessage);
            return;
        }

        ClothesModel clothesModel = extractClothesModel(request);
        Boolean isAdded = service.addProduct(clothesModel);

        if (isAdded == null) {
            handleError(request, response, "Server issue. Try again later.");
        } else if (isAdded) {
            handleSuccess(request, response, "Product added successfully!", "/WEB-INF/pages/product.jsp");
        } else {
            handleError(request, response, "Could not add the product.");
        }
    }

    /**
     * Validates the product form input.
     *
     * @param request The HttpServletRequest object that contains the request the client has made.
     * @return A validation message or null if the form is valid.
     */
    private String validateProductForm(HttpServletRequest request) {
        StringBuilder errors = new StringBuilder();

        String clothesName = request.getParameter("clothesName");
        String color = request.getParameter("color");
        String stock = request.getParameter("stock");
        String price = request.getParameter("price");

        if (ValidationUtil.isNullOrEmpty(clothesName)) {
            errors.append("Clothes name is required.<br>");
        } else if (!ValidationUtil.isValidClothesName(clothesName)) {
            errors.append("Clothes name must start with a letter and contain only letters, numbers, spaces, or -&.<br>");
        }

        if (ValidationUtil.isNullOrEmpty(color)) {
            errors.append("Color is required.<br>");
        } else if (!ValidationUtil.isValidColor(color)) {
            errors.append("Invalid color name.<br>");
        }

        if (ValidationUtil.isNullOrEmpty(stock)) {
            errors.append("Stock quantity is required.<br>");
        } else if (!ValidationUtil.isValidStock(stock)) {
            errors.append("Invalid stock quantity.<br>");
        }

        if (ValidationUtil.isNullOrEmpty(price)) {
            errors.append("Price is required.<br>");
        } else if (!ValidationUtil.isValidPrice(price)) {
            errors.append("Invalid price.<br>");
        }

        return errors.length() == 0 ? null : errors.toString();
    }

    /**
     * Extracts a ClothesModel from the form data.
     *
     * @param request The HttpServletRequest object that contains the request the client has made.
     * @return A ClothesModel object with data from the form.
     */
    private ClothesModel extractClothesModel(HttpServletRequest request) {
        int code = 0;
        String clothesName = request.getParameter("clothesName");
        String color = request.getParameter("color");
        int stock = Integer.parseInt(request.getParameter("stock"));
        double price = Double.parseDouble(request.getParameter("price"));

        return new ClothesModel(code, clothesName, color, stock, price);
    }

    /**
     * Handles successful operations.
     *
     * @param request       The HttpServletRequest object that contains the request the client has made.
     * @param response      The HttpServletResponse object that contains the response the servlet sends to the client.
     * @param message       The success message to be shown.
     * @param redirectPage  The page to redirect to after success.
     * @throws ServletException If an error occurs while processing the request.
     * @throws IOException      If an input or output error occurs during the request-response cycle.
     */
    private void handleSuccess(HttpServletRequest request, HttpServletResponse response, String message, String redirectPage)
            throws ServletException, IOException {
        request.setAttribute("success", message);
        List<ClothesModel> products = service.getAllClothes();
        request.setAttribute("products", products);
        request.getRequestDispatcher(redirectPage).forward(request, response);
    }

    /**
     * Handles error messages.
     *
     * @param request  The HttpServletRequest object that contains the request the client has made.
     * @param response The HttpServletResponse object that contains the response the servlet sends to the client.
     * @param message  The error message to be shown.
     * @throws ServletException If an error occurs while processing the request.
     * @throws IOException      If an input or output error occurs during the request-response cycle.
     */
    private void handleError(HttpServletRequest request, HttpServletResponse response, String message)
            throws ServletException, IOException {
        request.setAttribute("error", message);
        List<ClothesModel> products = service.getAllClothes();
        request.setAttribute("products", products);
        request.getRequestDispatcher("/WEB-INF/pages/product.jsp").forward(request, response);
    }
}
