<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<jsp:useBean id="dateValue" class="java.util.Date"/>


<t:genericpage>
    <div class="container">
        <div class="row">
            <div class="col-md-10 col-md-offset-1">

                <a class="btn btn-primary" href="/admin/daire/ekle">Daire Ekle</a> <br><br>

                <table class="table table-striped">
                    <tr class="koyu_mavi">
                        <th>Daire No</th>
                        <th>Giriş Tarihi</th>
                        <th>Çıkış Tarihi</th>
                        <th>Oda Sayısı</th>
                        <th>Blok</th>
                        <th>İşlemler</th>
                    </tr>
                    <c:forEach var="daire" items="${daireler}">
                        <tr>
                            <td>${daire.daireNo}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${daire.girisTarihi == null}">
                                        -
                                    </c:when>
                                    <c:otherwise>
                                        ${daire.girisTarihi}
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${daire.cikisTarihi == null}">
                                        -
                                    </c:when>
                                    <c:otherwise>
                                        ${daire.cikisTarihi}
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td>${daire.odaSayisi}</td>
                            <td>${daire.blok.blokAdi}</td>
                            <td>
                                <a href="/admin/daire/${daire.id}/kirala"
                                   class="btn btn-primary <c:if test="${daire.cikisTarihi != null}">disabled</c:if>">Kirala</a>
                                <a href="/admin/daire/${daire.id}/guncelle" class="btn btn-primary">Güncelle</a>
                                <a href="/admin/daire/${daire.id}/sil" class="btn btn-danger">Sil</a>
                            </td>
                        </tr>
                    </c:forEach>

                </table>

            </div>
        </div>
    </div>
</t:genericpage>
