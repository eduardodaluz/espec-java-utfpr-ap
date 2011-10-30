<%@page import="modelo.Pedido"%>
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
            <h1>Lista de Pedidos</h1>
            <hr/>
            <div id="menu">
                <a href="/BotiqueWeb" >Principal</a>
                <a href="pedido?action=add" >Novo Pedido</a>
            </div>
            <hr/>
            <div id="pesquisar">
<!--                <p>Pesquisar:</p>
                <form method="post" action="pedido">
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
                </form>-->
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
                            <th>Numero</th>
                            <th>Data Pedido</th>
                            <th>Fornecedor</th>
                            <th>Qntd. Itens</th>
                        </tr>
                    <c:forEach var="ped" items="${pedidoInstanceList}">
                        <tr>
                            <td>
                                <a href="pedido?action=edit&id=${ped.id}">Editar</a>
                            </td>
                            <td>
                                <a href="pedido?action=delete&id=${ped.id}">Excluir</a>
                            </td>
                            <td>${ped.id}</td>
                            <td>${ped.numero}</td>
                            <td>${ped.dtPedido}</td>
                            <td>${ped.fornecedor}</td>
                            <td>${ped.pedidoItens.size()}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>