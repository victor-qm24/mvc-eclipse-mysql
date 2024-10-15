<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.siesweb.modelo.Proyectos"%>
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
<title>Gestión de avances</title>
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
	<section id="sec_insertarAvc"
		class="container-fluid bg-body p-3 ms-2 me-2"
		style="margin-top: 100px;">
		<h1>
			<b>Insertar avances</b>
		</h1>
		<h6>Debes llenar todos los campos del formulario.</h6>
		<div class="row mt-3">
			<div class="col-sm-6 bg-dark-subtle">
				<form action="insertarAvc" method="POST"
					onsubmit="return validarFormulario();">

					<div class="row p-3">
						<div class="col-sm-4">
							<!--grupo__fecha-->
							<div class="formulario__grupo" id="grupo__fecha">
								<label for="fecha" class="form-label formulario__label me-1"><strong>Fecha</strong></label>
								<div class="formulario__grupo-input d-flex">
									<input type="date" name="fecha" id="fecha"
										class="formulario__input form-control"
										oninput="validarFecha()"> <i
										class="formulario__validacion-estado material-icons ms-1"
										id="iconFecha">check_circle</i>
								</div>
								<p class="formulario__input-error" id="fechaError"></p>
							</div>
							<!-- Grupo: Tramo ampliado -->
							<div class="formulario__grupo" id="grupo__tramo_amp">
								<label for="tramo_amp" class="formulario__label form-label"><strong>T.
										ampliado</strong></label>
								<div class="formulario__grupo-input d-flex">
									<input type="text" name="tramo_amp" id="tramo_amp"
										class="formulario__input form-control"
										oninput="validarTramo_amp()"> <i
										class="formulario__validacion-estado material-icons ms-1"
										id="iconTramo_amp">check_circle</i>
								</div>
								<p class="formulario__input-error" id="tramo_ampError"></p>
							</div>
							<!-- Grupo: Tramo mejorado -->
							<div class="formulario__grupo" id="grupo__tramo_mej">
								<label for="tramo_mej" class="formulario__label form-label"><strong>T.
										mejorado</strong></label>
								<div class="formulario__grupo-input d-flex">
									<input type="text" name="tramo_mej"
										class="formulario__input form-control" id="tramo_mej"
										oninput="validarTramo_mej()"> <i
										class="formulario__validacion-estado material-icons ms-1"
										id="iconTramo_mej">check_circle</i>
								</div>
								<p class="formulario__input-error" id="tramo_mejError"></p>
							</div>
						</div>
						<div class="col-sm-4">
							<!-- Grupo: Tramo sub-base -->
							<div class="formulario__grupo" id="grupo__tramo_sub">
								<label for="tramo_sub" class="formulario__label form-label"><strong>T.
										subBase</strong></label>
								<div class="formulario__grupo-input d-flex">
									<input type="text" name="tramo_sub"
										class="formulario__input form-control" id="tramo_sub"
										oninput="validarTramo_sub()"> <i
										class="formulario__validacion-estado material-icons ms-1"
										id="iconTramo_sub">check_circle</i>
								</div>
								<p class="formulario__input-error" id="tramo_subError"></p>
							</div>
							<!-- Grupo: Tramo base -->
							<div class="formulario__grupo" id="grupo__tramo_bas">
								<label for="tramo_bas" class="formulario__label form-label"><strong>T.
										base</strong></label>
								<div class="formulario__grupo-input d-flex">
									<input type="text" name="tramo_bas"
										class="formulario__input form-control" id="tramo_bas"
										oninput="validarTramo_bas()"> <i
										class="formulario__validacion-estado material-icons ms-1"
										id="iconTramo_bas">check_circle</i>
								</div>
								<p class="formulario__input-error" id="tramo_basError"></p>
							</div>
							<!-- Grupo: Tramo asfaltado -->
							<div class="formulario__grupo" id="grupo__tramo_asf">
								<label for="tramo_asf" class="formulario__label form-label"><strong>T.
										asfaltado</strong></label>
								<div class="formulario__grupo-input d-flex">
									<input type="text" name="tramo_asf" id="tramo_asf"
										class="formulario__input form-control"
										oninput="validarTramo_asf()"> <i
										class="formulario__validacion-estado material-icons ms-1"
										id="iconTramo_asf">check_circle</i>
								</div>
								<p class="formulario__input-error" id="tramo_asfError"></p>
							</div>
							<!--grupo__proyecto-->
							<div class="formulario__grupo" id="grupo__proyecto">
								<label for="proyecto" class="form-label formulario__label"><strong>Proyecto</strong></label>
								<div class="formulario__grupo-input d-flex">
									<select name="proyecto" id="proyecto"
										class="form-select formulario__input"
										oninput="validarProyecto()">
										<%
								            List<Proyectos> listaProyecto = (List<Proyectos>) request.getAttribute("listaProyectos");
								            if(listaProyecto != null){
                                				for (Proyectos proyecto : listaProyecto) {
								        %>
										<option value="<%= proyecto.getTitulo() %>"><%= proyecto.getTitulo() %></option>
										<%
								            	}
								            }
								        %>
									</select> <i class="formulario__validacion-estado material-icons ms-1"
										id="iconProyecto">check_circle</i>
								</div>
								<p class="formulario__input-error" id="proyectoError"></p>
							</div>
						</div>
						<div class="col-sm-4">
							<!-- Grupo: cunetas -->
							<div class="formulario__grupo" id="grupo__cunetas">
								<label for="cunetas" class="formulario__label form-label"><strong>Cunetas
										terminadas</strong></label>
								<div class="formulario__grupo-input d-flex">
									<input type="text" name="cunetas" id="cunetas"
										class="formulario__input form-control"
										oninput="validarCunetas()"> <i
										class="formulario__validacion-estado material-icons ms-1"
										id="iconCunetas">check_circle</i>
								</div>
								<p class="formulario__input-error" id="cunetasError"></p>
							</div>
							<!-- Grupo: muros -->
							<div class="formulario__grupo" id="grupo__muros">
								<label for="muros" class="formulario__label form-label"><strong>Muros
										terminados</strong></label>
								<div class="formulario__grupo-input d-flex">
									<input type="text" name="muros" id="muros"
										class="formulario__input form-control"
										oninput="validarMuros()"> <i
										class="formulario__validacion-estado material-icons ms-1"
										id="iconMuros">check_circle</i>
								</div>
								<p class="formulario__input-error" id="murosError"></p>
							</div>
							<!-- Grupo: ejecucion -->
							<div class="formulario__grupo" id="grupo__ejecucion">
								<label for="ejecucion" class="formulario__label form-label"><b>%
										de ejecucion</b></label>
								<div class="formulario__grupo-input d-flex">
									<input type="text" name="ejecucion" id="ejecucion"
										class="formulario__input form-control"
										oninput="validarEjecucion()"> <i
										class="formulario__validacion-estado material-icons ms-1"
										id="iconEjecucion">check_circle</i>
								</div>
								<p class="formulario__input-error" id="ejecucionError"></p>
							</div>

						</div>
					</div>
					<div class="row p-3">
						<div class="col-sm">
							<input type="submit" value="Insertar"
								class="btn btn-primary float-end formulario__btn">
						</div>
					</div>
				</form>
			</div>
			<div
				class="col-sm-6 d-flex justify-content-center align-items-center">
				<img src="imagenes/vias-3.jpg" alt=""
					class="img-fluid w-100 rounded">
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
	<script type="text/javascript" src="javaScript/validateAvances.js"></script>
</body>
</html>