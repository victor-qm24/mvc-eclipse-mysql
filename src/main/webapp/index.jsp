<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>Iniciar sesión</title>
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
			<ul>
				<li class="d-inline"><a href="#" class="navbar-brand"><img
						src="imagenes/logo_siesweb_v2.jpg" alt="" class="img-fluid">
						</a></li>
				<li class="d-inline"><a href="#" class="navbar-brand"><img
						src="imagenes/logo-ing-vias.PNG" alt="" class="img-fluid">
						</a></li>
			</ul>
		</div>
	</nav>
	<section class="container-fluid bg-body p-5 pt-1"
		style="margin-top: 100px;" id="sec-login">
		<h1>
			<b>Iniciar sesión</b>
		</h1>
		<h6>Acceder para ingresar a SIES WEB Vial</h6>
		<div class="row mt-3">
			<div class="col-sm-6">
				<form action="iniciarSesion" method="POST"
					class="formulario bg-dark-subtle rounded p-5 h-100" id="formulario"
					name="formulario">
					<div class="row mb-3 pt-5">
						<div class="col-sm-4">
							<img src="imagenes/logo_login.png" class="img-fluid w-100">
						</div>
						<div class="col-sm-8">
							<!--grupo-usuario-->
							<div class="formulario__grupo" id="grupo__usuario">
								<label for="usuario" class="form-label formulario__label">
								<strong>Usuario</strong></label>
								<div class="formulario__grupo-input d-flex">
									<input type="text" name="usuario" id="usuario"
										placeholder="Ingrese su usuario..."
										class="formulario__input form-control mb-2"
										oninput="validarUsuario()"> <i
										class="material-icons ms-1"
										id="usuarioIcon">check_circle</i>
								</div>
								<p class="formulario__input-error" id="usuarioError"></p>
							</div>
							<!--grupo-password-->
							<div class="formulario__grupo" id="grupo__password">
								<label for="password" class="form-label formulario__label"><strong>Password</strong></label>
								<div class="formulario__grupo-input d-flex">									
									<input type="password" name="password" id="password"
										placeholder="**********"
										class="formulario__input form-control"
										oninput="validarPassword()">
									<!--<a href="#" id="cambio" ><i class="material-icons">remove_red_eye</i></a>-->
									<i class="formulario__validacion-estado material-icons ms-1"
										id="passwordIcon">check_circle</i>
								</div>
								<p class="formulario__input-error" id="passwordError"></p>
							</div>
							<!--Mensaje-exito-error-->					
							
							<div class="formulario__grupo formulario__grupo-btn-enviar mt-4">
								<a href="cargarRegistro" class="">Eres nuevo, registrate.</a>
								<input
									type="submit" value="Iniciar sesión"
									class="btn btn-primary float-end formulario__btn">								
							</div>
						</div>
					</div>
				</form>
			</div>
			<div class="col-sm-6">
				<img src="imagenes/img-index.jpg" alt=""
					class="img-fluid w-100 rounded">
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
	<script type="text/javascript" src="javaScript/validateUsuarios.js"></script>
</body>
</html>