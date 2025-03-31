<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Product</title>

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">

    <!-- Bootstrap CSS CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom Modern CSS (Same as Area Form) -->
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Poppins', sans-serif;
            background: linear-gradient(135deg, #e0eafc, #cfdef3);
            height: auto;
            min-height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            padding: 20px;
        }

        .form-container {
            background: white;
            padding: 30px 40px;
            border-radius: 20px;
            box-shadow: 0 10px 25px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 700px;
        }

        h2 {
            text-align: center;
            margin-bottom: 25px;
            font-weight: 600;
            color: #333;
        }

        .form-label {
            font-weight: 500;
            margin-bottom: 8px;
            display: block;
            color: #444;
        }

        .form-control, .form-select {
            width: 100%;
            padding: 10px 15px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 12px;
            transition: border-color 0.3s ease;
        }

        .form-control:focus, .form-select:focus {
            border-color: #007bff;
            box-shadow: 0 0 0 0.2rem rgba(0, 123, 255, 0.25);
        }

        .btn-submit {
            width: 100%;
            padding: 12px;
            background: linear-gradient(135deg, #667eea, #764ba2);
            color: white;
            font-weight: 600;
            border: none;
            border-radius: 50px;
            transition: background 0.3s ease;
        }

        .btn-submit:hover {
            background: linear-gradient(135deg, #5a67d8, #6b46c1);
        }

        .back-link {
            margin-top: 20px;
            text-align: center;
        }

        .back-link a {
            color: #667eea;
            text-decoration: none;
            font-weight: 500;
        }

        .back-link a:hover {
            text-decoration: underline;
        }
    </style>
</head>

<body>

    <div class="form-container">
        <h2>Add Product</h2>

        <form action="saveproduct" method="post" enctype="multipart/form-data">

            <!-- Product Fields -->
            <label class="form-label" for="productName">Product Name</label>
            <input type="text" name="productName" id="productName" class="form-control" placeholder="Enter Product Name" required>

            <label class="form-label" for="basePrice">Base Price</label>
            <input type="text" name="basePrice" id="basePrice" class="form-control" placeholder="Enter Base Price" required>

            <label class="form-label" for="offerPrice">Offer Price</label>
            <input type="text" name="offerPrice" id="offerPrice" class="form-control" placeholder="Enter Offer Price">

            <label class="form-label" for="offerPercentage">Offer Percentage</label>
            <input type="text" name="offerPercentage" id="offerPercentage" class="form-control" placeholder="Enter Offer Percentage">

            <label class="form-label" for="productDetail">Product Detail</label>
            <input type="text" name="productDetail" id="productDetail" class="form-control" placeholder="Enter Product Details">

            <label class="form-label" for="productImageURL1">Product Image URL 1</label>
            <input type="file" name="productImage1" id="productImageURL1" class="form-control" placeholder="Enter Image URL 1">

            <label class="form-label" for="productImageURL2">Product Image URL 2</label>
            <input type="file" name="productImage2" id="productImageURL2" class="form-control" placeholder="Enter Image URL 2">

            <label class="form-label" for="productImageURL3">Product Image URL 3</label>
            <input type="file" name="productImage3" id="productImageURL3" class="form-control" placeholder="Enter Image URL 3">
             
            <label class="form-label" for="quantity">Quantity</label>
            <input type="number" name="quantity" id="quantity" class="form-control" placeholder="Enter Quantity" required>

            <!-- Category Selection -->
            <label class="form-label" for="categoryId">Select Category</label>
            <select name="categoryId" id="categoryId" class="form-select" required>
                <option value="">-- Select Category --</option>
                <c:forEach items="${allCategory}" var="s">
                    <option value="${s.categoryId}">${s.categoryName}</option>
                </c:forEach>
            </select>

            <!-- SubCategory Selection -->
            <label class="form-label" for="subCategoryId">Select Sub Category</label>
            <select name="subCategoryId" id="subCategoryId" class="form-select" required>
                <option value="">-- Select SubCategory --</option>
                <c:forEach items="${allSubCategory}" var="s">
                    <option value="${s.subCategoryId}">${s.subCategoryName}</option>
                </c:forEach>
            </select>

            <!-- Submit Button -->
            <button type="submit" class="btn-submit">Save Product</button>

        </form>

        <!-- Back to Login Link -->
        <div class="back-link">
            <a href="login">← Back to Login</a>
        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
