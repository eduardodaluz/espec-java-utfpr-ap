/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

var numeroFan = 0;
var contador = 0;

$(document).ready( function() {
	if(numeroFan = 0) {
		$(".fanstar:eq(1)").fadeOut("fast");
		$(".fanstar:eq(2)").fadeOut("fast");
	}
	$(".fanstar:eq(0)").click(
			function() {
				numeroFan = numeroFan + 1;
				$(".fanstar:eq(0)").fadeIn("slow");
				if (numeroFan > 3) {
					$(".fanstar:eq(1)").fadeIn("slow");
				}
				if (numeroFan > 6 ) {
					$(".fanstar:eq(2)").fadeIn("slow");
				}
			}
	);
});

function msgTroll() {
    alert("Vc foi trollado!");
    contador++;
}

function msgTrollAgain() {
    if (contador > 0) {
        confirm("Foi Trollado novamente!!!");
        contador++;
    } else {
        msgTroll();
    }
}

function insertMsg() {
    
    var recado = prompt("Deixe seu recado para o Troll");
    var recados = document.getElementById("recados").innerHTML;
    
    if (recado != null && recado.length > 0) {
        if(recados.toString().length == 0) {
            document.getElementById("recados").innerHTML = recado;
        } else {
            document.getElementById("recados").innerHTML = recados + "<br />" + recado;
        }
    }
}

function fan() {
    numeroFan = numeroFan + 1;
    var imagens = "";
    if (numeroFan < 3) {
        imagens = "<img src=\"star.png\" alt=\"\" id=\"fanstar\" onclick=\"fan()\"/>";
    } else if (numeroFan < 7 ) {
        for(var i = 0; i < 2; i++) {
            imagens = imagens +"<img src=\"star.png\" id=\"fanstar\" alt=\"\" onclick=\"fan()\"/>";
        }
    } else if (numeroFan >= 7 ){
        for(var y = 0; y < 3; y++) {
            imagens = imagens +"<img src=\"star.png\" alt=\"\" id=\"fanstar\" onclick=\"fan()\"/>";
        }
    }
    document.getElementById("fans").innerHTML = imagens;
}