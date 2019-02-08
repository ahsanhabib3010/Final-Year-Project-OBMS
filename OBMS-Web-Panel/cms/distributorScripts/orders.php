
<?php include('../dbcon.php');

$shop_id = $_POST['id'];

 $query = "SELECT orders.order_totalprice, orders.order_id, orders_has_product.product_name, orders_has_product.product_qty, 
            orders_has_product.product_id, product.product_perunitprize 
            FROM `orders` INNER JOIN `orders_has_product` INNER JOIN `product` WHERE 
            orders.shopkeeper_id = orders_has_product.shopkeeper_id AND
            orders_has_product.product_id = product.product_id AND orders.shopkeeper_id = '$shop_id' ";
  $run = mysqli_query($con,$query);
  
  if($run == TRUE) {

      while($row1 = mysqli_fetch_assoc($run)) {
            $arr = array();
            $arr['total_prize'] = $row1['order_totalprice'];
            $arr['order_id'] = $row1['order_id'];
            $arr['pro_name'] = $row1['product_name'];
            $arr['pro_qty'] = $row1['product_qty'];
            $arr['pro_unit_prize'] = $row1['product_perunitprize'];
            $arr['pro_id'] = $row1['product_id'];
            
            $data[] = $arr;
        }
      print(json_encode($data));
    }
   else {
       echo "Failed";
  }
  
  mysqli_close($con);

?>