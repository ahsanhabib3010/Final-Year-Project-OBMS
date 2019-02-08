
<?php include('../dbcon.php');


$d_email = trim($_POST['d_email']);
$password = trim($_POST['d_password']);

$d_password = md5($password);

		 $qry = "SELECT * FROM `distributor` WHERE `distributor_email` = '$d_email' AND `password` = '$d_password' ";

		$run = mysqli_query($con,$qry);

		$row = mysqli_num_rows($run);
		if($row == 0) {
			echo "Email or Password is Incorrect";
		}
		else {
			while($row1 = mysqli_fetch_assoc($run)) {
				$arr = array();
				$arr['id'] = $row1['distributor_id'];
				$arr['name'] = $row1['distributor_name'];
				$arr['contact'] = $row1['distributor_contact'];
				$arr['email'] = $row1['distributor_email'];
				$arr['address'] = $row1['distributor_address'];
				$arr['region'] = $row1['distributor_region'];
				$arr['password'] = $row1['password'];
				$data[] = $arr;
			}
			echo (json_encode($data));
		}
		$con -> close();
?>
