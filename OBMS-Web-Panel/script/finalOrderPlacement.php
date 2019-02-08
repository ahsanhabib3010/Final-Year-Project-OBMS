<?php

	header("Access-Control-Allow-Origin: *");
	header("Content-Type: application/json; charset=UTF-8");


	include('../dbcon.php');


	file_put_contents('order.txt',print_r($_POST,true));	
	
	//$distributor_id = '16';
    //$shopkeeper_id = '20';
//	$ordered_products = '{"a":1,"b":2,"c":3}';
	
	//$ordered_products = file_put_contents(ordered_products,true);
		
	  $distributor_id = trim($_POST['did']);
	  $shopkeeper_id = trim($_POST['sid']);
	  $totalprice = trim($_POST['total']);
	  $ordered_products = $_POST['ordered_products'];

	  $products = json_decode($ordered_products);
	  
	

$qry = "INSERT INTO `orders`(`shopkeeper_id`, `distributor_id`, `order_totalprice`) 
VALUES ('$shopkeeper_id','$distributor_id','$totalprice')";

$run1 = mysqli_query($con,$qry);

$last_order_id = mysqli_insert_id($con);

foreach($products as $prod){
	
		$pid =$prod->product_id;
		$porderName =$prod->product_name;
		$pqty= $prod->qty;
	
		$qryOrderHasProduct = "INSERT INTO `orders_has_product`(`shopkeeper_id`,`order_id`, `product_id`, `product_name`, `product_qty`) 
								VALUES ('$shopkeeper_id','$last_order_id','$pid','$porderName','$pqty')";
	
		$run2 = mysqli_query($con,$qryOrderHasProduct);
	
		if($run2 == TRUE) {
			echo "Product Place Successfully";
		}
		else {
			echo "Product Placement failed";
		}
	
	
	}
if($run1 == TRUE) {
	 	echo "Order Place Successfully";
	 }
	 else {
	 	echo "Order Placement failed";
	 }


	$con -> close();
?>