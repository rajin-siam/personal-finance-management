<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.siam.dao.CategoryDAO"%>
<%@ page import="com.siam.dao.CategoryDAOImpl"%>
<%@ page import="com.siam.model.Category"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
// Initialize DAO and retrieve categories
CategoryDAO categoryDAO = new CategoryDAOImpl();
List<Category> categories = categoryDAO.getCategories();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Transaction</title>
<link rel="stylesheet" type="text/css" href="css/addTransaction.css">
</head>
<body>
	<div class="transaction-container">
		<div class="header">
			<h2>Add Transaction</h2>
		</div>

		<div class="form-container">
			<form action="transaction" method="post">

				<div class="form-group">
					<label for="amount">Money Amount:</label> <input type="text"
						id="amount" name="amount" required>
				</div>

				<div class="form-group">
					<label for="category">Category:</label> <select id="category"
						name="category" required style="margin-bottom: 10px;">
						<%
						for (Category category : categories) {
						%>
						<option value="<%=category.getCategoryName()%>">
							<%=category.getCategoryName()%> (<%=category.getTransactionType()%>)
						</option>
						<%
						}
						%>
					</select> <a href="addCategory.jsp?referer=transaction.jsp"  style="text-decoration: none;
	padding: 3px;
	background-color: #2d8ef7;
	color: #0e0d0d;
	font-size: 14px;
	border-radius: 5px;
	margin-top: 20px;
">Add New
						Category</a>
				</div>

				<div class="form-group">
					<label for="date">Date:</label> <input type="date" id="date"
						name="date"
						value="<fmt:formatDate value='${now}' pattern='yyyy-MM-dd' />"
						required>
				</div>

				<div class="form-group">
					<label for="quantity">Quantity:</label> <input type="text"
						id="quantity" name="quantity" required>
				</div>

				<div class="form-group">
					<label for="description">Description:</label>
					<textarea id="description" name="description" rows="4" required></textarea>
				</div>

				<div class="form-group">
					<input type="submit" value="Submit">
				</div>
			</form>
		</div>
	</div>
</body>
</html>
