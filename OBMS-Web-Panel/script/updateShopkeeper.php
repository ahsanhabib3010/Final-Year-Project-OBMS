
<?php include('../dbcon.php');

$id = $_POST['sk_id'];

	$s_name = trim($_POST['s_name']);
	$s_contact = trim($_POST['s_contact']);
	$s_email = trim($_POST['s_email']);
	$s_shopname = trim($_POST['s_shopname']);
  $shop_address = trim($_POST['s_shopaddress']);
  $s_region = trim($_POST['s_region']);
  $s_password1 = trim($_POST['s_password']);

  $s_password = md5($s_password1);

		
$qry = "UPDATE `shopkeeper` SET `sk_name`= '$s_name',`sk_contact`= '$s_contact',`sk_email`= '$s_email',`shop_name`= '$s_shopname',`shop_address`= '$shop_address',`shop_region`= '$s_region',`password`= '$s_password' WHERE `sk_id` = $id";


		$run = mysqli_query($con,$qry);
		
		if($run == TRUE) {
			echo "Shopkeeper successfully updated";
		}
		else {
			echo "Update Failed";
		}

		$con -> close();
?>