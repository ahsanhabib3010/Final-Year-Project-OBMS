
<?php
$errors	  = array();


include('dbcon.php');

if(isset($_POST['register']))
{
	$fname = trim($_POST['fname']);
	$lname = trim($_POST['lname']);
	$email = trim($_POST['email']);
	$password = $_POST['password'];
	$cpassword = $_POST['cpassword'];

 	$name = trim($fname);
	$lastname = trim($lname);
	$emaill = trim($email);
	
	if(empty($fname))
	{
		array_push($errors, "First name is required");
	}
	elseif(!preg_match('/^[\p{L} ]+$/u',$name))
	{
		array_push($errors, "only letter");
	}
	
	if(empty($lname))
	{
		array_push($errors, "Last name is required");
	}
	
	if(empty($email))
	{
		array_push($errors, "Email is required");
	}
	elseif(!filter_var($emaill, FILTER_VALIDATE_EMAIL))
	{
		array_push($errors, "Invalid Email formate");
	}
	
	if($password != $cpassword)
	{
		array_push($errors, "The two password do not match");
	}
	
	if(count($errors)== 0)
	{
		$password1 = md5($password);
		$qry = "INSERT INTO `admin`(`id`, `first_name`, `last_name`, `email`, `password`) 
		VALUES (null,'$name','$lastname','$emaill','$password1')";
		
		$run = mysqli_query($con,$qry);
		
		if($run == true)
		{
			?>
			<script>
		alert('Data Inserted');
		window.open('register.php','_self');
  </script>
			<?php
			

		}
		
		
	}
	
} 

if(isset($_POST['addcompany']))
{
	$c_name = trim($_POST['c_name']);
	$c_contact = trim($_POST['c_contact']);
	$c_email = trim($_POST['c_email']);
	$c_regno = trim($_POST['c_regno']);
	$company_username = trim($_POST['company_username']);
	$c_password = $_POST['c_password'];
	
	if(empty($c_name))
	{
		array_push($errors, "Name is required");
	}
	elseif(!preg_match('/^[\p{L} ]+$/u',$c_name))
	{
		array_push($errors, "only letter");
	}
	
	if(empty($c_contact))
	{
		array_push($errors, "Contact number is required");
	}
	elseif(!preg_match('/^\d{11}$/',$c_contact))
	{
		array_push($errors, "wrong number");
	}
	
	if(empty($c_email))
	{
		array_push($errors, "Email is required");
	}
	elseif(!filter_var($c_email, FILTER_VALIDATE_EMAIL))
	{
		array_push($errors, "Invalid Email formate");
	}
	
	if(empty($c_regno))
	{
		array_push($errors, "Reg no is required");
	}
	
	if(empty($company_username))
	{
		array_push($errors, "Username is required");
	}
	elseif(!preg_match("/^[a-zA-Z]*$/",$company_username))
	{
		array_push($errors, "only letter");
	}
	
	if(count($errors)== 0)
	{
		
		$password1 = md5($c_password);
		$qry = "INSERT INTO `company`(`company_id`, `company_name`, `company_contact`, `company_email`, `company_regno`,`company_username`,`password`) 
    VALUES (null,'$c_name','$c_contact','$c_email','$c_regno','$company_username','$password1')";
		
		$run = mysqli_query($con,$qry);
		
		$run = mysqli_query($con,$qry);
		
		if($run == true)
		{
			?>
			<script>
		alert('Data Inserted');
    window.open('addcompany.php','_self');
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

