<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Required meta tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-social/5.1.1/bootstrap-social.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <title></title>
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
            <c:choose>
                <c:when test="${not empty pageContext.request.userPrincipal}">
                    <li class="navbar-item">
                        <a href="/account" class="nav-link">${pageContext.request.userPrincipal.name}</a>
                    </li>
                    <li class="navbar-item">
                        <a href="/logout" class="nav-link">Logout</a>
                    </li>
                </c:when>
                <c:otherwise>
                    <a href="/login" class="nav-link">Login</a>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
</nav>

<div class="container">
    <form:form method="post" action="/signup" modelAttribute="signUpForm">
        <h2 class="form-signin-heading">Please sign up</h2>
        <div class="form-group row">
            <label for="email" class="col-sm-2 col-form-label">Email</label>
            <div class="col-sm-4">
                <form:input path="email" type="text" id="email" name="email" class="form-control " placeholder="email" required="" autofocus=""/>
            </div>
        </div>

        <c:if test="${!isSocialUser}">
            <div class="form-group row">
                <label for="password" class="col-sm-2 col-form-label">Password</label>
                <div class="col-sm-4">
                    <form:input path="password" type="password" id="password" name="password" class="form-control " placeholder="Password" required="" autofocus=""/>
                </div>
            </div>

            <div class="form-group row">
                <label for="checkPassword" class="col-sm-2 col-form-label">Repeat password</label>
                <div class="col-sm-4">
                    <form:input path="checkPassword" type="password" id="checkPassword" name="checkPassword" class="form-control " placeholder="Password" required="" autofocus=""/>
                </div>
            </div>
        </c:if>

        <div class="form-group row">
            <label for="firstName" class="col-sm-2 col-form-label">First name</label>
            <div class="col-sm-4">
                <form:input path="firstName" type="text" id="firstName" name="firstName" class="form-control " placeholder="First name" required="" autofocus=""/>
            </div>
        </div>

        <div class="form-group row">
            <label for="lastName" class="col-sm-2 col-form-label">Last name</label>
            <div class="col-sm-4">
                <form:input path="lastName" type="text" id="lastName" name="lastName" class="form-control " placeholder="Last name" required="" autofocus=""/>
            </div>
        </div>

        <div class="row">
            <div class="col-sm-6">
                <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
            </div>
        </div>
    </form:form>
</div>


</body>
</html>
