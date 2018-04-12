package com.comercial

class Produto {

    String nome
    String descricao
    double preco

    static constraints = {
        nome nullable:false
        descricao nullable:true
        preco nullable:false
    }
}
