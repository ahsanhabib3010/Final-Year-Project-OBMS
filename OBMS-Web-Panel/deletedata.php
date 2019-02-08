<?php

include('dbcon.php');
$did = $_REQUEST['did'];
$qry = "DELETE FROM `company` WHERE `company_id` = '$did';";
$run = mysqli_query($con,$qry);
if($run == true)
		{
			?>
			<script>
		alert('Data Deleted');
    <?php header('location:managecompany.php'); ?>
  </script>
			<?php
		}
	
?>
