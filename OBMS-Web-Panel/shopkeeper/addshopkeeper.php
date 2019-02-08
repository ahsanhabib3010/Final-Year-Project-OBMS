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
?>
<?php include('ShopkeeperRegister.php'); ?>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="../vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Page level plugin CSS-->
  <link href="../vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
  <!-- Custom styles for this template-->
  <link href="../css/sb-admin.css" rel="stylesheet">
	
	<link href="../css/stylesheet.css" rel="stylesheet">
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<?php include('adminshop.php');?>
	 <div class="content-wrapper">
    
  <div class="container">
    <div class="card card-register mx-auto mt-5">
      <div class="card-header">Register an Account</div>
      <div class="card-body">
        <form action="addshopkeeper.php" method="post">
        <?php include('error.php'); ?>
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <label for="exampleInputName">Shopkeeper name</label>
                <input class="form-control" id="exampleInputName" type="text" name="s_name" aria-describedby="nameHelp" placeholder="Enter shopkeeper name" required>
              </div>
              <div class="col-md-6">
                <label for="exampleInputLastName">Contact No</label>
                <input class="form-control" id="exampleInputLastName" type="text" name="s_contact" aria-describedby="nameHelp" placeholder="e.g (03451234567)" required>
              </div>
            </div>
          </div>
          <div class="form-group">
            <label for="exampleInputEmail1">Email Address</label>
            <input class="form-control" id="exampleInputEmail1" type="email" name="s_email" aria-describedby="emailHelp" placeholder="Enter email" required>
          </div>

          <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <label for="exampleInputPassword1">Shop Name</label>
                <input class="form-control" id="exampleInputPassword1" type="text" name="s_shopname" placeholder="Enter Shop name" required>
              </div>
				
			<div class="col-md-6">
                <label for="exampleInputPassword1">Shopkeeper Address</label>
                <input class="form-control" id="exampleInputPassword1" type="text" name="s_addresss" placeholder="Enter Address" required>
              </div>
              </div>
              <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <label for="exampleInputPassword1">Region</label>
                <input class="form-control" id="exampleInputPassword1" type="text" name="s_region" placeholder="Enter Shop Region" required>
              </div>
				
			<div class="col-md-6">
                <label for="exampleInputPassword1">Password</label>
                <input class="form-control" id="exampleInputPassword1" type="password" name="s_password" placeholder="Enter Password" required>
              </div>
          </div>
          <br><br>
          <input type="submit" name="register" value="Register" class="btn btn-primary btn-block" />
			
			
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


