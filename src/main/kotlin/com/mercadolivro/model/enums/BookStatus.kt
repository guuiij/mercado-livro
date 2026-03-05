package com.mercadolivro.model.enums

enum class BookStatus(val descricao: String) {

    ATIVO("Ativo para venda"),
    VENDIDO("Já vendido"),
    CANCELADO("Usuário cancelou a venda"),
    DELETADO("Usuário não existe mais no sistema"),
    INATIVO("Fora de estoque"),

}