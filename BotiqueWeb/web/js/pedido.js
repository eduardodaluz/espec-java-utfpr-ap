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
    itemClone.find("a[id$=delItem]").attr("onclick", "delItem('#item-"+status+"');");
    itemClone.appendTo($('#div-item-list'));
    itemClone.show();
}
function delItem(item) {
    $(item).remove();
}