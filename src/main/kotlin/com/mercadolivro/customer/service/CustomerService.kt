package com.mercadolivro.customer.service

import com.mercadolivro.customer.model.CustomerModel
import com.mercadolivro.book.repository.BookRepository
import com.mercadolivro.customer.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(
    val customerRepository: CustomerRepository, val bookRepository: BookRepository
) {
    fun getAll(name: String?): List<CustomerModel> {
        name?.let {
            return customerRepository.findByNameContaining(it)
        }
        return customerRepository.findAll().toList()
    }

    fun getById(id: Int): CustomerModel {
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
        if (!customerRepository.existsById(id!!)) {
            throw Exception("Customer not found")
        }
        customerRepository.deleteById(id)
    }

}