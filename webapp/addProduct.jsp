<%@page import="com.jwc.data.ProductRepositoryImpl"%>
<%@page import="com.jwc.domain.model.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>상품 등록</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body>
	<jsp:include page="menu.jsp"></jsp:include>

	<div class="p-5 bg-primary text-white">
		<div class="container">
			<h1 class="display-3">상품 등록</h1>
		</div>
	</div>

	<div class="container">
		<form name="newProduct" action="processAddProduct.jsp" method="post"
			class="form-horizontal">
			<div class="form-group row m-3">
				<label class="col-sm-2">상품 코드</label>
				<div class="col-sm-3">
					<input type="text" name="productId" class="form-control">
				</div>
			</div>
			<div class="form-group row m-3">
				<label class="col-sm-2">상품명</label>
				<div class="col-sm-3">
					<input type="text" name="name" class="form-control">
				</div>
			</div>
			<div class="form-group row m-3">
				<label class="col-sm-2">가격</label>
				<div class="col-sm-3">
					<input type="text" name="unitPrice" class="form-control">
				</div>
			</div>
			<div class="form-group row m-3">
				<label class="col-sm-2">상세 정보</label>
				<div class="col-sm-3">
					<textarea type="text" name="description" class="form-control"></textarea>
				</div>
			</div>
			<div class="form-group row m-3">
				<label class="col-sm-2">제조사</label>
				<div class="col-sm-3">
					<input type="text" name="manufacturer" class="form-control">
				</div>
			</div>
			<div class="form-group row m-3">
				<label class="col-sm-2">분류</label>
				<div class="col-sm-3">
					<input type="text" name="category" class="form-control">
				</div>
			</div>
			<div class="form-group row m-3">
				<label class="col-sm-2">재고 수</label>
				<div class="col-sm-3">
					<input type="text" name="unitsInStock" class="form-control">
				</div>
			</div>
			<div class="form-group row m-3">
				<label class="col-sm-2">상태</label>
				<div class="col-sm-3">
					<input type="radio" name="condition" value="New" checked>신규
					제품 <input type="radio" name="condition" value="Old">중고 제품 <input
						type="radio" name="condition" value="Refurbished">재생 제품
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="submit" class="btn btn-primary" value="등록">
				</div>
			</div>
		</form>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>