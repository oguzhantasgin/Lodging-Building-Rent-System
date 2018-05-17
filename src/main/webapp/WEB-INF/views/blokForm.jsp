<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<t:genericpage>
    <div class="container">
        <div class="row">
            <div class="col-md-6 col-md-offset-3">

                <form:form acceptCharset="UTF-8" method="POST" modelAttribute="blok" action="/admin/blok">
                    <form:input type="hidden" path="id" id="id"/>

                    <div class="form-group">
                        <label for="blokAdi">Blok Adı</label>
                        <form:input cssClass="form-control" path="blokAdi" id="blokAdi"/>
                    </div>

                    <div class="form-group">
                        <label for="daireSayisi">Daire Sayısı</label>
                        <form:input cssClass="form-control" path="daireSayisi" id="daireSayisi"/>
                    </div>

                    <input type="submit" name="submit" class="btn btn-primary" value="Kaydet">
                </form:form>
            </div>
        </div>
    </div>
</t:genericpage>
