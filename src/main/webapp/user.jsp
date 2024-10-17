<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.siesweb.modelo.Avances"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="javax.servlet.RequestDispatcher"%>
<%@ page import="java.util.List"%>
<%@ page import="com.siesweb.modelo.Temas"%>
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
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<title>SIES WEBb</title>
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
				<li class="d-inline"><a href="admin.jsp" class="navbar-brand"><img
						src="imagenes/logo_siesweb_v2.jpg" alt="" class="img-fluid"></a></li>
				<li class="d-inline"><a href="#" class="navbar-brand"><img
						src="imagenes/logo-ing-vias.PNG" alt="" class="img-fluid"></a></li>
			</ul>
			<ul class="nav nav-pills justify-content-end">
				<li class="nav-item"><a class="nav-link" href="#sec-inicio">Inicio</a></li>
				<li class="nav-item"><a class="nav-link"
					href="#sec-estadisticas">Estadisticas</a></li>
				<li class="nav-item"><a class="nav-link"
					href="#sec-solicitudes">Solicitudes</a></li>
				<li class="nav-item"><a class="nav-link"
					href="#sec-quienesSomos">¿Quienes somos?</a></li>
				<li><a class="dropdown-item " href="logout"><i
					class="material-icons nav-link">logout</i></a></li>
			</ul>
		</div>
	</nav>
	<section class="container-fluid p-3" style="margin-top: 100px;"
		id="sec-inicio">
		<% 
		if (session != null && session.getAttribute("nombreUser") != null) {
        	String name = (String) session.getAttribute("nombreUser");
        	out.print("<h1> !Bienvenido <strong>" + name + "</strong>¡</h1>");
    	}else {
    		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
        }
        %>
		<hr>
		<div class="container-fluid bg-light">
			<div class="row text-center">			
				<div class="col-sm">
					<h2>
						<b>Nombre del proyecto</b>
					</h2>
					<p class="display-6">Desarrollo de un aplicativo web para la
						visualización de estadísticas viales mediante el análisis de la
						información sobre el manejo de solicitudes por intervención de
						propiedades privadas en la obra de pavimentación PALMITAS-LERMA</p>							
				</div>			
			</div>
			<div class="row p-4">			
				<div class="col-sm embed-responsive">
					<video class="embed-responsive-item mx-auto d-block" controls>
				    	<source src="imagenes/lerma-via.mp4" type="video/mp4">			    			    
					</video>								
				</div>			
			</div>
		</div>		
	</section>
	<section class="container-fluid p-3"
		id="sec-estadisticas">
		<h1>
			<b>Pavimentación Palmitas - Lerma</b>
		</h1>
		<h4>Avances estadisticos</h4>
		<div class="row mt-3">
			<h4>Valores actuales</h4>
			<div class="col-sm p-3 ms-2 me-2 rounded border border-success">
				<div class="container-fluid table-responsive"
					style="max-height: 500px; overflow-y: auto;">
					<table class="table table-borderless text-center">
						<thead class="">
							<tr class="">
								<th class="text-primary"><h5>Tramo ampliado (m)</h5></th>
								<th class="text-primary"><h5>Tramo mejorado (m)</h5></th>
								<th class="text-primary"><h5>Tramo subBase (m)</h5></th>
								<th class="text-primary"><h5>Tramo base (m)</h5></th>
								<th class="text-primary"><h5>Tramo asfaltado (m)</h5></th>
								<th class="text-primary"><h5>Cunetas terminadas</h5></th>
								<th class="text-primary"><h5>Muros terminados</h5></th>								
								<th class="text-primary"><h5>Ejecucion (%)</h5></th>
							</tr>
						</thead>
						<tbody>
							<% 
				            	Avances avance = (Avances) request.getAttribute("avancesUltimo");
				            	if(avance != null){					            	
					            		out.print("<tr>");					            		
					            		out.print("<td><h2 class='display-2'>" + avance.getTramo_amp() + "</h2></td>");
					            		out.print("<td><h2 class='display-2'>" + avance.getTramo_mej() + "</h2></td>");
					            		out.print("<td><h2 class='display-2'>" + avance.getTramo_sub() + "</h2></td>");
					            		out.print("<td><h2 class='display-2'>" + avance.getTramo_bas() + "</h2></td>");
					            		out.print("<td><h2 class='display-2'>" + avance.getTramo_asf() + "</h2></td>");
					            		out.print("<td><h2 class='display-2'>" + avance.getCunetas() + "</h2></td>");
					            		out.print("<td><h2 class='display-2'>" + avance.getMuros() + "</h2></td>");
					            		out.print("<td><h2 class='display-2'>" + avance.getPorcentaje_ejecucion() + "</td>");
					            		out.print("<tr>");					            	
				            	}
				            %>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<hr>
		<div class="row mt-3 ">
			<h4 >Graficas de historicos</h4>
			<div class="col-sm p-3 ms-2 me-2 rounded border border-success">
				<div class="container-fluid table-responsive" style="max-height: 500px; overflow-y: auto;">
					<table class="table table-borderless text-center">
						<thead class="">
							<tr class="">
								
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><canvas id="myChartTramo_amp" style="width:100%;max-width:300px" class=""></canvas></td>
								<td><canvas id="myChartTramo_mej" style="width:100%;max-width:300px" class=""></canvas></td>
								<td><canvas id="myChartTramo_sub" style="width:100%;max-width:300px" class=""></canvas></td>
								<td><canvas id="myChartTramo_bas" style="width:100%;max-width:300px" class=""></canvas></td>										
							</tr>
							<tr>
								<td><canvas id="myChartTramo_asf" style="width:100%;max-width:300px" class=""></canvas></td>
								<td><canvas id="myChartEjecucion" style="width:100%;max-width:300px" class=""></canvas></td>
								<td><canvas id="myChartCunetas" style="width:100%;max-width:300px" class=""></canvas></td>
								<td><canvas id="myChartMuros" style="width:100%;max-width:300px" class=""></canvas></td>
							</tr>							
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<script type="text/javascript">
			// Obtener el JSON desde el atributo de la solicitud
	        const avancesJson = '<%= request.getAttribute("avancesJson") %>';
	        const data = JSON.parse(avancesJson);

	        const fechas = data.map(avance => avance.fecha);
	        const tramos_amp = data.map(avance => avance.tramo_amp);
	        const tramos_mej = data.map(avance => avance.tramo_mej);
	        const tramos_sub = data.map(avance => avance.tramo_sub);
	        const tramos_bas = data.map(avance => avance.tramo_bas);
	        const tramos_asf = data.map(avance => avance.tramo_asf);
	        const porcentaje_ejecucion = data.map(avance => avance.porcentaje_ejecucion);
	        const cunetas = data.map(avance => avance.cunetas);
	        const muros = data.map(avance => avance.muros);

	        const ctx_amp = document.getElementById('myChartTramo_amp').getContext('2d');
	        const myChart_amp = new Chart(ctx_amp, {
	            type: 'line', // Tipo de gráfico: 'bar', 'line', etc.
	            data: {
	                labels: fechas,
	                datasets: [{
	                    label: 'Tramo_amp',
	                    data: tramos_amp,
	                    backgroundColor: 'rgba(203, 149, 88, 0.2)',
	                    borderColor: 'rgba(203, 149, 88, 1)',
	                    borderWidth: 1
	                }]
	            },
	            options: {scales: {y: {beginAtZero: true}}}
	        });
	        const ctx_mej = document.getElementById('myChartTramo_mej').getContext('2d');
	        const myChart_mej = new Chart(ctx_mej, {
	            type: 'line', // Tipo de gráfico: 'bar', 'line', etc.
	            data: {
	                labels: fechas,
	                datasets: [{
	                    label: 'Tramo_mej',
	                    data: tramos_mej,
	                    backgroundColor: 'rgba(255, 99, 71, 0.2)',
	                    borderColor: 'rgba(255, 99, 71, 1)',
	                    borderWidth: 1
	                }]
	            },
	            options: {scales: {y: {beginAtZero: true}}}
	        });
	        const ctx_sub = document.getElementById('myChartTramo_sub').getContext('2d');
	        const myChart_sub = new Chart(ctx_sub, {
	            type: 'line', // Tipo de gráfico: 'bar', 'line', etc.
	            data: {
	                labels: fechas,
	                datasets: [{
	                    label: 'Tramo_sub',
	                    data: tramos_sub,
	                    backgroundColor: 'rgba(60, 179, 113, 0.2)',
	                    borderColor: 'rgba(60, 179, 113, 1)',
	                    borderWidth: 1
	                }]
	            },
	            options: {scales: {y: {beginAtZero: true}}}
	        });
	        const ctx_bas = document.getElementById('myChartTramo_bas').getContext('2d');
	        const myChart_bas = new Chart(ctx_bas, {
	            type: 'line', // Tipo de gráfico: 'bar', 'line', etc.
	            data: {
	                labels: fechas,
	                datasets: [{
	                    label: 'Tramo_bas',
	                    data: tramos_bas,
	                    backgroundColor: 'rgba(106, 90, 205, 0.2)',
	                    borderColor: 'rgba(106, 90, 205, 1)',
	                    borderWidth: 1
	                }]
	            },
	            options: {scales: {y: {beginAtZero: true}}}
	        });
	        const ctx_asf = document.getElementById('myChartTramo_asf').getContext('2d');
	        const myChart_asf = new Chart(ctx_asf, {
	            type: 'line', // Tipo de gráfico: 'bar', 'line', etc.
	            data: {
	                labels: fechas,
	                datasets: [{
	                    label: 'Tramo_asf',
	                    data: tramos_asf,
	                    backgroundColor: 'rgba(255, 165, 0, 0.2)',
	                    borderColor: 'rgba(255, 165, 0, 1)',
	                    borderWidth: 1
	                }]
	            },
	            options: {scales: {y: {beginAtZero: true}}}
	        });
	        const ctx_eje = document.getElementById('myChartEjecucion').getContext('2d');
	        const myChart_eje = new Chart(ctx_eje, {
	            type: 'bar', // Tipo de gráfico: 'bar', 'line', etc.
	            data: {
	                labels: fechas,
	                datasets: [{
	                    label: 'Ejecucion',
	                    data: porcentaje_ejecucion,
	                    backgroundColor: 'rgba(255, 0, 0, 0.2)',
	                    borderColor: 'rgba(255, 0, 0, 1)',
	                    borderWidth: 1
	                }]
	            },
	            options: {scales: {y: {beginAtZero: true}}}
	        });
	        const ctx_cune = document.getElementById('myChartCunetas').getContext('2d');
	        const myChart_cune = new Chart(ctx_cune, {
	            type: 'bar', // Tipo de gráfico: 'bar', 'line', etc.
	            data: {
	                labels: fechas,
	                datasets: [{
	                    label: 'Cunetas',
	                    data: cunetas,
	                    backgroundColor: 'rgba(0, 0, 255, 0.2)',
	                    borderColor: 'rgba(0, 0, 255, 1)',
	                    borderWidth: 1
	                }]
	            },
	            options: {scales: {y: {beginAtZero: true}}}
	        });
	        const ctx_mur = document.getElementById('myChartMuros').getContext('2d');
	        const myChart_mur = new Chart(ctx_mur, {
	            type: 'bar', // Tipo de gráfico: 'bar', 'line', etc.
	            data: {
	                labels: fechas,
	                datasets: [{
	                    label: 'Muros',
	                    data: muros,
	                    backgroundColor: 'rgba(40, 114, 51, 0.2)',
	                    borderColor: 'rgba(40, 114, 51, 1)',
	                    borderWidth: 1
	                }]
	            },
	            options: {scales: {y: {beginAtZero: true}}}
	        });
		</script>
	</section>
	<section class="container-fluid p-5 bg-light" id="sec-solicitudes">
		<h1>
			<b>Solicitudes</b>
		</h1>
		<br>
		<div class="row">
			<div class="col-sm-6">
				<form action="insertarSolicitud"
					class="d-block bg-dark-subtle rounded p-3 h-100 formulario"
					id="formulario" onsubmit="return validarFormulario();">
					<!--grupo__fech-->
					<div class="formulario__grupo" id="grupo__fech">
						<label for="fech" class="form-label formulario__label">Fecha</label>
						<div class="formulario__grupo-input d-flex">
							<input type="date" name="fech" id="fech"
								class="formulario__input form-control"								
								oninput="validarFech()"> <i
								class="formulario__validacion-estado material-icons ms-1" id="iconFech">check_circle</i>
						</div>
						<p class="formulario__input-error" id="fechError"></p>
					</div>
					<!--grupo__users-->
					<div class="formulario__grupo" id="grupo__emails">
						<label for="users" class="form-label formulario__label">Usuario</label>
						<div class="formulario__grupo-input d-flex">
							<input type="text" name="users" id="users"
								class="formulario__input form-control"
								placeholder="Ingrese su usuario..."
								oninput="validarUsers()"> <i
								class="formulario__validacion-estado material-icons ms-1" id="iconUsers">check_circle</i>
						</div>
						<p class="formulario__input-error" id="usersError"></p>
					</div>
					<!--grupo__proyect-->
					<div class="formulario__grupo" id="grupo__proyect">
						<label for="proyect" class="form-label formulario__label">Proyecto</label>
						<div class="formulario__grupo-input d-flex">
							<select name="proyect" id="proyect"
								class="form-select formulario__input mb-2"
								oninput="validarProyect()">
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
							</select> <i class="formulario__validacion-estado material-icons ms-1" id="iconProyect">check_circle</i>
						</div>
						<p class="formulario__input-error" id="proyectError"></p>
					</div>
					<!--grupo__temas-->
					<div class="formulario__grupo" id="grupo__temas">
						<label for="temas" class="form-label formulario__label">Tema</label>
						<div class="formulario__grupo-input d-flex">
							<select name="temas" id="temas"
								class="form-select formulario__input"
								oninput="validarTemas()">
								<%
						            List<Temas> listaTema = (List<Temas>) request.getAttribute("listaTemas");
						            if(listaTema != null){
                              				for (Temas tema : listaTema) {
						        %>
								<option value="<%= tema.getDescripcion_tema() %>"><%= tema.getDescripcion_tema() %></option>
								<%
						            	}
						            }
						        %>
							</select> <i class="formulario__validacion-estado material-icons ms-1" id="iconTemas">check_circle</i>
						</div>
						<p class="formulario__input-error" id="temasError"></p>
					</div>
					<!--grupo__observacion-->
					<div class="formulario__grupo" id="grupo__observacion">
						<label for="observacion" class="form-label formulario__label">Observacion</label>
						<div class="formulario__grupo-input d-flex">
							<textarea rows="5" cols="1" name="observacion" id="observacion"
								class=" form-control formulario__input mb-2">
							</textarea>
							 <a href="#" class="form-text ms-1"><i class="material-icons ms-1">attach_file</i></a>
							 <i class="formulario__validacion-estado material-icons ms-1" id="iconObservacion">check_circle</i>
						</div>
						<p class="formulario__input-error" id="observacionError"></p>
					</div>					
					<div
						class="formulario__grupo formulario__grupo-btn-enviar mb-5 mt-2">
						<input type="submit" value="Enviar"
							class="btn btn-primary float-end formulario__btn">
					</div>
				</form>
			</div>
			<div class="col-sm-6">
				<img src="imagenes/vias-4.jpeg" alt="" class="d-block w-100 rounded">
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
</body>
</html>