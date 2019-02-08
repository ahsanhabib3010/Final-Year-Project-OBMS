<?php
session_start();

if(isset($_SESSION['uid']))
{
	header('location:admindash.php');
	
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
  <title>SB Admin - Start Bootstrap Template</title>
  <!-- Bootstrap core CSS-->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom styles for this template-->
  <link href="css/sb-admin.css" rel="stylesheet">
  <link href="css/stylesheet.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  



</head>

<body class="bg-dark">
<h1 class="appname">Order Booker Application</h1>
  <div class="container">
    <div class="card card-login mx-auto mt-5">
      <div class="card-header">Admin Panel Login</div>
      <div class="card-body">
        <form action="login.php" method="post">
          <div class="form-group">
            <label for="exampleInputEmail1">Email address</label>
            <input class="form-control" id="exampleInputEmail1" type="email" name="email" aria-describedby="emailHelp" placeholder="Enter email" required>
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

<style>
.appname{
  color: white;
  text-align: center;
  position: relative;
  font-style: italic;
  margin-top: 30px;
}
</style>

<?php
		include('dbcon.php');
	
	if(isset($_POST['login'])){
		
		$email = $_POST['email'];
    $password = $_POST['password'];
    
    $password1 = md5($password);
		
		$qry = "SELECT * FROM `admin` WHERE `email` = '$email' AND `password` = '$password1'";
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
		
		$id = $data['id'];
		
		session_start();
		
	$_SESSION['uid']=$id;	
		
		header('location:admindash.php');
	}		
		
}
	?>
