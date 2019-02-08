<?php
include('../dbcon.php');

$stock = $_GET["stock"];

echo "<table class='table table-striped'>";

echo "<tr>";
echo "<th>Product Name</th>";
echo "<th>Product Price</th>";
echo "<th>Action</th>";
echo "</tr>";
echo "<td></td>";
echo "</table>";

$qry="select * from `stock` where `distributor_id` = '$stock'";
$run = mysqli_query($con,$qry);

while($data = mysqli_fetch_row($run))
{
  
echo	"<tr>";
echo  "<td>$data[3]</td>"."<br>";
echo  "<td>$data[4]</td>";

echo	"</tr>";

}

?>