<?php
include('../dbcon.php');

$productid = $_GET["productid"];

if($productid!="")
{
$qry="SELECT * FROM `product` WHERE `category_id`='$productid '";
$run = mysqli_query($con,$qry);

echo "Product Name"."&nbsp;&nbsp;"."<select name='product_idd' id='prod_id'  onchange='prod_price()'>";
echo "<option>Select</option>";
while($row=mysqli_fetch_array($run))
{
    echo "<option value='$row[product_id]'>";
     echo $row["product_name"]; 
    echo "</option>";
}
echo "</select>";
}
?>