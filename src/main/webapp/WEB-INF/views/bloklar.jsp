<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<t:genericpage>
    <div class="container">
        <div class="row">
            <div class="col-md-10 col-md-offset-1">

                <a class="btn btn-primary" href="/admin/blok/ekle">Blok Ekle</a> <br><br>

                <table class="table table-striped">
                    <tr class="koyu_mavi">
                        <th>Blok Adı</th>
                        <th>Daire Kapasitesi</th>
                        <th>İşlemler</th>
                    </tr>
                    <c:forEach var="blok" items="${bloklar}">
                        <tr>
                            <td>${blok.blokAdi}</td>
                            <td>${blok.daireSayisi}</td>
                            <td>
                                <a href="/admin/blok/${blok.id}/guncelle" class="btn btn-primary">Güncelle</a>
                                <a href="/admin/blok/${blok.id}/sil" class="btn btn-danger">Sil</a>
                            </td>
                        </tr>
                    </c:forEach>

                </table>

            </div>
        </div>
    </div>
</t:genericpage>
