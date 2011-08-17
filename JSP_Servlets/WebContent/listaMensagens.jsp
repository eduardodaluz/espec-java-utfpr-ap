<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="br.edu.utfpr.ap.jsp.mensagem.Mensagem"%>
<%@page import="java.util.List"%>
<%@page import="br.edu.utfpr.ap.jsp.mensagem.MensagemDAO"%>
<%@page import="java.sql.Connection"%>
<%@page import="br.edu.utfpr.ap.jsp.connection.ConnectionFactory"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="WEB-INF/jspf/verificaLogin.jspf"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="css/estilo.css" />
        <title>Lista de mensagens!</title>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/cabecalho.jspf"%>
        <h1>Mensagens enviadas...</h1>
        <div id="mensagens">
        	<table align="center">
	        	<thead>
	        		<tr><th>Mensagens</th></tr>
	        	</thead>
	        	<tbody>
	            <%
	                Connection conn = ConnectionFactory.getConnection();
	                MensagemDAO dao = new MensagemDAO(conn);
	                List<Mensagem> msgs = dao.getMensagens();
	                for(Mensagem msg : msgs) {
	                	%>
	                	<tr><td><%=msg.toString() %></td></tr>
	                	<%
	                }
	            %>
	            </tbody>
            </table>
        </div>
        <%@include file="WEB-INF/jspf/rodape.jspf"%>
    </body>
</html>