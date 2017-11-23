<%-- 
    Document   : gerenciarPalestras
    Created on : 23/11/2017, 01:37:11
    Author     : isabella
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container-fluid">
    <div class="row">
        <h1>Lista de palestras</h1>
        <table class="table table-bordered table-striped table-hover">
            <thead>
                <tr>
                    <th>Evento</th>
                    <th>Título</th>
                    <th>Palestrante</th>
                    <th>Data</th>
                </tr>
            </thead>
            <tbody>                
                <c:forEach var="evento" items="${eventos}">
                    <c:forEach var="palestra" items="${evento.palestras}">
                        <tr>
                            <td>${evento.nome}</td>
                            <td>${palestra.titulo}</td>
                            <td>${palestra.palestrante.nome}</td>
                            <td>${palestra.data}</td>
                        </tr>
                    </c:forEach>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div> 
