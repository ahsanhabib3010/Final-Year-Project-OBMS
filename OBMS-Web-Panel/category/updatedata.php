<?php
$errors = array();

include('../dbcon.php');

if(isset($_POST['register'])){

	$category_name = trim($_POST['category_name']);
	$category_type = trim($_POST['category_type']);
	$id = $_POST['category_id'];
	
	if(empty($category_name))
	{
		array_push($errors, "Name is required");
			?>
			<script>
		alert('Name is required');
    window.open('managecategory.php','_self');
  </script>
			<?php
	}
	elseif(!preg_match('/^[\p{L} ]+$/u',$category_name))
	{
		array_push($errors, "only letter");
		?>
			<script>
		alert('only letter');
    window.open('managecategory.php','_self');
  </script>
			<?php
	}
	
	if(empty($category_type))
	{
		array_push($errors, "Category type is required");
			?>
			<script>
		alert('Category type is required');
    window.open('managecategory.php','_self');
  </script>
			<?php
	}
	
	if(count($errors)== 0)
	{
		$qry = "UPDATE `category` SET `category_name`='$category_name',`category_type`='$category_type' WHERE category_id = $id;";
		
		$run = mysqli_query($con,$qry);
		
		if($run == true)
		{
			?>
			<script>
		alert('Data Updated');
    window.open('managecategory.php','_self');
  </script>
			<?php
		}
	}
}

?>

