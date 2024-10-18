<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.siesweb.modelo.TiposDocumentos"%>
<%@ page import="com.siesweb.modelo.Roles"%>
<%@ page import="com.siesweb.modelo.Proyectos"%>
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
<title>Actualizar usuario</title>
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
	<section class="container-fluid bg-body p-5 pt-1"
		style="margin-top: 100px;">
		<h1>
			<b>Actualizar usuarios</b>
		</h1>
		<h6>Es necesario llenar todos los campos del formulario.</h6>
		<div class="row mt-3">
			<div class="col-sm-6 bg-dark-subtle p-3 rounded">
				<form action="actualizar" method="POST" class="formulario"
					id="formulario">
					<div class="row">
						<div class="col-sm-3">
							<!--grupo__id-->
							<div class="formulario__grupo" id="grupo__id">
								<div class="formulario__grupo-input d-flex">
									<input type="text" name="idActualizar" id="idActualizar"
										class=" form-control formulario__input" placeholder="Id"
										oninput="validarIdActualizar()"> <i
										class="formulario__validacion-estado material-icons ms-1"
										id="idActualizarIcon">check_circle</i>
								</div>
								<p class="formulario__input-error" id="idActualizarError"></p>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-6">
							<!--grupo__nombre-->
							<div class="formulario__grupo" id="grupo__nombre">
							<label for="nombre" class="form-label formulario__label"><strong>Nombre</strong></label>
								<div class="formulario__grupo-input d-flex">
									<input type="text" name="nombre" id="nombre"
										class=" form-control formulario__input" placeholder="Ingrese nombre..."
										oninput="validarNombre()"> <i
										class="formulario__validacion-estado material-icons ms-1"
										id="nombreIcon">check_circle</i>
								</div>
								<p class="formulario__input-error" id="nombreError"></p>
							</div>
						</div>
						<div class="col-sm-6">
							<!--grupo__apellidos-->
							<div class="formulario__grupo" id="grupo__apellido">
							<label for="apellido" class="form-label formulario__label"><strong>Apellido</strong></label>
								<div class="formulario__grupo-input d-flex">
									<input type="text" name="apellido" id="apellido"
										class=" form-control formulario__input"
										placeholder="Ingrese apellido..." oninput="validarApellido()"> <i
										class="formulario__validacion-estado material-icons ms-1"
										id="apellidoIcon">check_circle</i>
								</div>
								<p class="formulario__input-error" id="apellidoError"></p>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-6">
							<!--grupo__tipo-->
							<div class="formulario__grupo" id="grupo__tipo">
								<label for="tipo" class="form-label formulario__label"><strong>Tipo 
								de documento</strong></label>
								<div class="formulario__grupo-input d-flex">
									<select name="tipo" id="tipo"
										class="form-select formulario__input" oninput="validarTipo()">
										<%
								            List<TiposDocumentos> listaTipos = (List<TiposDocumentos>) request.getAttribute("listaTipos");
								            if(listaTipos != null){
                                				for (TiposDocumentos tipo : listaTipos) {
								        %>
										<option value="<%= tipo.getDescripcion_tipo() %>"><%= tipo.getDescripcion_tipo() %></option>
										<%
								            	}
								            }
								        %>
									</select> <i class="formulario__validacion-estado material-icons ms-1"
										id="tipoIcon">check_circle</i>
								</div>
								<p class="formulario__input-error" id="tipoError"></p>
							</div>
						</div>
						<div class="col-sm-6">
							<!--grupo__documento-->
							<div class="formulario__grupo" id="grupo__documento">
								<label for="documento" class="form-label formulario__label"><strong>Documento</strong></label>
								<div class="formulario__grupo-input d-flex">
									<input type="text" name="documento" id="documento"
										class=" form-control formulario__input"
										placeholder="Ingrese su documento..." oninput="validarDocumento()">
									<i class="formulario__validacion-estado material-icons ms-1"
										id="documentoIcon">check_circle</i>
								</div>
								<p class="formulario__input-error" id="documentoError"></p>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-6">
							<!--grupo__email-->
							<div class="formulario__grupo" id="grupo__email">
							<label for="email" class="form-label formulario__label"><strong>Email</strong></label>
								<div class="formulario__grupo-input d-flex">
									<input type="text" name="email" id="email"
										class=" form-control formulario__input" placeholder="example@example.com"
										oninput="validarEmail()"> <i
										class="formulario__validacion-estado material-icons ms-1"
										id="emailIcon">check_circle</i>
								</div>
								<p class="formulario__input-error" id="emailError"></p>
							</div>
						</div>
						<div class="col-sm-6">
							<!--grupo__telefono-->
							<div class="formulario__grupo" id="grupo__telefono">
							<label for="telefono" class="form-label formulario__label"><strong>Telefono</strong></label>
								<div class="formulario__grupo-input d-flex">
									<input type="text" name="telefono" id="telefono"
										class="formulario__input form-control" placeholder="0000000000"
										oninput="validarTelefono()"> <i
										class="formulario__validacion-estado material-icons ms-1"
										id="telefonoIcon">check_circle</i>
								</div>
								<p class="formulario__input-error" id="telefonoError"></p>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-6">
							<!--grupo-usuario-->
							<div class="formulario__grupo" id="grupo__usuario">
							<label for="usuario" class="form-label formulario__label"><strong>Usuario</strong></label>
								<div class="formulario__grupo-input d-flex">
									<input type="text" name="usuario" id="usuario"
										class="formulario__input form-control"
										oninput="validarUsuario()" placeholder="Ingrese su usuario..."> <i
										class="formulario__validacion-estado material-icons ms-1"
										id="usuarioIcon">check_circle</i>
								</div>
								<p class="formulario__input-error" id="usuarioError"></p>
							</div>
						</div>
						<div class="col-sm-6">
							<!--grupo-password-->
							<div class="formulario__grupo" id="grupo__password">
							<label for="password" class="form-label formulario__label"><strong>Password</strong></label>
								<div class="formulario__grupo-input d-flex">
									<input type="password" name="password" id="password"
										class="formulario__input form-control"
										oninput="validarPassword()" placeholder="**********"> <i
										class="formulario__validacion-estado material-icons ms-1"
										id="passwordIcon">check_circle</i>
								</div>
								<p class="formulario__input-error" id="passwordError"></p>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-6">
							<!--grupo__rol-->
							<div class="formulario__grupo" id="grupo__rol">
								<label for="rol" class="form-label formulario__label"><strong>Rol</strong></label>
								<div class="formulario__grupo-input d-flex">
									<select name="rol" id="rol"
										class="form-select formulario__input" oninput="validarRol()">
										<%
								            List<Roles> listaRol = (List<Roles>) request.getAttribute("listaRoles");
								            if(listaRol != null){
                                				for (Roles rol : listaRol) {
								        %>
										<option value="<%= rol.getDescripcion_rol() %>"><%= rol.getDescripcion_rol() %></option>
										<%
								            	}
								            }
								        %>
									</select> <i class="formulario__validacion-estado material-icons ms-1"
										id="rolIcon">check_circle</i>
								</div>
								<p class="formulario__input-error" id="rolError"></p>
							</div>
						</div>
						<div class="col-sm-6">
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
										id="proyectoIcon">check_circle</i>
								</div>
								<p class="formulario__input-error" id="proyectoError"></p>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-6">
							<!--grupo__estado-->
							<div class="formulario__grupo" id="grupo__estado">
								<label for="estado" class="form-label formulario__label"><strong>Estado</strong></label>
								<div class="formulario__grupo-input d-flex">
									<select name="estado" id="estado"
										class="form-select formulario__input"
										oninput="validarEstado()">
										<option value="-">-</option>
										<option value="Activo">Activo</option>
										<option value="Inactivo">Inactivo</option>
									</select> <i class="formulario__validacion-estado material-icons ms-1"
										id="estadoIcon">check_circle</i>
								</div>
								<p class="formulario__input-error" id="estadoError"></p>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm">
							<!--Mensaje-exito-error-->							
							<div class="formulario__grupo formulario__grupo-btn-enviar">
								<input type="submit" value="Actualizar"
									class="btn btn-secondary float-end formulario__btn">								
							</div>
						</div>
					</div>
				</form>

			</div>
			<div class="col-sm-6">
				<img src="imagenes/ampliamiento.jpg" alt=""
					class="img-fluid p-2 w-100 rounded">
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
	<script type="text/javascript" src="javaScript/validateUsuarios.js"></script>
</body>
</html>