<%-- 
    Document   : gerenciarPalestras
    Created on : 23/11/2017, 01:37:11
    Author     : isabella
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container-fluid">
    <div class="row">
        <h1>Lista de palestras do evento ${evento.nome}</h1>
        <table class="table table-bordered table-striped table-hover">
            <thead>
                <tr>
                    <th>Título</th>
                    <th>Assunto</th>
                    <th>Descrição</th>
                    <th>Palestrante</th>
                    <th>Data</th>
                    <th>Início</th>
                    <th>Fim</th>
                    <th>Ação</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="palestra" items="${palestras}">
                    <tr>
                        <td>${palestra.titulo}</td>
                        <td>${palestra.assunto}</td>
                        <td>${palestra.descricao}</td>
                        <td>${palestra.palestrante.nome}</td>
                        <td>${palestra.data}</td>
                        <td>${palestra.horaInicio}</td>
                        <td>${palestra.horaFim}</td>
                        <td><div class="col-md-6"><a href="palestraServlet?action=update&id_evento=${evento.id}&id_palestra=${palestra.id}" class="btn btn-warning glyphicon glyphicon-pencil"></a></div>
                            <div class="col-md-6"><a href="palestraServlet?action=delete&id_evento=${evento.id}&id_palestra=${palestra.id}" class="btn btn-danger glyphicon glyphicon-trash"></a></div>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div> 
