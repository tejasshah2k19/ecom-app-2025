<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<title>List UserAddress</title>

<jsp:include page="AdminCss.jsp"></jsp:include>

<link href="https://cdn.datatables.net/2.2.2/css/dataTables.bootstrap5.min.css" rel="stylesheet"/>

<!-- Custom Styles -->
<style>
    td:last-child {
        white-space: nowrap; /* Prevent text wrapping in action column */
    }
</style>

</head>
<body style="background: #DBE4EE">

<jsp:include page="AdminHeader.jsp"></jsp:include>
<jsp:include page="AdminSidebar.jsp"></jsp:include>

<main id="main" class="main">
    <div class="pagetitle">
        <h1>List UserAddress</h1>
        <nav>
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="admindashboard">Home</a></li>
                <li class="breadcrumb-item active">List UserAddress</li>
            </ol>
        </nav>
    </div>

    <section class="section dashboard">
        <div class="row" style="min-height: 500px;">
            <div class="col-lg-12">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">User Address<span>/all</span></h5>

                        <table class="table datatable datatable-table table-hover" id="userAddress">
                            <thead>
                                <tr>
                                    <th>Address Detail</th>
                                    <th>Title</th>
                                    <th>Unit Name</th>
                                    <th>Street</th>
                                    <th>Landmark</th>
                                    <th>Zip Code</th>
                                    <th>City Name</th>
                                    <th>State Name</th>
                                    <th>First Name</th>
                                    <th>Last Name</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${useraddressList}" var="m">
                                    <tr>
                                        <td>${m[1]}</td>
                                        <td>${m[6]}</td>
                                        <td>${m[7]}</td>
                                        <td>${m[5]}</td>
                                        <td>${m[3]}</td>
                                        <td>${m[9]}</td>
                                        <td>${m[10]}</td>
                                        <td>${m[11]}</td>
                                        <td>${m[12]}</td>
                                        <td>${m[13]}</td>
                                        <td>
                                            <div class="d-flex gap-2">
                                                <a href="viewuseraddress?userAddressId=${m[0]}" class="btn btn-sm btn-primary">View</a>
                                                <a href="deleteuseraddress?userAddressId=${m[0]}" class="btn btn-sm btn-danger">Delete</a>
                                                <a href="edituseraddress?userAddressId=${m[0]}" class="btn btn-sm btn-warning">Edit</a>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
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
        let table = new DataTable('#userAddress');
    });
</script>

</body>
</html>