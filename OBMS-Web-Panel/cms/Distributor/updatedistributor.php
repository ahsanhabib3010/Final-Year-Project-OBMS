<?php include('updatedata.php'); ?>
<?php
session_start();

if(isset($_SESSION['cid']))
{
	echo "";
	
}
else
{
	header('location:../index.php');
}

include('../dbcon.php');
$d_id = $_GET['d_id'];
$qry = "SELECT * FROM `distributor` WHERE `distributor_id` = '$d_id'";
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
  <title>SB Admin - Start Bootstrap Template</title>
  <!-- Bootstrap core CSS-->
  <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="../vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Custom styles for this template-->
  <link href="../css/sb-admin.css" rel="stylesheet">
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<?php include('admindistributor.php');?>
	 <div class="content-wrapper">
	
  <div class="container">
    <div class="card card-register mx-auto mt-5">
      <div class="card-header">Register an Account</div>
      <div class="card-body">
        <form action="updatedistributor.php" method="post">
			
		<?php include('error.php'); ?>
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <label for="exampleInputName">Distributor name</label>
                <input class="form-control" id="exampleInputName" type="text" name="d_name" value=<?php echo $data['distributor_name']; ?> aria-describedby="nameHelp" placeholder="Enter Distributor name" >
              </div>
              <div class="col-md-6">
                <label for="exampleInputLastName">Contact No</label>
                <input class="form-control" id="exampleInputLastName" type="text" name="d_contact" value=<?php echo $data['distributor_contact']; ?> aria-describedby="nameHelp" placeholder="Enter contact number" >
              </div>
            </div>
          </div>
          <div class="form-group">
            <label for="exampleInputEmail1">Email Address</label>
            <input class="form-control" id="exampleInputEmail1" type="email" name="d_email" value="<?php echo $data['distributor_email']; ?>" aria-describedby="emailHelp" placeholder="Enter email" >
          </div>
          <div class="form-group">
            <div class="form-row">
   	
			<div class="col-md-6">
                <label for="exampleInputPassword1">Distributor Address</label>
                <input class="form-control" id="exampleInputPassword1" type="text" name="d_addresss" value="<?php echo $data['distributor_address']; ?>" placeholder="Enter Address" >
              </div>
				
			<div class="col-md-6">
                <label for="exampleInputPassword1">Distributor Region</label>
                <input class="form-control" id="exampleInputPassword1" type="text" name="d_region" value="<?php echo $data['distributor_region']; ?>" placeholder="Enter Distributor region" >
				
				 <input type="hidden" name="d_id" value="<?php echo $data['distributor_id']; ?>" />
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

