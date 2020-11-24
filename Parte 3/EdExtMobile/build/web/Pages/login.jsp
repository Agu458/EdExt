<%-- 
    Document   : login
    Created on : 8 nov. 2020, 15:44:54
    Author     : Agustín
--%>

<%@page import="Model.SessionState"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- saved from url=(0051)https://getbootstrap.com/docs/4.5/examples/sign-in/ -->
<html lang="en">
    <head>
        <%@include file="/Pages/Partials/head.jsp" %>

        <style>
            :root {
                --input-padding-x: 1.5rem;
                --input-padding-y: 0.75rem;
            }

            .login,
            .image {
                min-height: 100vh;
            }

            .bg-image {
                background-image: url('https://source.unsplash.com/WEQbe2jBg40/600x1200');
                background-size: cover;
                background-position: center;
            }

            .login-heading {
                font-weight: 300;
            }

            .btn-login {
                font-size: 0.9rem;
                letter-spacing: 0.05rem;
                padding: 0.75rem 1rem;
            }

            .form-label-group {
                position: relative;
                margin-bottom: 1rem;
            }

            .form-label-group>input,
            .form-label-group>label {
                padding: var(--input-padding-y) var(--input-padding-x);
                height: auto;
            }

            .form-label-group>label {
                position: absolute;
                top: 0;
                left: 0;
                display: block;
                width: 100%;
                margin-bottom: 0;
                /* Override default `<label>` margin */
                line-height: 1.5;
                color: #495057;
                cursor: text;
                /* Match the input under the label */
                border: 1px solid transparent;
                transition: all .1s ease-in-out;
            }

            .form-label-group input::-webkit-input-placeholder {
                color: transparent;
            }

            .form-label-group input:-ms-input-placeholder {
                color: transparent;
            }

            .form-label-group input::-ms-input-placeholder {
                color: transparent;
            }

            .form-label-group input::-moz-placeholder {
                color: transparent;
            }

            .form-label-group input::placeholder {
                color: transparent;
            }

            .form-label-group input:not(:placeholder-shown) {
                padding-top: calc(var(--input-padding-y) + var(--input-padding-y) * (2 / 3));
                padding-bottom: calc(var(--input-padding-y) / 3);
            }

            .form-label-group input:not(:placeholder-shown)~label {
                padding-top: calc(var(--input-padding-y) / 3);
                padding-bottom: calc(var(--input-padding-y) / 3);
                font-size: 12px;
                color: #777;
            }

            /* Fallback for Edge
            -------------------------------------------------- */

            @supports (-ms-ime-align: auto) {
                .form-label-group>label {
                    display: none;
                }
                .form-label-group input::-ms-input-placeholder {
                    color: #777;
                }
            }

            /* Fallback for IE
            -------------------------------------------------- */

            @media all and (-ms-high-contrast: none),
            (-ms-high-contrast: active) {
                .form-label-group>label {
                    display: none;
                }
                .form-label-group input:-ms-input-placeholder {
                    color: #777;
                }
            }
        </style>
    </head>

    <body>
        
        <div class="container-fluid">
            <div class="row no-gutter">
                <div class="d-none d-md-flex col-md-4 col-lg-6 bg-success"></div>
                <div class="col-md-8 col-lg-6">
                    <div class="login d-flex align-items-center py-5">
                        <div class="container">
                            <div class="row">
                                <div class="col-md-9 col-lg-8 mx-auto">
                                    <div class="text-center">
                                        <img src="/EdExtMobile/Src/Images/EdExtMobile.png">
                                    </div>
                                    <h3 class="login-heading mb-4">Bienvenido!</h3>
                                    <%
                                        SessionState state = (SessionState) session.getAttribute("SessionState");
                                        if (state != null && state == SessionState.LOGIN_FAILED) {
                                    %>
                                    <div class="form-group">
                                        <div class="alert alert-danger alert-dismissible fade show" role="alert">
                                            <strong>Ocurrio un error!</strong> Las credenciales usadas son invalidas.
                                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                    </div>
                                    <%
                                        }
                                    %>
                                    <form action="Login" method="POST">
                                        <div class="form-label-group">
                                            <input type="email" id="inputEmail" class="form-control" placeholder="Direccion email" required autofocus name="email">
                                            <label for="inputEmail">Direccion email</label>
                                        </div>

                                        <div class="form-label-group">
                                            <input type="password" id="inputPassword" class="form-control" placeholder="Contraseña" required name="password">
                                            <label for="inputPassword">Contraseña</label>
                                        </div>

                                        <button class="btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2" type="submit">Ingresar</button>
                                        <div class="text-center">
                                            <a class="small" href="#">Olvidó su contraseña?</a></div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <%@include file="/Pages/Partials/footer.jsp" %>

    </body>
</html>
