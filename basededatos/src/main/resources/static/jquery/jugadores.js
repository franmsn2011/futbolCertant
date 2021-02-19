const url='http://localhost:8080/posicion/listaa';
$(document).ready(function() {

$('#idPos').on('click', function () {
    console.log(4)
    $.get(url,function(data){
  	//var obj=JSON(data)
  	//console.log(obj.nombre)
 });
});

});