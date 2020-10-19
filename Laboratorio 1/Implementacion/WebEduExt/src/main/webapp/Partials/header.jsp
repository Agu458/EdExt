<%-- 
    Document   : header
    Created on : 15 oct. 2020, 13:23:11
    Author     : Agustin
--%>

<%@page import="DataTypes.DataUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- Modal -->
<div class="modal fade" id="login" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header tit-up">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">INGRESAR COMO USUARIO</h4>
            </div>
            <div class="modal-body customer-box">
                <!-- Nav tabs -->
                <ul class="nav nav-tabs">
                    <li><a class="active" href="#Login" data-toggle="tab">INGRESAR</a></li>
                    <li><a href="#Registration" data-toggle="tab">REGISTRARSE</a></li>
                </ul>
                <!-- Tab panes -->
                <div class="tab-content">
                    <div class="tab-pane active" id="Login">
                        <form role="form" class="form-horizontal" action="Login" method="POST">
                            <div class="form-group">
                                <div class="col-sm-12">
                                    <input class="form-control" id="exampleInputPassword1" placeholder="Email" type="email" name="email">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-12">
                                    <input class="form-control" id="password" placeholder="Password" type="password" name="password">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-10">
                                    <button type="submit" class="btn btn-dark btn-radius btn-brd grd1">
                                        Ingresar
                                    </button>
                                    <a class="for-pwd" href="#">Olvidaste tu contraseña?</a>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="tab-pane" id="Registration">
                        <form role="form" class="form-horizontal" action="Registrarse" method="POST" >
                            <div class="form-group">
                                <div class="col-sm-12">
                                    <input class="form-control" id="nick" type="text" placeholder="Nick" name="nick" required>
                                    <div class="alert alert-danger" id="nickValido" role="alert"> El nick se encuentra en uso ... </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-12">
                                    <input class="form-control" type="text" placeholder="Nombre" name="nombre" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-12">
                                    <input class="form-control" type="text" placeholder="Apellido" name="apellido" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-12">
                                    <input class="form-control" type="email" placeholder="Email" name="email" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-12">
                                    <input class="form-control" type="password" placeholder="Password" name="password" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-12">
                                    <input class="form-control" type="password" placeholder="Retype Password" name="password2" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-12">
                                    <input class="form-control" type="date" name="fecha" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-12">
                                    <label for="#docente" >Es Docente?</label>
                                    <input class="form-control" id="docente" type="checkbox" name="docente">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-12">
                                    <select class="form-control" id="selinsti" name="instituto"></select>
                                </div>
                            </div>
                            <div class="row">							
                                <div class="col-sm-10">
                                    <button type="submit" class="btn btn-dark btn-radius btn-brd grd1">
                                        Guardar y Continuar
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>	

<!-- Start header -->
<header class="top-navbar">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="index.html">
                <img src="http://localhost:8080/WebEduExt/Partials/images/logo2.png" height="60px" alt="" />
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbars-host" aria-controls="navbars-rs-food" aria-expanded="false" aria-label="Toggle navigation">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbars-host">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item active"><a class="nav-link" href="index.jsp">Home</a></li>
                    <li class="nav-item"><a class="nav-link" href="about.html">Sobre Nosotros</a></li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="dropdown-a" data-toggle="dropdown">Consultas </a>
                        <div class="dropdown-menu" aria-labelledby="dropdown-a">
                            <a class="dropdown-item" href="consultarcurso.html">Consultar Curso </a>
                            <a class="dropdown-item" href="consultaredicion.html">Consultar Edicion </a>
                            <a class="dropdown-item" href="consultarprograma.html">Consultar Programa </a>
                            <a class="dropdown-item" href="consultarusuario.html">Consultar Usuario </a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="dropdown-a" data-toggle="dropdown">Blog </a>
                        <div class="dropdown-menu" aria-labelledby="dropdown-a">
                            <a class="dropdown-item" href="blog.html">Blog </a>
                            <a class="dropdown-item" href="blog-single.html">Blog single </a>
                        </div>
                    </li>
                    <li class="nav-item"><a class="nav-link" href="contact.html">Contacto</a></li>
                </ul>
                <%
                    session = request.getSession(false);
                    if (session != null && session.getAttribute("email") != null) {
                        DataUsuario du = (DataUsuario) session.getAttribute("usuario");
                    %>
                        <div class="dropdown">
                            <a class="btn btn-outline-light dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-user"></i> <%= du.getNick() %>
                            </a>
                            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenuLink">
                                <a class="dropdown-item disabled" > <%= du.getEmail() %> </a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="#"><i class="fas fa-user"></i>   VerPerfil </a>
                                <a class="dropdown-item" href="Logout"><i class="fas fa-sign-out-alt"></i>   Salir </a>
                            </div>
                        </div>
                <%  } else {%>
                        <ul class="nav navbar-nav navbar-right">
                            <li><a class="hover-btn-new log orange" href="#" data-toggle="modal" data-target="#login"><span>Ingresar</span></a></li>
                        </ul> 
                <%  }  %>
            </div>
        </div>
    </nav>
</header>
<!-- End header -->
<script>
    $(document).ready(function () {
        var selinsti = $('#selinsti');
        selinsti.hide();
        $('#docente').click(function () {
            selinsti.empty();
            selinsti.append(`<option value="vacio" selected> Seleccione Instituto... </option>`);
            selinsti.toggle();
            $.ajax({
                type: 'GET',
                url: 'Registrarse',
                success: function (response) {
                    let institutos = JSON.parse(response);
                    institutos.forEach(instituto => {
                        let template = '<option value="' + instituto + '">' + instituto + '</option>';
                        $('#selinsti').append(template);
                    });
                }
            });
        });
        
        
        var nickValido = $('#nickValido');
        var campoNick = $('#nick');
        nickValido.hide();
        $('#nick').keyup(function(){
            nickValido.hide();
            let nick = campoNick.val();
            let validar = 'validarNick';
            $.ajax({
                type: 'POST',
                data: {nick:nick, validar:validar},
                url: 'Validar',
                success: function(response){
                    let valido = JSON.parse(response);
                    if(!valido){
                        campoNick.addClass("text-danger");
                        nickValido.show();
                    } else {
                        campoNick.removeClass("text-danger");
                        nickValido.hide();
                    }
                }
            });
        });
    });
</script>