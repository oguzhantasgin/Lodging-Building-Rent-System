<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>


<t:genericpage>
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">

                <form:form acceptCharset="UTF-8" method="POST" modelAttribute="daire" action="/admin/daire">
                    <form:input type="hidden" path="id" id="id"/>

                    <div class="form-group">
                        <label for="daireNo">Daire No</label>
                        <form:input cssClass="form-control" path="daireNo" id="daireNo" readonly="true"/>
                    </div>

                    <div class="form-group">
                        <label for="odaSayisi">Oda Sayısı</label>
                        <form:input cssClass="form-control" path="odaSayisi" id="odaSayisi" readonly="true"/>
                    </div>

                    <div class="form-group">
                        <label for="blok.id">Blok</label>
                        <form:select path="blok.id" class="form-control" readonly="true" >
                            <form:option value="-1" label="-- Blok Seçiniz --"/>
                            <form:options items="${bloklar}" itemValue="id" itemLabel="blokAdi" />
                        </form:select>
                    </div>

                    <div class="form-group">
                        <label for="girisTarihi">Giriş Tarihi</label>
                        <form:input cssClass="form-control" path="girisTarihi" id="girisTarihi"/>
                    </div>

                    <div class="form-group">
                        <label for="cikisTarihi">Çıkış Tarihi</label>
                        <form:input cssClass="form-control" path="cikisTarihi" id="cikisTarihi"/>
                    </div>

                    <input type="submit" name="submit" class="btn btn-primary" value="Kirala">
                </form:form>

            </div>
        </div>
    </div>
</t:genericpage>
