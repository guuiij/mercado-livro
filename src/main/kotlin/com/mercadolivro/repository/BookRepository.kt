package com.mercadolivro.repository

import com.mercadolivro.model.BookModel
import com.mercadolivro.model.enums.BookStatus
import org.springframework.data.repository.CrudRepository

interface BookRepository : CrudRepository<BookModel, Int> {

    fun findByStatus(status: BookStatus): List<BookModel>
}
