$(document).ready(function() {
	console.log(3);
	$("#btp").click(function() {
		console.log(33);
		var nom = document.getElementById("idNombre").value;
		var div = document.getElementById("idDivision").value;
		var datoss = document.getElementById("idExc");
		if (nom != "" && div != "") {
			return OK;

		} else {
			if(nom == "" && div == ""){
				datoss.innerHTML= `Error los datos no pueden estar vacios`;
			}else {
				if (nom == "") {
					datoss.innerHTML = `Error cargue algun nombre`;

				} else {
					datoss.innerHTML = `Error cargue alguna division`;

				}
			}
		}
		alert("Cargue datos otra ves");
		return false;
	});

});