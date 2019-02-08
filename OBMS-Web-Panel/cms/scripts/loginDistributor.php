
<?php

include('../dbcon.php');

	$d_email = trim($_POST['d_email']);
	$d_password = trim($_POST['d_password']);

	// $qry = "INSERT INTO `distributor`(`distributor_name`, `distributor_contact`, `distributor_email`, `distributor_address`, `distributor_region`, `distributor_password`) 
	// VALUES ('$d_name','$d_contact','$d_email','$d_address','$d_region','$d_password')";

     $qry = "SELECT `distributor_email`,`distributor_password` FROM `distributor` WHERE `distributor_email`= '$d_email'  AND `distributor_password` =  '$d_password' ";


		$run = mysqli_query($con,$qry);
		$row = mysqli_num_rows($run);
		
		if($row > 0)
		{
            echo "Distributor Login Successfull..!!";
        }
        else 
        {
            echo "Login Failed..!!";
		}
		$con -> close();
		
?>
