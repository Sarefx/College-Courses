<?php

session_start();
$quantity = $_POST["quantity"];

$_SESSION["quantity"] = $quantity;

//echo "SUCCESS!!!!";
header("Location:shoppingCart.php");
exit();
 ?>
