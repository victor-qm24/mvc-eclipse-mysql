<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.siesweb.modelo.Solicitudes"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	<title>SIES WEB - Admin - solicitudes</title>
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
						<li><a class="dropdown-item" href="adminBuscarEliminarUser.jsp">Buscar - Eliminar</a></li>
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
						<li><a class="dropdown-item" href="adminTipo.jsp">Tipos de documento</a></li>
						<li><a class="dropdown-item" href="adminRol.jsp">Roles</a></li>
						<li><a class="dropdown-item" href="adminProyecto.jsp">Proyectos</a></li>
						<li><a class="dropdown-item" href="adminSolicitud.jsp">Solicitudes</a></li>
						<li><a class="dropdown-item" href="adminTema.jsp">Temas</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</nav>
	<section class="container-fluid p-3 border-bottom" style="margin-top: 100px;" id="sec-tipo">
        <h1><b>CRUD Solicitudes</b></h1>
        <h6>Aqui puedes eliminar y listar.</h6>        
        <div class="row p-3">
        	<div class="col-sm-4 border-end">
        		<form method="POST" action="actualizarSolicitud">
        			<div class="row">
        				<div class="col-sm-6"></div>
        				<div class="col-sm-3">
        					<!--grupo_id-->
			                <div class="formulario__grupo" id="grupo__id">                                
			                    <div class="formulario__grupo-input d-flex">
			                        <input type="text" name="idSolicitud" id="idSolicitud" class=" form-control formulario__input" placeholder="Id" oninput="validarIdSolicitud()">
			                        <i class="formulario__validacion-estado material-icons ms-1" id="iconIdSolicitud">check_circle</i>
			                    </div>
			                    <p class="formulario__input-error" id="idSolicitudError"></p>
			                </div>
        				</div>        				       				
        				<div class="col-sm-3">
        					<!--gurpo_button_eliminar--> 
		                    <div class="formulario__grupo formulario__grupo-btn-enviar">                                                       
		                        <input type="submit" value="Ejecutar" class="btn btn-danger float-end formulario__btn">
		                    </div>
        				</div>
        			</div>
        			<div class="row">
        				<div class="col-sm-9"></div>
        				<div class="col-sm-3">
        					<!--gurpo_button_listar--> 
		                    <div class="formulario__grupo formulario__grupo-btn-enviar">
		                    	<a class="btn btn-info float-end" href="listarSolicitud">Listar</a>
		                    </div>
        				</div>
        			</div>
        		</form>
        	</div>
        	<div class="col-sm-8">
        		<div class="container-fluid table-responsive" style="max-height: 550px; overflow-y: auto;">
				    <table class="table table-hover text-center">
				        <thead class="table-primary">
				            <tr>				                
				                <th>ID</th>
				                
				                <th>Observacion</th>				                
				                <th>Proyecto</th>
				                <th>Tema</th>
				                <th>Usuario</th>
				                <th>Estado</th>				                
				            </tr>
				        </thead>
				        <tbody>
				            <% 
				            	List<Solicitudes> listaSolicitudes = (List<Solicitudes>) request.getAttribute("listaSolicitudes");
				            	if(listaSolicitudes != null){
					            	for(Solicitudes solicitud:listaSolicitudes){
					            		out.print("<tr>");
					            		out.print("<td>" + solicitud.getId() + "</td>");
					            		//out.print("<td>" + solicitud.getFecha() + "</td>");
					            		out.print("<td>" + solicitud.getObservacion() + "</td>");
					            		
					            		if(solicitud.getProyectoId() == 1){
					            			out.print("<td>" + "Pavimentacion PALMITAS-LERMA" + "</td>");}
					            		
					            		if(solicitud.getTemaId() == 1){
					            			out.print("<td>" + "Citas" + "</td>");
					            		}else if(solicitud.getTemaId() == 2){
					            			out.print("<td>" + "Daños" + "</td>");
					            		}else{out.print("<td>" + "Otros" + "</td>");}
					            		
					            		out.print("<td>" + solicitud.getUsuarioId() + "</td>");
					            		out.print("<td>" + solicitud.getEstado() + "</td>");
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
</body>
</html>