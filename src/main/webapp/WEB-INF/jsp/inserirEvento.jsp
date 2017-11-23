<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="t" %>  

<script src="js/tabs-navegation.js"></script>

<div class="container-fluid">
    <div class="row">
        <ul class="nav nav-tabs nav-justified"> 
            <li id="tab_evento" class="active"><a>Dados do evento</a></li>
            <li id="tab_local"><a>Dados do local</a></li>
            <li id="tab_palestras"><a>Palestras</a></li>
        </ul>
        <div class="tab-content">
            <c:choose>
                <c:when test="${not empty eventoUpdate}">
                    <t:tab-evento titulo="Alterar informações do evento"></t:tab-evento>
                </c:when>
                <c:otherwise>
                    <t:tab-evento titulo="Informações do evento"></t:tab-evento>
                    <t:tab-local titulo="Informações do local"></t:tab-local>
                    <t:tab-palestras titulo="Palestras"></t:tab-palestras>
                </c:otherwise>
            </c:choose>  

        </div>
    </div> <!-- ./row -->
</div> <!-- ./container-fluid -->

<script src="js/input-datas.js"></script>
<script src="js/select-predios.js"></script>
<script src="js/evento-objetos.js"></script>
<script src="js/palestras.js"></script>
<script src="js/ajax_evento.js"></script>