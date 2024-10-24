function validarTitulo() {
	var id = document.getElementById("titulo").value;
	var input = document.getElementById("titulo");
	var mensaje = document.getElementById("tituloError");
	var icon = document.getElementById("tituloIcon");
	var Regex = /^[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ ]{1,100}$/;

	if (id === "") {
		mensaje.textContent = "El titulo es obligatorio.";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
	} else if (!Regex.test(id)) {
		mensaje.textContent = "El campo titulo admite solo texto y numeros (1 a 100).";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
	} else {
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		input.style.borderColor = "green";
	}
}
function validarEstado() {
	var id = document.getElementById("estado").value;
	var input = document.getElementById("estado");
	var mensaje = document.getElementById("estadoError");
	var icon = document.getElementById("estadoIcon");
	var Regex = /^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]{1,25}$/;

	if (id === "") {
		mensaje.textContent = "El estado es obligatorio.";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
	} else if (!Regex.test(id)) {
		mensaje.textContent = "El campo estado admite solo texto (1 a 25).";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
	} else {
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		input.style.borderColor = "green";
	}
}

function validarUbicacion() {
	var id = document.getElementById("ubicacion").value;
	var input = document.getElementById("ubicacion");
	var mensaje = document.getElementById("ubicacionError");
	var icon = document.getElementById("ubicacionIcon");
	var Regex = /^[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ ]{1,100}$/;

	if (id === "") {
		mensaje.textContent = "La ubicacion es obligatoria.";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
	} else if (!Regex.test(id)) {
		mensaje.textContent = "El campo ubicacion admite solo texto y numeros (1 a 100).";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
	} else {
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		input.style.borderColor = "green";
	}
}

function validarTitle() {
	var id = document.getElementById("title").value;
	var input = document.getElementById("title");
	var mensaje = document.getElementById("titleError");
	var icon = document.getElementById("titleIcon");
	var Regex = /^[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ ]{1,100}$/;

	if (id === "") {
		mensaje.textContent = "El titulo es obligatorio.";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
	} else if (!Regex.test(id)) {
		mensaje.textContent = "El campo titulo admite solo texto y numeros (1 a 100).";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
	} else {
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		input.style.borderColor = "green";
	}
}
function validarState() {
	var id = document.getElementById("state").value;
	var input = document.getElementById("state");
	var mensaje = document.getElementById("stateError");
	var icon = document.getElementById("stateIcon");
	var Regex = /^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]{1,25}$/;

	if (id === "") {
		mensaje.textContent = "El estado es obligatorio.";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
	} else if (!Regex.test(id)) {
		mensaje.textContent = "El campo estado admite solo texto (1 a 25).";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
	} else {
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		input.style.borderColor = "green";
	}
}

function validarUbication() {
	var id = document.getElementById("ubication").value;
	var input = document.getElementById("ubication");
	var mensaje = document.getElementById("ubicationError");
	var icon = document.getElementById("ubicationIcon");
	var Regex = /^[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ ]{1,100}$/;

	if (id === "") {
		mensaje.textContent = "La ubicacion es obligatoria.";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
	} else if (!Regex.test(id)) {
		mensaje.textContent = "El campo ubicacion admite solo texto y numeros (1 a 100).";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
	} else {
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		input.style.borderColor = "green";
	}
}

function validarIdProyecto() {
	var id = document.getElementById("idProyecto").value;
	var input = document.getElementById("idProyecto");
	var mensaje = document.getElementById("idProyectoError");
	var icon = document.getElementById("idProyectoIcon");
	var Regex = /^[0-9]{1,3}$/;

	if (id === "") {
		mensaje.textContent = "El id es obligatorio.";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
	} else if (!Regex.test(id)) {
		mensaje.textContent = "El campo id admite solo numeros enteros positivos (1 a 3).";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
	} else {
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		input.style.borderColor = "green";
	}
}
function validarIdProyectos() {
	var id = document.getElementById("idProyectos").value;
	var input = document.getElementById("idProyectos");
	var mensaje = document.getElementById("idProyectosError");
	var icon = document.getElementById("idProyectosIcon");
	var Regex = /^[0-9]{1,3}$/;

	if (id === "") {
		mensaje.textContent = "El id es obligatorio.";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
	} else if (!Regex.test(id)) {
		mensaje.textContent = "El campo id admite solo numeros enteros positivos (1 a 3).";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
	} else {
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		input.style.borderColor = "green";
	}
}
function validarDescRol() {
	var id = document.getElementById("descRol").value;
	var input = document.getElementById("descRol");
	var mensaje = document.getElementById("descRolError");
	var icon = document.getElementById("descRolIcon");
	var Regex = /^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]{1,25}$/;

	if (id === "") {
		mensaje.textContent = "La descripcion es obligatoria.";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
	} else if (!Regex.test(id)) {
		mensaje.textContent = "El campo descripcion admite solo texto (1 a 25).";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
	} else {
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		input.style.borderColor = "green";
	}
}

function validarDescripcionRol() {
	var id = document.getElementById("descripcionRol").value;
	var input = document.getElementById("descripcionRol");
	var mensaje = document.getElementById("descripcionRolError");
	var icon = document.getElementById("descripcionRolIcon");
	var Regex = /^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]{1,25}$/;

	if (id === "") {
		mensaje.textContent = "La descripcion es obligatoria.";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
	} else if (!Regex.test(id)) {
		mensaje.textContent = "El campo descripcion admite solo texto (1 a 25).";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
	} else {
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		input.style.borderColor = "green";
	}
}
function validarIdRol() {
	var id = document.getElementById("idRol").value;
	var input = document.getElementById("idRol");
	var mensaje = document.getElementById("idRolError");
	var icon = document.getElementById("idRolIcon");
	var Regex = /^[0-9]{1,3}$/;

	if (id === "") {
		mensaje.textContent = "El id es obligatorio.";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
	} else if (!Regex.test(id)) {
		mensaje.textContent = "El campo id admite solo numeros enteros positivos (1 a 3).";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
	} else {
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		input.style.borderColor = "green";
	}
}
function validarIdRoles() {
	var id = document.getElementById("idRoles").value;
	var input = document.getElementById("idRoles");
	var mensaje = document.getElementById("idRolesError");
	var icon = document.getElementById("iconIdRoles");
	var Regex = /^[0-9]{1,3}$/;

	if (id === "") {
		mensaje.textContent = "El id es obligatorio.";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
	} else if (!Regex.test(id)) {
		mensaje.textContent = "El campo id admite solo numeros enteros positivos (1 a 3).";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
	} else {
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		input.style.borderColor = "green";
	}
}
function validarIdSolicitud() {
	var id = document.getElementById("idSolicitud").value;
	var input = document.getElementById("idSolicitud");
	var mensaje = document.getElementById("idSolicitudError");
	var icon = document.getElementById("idSolicitudIcon");
	var Regex = /^[0-9]{1,3}$/;

	if (id === "") {
		mensaje.textContent = "El id es obligatorio.";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
	} else if (!Regex.test(id)) {
		mensaje.textContent = "El campo id admite solo numeros enteros positivos (1 a 3).";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
	} else {
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		input.style.borderColor = "green";
	}
}

function validarDescTema() {
	var id = document.getElementById("descTema").value;
	var input = document.getElementById("descTema");
	var mensaje = document.getElementById("descTemaError");
	var icon = document.getElementById("descTemaIcon");
	var Regex = /^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]{1,25}$/;

	if (id === "") {
		mensaje.textContent = "La descripcion es obligatoria.";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
	} else if (!Regex.test(id)) {
		mensaje.textContent = "El campo descripcion admite solo texto (1 a 25).";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
	} else {
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		input.style.borderColor = "green";
	}
}

function validarDescripcionTema() {
	var id = document.getElementById("descripcionTema").value;
	var input = document.getElementById("descripcionTema");
	var mensaje = document.getElementById("descripcionTemaError");
	var icon = document.getElementById("descripcionTemaIcon");
	var Regex = /^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]{1,25}$/;

	if (id === "") {
		mensaje.textContent = "La descripcion es obligatoria.";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
	} else if (!Regex.test(id)) {
		mensaje.textContent = "El campo descripcion admite solo texto (1 a 25).";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
	} else {
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		input.style.borderColor = "green";
	}
}
function validarIdTema() {
	var id = document.getElementById("idTema").value;
	var input = document.getElementById("idTema");
	var mensaje = document.getElementById("idTemaError");
	var icon = document.getElementById("idTemaIcon");
	var Regex = /^[0-9]{1,3}$/;

	if (id === "") {
		mensaje.textContent = "El id es obligatorio.";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
	} else if (!Regex.test(id)) {
		mensaje.textContent = "El campo id admite solo numeros enteros positivos (1 a 3).";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
	} else {
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		input.style.borderColor = "green";
	}
}
function validarIdTemas() {
	var id = document.getElementById("idTemas").value;
	var input = document.getElementById("idTemas");
	var mensaje = document.getElementById("idTemasError");
	var icon = document.getElementById("idTemasIcon");
	var Regex = /^[0-9]{1,3}$/;

	if (id === "") {
		mensaje.textContent = "El id es obligatorio.";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
	} else if (!Regex.test(id)) {
		mensaje.textContent = "El campo id admite solo numeros enteros positivos (1 a 3).";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
	} else {
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		input.style.borderColor = "green";
	}
}
function validarDescTipo() {
	var id = document.getElementById("descTipo").value;
	var input = document.getElementById("descTipo");
	var mensaje = document.getElementById("descTipoError");
	var icon = document.getElementById("descTipoIcon");
	var Regex = /^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]{1,25}$/;

	if (id === "") {
		mensaje.textContent = "La descripcion es obligatoria.";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
	} else if (!Regex.test(id)) {
		mensaje.textContent = "El campo descripcion admite solo texto (1 a 25).";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
	} else {
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		input.style.borderColor = "green";
	}
}

function validarDescripcionTipo() {
	var id = document.getElementById("descripcionTipo").value;
	var input = document.getElementById("descripcionTipo");
	var mensaje = document.getElementById("descripcionTipoError");
	var icon = document.getElementById("descripcionTipoIcon");
	var Regex = /^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]{1,25}$/;

	if (id === "") {
		mensaje.textContent = "La descripcion es obligatoria.";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
	} else if (!Regex.test(id)) {
		mensaje.textContent = "El campo descripcion admite solo texto (1 a 25).";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
	} else {
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		input.style.borderColor = "green";
	}
}
function validarIdTipo() {
	var id = document.getElementById("idTipo").value;
	var input = document.getElementById("idTipo");
	var mensaje = document.getElementById("idTipoError");
	var icon = document.getElementById("idTipoIcon");
	var Regex = /^[0-9]{1,3}$/;

	if (id === "") {
		mensaje.textContent = "El id es obligatorio.";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
	} else if (!Regex.test(id)) {
		mensaje.textContent = "El campo id admite solo numeros enteros positivos (1 a 3).";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
	} else {
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		input.style.borderColor = "green";
	}
}
function validarIdTipos() {
	var id = document.getElementById("idTipos").value;
	var input = document.getElementById("idTipos");
	var mensaje = document.getElementById("idTiposError");
	var icon = document.getElementById("idTiposIcon");
	var Regex = /^[0-9]{1,3}$/;

	if (id === "") {
		mensaje.textContent = "El id es obligatorio.";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
	} else if (!Regex.test(id)) {
		mensaje.textContent = "El campo id admite solo numeros enteros positivos (1 a 3).";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
	} else {
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		input.style.borderColor = "green";
	}
}

function validarFech() {
	var fecha = document.getElementById("fech").value;
	var input = document.getElementById("fech");
	var mensaje = document.getElementById("fechError");
	var icon = document.getElementById("fechIcon");
	var Regex = /^(\d{4})-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/;

	if (fecha === "") {
		mensaje.textContent = "La fecha es obligatoria.";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
	} else if (!Regex.test(fecha)) {
		mensaje.textContent = "El campo fecha admite solo el formato dd/MM/yyyy";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
	} else {
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		input.style.borderColor = "green";
	}
}

function validarUsers() {
	var usuario = document.getElementById("users").value;
	var inputUser = document.getElementById("users");
	var mensaje = document.getElementById("usersError");
	var icon = document.getElementById("usersIcon");
	var usuarioRegex = /^[a-zA-Z0-9._-]{1,25}$/;


	if (usuario === "") {
		mensaje.textContent = "El usuario es obligatorio.";
		mensaje.style.color = "red";
		icon.style.color = "red";
		inputUser.style.borderColor = "red";
	} else if (!usuarioRegex.test(usuario)) {
		mensaje.textContent = "El campo usuario admite solo texto, numeros y guiones (1 a 25).";
		mensaje.style.color = "red";
		icon.style.color = "red";
		inputUser.style.borderColor = "red";
	} else {
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		inputUser.style.borderColor = "green";
	}
}

function validarProyect() {
	var proyecto = document.getElementById("proyect").value;
	var inputProyecto = document.getElementById("proyect");
	var mensaje = document.getElementById("proyectError");
	var icon = document.getElementById("proyectIcon");

	if (proyecto === "") {
		mensaje.textContent = "El proyecto es obligatorio.";
		mensaje.style.color = "red";
		icon.style.color = "red";
		inputProyecto.style.borderColor = "red";
	} else {
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		inputProyecto.style.borderColor = "green";
	}
}

function validarTemas() {
	var tema = document.getElementById("temas").value;
	var inputTema = document.getElementById("temas");
	var mensaje = document.getElementById("temasError");
	var icon = document.getElementById("temasIcon");

	if (tema === "") {
		mensaje.textContent = "El tema es obligatorio.";
		mensaje.style.color = "red";
		icon.style.color = "red";
		inputTema.style.borderColor = "red";
	} else {
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		inputTema.style.borderColor = "green";
	}
}

function validarObservacion() {
	var id = document.getElementById("observacion").value;
	var input = document.getElementById("observacion");
	var mensaje = document.getElementById("observacionError");
	var icon = document.getElementById("observacionIcon");
	var Regex = /^[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ ]{1,100}$/;

	if (id === "") {
		mensaje.textContent = "La observacion es obligatoria.";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
	} else if (!Regex.test(id)) {
		mensaje.textContent = "El campo observacion admite solo texto y numeros (1 a 100).";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
	} else {
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		input.style.borderColor = "green";
	}
}