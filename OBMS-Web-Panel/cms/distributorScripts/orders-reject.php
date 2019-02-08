
<?php include('../dbcon.php');

$order_id = $_POST['id'];

 $query1 = "DELETE FROM `orders` WHERE order_id = $order_id ";
 $query2 = "DELETE FROM `orders_has_product` WHERE order_id = $order_id ";
  $run1 = mysqli_query($con,$query1);
  $run2 = mysqli_query($con,$query2);
  
  if($run1 == TRUE && $run2 == TRUE) {
      echo "successfull";
    }
   else {
       echo "Failed";
  }
  
  mysqli_close($con);

?>