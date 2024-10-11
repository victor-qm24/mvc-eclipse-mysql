<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.siesweb.modelo.Usuarios"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	<title>Buscar usuario</title>
</head>
<body>
	<nav class="navbar navbar-expand-sm fixed-top bg-light">
		<div class="container-fluid">
			<ul>
				<li class="d-inline"><a href="admin.jsp" class="navbar-brand"><img
						src="imagenes/logo_siesweb.jpg" alt="" class="img-fluid"></a></li>
				<li class="d-inline"><a href="#" class="navbar-brand"><img
						src="imagenes/logo-ing-vias.PNG" alt="" class="img-fluid"></a></li>
			</ul>
			<ul class="nav nav-pills">
				<li class="nav-item"><a class="nav-link" href="admin.jsp">Inicio</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					data-bs-toggle="dropdown">Usuarios</a>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" href="adminAgregarUser.jsp">Agregar</a></li>
						<li><a class="dropdown-item" href="adminActualizarUser.jsp">Actualizar</a></li>
						<li><a class="dropdown-item" href="adminBuscarUser.jsp">Buscar</a></li>
						<li><a class="dropdown-item" href="adminEliminarUser.jsp">Eliminar</a></li>
						<li><a class="dropdown-item" href="listar">Listar</a></li>
					</ul>
				</li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					data-bs-toggle="dropdown">Avances</a>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" href="adminInsertarAvc.jsp">Insertar</a></li>
						<li><a class="dropdown-item" href="adminActualizarAvc.jsp">Actualizar</a></li>
						<li><a class="dropdown-item" href="adminBuscarEliminarAvc.jsp">Buscar - Eliminar</a></li>
						<li><a class="dropdown-item" href="listarAvc">Listar</a></li>
					</ul>
				</li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					data-bs-toggle="dropdown">Más</a>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" href="#">Tipos de documento</a></li>
						<li><a class="dropdown-item" href="#">Roles</a></li>
						<li><a class="dropdown-item" href="#">Proyectos</a></li>
						<li><a class="dropdown-item" href="#">Solicitudes</a></li>
						<li><a class="dropdown-item" href="#">Temas</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</nav>
    <section class="container-fluid bg-body p-5 pt-1" style="margin-top: 100px;">
        <h1><b>Buscar usuarios</b></h1>
        <h6>Es necesario conocer el id del usuario a buscar..</h6>
        <div class="row mt-3">
            <div class="col-sm-8 bg-dark-subtle pt-3 rounded">
                <form action="buscar" method="POST" class="formulario" id="formulario" onsubmit="return validarFormulario();">
                    <div class="row mb-2">
                    	<div class="col-sm-3">
                    		<!--grupo__id-->
                            <div class="formulario__grupo" id="grupo__id">                                
                                <div class="formulario__grupo-input d-flex">
                                    <input type="text" name="id" id="id" class=" form-control formulario__input mb-2" placeholder="Id" oninput="validarId()">
                                    <i class="formulario__validacion-estado material-icons ms-1" id="iconId">check_circle</i>
                                </div>
                                <p class="formulario__input-error" id="idError"></p>
                            </div>
                    	</div>
                    	<div class="col-sm-3">
                            <!--Mensaje-exito-error-->                            
                            <div class="formulario__mensaje h-50 border rounded bg-danger ps-2 pe-2 lh-1 d-none mt-2" id="formulario__mensaje">
                                <p><i class="material-icons me-2">assignment_late</i><b>Error: </b>Por favor rellena el formulario correctamente.</p>
                            </div>
                            <div class="formulario__grupo formulario__grupo-btn-enviar">                                                       
                                <input type="submit" value="Buscar" class="btn btn-primary float-start formulario__btn">
                                <p class="formulario__mensaje-exito text-success d-none" id="formulario__mensaje-exito">Te has registrado exitosamente!</p>
                            </div>
                        </div> 
                    </div>             
                </form>
                <div class="container-fluid table-responsive" style="max-height: 200px; overflow-y: auto;">
				    <table class="table table-hover mt-3 text-center">
				        <thead class="table-primary">
				            <tr>
				                <th>ID</th>
				                <th>Nombre</th>
				                <th>Apellido</th>
				                <th>Tipo DNI</th>
				                <th>Documento</th>
				                <th>Email</th>
				                <th>Telefono</th>
				                <th>Usuario</th>
				                <th>Contraseña</th>				                
				                <th>Rol</th>
				                <th>Proyecto</th>
				            </tr>
				        </thead>
				        <tbody>
				            <% 
				            	List<Usuarios> listaUsuarios = (List<Usuarios>) request.getAttribute("User");
				            	if(listaUsuarios != null){
					            	for(Usuarios usuario:listaUsuarios){
					            		out.print("<tr>");
					            		out.print("<td>" + usuario.getId() + "</td>");
					            		out.print("<td>" + usuario.getNombre() + "</td>");
					            		out.print("<td>" + usuario.getApellido() + "</td>");
					            		
					            		if(usuario.getTipoDocumentoId() == 1){
					            			out.print("<td>" + "Cedula de ciudadania" + "</td>");
					            		}else if(usuario.getTipoDocumentoId() == 2){
					            			out.print("<td>" + "Cedula extrangera" + "</td>");
					            		}else{out.print("<td>" + "Tarjeta de identidad" + "</td>");} 
					            		
					            		out.print("<td>" + usuario.getDocumento() + "</td>");
					            		out.print("<td>" + usuario.getEmail() + "</td>");
					            		out.print("<td>" + usuario.getTelefono() + "</td>");
					            		out.print("<td>" + usuario.getUsuario() + "</td>");
					            		out.print("<td>" + usuario.getPassword() + "</td>");				            						            		
					            		
					            		if(usuario.getRolId() == 1){
					            			out.print("<td>" + "Administrador" + "</td>");
					            		}else if(usuario.getRolId() == 2){
					            			out.print("<td>" + "Cliente" + "</td>");
					            		}else{out.print("<td>" + "Invitado" + "</td>");}
					            		
					            		if(usuario.getProyectoId() == 1){
					            			out.print("<td>" + "Pavimentacion PALMITAS-LERMA" + "</td>");}				            		
					            		
					            		out.print("<tr>");
					            	}
				            	}
				            %>
				        </tbody>
				    </table>
			    </div>
            </div>
            <div class="col-sm-4">
                <img src="imagenes/asfaltado-2.jpg" alt="" class="img-fluid w-100 rounded">
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
    <script type="text/javascript" src="javaScript/validateUsuarios.js"></script>
</body>
</html>