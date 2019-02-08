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
<!DOCTYPE html>
<html lang="en"><head>
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
	
	<link href="../css/stylesheet.css" rel="stylesheet">s
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<?php include('adminshop.php');?>
	 <div class="content-wrapper">
  <div class="container">
    <div class="card mx-auto mt-5">
      <div class="card-header">Manage Shopkeeper</div>
      <div class="card-body">
        <form action="deleteshopkeeper.php" method="post" >
			<table class="table table-striped">

				<tr>
				<th>Shopkeeper Name</th>
				<th>Contact No</th>
			  <th>Email</th>
				<th>Shop Name</th>
				<th>Shop Address</th>
        <th>Action</th>
				</tr>
<?php
include('../dbcon.php');

$qry="select * from shopkeeper";
$run = mysqli_query($con,$qry);

while($data = mysqli_fetch_row($run))
{
  ?>
	<tr>
	 <td><?php echo $data[1]; ?></td>
   <td><?php echo $data[2]; ?></td>
   <td><?php echo "$data[3]"; ?></td>
   <td><?php echo "$data[4]"; ?></td>
		<td><?php echo "$data[5]"; ?></td>


	<td> <a href="updateshopkeeper.php?skid=<?php echo $data[0]; ?>">Edit</a> | <a href="deleteshopkeeper.php?did=<?php echo $data[0]; ?>">Delete</a></td>	
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




