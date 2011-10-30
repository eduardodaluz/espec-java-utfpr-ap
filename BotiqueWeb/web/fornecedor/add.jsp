<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/main.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novo Fornecedor</title>
    </head>
    <body>
        <div id="menu" class="nav">
            <span class="menuButton"><a class="home" href="/BotiqueWeb" >Principal</a></span>
            <span class="menuButton"><a class="list" href="fornecedor" >Listar Fornecedores</a></span>
        </div>
        <div id="geral" class="body">
            <h1>Novo Fornecedor</h1>
            <hr/>
            <div id="formulario">
                <form method="post" action="fornecedor">
                    <input name="action" value="save" type="hidden" />
                    <input name="id" value="${fornecedor.id}" type="hidden" />
                    <div class="dialog">
                    <table>
                        <tbody>
                            <tr>
                                <td>ID:</td>
                                <td>
                                    <input name="id" value="${fornecedor.id}" disabled="true" />
                                </td>
                            </tr>
                            <tr>
                                <td>Nome:</td>
                                <td>
                                    <input name="nome" value="${fornecedor.nome}" />
                                </td>
                            </tr>
                            <tr>
                                <td>Telefone:</td>
                                <td>
                                    <input name="telefone" value="${fornecedor.telefone}" />
                                </td>
                            </tr>
                            <tr>
                                <td>Email:</td>
                                <td>
                                    <input name="email" value="${fornecedor.email}" />
                                </td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><input type="submit" value="Salvar"/></td>
                            </tr>
                        </tbody>
                    </table>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
