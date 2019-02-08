<?php

session_start();
$_SESSION['uid']=$id;	
session_destroy();
		header('location:index.php');

?>
