<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="css.css">
  </head>
  <body >
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
      <a href="logOut.php">Log Out</a>
  </div>
</div>
</header>


      <?php
      include "session.php";
      require "database.php";
      if(!empty($adminSelection))
      {
        foreach($adminSelection as $item)
        {

			$priceUpdate = $_POST["priceChange".$item];
			echo "a: ".$priceUpdate;
			$stockUpdate = $_POST["stockChange".$item];
                  $sql = "UPDATE beverages SET price=$priceUpdate, inventory=$stockUpdate WHERE id= $item";
                  if (mysqli_query($con, $sql)) {
                    //echo "Record updated successfully";
                  } else
                  {
                    //echo "Error updating record: " . mysqli_error($conn);
                  }
        }
      }else{
		  echo "empty";
	  }
      $_SESSION["adminSelection"] = null;
      ?>
      <div>
      <p> Thank you for the purchase!</p>
      <a href="adminPage.php">Clean me to return to a adminPage</a>
      </div>
  </body>
</html>
