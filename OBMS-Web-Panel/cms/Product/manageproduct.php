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
<!DOCTYPE html>
<html lang="en"><head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>Admin Panel - OBMS</title>
  <!-- Bootstrap core CSS-->
  <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="../vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Custom styles for this template-->
  <link href="../css/sb-admin.css" rel="stylesheet">
	
	<link href="../css/stylesheet.css" rel="stylesheet">s
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<?php include('adminproduct.php');?>
	 <div class="content-wrapper">
  <div class="container">
    <div class="card mx-auto mt-5">
      <div class="card-header">Manage Distributor</div>
      <div class="card-body">
        <form action="deleteshopkeeper.php" method="post" >
			<table class="table table-striped">

				<tr>
				<th>Product Name</th>
				<th>Product Price</th>
			  <th>Action</th>
				</tr>
<?php
include('../dbcon.php');
$id = $_SESSION['cid'];
$qry="select * from `product` where `company_id` = '$id'";
$run = mysqli_query($con,$qry);

while($data = mysqli_fetch_row($run))
{
  ?>
	<tr>
   <td><?php echo "$data[3]"; ?></td>
		<td><?php echo "$data[4]"; ?></td>

	<td> <a href="updateproduct.php?product_id=<?php echo $data[0]; ?>">Edit</a> | <a href="deleteproduct.php?did=<?php echo $data[0]; ?>">Delete</a></td>	
	</tr>
  <?php
}

?>
				</table>
			
			
		
        </form>
		</div>
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




