<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Admin Page</title>
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
        <a href="logOut.php">Log Out</a>
      </div>
    </div>
  </header>

  <div class="normalPanel" id="adminPagePanel">
    <div>
      <h1>Welcome <?php include 'session.php'; echo $username; ?>!</h1>
      <p>This is the admin page. Select the items you would like to modify below.</p>
    </div>
    <form action="processChange.php" method="post" id="form6">
      <?php
      require "database.php";

      $sql = "select id, name, price, inventory from beverages";
      $result = mysqli_query($con,$sql);
      $count = 0;
      if(mysqli_num_rows($result)>0){
        while ($row =$result-> fetch_assoc()) {
          $count++;
          echo "<input type='checkbox' name='adminSelection[]' value='".$row["id"]."'>".$count.". ".$row["name"] . " Price:".$row["price"]." Quantity:" .$row["inventory"];
          echo "<br><br>";
        }
      }
      ?>
    </form>
    <button type="submit" form="form6" class="submit" value="Submit">Update</button>


  </div>
</div>
</body>
</html>
