<%-- 
    Document   : edit.jsp
    Created on : Oct 29, 2011, 2:58:03 PM
    Author     : eduardo
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novo Produto</title>
    </head>
    <body>
        <div id="geral">
            <h1>Novo Produto</h1>
            <hr/>
            <div id="menu">
                <a href="/BotiqueWeb" >Principal</a>
                <a href="produto" >Listar Produtos</a>
            </div>
            <hr/>
            <div id="formulario">
                <form method="post" action="produto">
                    <input name="action" value="save" type="hidden" />
                    <table>
                        <tbody>
                            <tr>
                                <td>ID:</td>
                                <td>
                                    <input name="id" value="${produto.id}" disabled="true"/>
                                </td>
                            </tr>
                            <tr>
                                <td>Descrição:</td>
                                <td>
                                    <input name="descricao" value="${produto.descricao}"/>
                                </td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><input type="submit" value="Salvar"/></td>
                            </tr>
                        </tbody>
                    </table>
                </form>
            </div>
        </div>
    </body>
</html>
