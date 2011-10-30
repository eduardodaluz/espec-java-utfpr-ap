<%@page import="modelo.Pedido"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/main.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="menu" class="nav">
            <span class="menuButton"><a class="home" href="/BotiqueWeb" >Principal</a></span>
            <span class="menuButton"><a class="create" href="pedido?action=add" >Novo Pedido</a></span>    
        </div>
        <div id="geral" class="body">
            <h1>Lista de Pedidos</h1>
            <hr/>
            <div id="tabela" class="list">
                <table>
                    <thead>
                        <tr>
                            <th>Editar</th>
                            <th>Excluir</th>
                            <th>ID</th>
                            <th>Numero</th>
                            <th>Data Pedido</th>
                            <th>Fornecedor</th>
                            <th>Qntd. Itens</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="ped" items="${pedidoInstanceList}" varStatus="i">
                        <tr class="${(i.count % 2) == 0 ? 'odd' : 'even'}">
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