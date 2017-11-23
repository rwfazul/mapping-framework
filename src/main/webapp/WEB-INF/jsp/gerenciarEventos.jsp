<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container-fluid">
    <div class="row">
        <h1>Lista de eventos</h1>
        <table class="table table-bordered table-striped table-hover">
            <thead>
                <tr>
                    <th>Nome</th>
                    <th>Descrição</th>
                    <th>Endereço</th>
                    <th>Prédio</th>
                    <th>Início</th>
                    <th>Fim</th>
                    <th>Ação</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="evento" items="${eventos}">
                    <tr>
                        <td>${evento.nome}</td>
                        <td>${evento.descricao}</td>
                        <td>${evento.endereco}</td>
                        <td>${evento.predio.nome}</td>
                        <td>${evento.dataInicio}</td>
                        <td>${evento.dataFim}</td>
                        <td><div class="col-md-6"><a href="palestraServlet?action=list&id_evento=${evento.id}" class="btn btn-info glyphicon glyphicon-duplicate"> Palestras</a></div>
                            <div class="col-md-3"><a href="eventoServlet?action=update&id_evento=${evento.id}" class="btn btn-warning glyphicon glyphicon-pencil"></a></div>
                            <div class="col-md-3"><a href="eventoServlet?action=delete&id_evento=${evento.id}" class="btn btn-danger glyphicon glyphicon-trash"></a></div>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div> 
