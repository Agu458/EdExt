<%-- 
    Document   : index
    Created on : 13 oct. 2020, 17:21:39
    Author     : Agustin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <%@include file="/Partials/head.jsp" %>
    </head>
    <body>
        <%@include file="/Partials/header.jsp" %>

        <div id="carouselExampleControls" class="carousel slide bs-slider box-slider" data-ride="carousel" data-pause="hover" data-interval="false" >
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#carouselExampleControls" data-slide-to="0" class="active"></li>
                <li data-target="#carouselExampleControls" data-slide-to="1"></li>
                <li data-target="#carouselExampleControls" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner" role="listbox">
                <div class="carousel-item active">
                    <div id="home" class="first-section" style="background-image:url('http://localhost:8080/WebEduExt/Partials/images/slider-01.jpg');">
                        <div class="dtab">
                            <div class="container">
                                <div class="row">
                                    <div class="col-md-12 col-sm-12 text-right">
                                        <div class="big-tagline">
                                            <h2><strong>EduExt </strong> cursos Online</h2>
                                            <p class="lead">Estudia desde cualquier lugar del mundo. Sin limitaciones. </p>
                                            <a href="contact.html" class="hover-btn-new"><span>Contactanos</span></a>
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

                                        </div>
                                    </div>
                                </div><!-- end row -->            
                            </div><!-- end container -->
                        </div>
                    </div><!-- end section -->
                </div>
                <div class="carousel-item">
                    <div id="home" class="first-section" style="background-image:url('http://localhost:8080/WebEduExt/Partials/images/slider-02.jpg');">
                        <div class="dtab">
                            <div class="container">
                                <div class="row">
                                    <div class="col-md-12 col-sm-12 text-left">
                                        <div class="big-tagline">
                                            <h2 data-animation="animated zoomInRight">Cursos <strong>en un PROGRAMA comun</strong></h2>
                                            <p class="lead" data-animation="animated fadeInLeft">Un PROGRAMA es una serie de CURSOS en un orden especifico para garantizar un mayor APRENDIZAJE. </p>
                                            <a href="consultarprograma.html" class="hover-btn-new"><span>Consultar</span></a>
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

                                        </div>
                                    </div>
                                </div><!-- end row -->            
                            </div><!-- end container -->
                        </div>
                    </div><!-- end section -->
                </div>
                <div class="carousel-item">
                    <div id="home" class="first-section" style="background-image:url('http://localhost:8080/WebEduExt/Partials/images/slider-03.jpg');">
                        <div class="dtab">
                            <div class="container">
                                <div class="row">
                                    <div class="col-md-12 col-sm-12 text-center">
                                        <div class="big-tagline">
                                            <h2 data-animation="animated zoomInRight"><strong>DIPLOMAS</strong> Certificados</h2>
                                            <p class="lead" data-animation="animated fadeInLeft">Nuestros cursos y programas cuentan con diplomas certificados al terminar el mismo.</p>
                                            <a href="contact.html" class="hover-btn-new"><span>Contactanos</span></a>
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        </div>
                                    </div>
                                </div><!-- end row -->            
                            </div><!-- end container -->
                        </div>
                    </div><!-- end section -->
                </div>
                <!-- Left Control -->
                <a class="new-effect carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
                    <span class="fa fa-angle-left" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>

                <!-- Right Control -->
                <a class="new-effect carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
                    <span class="fa fa-angle-right" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>





        <div class="section cl">
            <div class="container">
                <div class="row text-left stat-wrap">
                    <div class="col-md-4 col-sm-4 col-xs-12">
                        <span data-scroll class="global-radius icon_wrap effect-1 alignleft"><i class="flaticon-study"></i></span>
                        <p class="stat_count">4000</p>
                        <h3>Estudiantes</h3>
                    </div><!-- end col -->

                    <div class="col-md-4 col-sm-4 col-xs-12">
                        <span data-scroll class="global-radius icon_wrap effect-1 alignleft"><i class="flaticon-online"></i></span>
                        <p class="stat_count">240</p>
                        <h3>Cursos</h3>
                    </div><!-- end col -->

                    <div class="col-md-4 col-sm-4 col-xs-12">
                        <span data-scroll class="global-radius icon_wrap effect-1 alignleft"><i class="flaticon-years"></i></span>
                        <p class="stat_count">55</p>
                        <h3>Años Completados</h3>
                    </div><!-- end col -->
                </div><!-- end row -->
            </div><!-- end container -->
        </div><!-- end section -->



        <div id="Testimonios" class="parallax section db parallax-off" style="background-image:url('http://localhost:8080/WebEduExt/Partials/images/parallax_04.jpg');">
            <div class="container">
                <div class="section-title text-center">
                    <h3>Testimonios</h3>
                    <p>Estos son algunos testimonios de nuestros estudiantes... </p>
                </div><!-- end title -->

                <div class="row">
                    <div class="col-md-12 col-sm-12">
                        <div class="testi-carousel owl-carousel owl-theme">
                            <div class="testimonial clearfix">
                                <div class="testi-meta">
                                    <img src="http://localhost:8080/WebEduExt/Partials/images/testi_01.png" alt="" class="img-fluid">
                                    <h4>Adrián Maximiliano Nario Pérez </h4>
                                </div>
                                <div class="desc">
                                    <h3><i class="fa fa-quote-left"></i> Maravillosos Cursos!</h3>
                                    <p class="lead">Hice un par de cursos de edicion para mi canal de Youtube "El Bananero".</p>
                                </div>
                                <!-- end testi-meta -->
                            </div>
                            <!-- end testimonial -->

                            <div class="testimonial clearfix">
                                <div class="testi-meta">
                                    <img src="http://localhost:8080/WebEduExt/Partials/images/testi_02.png" alt="" class="img-fluid">
                                    <h4>Nicolas Escobar </h4>
                                </div>
                                <div class="desc">
                                    <h3><i class="fa fa-quote-left"></i> Buenisima pagina gurices</h3>
                                    <p class="lead">Aprobado siguiente!</p>
                                </div>
                                <!-- end testi-meta -->
                            </div>
                            <!-- end testimonial -->

                            <div class="testimonial clearfix">
                                <div class="testi-meta">
                                    <img src="http://localhost:8080/WebEduExt/Partials/images/testi_03.png" alt="" class="img-fluid ">
                                    <h4>Martin Perez Disalvo </h4>
                                </div>
                                <div class="desc">
                                    <h3><i class="fa fa-quote-left"></i> Tremendos cursos PADREEE!</h3>
                                    <p class="lead">Hice cursos de Stand UP, y estan IDOOOOS.</p>
                                </div>
                                <!-- end testi-meta -->
                            </div>
                            <!-- end testimonial -->
                            <div class="testimonial clearfix">
                                <div class="testi-meta">
                                    <img src="http://localhost:8080/WebEduExt/Partials/images/testi_04.png" alt="" class="img-fluid">
                                    <h4>Marcos Alberca </h4>
                                </div>
                                <div class="desc">
                                    <h3><i class="fa fa-quote-left"></i> Los cursos son muy completos!</h3>
                                    <p class="lead">Hice cursos de fotografia y me sirvieron para mi carrera profesional.</p>
                                </div>
                                <!-- end testi-meta -->
                            </div>
                            <!-- end testimonial -->

                            <div class="testimonial clearfix">
                                <div class="testi-meta">
                                    <img src="http://localhost:8080/WebEduExt/Partials/images/testi_05.png" alt="" class="img-fluid">
                                    <h4>Mauricio "HACKERMAN" Camacho.</h4>
                                </div>
                                <div class="desc">
                                    <h3><i class="fa fa-quote-left"></i> Muy buenos cursos</h3>
                                    <p class="lead">Hice un par de cursos de seguridad informatica y ahora puedo hackear al pentagono gracias!! :).</p>
                                </div>
                                <!-- end testi-meta -->
                            </div>
                            <!-- end testimonial -->

                            <div class="testimonial clearfix">
                                <div class="testi-meta">
                                    <img src="http://localhost:8080/WebEduExt/Partials/images/testi_06.png" alt="" class="img-fluid">
                                    <h4>Cintia Leal </h4>
                                </div>
                                <div class="desc">
                                    <h3><i class="fa fa-quote-left"></i> Buenos cursos gamers!!</h3>
                                    <p class="lead">Hice el curso de League Of Legends y ahora puedo dejar de jugar Teemo.</p>
                                </div>
                                <!-- end testi-meta -->
                            </div><!-- end testimonial -->
                        </div><!-- end carousel -->
                    </div><!-- end col -->
                </div><!-- end row -->
            </div><!-- end container -->
        </div><!-- end section -->

        <div class="parallax section dbcolor">
            <div class="container">
                <div class="row logos">
                    <div class="col-md-2 col-sm-2 col-xs-6 wow fadeInUp">
                        <a href="#"><img src="http://localhost:8080/WebEduExt/Partials/images/logo_01.png" alt="" class="img-repsonsive"></a>
                    </div>
                    <div class="col-md-2 col-sm-2 col-xs-6 wow fadeInUp">
                        <a href="#"><img src="http://localhost:8080/WebEduExt/Partials/images/logo_02.png" alt="" class="img-repsonsive"></a>
                    </div>
                    <div class="col-md-2 col-sm-2 col-xs-6 wow fadeInUp">
                        <a href="#"><img src="http://localhost:8080/WebEduExt/Partials/images/logo_03.png" alt="" class="img-repsonsive"></a>
                    </div>
                    <div class="col-md-2 col-sm-2 col-xs-6 wow fadeInUp">
                        <a href="#"><img src="http://localhost:8080/WebEduExt/Partials/images/logo_04.png" alt="" class="img-repsonsive"></a>
                    </div>
                    <div class="col-md-2 col-sm-2 col-xs-6 wow fadeInUp">
                        <a href="#"><img src="http://localhost:8080/WebEduExt/Partials/images/logo_05.png" alt="" class="img-repsonsive"></a>
                    </div>
                    <div class="col-md-2 col-sm-2 col-xs-6 wow fadeInUp">
                        <a href="#"><img src="http://localhost:8080/WebEduExt/Partials/images/logo_06.png" alt="" class="img-repsonsive"></a>
                    </div>
                </div><!-- end row -->
            </div><!-- end container -->
        </div><!-- end section -->

        <%@include file="/Partials/footer.jsp" %>
    </body>
</html>