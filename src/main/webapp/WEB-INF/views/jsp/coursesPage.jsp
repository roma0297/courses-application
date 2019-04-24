<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Required meta tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-social/5.1.1/bootstrap-social.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>Courses</title>
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
            <li class="navbar-item">
                <c:choose>
                    <c:when test="${not empty pageContext.request.userPrincipal}">
                        <a href="/account" class="nav-link">${pageContext.request.userPrincipal.name}</a>
                    </c:when>
                    <c:otherwise>
                        <a href="/login" class="nav-link">Login</a>
                    </c:otherwise>
                </c:choose>
            </li>
            <li class="navbar-item">
                <a href="/logout" class="nav-link">Logout</a>
            </li>
        </ul>
    </div>
</nav>


<div class="container" style="margin-top: 30px;">
    <div class="card-deck">
        <c:forEach items="${courses}" var="course">
            <div class="card mb-4" style="min-width: 18rem; max-width: 18rem;">
                <div class="card-body">
                    <h5 class="card-title">${course.name}</h5>
                    <p class="card-text">${course.description}</p>
                </div>
                <div class="card-body">
                    <span class="fa fa-usd"> ${course.price}</span>
                </div>
                <div class="card-body">
                    <a href="/courses/${course.id}" class="btn btn-dark">Read more</a>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</div>

</body>
</html>
