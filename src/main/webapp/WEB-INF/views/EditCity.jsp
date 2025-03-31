<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit City</title>
    <jsp:include page="AdminCss.jsp"></jsp:include>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet"/>

    <!-- Custom CSS (Same as Edit Area) -->
    <style>
        body {
            background-color: #f8f9fa;
        }
        .container {
            max-width: 600px;
        }
        .card {
            border-radius: 10px;
            background: #fff;
            padding: 20px;
        }
        .form-label {
            font-weight: bold;
            font-size: 21px;
        }
        .btn-submit {
            width: 30%;
            padding: 9px;
            background: #007bff;
            color: white;
            font-weight: bold;
            border: none;
            border-radius: 5px;
            transition: background 0.3s ease;
        }
        .btn-submit:hover {
            background: #0056b3;
             color:Lavender;
        }
        .back-link {
            margin-top: 15px;
            text-align: center;
        }

        .back-link a {
            color: #blue;
            text-decoration: none;
            font-weight: 630;
            font-size:19px;
        }

        .back-link a:hover {
            text-decoration: underline;
            color: #8B008B;
        }
    </style>
</head>

<body style="background: #C3CFDD">

<div class="container mt-5">
    <div class="card shadow-lg">
        <h2 class="text-center mb-4">Edit City</h2>

        <form action="updatecity" method="post">
            <!-- City Name -->
            <div class="mb-3">
                <label class="form-label" for="cityName">City Name</label>
                <input type="text" name="cityName" id="cityName" class="form-control" value="${city.cityName}" required>
            </div>

            <!-- Hidden City ID -->
            <input type="hidden" name="cityId" value="${city.cityId}"/>

            <!-- State Dropdown (Currently Commented Out) -->
            <!--  
            <div class="mb-3">
                <label class="form-label" for="stateId">State</label>
                <select name="stateId" id="stateId" class="form-control">
                    <option>Select State</option>
                    <c:forEach items="${allState}" var="s">
                        <option value="${s.stateId}">${s.stateName}</option>
                    </c:forEach>
                </select>
            </div>
            -->

            <!-- Submit Button Centered -->
            <div class="d-flex justify-content-center">
                <button type="submit" class="btn btn-submit">Update City</button>
            </div>
        </form>

        <!-- Back to Login Link -->
        <div class="back-link">
            <a href="ListCity">← Back</a>
        </div>

    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
