<?php
$errors = array();
include('dbcon.php');

if(isset($_POST['register'])){
	

	$c_name = $_POST['c_name'];
	$c_contact = $_POST['c_contact'];
	$c_email = $_POST['c_email'];
	$c_regno = $_POST['c_regno'];
	$id = $_POST['cid'];



		if(empty($c_name))
	{
		array_push($errors, "Name is required");
			?>
			<script>
		alert('Name is required');
    window.open('managecompany.php','_self');
  </script>
			<?php
	}
	elseif(!preg_match('/^[\p{L} ]+$/u',$c_name))
	{
		array_push($errors, "only letter");
		?>
			<script>
		alert('only letter');
    window.open('managecompany.php','_self');
  </script>
			<?php
	}
	
	if(empty($c_contact))
	{
		array_push($errors, "Contact number is required");
		?>
			<script>
		alert('Contact number is required');
    window.open('managecompany.php','_self');
  </script>
			<?php
	}
	elseif(!preg_match('/^\d{11}$/',$c_contact))
	{
		array_push($errors, "wrong number");
		?>
			<script>
		alert('wrong number');
    window.open('managecompany.php','_self');
  </script>
			<?php
	}
	
	if(empty($c_email))
	{
		array_push($errors, "Email is required");
		?>
			<script>
		alert('Email is required');
    window.open('managecompany.php','_self');
  </script>
			<?php
	}
	elseif(!filter_var($c_email, FILTER_VALIDATE_EMAIL))
	{
		array_push($errors, "Invalid Email formate");
		?>
			<script>
		alert('Invalid Email formate');
    window.open('managecompany.php','_self');
  </script>
			<?php
	}
	
	if(empty($c_regno))
	{
		array_push($errors, "Reg no is required");
		?>
			<script>
		alert('Reg no is required');
    window.open('managecompany.php','_self');
  </script>
			<?php
	}
	
	if(count($errors)== 0)
	{
		$qry = "UPDATE `company` SET `company_name`='$c_name',`company_contact`='$c_contact',`company_email`='$c_email',`company_regno`='$c_regno' WHERE company_id = $id;";
		
		$run = mysqli_query($con,$qry);
		
		if($run == true)
		{
			?>
			<script>
		alert('Data Updated');
    window.open('managecompany.php?cid=<?php echo $id; ?>','_self');
  </script>
			<?php

		}
		
	}
	}


?>

