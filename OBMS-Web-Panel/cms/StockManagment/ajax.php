<?php
include('../dbcon.php');
$category = $_GET["category"];



if($category!="")
{
$qry="select * from category where category_name='$category'";
$run = mysqli_query($con,$qry);

echo "Category Type"."&nbsp;&nbsp;"."<select id='productid'  onchange='product_namee()'>";
echo "<option>Select</option>";
while($row=mysqli_fetch_array($run))
{
    echo "<option value='$row[category_id]'>";
     echo $row["category_type"]; 
    echo "</option>";
}
echo "</select>";
}


?>

