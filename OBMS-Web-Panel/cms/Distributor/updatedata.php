<?php
$errors	  = array();
include('../dbcon.php');

if(isset($_POST['register']))
{
	$d_name = trim($_POST['d_name']);
	$d_contact = trim($_POST['d_contact']);
	$d_email = trim($_POST['d_email']);
	$d_address = trim($_POST['d_addresss']);
	$d_region = trim($_POST['d_region']);
	$id = $_POST['d_id'];

	
		
	
	
	if(empty($d_name))
	{
		array_push($errors, "Name is required");
		?>
			<script>
		alert('Fill Name');
    window.open('managedistributor.php','_self');
  </script>
			<?php
	}
	elseif(!preg_match('/^[\p{L} ]+$/u',$d_name))
	{
		array_push($errors, "only letter");
		?>
			<script>
		alert('only letter');
    window.open('managedistributor.php','_self');
  </script>
			<?php
	}
	
	if(empty($d_contact))
	{
		array_push($errors, "Contact number is required");
		?>
			<script>
		alert('Contact number is required');
    window.open('managedistributor.php','_self');
  </script>
			<?php
		
	}
	elseif(!preg_match('/^\d{11}$/',$d_contact))
	{
		array_push($errors, "wrong number");
		?>
			<script>
		alert('wrong number');
    window.open('managedistributor.php','_self');
  </script>
			<?php
	}
	
	if(empty($d_email))
	{
		array_push($errors, "Email is required");
		?>
			<script>
		alert('Email is required');
    window.open('managedistributor.php','_self');
  </script>
			<?php
	}
	elseif(!filter_var($d_email, FILTER_VALIDATE_EMAIL))
	{
		array_push($errors, "Invalid Email formate");
		?>
			<script>
		alert('Invalid Email formate');
    window.open('managedistributor.php','_self');
  </script>
			<?php
	}
	
	if(empty($d_address))
	{
		array_push($errors, "Address is required");
		?>
			<script>
		alert('Address is required');
    window.open('managedistributor.php','_self');
  </script>
			<?php
	}
	
	if(empty($d_region))
	{
		array_push($errors, "Region is required");
		?>
			<script>
		alert('Region is required');
    window.open('managedistributor.php','_self');
  </script>
			<?php
	}
	
	
	if(count($errors)== 0)
	{
		$qry = "UPDATE `distributor` SET `distributor_name`='$d_name',`distributor_contact`='$d_contact',`distributor_email`='$d_email',`distributor_address`='$d_address',`distributor_region`='$d_region' WHERE distributor_id = $id";
		
		$run = mysqli_query($con,$qry);
		
		if($run == true)
		{
			?>
			<script>
		alert('Data Updated');
    window.open('managedistributor.php','_self');
  </script>
			<?php
		}
	}
	
}
?>

