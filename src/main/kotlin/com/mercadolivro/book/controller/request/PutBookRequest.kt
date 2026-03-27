package com.mercadolivro.book.controller.request

import com.fasterxml.jackson.annotation.JsonAlias
import com.mercadolivro.book.model.enums.BookStatus
import java.math.BigDecimal

data class PutBookRequest(
    var name: String?,

    var price: BigDecimal?,

    )
