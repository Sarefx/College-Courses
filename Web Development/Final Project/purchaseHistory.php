<!DOCTYPE html>
<html>
<head>
  <title>Purchase History</title>
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

  <div class="normalPanel" id="purchaseHistoryPanel1">
    <table>
      <tr>
        <th>Purchase ID</th>
        <th>Drinks Sold</th>
        <th>Total Sale</th>
        <th>Date</th>
      </tr>

      <?php
      require "database.php";
      include "session.php";

      $sql = "SELECT * from TotalPurchaseRecord where customerID = $userID";
      $result = mysqli_query($con,$sql);
      if(mysqli_num_rows($result)>0){
        while ($row = mysqli_fetch_assoc($result)) {

          echo "<tr><td>" . $row["id"]. "</td><td>" . $row["drinksSold"] . "</td><td>$" . $row["totalSale"] . "</td><td>". $row["date"]. "</td></tr>";
        }
        echo "</table>";
      }
      else {
        echo "0 results";
      }

      ?>
    </table>
  </div>

  <div class="normalPanel" id="purchaseHistoryPanel2">
    <table>
      <tr>
        <th>Purchase ID</th>
        <th>Drink Name</th>
        <th>Quantity</th>
      </tr>
      <?php
      $sql4 = "SELECT * from TotalPurchaseRecord where customerID = $userID";
      $result4 = mysqli_query($con,$sql4);
      if(mysqli_num_rows($result4)>0)
      {
        while ($row4 = mysqli_fetch_assoc($result4))
        {
          $purchaseID = $row4['id'];
          $sql2 = "SELECT * from PurchaseHistory where purchaseID = $purchaseID";
          $result2 = mysqli_query($con,$sql2);

          if(mysqli_num_rows($result2)>0)
          {
            while ($row2 = mysqli_fetch_assoc($result2))
            {
              $drinkID = $row2["beverageID"];
              $sql3 = "SELECT * from beverages where id = $drinkID";
              $result3 = mysqli_query($con,$sql3);
              $row3 = $result3-> fetch_assoc();
              echo "<tr><td>" . $row2["purchaseID"]. "</td><td>" . $row3["name"] . "</td><td>" . $row2["quantity"] . "</td></tr>";
            }
          }
          else
          {
            echo "0 results";
          }
        }
        echo "</table>";
      }
      else {
        echo "0 results";
      }
      ?>
    </table>
  </div>
</body>
</html>
