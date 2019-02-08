
<?php include('../dbcon.php');

$dis_id = $_POST['id'];

//$query = "SELECT * FROM `shopkeeper` INNER JOIN distributor WHERE shopkeeper.shop_region = distributor.distributor_region AND distributor_id = '$dis_id' ";
 $query = "SELECT * FROM `orders` INNER JOIN shopkeeper s , distributor d
 WHERE orders.shopkeeper_id = s.sk_id 
 AND orders.distributor_id = d.distributor_id;";

  $run = mysqli_query($con,$query);
  
  if($run == TRUE) {
    //   while($row = mysqli_fetch_array($run)) {
    //       $data[] = $row;
    //   }
      while($row1 = mysqli_fetch_assoc($run)) {
            $arr = array();
            $arr['id'] = $row1['sk_id'];
            $arr['name'] = $row1['sk_name'];
            $arr['contact'] = $row1['sk_contact'];
            $arr['email'] = $row1['sk_email'];
            $arr['shopname'] = $row1['shop_name'];
            $arr['shopaddress'] = $row1['shop_address'];
            $arr['region'] = $row1['shop_region'];            
            $data[] = $arr;
        }
      print(json_encode($data));
    }
   else {
       echo "Failed";
  }
  
  mysqli_close($con);

?>