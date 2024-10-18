<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.siam.dao.TransactionDAO"%>
<%@ page import="com.siam.dao.TransactionDAOImpl"%>
<%@ page import="com.siam.dao.CategoryDAO"%>
<%@ page import="com.siam.dao.CategoryDAOImpl"%>
<%@ page import="com.siam.model.Transaction"%>
<%@ page import="com.siam.model.Category"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="jakarta.servlet.http.HttpSession"%>
<%@ page import="java.util.List"%>

<%
// Retrieve transaction ID from request parameter
int transactionId = Integer.parseInt(request.getParameter("id"));
// Initialize DAO and retrieve transaction details
TransactionDAO transactionDAO = new TransactionDAOImpl();
Transaction transaction = transactionDAO.getTransactionById(transactionId);

// Check if transaction exists
if (transaction == null) {
	response.sendRedirect("history.jsp"); // Redirect if transaction not found
}

// Initialize DAO and retrieve categories
CategoryDAO categoryDAO = new CategoryDAOImpl();
List<Category> categories = categoryDAO.getCategories();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Transaction</title>
<link rel="stylesheet" type="text/css" href="css/editTransaction.css">
</head>
<body>
	<div class="edit-transaction-container">
		<div class="header">
			<h2>Edit Transaction</h2>
		</div>

		<div class="form-container">
			<form action="updateTransaction" method="post">
				<input type="hidden" name="transactionId"
					value="<%=transaction.getTransactionId()%>">

				<div class="form-group">
					<label for="amount">Amount:</label> <input type="text" id="amount"
						name="amount" value="<%=transaction.getAmount()%>" required>
				</div>

				<div class="form-group">
					<label for="date">Date:</label> <input type="date" id="date"
						name="date"
						value="<%=new SimpleDateFormat("yyyy-MM-dd").format(transaction.getDate())%>"
						required>
				</div>

				<div class="form-group">
					<label for="category">Category:</label> <select id="category"
						name="category" required>
						<%
						for (Category category : categories) {
						%>
						<option value="<%=category.getCategoryName()%>"
							<%if (category.getCategoryName().equals(transaction.getCategory())) {%>
							selected="selected" <%}%>><%=category.getCategoryName()%>
							(<%=category.getTransactionType()%>)
						</option>
						<%
						}
						%>
					</select> <a
						href="addCategory.jsp?referer=editTransaction.jsp&id=<%=transactionId%>">Add
						New Category</a>
				</div>

				<div class="form-group">
					<label for="quantity">Quantity:</label> <input type="text"
						id="quantity" name="quantity"
						value="<%=transaction.getQuantity()%>" required>
				</div>

				<div class="form-group">
					<label for="description">Description:</label>
					<textarea id="description" name="description" required><%=transaction.getDescription()%></textarea>
				</div>

				<div class="form-group">
					<input type="submit" value="Update Transaction">
				</div>
			</form>
		</div>
	</div>
</body>
</html>
