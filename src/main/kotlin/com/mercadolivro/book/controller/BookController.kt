package com.mercadolivro.book.controller

import com.mercadolivro.book.controller.request.PostBookRequest
import com.mercadolivro.customer.extension.toBookModel
import com.mercadolivro.book.model.BookModel
import com.mercadolivro.book.model.enums.BookStatus
import com.mercadolivro.book.service.BookService
import com.mercadolivro.customer.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("book")
class BookController(
    val bookService: BookService, val customerService: CustomerService

) {

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request: PostBookRequest) {
        val customer = customerService.getById(request.customerId)
        bookService.create(request.toBookModel(customer))
    }

    @GetMapping()
    open fun findAll(): List<BookModel> {
        return bookService.findAll()
    }

    @GetMapping("/active")
    fun findActives(): List<BookModel> {
        return bookService.findActives()
    }

    @GetMapping("/status/{status}")
    fun findStatusByParam(@PathVariable status: BookStatus): List<BookModel> {
        return bookService.findBookByStatus(status)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): BookModel {
        return bookService.findById(id)
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Int) {
        return bookService.deleteById(id)
    }

    @PutMapping
    fun update(@RequestBody request: PostBookRequest) {
        val book = bookService.findById(request.bookId)
    }
}