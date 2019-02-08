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
?>
<?php include('ProductRegister.php'); ?>

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
   <meta name="viewport" content="width=device-width, initial-scale=1">
  
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<?php include('adminproduct.php');?>
	 <div class="content-wrapper">
    
  <div class="container">
    <div class="card card-register mx-auto mt-5">
      <div class="card-header">Add Product</div>
      <div class="card-body">
        <form action="addproduct.php" method="post">
          <?php include('error.php'); ?>
          <div class="form-group">
   <div class="form-group">
            <div class="form-row">

            <div class="col-md-6">
                <label for="exampleInputName">Distributor</label>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <!-- spaces -->
                <select name="distributor_idd">
                    <option>Select</option>
                    <?php
                        include('../dbcon.php');
                        $qry = "SELECT * FROM `distributor`";
                        $run =mysqli_query($con,$qry);
                        while($row=mysqli_fetch_array($run))
                        {
                          ?>
                            <option value="<?php  echo $row["distributor_id"]; ?>"><?php echo $row["distributor_name"]; ?></option>
                          <?php
                        }
                    ?>
                </select>
              </div>


              <div class="col-md-6">
              <label for="exampleInputEmail1">Category</label>&nbsp;&nbsp;
              <select id="categoryd"  onChange="category_name()" >
              <option>Select</option>  
                  <?php 
                   include('../dbcon.php');

                  $qry="SELECT * FROM `category`";
                  $run=mysqli_query($con,$qry);
    
                  while($row=mysqli_fetch_array($run))
                  { 
                  ?>
                  <option value="<?php  echo $row['category_name']; ?>"><?php echo $row["category_name"]; ?> </option>
                  <?php
                  }
                  ?>
                </optgroup>
                </select>


              </div>
              <div class="col-md-6">
              
                    <div id="category_type">
                    <label for="exampleInputEmail2">Category Type</label>&nbsp;&nbsp;
                        <select>
                 
                          <option>Category Type</option>
                         
                        </select>
                        
                    </div>
              </div>
            </div>
          </div>
  
  <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <label for="exampleInputName">Product name</label>
                <input class="form-control" id="exampleInputName" type="text" name="product_name" aria-describedby="nameHelp" placeholder="Enter Product name">
              </div>
              <div class="col-md-6">
                <label for="exampleInputLastName">Product Price</label>
                <input class="form-control" id="exampleInputLastName" type="text" name="product_price" aria-describedby="nameHelp" placeholder="Enter Price" >
              </div>
            </div>
          </div>
              
            </div>
          
          <input type="submit" name="register" value="Register" class="btn btn-primary btn-block" />
			
          </div>
		
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

  <script type="text/javascript">
	function category_name()
    {
      var xmlhttp=new XMLHttpRequest();
      xmlhttp.open("GET","ajax.php?category="+document.getElementById("categoryd").value,false);
      xmlhttp.send(null);
      document.getElementById("category_type").innerHTML=xmlhttp.responseText;
    } 
</script>
</body>

</html>


