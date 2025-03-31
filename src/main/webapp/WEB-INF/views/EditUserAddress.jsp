<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit UserAddress</title>
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
            font-size: 18px;
        }
        .btn-submit {
            width: 40%;
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
        <h2 class="text-center mb-4">Edit UserAddress</h2>

        <form action="updateuseraddress" method="post">
            <!-- Title -->
            <div class="mb-3">
                <label class="form-label" for="title">Title</label>
                <input type="text" name="title" id="title" class="form-control" value="${useraddress.title}" required>
            </div>

            <!-- Unit Name -->
            <div class="mb-3">
                <label class="form-label" for="unitName">Unit Name</label>
                <input type="text" name="unitName" id="unitName" class="form-control" value="${useraddress.unitName}" required>
            </div>

            <!-- Street -->
            <div class="mb-3">
                <label class="form-label" for="street">Street</label>
                <input type="text" name="street" id="street" class="form-control" value="${useraddress.street}" required>
            </div>

            <!-- Land Mark -->
            <div class="mb-3">
                <label class="form-label" for="landMark">Land Mark</label>
                <input type="text" name="landMark" id="landMark" class="form-control" value="${useraddress.landMark}">
            </div>

            <!-- Address Details -->
            <div class="mb-3">
                <label class="form-label" for="addressDetail">Address Details</label>
                <input type="text" name="addressDetail" id="addressDetail" class="form-control" value="${useraddress.addressDetail}">
            </div>

            <!-- Zip Code -->
            <div class="mb-3">
                <label class="form-label" for="zipCode">Zip Code</label>
                <input type="text" name="zipCode" id="zipCode" class="form-control" value="${useraddress.zipCode}" required>
            </div>

            <!-- Hidden User Address ID -->
            <input type="hidden" name="userAddressId" value="${useraddress.userAddressId}"/>

            <!-- Submit Button Centered -->
            <div class="d-flex justify-content-center">
                <button type="submit" class="btn btn-submit">Update Address</button>
            </div>
        </form>
        <!-- Back to Login Link -->
        <div class="back-link">
            <a href="listuseraddress">← Back</a>
        </div>

    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
