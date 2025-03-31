<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<title>List Product</title>

<jsp:include page="AdminCss.jsp"></jsp:include>

<link href="https://cdn.datatables.net/2.2.2/css/dataTables.bootstrap5.min.css" rel="stylesheet"/>

</head>
<body style="background: #DBE4EE">

<jsp:include page="AdminHeader.jsp"></jsp:include>
<jsp:include page="AdminSidebar.jsp"></jsp:include>

<main id="main" class="main">
    <div class="pagetitle">
        <h1>List Product</h1>
        <nav>
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="admindashboard">Home</a></li>
                <li class="breadcrumb-item active">List Product</li>
            </ol>
        </nav>
    </div>

    <section class="section dashboard">
        <div class="row" style="min-height: 500px;">
            <div class="col-lg-12">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Product<span>/all</span></h5>

                        <div class="table-responsive">
                            <table class="table datatable datatable-table table-hover" id="products">
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
	                                <th>Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                     <c:forEach items="${productList}" var="m">
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
                                        <td>
                                                <div class="d-flex gap-2">
                                                    <a href="viewproduct?productId=${m[0]}" class="btn btn-sm btn-primary">View</a>
                                               		<a href="deleteproduct?productId=${m[0]}" class="btn btn-sm btn-danger">Delete</a>
                                                	<a href="editproduct?productId=${m[0]}" class="btn btn-sm btn-warning">Edit</a>                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</main>

<jsp:include page="AdminFooter.jsp"></jsp:include>
<jsp:include page="AdminJs.jsp"></jsp:include>

<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="https://cdn.datatables.net/2.2.2/js/dataTables.min.js"></script>
<script src="https://cdn.datatables.net/2.2.2/js/dataTables.bootstrap5.min.js"></script>

<script type="text/javascript">
    $(document).ready(function() {
        let table = new DataTable('#products');
    });
</script>

</body>
</html>