<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novo Fornecedor</title>
    </head>
    <body>
        <div id="geral">
            <h1>Novo Fornecedor</h1>
            <hr/>
            <div id="menu">
                <a href="/BotiqueWeb" >Principal</a>
                <a href="fornecedor" >Listar Fornecedores</a>
            </div>
            <hr/>
            <div id="formulario">
                <form method="post" action="fornecedor">
                    <input name="action" value="save" type="hidden" />
                    <input name="id" value="${fornecedor.id}" type="hidden" />
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
                </form>
            </div>
        </div>
    </body>
</html>
