package com.pessoa

class Usuario {

    String nome
    String email
    String senha
    String endereco
    long cpf

    static constraints = {
        email email:true
    }
}
