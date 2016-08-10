<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- css -->
<title>Invoice Match</title>
<meta name=viewport content=width=device-width initial-scale=1>
<style type="text/css">
footer {
	padding: 5px;
	background-color: #DCDCDC;
}
</style>
<!-- Custom CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/dataTables.bootstrap.min.css">
<link href="css/responsive.bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap.css" rel="stylesheet">
<!-- Custom Fonts -->
<link rel="stylesheet" href="css/invoiceStyle.css">
<link rel="stylesheet" href="css/invoiceInputStyle.css">
<!-- jQuery -->
<script type="text/javascript" src="js/jquery-1.12.3.js"></script>
<script src="js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="js/dataTables.bootstrap.min.js"></script>
<script type="text/javascript" src="js/dataTables.responsive.min.js"></script>
<script type="text/javascript" src="js/responsive.bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<!-- -->
</head>
<body style="background-color: #fff">
	<header style="display: inline-block">
	<div class="panel col-sm-12">
		<div class="panel-heading">
			<img src="images/logo-heb.png" class="image-header">
		</div>

	</div>
	</header>


	<div style="margin-top: -10px">
		<nav class="navbar navbar-inverse" style="color:#fff">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#menu">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a href="/InvoiceMatch_InternShip2016" class="navbar-brand glyphicon glyphicon-home"></a>
		</div>

		<div class="navbar-collapse collapse" id="menu">
			<ul class="nav navbar-nav">
				<li><a href="/InvoiceMatch_InternShip2016/report">Report</a></li>
				<li><a href="http://www.magrabbit.com/news">News</a></li>
				<li><a href="http://www.magrabbit.com/about-us">About Us</a></li>
				<li><a href="http://www.magrabbit.com/contact-us">Contact</a></li>
				<li id="importData"><a href=""><b>Importing</b></a></li>
				<li id="matchData"><a href=""><b>Matching</b></a></li>
			</ul>
		</div>
		</nav>
	</div>
	<!-- body -->
	<div class="container-fluid container-override">
		<div>
			<ul class="breadcrumb" style="height: 40px;">
				<li><a href="/InvoiceMatch_InternShip2016"
					class="glyphicon glyphicon-home"></a></li>
			</ul>
		</div>
		<!-- body -->
		<div class="panel panel-primary">

			<div class="panel-heading" data-toggle="collapse"
				data-target="#search">
				<span class="accordion-toggle-bdm"> <i
					id="fa-angle-double-down-style"
					class="fa fa-angle-double-down glyphicon" style="width: 15px;"></i>
					SEARCH INVOICE
				</span>
			</div>

			<div id="search" class="row collapse in">

				<div class="panel-body">
					<div class="form-horizontal container-fluid container-override">
						<div class="form-group">
							<label for="invoice" class="col-sm-1 control-label">Invoice</label>
							<div class="col-sm-5 ">
								<input type="text" class="form-control" placeholder="Invoice"
									id="invoice" />
							</div>
							<label for="order" class="col-sm-1 control-label">Order</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" placeholder="Order" id="order">
							</div>
						</div>
						<div class="form-group">
							<label for="tracking" class="col-sm-1 control-label">Tracking</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" placeholder="Tracking" 
								id="tracking" />
							</div>
				
								<label for="vendor" class="col-sm-1 control-label">Vendor</label>
								<div class="col-sm-5">
									<select class="form-control" id="vendor">
										<option>Vendor</option>
								
									</select>
								</div>
							
						</div>
						<div style="float: right; margin-top: 10px">
							<button type="submit" value="submit" class="btn btn-info" id="Searching">
								<span class="glyphicon glyphicon-search"></span> Search
							</button>
						</div>
					</div>

				</div>
			</div>
		</div>
	
		<section id="datatable" style="padding-top: 50px;padding-bottom: 50px;">
		<div>
			<div class="row" style="display: inline">
				<!-- insert datatable -->
				<table id="example" class="table table-striped table-bordered dt-responsive nowrap" cellspacing="0" width="100%">
					<thead>
						<tr>
							<th>Vendor</th>
							<th>Invoice</th>
							<th>Invoice Type</th>
							<th>Invoice Date</th>
							<th>Invoice AMT</th>
						</tr>
					</thead>
				</table>
			</div>
		</div>
		</section>
	</div>
		<footer>
			<div style="height: 4.5em;background-color: #d5dade;color: #fff">
				<div class="footer footer-main">
					<p class="text-center">&copy; 2016 MRV Internship Team </p>
				</div>
			</div>
		</footer>
</body>
<!--  -->
<script>
	$(document).ready(function() {
		$('#example').DataTable({
			"bFilter" : true,
			'ajax' : {
				method : "POST",
				url : "/InvoiceMatch_InternShip2016/searchInvoice",
				data : function(data) {
					data.invoiceID = $("#invoice").val();
					data.orderID = $("#order").val();
					data.trackingID = $("#tracking").val();
					data.vendorID = $("#vendor option:selected").text();
				}
			},
			'serverSide' : false,
			columns : [ {
				data : "vendorID"
			}, {
				data : "invoiceID"
			}, {
				data : "invoiceType"
			}, {
				data : "invoiceStatus"
			}, {
				data : "invoiceAmt"
			} ]
		});
	});
	$('#Searching').click(function() {
		$('#example').dataTable().api().ajax.reload(null);
	});
	//ok
	$.ajax({
		type : 'POST',
		//async: false,
		url : "/InvoiceMatch_InternShip2016/listVendor"
	}).done(
			function(data) {
				var dataParse = JSON.parse(data);
				console.log(dataParse);
				$.each(dataParse.data, function(key, value) {
					console.log(value);
					$('#vendor').append(
							$('<option>').text(value.vendorId).attr('value',
									value.vendorId));
				})
			});
</script>
<script>
	$(document).ready(function() {
		$("#importData").click(function() {
			$.ajax({
				method : "POST",
				url : "/InvoiceMatch_InternShip2016/importData",
			}).done(function(msg) {
				alert("Importing data is Successfully");
			});

		});

	});
</script>
<script>
	$(document).ready(function() {
		$("#matchData").click(function() {
			$.ajax({
				method : "POST",
				url : "/InvoiceMatch_InternShip2016/matchData",
			}).done(function(msg) {
				alert("Matching data is Successfully");
			});

		});

	});
</script>
</html>