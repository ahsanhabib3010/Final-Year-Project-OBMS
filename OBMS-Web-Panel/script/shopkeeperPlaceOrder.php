
<?php include('../dbcon.php');

$order_id = $_POST['order_id'];
$shopkeeper_id = $_POST['shopkeeper_id'];
$company_id = $_POST['company_id'];
$distributor_id = $_POST['distributor_id'];
$order_name = $_POST['order_name'];
$order_quantity = $_POST['order_quantity'];
$order_unitperprice = $_POST['order_unitperprice'];
$order_date = CURRENTDATE(); 

$query = "INSERT INTO `orders`(`order_id`, `shopkeeper_id`, `company_id`, `distributor_id`, `order_name`, `order_quantity`, `order_date`, `order_unitperprice`, `order_status`) 
VALUES ('$order_id', '$shopkeeper_id', '$company_id', '$distributor_id', '$order_name', '$order_quantity', '$order_date', '$order_unitperprice', 1)";

  $run = mysqli_query($con,$query);
  
  if($run == TRUE) {
    echo "Order Placed Successfully";
    }
   else {
       echo "Order Placing Failed";
  }
  
  mysqli_close($con);

?>