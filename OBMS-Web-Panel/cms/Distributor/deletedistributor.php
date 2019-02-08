<?php

include('../dbcon.php');
$did = $_REQUEST['did'];
$qry = "DELETE FROM `distributor` WHERE `distributor_id` = '$did';";
$run = mysqli_query($con,$qry);
if($run == true)
		{
			?>
			<script>
		alert('Data Deleted');
    <?php header('location:managedistributor.php'); ?>
  </script>
			<?php
		}
	
?>
