package com.mercadolivro.book.repository

import com.mercadolivro.book.model.BookModel
import com.mercadolivro.book.model.enums.BookStatus
import org.springframework.data.repository.CrudRepository

interface BookRepository : CrudRepository<BookModel, Int> {

    fun findByStatus(status: BookStatus): List<BookModel>
}