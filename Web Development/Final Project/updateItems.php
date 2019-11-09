<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="css.css">
  </head>
  <body>
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
	<form action="sendUpdate.php" method="POST">
<?php
      include "session.php";
      require "database.php";

      if(!empty($adminSelection))
      {
        foreach($adminSelection as $item)
        {
		$sql = "select id, name, price, inventory from beverages where id=$item";
		$result = mysqli_query($con,$sql);
		$count = 0;
		if(mysqli_num_rows($result)>0){
		while ($row =$result-> fetch_assoc()) {
		echo "ID:".$row["id"]." name: ".$row["name"]." price:".$row["price"]." Quantity:".$row["inventory"];
        echo "<br>";
		echo "<input type='text' name='priceChange".$row["id"]."'> New Price(Write old price if unchanged)";
		echo "<br>";
		echo "<input type='text' name='stockChange".$row["id"]."'> New Quantity(Write old quantity if unchanged)";
        }
      }
		}
	  }
      ?>
	  <input type="submit">
	  </form>
  </body>
</html>
