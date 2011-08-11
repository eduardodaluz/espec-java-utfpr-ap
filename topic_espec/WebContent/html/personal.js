$(document).ready(function() {
	var count = 0;
	alert("Olá mundo jQuery!");
	$("#star1").hide("fast");
	$("#star2").hide("fast");
	$(".stars").click(function() {
		count++;
		if (count > 3 ) {
			$("#star1").fadeIn("slow");
		}
		if (count >= 6) {
			$("#star2").fadeIn("slow");
		}
	});
	$("#avatar").click(function () {
		alert("Foto de ..., nrº de fãns: " + count);
	});
	$("#btRecado").click(function() {
		var recado = prompt("Escreva seu recado aqui:");
		if (recado != null && recado.trim() != "") {
			$("#recados").hide();
			$("#recados").append(recado);
			$("#recados").append("<br />");
			$("#recados").fadeIn("slow");
		}
	});
});