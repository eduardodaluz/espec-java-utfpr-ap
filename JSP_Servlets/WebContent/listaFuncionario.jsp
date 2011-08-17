<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="br.edu.utfpr.ap.jsp.connection.ConnectionFactory"%>
<%@page import="br.edu.utfpr.ap.jsp.funcionario.FuncionarioDAO"%>
<%@page import="br.edu.utfpr.ap.jsp.funcionario.Funcionario"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
    
    int id = 0;
    String sId   = request.getParameter("id");
    String texto = request.getParameter("nome");
    
    try {
        id = Integer.parseInt(sId);
    } catch (Exception e) {
        id = 0;
    }

    if ((id > 0) || (texto != null)) {
    
        Funcionario funcParametro = new Funcionario();
        funcParametro.setNome(texto);
        %>
        <table align="center">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Endereço</th>
                    <th>Telefone</th>
                </tr>
            </thead>
            <tbody>
        <%
        FuncionarioDAO dao = new FuncionarioDAO(ConnectionFactory.getConnection());
        for (Funcionario func : dao.pesquisa(funcParametro)) {
        %>
            
                <tr>
                    <td><%= func.getId()%></td>
                    <td><%= func.getNome()%></td>
                    <td><%= func.getEndereco()%></td>
                    <td><%= func.getTelefone()%></td>
                </tr>
                <%
        } %>
            </tbody>
        </table>
        <%
    } else { %>
<html>
    <%@include file="WEB-INF/jspf/verificaLogin.jspf"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="css/estilo.css" />
        <title>Funcionarios</title>
        <script language="Javascript">
            function xmlhttpPost(strURL) {
                var xmlHttpReq = false;
                var self = this;
                // Mozilla/Safari
                if (window.XMLHttpRequest) {
                    self.xmlHttpReq = new XMLHttpRequest();
                }
                // IE
                else if (window.ActiveXObject) {
                    self.xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
                }
                self.xmlHttpReq.open('POST', strURL, true);
                self.xmlHttpReq.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
                self.xmlHttpReq.onreadystatechange = function() {
                    if (self.xmlHttpReq.readyState == 4) {
                        updatepage(self.xmlHttpReq.responseText);
                    }
                }
                self.xmlHttpReq.send(getquerystring());
            }

            function getquerystring() {
                var form     = document.forms['f1'];
                var id = form.codigo.value;
                var nome = form.nome.value;
                qstr = 'id=' + escape(id) + '&nome=' + escape(nome);
                return qstr;
            }

            function updatepage(str){
                document.getElementById("registros").innerHTML = str;
            }
        </script>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/cabecalho.jspf"%>
        <div id="formulario">
        <form name="f1">
            <fieldset>
                <legend>Procura Funcionario</legend>
                <label id="lbCodigo" name="lbCodigo">ID:</label>
                <input id="codigo" name="codigo" type="text" />
                <label id="lbNome" name="lbNome">Nome:</label>
                <input id="nome" name="nome" type="text" />
                <!--
                <label id="lbEndereco" name="lbEndereco">Endereço:</label>
                <input id="ipEndereco" name="ipEndereco" type="text" /><br />
                <label id="lbTelefone" name="lbTelefone">Telefone:</label>
                <input id="ipTelefone" name="ipTelefone" type="text" /><br />
                <label id="lbDataNasc" name="lbDataNasc">Data Nasc.:</label>
                <input id="ipDataNasc" name="ipDataNasc" type="text" /><br /> -->
                <input type="button" value="procurar" onclick='JavaScript:xmlhttpPost("listaFuncionario.jsp")' />
            </fieldset>
        </form>
        </div>
        <hr />
        <div id="registros">
            Nenhum registro encontrado!
        </div>
        <%@include file="WEB-INF/jspf/rodape.jspf"%>
    </body>
</html>
<%}%>