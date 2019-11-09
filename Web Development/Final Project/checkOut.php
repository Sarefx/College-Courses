<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Check Out Page</title>
  <link rel="stylesheet" href="css.css">
</head>
<body class="normalPage">
  <header>
    <div class="nav">
      <div class="nav-header">
        <div class="nav-title">
          Beverage Shop
        </div>
      </div>
      <div class="nav-links">
        <a href="homePage.php">Home</a>
        <a href="beverages.php">Beverages</a>
        <a href="shoppingCart.php">Shopping Cart</a>
        <a href="purchaseHistory.php">Purchase History</a>
        <a href="logOut.php">Log Out</a>
      </div>
    </div>
  </header>

  <div class="normalPanel" id="checkOutPanel">
    <?php
    include "session.php";
    require "database.php";

    if(!empty($selection))
    {
      $count = 0;
      $totalPrice = 0;
      $totalQuantity = 0;
      foreach($selection as $item)
      {
        $sql = "SELECT name, price, inventory from beverages where id = $item";
        $result = mysqli_query($con,$sql);
        $row = $result-> fetch_assoc();
        $totalPrice += $row["price"] * $quantity[$count];
        $totalQuantity += $quantity[$count];
        $count++;

      }
      echo "<h1>Check Out</h1>
      <p> The total will be $".$totalPrice."</p>";
    }
    $_SESSION['totalPrice'] = $totalPrice;
    $_SESSION['totalQuantity'] = $totalQuantity;

    ?>

    <form action="processCheckOut.php" method="post" id="form8">
      Enter Credit Card Number:<br>
      <input type="text" name="creditcard"><br>

    </form>
    <button type="submit" form="form8" class="submit" value="Submit">Submit</button>

  </div>


</body>
</html>
