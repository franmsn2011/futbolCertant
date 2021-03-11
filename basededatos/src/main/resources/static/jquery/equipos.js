$(document).ready(function() {
	$("#backLink").click(function(event) {
		event.preventDefault();
		history.back(1);
	});
	$("#btp").click(function() {
		var nom = $.trim($("#idNombre").val());
		var div = $.trim($("#idDivision").val());
		var letras = new RegExp('^[A-Za-z\s ]*$');
		var divNom = $("#idDivNom");
		var divDiv = $("#idDivDiv");
		if (nom != "" && div != "" && letras.test(nom) && letras.test(div)) {
			return "OK";
		} else {
		    divNom.slideUp(250);
			divNom.html('');
			if (nom == "") {
				
				divNom.html('<h5 class="text-danger">Tiene que ingresar un nombre</h5>');
				divNom.slideDown();
			} else {
				if (!letras.test(nom)) {
					divNom.html('<h5 class="text-danger">El nombre solo puede contener caracteres alfanumericos</h5>');
					divNom.slideDown();
				}
			}
			divDiv.slideUp(250);
			divDiv.html('');
			if (div == "") {
				divDiv.html('<h5 class="text-danger">Tiene que ingresar una Division</h5>');
				divDiv.slideDown();
			} else {
				if (!letras.test(div)) {
					divDiv.html('<h5 class="text-danger">La division solo puede contener caracteres alfanumericos</h5>');
					divDiv.slideDown();
				}
			}
		}
		return false;
	});

});