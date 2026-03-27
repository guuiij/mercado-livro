package com.mercadolivro.customer.service

import com.mercadolivro.customer.model.CustomerModel
import com.mercadolivro.book.repository.BookRepository
import com.mercadolivro.book.service.BookService
import com.mercadolivro.customer.model.enums.CustomerStatus
import com.mercadolivro.customer.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(
    val customerRepository: CustomerRepository,
    val bookService: BookService,

    ) {
    fun getAll(name: String?): List<CustomerModel> {
        name?.let {
            return customerRepository.findByNameContaining(it)
        }
        return customerRepository.findAll().toList()
    }

    fun findById(id: Int): CustomerModel {
        return customerRepository.findById(id).orElseThrow()
    }

    fun create(customer: CustomerModel) {
        customerRepository.save(customer)

    }

    fun update(customer: CustomerModel) {
        if (!customerRepository.existsById(customer.id!!)) {
            throw Exception("Customer not found")
        }
        customerRepository.save(customer)
    }

    fun delete(id: Int) {
       val customer = findById(id)
        bookService.deleteByCustomer(customer)

        customer.status = CustomerStatus.INATIVO
        customerRepository.save(customer)
    }

}