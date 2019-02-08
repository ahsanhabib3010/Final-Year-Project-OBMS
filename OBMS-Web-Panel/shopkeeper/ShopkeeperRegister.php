
<?php
$errors	  = array();

include('../dbcon.php');

if(isset($_POST['register']))
{
	$s_name = $_POST['s_name'];
	$s_contact = $_POST['s_contact'];
	$s_email = $_POST['s_email'];
	$s_shopname = $_POST['s_shopname'];
	$shop_address = $_POST['s_addresss'];
	$shop_region = $_POST['s_region'];
    $s_password = $_POST['s_password'];
	
	if(empty($s_name))
	{
		array_push($errors, "Name is required");
	}
	elseif(!preg_match('/^[\p{L} ]+$/u',$s_name))
	{
		array_push($errors, "only letter");
	}
	
	if(empty($s_contact))
	{
		array_push($errors, "Contact number is required");
	}
	elseif(!preg_match('/^\d{11}$/',$s_contact))
	{
		array_push($errors, "wrong number");
	}
	
	if(empty($s_email))
	{
		array_push($errors, "Email is required");
	}
	elseif(!filter_var($s_email, FILTER_VALIDATE_EMAIL))
	{
		array_push($errors, "Invalid Email formate");
	}
	
	if(empty($s_shopname))
	{
		array_push($errors, "Enter shop name");
	}
	
	if(empty($shop_address))
	{
		array_push($errors, "Enter shop address");
	}

	if(empty($s_password))
	{
		array_push($errors, "Enter password");
	}
	
	
	if(count($errors)== 0)
	{
		$password1 = md5($s_password);
		$qry = "INSERT INTO `shopkeeper`(`sk_id`, `sk_name`, `sk_contact`, `sk_email`, `shop_name`, `shop_address`, `shop_region`, `password`) 
		VALUES (null,'$s_name','$s_contact','$s_email','$s_shopname','$shop_address','$shop_region','$password1')";
		
		
		
		$run = mysqli_query($con,$qry);
		
		if($run == true)
		{
			?>
			<script>
		alert('Data Inserted');
    window.open('addshopkeeper.php','_self');
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

