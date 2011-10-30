<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/main.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Pedido</title>
        <script src="js/jquery-1.6.4.js" ></script>
        <script>
            var status = parseInt(0);
            function addItem() {
                status = parseInt(status) + parseInt(1);
                var nome = "item["+status+"]"
                var itemClone = $('#item-clone').clone();
                itemClone.attr("id", "item-"+status);
                itemClone.find("input[id$=exists]").attr("id", nome + ".exists").attr("name", nome + ".exists");
                itemClone.find("input[id$=id]").attr("id", nome + ".id").attr("name", nome + ".id");
                itemClone.find("input[id$=quantidade]").attr("id", nome + ".quantidade").attr("name", nome + ".quantidade");
                itemClone.find("select[id$=produto]").attr("id", nome + ".produto").attr("name", nome + ".produto");
                itemClone.appendTo($('#div-item-list'));
                itemClone.show();
            }
            function delItem(item) {
                $(item).remove();
            }
            $('document').ready(function() {
                var size = $('#item-size').val();
                console.log(size);
                status = parseInt(size);
            });
        </script>
    </head>
    <body>
        <div id="menu" class="nav">
            <span class="menuButton"><a class="home" href="/BotiqueWeb" >Principal</a></span>
            <span class="menuButton"><a class="list" href="pedido" >Listar Pedidos</a></span>
        </div>
        <div id="geral" class="body">
            <h1>Editar Pedido</h1>
            <hr/>
            <div id="formulario">
                <form method="post" action="pedido">
                    <input name="action" value="update" type="hidden" />
                    <input name="id" value="${pedido.id}" type="hidden" />
                    <input id="item-size" name="item-size" value="${pedido.pedidoItens.size()}" type="hidden" />
                    <div class="dialog">
                    <table>
                        <tbody>
                            <tr>
                                <td>ID:</td>
                                <td>
                                    <input name="id" value="${pedido.id}" disabled="true" />
                                </td>
                            </tr>
                            <tr>
                                <td>Numero:</td>
                                <td>
                                    <input name="numero" value="${pedido.numero}" />
                                </td>
                            </tr>
                            <tr>
                                <td>Data Pedido:</td>
                                <td>
                                    <input name="dtPedido" value="${pedido.dtPedido}" />
                                </td>
                            </tr>
                            <tr>
                                <td>Fornecedor:</td>
                                <td>
                                    <select id="fornecedor.id" name="fornecedor.id">
                                        <c:forEach var="forn" items="${fornecedorInstanceList}" >
                                            <c:if test="${forn.id == pedido.fornecedor.id}">
                                                <option value="${forn.id}" selected="selected">${forn}</option>
                                            </c:if>
                                            <c:if test="${forn.id != pedido.fornecedor.id}">
                                                <option value="${forn.id}">${forn}</option>
                                            </c:if>
                                        </c:forEach>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><hr/></td>
                            </tr>
                            <tr>
                                <td>Itens:</td>
                                <td>
                                    <div id="div-item-list">
                                        <c:forEach var="pedItem" items="${pedido.pedidoItens}" varStatus="i" >
                                        <div id="item-${i.count}" >
                                            <input id="item[${i.count}].exists" name="item[${i.count}].exists" type="hidden" value="true" />
                                            <input id="item[${i.count}].id" name="item[${i.count}].id" type="hidden" value="${pedItem.id}" />
                                            <input value="${pedItem.id}" disabled="true"/>
                                            <select id="item[${i.count}].produto" name="item[${i.count}].produto" >
                                                <c:forEach var="prod" items="${produtoInstanceList}" >
                                                    <c:if test="${prod.id == pedItem.produto.id}">
                                                        <option value="${prod.id}" selected="selected">${prod}</option>
                                                    </c:if>
                                                    <c:if test="${prod.id != pedItem.produto.id}">
                                                        <option value="${prod.id}">${prod}</option>
                                                    </c:if>
                                                </c:forEach>
                                            </select>
                                            <input id="item[${i.count}].quantidade" name="item[${i.count}].quantidade" value="${pedItem.quantidade}"/>
                                            <span><a href="javascript:void(0);" onclick="delItem('#item-${i.count}');">Excluir</a></span>
                                            <br/>
                                        </div>
                                        </c:forEach>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><a href="javascript:void(0);" onclick="addItem();">Add. Item</a></td>
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
        <div id="divclone">
            <div id="item-clone" class="item-div" style="display:none">
                <input id="item-clone.exists" name="item-clone.exists" type="hidden" value="true" />
                <input id="item-clone.id" name="item-clone.id" type="hidden" value="${pedItem.id}" />
                <input value="${pedItem.id}" disabled="true"/>
                <select id="item-clone.produto" name="item-clone.produto" >
                    <c:forEach var="prod" items="${produtoInstanceList}" >
                    <option value="${prod.id}">${prod}</option>
                    </c:forEach>
                </select>
                <input id="item-clone.quantidade" name="item-clone.quantidade" value="${pedItem.quantidade}"/>
                <br/>
            </div>
        </div>
    </body>
</html>