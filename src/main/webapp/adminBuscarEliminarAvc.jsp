<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.siesweb.modelo.Avances"%> 	
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	<title>Buscar y eliminar avances</title>
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
	<section class="container-fluid bg-body p-5 pt-1" style="margin-top: 100px;">
        <h1><b>Buscar o eliminar avances</b></h1>
        <h6>Es necesario conocer el id del avance a buscar o eliminar..</h6>
        <div class="row mt-3">
            <div class="col-sm-8 bg-dark-subtle pt-3 rounded">
            	<div class="row pt-3">
            		<div class="col-sm">
            			<form action="buscarAvce" method="POST" class="formulario" id="formulario" onsubmit="return validarFormulario();">
		                    <div class="row">                    	
			        			<div class="col-sm-2">
			        				<!--grupo__id-->
		                            <div class="formulario__grupo" id="grupo__id">                                
		                                <div class="formulario__grupo-input d-flex">
		                                    <input type="text" name="idLoad" id="idLoad" class=" form-control formulario__input" placeholder="Id" oninput="validarIdLoad()">
		                                    <i class="formulario__validacion-estado material-icons ms-1" id="iconIdLoad">check_circle</i>
		                                </div>
		                                <p class="formulario__input-error" id="idLoadError"></p>
		                            </div>
			        			</div>
			        			<div class="col-sm-3">
			        				<input type="submit" value="Buscar" class="btn btn-success formulario__btn">	        					        				
			        			</div>
		                    </div> 		                                
		                </form>
		                <form action="eliminarAvc" method="POST" class="formulario" id="formulario" onsubmit="return validarFormulario();">
		                    <div class="row">                    	
			        			<div class="col-sm-2">
			        				<!--grupo__id-->
		                            <div class="formulario__grupo" id="grupo__id">                                
		                                <div class="formulario__grupo-input d-flex">
		                                    <input type="text" name="idDelete" id="idDelete" class=" form-control formulario__input" placeholder="Id" oninput="validarIdDelete()">
		                                    <i class="formulario__validacion-estado material-icons ms-1" id="iconIdDelete">check_circle</i>
		                                </div>
		                                <p class="formulario__input-error" id="idDeleteError"></p>
		                            </div>
			        			</div> 
			        			<div class="col-sm-3">
			        				<input type="submit" value="Eliminar" class="btn btn-danger float-start formulario__btn">	        					        				
			        			</div>
		                    </div> 		                               
		                </form>
            		</div>            		
            	</div>
                
                <div class="container-fluid table-responsive" style="max-height: 200px; overflow-y: auto;">
				    <table class="table table-hover mt-3 text-center">
				        <thead class="table-primary">
				            <tr>				                
				                <th>ID</th>
				                <th>Fecha</th>
				                <th>T. amp</th>
				                <th>T. mej</th>
				                <th>T. sub</th>
				                <th>T. bas</th>
				                <th>T. asf</th>
				                <th>Cunetas</th>
				                <th>Muros</th>				                
				                <th>% ejecucion</th>
				                <th>Proyecto</th>
				            </tr>
				        </thead>
				        <tbody>
				            <% 
				            	List<Avances> listaAvances = (List<Avances>) request.getAttribute("Avanc");
				            	if(listaAvances != null){
					            	for(Avances avance:listaAvances){
					            		out.print("<tr>");
					            		out.print("<td>" + avance.getId() + "</td>");
					            		out.print("<td>" + avance.getFecha() + "</td>");
					            		out.print("<td>" + avance.getTramo_amp() + "</td>");
					            		out.print("<td>" + avance.getTramo_mej() + "</td>");
					            		out.print("<td>" + avance.getTramo_sub() + "</td>");
					            		out.print("<td>" + avance.getTramo_bas() + "</td>");
					            		out.print("<td>" + avance.getTramo_asf() + "</td>");
					            		out.print("<td>" + avance.getCunetas() + "</td>");				            						            		
					            		out.print("<td>" + avance.getMuros() + "</td>");
					            		out.print("<td>" + avance.getPorcentaje_ejecucion() + "</td>");					            		
					            		
					            		if(avance.getProyectoId() == 1){
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
    <script type="text/javascript" src="javaScript/validateAvances.js"></script>
</body>
</html>