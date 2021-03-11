

$(document).ready(function() {
	var CONTEXT_PATH = $('#contextPathHolder').attr('href');
	var contador=CONTEXT_PATH.split("/");
	var uurlp="/posis";
	var uurle="/equip";
	var i=0;
	for(i=0;i<contador.length-2;i++){
		uurlp="../"+uurlp;
		uurle="../"+uurle;
	}

	$.get(uurle, function(dataE) {
		var objE = JSON.parse(dataE);
		var datossE = $("#idEquipo")[0];
		var equipo = $("#idEquip").val();
		     datossE.innerHTML = `     <option  value="15">Ninguno </option>`;
		for (a in objE.equipos) { 
			if(objE.equipos[a].idEquipo == equipo){
					datossE.innerHTML += `<option selected value='${objE.equipos[a].idEquipo}'>${objE.equipos[a].nombre}</option>`;
			
			}else{
			datossE.innerHTML += `<option value='${objE.equipos[a].idEquipo}'>${objE.equipos[a].nombre}</option>`;
		}}
	});
	
		
	$.get(uurlp, function(data) {
		var obj = JSON.parse(data);
		var datoss = $("#idPosicion")[0];
		var posicionDefauld = $("#idPosis").val();
		datoss.innerHTML = `<option  value="24">Ninguna</option>`
		
		for (i in obj.posiciones) {
			if(obj.posiciones[i].idPosicion==posicionDefauld){
				datoss.innerHTML += `
  		<option selected value='${obj.posiciones[i].idPosicion}'>${obj.posiciones[i].nombre}</option>`;
			
			}else{
			datoss.innerHTML += `
  		<option value='${obj.posiciones[i].idPosicion}'>${obj.posiciones[i].nombre}</option>`;
			}
		}
	});


	$("#btp").click(function() {
		var nom = $.trim($("#idNombre").val());
		var edad = $("#idedad").val();
		var dn = $("#idDni").val();
		var ec = $("#idEstado").val();
		var datoss = $("#idExc")[0];
		var datos;
		var numero = new RegExp('^[0-9]*$');
		var letras = new RegExp('^[A-Za-z\s ]*$');
		if (nom != "" && edad != "" && edad != "0"  && parseInt(edad) <100 && parseInt(edad) >=16 && dn.length==8 && dn != "" && dn != "0" && numero.test(dn) && numero.test(edad) && letras.test(nom)) {
			return "OK";
		} else {
			datos = $("#idDivNombre");
			datos.slideUp();
			datos.html('');
			if (nom == "") {
				datos.html('<h5 class="text-danger">Tiene que ingresar un nombre</h5>');
				datos.slideDown();
			} else if (letras.test(nom) == false) {
				datos.html('<h5 class="text-danger">Error el nombre ingresado no puede contener numeros</h5>');
				datos.slideDown();
			}
			datos = $("#idDivEdad");
			datos.slideUp();
			datos.html('');
			if (edad == "" || edad == "0") {
				datos.html('<h5 class="text-danger">Tiene que ingresar una edad</h5>');
				datos.slideDown();
			}else if (numero.test(edad) == false) {
				datos.html('<h5 class="text-danger">Error la edad no puede contener caracteres alfanumericos</h5>');
				datos.slideDown();
			} else if(parseInt(edad) <=16){
				datos.html('<h5 class="text-danger">Tiene que ingresar una edad mayor a 15</h5>');
				datos.slideDown();
			} else if(parseInt(edad) >=100){
				datos.html('<h5 class="text-danger">Tiene que ingresar una edad menor a 100</h5>');
				datos.slideDown();
			}
			
			
			
			datos = $("#idDivDni");
			datos.slideUp();
			datos.html('');
			if (dn == "" || dn == "0") {
				datos.html('<h5 class="text-danger">Tiene que ingresar una dni</h5>');
				datos.slideDown();
			} else if (numero.test(dn) == false) {
				datos.html('<h5 class="text-danger">Error el dni no puede contener caracteres alfanumericos</h5>');
				datos.slideDown();
			} else if(parseInt(dn) >100000000 || parseInt(dn) <9999999){
				datos.html('<h5 class="text-danger">Tiene que ingresar una dni de 8 cifras</h5>');
				datos.slideDown();
			}
		}
		return false;
	});

	$("#backLink").click(function(event) {
		event.preventDefault();
		history.back(1);
	});

});