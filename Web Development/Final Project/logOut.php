<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Log Out Page</title>
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
  header("Location:logIn.php");
  exit(); ?>



  </body>
</html>
