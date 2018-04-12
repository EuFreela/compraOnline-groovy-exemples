package com.comercial

class Item {

    int quantidade
    Produto produto

    static belongsTo = [ordemdecompra:OrdemDeCompra]

    static constraints = {
    }
}
