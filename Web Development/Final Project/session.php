<?php
session_start();
$username = $_SESSION["username"];
$userID = $_SESSION["userID"];
$selection = $_SESSION["selection"];
$quantity = $_SESSION["quantity"];


$totalPrice = $_SESSION["totalPrice"];
$totalQuantity = $_SESSION["totalQuantity"];

$adminSelection = $_SESSION["adminSelection"];
$privilege = $_SESSION["privilege"];
 ?>
