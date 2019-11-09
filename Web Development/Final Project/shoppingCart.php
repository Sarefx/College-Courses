<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Shopping Cart Page</title>
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

  <div class="normalPanel" id="shoppingCartPanel">
    <form action="processShoppingCart.php" method="post" id="form11">
      <input type="hidden" name="act3" value="run">
    <h2>Shopping Cart</h2>
    <?php
    include "session.php";
    require "database.php";
    if(!empty($selection))
    {
      echo "<form action='processShoppingCart.php' method='post' id='form11'>
            <input type='hidden' name='act3' value='run'>
            <h3>You have the following items in your cart: </h3>";
      $count = 0;
      $total = 0;


      foreach($selection as $item)
      {
        $count++;
        $sql = "SELECT name, price, inventory from beverages where id = $item";

        $result = mysqli_query($con,$sql);
        $row = $result-> fetch_assoc();
        echo "<br>".$row["name"]." Price: $".$row["price"]." ";
        echo "Amount: <input type='number' id='".$count."' name='quantity[]' value='".$quantity[$count-1]."' min='0' max='".$row["inventory"]."'>";
        $total += $row["price"] * $quantity[$count-1];
      }
      echo "<br> The total will be $".$total;
      ?>
        </form>
        <button type="submit" form="form11" class="submit" value="Submit">Update</button>

      <?php
      if (!empty($_GET['act1'])) {
        header("Location:checkOut.php");
        exit();
      }
      echo '<form action="shoppingCart.php" method="get" id="form4">
        <input type="hidden" name="act1" value="run">
      </form>
      <button type="submit" form="form4" class="submit" value="Submit">Check Out</button>';
      if (!empty($_GET['act2'])) {
        $_SESSION["selection"] = 0;
        header("Location:shoppingCart.php");
        exit();
      }
      echo '<form action="shoppingCart.php" method="get" id="form5">
        <input type="hidden" name="act2" value="run">
      </form>
      <button type="submit" form="form5" class="submit" value="Submit">Remove All Items</button>';



    echo "<br>";
    /*
    foreach($selectionID as $itemID)
    {

      echo "ID is ".$item;
      echo "<br>";
    }

    foreach($selectionQuantity as $itemQuantity)
    {

      echo "Quantity is ".$itemQuantity;
      echo "<br>";
    }


    foreach($selection as $item)
    {

      foreach($item as $option)
      {
      echo "ID is ".$option['id'];
      echo "Quantity is ".$option['quantity'];
      echo "<br>";
    }
    }
    */



    }
    else
    {
      echo "Please select at least one beverage";
    }




    ?>
  </div>


  <script>


  function updatePage(){
    for (i=1; 1<10;i++)
    {


        if (document.getElementById(i+"qu") > 0)
        {
          document.getElementById("forTest").innerHTML += "ID is " + document.getElementById(i+"id").value +" Quantity is " + document.getElementById(i+"qu");
        }


    }
  }
  </script>

</body>
</html>
