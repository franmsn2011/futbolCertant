$(document).ready(function() {
	$("#backLink").click(function(event) {
		event.preventDefault();
		history.back(1);
	});
	$("#btp").click(function() {
		var nom = $("#idNombre").val();
		var letras = new RegExp('^[A-Za-z\s ]*$');
		if (nom != "" && letras.test(nom)) {
			return "OK";
		}
		var d = $("#idDivNom")[0];
		
		if (nom == "") {
			d.innerHTML = '<h5 class="text-danger">Ingrese el nombre por favor</h5>';
		} else {
			if (letras.test(nom) == false) {		
				d.innerHTML = '<h5 class="text-danger">El nombre solo puede tener caracteres alfabeticos</h5>';		
			}
		}
		var datoss = $("#idExc")[0];
		datoss.innerHTML = `verifique los datos nuevamente`;
		return false;
	});

});


