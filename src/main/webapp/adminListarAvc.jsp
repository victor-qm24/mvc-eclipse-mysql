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
	<title>Lista de avances</title>
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
        <h1><b>Listar avances</b></h1>
        <h6>Datos almacenados en la base de datos siesweb.</h6>
        <div class="row mt-3">
            <div class="col-sm-8 bg-dark-subtle pt-3 rounded">
                <div class="container-fluid table-responsive" style="max-height: 500px; overflow-y: auto;">
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
</body>
</html>