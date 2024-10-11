function validarIdActualizar() {
    var idActualizar = document.getElementById("idActualizar").value;
	var inputIdActualizar = document.getElementById("idActualizar");	
    var mensaje = document.getElementById("idError");
	var icon = document.getElementById("iconId");
	var IdRegex = /^[0-9]{1,3}$/;
	
    if (idActualizar === "") {
        mensaje.textContent = "El id es obligatorio.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		inputIdActualizar.style.borderColor = "red";
    } else if(!IdRegex.test(idActualizar)){
		mensaje.textContent = "El id admite solo numeros de hasta 3 cifras.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		inputIdActualizar.style.borderColor = "red";
	}else{
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		inputIdActualizar.style.borderColor = "green";
	}
}
function validarIdBuscar() {
	var idBuscar = document.getElementById("idBuscar").value;
	var inputIdBuscar = document.getElementById("idBuscar");	
    var mensaje = document.getElementById("idError");
	var icon = document.getElementById("iconId");
	var IdRegex = /^[0-9]{1,3}$/;
	
    if (idBuscar === "") {
        mensaje.textContent = "El id es obligatorio.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		inputIdBuscar.style.borderColor = "red";
    } else if(!IdRegex.test(idBuscar)){
		mensaje.textContent = "El id admite solo numeros de hasta 3 cifras.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		inputIdBuscar.style.borderColor = "red";
	}else{
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		inputIdBuscar.style.borderColor = "green";
	}
}

function validarIdEliminar() {
	var idEliminar = document.getElementById("idEliminar").value;
	var inputIdEliminar = document.getElementById("idEliminar");	
    var mensaje = document.getElementById("idError");
	var icon = document.getElementById("iconId");
	var IdRegex = /^[0-9]{1,3}$/;
	
    if (idEliminar === "") {
        mensaje.textContent = "El id es obligatorio.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		inputIdEliminar.style.borderColor = "red";
    } else if(!IdRegex.test(idEliminar)){
		mensaje.textContent = "El id admite solo numeros de hasta 3 cifras.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		inputIdEliminar.style.borderColor = "red";
	}else{
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		inputIdEliminar.style.borderColor = "green";
	}
}

function validarNombre() {
    var nombre = document.getElementById("nombre").value;
	var inputNombre = document.getElementById("nombre");
    var mensaje = document.getElementById("nombreError");
	var icon = document.getElementById("iconNombre");
	var nombreRegex = /^[a-zA-ZÀ-ÿ\s]{1,40}$/;	

    if (nombre === "") {
        mensaje.textContent = "El nombre es obligatorio.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		inputNombre.style.borderColor = "red";
    } else if(!nombreRegex.test(nombre)){
        mensaje.textContent = "El nombre debe contener solo letras, además, debe estar entre 1 a 40 caracteres.";
		mensaje.style.color = "red";
		icon.style.color = "red";
		inputNombre.style.borderColor = "red";
    }else{
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
	var icon = document.getElementById("iconApellido");
	var apellidoRegex = /^[a-zA-ZÀ-ÿ\s]{1,40}$/;	

    if (apellido === "") {
        mensaje.textContent = "El apellido es obligatorio.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		inputApellido.style.borderColor = "red";
    } else if(!apellidoRegex.test(apellido)){
        mensaje.textContent = "El apellido debe contener solo letras, además, debe estar entre 1 a 40 caracteres.";
		mensaje.style.color = "red";
		icon.style.color = "red";
		inputApellido.style.borderColor = "red";
    }else{
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
	var icon = document.getElementById("iconTipo");
	
    if (tipo === "" || tipo === "-") {
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
	var icon = document.getElementById("iconDocumento");
	var documentoRegex = /^[0-9]{8,10}$/;	

    if (documento === "") {
        mensaje.textContent = "El documento es obligatorio.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		inputDocumento.style.borderColor = "red";
    } else if(!documentoRegex.test(documento)){
        mensaje.textContent = "El documento debe contener solo numeros, además, debe estar entre 8 a 10 caracteres.";
		mensaje.style.color = "red";
		icon.style.color = "red";
		inputDocumento.style.borderColor = "red";
    }else{
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
	var icon = document.getElementById("iconEmail");
	var emailRegex = /^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/;	

    if (email === "") {
        mensaje.textContent = "El email es obligatorio.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		inputEmail.style.borderColor = "red";
    } else if(!emailRegex.test(email)){
        mensaje.textContent = "Correo no valido";
		mensaje.style.color = "red";
		icon.style.color = "red";
		inputEmail.style.borderColor = "red";
    }else{
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
	var icon = document.getElementById("iconTelefono");
	var TelefonoRegex = /^\d{7,14}$/;	

    if (telefono === "") {
        mensaje.textContent = "El telefono es obligatorio.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		inputTelefono.style.borderColor = "red";
    } else if(!TelefonoRegex.test(telefono)){
        mensaje.textContent = "El telefono admite solo numeros, además, debe estar entre 7 y 14 digitos.";
		mensaje.style.color = "red";
		icon.style.color = "red";
		inputTelefono.style.borderColor = "red";
    }else{
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
	var icon = document.getElementById("iconUsuario");
	var usuarioRegex = /^[a-zA-Z0-9\_\-]{4,16}$/;	

    if (usuario === "") {
        mensaje.textContent = "El usuario es obligatorio.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		inputUser.style.borderColor = "red";
    } else if(!usuarioRegex.test(usuario)){
        mensaje.textContent = "El usuario debe contener solo letras, numeros y guiones, además, debe estar entre 4 a 16 caracteres.";
		mensaje.style.color = "red";
		icon.style.color = "red";
		inputUser.style.borderColor = "red";
    }else{
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
	var icon = document.getElementById("iconPassword");	
	var passwordRegex = /^.{8,12}$/;

    if (password === "") {
        mensaje.textContent = "El password es obligatorio.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		inputPass.style.borderColor = "red";
    } else if(!passwordRegex.test(password)){
        mensaje.textContent = "El password debe estar entre 8 a 12 caracteres.";
		mensaje.style.color = "red";
		icon.style.color = "red";
		inputPass.style.borderColor = "red";
    }else{
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		inputPass.style.borderColor = "green";
	}
}

function validarRol() {
    var rol = document.getElementById("rol").value;
	var inputRol = document.getElementById("rol");
    var mensaje = document.getElementById("rolError");
	var icon = document.getElementById("iconRol");
	
    if (rol === "" || rol === "-") {
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
	var icon = document.getElementById("iconProyecto");
	
    if (proyecto === "" || proyecto === "-") {
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

function validarFormulario() {
    validarUsuario();
    validarPassword();
	validarIdActualizar();
	validarIdBuscar();
	validarIdEliminar();
	validarNombre();
	validarApellido();
	validarTipo();
	validarDocumento();
	validarEmail();
	validarTelefono();
    validarRol();
	validarProyecto();
	
    return document.getElementById("idError").textContent === "" + 
	document.getElementById("nombreError").textContent === ""+
	document.getElementById("apellidoError").textContent === "" +
	document.getElementById("tipoError").textContent === "" + 
	document.getElementById("documentoError").textContent === ""+
	document.getElementById("emailError").textContent === "" + 
	document.getElementById("telefonoError").textContent === ""+
	document.getElementById("usuarioError").textContent === "" + 
	document.getElementById("passwordError").textContent === ""+
	document.getElementById("rolError").textContent === "" + 
	document.getElementById("proyectoError").textContent === "";
}