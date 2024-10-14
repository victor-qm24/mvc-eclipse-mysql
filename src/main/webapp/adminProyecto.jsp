<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.siesweb.modelo.Avances"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	<title>SIES WEB - Admin - proyectos</title>
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
						<li><a class="dropdown-item" href="cargarInsercion">Agregar</a></li>
						<li><a class="dropdown-item" href="cargarActualizacion">Actualizar</a></li>
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
        <h1><b>CRUD Proyectos</b></h1>
        <h6>Aqui puedes insertar, actualizar, eliminar y listar.</h6>        
        <div class="row p-3">
        	<div class="col-sm-6 border-end">
        		<form method="POST" action="insertarProyecto">
        			<div class="row">
        				<div class="col-sm-7">
        					<!--grupo_titulo-->
			                <div class="formulario__grupo" id="grupo__titulo">                                
			                    <div class="formulario__grupo-input d-flex">
			                        <input type="text" name="titulo" id="titulo" class=" form-control formulario__input" placeholder="Titulo" oninput="validarTitulo()">
			                        <i class="formulario__validacion-estado material-icons ms-1" id="iconTitulo">check_circle</i>
			                    </div>
			                    <p class="formulario__input-error" id="tituloError"></p>
			                </div>
        				</div>
        				<div class="col-sm-1">
        					<label for="estado" class="form-label formulario__label">Estado</label>
        				</div>        				
        				<div class="col-sm-4">
        					<!--grupo__estado-->
                            <div class="formulario__grupo" id="grupo__estado">                                                                
                                <div class="formulario__grupo-input d-flex">
                                    <select name="estado" id="estado" class="form-select formulario__input" oninput="validarEstadoo()">
                                        <option value="-">-</option>
                                        <option value="Ejecucion">Ejecucion</option> 
                                        <option value="Terminado">Terminado</option> 
                                        <option value="Suspendido">Suspendido</option>                                        
                                    </select>
                                    <i class="formulario__validacion-estado material-icons ms-1" id="iconEstado">check_circle</i>
                                </div>
                                <p class="formulario__input-error" id="estadoError"></p>
                            </div>
        				</div>
        			</div>
        			<div class="row">
        				<div class="col-sm-7">
        					<!--grupo__ubicacion-->
                            <div class="formulario__grupo" id="grupo__ubicacion">                                
                                <div class="formulario__grupo-input d-flex">
                                    <input type="text" name="ubicacion" id="ubicacion" class=" form-control formulario__input" placeholder="Ubicacion" oninput="validarUbicacion()">
                                    <i class="formulario__validacion-estado material-icons ms-1" id="iconUbicacion">check_circle</i>
                                </div>
                                <p class="formulario__input-error" id="ubicacionError"></p>
                            </div>
        				</div>
        				
        				<div class="col-sm-1"></div>
        				<div class="col-sm-4">
        					<!--gurpo_button_enviar--> 
		                    <div class="formulario__grupo formulario__grupo-btn-enviar">                                                       
		                        <input type="submit" value="Insertar" class="btn btn-primary float-end formulario__btn">
		                    </div> 
        				</div>
        			</div>        	
        		</form>
        	</div>
        	<div class="col-sm-6">
        		<form method="POST" action="actualizarProyecto">
        			<div class="row">
        				<div class="col-sm-2">
        					<!--grupo_id-->
			                <div class="formulario__grupo" id="grupo__id">                                
			                    <div class="formulario__grupo-input d-flex">
			                        <input type="text" name="idProyecto" id="idProyecto" class=" form-control formulario__input" placeholder="Id" oninput="validarIdProyecto()">
			                        <i class="formulario__validacion-estado material-icons ms-1" id="iconIdProyecto">check_circle</i>
			                    </div>
			                    <p class="formulario__input-error" id="idProyectoError"></p>
			                </div>
        				</div>
        				<div class="col-sm-5">
        					<!--grupo_titulo-->
			                <div class="formulario__grupo" id="grupo__title">                                
			                    <div class="formulario__grupo-input d-flex">
			                        <input type="text" name="title" id="title" class=" form-control formulario__input" placeholder="Titulo" oninput="validarTitle()">
			                        <i class="formulario__validacion-estado material-icons ms-1" id="iconTitle">check_circle</i>
			                    </div>
			                    <p class="formulario__input-error" id="titleError"></p>
			                </div>
        				</div>
        				<div class="col-sm-1">
        					<label for="estado" class="form-label formulario__label">Estado</label>
        				</div>        				
        				<div class="col-sm-4">
        					<!--grupo__estado-->
                            <div class="formulario__grupo" id="grupo__state">                                                                
                                <div class="formulario__grupo-input d-flex">
                                    <select name="state" id="state" class="form-select formulario__input" oninput="validarState()">
                                        <option value="-">-</option>
                                        <option value="Ejecucion">Ejecucion</option> 
                                        <option value="Terminado">Terminado</option> 
                                        <option value="Suspendido">Suspendido</option>                                        
                                    </select>
                                    <i class="formulario__validacion-estado material-icons ms-1" id="iconState">check_circle</i>
                                </div>
                                <p class="formulario__input-error" id="stateError"></p>
                            </div>
        				</div>
        			</div>
        			<div class="row">
        				<div class="col-sm-7">
        					<!--grupo__ubicacion-->
                            <div class="formulario__grupo" id="grupo__ubication">                                
                                <div class="formulario__grupo-input d-flex">
                                    <input type="text" name="ubication" id="ubication" class=" form-control formulario__input" placeholder="Ubicacion" oninput="validarUbication()">
                                    <i class="formulario__validacion-estado material-icons ms-1" id="iconUbication">check_circle</i>
                                </div>
                                <p class="formulario__input-error" id="ubicationError"></p>
                            </div>
        				</div>
        				
        				<div class="col-sm-1"></div>
        				<div class="col-sm-4">
        					<!--gurpo_button_enviar--> 
		                    <div class="formulario__grupo formulario__grupo-btn-enviar">                                                       
		                        <input type="submit" value="Actualizar" class="btn btn-secondary float-end formulario__btn">
		                    </div> 
        				</div>
        			</div>        	
        		</form>
        	</div>
        </div>
        <hr>
        <div class="row p-3">
        	<div class="col-sm-6 border-end">
        		<form action="eliminarProyecto" method="POST">
        			<div class="row">        			
        				<div class="col-sm-6"></div>        				
        				<div class="col-sm-3">
	        				<!--grupo_id-->
			                <div class="formulario__grupo" id="grupo__id">                                
			                    <div class="formulario__grupo-input d-flex">
			                        <input type="text" name="idProyectos" id="idProyectos" class=" form-control formulario__input" placeholder="Id" oninput="validaridProyectos()">
			                        <i class="formulario__validacion-estado material-icons ms-1" id="iconidProyectos">check_circle</i>
			                    </div>
			                    <p class="formulario__input-error" id="idProyectosError"></p>
			                </div>
	        			</div>
	        			<div class="col-sm-3">
	        				<!--gurpo_button_eliminar--> 
		                    <div class="formulario__grupo formulario__grupo-btn-enviar">                                                       
		                        <input type="submit" value="Eliminar" class="btn btn-danger float-end formulario__btn">
		                    </div>
	        			</div>        			
        			</div>
        		</form>        		
        		<div class="row">
	        		<div class="col-sm">
	        			<!--gurpo_button_listar--> 
	                    <div class="formulario__grupo formulario__grupo-btn-enviar">
	                    	<a class="btn btn-info float-end" href="listarProyecto">Listar</a>
	                    </div>
	        		</div>
        		</div>
        	</div>
        	<div class="col-sm-6">
        		<div class="container-fluid table-responsive" style="max-height: 100px; overflow-y: auto;">
				    <table class="table table-hover text-center">
				        <thead class="table-primary">
				            <tr>				                
				                <th>ID</th>
				                <th>Titulo</th>
				                <th>Estado</th>
				                <th>Ubicacion</th>				                
				            </tr>
				        </thead>
				        <tbody>
				            <% /*
				            	List<Avances> listaAvances = (List<Avances>) request.getAttribute("Avanc");
				            	if(listaAvances != null){
					            	for(Avances avance:listaAvances){
					            		out.print("<tr>");
					            		out.print("<td>" + avance.getId() + "</td>");
					            		out.print("<td>" + avance.getFecha() + "</td>");					            		
					            		out.print("<tr>");
					            	}
				            	}*/
				            %>
				        </tbody>
				    </table>
			    </div>
        	</div>
        </div>
    </section>
    <footer class="p-2 bg-dark text-white text-center">
        <ul class="list-unstyled">
            <li class="d-inline p-2"><i class="material-icons">phone</i> +57-313-573-5659</li>
            <li class="d-inline p-2"><i class="material-icons">facebook</i> /sieswebvial</li>
            <li class="d-inline p-2"><i class="material-icons">mail</i> sieswebvial@gmail.com</li>
        </ul>
    </footer>
</body>
</html>