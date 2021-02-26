$(document).ready(function() {
	console.log(3);
	$("#btp").click(function() {
		console.log(33);
		var nom=document.getElementById("idNombre").value;
		
		if(nom!=""){
		return OK;
		}
		var datoss = document.getElementById("idExc");
		datoss.innerHTML= `Error el dato no puede ser nulo
  		
  	`;
		alert("El nombre no puede ser nulo");
		return false;
	});

});




$('#btpos').on('click', function() {
	console.log(1);
	$.ajax({
		data: { id: 123 },
		type: 'GET',

		dataType: 'json',
		success: function(json) {
			console.log(2);
		},
		error: function(xhr, status) {
			var datoss = document.getElementById("idDiv");
			datos.innerHTML = `
			<h2>Error</h2>;  		
`
		},

		// código a ejecutar sin importar si la petición falló o no
		complete: function(xhr, status) {
			alert('Petición realizada');
		}
	});
});