<?php

include('../dbcon.php');
$did = $_REQUEST['did'];
$qry = "DELETE FROM `shopkeeper` WHERE `sk_id` = '$did';";
$run = mysqli_query($con,$qry);
if($run == true)
		{
			?>
			<script>
		alert('Data Deleted');
    <?php header('location:manageshopkeeper.php'); ?>
  </script>
			<?php
		}
	
?>
