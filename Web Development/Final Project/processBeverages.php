<?php
session_start();
$_SESSION["selection"] = $_POST["selection"];
$selection = $_POST["selection"];

$count = 0;
foreach($selection as $item)
{
  $quantity[$count] = 1;
  $count++;
}
$_SESSION["quantity"] = $quantity;
echo "SUCCESS!!!!";
header("Location:shoppingCart.php");
exit();
 ?>
