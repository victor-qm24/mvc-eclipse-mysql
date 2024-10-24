function validarIdActualizar() {
	var id = document.getElementById("idActualizar").value;
	var input = document.getElementById("idActualizar");
	var mensaje = document.getElementById("idActualizarError");
	var icon = document.getElementById("idActualizarIcon");
	var Regex = /^[0-9]{1,3}$/;

	if (id === "") {
		mensaje.textContent = "El id es obligatorio.";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
	} else if (!Regex.test(id)) {
		mensaje.textContent = "El campo id admite solo numeros (3 cifras).";
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
function validarIdBuscar() {
	var id = document.getElementById("idBuscar").value;
	var input = document.getElementById("idBuscar");
	var mensaje = document.getElementById("idBuscarError");
	var icon = document.getElementById("idBuscarIcon");
	var Regex = /^[0-9]{1,3}$/;

	if (id === "") {
		mensaje.textContent = "El id es obligatorio.";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
	} else if (!Regex.test(id)) {
		mensaje.textContent = "El campo id admite solo numeros (3 cifras).";
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

function validarIdEliminar() {
	var id = document.getElementById("idEliminar").value;
	var input = document.getElementById("idEliminar");
	var mensaje = document.getElementById("idEliminarError");
	var icon = document.getElementById("idEliminarIcon");
	var Regex = /^[0-9]{1,3}$/;

	if (id === "") {
		mensaje.textContent = "El id es obligatorio.";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
	} else if (!Regex.test(id)) {
		mensaje.textContent = "El campo id admite solo numeros (3 cifras).";
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
function validarIdInactivar() {
	var id = document.getElementById("idInactivar").value;
	var input = document.getElementById("idInactivar");
	var mensaje = document.getElementById("idInactivarError");
	var icon = document.getElementById("idInactivarIcon");
	var Regex = /^[0-9]{1,3}$/;

	if (id === "") {
		mensaje.textContent = "El id es obligatorio.";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
	} else if (!Regex.test(id)) {
		mensaje.textContent = "El campo id admite solo numeros (3 cifras).";
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
function validarNombre() {
	var nombre = document.getElementById("nombre").value;
	var inputNombre = document.getElementById("nombre");
	var mensaje = document.getElementById("nombreError");
	var icon = document.getElementById("nombreIcon");
	var nombreRegex = /^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]{1,25}$/;


	if (nombre === "") {
		mensaje.textContent = "El nombre es obligatorio.";
		mensaje.style.color = "red";
		icon.style.color = "red";
		inputNombre.style.borderColor = "red";
	} else if (!nombreRegex.test(nombre)) {
		mensaje.textContent = "El campo nombre admite solo texto (1 a 25).";
		mensaje.style.color = "red";
		icon.style.color = "red";
		inputNombre.style.borderColor = "red";
	} else {
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		inputNombre.style.borderColor = "green";
	}
}

function validarApellido() {
	var apellido = document.getElementById("apellido").value;
	var inputApellido = document.getElementById("apellido");
	var mensaje = document.getElementById("apellidoError");
	var icon = document.getElementById("apellidoIcon");
	var apellidoRegex = /^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]{1,25}$/;

	if (apellido === "") {
		mensaje.textContent = "El apellido es obligatorio.";
		mensaje.style.color = "red";
		icon.style.color = "red";
		inputApellido.style.borderColor = "red";
	} else if (!apellidoRegex.test(apellido)) {
		mensaje.textContent = "El campo apellido admite solo texto (1 a 25).";
		mensaje.style.color = "red";
		icon.style.color = "red";
		inputApellido.style.borderColor = "red";
	} else {
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		inputApellido.style.borderColor = "green";
	}
}

function validarTipo() {
	var tipo = document.getElementById("tipo").value;
	var inputTipo = document.getElementById("tipo");
	var mensaje = document.getElementById("tipoError");
	var icon = document.getElementById("tipoIcon");

	if (tipo === "") {
		mensaje.textContent = "El tipo de documento es obligatorio.";
		mensaje.style.color = "red";
		icon.style.color = "red";
		inputTipo.style.borderColor = "red";
	} else {
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		inputTipo.style.borderColor = "green";
	}
}

function validarDocumento() {
	var documento = document.getElementById("documento").value;
	var inputDocumento = document.getElementById("documento");
	var mensaje = document.getElementById("documentoError");
	var icon = document.getElementById("documentoIcon");
	var documentoRegex = /^[0-9]{1,15}$/;

	if (documento === "") {
		mensaje.textContent = "El documento es obligatorio.";
		mensaje.style.color = "red";
		icon.style.color = "red";
		inputDocumento.style.borderColor = "red";
	} else if (!documentoRegex.test(documento)) {
		mensaje.textContent = "El campo documento admite solo numeros (1 a 15).";
		mensaje.style.color = "red";
		icon.style.color = "red";
		inputDocumento.style.borderColor = "red";
	} else {
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		inputDocumento.style.borderColor = "green";
	}
}

function validarEmail() {
	var email = document.getElementById("email").value;
	var inputEmail = document.getElementById("email");
	var mensaje = document.getElementById("emailError");
	var icon = document.getElementById("emailIcon");
	var emailRegex = /^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/;


	if (email === "") {
		mensaje.textContent = "El email es obligatorio.";
		mensaje.style.color = "red";
		icon.style.color = "red";
		inputEmail.style.borderColor = "red";
	} else if (!emailRegex.test(email)) {
		mensaje.textContent = "El campo email admite solo formato example@example.com (1 a 50).";
		mensaje.style.color = "red";
		icon.style.color = "red";
		inputEmail.style.borderColor = "red";
	} else {
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		inputEmail.style.borderColor = "green";
	}
}

function validarTelefono() {
	var telefono = document.getElementById("telefono").value;
	var inputTelefono = document.getElementById("telefono");
	var mensaje = document.getElementById("telefonoError");
	var icon = document.getElementById("telefonoIcon");
	var TelefonoRegex = /^[0-9]{1,15}$/;

	if (telefono === "") {
		mensaje.textContent = "El telefono es obligatorio.";
		mensaje.style.color = "red";
		icon.style.color = "red";
		inputTelefono.style.borderColor = "red";
	} else if (!TelefonoRegex.test(telefono)) {
		mensaje.textContent = "El campo telefono admite solo numeros (1 y 15).";
		mensaje.style.color = "red";
		icon.style.color = "red";
		inputTelefono.style.borderColor = "red";
	} else {
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		inputTelefono.style.borderColor = "green";
	}
}

function validarUsuario() {
	var usuario = document.getElementById("usuario").value;
	var inputUser = document.getElementById("usuario");
	var mensaje = document.getElementById("usuarioError");
	var icon = document.getElementById("usuarioIcon");
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
function validarPassword() {
	var password = document.getElementById("password").value;
	var inputPass = document.getElementById("password");
	var mensaje = document.getElementById("passwordError");
	var icon = document.getElementById("passwordIcon");
	var passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;


	if (password === "") {
		mensaje.textContent = "El password es obligatorio.";
		mensaje.style.color = "red";
		icon.style.color = "red";
		inputPass.style.borderColor = "red";
	} else if (!passwordRegex.test(password)) {
		mensaje.textContent = "El campo password minimo debe inluir un numero, letra mayuscula y minuscula, y un caracter especial (@$!%*?&) (8 o más).";
		mensaje.style.color = "red";
		icon.style.color = "red";
		inputPass.style.borderColor = "red";
	} else {
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		inputPass.style.borderColor = "green";
	}
}

function validarEstado() {
	var estado = document.getElementById("estado").value;
	var inputEstado = document.getElementById("estaddo");
	var mensaje = document.getElementById("estadoError");
	var icon = document.getElementById("estadoIcon");

	if (estado === "" || estado === "-") {
		mensaje.textContent = "El estado es obligatorio.";
		mensaje.style.color = "red";
		icon.style.color = "red";
		inputEstado.style.borderColor = "red";
	} else {
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		inputEstado.style.borderColor = "green";
	}
}

function validarRol() {
	var rol = document.getElementById("rol").value;
	var inputRol = document.getElementById("rol");
	var mensaje = document.getElementById("rolError");
	var icon = document.getElementById("rolIcon");

	if (rol === "") {
		mensaje.textContent = "El rol es obligatorio.";
		mensaje.style.color = "red";
		icon.style.color = "red";
		inputRol.style.borderColor = "red";
	} else {
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		inputRol.style.borderColor = "green";
	}
}

function validarProyecto() {
	var proyecto = document.getElementById("proyecto").value;
	var inputProyecto = document.getElementById("proyecto");
	var mensaje = document.getElementById("proyectoError");
	var icon = document.getElementById("proyectoIcon");

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

/*const passwordInput = document.getElementById('password');
const toggleEnlace = document.getElementById('cambio');
let isPasswordVisible = false;

toggleEnlace.addEventListener('click', function() {
	isPasswordVisible = !isPasswordVisible;
	passwordInput.type = isPasswordVisible ? 'text' : 'password';
	//toggleEnlace.textContent = isPasswordVisible ? 'Ocultar' : 'Mostrar';
});*/