<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/main.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Produto</title>
    </head>
    <body>
        <div id="menu" class="nav">
            <span class="menuButton"><a class="home" href="/BotiqueWeb" >Principal</a></span>
            <span class="menuButton"><a class="list" href="produto" >Listar Produtos</a></span>
        </div>
        <div id="geral" class="body">
            <h1>Editar Produto</h1>
            <hr/>
            <div id="formulario">
                <form method="post" action="produto">
                    <input name="action" value="update" type="hidden" />
                    <input name="id" value="${produto.id}" type="hidden" />
                    <div class="dialog">
                    <table>
                        <tbody>
                            <tr>
                                <td>ID:</td>
                                <td>
                                    <input name="id" value="${produto.id}" disabled="true" />
                                </td>
                            </tr>
                            <tr>
                                <td>Descrição:</td>
                                <td>
                                    <input name="descricao" value="${produto.descricao}" />
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
