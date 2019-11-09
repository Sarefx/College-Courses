<?php require "database.php";


//$sql = "select name, price, inventory from beverages";

$username = $_POST["userName"];
$password = $_POST["password"];

session_start();

$_SESSION['selection'] = 0;
$_SESSION['quantity'] = 0;
$_SESSION['totalPrice'] = 0;
$_SESSION['totalQuantity'] = 0;
$_SESSION['adminSelection'] = 0;


$query = "SELECT * from Customers where userName = '$username' and password = '$password'";

$result = mysqli_query($con, $query);

if(mysqli_num_rows($result) > 0)
{
	$row=$result->fetch_assoc();
	$_SESSION['username'] = $row["username"];
	$_SESSION['userID'] = $row["id"];



	$_SESSION['privilege'] = $row["Admin"];

	if($row["Admin"]==1){
		header("Location:adminPage.php");
	}else{
  echo "SUCCESS!!!!";
  header("Location:homePage.php");
  exit();
	}
}
else {
  echo "Log in wasnt successful";
  header("Location:logIn.php");
  exit();

}
?>
