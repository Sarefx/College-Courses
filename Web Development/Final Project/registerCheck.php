<?php require "database.php";


//$sql = "select name, price, inventory from beverages";

$usernameReg = $_POST["userNameReg"];
$passwordReg = $_POST["passwordReg"];
$nameReg = $_POST["nameReg"];

$sqlQ = "Select userName from customers";

$rs = mysqli_query($con,$sqlQ);
$data = mysqli_fetch_array($rs, MYSQLI_NUM);
if($data[0] > 1) {
  echo "User Already in Exists<br/>";
}
else{
  $sqlI = "INSERT INTO Customers VALUES (
    Null,
    '$nameReg',
    '$usernameReg',
    '$passwordReg',
    '0')";


    if(mysqli_query($con, $sqlI))
    {
      sleep(2);
      header("Location:logIn.php");
      exit();
    }
    else
    {

    }
  }
  //$result = mysqli_query($con,$sql);
  //$count = 0;
  //if(mysqli_num_rows($result)>0){
  //while ($row =$result-> fetch_assoc()) {
  //echo "<input type='checkbox' name='selection[]' value='".$row["name"]."'>".$count.". ".$row["name"] . "Price: ".$row["price"]."Quantity: " .$row["inventory"];
  //$count++;
  //echo "<br><br>";
  //}
  //}
  ?>
