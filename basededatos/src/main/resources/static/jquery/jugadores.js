const url = 'http://localhost:8080/posis';
const urlE = 'http://localhost:8080/equip';
$(document).ready(function() {
	

	$.get(url, function(data) {
		var obj = JSON.parse(data);
		var datoss = document.getElementById("idPos");
		console.log(obj.length);

		for (i in obj.posiciones) {
			datoss.innerHTML += `
  		<option value='${obj.posiciones[i].idPosicion}'>${obj.posiciones[i].nombre}</option>
  	`;

		}
	});
	$.get(urlE, function(dataE) {
		var objE = JSON.parse(dataE);
		var datossE = document.getElementById("idEqui");
		for (a in objE.equipos) {
		
			datossE.innerHTML += `
  		<option value='${objE.equipos[a].idEquipo}'>${objE.equipos[a].nombre}</option>
  	`;

		}
	});
	/*
   $('#idPos').on('click', function () {
	   
	   console.log(4)
	   
	   $.get(url,function(data){
	   console.log(data);
	   console.log(JSON.parse(data));
	   var obj=JSON.parse(data);
		   console.log(obj.posiciones[0].nombre);
		   var datoss=document.getElementById("idPos");
		   console.log(obj.length);
	 	
		   for (i in obj.posiciones) {
		   datoss.innerHTML+= `
			   <option value='${obj.posiciones[i].idPosicion}'>${obj.posiciones[i].nombre}</option>
		   `;
	 	
		   }
	});*/



});