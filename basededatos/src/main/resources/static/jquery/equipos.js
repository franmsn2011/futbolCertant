$(document).ready(function() {
	$("#backLink").click(function(event) {
		event.preventDefault();
		history.back(1);
	});
	$("#regTitle").html("Hello World");
	$("#btp").click(function() {
		var nom = $("#idNombre").val();
		var div = $("#idDivision").val();
		var datoss = $("#idExc")[0];
		var letras = new RegExp('^[A-Za-z\s]*$');
		var divNom = $("#idDivNom")[0];
		var divDiv = $("#idDivDiv")[0];
		if (nom != "" && div != "" && letras.test(nom) && letras.test(div)) {
			return OK;
		} else {
			divNom.innerHTML = ` `;
			if (nom == "") {
				divNom.innerHTML = '<h5 class="text-danger">Tiene que ingresar un nombre</h5>';
			} else {
				if (!letras.test(nom))
					divNom.innerHTML = '<h5 class="text-danger">El nombre solo puede contener caracteres alfanumericos</h5>';
			}
			divDiv.innerHTML = ` `;
			if (div == "") {
				divDiv.innerHTML = '<h5 class="text-danger">Tiene que ingresar una Division</h5>';
			} else {
				if (!letras.test(div))
					divDiv.innerHTML = '<h5 class="text-danger">La division solo puede contener caracteres alfanumericos</h5>';
			}
		}
		return false;
	});

});