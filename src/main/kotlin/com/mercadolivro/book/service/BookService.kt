package com.mercadolivro.book.service

import com.mercadolivro.book.model.BookModel
import com.mercadolivro.book.model.enums.BookStatus
import com.mercadolivro.book.repository.BookRepository
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

    fun deleteById(id: Int) {
        if (!bookRepository.existsById(id!!)) {
            throw Exception("Book Not Found")
        }
        bookRepository.deleteById(id)
    }


}