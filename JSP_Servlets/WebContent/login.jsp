<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="css/estilo.css" />
        <title>Sistema Login</title>
    </head>
    <body>
        <% session.invalidate(); %>
        <%@include file="WEB-INF/jspf/cabecalho.jspf" %>
        <form action="validaLogin.jsp" method="post">
            <fieldset>
                <legend>Login:</legend>
                <label for="usuario">Usuário:</label>
                <input class="redondo" type="text" name="usuario" id="usuario" /><br />
                <label for="senha">Senha:</label>
                <input class="redondo" type="password" name="senha" id="senha" /><br />
                <input type="submit" value="enviar" /><br />
            </fieldset>
        </form>
        <%@include file="WEB-INF/jspf/rodape.jspf" %>
    </body>
</html>