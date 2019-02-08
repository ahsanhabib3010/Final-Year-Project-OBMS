
<?php
$errors	  = array();


include('../dbcon.php');

if(isset($_POST['register']))
{
	$category_name = trim($_POST['category_name']);
	$category_type = trim($_POST['category_type']);
	
	if(empty($category_name))
	{
		array_push($errors, "Category Name is required");
	}
	elseif(!preg_match('/^[\p{L} ]+$/u',$category_name))
	{
		array_push($errors, "only letter");
	}
	
	if(empty($category_type))
	{
		array_push($errors, "Type is required");
	}
	elseif(!preg_match('/^[\p{L} ]+$/u',$category_type))
	{
		array_push($errors, "only letter");
	}
	
	if(count($errors)== 0)
	{
		$qry = "INSERT INTO `category`( `category_name`, `category_type`) 
    VALUES ('$category_name','$category_type')";
		
		$run = mysqli_query($con,$qry);
		
		if($run == true)
		{
			?>
			<script>
		alert('Data Inserted');
    window.open('addcategory.php','_self');
  </script>
			<?php
			

		}
		
	}
}

//elseif(!preg_match("/^(\d[\s-]?)?[\(\[\s-]{0,2}?\d{3}[\)\]\s-]{0,2}?\d{3}[\s-]?\d{2}$/i",$phone)
//	{
//		array_push($errors, "only letter");
//	}


?>

