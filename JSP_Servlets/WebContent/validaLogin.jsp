<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="css/estilo.css" />
        <title>Login</title>
    </head>
    <body>
        <h1>Login do sistema...</h1>
        <%
            String usuario = request.getParameter("usuario");
            String senha = request.getParameter("senha");
            Boolean loginAceito = usuario.equals("admin") && senha.equals("12345");
            
            if (loginAceito) {
                session.setAttribute("loginAceito", true);
                session.setAttribute("usuario", usuario);
                %>
                <h2>Login Aceito!</h2>
                <a href="index.jsp">Acesso ao sistema!</a>
                <%
                
            } else {
                session.setAttribute("loginAceito", false);
                session.setAttribute("usuario", null);
                %>
                <h2>Login Negado!</h2>
                <a href="login.jsp">Tente novamente!</a>
                <%
            }
        %>
    </body>
</html>