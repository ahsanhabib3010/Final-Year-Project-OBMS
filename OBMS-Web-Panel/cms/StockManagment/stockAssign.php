<?php
session_start();

if(isset($_SESSION['cid']))
{
	echo "";
	
}
else
{
	header('location:../login.php');
}
?>
<?php include('StockAssigntoDistributor.php'); ?>
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
	<?php include('adminStock.php');?>
	 <div class="content-wrapper">
    
  <div class="container">
    <div class="card card-register mx-auto mt-5">
      <div class="card-header">Stock Assign</div>
      <div class="card-body">
        <form action="stockAssign.php" method="post">
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
              
              <label for="exampleInputEmail1">Category</label>
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
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
              
          </div><br>
   <div class="form-group">
            <div class="form-row">
            
              <div class="col-md-6">
              <div id="category_type">
                    <label for="exampleInputEmail2">Category Type</label>&nbsp;&nbsp;
                        <select>
                 
                          <option>Category Type</option>
                         
                        </select>
                        
                    </div>
              </div>

              <div class="col-md-6">
              
                    <div id="product_type">
                    <label for="exampleInputEmail2">Product Name</label>&nbsp;&nbsp;
                        <select>
                 
                          <option>Product Name</option>
                         
                        </select>
                        
                    </div>
              </div>
            </div>
          </div>
  
  <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <label for="exampleInputName">Price</label>
                <div id="pricePerUnite">
              
					<label></label>
					<input type="hidden" name='product_price' />
                </div>
              </div>
              <div class="col-md-6">
                <label for="exampleInputLastName">Quantity</label>
                <input class="form-control" id="exampleInputLastName" type="text"  name="quantity" aria-describedby="nameHelp" placeholder="Enter Quantity" >
              </div>
            </div>
          </div>
              
            </div>
          
          <input type="submit" name="register" value="Submit" class="btn btn-primary btn-block" />
			
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

    function product_namee()
    {
      var xmlhttp=new XMLHttpRequest();
      xmlhttp.open("GET","ajaxProduct.php?productid="+document.getElementById("productid").value,false);
      xmlhttp.send(null);
      document.getElementById("product_type").innerHTML=xmlhttp.responseText;
    }

    function prod_price()
    {
      var xmlhttp=new XMLHttpRequest();
      xmlhttp.open("GET","ajaxPrice.php?prodid="+document.getElementById("prod_id").value,false);
      xmlhttp.send(null);
      document.getElementById("pricePerUnite").innerHTML=xmlhttp.responseText;
    }
    
</script>
</body>

</html>


