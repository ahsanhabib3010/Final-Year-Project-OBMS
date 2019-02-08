<?php

include('../dbcon.php');
$did = $_REQUEST['did'];
$qry = "DELETE FROM `category` WHERE `category_id` = '$did';";
$run = mysqli_query($con,$qry);
if($run == true)
		{
			?>
			<script>
		alert('Data Deleted');
    <?php header('location:managecategory.php'); ?>
  </script>
			<?php
		}
	
?>
