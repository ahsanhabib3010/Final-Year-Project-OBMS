<?php include('updatedata.php'); ?>
<?php
session_start();

if(isset($_SESSION['uid']))
{
	echo "";
	
}
else
{
	header('location:index.php');
}

include('dbcon.php');
$cid = $_GET['cid'];
$qry = "SELECT * FROM `company` WHERE `company_id` = '$cid'";
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
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Custom styles for this template-->
  <link href="css/sb-admin.css" rel="stylesheet">
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<?php include('admin.php');?>
	 <div class="content-wrapper">
  <div class="container">
    <div class="card card-register mx-auto mt-5">
      <div class="card-header">Register an Account</div>
      <div class="card-body">
        <form action="updatecompany.php" method="post">
			
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <label for="exampleInputName">Company name</label>
                <input class="form-control" id="exampleInputName" type="text" name="c_name" aria-describedby="nameHelp" value=<?php echo $data['company_name']; ?> >
              </div>
              <div class="col-md-6">
                <label for="exampleInputLastName">Contact No</label>
                <input class="form-control" id="exampleInputLastName" type="text" name="c_contact" aria-describedby="nameHelp" value=<?php echo $data['company_contact']; ?> required>
              </div>
            </div>
          </div>
          <div class="form-group">
            <label for="exampleInputEmail1">Email address</label>
            <input class="form-control" id="exampleInputEmail1" type="email" name="c_email" aria-describedby="emailHelp" value=<?php echo $data['company_email']; ?> required>
          </div>
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <label for="exampleInputPassword1">Reg No</label>
                <input class="form-control" id="exampleInputPassword1" type="text" name="c_regno" value=<?php echo $data['company_regno']; ?> required>
				  <input type="hidden" name="cid" value="<?php echo $data['company_id']; ?>" />
              </div>
              
            </div>
          </div>
          <input type="submit" name="register" value="Update" class="btn btn-primary btn-block" />
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
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <!-- Core plugin JavaScript-->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
</body>

</html>

