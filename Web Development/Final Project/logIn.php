<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Log In Page</title>
    <link rel="stylesheet" href="css.css">
  </head>
  <body class="normalPage">
    <header>
    </header>

    <div class="normalPanel" id="logInPanel">
      <h2 class="signin">Sign in</h2>
      <form action="processLogIn.php" method="post" id="form1">
        <br>
        <input type="text" class="username" name="userName" placeholder="username"><br>
        <br>
        <input type="password" class="password" name="password" placeholder="password"><br>
      </form>
      <button type="submit" form="form1" class="submit" value="Submit">Submit</button>

      <form action="register.php" method="post" id="form2">

      <button type="submit" form="form2" class="submit" value="Submit">Register Here</button>

    </div>


  </body>
</html>
