<?php
include('../dbcon.php');
$category = $_GET["category"];

$qry="select * from category where category_name='$category'";
$run = mysqli_query($con,$qry);

echo "Category Type"."&nbsp;&nbsp;"."<select name='category_id'>";
while($row=mysqli_fetch_array($run))
{
    echo "<option value='$row[category_id]'>";
     echo $row["category_type"]; 
    echo "</option>";
}
echo "</select>";
?>