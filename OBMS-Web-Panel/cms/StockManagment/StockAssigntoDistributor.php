
<?php
$errors	  = array();


include('../dbcon.php');


	if(isset($_POST['register']))
{
	$company_id = $_SESSION['cid'];
	$distributor_idd = $_POST['distributor_idd'];
	$product_id = $_POST['product_idd'];
	$quantity = $_POST['quantity'];
	$product_price = $_POST['product_price'];
		
	
	
	if(empty($quantity))
	{
		array_push($errors, "Enter Quantity");
	}
	
	
	if(count($errors)== 0)
	{
		$total = $quantity * $product_price;
        $qry = "INSERT INTO `stock`(`stock_id`, `company_id`, `distributor_id`, `product_id`, `stock_qty`, `stock_rate`) 
        VALUES (null,'$company_id' ,'$distributor_idd','$product_id','$quantity','$total')";
            
		
		$run = mysqli_query($con,$qry);
		
		if($run == true)
		{
			?>
			<script>
		alert('Data Inserted');
    window.open('stockAssign.php','_self');
  </script>
			<?php
			

		}
		
	}

}
//elseif(!preg_match("/^(\d[\s-]?)?[\(\[\s-]{0,2}?\d{3}[\)\]\s-]{0,2}?\d{3}[\s-]?\d{2}$/i",$phone)
//	{
//		array_push($errors, "only letter");
//	}


?>

