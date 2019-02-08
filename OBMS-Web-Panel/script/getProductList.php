
<?php include('../dbcon.php');

$id = $_POST['id'];

$query = "SELECT `product_id`, `distributor_id`, `product_name`, `product_perunitprize` FROM `product` WHERE distributor_id = $id";
 
  $run = mysqli_query($con,$query);
  
  if($run == TRUE) {
      while($row1 = mysqli_fetch_assoc($run)) {
            $arr = array();
            $arr['id'] = $row1['distributor_id'];
            $arr['productId'] = $row1['product_id'];
            $arr['productName'] = $row1['product_name'];
            $arr['productUnitPrize'] = $row1['product_perunitprize'];
            $data[] = $arr;
        }
      print(json_encode($data));
    }
   else {
       echo "Failed";
  }  
  mysqli_close($con);
?>