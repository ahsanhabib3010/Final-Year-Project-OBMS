<?php
include('../dbcon.php');

	$product_name = $_POST['product_name'];
	$product_prize = $_POST['product_prize'];
	$id = $_POST['product_id'];

	
		$qry = "UPDATE `product` SET `product_name`='$product_name',`product_perunitprize`='$product_prize' WHERE product_id='$id'";
		
		$run = mysqli_query($con,$qry);
		
		if($run == true)
		{
			?>
			<script>
		alert('Data Updated');
    window.open('manageproduct.php','_self');
  </script>
			<?php
		}
	
?>

