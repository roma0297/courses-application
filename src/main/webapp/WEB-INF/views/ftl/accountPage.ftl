<#assign  security=JspTaglibs["/WEB-INF/tld/spring-security.tld"] />

<!doctype html>
<html lang="en">
<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-social/5.1.1/bootstrap-social.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <title>Account page</title>
</head>
<body>

<nav class="navbar navbar-light bg-light navbar-expand-lg">
  <a href="#" class="navbar-brand">courses-application</a>
  <button class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarCollapse">
    <ul class="navbar-nav">
      <li class="navbar-item">
        <a href="/courses" class="nav-link">Courses</a>
      </li>
    </ul>
    <ul class="navbar-nav ml-auto">
      <li class="navbar-item">
      <@security.authorize access="isAuthenticated()">
        <a href="/account" class="nav-link">
          <@security.authentication property="principal.username"/>
        </a>
      </@security.authorize>
      <@security.authorize access="! isAuthenticated()">
        <a href="/login" class="nav-link">Login</a>
      </@security.authorize>
      </li>
      <li class="navbar-item">
        <a href="/logout" class="nav-link">Logout</a>
      </li>
    </ul>
  </div>
</nav>

<div class="container" style="margin-top:30px;">

</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</body>
</html>