<?php
$errors = array();
include('../dbcon.php');
if(isset($_POST['update']))
{
	$sk_name = trim($_POST['sk_name']);
	$sk_contact = trim($_POST['sk_contact']);
	$sk_email = trim($_POST['sk_email']);
	$shop_name = trim($_POST['shop_name']);
	$shop_address = trim($_POST['shop_address']);
	$id = $_POST['sk_id'];


if(empty($sk_name))
	{
	array_push($errors, "Name is required");
		?>
			<script>
		alert('Fill Name');
    window.open('manageshopkeeper','_self');
  </script>
			<?php
	}
	elseif(!preg_match('/^[\p{L} ]+$/u',$sk_name))
	{
		array_push($errors, "only letter");
		?>
			<script>
		alert('only letter');
    window.open('manageshopkeeper','_self');
  </script>
			<?php
	}
	
	if(empty($sk_contact))
	{
		array_push($errors, "Contact number is required");
		?>
			<script>
		alert('Contact number is required');
    window.open('manageshopkeeper.php','_self');
  </script>
			<?php
		
	}
	elseif(!preg_match('/^\d{11}$/',$sk_contact))
	{
		array_push($errors, "wrong number");
		?>
			<script>
		alert('wrong number');
    window.open('manageshopkeeper.php','_self');
  </script>
			<?php
	}
	
	if(empty($sk_email))
	{
		array_push($errors, "Email is required");
		?>
			<script>
		alert('Email is required');
    window.open('manageshopkeeper.php','_self');
  </script>
			<?php
	}
	elseif(!filter_var($sk_email, FILTER_VALIDATE_EMAIL))
	{
		array_push($errors, "Invalid Email formate");
		?>
			<script>
		alert('Invalid Email formate');
    window.open('manageshopkeeper.php','_self');
  </script>
			<?php
	}
	
	if(empty($shop_address))
	{
		array_push($errors, "Address is required");
		?>
			<script>
		alert('Address is required');
    window.open('manageshopkeeper.php','_self');
  </script>
			<?php
	}
	
	if(empty($shop_name))
	{
		array_push($errors, "Shop Name is required");
		?>
			<script>
		alert('Shop Name is required');
    window.open('manageshopkeeper.php','_self');
  </script>
			<?php
	}
	
	
	if(count($errors)== 0)
	{
	
		$qry = "UPDATE `shopkeeper` SET `sk_name`='$sk_name',`sk_contact`='$sk_contact',`sk_email`='$sk_email',`shop_name`='$shop_name',`shop_address`='$shop_address' WHERE sk_id = $id;";
		
		$run = mysqli_query($con,$qry);
		
		if($run == true)
		{
			?>
			<script>
		alert('Data Updated');
    window.open('manageshopkeeper.php','_self');
  </script>
			<?php
		}
	}
}
?>

