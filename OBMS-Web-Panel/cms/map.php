<!DOCTYPE html>
<html>
<head>
<style>
*{
	margin:0;
	padding:0;
}
#map{
	height: 500px;
	width:100%;
}

</style>
</head>

<body>

<div id="map">

</div>
<?php 
	include('dbcon.php');
	$lat = $_POST["lat"];
	$long = $_POST["long"];

	$qry = "UPDATE `distributor` SET `lat`=$lat , `long`=$long, where distributor_id = 
?>
<script>
function initMap() {
	var location = {lat:24.860734 , lng:67.001136};
	var map = new google.maps.Map(document.getElementById("map"),{
		zoom:4,
		center: location
	});
	var marker = new google.maps.Marker({
		position: location,
		map: map
	})
}
</script>
<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAswt9eEMvcFlAD3Q1i2svW9r3SZn3cC1I&callback=initMap">

</script>

</body>
</html>