
<?php include('../dbcon.php');


$s_email = trim($_POST['d_email']);
$password = trim($_POST['d_password']);

$s_password = md5($password);

		 $qry = "SELECT * FROM `shopkeeper` WHERE `sk_email` = '$s_email' AND `password` = '$s_password' ";

		$run = mysqli_query($con,$qry);

		$row = mysqli_num_rows($run);
		if($row == 0) {
			echo "Email or Password is Incorrect";
		}
		else {
			while($row1 = mysqli_fetch_assoc($run)) {
				$arr = array();
				$arr['id'] = $row1['sk_id'];
				$arr['name'] = $row1['sk_name'];
				$arr['contact'] = $row1['sk_contact'];
				$arr['email'] = $row1['sk_email'];
				$arr['shop_name'] = $row1['shop_name'];
				$arr['shop_address'] = $row1['shop_address'];
				$arr['region'] = $row1['shop_region'];
				$arr['password'] = $row1['password'];
				$data[] = $arr;
			}
			echo (json_encode($data));
		}
		$con -> close();
?>
