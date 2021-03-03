$(document).ready(function() {
	$("#btp").click(function() {
		var nom = document.getElementById("idNombre").value;
		var div = document.getElementById("idDivision").value;
		var datoss = document.getElementById("idExc");
		var letras = new RegExp('^[a-zA-Z]*$');
		var divNom = document.getElementById("idDivNom");
		var divDiv = document.getElementById("idDivDiv");
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