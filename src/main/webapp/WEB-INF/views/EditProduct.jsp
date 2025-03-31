<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Product</title>
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
        <h2 class="text-center mb-4">Edit Product</h2>

        <form action="updateproduct" method="post" enctype="multipart/form-data">
            <!-- Product Name -->
            <div class="mb-3">
                <label class="form-label" for="productName">Product Name</label>
                <input type="text" name="productName" id="productName" class="form-control" value="${product.productName}" required>
            </div>

            <!-- Base Price -->
            <div class="mb-3">
                <label class="form-label" for="basePrice">Base Price</label>
                <input type="text" name="basePrice" id="basePrice" class="form-control" value="${product.basePrice}" required>
            </div>

            <!-- Offer Price -->
            <div class="mb-3">
                <label class="form-label" for="offerPrice">Offer Price</label>
                <input type="text" name="offerPrice" id="offerPrice" class="form-control" value="${product.offerPrice}" required>
            </div>

            <!-- Offer Percentage -->
            <div class="mb-3">
                <label class="form-label" for="offerPercentage">Offer Percentage</label>
                <input type="text" name="offerPercentage" id="offerPercentage" class="form-control" value="${product.offerPercentage}" required>
            </div>

            <!-- Product Detail -->
            <div class="mb-3">
                <label class="form-label" for="productDetail">Product Detail</label>
                <input type="text" name="productDetail" id="productDetail" class="form-control" value="${product.productDetail}" required>
            </div>

            <!-- Product Images -->
            <div class="mb-3">
                <label class="form-label" for="productImageURL1">Product Image URL1</label>
                <img alt="" src="${product.productImageURL1}" height="50px" width="50px">
                <input type="file" name="productImage1" id="productImageURL1" class="form-control" value="${product.productImageURL1}" required>
            </div>

            <div class="mb-3">
                <label class="form-label" for="productImageURL2">Product Image URL2</label>
                <img alt="" src="${product.productImageURL2}" height="50px" width="50px">
                <input type="file" name="productImage2" id="productImageURL2" class="form-control" value="${product.productImageURL2}">
            </div>

            <div class="mb-3">
                <label class="form-label" for="productImageURL3">Product Image URL3</label>
                <img alt="" src="${product.productImageURL3}" height="50px" width="50px">
                <input type="file" name="productImage3" id="productImageURL3" class="form-control" value="${product.productImageURL3}">
            </div>
             
            <!-- Quantity -->
            <div class="mb-3">
                <label class="form-label" for="quantity">Quantity</label>
                <input type="number" name="quantity" id="quantity" class="form-control" value="${product.quantity}" required>
            </div>

            <!-- Hidden Product ID -->
            <input type="hidden" name="productId" value="${product.productId}"/>

            <!-- Submit Button Centered -->
            <div class="d-flex justify-content-center">
                <button type="submit" class="btn btn-submit">Update Product</button>
            </div>
        </form>

        <!-- Back to Login Link -->
        <div class="back-link">
            <a href="listproduct">← Back</a>
        </div>
       
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
