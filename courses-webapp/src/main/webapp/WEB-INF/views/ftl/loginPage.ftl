<#assign  security=JspTaglibs["/WEB-INF/tld/spring-security.tld"] />
<!DOCTYPE html>

<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>Please sign in</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-social/5.1.1/bootstrap-social.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

<nav class="navbar navbar-light bg-light navbar-expand-lg">
  <a href="/" class="navbar-brand">courses-application</a>
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
    <@security.authorize access="isAuthenticated()">
      <li class="navbar-item">
        <a href="/account" class="nav-link">
          <@security.authentication property="principal.username"/>
        </a>
      </li>
      <li class="navbar-item">
        <a href="/logout" class="nav-link">Logout</a>
      </li>
    </@security.authorize>
    <@security.authorize access="! isAuthenticated()">
      <li class="navbar-item">
        <a href="/login" class="nav-link">Login</a>
      </li>
    </@security.authorize>
    </ul>
  </div>
</nav>

<div class="container" style="margin-top: 30px;">
  <form method="post" action="/login">
    <h2 class="form-signin-heading">Please sign in</h2>
    <div class="form-group row">
      <label for="username" class="col-sm-2 col-form-label">Username</label>
      <div class="col-sm-4">
        <input type="text" id="username" name="username" class="form-control " placeholder="Username" required="" autofocus="">
      </div>
    </div>

    <div class="form-group row">
      <label for="password" class="col-sm-2 col-form-label">Password</label>
      <div class="col-sm-4">
        <input type="password" id="password" name="password" class="form-control" placeholder="Password" required="">
      </div>
    </div>

    <div class="form-group row">
      <label for="rememer-me" class="col-sm-2 col-form-label">Remember me</label>
      <div class="col-sm-4">
        <input id="rememer-me" type="checkbox" name="remember-me" class="form-control"/>
      </div>
    </div>

    <div class="row">
      <div class="col-sm-6">
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </div>
    </div>
  </form>

  <form action="/signin/facebook" method="post">
    <input type="hidden" name="scope" value="public_profile"/>
    <div class="form-group row" style="margin-top: 30px;">
      <div class="col-sm-4">
        <button class="btn btn-block btn-social-icon btn-lg btn-facebook">
          <i class="fa fa-facebook"></i>
        </button>
      </div>
    </div>
  </form>

</div>
</body>
</html>
