<?php include('updatedata.php'); ?>
<?php
session_start();

if(isset($_SESSION['uid']))
{
	echo "";
	
}
else
{
	header('location:../index.php');
}

include('../dbcon.php');
$ct_id = $_GET['ctid'];
$qry = "SELECT * FROM `category` WHERE `category_id` = '$ct_id'";
$run = mysqli_query($con,$qry);

$data = mysqli_fetch_assoc($run);

?>


<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>SB Admin - Order Panel - Order Booker Management Systems</title>
  <!-- Bootstrap core CSS-->
  <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="../vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Custom styles for this template-->
  <link href="../css/sb-admin.css" rel="stylesheet">
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<?php include('admincategory.php');?>
	 <div class="content-wrapper">
	
  <div class="container">
    <div class="card card-register mx-auto mt-5">
      <div class="card-header">Register an Account</div>
      <div class="card-body">
        <form action="updatecategory.php" method="post">
          <div class="form-group">
            <div class="form-row">
              
				<div class="col-md-6">
                <label for="exampleInputName">Category Name</label>
                <input class="form-control" id="exampleInputName" type="text" name="category_name" value=<?php echo $data['category_name']; ?> aria-describedby="nameHelp" placeholder="Enter Distributor name" >
              </div>
				
			  <div class="col-md-6">
                <label for="exampleInputName">Type</label>
                <input class="form-control" id="exampleInputName" type="text" name="category_type" value=<?php echo $data['category_type']; ?> aria-describedby="nameHelp" placeholder="Enter Distributor name" >
				  
				  <input type="hidden" name="category_id" value="<?php echo $data['category_id']; ?>" />
              </div>
              
            </div>
          </div>
			
          <input type="submit" name="register" value="Update" class="btn btn-primary btn-block" />
			
			<script src="../vendor/jquery/jquery.min.js"></script>
    <script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- Core plugin JavaScript-->
    <script src="../vendor/jquery-easing/jquery.easing.min.js"></script>
    <!-- Page level plugin JavaScript-->
    <script src="../vendor/chart.js/Chart.min.js"></script>
    <script src="../vendor/datatables/jquery.dataTables.js"></script>
    <script src="../vendor/datatables/dataTables.bootstrap4.js"></script>
    <!-- Custom scripts for all pages-->
    <script src="../js/sb-admin.min.js"></script>
    <!-- Custom scripts for this page-->
    <script src="../js/sb-admin-datatables.min.js"></script>
    <script src="../js/sb-admin-charts.min.js"></script>
        </form>
        <!-- <div class="text-center">
          <a class="d-block small mt-3" href="login.html">Login Page</a>
          <a class="d-block small" href="forgot-password.html">Forgot Password?</a>
        </div> -->
      </div>
    </div>
  </div>
	</div>
  <!-- Bootstrap core JavaScript-->
  <script src="../vendor/jquery/jquery.min.js"></script>
  <script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <!-- Core plugin JavaScript-->
  <script src="../vendor/jquery-easing/jquery.easing.min.js"></script>
</body>

</html>

