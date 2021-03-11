$(document).ready(function() {
	$("#backLink").click(function(event) {
		event.preventDefault();
		history.back(1);
	});
	$("#btp").click(function() {
		var nom = $.trim($("#idNombre").val());
		var letras = new RegExp('^[A-Za-z\s ]*$');
		if (nom != "" && letras.test(nom)) {
			return "OK";
		}
		var d = $("#idDivNom");
		d.slideUp();
		if (nom == "") {
			d.html('<h5 class="text-danger">Ingrese el nombre por favor</h5>');
			d.slideDown();
		} else {
			if (letras.test(nom) == false) {
				d.html('<h5 class="text-danger">El nombre solo puede tener caracteres alfabeticos</h5>');
				d.slideDown();		
			}
		}
		var datoss = $("#idExc");
		datoss.html('verifique los datos nuevamente');
		return false;
	});

});


