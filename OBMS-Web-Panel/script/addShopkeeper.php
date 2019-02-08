
<?php include('../dbcon.php');

	$s_name = trim($_POST['s_name']);
	$s_contact = trim($_POST['s_contact']);
	$s_email = trim($_POST['s_email']);
	$s_shopname = trim($_POST['s_shopname']);
	$shop_address = trim($_POST['s_address']);
	$shop_region = trim($_POST['s_region']);
  $s_password = trim($_POST['s_password']);
	
	$s_password1 = md5($s_password);

		$qry = "INSERT INTO `shopkeeper`(`sk_name`, `sk_contact`, `sk_email`, `shop_name`, `shop_address`, `shop_region`, `password`) 
    VALUES ('$s_name', '$s_contact', '$s_email', '$s_shopname', '$shop_address', '$shop_region', '$s_password1') ";
		
		$run = mysqli_query($con,$qry);
		
		if($run == TRUE) {
			echo "Shopkeeper Registered successfully";
		}
		else {
			echo "Registration failed.........";
		}

		$con -> close();
?>