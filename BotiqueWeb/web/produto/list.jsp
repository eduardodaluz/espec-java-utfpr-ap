<%@page import="modelo.Produto"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="geral">
            <h1>Lista de Produtos</h1>
            <hr/>
            <div id="menu">
                <a href="/BotiqueWeb" >Principal</a>
                <a href="produto?action=add" >Novo Produto</a>
            </div>
            <hr/>
            <div id="pesquisar">
                <p>Pesquisar:</p>
                <form method="post" action="produto">
                    <input name="action" value="search" type="hidden"/>
                    <table>
                        <tbody>
                            <tr>
                                <td>Descrição: </td>
                                <td><input name="descricao" value="" /></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><input value="Enviar" type="submit" /></td>
                            </tr>
                        </tbody>
                    </table>
                </form>
            </div>
            <hr/>
            <div id="tabela">
                <p>Lista:</p>
                <table>
                    <tbody>
                        <tr>
                            <th>Editar</th>
                            <th>Excluir</th>
                            <th>ID</th>
                            <th>Descrição</th>
                        </tr>
                    <c:forEach var="prod" items="${produtoInstanceList}">
                        <tr>
                            <td>
                                <a href="produto?action=edit&id=${prod.id}">Editar</a>
                            </td>
                            <td>
                                <a href="produto?action=delete&id=${prod.id}">Excluir</a>
                            </td>
                            <td>${prod.id}</td>
                            <td>${prod.descricao}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
