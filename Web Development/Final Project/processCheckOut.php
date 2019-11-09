<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title></title>
  <link rel="stylesheet" href="css.css">
</head>
<body class="normalPage">
  <header>
  </header>


  <?php
  include "session.php";
  require "database.php";
  if(!empty($selection))
  {
    $today = date_create()->format('Y-m-d H:i:s');

    $sqlI = "INSERT INTO TotalPurchaseRecord VALUES (Null,'$totalQuantity','$totalPrice','$userID','$today')";
    if (mysqli_query($con, $sqlI)) {
    } else
    {
    }
    $last_id = $con->insert_id;
    $purchaseID = $last_id;

    $count = 0;
    foreach($selection as $item)
    {
      $sql = "UPDATE beverages SET inventory = inventory - $quantity[$count] WHERE id= $item";
      if (mysqli_query($con, $sql)) {
      } else
      {
      }
      $sql2 = "INSERT INTO PurchaseHistory VALUES (Null,'$purchaseID','$selection[$count]','$quantity[$count]')";
      if (mysqli_query($con, $sql2)) {
      } else
      {
      }
      $count++;
    }
  }

  $_SESSION["selection"] = null;
  ?>
  <div class="normalPanel" id="processCheckOutPanel">
    <p > Thank you for the purchase!</p>
    <a href="homePage.php">Click me to return to Home page</a>
  </div>
</body>
</html>
