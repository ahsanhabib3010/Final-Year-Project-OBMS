
<?php

include('../dbcon.php');

	$d_name = trim($_POST['d_name']);
	$d_contact = trim($_POST['d_contact']);
	$d_email = trim($_POST['d_email']);
	$d_address = trim($_POST['d_addresss']);
	$d_region = trim($_POST['d_region']);
	$d_password = trim($_POST['d_password']);

	$qry = "INSERT INTO `distributor`(`distributor_name`, `distributor_contact`, `distributor_email`, `distributor_address`, `distributor_region`, `distributor_password`) 
	VALUES ('$d_name','$d_contact','$d_email','$d_address','$d_region','$d_password')";
			
		$run = mysqli_query($con,$qry);
		
		if($run == TRUE)
		{
            echo "Distributor Registration Successfully...!!!";
        }
        else 
        {
            echo "Registration Failed...!!!";
		}
		$con -> close();
		
?>
