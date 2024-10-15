<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.siesweb.modelo.TiposDocumentos"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	<title>SIES WEB - Admin - Tipo de documento</title>
</head>
<body>
	<nav class="navbar navbar-expand-sm fixed-top bg-light">
		<div class="container-fluid">
			<ul class="d-flex justify-content-center align-items-center nav-justified">
				<li class="d-inline"><a href="admin.jsp" class="navbar-brand"><img
						src="imagenes/logo_siesweb.jpg" alt="" class="img-fluid"></a></li>
				<li class="d-inline"><a href="#" class="navbar-brand"><img
						src="imagenes/logo-ing-vias.PNG" alt="" class="img-fluid"></a></li>
			</ul>
			<ul class="nav nav-pills d-flex justify-content-center align-items-center nav-justified">
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
				<li><a class="dropdown-item" href="logout"><i class="material-icons text-primary">logout</i></a></li>
			</ul>
		</div>
	</nav>
    <section class="container-fluid p-3 border-bottom" style="margin-top: 100px;" id="sec-tipo">
        <h1><b>CRUD Tipos de documento</b></h1>
        <h6>Aqui puedes insertar, actualizar, eliminar y listar.</h6>        
        <div class="row p-3">
        	<div class="col-sm-6 border-end">
        		<form method="POST" action="insertarTipo">
        			<!--grupo_descricpion_tipo-->
	                <div class="formulario__grupo" id="grupo__descTipo">                                
	                    <div class="formulario__grupo-input d-flex">
	                        <input type="text" name="descTipo" id="descTipo" class=" form-control formulario__input mb-2" placeholder="Descripcion" oninput="validarDescTipo()">
	                        <i class="formulario__validacion-estado material-icons ms-1" id="iconDescTipo">check_circle</i>
	                    </div>
	                    <p class="formulario__input-error" id="descTipoError"></p>
	                </div>
                    <!--gurpo_button_enviar--> 
                    <div class="formulario__grupo formulario__grupo-btn-enviar">                                                       
                        <input type="submit" value="Insertar" class="btn btn-primary float-end formulario__btn">
                    </div>                	
        		</form>
        	</div>
        	<div class="col-sm-6">
        		<form method="POST" action="actualizarTipo">
        			<div class="row">
        				<div class="col-sm-3">
        					<!--grupo_id-->
                            <div class="formulario__grupo" id="grupo__id">                                
                                <div class="formulario__grupo-input d-flex">
                                    <input type="text" name="idTipo" id="idTipo" class=" form-control formulario__input mb-2" placeholder="Id" oninput="validarIdTipo()">
                                    <i class="formulario__validacion-estado material-icons ms-1" id="iconIdTipo">check_circle</i>
                                </div>
                                <p class="formulario__input-error" id="idTipoError"></p>
                            </div>                            
        				</div>
        				<div class="col-sm-9">
        					<!--grupo_descricpion_tipo-->
			                <div class="formulario__grupo" id="grupo__descripcionTipo">                                
			                    <div class="formulario__grupo-input d-flex">
			                        <input type="text" name="descripcionTipo" id="descripcionTipo" class=" form-control formulario__input mb-2" placeholder="Descripcion" oninput="validarDescripcionTipo()">
			                        <i class="formulario__validacion-estado material-icons ms-1" id="iconDescripcionTipo">check_circle</i>
			                    </div>
			                    <p class="formulario__input-error" id="descripcionTipoError"></p>
			                </div>
        				</div>
        			</div>
        			<div class="row">
        				<div class="col-sm">
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
        		<form action="eliminarTipo" method="POST">
        			<div class="row">        			
        				<div class="col-sm-6"></div>        				
        				<div class="col-sm-3">
	        				<!--grupo_id-->
			                <div class="formulario__grupo" id="grupo__id">                                
			                    <div class="formulario__grupo-input d-flex">
			                        <input type="text" name="idTipoDoc" id="idTipoDoc" class=" form-control formulario__input mb-2" placeholder="Id" oninput="validarIdTipoDoc()">
			                        <i class="formulario__validacion-estado material-icons ms-1" id="iconIdTipoDoc">check_circle</i>
			                    </div>
			                    <p class="formulario__input-error" id="idTipoDocError"></p>
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
	                    	<a class="btn btn-info float-end" href="listarTipo">Listar</a>
	                    </div>
	        		</div>
        		</div>
        	</div>
        	<div class="col-sm-6">
        		<div class="container-fluid table-responsive" style="max-height: 100px; overflow-y: auto;">
				    <table class="table table-hovertext-center">
				        <thead class="table-primary">
				            <tr>				                
				                <th>ID</th>
				                <th>Descripcion</th>				                
				            </tr>
				        </thead>
				        <tbody>
				            <% 
				            	List<TiposDocumentos> listaTipos = (List<TiposDocumentos>) request.getAttribute("listaTipos");
				            	if(listaTipos != null){
					            	for(TiposDocumentos tipo:listaTipos){
					            		out.print("<tr>");
					            		out.print("<td>" + tipo.getId() + "</td>");
					            		out.print("<td>" + tipo.getDescripcion_tipo() + "</td>");					            		
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
    <footer class="p-2 bg-dark text-white text-center position-absolute w-100 bottom-0">
    	<div class="row">
    		<div class="col-sm-3"></div>
    		<div class="col-sm-6">
	   			<ul class="list-unstyled">
		            <li class="d-inline p-2"><i class="material-icons">phone</i> +57-313-573-5659</li>
		            <li class="d-inline p-2"><i class="material-icons">facebook</i> /sieswebvial</li>
		            <li class="d-inline p-2"><i class="material-icons">mail</i> sieswebvial@gmail.com</li>
		        </ul>
    		</div>
    		<div class="col-sm-3"></div>
    	</div>        
    </footer>
</body>
</html>