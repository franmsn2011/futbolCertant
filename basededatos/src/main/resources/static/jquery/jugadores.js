//const url = '@{posicion/posis}';
const urlp = '../posis';
const urlE = '../equip';
$(document).ready(function() {

	$.get(urlE, function(dataE) {
		var objE = JSON.parse(dataE);
		var datossE = $("#idEqui")[0];
		for (a in objE.equipos) {
			datossE.innerHTML += `<option value='${objE.equipos[a].idEquipo}'>${objE.equipos[a].nombre}</option>`;
		}
	});




/*
	var ru = $('#ruta');
	var CONTEXT_PATH = $('#contextPathHolder').attr('href');
	console.log(CONTEXT_PATH);
	*/
	$.get(urlp, function(data) {
		var obj = JSON.parse(data);
		var datoss = $("#idPos")[0];
		for (i in obj.posiciones) {
			datoss.innerHTML += `
  		<option value='${obj.posiciones[i].idPosicion}'>${obj.posiciones[i].nombre}</option>`;
		}
	});


	$("#btp").click(function() {
		var nom = $("#idNombre").val();
		var edad = $("#idedad").val();
		var dn = $("#idDni").val();
		var ec = $("#idEstado").val();
		var datoss = $("#idExc")[0];
		var datos;
		var numero = new RegExp('^[0-9]*$');
		var letras = new RegExp('^[A-Za-z\s]*$');
		if (nom != "" && edad != "" && edad != "0" && dn != "" && dn != "0" && numero.test(dn) && numero.test(edad) && letras.test(nom)) {
			return OK;
		} else {
			datos = $("#idDivNombre")[0];
			datos.innerHTML = ` `;
			if (nom == "") {
				datos.innerHTML = `<h5 class="text-danger">Tiene que ingresar un nombre</h5>`;
			} else if (letras.test(nom) == false) {
				datos.innerHTML = `<h5 class="text-danger">Error el nombre ingresado no puede contener numeros</h5>`;
			}
			datos = $("#idDivEdad")[0];
			datos.innerHTML = ` `;

			if (edad == "" || edad == "0") {
				datos.innerHTML = `<h5 class="text-danger">Tiene que ingresar una edad</h5>`;
			} else if (numero.test(edad) == false) {
				datos.innerHTML = `<h5 class="text-danger">Error la edad no puede contener caracteres alfanumericos</h5>`;
			}
			datos = $("#idDivDni")[0];
			datos.innerHTML = ` `;
			if (dn == "" || dn == "0") {
				datos.innerHTML = `<h5 class="text-danger">Tiene que ingresar una dni</h5>`;
			} else if (numero.test(dn) == false) {
				datos.innerHTML = `<h5 class="text-danger">Error el dni no puede contener caracteres alfanumericos</h5>`;
			}
		}
		return false;
	});

	$("#backLink").click(function(event) {
		event.preventDefault();
		history.back(1);
	});

});