const url = 'http://localhost:8080/posis';
const urlE = 'http://localhost:8080/equip';
$(document).ready(function() {


	$.get(url, function(data) {
		var obj = JSON.parse(data);
		var datoss = document.getElementById("idPos");
		console.log(obj.length);

		for (i in obj.posiciones) {
			datoss.innerHTML += `
  		<option value='${obj.posiciones[i].idPosicion}'>${obj.posiciones[i].nombre}</option>`;

		}
	});
	$.get(urlE, function(dataE) {
		var objE = JSON.parse(dataE);
		var datossE = document.getElementById("idEqui");
		for (a in objE.equipos) {
			datossE.innerHTML += `<option value='${objE.equipos[a].idEquipo}'>${objE.equipos[a].nombre}</option>`;
		}
	});
	
	$("#btp").click(function() {
		console.log(33);
		var nom = document.getElementById("idNombre").value;
		var edad = document.getElementById("idedad").value;
		var dn = document.getElementById("idDni").value;
		var ec = document.getElementById("idEstado").value;
		var datoss = document.getElementById("idExc");
		var datos;
		var numero = new RegExp('^[0-9]*$');
		var letras = new RegExp('^[a-zA-Z0-9]*$')
		if (nom != "" && edad != "" && dn!="" && ec!="" && numero.test(dn) && numero.test(edad) && numero.test(edad)) {
			return OK;

		} else {
			if(nom == "" || edad == "" || dn=="" || ec==""){
				datoss.innerHTML= `Error los datos no pueden estar vacios`;
			}else if(numero.test(dn)==false){
			datos = document.getElementById("idDivDni");
					datos.innerHTML+= `<h5 class="text-danger">Error el dni tiene que tener todos caracteres numericos</h5>`;
			}
			if(numero.test(edad)==false){
			datos = document.getElementById("idDivEdad");
					datos.innerHTML+= `<h5 class="text-danger">Error la edad tiene que tener todos caracteres numericos</h5>`;
			}
			if(letras.test(nom)==false){
			datos = document.getElementById("idDivNombre");
					datos.innerHTML+= `<h5 class="text-danger">Error el nombre ingresado no puede contener numeros</h5>`;
			}
			
		}
		alert("Cargue datos otra ves");
		return false;
	});



});