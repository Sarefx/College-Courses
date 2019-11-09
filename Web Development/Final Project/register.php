<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Register Page</title>
  <link rel="stylesheet" href="css.css">
</head>
<body class="normalPage">
  <header>
  </header>
  
  <div class="normalPanel" id="registerPanel">
    <h2 class="signin">Register</h2>
    <form action="registerCheck.php" method="post" id="registerForm">
      <br>
      <input type="text" class="username" name="nameReg" placeholder="first name">
      <br>
      <br>
      <input type="text" class="username" name="userNameReg" placeholder="username">
      <br>
      <br>
      <input type="password" class="password" name="passwordReg" placeholder="password"><br>
    </form>
    <button type="submit" form="registerForm" class="submit" value="Submit">Submit</button>

  </div>


</body>
</html>
