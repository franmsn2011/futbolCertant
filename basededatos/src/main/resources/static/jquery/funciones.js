function eliminar(idPosicion) {
	swal({
		title: "Estas seguro que quieres borrar?",
		text: "Once deleted, you will not be able to recover this imaginary file!",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
		.then((OK) => {
			if (OK) {
				$.ajax({
				 url :"/posicion/eliminar/"+idPosicion,
					success: function(res) {
						console.log(res);
					}
				});
				swal("Poof! Your imaginary file has been deleted!", {
					icon: "success",
				}).then((ok)=>{
					if(ok){
						location.href="/posicion/list";
					}
				});
			} else {
				swal("Your imaginary file is safe!");
			}
		});
}