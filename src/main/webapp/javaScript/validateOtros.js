function validarTitulo() {
    var id = document.getElementById("titulo").value;
	var inputId = document.getElementById("titulo");	
    var mensaje = document.getElementById("tituloError");
	var icon = document.getElementById("iconTitulo");
	var IdRegex = /^[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ ]{1,40}$/;
	
    if (id === "") {
        mensaje.textContent = "El titulo es obligatorio.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		inputId.style.borderColor = "red";
    } else if(!IdRegex.test(id)){
		mensaje.textContent = "El titulo admite letras y numeros, de 1 a 40 caracteres.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		inputId.style.borderColor = "red";
	}else{
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		inputId.style.borderColor = "green";
	}
}
function validarEstado() {
    var id = document.getElementById("estado").value;
	var inputId = document.getElementById("estado");	
    var mensaje = document.getElementById("estadoError");
	var icon = document.getElementById("iconEstado");
	var IdRegex = /^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]{1,40}$/;
	
    if (id === "") {
        mensaje.textContent = "El estado es obligatorio.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		inputId.style.borderColor = "red";
    } else if(!IdRegex.test(id)){
		mensaje.textContent = "El estado admite cadenas de 1 a 40 caracteres.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		inputId.style.borderColor = "red";
	}else{
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		inputId.style.borderColor = "green";
	}
}

function validarUbicacion() {
    var id = document.getElementById("ubicacion").value;
	var inputId = document.getElementById("ubicacion");	
    var mensaje = document.getElementById("ubicacionError");
	var icon = document.getElementById("iconUbicacion");
	var IdRegex = /^[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ ]{1,40}$/;
	
    if (id === "") {
        mensaje.textContent = "La ubicacion es obligatoria.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		inputId.style.borderColor = "red";
    } else if(!IdRegex.test(id)){
		mensaje.textContent = "La ubicacion admite letras y numeros, de 1 a 40 caracteres.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		inputId.style.borderColor = "red";
	}else{
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		inputId.style.borderColor = "green";
	}
}

function validarTitle() {
    var id = document.getElementById("title").value;
	var inputId = document.getElementById("title");	
    var mensaje = document.getElementById("titleError");
	var icon = document.getElementById("iconTitle");
	var IdRegex = /^[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ ]{1,40}$/;
	
    if (id === "") {
        mensaje.textContent = "El titulo es obligatorio.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		inputId.style.borderColor = "red";
    } else if(!IdRegex.test(id)){
		mensaje.textContent = "El titulo admite letras y numeros, de 1 a 40 caracteres.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		inputId.style.borderColor = "red";
	}else{
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		inputId.style.borderColor = "green";
	}
}
function validarState() {
    var id = document.getElementById("state").value;
	var inputId = document.getElementById("state");	
    var mensaje = document.getElementById("stateError");
	var icon = document.getElementById("iconState");
	var IdRegex = /^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]{1,40}$/;
	
    if (id === "") {
        mensaje.textContent = "El estado es obligatorio.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		inputId.style.borderColor = "red";
    } else if(!IdRegex.test(id)){
		mensaje.textContent = "El estado admite cadenas de 1 a 40 caracteres.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		inputId.style.borderColor = "red";
	}else{
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		inputId.style.borderColor = "green";
	}
}

function validarUbication() {
    var id = document.getElementById("ubication").value;
	var inputId = document.getElementById("ubication");	
    var mensaje = document.getElementById("ubicationError");
	var icon = document.getElementById("iconUbication");
	var IdRegex = /^[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ ]{1,40}$/;
	
    if (id === "") {
        mensaje.textContent = "La ubicacion es obligatoria.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		inputId.style.borderColor = "red";
    } else if(!IdRegex.test(id)){
		mensaje.textContent = "La ubicacion admite letras y numeros, de 1 a 40 caracteres.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		inputId.style.borderColor = "red";
	}else{
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		inputId.style.borderColor = "green";
	}
}

function validarIdProyecto() {
    var id = document.getElementById("idProyecto").value;
	var inputId = document.getElementById("idProyecto");	
    var mensaje = document.getElementById("idProyectoError");
	var icon = document.getElementById("iconIdProyecto");
	var IdRegex = /^[0-9]{1,3}$/;
	
    if (id === "") {
        mensaje.textContent = "El id es obligatorio.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		inputId.style.borderColor = "red";
    } else if(!IdRegex.test(id)){
		mensaje.textContent = "El id admite solo numeros de hasta 3 cifras.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		inputId.style.borderColor = "red";
	}else{
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		inputId.style.borderColor = "green";
	}
}
function validarIdProyectos() {
    var id = document.getElementById("idProyectos").value;
	var inputId = document.getElementById("idProyectos");	
    var mensaje = document.getElementById("idProyectosError");
	var icon = document.getElementById("iconIdProyectos");
	var IdRegex = /^[0-9]{1,3}$/;
	
    if (id === "") {
        mensaje.textContent = "El id es obligatorio.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		inputId.style.borderColor = "red";
    } else if(!IdRegex.test(id)){
		mensaje.textContent = "El id admite solo numeros de hasta 3 cifras.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		inputId.style.borderColor = "red";
	}else{
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		inputId.style.borderColor = "green";
	}
}
function validarDescRol() {
    var id = document.getElementById("descRol").value;
	var inputId = document.getElementById("descRol");	
    var mensaje = document.getElementById("descRolError");
	var icon = document.getElementById("iconDescRol");
	var IdRegex = /^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]{1,40}$/;
	
    if (id === "") {
        mensaje.textContent = "La descripcion del rol es obligatoria.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		inputId.style.borderColor = "red";
    } else if(!IdRegex.test(id)){
		mensaje.textContent = "La descripcion admite cadenas de 1 a 40 caracteres.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		inputId.style.borderColor = "red";
	}else{
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		inputId.style.borderColor = "green";
	}
}

function validarDescripcionRol() {
    var id = document.getElementById("descripcionRol").value;
	var inputId = document.getElementById("descripcionRol");	
    var mensaje = document.getElementById("descripcionRolError");
	var icon = document.getElementById("iconDescripcionRol");
	var IdRegex = /^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]{1,40}$/;
	
    if (id === "") {
        mensaje.textContent = "La descripcion del rol es obligatoria.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		inputId.style.borderColor = "red";
    } else if(!IdRegex.test(id)){
		mensaje.textContent = "La descripcion admite cadenas de 1 a 40 caracteres.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		inputId.style.borderColor = "red";
	}else{
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		inputId.style.borderColor = "green";
	}
}
function validarIdRol() {
    var id = document.getElementById("idRol").value;
	var inputId = document.getElementById("idRol");	
    var mensaje = document.getElementById("idRolError");
	var icon = document.getElementById("iconIdRol");
	var IdRegex = /^[0-9]{1,3}$/;
	
    if (id === "") {
        mensaje.textContent = "El id es obligatorio.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		inputId.style.borderColor = "red";
    } else if(!IdRegex.test(id)){
		mensaje.textContent = "El id admite solo numeros de hasta 3 cifras.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		inputId.style.borderColor = "red";
	}else{
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		inputId.style.borderColor = "green";
	}
}
function validarIdRoles() {
    var id = document.getElementById("idRoles").value;
	var inputId = document.getElementById("idRoles");	
    var mensaje = document.getElementById("idRolesError");
	var icon = document.getElementById("iconIdRoles");
	var IdRegex = /^[0-9]{1,3}$/;
	
    if (id === "") {
        mensaje.textContent = "El id es obligatorio.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		inputId.style.borderColor = "red";
    } else if(!IdRegex.test(id)){
		mensaje.textContent = "El id admite solo numeros de hasta 3 cifras.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		inputId.style.borderColor = "red";
	}else{
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		inputId.style.borderColor = "green";
	}
}
function validarIdSolicitud() {
    var id = document.getElementById("idSolicitud").value;
	var inputId = document.getElementById("idSolicitud");	
    var mensaje = document.getElementById("idSolicitudError");
	var icon = document.getElementById("iconIdSolicitud");
	var IdRegex = /^[0-9]{1,3}$/;
	
    if (id === "") {
        mensaje.textContent = "El id es obligatorio.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		inputId.style.borderColor = "red";
    } else if(!IdRegex.test(id)){
		mensaje.textContent = "El id admite solo numeros de hasta 3 cifras.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		inputId.style.borderColor = "red";
	}else{
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		inputId.style.borderColor = "green";
	}
}

function validarDescTema() {
    var id = document.getElementById("descTema").value;
	var inputId = document.getElementById("descTema");	
    var mensaje = document.getElementById("descTemaError");
	var icon = document.getElementById("iconDescTema");
	var IdRegex = /^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]{1,40}$/;
	
    if (id === "") {
        mensaje.textContent = "La descripcion del tema es obligatoria.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		inputId.style.borderColor = "red";
    } else if(!IdRegex.test(id)){
		mensaje.textContent = "La descripcion admite cadenas de 1 a 40 caracteres.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		inputId.style.borderColor = "red";
	}else{
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		inputId.style.borderColor = "green";
	}
}

function validarDescripcionTema() {
    var id = document.getElementById("descripcionTema").value;
	var inputId = document.getElementById("descripcionTema");	
    var mensaje = document.getElementById("descripcionTemaError");
	var icon = document.getElementById("iconDescripcionTema");
	var IdRegex = /^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]{1,40}$/;
	
    if (id === "") {
        mensaje.textContent = "La descripcion del tema es obligatoria.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		inputId.style.borderColor = "red";
    } else if(!IdRegex.test(id)){
		mensaje.textContent = "La descripcion admite cadenas de 1 a 40 caracteres.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		inputId.style.borderColor = "red";
	}else{
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		inputId.style.borderColor = "green";
	}
}
function validarIdTema() {
    var id = document.getElementById("idTema").value;
	var inputId = document.getElementById("idTema");	
    var mensaje = document.getElementById("idTemaError");
	var icon = document.getElementById("iconIdTema");
	var IdRegex = /^[0-9]{1,3}$/;
	
    if (id === "") {
        mensaje.textContent = "El id es obligatorio.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		inputId.style.borderColor = "red";
    } else if(!IdRegex.test(id)){
		mensaje.textContent = "El id admite solo numeros de hasta 3 cifras.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		inputId.style.borderColor = "red";
	}else{
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		inputId.style.borderColor = "green";
	}
}
function validarIdTemas() {
    var id = document.getElementById("idTemas").value;
	var inputId = document.getElementById("idTemas");	
    var mensaje = document.getElementById("idTemasError");
	var icon = document.getElementById("iconIdTemas");
	var IdRegex = /^[0-9]{1,3}$/;
	
    if (id === "") {
        mensaje.textContent = "El id es obligatorio.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		inputId.style.borderColor = "red";
    } else if(!IdRegex.test(id)){
		mensaje.textContent = "El id admite solo numeros de hasta 3 cifras.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		inputId.style.borderColor = "red";
	}else{
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		inputId.style.borderColor = "green";
	}
}
function validarDescTipo() {
    var id = document.getElementById("descTipo").value;
	var inputId = document.getElementById("descTipo");	
    var mensaje = document.getElementById("descTipoError");
	var icon = document.getElementById("iconDescTipo");
	var IdRegex = /^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]{1,40}$/;
	
    if (id === "") {
        mensaje.textContent = "La descripcion del tipo es obligatoria.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		inputId.style.borderColor = "red";
    } else if(!IdRegex.test(id)){
		mensaje.textContent = "La descripcion admite cadenas de 1 a 40 caracteres.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		inputId.style.borderColor = "red";
	}else{
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		inputId.style.borderColor = "green";
	}
}

function validarDescripcionTipo() {
    var id = document.getElementById("descripcionTipo").value;
	var inputId = document.getElementById("descripcionTipo");	
    var mensaje = document.getElementById("descripcionTipoError");
	var icon = document.getElementById("iconDescripcionTipo");
	var IdRegex = /^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]{1,40}$/;
	
    if (id === "") {
        mensaje.textContent = "La descripcion del tipo es obligatoria.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		inputId.style.borderColor = "red";
    } else if(!IdRegex.test(id)){
		mensaje.textContent = "La descripcion admite cadenas de 1 a 40 caracteres.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		inputId.style.borderColor = "red";
	}else{
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		inputId.style.borderColor = "green";
	}
}
function validarIdTipo() {
    var id = document.getElementById("idTipo").value;
	var inputId = document.getElementById("idTipo");	
    var mensaje = document.getElementById("idTipoError");
	var icon = document.getElementById("iconIdTipo");
	var IdRegex = /^[0-9]{1,3}$/;
	
    if (id === "") {
        mensaje.textContent = "El id es obligatorio.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		inputId.style.borderColor = "red";
    } else if(!IdRegex.test(id)){
		mensaje.textContent = "El id admite solo numeros de hasta 3 cifras.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		inputId.style.borderColor = "red";
	}else{
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		inputId.style.borderColor = "green";
	}
}
function validarIdTipos() {
    var id = document.getElementById("idTipos").value;
	var inputId = document.getElementById("idTipos");	
    var mensaje = document.getElementById("idTiposError");
	var icon = document.getElementById("iconIdTipos");
	var IdRegex = /^[0-9]{1,3}$/;
	
    if (id === "") {
        mensaje.textContent = "El id es obligatorio.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		inputId.style.borderColor = "red";
    } else if(!IdRegex.test(id)){
		mensaje.textContent = "El id admite solo numeros de hasta 3 cifras.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		inputId.style.borderColor = "red";
	}else{
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		inputId.style.borderColor = "green";
	}
}