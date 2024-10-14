<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.siesweb.modelo.TiposDocumentos" %>
<%@ page import="com.siesweb.modelo.Roles" %>
<%@ page import="com.siesweb.modelo.Proyectos" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	<title>Registrate</title>
</head>
<body>
	<nav class="navbar navbar-expand-sm fixed-top bg-light">
        <div class="container-fluid">
        	<ul>
        		<li class="d-inline"><a href="#" class="navbar-brand"><img src="imagenes/logo_siesweb.jpg" alt="" class="img-fluid"></a></li>
        		<li class="d-inline"><a href="#" class="navbar-brand"><img src="imagenes/logo-ing-vias.PNG" alt="" class="img-fluid"></a></li>
        	</ul>
        </div>
    </nav>
    
    <section class="container-fluid bg-body p-5 pt-1" style="margin-top: 100px;">
        <h1><b>Registrate</b></h1>
        <h6>Es grato y lo seguira siendo</h6>
        <div class="row mt-3">
            <div class="col-sm-6 bg-dark-subtle p-3 rounded">
                <form action="registrar" method="POST" class=" formulario" id="formulario" onsubmit="return validarFormulario();">
                    <div class="row mb-2">
                        <div class="col-sm-6">
                            <!--grupo__nombre-->
                            <div class="formulario__grupo" id="grupo__nombre">                                
                                <div class="formulario__grupo-input d-flex">
                                    <input type="text" name="nombre" id="nombre" class=" form-control formulario__input" placeholder="Nombres" oninput="validarNombre()">
                                    <i class="formulario__validacion-estado material-icons ms-1" id="iconNombre">check_circle</i>
                                </div>
                                <p class="formulario__input-error" id="nombreError"></p>
                            </div>                            
                        </div>
                        <div class="col-sm-6">
                            <!--grupo__apellidos-->
                            <div class="formulario__grupo" id="grupo__apellido">                                
                                <div class="formulario__grupo-input d-flex">
                                    <input type="text" name="apellido" id="apellido" class=" form-control formulario__input" placeholder="Apellidos" oninput="validarApellido()">
                                    <i class="formulario__validacion-estado material-icons ms-1" id="iconApellido">check_circle</i>
                                </div>
                                <p class="formulario__input-error" id="apellidoError"></p>
                            </div>                            
                        </div>
                    </div>                    
                    <div class="row mb-1">
                        <div class="col-sm-6">
                            <!--grupo__tipo-->
                            <div class="formulario__grupo" id="grupo__tipo">
                                <label for="tipo" class="form-label formulario__label">Tipo de documento</label>                                
                                <div class="formulario__grupo-input d-flex">
                                    <select name="tipo" id="tipo" class="form-select formulario__input" oninput="validarTipo()">                                        
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
                                    </select>
                                    <i class="formulario__validacion-estado material-icons ms-1" id="iconTipo">check_circle</i>
                                </div>
                                <p class="formulario__input-error" id="tipoError"></p>
                            </div>                            
                        </div>
                        <div class="col-sm-6">
                            <!--grupo__documento-->
                            <div class="formulario__grupo" id="grupo__documento">
                                <label for="documento" class="form-label formulario__label">Documento</label>                                
                                <div class="formulario__grupo-input d-flex">
                                    <input type="text" name="documento" id="documento" class=" form-control formulario__input" placeholder="Documento" oninput="validarDocumento()">
                                    <i class="formulario__validacion-estado material-icons ms-1" id="iconDocumento">check_circle</i>
                                </div>
                                <p class="formulario__input-error" id="documentoError"></p>
                            </div>                            
                        </div>
                    </div>
                    <div class="row mb-1">
                        <div class="col-sm-6">
                            <!--grupo__email-->
                            <div class="formulario__grupo" id="grupo__email">                                
                                <div class="formulario__grupo-input d-flex">
                                    <input type="text" name="email" id="email" class=" form-control formulario__input" placeholder="Email" oninput="validarEmail()">
                                    <i class="formulario__validacion-estado material-icons ms-1" id="iconEmail">check_circle</i>
                                </div>
                                <p class="formulario__input-error" id="emailError"></p>
                            </div>                            
                        </div>
                        <div class="col-sm-6">
                            <!--grupo__telefono-->
                            <div class="formulario__grupo" id="grupo__telefono">                                                                
                                <div class="formulario__grupo-input d-flex">
                                    <input type="text" name="telefono" id="telefono" class="formulario__input form-control" placeholder="Telefono" oninput="validarTelefono()">
                                    <i class="formulario__validacion-estado material-icons ms-1" id="iconTelefono">check_circle</i>
                                </div>
                                <p class="formulario__input-error" id="telefonoError"></p>
                            </div>                            
                        </div>
                    </div>
                    <div class="row mb-1">
                        <div class="col-sm-6">
                            <!--grupo-usuario-->
                            <div class="formulario__grupo" id="grupo__usuario">                                
                                <div class="formulario__grupo-input d-flex">
                                    <input type="text" name="usuario" id="usuario" class="formulario__input form-control" oninput="validarUsuario()" placeholder="Usuario">
                                    <i class="formulario__validacion-estado material-icons ms-1" id="iconUsuario">check_circle</i>
                                </div>
                                <p class="formulario__input-error" id="usuarioError"></p>
                            </div>                            
                        </div>
                        <div class="col-sm-6">
                            <!--grupo-password-->
                            <div class="formulario__grupo" id="grupo__password">                                
                                <div class="formulario__grupo-input d-flex">
                                    <input type="password" name="password" id="password" class="formulario__input form-control" oninput="validarPassword()" placeholder="Password">
                                    <i class="formulario__validacion-estado material-icons ms-1" id="iconPassword">check_circle</i>
                                </div>
                                <p class="formulario__input-error" id="passwordError"></p>
                            </div>                            
                        </div>
                    </div>
                    <div class="row mb-1">
                        <div class="col-sm-6">
                            <!--grupo__rol-->
                            <div class="formulario__grupo" id="grupo__rol">
                                <label for="rol" class="form-label formulario__label">Rol</label>                                
                                <div class="formulario__grupo-input d-flex">
                                    <select name="rol" id="rol" class="form-select formulario__input" oninput="validarRol()">
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
                                    </select>
                                    <i class="formulario__validacion-estado material-icons ms-1" id="iconRol">check_circle</i>
                                </div>
                                <p class="formulario__input-error" id="rolError"></p>
                            </div>                            
                        </div>
                        <div class="col-sm-6">
                            <!--grupo__proyecto-->
                            <div class="formulario__grupo" id="grupo__proyecto">
                                <label for="proyecto" class="form-label formulario__label">Proyecto</label>                                
                                <div class="formulario__grupo-input d-flex">
                                    <select name="proyecto" id="proyecto" class="form-select formulario__input" oninput="validarProyecto()">
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
                                    </select>
                                    <i class="formulario__validacion-estado material-icons ms-1" id="iconProyecto">check_circle</i>
                                </div>
                                <p class="formulario__input-error" id="proyectoError"></p>
                            </div>                          
                        </div>
                    </div>   
                    <div class="row mt-4">
                        <div class="col-sm-6">
                            <!--Mensaje-exito-error-->                            
                            <div class="formulario__mensaje h-50 border rounded bg-danger ps-2 pe-2 lh-1 d-none mt-2" id="formulario__mensaje">
                                <p><i class="material-icons me-2">assignment_late</i><b>Error: </b>Por favor rellena el formulario correctamente.</p>
                            </div>
                            <div class="formulario__grupo formulario__grupo-btn-enviar">                                                       
                                <input type="submit" value="Registrarse" class="btn btn-primary float-end formulario__btn">
                                <p class="formulario__mensaje-exito text-success d-none" id="formulario__mensaje-exito">Te has registrado exitosamente!</p>
                            </div>
                        </div> 
                        <div class="col-sm-6">
                    		<a href="index.jsp" class="float-start">Inciar Sesión</a> 
                		</div>
                    </div>                    
                </form>
                
            </div>
            <div class="col-sm-6">
                <img src="imagenes/vias-1.jpg" alt="" class="img-fluid p-2 w-100 rounded">
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
    <script type="text/javascript" src="javaScript/validateUsuarios.js"></script>
</body>
</html>