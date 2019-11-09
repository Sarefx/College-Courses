<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Beverages Page</title>
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

  <div class="normalPanel" id="beveragesPanel">
    <form action="processBeverages.php" method="post" id="form3">
      <h1>Drinks</h1>
      <?php
      require "database.php";
      $sql = "select id, name, price, inventory from beverages";
      $result = mysqli_query($con,$sql);
      $count = 1;

      if(mysqli_num_rows($result)>0){
        while ($row =$result-> fetch_assoc()) {
          //"<input type='checkbox' name='selection[]' value='".$row["id"]."'>".$count.". ".$row["name"] . " Price: $".$row["price"]." Quantity: " .$row["inventory"];

          echo "<input type='checkbox' name='selection[]' value='".$row["id"]."'>".$count.". ".$row["name"]." Price: $".$row["price"]." Quantity: ".$row["inventory"]."";
          //echo "Select Amount: <input type='number' name='selection[]['quantity']' min='0' max=".$row['inventory'].">";
          //echo "<input type='checkbox' id='".$count."id' name='id' value='".$row["id"]."'>".$count.". ".$row["name"]." Price: $".$row["price"]." Quantity: ".$row["inventory"]."";
          //echo "Select Amount: <input type='number' id=".$count."qu' name='quantity' min='0' max=".$row['inventory'].">";
          echo "<br><br>";
          $count++;
        }
      }

      ?>

    </form>
    <button type="submit" form="form3" class="submit" value="Submit">Submit</button>
    <!--
    <button type="submit" onclick="updatePage();" value="Submit" class="submit">Update</button>
    <p id="forTest"><p>
    -->
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
