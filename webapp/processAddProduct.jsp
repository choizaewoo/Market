<%@page import="com.jwc.domain.repository.ProductRepository"%>
<%@page import="com.jwc.domain.model.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 한글 처리
request.setCharacterEncoding("UTF-8");
// POST로 넘어온 것
String productId = request.getParameter("productId");
String name = request.getParameter("name");
int unitPrice = Integer.valueOf(request.getParameter("unitPrice"));
String description = request.getParameter("description");
String manufacturer = request.getParameter("menufacturer");
String category = request.getParameter("category");
int unitsInStock = Integer.valueOf(request.getParameter("unitsInStock"));
String condition = request.getParameter("condition");

ProductRepository repository = ProductRepository.getInstance();

Product product = new Product(productId, name, unitPrice);
product.setDescription(description);
product.setManufacturer(manufacturer);
product.setCategory(category);
product.setUnitsInStock(unitsInStock);
product.setCondition(condition);

repository.addProduct(product);

response.sendRedirect("products.jsp");
%>















