<%-- 
    Document   : head
    Created on : 15 oct. 2020, 13:21:22
    Author     : Agustin
--%>

<%@page import="Logica.ISistema"%>
<%@page import="java.util.List"%>
<%@page import="Logica.Fabrica"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
    
    <%
        ISistema is = Fabrica.getInstance().getISistema();
        List<String> institutos = is.listarInstitutos();
    %>
    
    <!-- Basic -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">   

    <!-- Mobile Metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Site Metas -->
    <title>EduExt - Home</title>  
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Site Icons -->
    <link rel="shortcut icon" href="http://localhost:8080/WebEduExt/Partials/images/favicon.jpg" type="image/x-icon" />
    <link rel="apple-touch-icon" href="http://localhost:8080/WebEduExt/Partials/images/favicon.jpg">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="http://localhost:8080/WebEduExt/Partials/css/bootstrap.min.css">
    <!-- Site CSS -->
    <link rel="stylesheet" href="http://localhost:8080/WebEduExt/Partials/style.css">
    <!-- ALL VERSION CSS -->
    <link rel="stylesheet" href="http://localhost:8080/WebEduExt/Partials/css/versions.css">
    <!-- Responsive CSS -->
    <link rel="stylesheet" href="http://localhost:8080/WebEduExt/Partials/css/responsive.css">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="http://localhost:8080/WebEduExt/Partials/css/custom.css">

    <!-- Modernizer for Portfolio -->
    <script src="http://localhost:8080/WebEduExt/Partials/js/modernizer.js"></script>

    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>

