<?php
$db_name = "theCoolBeverageShop";
$mysql_user = "YaserIftikhar";
$mysql_pass = "password";
$server_name = "107.180.26.65";

$con = mysqli_connect($server_name, $mysql_user, $mysql_pass, $db_name);
if(!$con)
{
  //echo "Connection error..." .mysqli_connect_error();
}
else
	//echo "success";
?>
