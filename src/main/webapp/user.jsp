<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.siesweb.modelo.Usuarios"%>
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
<title>SIES WEBb</title>
</head>
<body>
	<nav class="navbar navbar-expand-sm fixed-top bg-success">
		<div class="container-fluid">
			<ul>
				<li class="d-inline"><a href="admin.jsp" class="navbar-brand"><img
						src="imagenes/logo_siesweb.jpg" alt="" class="img-fluid"></a></li>
				<li class="d-inline"><a href="#" class="navbar-brand"><img
						src="imagenes/logo-ing-vias.PNG" alt="" class="img-fluid"></a></li>
			</ul>
			<ul class="nav nav-pills justify-content-end">
				<li class="nav-item"><a class="nav-link" href="#sec-inicio">Inicio</a></li>
				<li class="nav-item"><a class="nav-link"
					href="#sec-estadisticas">Estadisticas</a></li>
				<li class="nav-item"><a class="nav-link"
					href="#sec-solicitudes">Solicitudes</a></li>
			</ul>
		</div>
	</nav>
	<section class="container-fluid p-3" style="margin-top: 100px;"
		id="sec-inicio">
		<% 
        	String name = (String) request.getAttribute("nombreUser");
        	out.print("<h1> !Bienvenido <strong>" + name + "</strong>¡</h1>");
        %>
		<hr>
		<div class="row mt-4">
			<div class="col-sm-6">

				<div class="row text-center">
					<div class="col-sm">
						<h2>
							<b>Nombre del proyecto</b>
						</h2>
						<p class="display-7">Desarrollo de un prototipo web para la
							visualización de estadísticas viales mediante el análisis de la
							información sobre el manejo de solicitudes por intervención de
							propiedades privadas en la obra de pavimentación Palmitas Lerma</p>
					</div>
				</div>
				<hr>
				<div class="row text-center">
					<h2>
						<b>¿Quienes somos?</b>
					</h2>
					<div class="col-sm-6">
						<img src="imagenes/foto-personal.jpg" alt=""
							class="img-fluid float-end">
					</div>
					<div
						class="col-sm-6 d-flex justify-content-center align-items-center">
						<ul class="list-unstyled">
							<li>Victor Manuel Quinayas Meneses</li>
							<li>Desarrollador del software SIESWEB vial</li>
							<li>Ingeniero Electronico</li>
						</ul>
					</div>
				</div>
			</div>
			<div class="col-sm-6">
				<img src="imagenes/vias-3.jpg" alt="" srcset=""
					class="d-block w-100">
			</div>
		</div>
	</section>
	<section class="container-fluid bg-light p-5 pt-1"
		style="margin-top: 100px;" id="sec-estadisticas">
		<h1>
			<b>Pavimentación Palmitas - Lerma</b>
		</h1>
		<h6>Avances estadisticos</h6>
		<div class="row border bordered mt-5">
			<div
				class="col-sm-2 border-2 border-dark border-end d-block text-center p-3">
				<h3 class="text-primary">
					<strong>1000 m</strong>
				</h3>
				<h5>Tramo ampliado</h5>
			</div>
			<div
				class="col-sm-2 border-2 border-dark border-end d-block text-center p-3">
				<h3 class="text-primary">
					<strong>1000 m</strong>
				</h3>
				<h5>Tramo mejorado</h5>
			</div>
			<div
				class="col-sm-2 border-2 border-dark border-end d-block text-center p-3">
				<h3 class="text-primary">
					<strong>1000 m</strong>
				</h3>
				<h5>Tramo sub-base</h5>
			</div>
			<div
				class="col-sm-2 border-2 border-dark border-end d-block text-center p-3">
				<h3 class="text-primary">
					<strong>1000 m</strong>
				</h3>
				<h5>Tramo base</h5>
			</div>
			<div
				class="col-sm-2 border-2 border-dark border-end d-block text-center p-3">
				<h3 class="text-primary">
					<strong>1000 m</strong>
				</h3>
				<h5>Tramo asfaltado</h5>
			</div>
			<div
				class="col-sm-2 border-2 border-dark border-end d-block text-center p-3">
				<h3 class="text-primary">
					<strong>1000 m</strong>
				</h3>
				<h5>% ejecucion</h5>
			</div>
		</div>
		<div class="row border bordered mt-5">
			<div class="col-sm-4"></div>
			<div class="col-sm-4"></div>
			<div class="col-sm-4"></div>
		</div>
	</section>
	<section class="container-fluid p-5" id="sec-solicitudes">
		<h1>
			<b>Solicitudes</b>
		</h1>
		<br>
		<div class="row">
			<div class="col-sm-6">
				<form action="#"
					class="d-block bg-dark-subtle rounded p-3 h-100 formulario"
					id="formulario">
					<!--grupo__nombres-->
					<div class="formulario__grupo" id="grupo__nombres">
						<label for="nombres" class="form-label formulario__label"><b>Nombres</b></label>
						<div class="formulario__grupo-input d-flex">
							<input type="text" name="nombres" id="nombres"
								class="formulario__input form-control"
								placeholder="Ingrese su nombre..."> <i
								class="formulario__validacion-estado material-icons ms-1">check_circle</i>
						</div>
						<p class="formulario__input-error d-none">El nombre solo
							permite letras.</p>
					</div>
					<!--grupo__proyecto-->
					<div class="formulario__grupo" id="grupo__proyecto">
						<label for="proyecto" class="form-label formulario__label">Proyecto</label>
						<div class="formulario__grupo-input d-flex">
							<select name="proyecto" id="proyecto"
								class="form-select formulario__input mb-2">
								<option value="-">-</option>
								<option value="Pavimentacion PALMITAS-LERMA">Pavimentacion
									PALMITAS-LERMA</option>
							</select> <i class="formulario__validacion-estado material-icons ms-1">check_circle</i>
						</div>
						<p class="formulario__input-error d-none">Se debe especificar
							el proyecto de interes.</p>
					</div>
					<!--grupo__tema-->
					<div class="formulario__grupo" id="grupo__tema">
						<label for="tema" class="form-label formulario__label"><b>Tema</b></label>
						<div class="formulario__grupo-input d-flex">
							<select name="tema" id="tema"
								class="form-select formulario__input">
								<option value="-">-</option>
								<option value="Citas">Citas</option>
								<option value="Daños">Daños</option>
								<option value="Otros">Otros</option>
							</select> <i class="formulario__validacion-estado material-icons ms-1">check_circle</i>
						</div>
						<p class="formulario__input-error d-none">Se debe especificar
							el tema.</p>
					</div>
					<!--grupo__observacion-->
					<div class="formulario__grupo" id="grupo__observacion">
						<label for="observacion" class="form-label formulario__label"><b>Observacion</b></label>
						<div class="formulario__grupo-input d-flex">
							<input type="text" name="observacion" id="observacion"
								class=" form-control formulario__input mb-2"
								placeholder="Ingrese su observacion..."> <a href="#"
								class="form-text ms-1">Adjuntar</a> <i
								class="formulario__validacion-estado material-icons ms-1">check_circle</i>
						</div>
						<p class="formulario__input-error d-none"></p>
					</div>
					<!--Mensaje-exito-error-->
					<div
						class="formulario__mensaje border rounded bg-danger ps-2 pe-2 lh-1 d-none mt-2"
						id="formulario__mensaje">
						<p>
							<i class="material-icons me-2">assignment_late</i><b>Error: </b>Por
							favor rellena el formulario correctamente.
						</p>
					</div>
					<div
						class="formulario__grupo formulario__grupo-btn-enviar mb-5 mt-2">
						<input type="submit" value="Enviar"
							class="btn btn-primary float-end formulario__btn">
						<p class="formulario__mensaje-exito text-success d-none"
							id="formulario__mensaje-exito">Envio exitoso!</p>
					</div>
				</form>
			</div>
			<div class="col-sm-6">
				<img src="imagenes/vias-4.jpeg" alt="" class="d-block w-100 rounded">
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