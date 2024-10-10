<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.siesweb.modelo.Usuarios"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	<title>SIES WEB - Admin</title>
</head>
<body>
	<nav class="navbar navbar-expand-sm fixed-top bg-light">
        <div class="container-fluid">
        	<ul>
        		<li class="d-inline"><a href="admin.jsp" class="navbar-brand"><img src="imagenes/logo_siesweb.jpg" alt="" class="img-fluid"></a></li>
        		<li class="d-inline"><a href="#" class="navbar-brand"><img src="imagenes/logo-ing-vias.PNG" alt="" class="img-fluid"></a></li>
        	</ul>
        	<ul class="nav nav-pills justify-content-end">
        		<li class="nav-item"><a class="nav-link" href="admin.jsp">Inicio</a></li>
        		<li class="nav-item dropdown">
	          		<a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">Usuarios</a>
	          		<ul class="dropdown-menu">
			            <li><a class="dropdown-item" href="adminAgregarUser.jsp">Agregar</a></li>
			            <li><a class="dropdown-item" href="adminActualizarUser.jsp">Actualizar</a></li>
			            <li><a class="dropdown-item" href="adminBuscarUser.jsp">Buscar</a></li>
			            <li><a class="dropdown-item" href="adminEliminarUser.jsp">Eliminar</a></li>
			            <li><a class="dropdown-item" href="listar">Listar</a></li>
	          		</ul>
		        </li> 
                <li class="nav-item"><a class="nav-link" href="#sec-avances">Avances</a></li> 
                <li class="nav-item"><a class="nav-link" href="#sec-proyectos">Proyectos</a></li>               
       			<li class="nav-item"><a class="nav-link" href="#sec-temas">Temas</a></li>
       			<li class="nav-item"><a class="nav-link" href="#sec-roles">Roles</a></li>               
       			<li class="nav-item"><a class="nav-link" href="#sec-tiposDoc">Tipos de documento</a></li>                
            </ul>
        </div>
    </nav>
    <section class="container-fluid p-3 border-bottom" style="margin-top: 100px;" id="sec-inicio">
        <% 
        	String name = (String) request.getAttribute("nombreUser");
        	out.print("<h1> !Bienvenido <strong>" + name + "</strong>¡</h1>");
        %>
        <hr>
        <div class="row mt-4">
            <div class="col-sm-6">
                
                <div class="row text-center">
	                <div class="col-sm">
	                	<h2><b>Nombre del proyecto</b></h2>
	                    <p class="display-7">Desarrollo de un prototipo web para la visualización de estadísticas viales 
	                    mediante el análisis de la información sobre el manejo de solicitudes por intervención 
	                    de propiedades privadas en la obra de pavimentación Palmitas Lerma</p>
	                </div>                    
                </div>
                <hr>
                <div class="row text-center">
                    <h2><b>¿Quienes somos?</b></h2>
                    <div class="col-sm-6">
                         <img src="imagenes/foto-personal.jpg" alt="" class="img-fluid float-end">
                    </div>
                    <div class="col-sm-6 d-flex justify-content-center align-items-center">
                    	<ul class="list-unstyled">
                    		<li>Victor Manuel Quinayas Meneses</li>
                    		<li>Desarrollador del software SIESWEB vial</li>
                    		<li>Ingeniero Electronico</li>
                    	</ul>
                    </div>
                </div>
            </div>
            <div class="col-sm-6">
                <img src="imagenes/vias-2.jpg" alt="" srcset="" class="d-block w-100">
            </div>
        </div>
    </section>
    <footer class="p-2 bg-dark text-white text-center position-absolute w-100 bottom-0">
        <ul class="list-unstyled">
            <li class="d-inline p-2"><i class="material-icons">phone</i> +57-313-573-5659</li>
            <li class="d-inline p-2"><i class="material-icons">facebook</i> /sieswebvial</li>
            <li class="d-inline p-2"><i class="material-icons">mail</i> sieswebvial@gmail.com</li>
        </ul>
    </footer>
</body>
</html>