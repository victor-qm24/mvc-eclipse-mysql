<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="javax.servlet.RequestDispatcher"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<title>SIES WEB - Admin</title>
<style>
.nav-link {
	color: #ffffff;
}

.nav-link:hover {
	color: blue;
}
</style>
</head>
<body>
	<nav class="navbar navbar-expand-sm fixed-top bg-success">
		<div class="container-fluid">
			<ul
				class="d-flex justify-content-center align-items-center nav-justified ">
				<li class="d-inline"><a href="admin.jsp" class="navbar-brand"><img
						src="imagenes/logo_siesweb_v2.jpg" alt="" class="img-fluid"></a></li>
				<li class="d-inline"><a href="#" class="navbar-brand"><img
						src="imagenes/logo-ing-vias.PNG" alt="" class="img-fluid"></a></li>
			</ul>
			<ul
				class="nav nav-pills d-flex justify-content-center align-items-center nav-justified">
				<li class="nav-item"><a class="nav-link" href="admin.jsp">Inicio</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					data-bs-toggle="dropdown">Usuarios</a>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" href="cargarInsercion">Agregar</a></li>
						<li><a class="dropdown-item" href="cargarActualizacion">Actualizar</a></li>
						<li><a class="dropdown-item"
							href="adminBuscarEliminarUser.jsp">Buscar - Eliminar</a></li>
						<li><a class="dropdown-item" href="listar">Listar</a></li>
					</ul></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					data-bs-toggle="dropdown">Avances</a>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" href="cargarInsercionAvc">Insertar</a></li>
						<li><a class="dropdown-item" href="cargarActualizacionAvc">Actualizar</a></li>
						<li><a class="dropdown-item"
							href="adminBuscarEliminarAvc.jsp">Buscar - Eliminar</a></li>
						<li><a class="dropdown-item" href="listarAvc">Listar</a></li>
					</ul></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					data-bs-toggle="dropdown">Más</a>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" href="adminTipo.jsp">Tipos
								de DNI</a></li>
						<li><a class="dropdown-item" href="adminRol.jsp">Roles</a></li>
						<li><a class="dropdown-item" href="adminProyecto.jsp">Proyectos</a></li>
						<li><a class="dropdown-item" href="adminSolicitud.jsp">Solicitudes</a></li>
						<li><a class="dropdown-item" href="adminTema.jsp">Temas</a></li>
					</ul></li>
				<li><a class="dropdown-item " href="logout"><i
						class="material-icons nav-link">logout</i></a></li>
			</ul>
		</div>
	</nav>
	<section class="container-fluid p-3 border-bottom"
		style="margin-top: 100px;" id="sec-inicio">
		<% 	
        	if (session != null && session.getAttribute("nombreUser") != null) {
	        	String name = (String) session.getAttribute("nombreUser");
	        	out.print("<h1> !Bienvenido <strong>" + name + "</strong>¡</h1>");
        	}else {
        		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
    			dispatcher.forward(request, response);
            }
        %>
		<hr>
		<div class="row mt-4 mb-2 border-bottom">
			<div class="col-sm-10 text-center">
				<h2><strong>Nombre del proyecto</strong></h2>
				<p class="display-6">Desarrollo de un aplicativo web para la
				visualización de estadísticas viales mediante el análisis de la
				información sobre el manejo de solicitudes por intervención de
				propiedades privadas en la obra de pavimentación PALMITAS-LERMA</p>
			</div>
			<div class="col-sm-2">
				<img src="imagenes/vias-2.jpg" alt="" srcset=""
					class="d-block w-100">
			</div>
		</div>
		
		<div class="row">
			<div class="col-sm-6 border-end">
				<h4 class="text-center mb-2">Misión</h4>
				<p class="text-justify">Facilitar la vida de las personas mediante el uso de la tecnología, 
				desarrollando soluciones innovadoras enfocadas a la calidad y personalización del resultado, 
				que proporcionen una grata experiencia de usuario, y que aporten valor y tengan un impacto 
				positivo en el día a día de nuestra sociedad</p>
				<h4 class="text-center mb-2">Visión</h4>
				<p class="text-justify">Para el 2030 nuestra empresa será un referente atractivo como empresa de desarrollo, 
				en los productos y servicios ofrecidos, como proveedor tecnlógico y como lugar de trabajo, al diseñar y 
				desarrollar servicios y soluciones software	diferenciales, que aporten un gran valor. </p>
				<h4 class="text-center mb-2">Valores</h4>
				<ul>
					<li>Fuerte compromiso centrado en la cercanía al cliente y en la personalización del trato 
					y del servicio.</li>
					<li>Respeto y tolerancia hacia la forma de ver las cosas de los demás.</li>
					<li>Confianza, paciencia y constancia en todo cuanto hacemos.</li>
				</ul>
			</div>
			<div class="col-sm-4 d-flex justify-content-center align-items-center">
				<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d1993.7234526039933!2d-
				76.95635159351161!3d1.975542499499571!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s
				0x8e2fbba7e25baf67%3A0x9fc0b65f9e063e82!2sLerma%2C%20Bol%C3%ADvar%2C%20Cauca!5e0!3m2!1ses
				!2sco!4v1729197877762!5m2!1ses!2sco" width="550" height="400" style="border:0;" allowfullscreen="" 
				loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
			</div>
			<div class="col-sm-2 d-flex justify-content-center align-items-center">
				<div class="card" style="width:250px">
				    <img class="card-img-top" src="imagenes/foto-personal.jpg" alt="Card image" style="width:100%">
				    <div class="card-body text-center">
				      <h5 class="card-title">Victor Manuel Quinayas</h5>
				      <p class="card-text">Ingeniero electrónico</p>				      
				    </div>
				</div>
			</div>						
		</div>
	</section>
	<footer class="p-2 bg-dark text-white text-center">
		<div class="row">
			<div class="col-sm-3"></div>
			<div class="col-sm-6">
				<ul class="list-unstyled">
					<li class="d-inline p-2"><i class="material-icons">phone</i>
						+57-313-573-5659</li>
					<li class="d-inline p-2"><i class="material-icons">facebook</i>
						/sieswebvial</li>
					<li class="d-inline p-2"><i class="material-icons">mail</i>
						sieswebvial@gmail.com</li>
				</ul>
			</div>
			<div class="col-sm-3"></div>
		</div>
	</footer>
</body>
</html>