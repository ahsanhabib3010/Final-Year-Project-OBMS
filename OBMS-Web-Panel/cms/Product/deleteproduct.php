<?php

include('../dbcon.php');
$did = $_REQUEST['did'];
$qry = "DELETE FROM `product` WHERE `product_id` = '$did';";
$run = mysqli_query($con,$qry);
if($run == true)
		{
			?>
			<script>
		alert('Data Deleted');
    <?php header('location:manageproduct.php'); ?>
  </script>
			<?php
		}
	
?>
