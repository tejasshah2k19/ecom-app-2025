<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Address</title>

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">

    <!-- Bootstrap CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom Modern CSS (Matching New Area Page) -->
    <style>
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
        }

        body {
            font-family: 'Poppins', sans-serif;
            background: linear-gradient(135deg, #e0eafc, #cfdef3);
            height: 100vh;
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
            max-width: 600px;
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

    <!-- Optional JS Validation for Zip Code -->
    <script>
        function validateForm() {
            let zip = document.getElementById("zipCode").value;
            if (zip.length !== 6) {
                alert("Zip code must be exactly 6 digits.");
                return false;
            }
            return true;
        }
    </script>
</head>

<body>

    <div class="form-container">
        <h2>Add UserAddress</h2>

        <form action="saveuseraddress" method="post" onsubmit="return validateForm();">

            <!-- Title -->
            <label class="form-label" for="title">Title</label>
            <input type="text" name="title" id="title" class="form-control" placeholder="Home, Office, etc." required>

            <!-- Unit Name -->
            <label class="form-label" for="unitName">Unit Name</label>
            <input type="text" name="unitName" id="unitName" class="form-control" placeholder="Apartment/Unit No." required>

            <!-- Street -->
            <label class="form-label" for="street">Street</label>
            <input type="text" name="street" id="street" class="form-control" placeholder="Street Name" required>

            <!-- Landmark -->
            <label class="form-label" for="landMark">Landmark</label>
            <input type="text" name="landMark" id="landMark" class="form-control" placeholder="Near..." required>

            <!-- Address Detail -->
            <label class="form-label" for="addressDetail">Address Detail</label>
            <textarea name="addressDetail" id="addressDetail" rows="3" class="form-control" placeholder="Additional info (Optional)"></textarea>

            <!-- Zip Code -->
            <label class="form-label" for="zipCode">Zip Code</label>
            <input type="number" name="zipCode" id="zipCode" class="form-control" placeholder="6-digit Zip Code" required>

            <!-- State Selection -->
            <label class="form-label" for="stateId">State</label>
            <select name="stateId" id="stateId" class="form-select" required>
                <option value="">Select State</option>
                <c:forEach items="${allState}" var="s">
                    <option value="${s.stateId}">${s.stateName}</option>
                </c:forEach>
            </select>

            <!-- City Selection -->
            <label class="form-label" for="cityId">City</label>
            <select name="cityId" id="cityId" class="form-select" required>
                <option value="">Select City</option>
                <c:forEach items="${allCity}" var="c">
                    <option value="${c.cityId}">${c.cityName}</option>
                </c:forEach>
            </select>

            <!-- Submit Button -->
            <button type="submit" class="btn-submit">Save Address</button>
        </form>

        <!-- Back Link -->
        <div class="back-link">
            <a href="login">← Back to Login</a>
        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
