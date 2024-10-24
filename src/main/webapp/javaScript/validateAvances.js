function validarIdUpdate() {
	var id = document.getElementById("idUpdate").value;
	var input = document.getElementById("idUpdate");
	var mensaje = document.getElementById("idUpdateError");
	var icon = document.getElementById("idUpdateIcon");
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
function validarIdLoad() {
	var id = document.getElementById("idLoad").value;
	var input = document.getElementById("idLoad");
	var mensaje = document.getElementById("idLoadError");
	var icon = document.getElementById("idLoadIcon");
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

function validarIdDelete() {
	var id = document.getElementById("idDelete").value;
	var input = document.getElementById("idDelete");
	var mensaje = document.getElementById("idDeleteError");
	var icon = document.getElementById("idDeleteIcon");
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

function validarFecha() {
	var fecha = document.getElementById("fecha").value;
	var input = document.getElementById("fecha");
	var mensaje = document.getElementById("fechaError");
	var icon = document.getElementById("fechaIcon");
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

function validarTramo_amp() {
	var tramo = document.getElementById("tramo_amp").value;
	var input = document.getElementById("tramo_amp");
	var mensaje = document.getElementById("tramo_ampError");
	var icon = document.getElementById("tramo_ampIcon");
	var Regex = /^(?:[1-9]\d*|[1-9]\d*\.\d{2})$/;


	if (tramo === "") {
		mensaje.textContent = "El tramo es obligatorio.";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
	} else if (!Regex.test(tramo)) {
		mensaje.textContent = "El campo tramo admite solo numeros racionales positivos (0 a 99999,00).";
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
function validarTramo_mej() {
	var tramo = document.getElementById("tramo_mej").value;
	var input = document.getElementById("tramo_mej");
	var mensaje = document.getElementById("tramo_mejError");
	var icon = document.getElementById("tramo_mejIcon");
	var Regex = /^(?:[1-9]\d*|[1-9]\d*\.\d{2})$/;

	if (tramo === "") {
		mensaje.textContent = "El tramo es obligatorio.";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
	} else if (!Regex.test(tramo)) {
		mensaje.textContent = "El campo tramo admite solo numeros racionales positivos (0 a 99999,00).";
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
function validarTramo_sub() {
	var tramo = document.getElementById("tramo_sub").value;
	var input = document.getElementById("tramo_sub");
	var mensaje = document.getElementById("tramo_subError");
	var icon = document.getElementById("tramo_subIcon");
	var Regex = /^(?:[1-9]\d*|[1-9]\d*\.\d{2})$/;

	if (tramo === "") {
		mensaje.textContent = "El tramo es obligatorio.";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
	} else if (!Regex.test(tramo)) {
		mensaje.textContent = "El campo tramo admite solo numeros racionales positivos (0 a 99999,00).";
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
function validarTramo_bas() {
	var tramo = document.getElementById("tramo_bas").value;
	var input = document.getElementById("tramo_bas");
	var mensaje = document.getElementById("tramo_basError");
	var icon = document.getElementById("tramo_basIcon");
	var Regex = /^(?:[1-9]\d*|[1-9]\d*\.\d{2})$/;

	if (tramo === "") {
		mensaje.textContent = "El tramo es obligatorio.";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
	} else if (!Regex.test(tramo)) {
		mensaje.textContent = "El campo tramo admite solo numeros racionales positivos (0 a 99999,00).";
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
function validarTramo_asf() {
	var tramo = document.getElementById("tramo_asf").value;
	var input = document.getElementById("tramo_asf");
	var mensaje = document.getElementById("tramo_asfError");
	var icon = document.getElementById("tramo_asfIcon");
	var Regex = /^(?:[1-9]\d*|[1-9]\d*\.\d{2})$/;

	if (tramo === "") {
		mensaje.textContent = "El tramo es obligatorio.";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
	} else if (!Regex.test(tramo)) {
		mensaje.textContent = "El campo tramo admite solo numeros racionales positivos (0 a 99999,00).";
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
function validarCunetas() {
	var cunetas = document.getElementById("cunetas").value;
	var input = document.getElementById("cunetas");
	var mensaje = document.getElementById("cunetasError");
	var icon = document.getElementById("cunetasIcon");
	var Regex = /^[1-9]\d*$/;

	if (cunetas === "") {
		mensaje.textContent = "La cantidad de cunetas es obligatoria.";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
	} else if (!Regex.test(cunetas)) {
		mensaje.textContent = "El campo cunetas admite solo numeros enteros positivos (1 a 999).";
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
function validarMuros() {
	var muros = document.getElementById("muros").value;
	var input = document.getElementById("muros");
	var mensaje = document.getElementById("murosError");
	var icon = document.getElementById("murosIcon");
	var Regex = /^[1-9]\d*$/;

	if (muros === "") {
		mensaje.textContent = "La cantidad de muros es obligatoria.";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
	} else if (!Regex.test(muros)) {
		mensaje.textContent = "El campo muros admite solo numeros enteros positivos (1 a 999).";
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
function validarEjecucion() {
	var ejecucion = document.getElementById("ejecucion").value;
	var input = document.getElementById("ejecucion");
	var mensaje = document.getElementById("ejecucionError");
	var icon = document.getElementById("ejecucionIcon");
	var Regex = /^(100|[1-9]?\d)(\.\d+)?$/;

	if (ejecucion === "") {
		mensaje.textContent = "El procentaje es obligatorio.";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
	} else if (!Regex.test(ejecucion)) {
		mensaje.textContent = "El campo de ejecucion admite solo numeros racionales postivos (0 a 100)";
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
function validarProyecto() {
	var proyecto = document.getElementById("proyecto").value;
	var input = document.getElementById("proyecto");
	var mensaje = document.getElementById("proyectoError");
	var icon = document.getElementById("proyectoIcon");

	if (proyecto === "" || proyecto === "-") {
		mensaje.textContent = "El proyecto es obligatorio.";
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