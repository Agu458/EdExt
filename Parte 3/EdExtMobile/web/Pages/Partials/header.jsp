<%-- 
    Document   : header
    Created on : 9 nov. 2020, 14:23:00
    Author     : Agustín
--%>

<%@page import="Server.DataUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    DataUsuario du = (DataUsuario) session.getAttribute("usuario");
%>

<header>
    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary" id="mainNav">
        <div class="container">
            <a class="navbar-brand js-scroll-trigger" href="/EdExtMobile/Home">EdExt</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link js-scroll-trigger" href="/EdExtMobile/Home"><i class="fas fa-home"></i> Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link js-scroll-trigger" href="/EdExtMobile/Logout"><i class="fas fa-door-open"></i> Salir</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link js-scroll-trigger" href="#"><i class="fas fa-user"></i> Perfil</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>
