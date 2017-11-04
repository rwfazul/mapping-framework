<%-- 
    Document   : campo-editar
    Created on : Oct 26, 2017, 3:51:33 PM
--%>

<%@tag description="cria bloco de edicao dos inputs e labels do formulario" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="label" required="true" %>
<%@attribute name="valor" required="true" %>

<%-- any content can be specified here e.g.: --%>
<div class="bloco-info">
    <span class="bloco-label">${label}</span>
    <span class="bloco-valor">${valor}</span>
    <button class="btn btn-link">Editar</button> <!-- modal que pede senha -->
</div>
