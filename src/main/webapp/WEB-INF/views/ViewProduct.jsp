<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Product</title>
    <jsp:include page="AdminCss.jsp"></jsp:include>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet"/>

    <!-- Custom CSS -->
    <style>
        body {
            background-color: #f8f9fa;
        }
        .container {
            max-width: 1100px;
        }
        .card {
            border-radius: 10px;
            background: #fff;
        }
        table {
            width: 100%;
        }
        th {
            background: #343a40;
            color: white;
            text-align: center;
        }
        td {
            background: #f1f1f1;
            text-align: center;
        }
        .btn-back {
            margin-top: 15px;
        }
    </style>
</head>
<body style="background: #C3CFDD">

<div class="container mt-5">
    <div class="card shadow-lg p-4">
        <h2 class="text-center mb-4">View Product</h2>

        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Product Name</th>
                    <th>Base Price</th>
                    <th>Offer Percentage</th>
                    <th>Offer Price</th>
                    <th>Product Detail</th>
                    <th>Product ImageURL1</th>
					<th>Product ImageURL2</th>
					<th>Product ImageURL3</th>
                    <th>Quantity</th>
                    <th>Category Name</th>
                    <th>SubCategory Name</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${product}" var="m">
                    <tr>
                        <td>${m[10]}</td>
                        <td>${m[1]}</td>
                        <td>${m[4]}</td>
                        <td>${m[5]}</td>
                        <td>${m[6]}</td>
                        <td><img src="${m[7]}" height="70px" width="80px"></td>
                        <td><img src="${m[8]}" height="70px" width="80px"></td>
                        <td><img src="${m[9]}" height="70px" width="80px"></td>
                        <td>${m[11]}</td>
                        <td>${m[13]}</td>
                        <td>${m[14]}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div class="text-center">
            <a href="listproduct" class="btn btn-primary btn-back">
                <i class="bi bi-arrow-left"></i> Back
            </a>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
