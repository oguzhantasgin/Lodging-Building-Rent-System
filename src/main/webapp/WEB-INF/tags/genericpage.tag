<%@tag pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Lojman Takip</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Lojman Yönetim Sistemi</a>
        </div>

        <ul class="nav navbar-nav">
            <li><a href="/">Anasayfa</a></li>
            <li><a href="/admin/"> Yönetim Paneli </a></li>
        </ul>

        <sec:authorize var="loggedIn" access="isAuthenticated()"/>
        <c:choose>
            <c:when test="${loggedIn}">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <script>
                            function formSubmit() {
                                document.getElementById("logoutForm").submit();
                            }
                        </script>

                        <a href="javascript:formSubmit()"><span class="glyphicon glyphicon-log-out"></span> Çıkış Yap</a>
                    </li>
                </ul>
            </c:when>
            <c:otherwise>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Giriş Yap </a></li>
                </ul>
            </c:otherwise>
        </c:choose>

    </div>
</nav>

<form action="<c:url value="/logout" />" method="POST" id="logoutForm">
    <input type="hidden" name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
</form>

<div id="body">
    <jsp:doBody/>
</div>

<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>