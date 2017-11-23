<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container-fluid">
    <div class="row">
        <h1>Lista de eventos</h1>
        <table class="table table-bordered table-striped table-hover">
            <thead>
                <tr>
                    <th>Nome</th>
                    <th>Prédio</th>
                    <th>Início</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="evento" items="${eventos}">
                    <tr>
                        <td>${evento.nome}</td>
                        <td>${evento.predio.nome}</td>
                        <td><fmt:formatDate pattern="dd/MM/yyyy" value="${evento.dataInicio}" /></td>
                        <td>
                            <a href="palestraServlet?action=list&id_evento=${evento.id}" class="btn btn-info"><i class="fa fa-search-plus" aria-hidden="true"></i></a>
                            <a href="eventoServlet?action=update&id_evento=${evento.id}" class="btn btn-warning"><i class="glyphicon glyphicon-pencil" aria-hidden="true"></i></a>
                            <a href="eventoServlet?action=delete&id_evento=${evento.id}" class="btn btn-danger"><i class=" glyphicon glyphicon-trash" aria-hidden="true"></i></a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <c:if test="${empty eventos}">
        <div class="row">
            <div class="col-md-6 col-md-offset-3">
                <div class="alert alert-warning">
                    <h5 class="text-center"><i class="fa fa-exclamation-circle" aria-hidden="true"></i> Não há eventos cadastrados :(</h5>
                </div>
            </div>
        </div>
    </c:if>
</div> 
