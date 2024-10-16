function validarIdUpdate() {
    var idUpdate = document.getElementById("idUpdate").value;
	var inputIdUpdate = document.getElementById("idUpdate");	
    var mensaje = document.getElementById("idUpdateError");
	var icon = document.getElementById("iconIdUpdate");
	var IdRegex = /^[0-9]{1,3}$/;
	
    if (idUpdate === "") {
        mensaje.textContent = "El id es obligatorio.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		inputIdUpdate.style.borderColor = "red";
    } else if(!IdRegex.test(idUpdate)){
		mensaje.textContent = "El id admite solo numeros de hasta 3 cifras.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		inputIdUpdate.style.borderColor = "red";
	}else{
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		inputIdUpdate.style.borderColor = "green";
	}
}
function validarIdLoad() {
	var idLoad = document.getElementById("idLoad").value;
	var inputIdLoad = document.getElementById("idLoad");	
    var mensaje = document.getElementById("idLoadError");
	var icon = document.getElementById("iconIdLoad");
	var IdRegex = /^[0-9]{1,3}$/;
	
    if (idLoad === "") {
        mensaje.textContent = "El id es obligatorio.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		inputIdLoad.style.borderColor = "red";
    } else if(!IdRegex.test(idLoad)){
		mensaje.textContent = "El id admite solo numeros de hasta 3 cifras.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		inputIdLoad.style.borderColor = "red";
	}else{
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		inputIdLoad.style.borderColor = "green";
	}
}

function validarIdDelete() {
	var idDelete = document.getElementById("idDelete").value;
	var inputIdDelete = document.getElementById("idDelete");	
    var mensaje = document.getElementById("idDeleteError");
	var icon = document.getElementById("iconIdDelete");
	var IdRegex = /^[0-9]{1,3}$/;
	
    if (idDelete === "") {
        mensaje.textContent = "El id es obligatorio.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		inputIdDelete.style.borderColor = "red";
    } else if(!IdRegex.test(idDelete)){
		mensaje.textContent = "El id admite solo numeros de hasta 3 cifras.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		inputIdDelete.style.borderColor = "red";
	}else{
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		inputIdDelete.style.borderColor = "green";
	}
}

function validarFecha() {
    var fecha = document.getElementById("fecha").value;
	var inputFecha = document.getElementById("fecha");
    var mensaje = document.getElementById("fechaError");
	var icon = document.getElementById("iconFecha");
	var FechaRegex = /^(?:3[01]|[12][0-9]|0?[1-9])([\-/.])(0?[1-9]|1[1-2])\1\d{4}$/;	

    if (fecha === "") {
        mensaje.textContent = "La fecha es obligatoria.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		inputFecha.style.borderColor = "red";
    } else if(!FechaRegex.test(fecha)){
        mensaje.textContent = "El fecha admite el formato dd/MM/yyyy";
		mensaje.style.color = "red";
		icon.style.color = "red";
		inputFecha.style.borderColor = "red";
    }else{
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		inputFecha.style.borderColor = "green";
	}
}

function validarTramo_amp() {
    var tramo = document.getElementById("tramo_amp").value;
	var input = document.getElementById("tramo_amp");
    var mensaje = document.getElementById("tramo_ampError");
	var icon = document.getElementById("iconTramo_amp");
	var Regex = /^(?:[1-9]\d*|[1-9]\d*\.\d{2})$/;
	

    if (tramo === "") {
        mensaje.textContent = "El tramo_amp es obligatorio.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
    } else if(!Regex.test(tramo)){
        mensaje.textContent = "El tramo_amp admite solo numeros enteros y decimales positivos.";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
    }else{
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
	var icon = document.getElementById("iconTramo_mej");
	var Regex = /^(?:[1-9]\d*|[1-9]\d*\.\d{2})$/;

    if (tramo === "") {
        mensaje.textContent = "El tramo_mej es obligatorio.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
    } else if(!Regex.test(tramo)){
        mensaje.textContent = "El tramo_mej admite solo numeros enteros y decimales positivos.";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
    }else{
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
	var icon = document.getElementById("iconTramo_sub");
	var Regex = /^(?:[1-9]\d*|[1-9]\d*\.\d{2})$/;

    if (tramo === "") {
        mensaje.textContent = "El tramo_sub es obligatorio.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
    } else if(!Regex.test(tramo)){
        mensaje.textContent = "El tramo_sub admite solo numeros enteros y decimales positivos.";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
    }else{
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
	var icon = document.getElementById("iconTramo_bas");
	var Regex = /^(?:[1-9]\d*|[1-9]\d*\.\d{2})$/;

    if (tramo === "") {
        mensaje.textContent = "El tramo_bas es obligatorio.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
    } else if(!Regex.test(tramo)){
        mensaje.textContent = "El tramo_bas admite solo numeros enteros y decimales positivos.";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
    }else{
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
	var icon = document.getElementById("iconTramo_asf");
	var Regex = /^(?:[1-9]\d*|[1-9]\d*\.\d{2})$/;

    if (tramo === "") {
        mensaje.textContent = "El tramo_asf es obligatorio.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
    } else if(!Regex.test(tramo)){
        mensaje.textContent = "El tramo_asf admite solo numeros enteros y decimales positivos.";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
    }else{
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
	var icon = document.getElementById("iconCunetas");
	var Regex = /^[0-9]\d*$/;

    if (cunetas === "") {
        mensaje.textContent = "La cantidad de cunetas son obligatorias.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
    } else if(!Regex.test(cunetas)){
        mensaje.textContent = "El campo cunetas admite solo numeros enteros";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
    }else{
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
	var icon = document.getElementById("iconMuros");
	var Regex = /^[1-9]\d*$/;

    if (muros === "") {
        mensaje.textContent = "La cantidad de muros es obligatorio.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
    } else if(!Regex.test(tramo)){
        mensaje.textContent = "El campo muros admite solo numeros enteros";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
    }else{
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
	var icon = document.getElementById("iconEjecucion");
	var Regex = /^(100|[1-9]?\d)(\.\d+)?$/;

    if (ejecucion === "") {
        mensaje.textContent = "El procentaje de ejecucion es obligatorio.";
        mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
    } else if(!Regex.test(ejecucion)){
        mensaje.textContent = "El campo de porcentaje de ejecucion admite solo numeros enteros y decimales postivos menores a 100%";
		mensaje.style.color = "red";
		icon.style.color = "red";
		input.style.borderColor = "red";
    }else{
		mensaje.textContent = "";
		mensaje.style.color = "green";
		icon.style.color = "green";
		input.style.borderColor = "green";
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
    validarIdUpdate();
    validarIdLoad();
	validarIdDelete();
	validarFecha();
	validarTramo_amp();
	validarTramo_mej();
	validarTramo_bas();
	validarTramo_sub();
	validarTramo_asf();
	validarCunetas();
	validarMuros();
	validarEjecucion();
	validarProyecto();
	
    return document.getElementById("idError").textContent === "" + 
	document.getElementById("fechaError").textContent === ""+
	document.getElementById("tramo_ampError").textContent === "" +
	document.getElementById("tramo_mejError").textContent === "" + 
	document.getElementById("tramo_subError").textContent === ""+
	document.getElementById("tramo_basError").textContent === "" + 
	document.getElementById("tramo_asfError").textContent === ""+
	document.getElementById("cunetasError").textContent === "" + 
	document.getElementById("murosError").textContent === ""+
	document.getElementById("ejecucionError").textContent === "" + 
	document.getElementById("proyectoError").textContent === "";
}