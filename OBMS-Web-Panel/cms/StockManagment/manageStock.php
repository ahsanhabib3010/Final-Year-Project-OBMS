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
  <title>Company Admin Panel</title>
  <!-- Bootstrap core CSS-->
  <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="../vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Custom styles for this template-->
  <link href="../css/sb-admin.css" rel="stylesheet">
	
	<link href="../css/stylesheet.css" rel="stylesheet">s
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<?php include('adminStock.php');?>
	 <div class="content-wrapper">
  <div class="container">
    <div class="card mx-auto mt-5">
      <div class="card-header">Manage Distributor</div>
      <div class="card-body">
        <form action="deleteshopkeeper.php" method="post" >

        <div class="col-md-6">
                <label for="exampleInputName">Distributor</label>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <!-- spaces -->
                <select id="distributorid"  onChange="distributor_stock()">
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
    <div id="stockShow">
			<table class="table table-striped">

				<tr>
				<th>Product Name</th>
				<th>Product Price</th>
			  <th>Action</th>
				</tr>
        <td></td>
				</table>
	</div>		
			
		
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

  <script type="text/javascript">
	function distributor_stock()
    {
      var xmlhttp=new XMLHttpRequest();
      xmlhttp.open("GET","ajaxStock.php?stock="+document.getElementById("distributorid").value,false);
      xmlhttp.send(null);
      document.getElementById("stockShow").innerHTML=xmlhttp.responseText;
    }
</script>
</body>

</html>




