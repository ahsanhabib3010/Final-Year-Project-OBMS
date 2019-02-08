
<?php
$errors	  = array();
$id = $_SESSION['cid'];

include('../dbcon.php');

if(isset($_POST['register']))
{
	$d_name = trim($_POST['d_name']);
	$d_contact = trim($_POST['d_contact']);
	$d_email = trim($_POST['d_email']);
	$d_address = trim($_POST['d_addresss']);
	$d_region = trim($_POST['d_region']);
	$d_password = trim($_POST['d_password']);
	
	if(empty($d_name))
	{
		array_push($errors, "Name is required");
	}
	elseif(!preg_match('/^[\p{L} ]+$/u',$d_name))
	{
		array_push($errors, "Only Alphabet in Names");
	}
	
	if(empty($d_contact))
	{
		array_push($errors, "Contact number is required");
	}
	elseif(!preg_match('/^\d{11}$/',$d_contact))
	{
		array_push($errors, "wrong number");
	}
	
	if(empty($d_email))
	{
		array_push($errors, "Email is required");
	}
	elseif(!filter_var($d_email, FILTER_VALIDATE_EMAIL))
	{
		array_push($errors, "Invalid Email formate");
	}
	
	if(empty($d_address))
	{
		array_push($errors, "Address is required");
	}
	
	if(empty($d_region))
	{
		array_push($errors, "Region is required");
	}
	
	if(count($errors)== 0)
	{
		$password1 = md5($d_password);
		$qry = "INSERT INTO `distributor`(`distributor_id`, `company_id`,`distributor_name`, `distributor_contact`, `distributor_email`, `distributor_address`, `distributor_region`, `password`) 
    VALUES (null,'$id','$d_name','$d_contact','$d_email','$d_address','$d_region', '$password1')";
		
		$run = mysqli_query($con,$qry);
		
		if($run == true)
		{
			?>
			<script>
		alert('Data Inserted');
    window.open('adddistributor.php','_self');
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

