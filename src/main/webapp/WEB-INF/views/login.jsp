<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>


<t:genericpage>
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <h3>Giriş Yap</h3> <br>

                <c:if test="${not empty error}">
                    <div class="alert alert-danger alert-dismissible" role="alert">
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
                                aria-hidden="true">&times;</span></button>
                        <strong>Hata!</strong> ${error}
                    </div>
                </c:if>

                <c:if test="${not empty msg}">
                    <div class="alert alert-info alert-dismissible" role="alert">
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
                                aria-hidden="true">&times;</span></button>
                            ${msg}
                    </div>
                </c:if>

                <div class="account-wall">

                    <form action="<c:url value='/login' />" method='POST'>
                        <input type="text" name="username" class="form-control" id="username"
                               placeholder="Kullanıcı Adı"> <br>
                        <input type="password" name="password" class="form-control" id="password"
                               placeholder="Parola"> <br>
                        <button class="btn btn-lg btn-primary btn-block" type="submit">
                            Giriş Yap
                        </button>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    </form>
                </div>

            </div>
        </div>
    </div>
</t:genericpage>