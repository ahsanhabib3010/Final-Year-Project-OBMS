
<?php
$errors	  = array();


include('../dbcon.php');


	if(isset($_POST['register']))
{
	$product_name = $_POST['product_name'];
	$product_price = $_POST['product_price'];
	$category_id = $_POST['category_id'];
	$company_id = $_SESSION['cid'];
	$distributor_idd = $_POST['distributor_idd'];
	
	if(empty($product_name))
	{
		array_push($errors, "Product Name is required");
	}
	
	
	if(empty($product_price))
	{
		array_push($errors, "Price is required");
	}
	
	
	if(count($errors)== 0)
	{
        $qry = "INSERT INTO `product`(`product_id`,`distributor_id`,`company_id`, `category_id`, `product_name`, `product_perunitprize`) 
        VALUES (null,'$distributor_idd','$company_id' ,'$category_id ','$product_name','$product_price')";
            
		
		$run = mysqli_query($con,$qry);
		
		if($run == true)
		{
			?>
			<script>
		alert('Data Inserted');
    window.open('addproduct.php','_self');
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

