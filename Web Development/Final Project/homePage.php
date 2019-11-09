<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Home Page</title>
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

  <div class="normalPanel" id="homePagePanel">
      <h1>Welcome <?php include 'session.php'; echo $username; ?>!</h1>
      <p class="rText">This is our cool, but humble beverage shop. You will find here the most delcious drinks that will ever touch your lips.</p>
      <p class="rText">Please shop and enjoy our products!</p>
  </div>

</body>
</html>
