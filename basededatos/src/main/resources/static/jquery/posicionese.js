$(document).ready(function() {
	console.log(3);
	
	});
$('#btp').on('click', function() {
	console.log(1);
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