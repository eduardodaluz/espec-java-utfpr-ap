<%@page import="modelo.Fornecedor"%>
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
            <h1>Lista de Fornecedores</h1>
            <hr/>
            <div id="menu">
                <a href="/BotiqueWeb" >Principal</a>
                <a href="fornecedor?action=add" >Novo Fornecedor</a>
            </div>
            <hr/>
            <div id="pesquisar">
                <p>Pesquisar:</p>
                <form method="post" action="fornecedor">
                    <input name="action" value="search" type="hidden"/>
                    <table>
                        <tbody>
                            <tr>
                                <td>Nome: </td>
                                <td><input name="nome" value="" /></td>
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
                            <th>Nome</th>
                            <th>Telefone</th>
                            <th>Email</th>
                        </tr>
                    <c:forEach var="forn" items="${fornecedorInstanceList}">
                        <tr>
                            <td>
                                <a href="fornecedor?action=edit&id=${forn.id}">Editar</a>
                            </td>
                            <td>
                                <a href="fornecedor?action=delete&id=${forn.id}">Excluir</a>
                            </td>
                            <td>${forn.id}</td>
                            <td>${forn.nome}</td>
                            <td>${forn.telefone}</td>
                            <td>${forn.email}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
