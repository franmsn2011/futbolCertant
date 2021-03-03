const url = 'http://localhost:8080/posis';
const urlE = 'http://localhost:8080/equip';
$(document).ready(function() {
	$.get(url, function(data) {
		var obj = JSON.parse(data);
		var datoss = document.getElementById("idPos");
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
		var nom = document.getElementById("idNombre").value;
		var edad = document.getElementById("idedad").value;
		var dn = document.getElementById("idDni").value;
		var ec = document.getElementById("idEstado").value;
		var datoss = document.getElementById("idExc");
		var datos;
		var numero = new RegExp('^[0-9]*$');
		var letras = new RegExp('^[a-zA-Z]*$');
		if (nom != "" && edad !="" && edad!="0"  && dn!=""&& dn!="0"  && numero.test(dn)&& numero.test(edad) && letras.test(nom)) {
			return OK;
		}else {
			datos = document.getElementById("idDivNombre");
						datos.innerHTML= ` `;
			if(nom==""){
					datos.innerHTML= `<h5 class="text-danger">Tiene que ingresar un nombre</h5>`;
			}else if(letras.test(nom)==false){
					datos.innerHTML= `<h5 class="text-danger">Error el nombre ingresado no puede contener numeros</h5>`;
				}
			datos = document.getElementById("idDivEdad");
					datos.innerHTML= ` `;
				
			if(edad=="" || edad=="0"){
					datos.innerHTML= `<h5 class="text-danger">Tiene que ingresar una edad</h5>`;
			}else if(numero.test(edad)==false){
					datos.innerHTML= `<h5 class="text-danger">Error la edad no puede contener caracteres alfanumericos</h5>`;
				}
			datos = document.getElementById("idDivDni");	
			datos.innerHTML= ` `;
			if(dn=="" || dn=="0"){
					datos.innerHTML= `<h5 class="text-danger">Tiene que ingresar una dni</h5>`;
			}else if(numero.test(dn)==false){
					datos.innerHTML= `<h5 class="text-danger">Error el dni no puede contener caracteres alfanumericos</h5>`;
				}
		}
		return false;
	});



});