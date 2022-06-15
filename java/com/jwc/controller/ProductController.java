package com.jwc.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jwc.domain.model.Product;
import com.jwc.domain.repository.ProductRepository;

@WebServlet(name = "ProductController", urlPatterns = {"/products.do", "/processAddProduct.do"})
public class ProductController extends HttpServlet {
    private static final long serialVersionUID = -8981601493800853908L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // 요청 주소 (/products.do)
        String command = req.getRequestURI().substring(req.getContextPath().length());
        
        ProductRepository repository = ProductRepository.getInstance();
        
        if (command.equals("/products.do")) {
            // 싱글턴 패턴
            List<Product> products = repository.getAllProducts();
            req.getSession().setAttribute("products", products);
            
        } else if (command.equals("/processAddProduct.do")) {
            // 한글 처리
            req.setCharacterEncoding("UTF-8");
            // POST로 넘어온 것
            String productId = req.getParameter("productId");
            String name = req.getParameter("name");
            int unitPrice = Integer.valueOf(req.getParameter("unitPrice"));
            String description = req.getParameter("description");
            String manufacturer = req.getParameter("manufacturer");
            String category = req.getParameter("category");
            int unitsInStock = Integer.valueOf(req.getParameter("unitsInStock"));
            String condition = req.getParameter("condition");

            Product product = new Product(productId, name, unitPrice);
            product.setDescription(description);
            product.setManufacturer(manufacturer);
            product.setCategory(category);
            product.setUnitsInStock(unitsInStock);
            product.setCondition(condition);

            repository.addProduct(product);
        }

        System.out.println("통과!!!!!!!!!!!!!!!!!");
        
        // products.jsp 로 이동
        req.getRequestDispatcher("products.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPost(req, resp);
    }
}