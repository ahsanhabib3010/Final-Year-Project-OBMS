<?php
session_start();

if(isset($_SESSION['cid']))
{
	header('location:companyadmindash');
	
}
?>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>Company Admin-Panal</title>
  <!-- Bootstrap core CSS-->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Custom styles for this template-->
  <link href="css/sb-admin.css" rel="stylesheet">

  <style>
.appname{
  color: white;
  text-align: center;
  position: relative;
  font-style: italic;
  margin-top: 30px;
}
</style>
</head>

<body class="bg-dark">
  <h1 class="appname">Order Booking Application</h1>
  <div class="container">
    <div class="card card-login mx-auto mt-5">
      <div class="card-header">Company Panel Login</div>
      <div class="card-body">
        <form action="login.php" method="post">
          <div class="form-group">
            <label for="exampleInputEmail1">User Name</label>
            <input class="form-control" id="exampleInputEmail1" type="text" name="company_username" aria-describedby="emailHelp" placeholder="Enter User Name" required>
          </div>
          <div class="form-group">
            <label for="exampleInputPassword1">Password</label>
            <input class="form-control" id="exampleInputPassword1" type="password" name="password" placeholder="Password" required>
          </div>
          <div class="form-group">
            <div class="form-check">
              <label class="form-check-label">
                <input class="form-check-input" type="checkbox"> Remember Password</label>
            </div>
          </div>
         <!--  <a class="btn btn-primary btn-block" href="index.html" >Login</a> -->
         <input type="submit" name="login" value="Login" class="btn btn-primary btn-block"  />
        <input type="hidden" name="comid" />
        </form>
        <div class="text-center">
          <!-- <a class="d-block small mt-3" href="register.php">Register an Account</a> -->
          <a class="d-block small" href="forgot-password.php">Forgot Password?</a>
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

<?php
		include('dbcon.php');
	
	if(isset($_POST['login'])){
		
		$company_username = $_POST['company_username'];
    $password = $_POST['password'];
    $password1 = md5($password);
		
		$qry = "SELECT * FROM `company` WHERE `company_username` = '$company_username' AND `password` = '$password1'";
		$run = mysqli_query($con,$qry);
		$row = mysqli_num_rows($run);
		if($row < 1)
		{
			
			?> 
	 <script>
		alert('Username or Password not match');
		window.open('login.php','_self');
	</script>
	<?php
		}
	else{
		
		$data =mysqli_fetch_assoc($run);
		
		$id = $data['company_id'];
		
		session_start();
		
	$_SESSION['cid']=$id;	
		
		header('location:companyadmindash');
	}		
		
}
	?>
