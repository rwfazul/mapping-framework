<%-- 
    Document   : menu
    Created on : Oct 26, 2017, 6:35:49 PM
--%>

<%@tag description="cria navbar base" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="id" required="true" %>

<%-- any content can be specified here e.g.: --%>
<nav class="navbar" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#menu" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">
                <img src="img/logo-branco.png" alt="Doa Mais" class="navbar-img" width="98px">
            </a>
        </div>
        <div class="collapse navbar-collapse" id="menu">
            <ul class="nav navbar-nav">
                <li id="home"><a href="#">Visualizar palestras</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">                
                <li class="dropdown" id="more">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-plus" aria-hidden="true"></i>
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li id="novoagendamento"><a href="nova-palestra.jsp">Nova palestra</a></li>
                    </ul>
                </li>
            </ul>
        </div>  
    </div> <!-- ./container -->
</nav>

<script>
    document.getElementById("${id}").setAttribute("class", "active");
</script>