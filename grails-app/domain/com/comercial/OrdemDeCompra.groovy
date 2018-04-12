package com.comercial

import com.pessoa.Usuario

class OrdemDeCompra {

    Date dataDaCompra
    Usuario comprador

    static hasMany = [itens:Item]
    
    static constraints = {
    }
}
