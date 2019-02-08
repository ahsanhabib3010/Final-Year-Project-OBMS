<?php
include('../dbcon.php');

$prodid = $_GET["prodid"];

if($prodid!="")
{
$qry="SELECT * FROM `product` WHERE `product_id`='$prodid '";
$run = mysqli_query($con,$qry);


while($row=mysqli_fetch_array($run))
{
    echo "<label>$row[product_perunitprize]</label>";
	echo "<input type='hidden' value='$row[product_perunitprize]' name='product_price' />";
}

}
?>