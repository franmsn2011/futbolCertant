$(document).ready(function() {
	$("#btp").click(function() {
		var nom  = document.getElementById("idNombre").value;
		var letras = new RegExp('^[a-zA-Z]*$');
		if (nom != "" && letras.test(nom)) {
			return OK;
		}
		var d = document.getElementById("idDivNom");
		if (nom == "")  {
			d.innerHTML = '<h5 class="text-danger">Ingrese el nombre por favor</h5>';
		} else {
			if (letras.test(nom) == false) {

				d.innerHTML = '<h5 class="text-danger">El nombre solo puede tener caracteres alfabeticos</h5>';
			}
		}
		var datoss = document.getElementById("idExc");
		datoss.innerHTML = `verifique los datos nuevamente`;
		return false;
	});

});


