<?php

session_start();
$adminSelection = $_POST["adminSelection"];
$_SESSION["adminSelection"] = $adminSelection;
echo "SUCCESS!!!!";

header("Location:updateItems.php");
exit();
 ?>