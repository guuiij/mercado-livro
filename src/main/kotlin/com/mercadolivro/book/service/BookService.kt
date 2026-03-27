package com.mercadolivro.book.service

import com.mercadolivro.book.model.BookModel
import com.mercadolivro.book.model.enums.BookStatus
import com.mercadolivro.book.repository.BookRepository
import com.mercadolivro.customer.model.CustomerModel
import org.springframework.stereotype.Service

@Service
class BookService(
    val bookRepository: BookRepository
) {
    fun create(book: BookModel) {
        bookRepository.save(book)
    }

    fun findAll(): List<BookModel> {
        return bookRepository.findAll().toList()
    }

    fun findActives(): List<BookModel> {
        return bookRepository.findByStatus(BookStatus.ATIVO)
    }

    fun findBookByStatus(status: BookStatus): List<BookModel> {
        return bookRepository.findByStatus(status)
    }

    fun findById(id: Int): BookModel {
        return bookRepository.findById(id).orElseThrow()
    }

    fun delete(id: Int) {
        val book = findById(id)

        book.status = BookStatus.CANCELADO

        update(book)
    }

    fun update(book: BookModel) {
        if (!bookRepository.existsById(book.id!!)) {
            throw Exception("Book Not Found")
        }
        bookRepository.save(book)
    }

    fun deleteByCustomer(customer: CustomerModel) {
        val books = bookRepository.findByCustomer(customer)
        for (book in books) {
            book.status = BookStatus.DELETADO
        }
        bookRepository.saveAll(books)
    }


}