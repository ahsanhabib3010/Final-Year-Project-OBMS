
<?php include('../dbcon.php');

$shopkeeper_id = $_POST['id'];

$query = "SELECT * FROM `distributor` INNER JOIN shopkeeper WHERE distributor.distributor_region = shopkeeper.shop_region AND shopkeeper.sk_id = '$shopkeeper_id' ";
 

  $run = mysqli_query($con,$query);
  
  if($run == TRUE) {
    //   while($row = mysqli_fetch_array($run)) {
    //       $data[] = $row;
    //   }
      while($row1 = mysqli_fetch_assoc($run)) {
            $arr = array();
            $arr['id'] = $row1['distributor_id'];
            $arr['name'] = $row1['distributor_name'];
            $arr['contact'] = $row1['distributor_contact'];
            $arr['email'] = $row1['distributor_email'];
            $arr['address'] = $row1['distributor_address'];
            $arr['region'] = $row1['distributor_region'];            
            $data[] = $arr;
        }
      print(json_encode($data));
    }
   else {
       echo "Failed";
  }
  
  mysqli_close($con);

?>