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
    <div class="collapse" id="navbarToggleExternalContent">
        <div class="bg-dark p-4">
            <h5 class="text-white h4">EdExt Mobile</h5>
            <ul class="navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link text-white" href="/EdExtMobile/Home">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white" href="/EdExtMobile/Logout">Logout</a>
                </li>
            </ul>
        </div>
    </div>
    <nav class="navbar navbar-dark bg-dark">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarToggleExternalContent" aria-controls="navbarToggleExternalContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <span class="navbar-brand mb-0 h1"><%= du.getEmail()%></span>
    </nav>
</header>
