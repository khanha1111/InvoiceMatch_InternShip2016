<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Report Invoice Match</title>

<!-- Custom CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/dataTables.bootstrap.min.css">
<link href="css/responsive.bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/home-style.css" rel="stylesheet">
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
<!--Custom CSS -->

<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<link rel="stylesheet" href="css/daterangepicker.css">
<link rel="stylesheet" href="css/style-select.css">
<link rel="stylesheet" href="css/datepicker.css">
<link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet" href="css/bootstrap-select.css">
<link rel="stylesheet" href="css/bootstrap-select.min.css">
<link rel="stylesheet" href="css/invoiceStyle.css">
<link rel="stylesheet" href="css/datepicker.min.css">
<link rel="stylesheet" href="css/datepicker3.min.css">

<!-- Js -->

<script type="text/javascript" src="js/daterangepicker.js"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="js/bootstrap-select.js"></script>
<script type="text/javascript" src="js/bootstrap-datepicker.min.js"></script>

<script src="js/bootstrap-datepicker.js"></script>

</head>
<body>
	<header style="display: inline-block">
	<div class="panel col-sm-12">
		<div class="panel-heading">
			<img src="images/logo-heb.png" class="image-header">
		</div>

	</div>
	</header>
	<div style="margin-top: -10px">
		<nav class="navbar navbar-inverse">
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
				<li id="importData"><a href="">Importing</a></li>
				<li id="matchData"><a href="">Matching</a></li>
			</ul>
		</div>
		</nav>
	</div>
	<div class="container-fluid container-override">
	<div>
		<ul class="breadcrumb">
			<li><a href="/InvoiceMatch_InternShip2016" class="glyphicon glyphicon-home"></a></li>
			<li><a href="/InvoiceMatch_InternShip2016/report">Report</a></li>
		</ul>
	</div>
	
		<div class="panel panel-primary">
				
			<div class="panel-heading" data-toggle="collapse"
				data-target="#searchReportForm">
				<span class="accordion-toggle-bdm"> <i id="fa-angle-double-down-style" class="fa fa-angle-double-down"
					style="width: 15px;"></i> Report
				</span>
			</div>

			<div id="searchReportForm" class="row collapse in container-fluid container-override">
			
				<div class="panel-body">
				
					<div class="form-horizontal">
		
						<div class="form-group">
							<label for="invStat" class="col-sm-2 control-label" style="text-align : left">Invoice Status</label>
				
							<div class="col-sm-6">
							<select class="form-control" id="invStat">
								<option value="unselected">All</option>
							
							</select>
				
							</div>
						</div>
						<div class="form-group">
							<label for="datepicker" class="col-sm-2 control-label" style="text-align : left; margin-top: 10px">Invoice Date Range</label>
							<div class="col-sm-3 margin">
								<div class="input-group input-append date" id="datepicker">
									<input type="text" class="form-control" id="dayStart"/> <span
										class="input-group-addon add-on"><span
										class="glyphicon glyphicon-calendar"></span></span>
								</div>
								
							</div>
							<div class="col-sm-3 margin">
								<div class="input-group input-append date " id="datepicker2">
									<input type="text" class="form-control" name="date" id="dayEnd" /> <span
										class="input-group-addon add-on"><span
										class="glyphicon glyphicon-calendar"></span></span>
								</div>
							</div>
						</div>
				
					</div>
				</div>	
			
		
		<div class="form-inline margin_right_btn" style="float: right">
			<button  id="btClean" type="button" class="btn btn-default cleanButton"><span class="glyphicon glyphicon-refresh"></span>&nbsp;&nbsp;Clear</button>
			<button  id="btSearch" type="button" class="btn searchButton" ><span class="glyphicon glyphicon-search"></span>&nbsp;&nbsp;Search</button>
			
		</div>
		</div>
		</div>
		<div>
		<div class="row no-right-padding searchResultMargin" id="searchResult">
                <div class="col-md-2">
                     <span class="text-bold">Search Results</span>
                 </div>
                 <div class="col-md-8">
                 </div>
                 <div class="col-md-2 no-right-padding pull-right">
                    <form class="export-excel" action="downloadFile" method="POST">
						<button class="btn_Export" id="btExport" type="submit"></button>
                    </form>
					
					
            </div>
		</div>
				</div>
		</div>
		
		
		
		<div class="col-sm-12">
			<table id="example" class="table table-striped table-bordered dt-responsive nowrap" cellspacing="0" width="100%">
				<thead>
					<tr>
						<th>Vendor ID</th>
						<th>Invoice ID</th>
						<th>Invoice Date</th>
						<th>Invoice Type</th>
						<th>Approved Date</th>
						<th>Invoice Status</th>
					</tr>
				</thead>

			</table>
		</div>
		<div class="clr"></div>
	</div>
	
		<div class="footer-panel"style="margin-top: 20px">
			<div class="footer footer-main">
				<p class="text-center">&copy; 2016 MRV Internship Team </p>
			</div>
			
		</div>


	<!-- 	======JS====== -->
	<script type="text/javascript" charset="utf-8">
		$(document)
				.ready(
						function() {

							$('#datepicker').datepicker({
								format : "yyyy-mm-dd"
							});
							$('#datepicker2').datepicker({
								format : "yyyy-mm-dd"
							});

							$('#btSearch').click(
									function() {
										$('#example').dataTable().api().ajax
												.reload(null);
									});
							$('#example')
									.dataTable(
											{
												'ajax' : {
													method : "POST",
													url : "/InvoiceMatch_InternShip2016/searchReport",
													data : function(data) {
																data.dayStart = $("#dayStart").val(),
																data.dayEnd = $("#dayEnd").val(),
																data.invStat = $("#invStat option:selected").text()
													}
												},
												
												fixedColumns : true,
												columns : [ {
													data : "vendId"
												}, {
													data : "vendInvNbr"
												}, {
													data : "invTs"
												}, {
													data : "invTypCd"
												}, {
													data : "invApprTs"
												}, {
													data : "invStatCd"
												} ],
											});
							$('#btClean').click(
									function() {
										$("#dayStart").val("");
										$("#dayEnd").val("");
										$("#invStat").val("unselected");
										$('#example').dataTable().api().ajax.reload(null);
									});
							$.ajax({
									type : 'POST',
									url : "/InvoiceMatch_InternShip2016/getListInvStat"
									})
									.done(function(data) {
												var dataParse = JSON.parse(data);
												$.each(dataParse.data,
														function(key,value) {
															$('#invStat').append($('<option>').text(value.invStatId).attr('value',value.invStatId));
												})
									});
							
							
						});
	</script>
</body>
</html>