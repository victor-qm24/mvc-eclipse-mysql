<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.siesweb.modelo.Temas"%>
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
<title>SIES WEB - Admin - temas solicitud</title>
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
								de documento</a></li>
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
	<section class="container-fluid p-3"
		style="margin-top: 100px;" id="sec-tipo">
		<h1>
			<b>CRUD Temas</b>
		</h1>
		<h6>Aqui puedes insertar, actualizar, eliminar y listar.</h6>
		<div class="row p-3">
			<div class="col-sm-6 border-end">
				<form method="POST" action="insertarTema">
					<!--grupo_descricpion_tema-->
					<div class="formulario__grupo" id="grupo__descTema">
						<div class="formulario__grupo-input d-flex">
							<input type="text" name="descTema" id="descTema"
								class=" form-control formulario__input mb-2"
								placeholder="Descripcion" oninput="validarDescTema()"> <i
								class="formulario__validacion-estado material-icons ms-1"
								id="iconDescTema">check_circle</i>
						</div>
						<p class="formulario__input-error" id="descTemaError"></p>
					</div>
					<!--gurpo_button_enviar-->
					<div class="formulario__grupo formulario__grupo-btn-enviar">
						<input type="submit" value="Insertar"
							class="btn btn-primary float-end formulario__btn">
					</div>
				</form>
			</div>
			<div class="col-sm-6">
				<form method="POST" action="actualizarTema">
					<div class="row">
						<div class="col-sm-3">
							<!--grupo_id-->
							<div class="formulario__grupo" id="grupo__id">
								<div class="formulario__grupo-input d-flex">
									<input type="text" name="idTema" id="idTema"
										class=" form-control formulario__input mb-2" placeholder="Id"
										oninput="validarIdTema()"> <i
										class="formulario__validacion-estado material-icons ms-1"
										id="iconIdTema">check_circle</i>
								</div>
								<p class="formulario__input-error" id="idTemaError"></p>
							</div>
						</div>
						<div class="col-sm-9">
							<!--grupo_descricpion_rol-->
							<div class="formulario__grupo" id="grupo__descripcionTema">
								<div class="formulario__grupo-input d-flex">
									<input type="text" name="descripcionTema" id="descripcionTema"
										class=" form-control formulario__input mb-2"
										placeholder="Descripcion" oninput="validarDescripcionTema()">
									<i class="formulario__validacion-estado material-icons ms-1"
										id="iconDescripcionTema">check_circle</i>
								</div>
								<p class="formulario__input-error" id="descripcionTemaError"></p>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm">
							<!--gurpo_button_enviar-->
							<div class="formulario__grupo formulario__grupo-btn-enviar">
								<input type="submit" value="Actualizar"
									class="btn btn-secondary float-end formulario__btn">
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
		<hr>
		<div class="row p-3">
			<div class="col-sm-6 border-end">
				<form action="eliminarTema" method="POST">
					<div class="row">
						<div class="col-sm-6"></div>
						<div class="col-sm-3">
							<!--grupo_id-->
							<div class="formulario__grupo" id="grupo__id">
								<div class="formulario__grupo-input d-flex">
									<input type="text" name="idTemas" id="idTemas"
										class=" form-control formulario__input mb-2" placeholder="Id"
										oninput="validarIdTemas()"> <i
										class="formulario__validacion-estado material-icons ms-1"
										id="iconIdTemas">check_circle</i>
								</div>
								<p class="formulario__input-error" id="idTemasError"></p>
							</div>
						</div>
						<div class="col-sm-3">
							<!--gurpo_button_eliminar-->
							<div class="formulario__grupo formulario__grupo-btn-enviar">
								<input type="submit" value="Eliminar"
									class="btn btn-danger float-end formulario__btn">
							</div>
						</div>
					</div>
				</form>
				<div class="row">
					<div class="col-sm">
						<!--gurpo_button_listar-->
						<div class="formulario__grupo formulario__grupo-btn-enviar">
							<a class="btn btn-info float-end" href="listarTema">Listar</a>
						</div>
					</div>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="container-fluid table-responsive"
					style="max-height: 100px; overflow-y: auto;">
					<table class="table table-hover text-center">
						<thead class="table-primary">
							<tr>
								<th>ID</th>
								<th>Descripcion</th>
							</tr>
						</thead>
						<tbody>
							<% 
				            	List<Temas> listaTemas = (List<Temas>) request.getAttribute("listaTemas");
				            	if(listaTemas != null){
					            	for(Temas tema:listaTemas){
					            		out.print("<tr>");
					            		out.print("<td>" + tema.getId() + "</td>");
					            		out.print("<td>" + tema.getDescripcion_tema() + "</td>");					            		
					            		out.print("<tr>");
					            	}
				            	}
				            %>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</section>
	<footer
		class="p-2 bg-dark text-white text-center position-absolute w-100 bottom-0">
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
	<script type="text/javascript" src="javaScript/validateOtros.js"></script>
</body>
</html>