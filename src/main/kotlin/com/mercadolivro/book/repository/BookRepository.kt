package com.mercadolivro.book.repository

import com.mercadolivro.book.model.BookModel
import com.mercadolivro.book.model.enums.BookStatus
import com.mercadolivro.customer.model.CustomerModel
import org.springframework.data.repository.CrudRepository

interface BookRepository : CrudRepository<BookModel, Int> {

    fun findByStatus(status: BookStatus): List<BookModel>
    fun findByCustomer(customer: CustomerModel): List<BookModel>
}