package com.mercadolivro.customer.extension

import com.mercadolivro.book.controller.request.PostBookRequest
import com.mercadolivro.customer.controller.request.PostCustomerRequest
import com.mercadolivro.customer.controller.request.PutCustomerRequest
import com.mercadolivro.book.model.BookModel
import com.mercadolivro.customer.model.CustomerModel
import com.mercadolivro.book.model.enums.BookStatus


fun PostCustomerRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(name = this.name, email = this.email)
}

fun PutCustomerRequest.toCustomerModel(id: Int): CustomerModel {
    return CustomerModel(id = id, name = this.name, email = this.email)
}

fun PostBookRequest.toBookModel(customer: CustomerModel): BookModel {
    return BookModel(
        name = this.name,
        price = this.price,
        status = BookStatus.ATIVO,
        customer = customer
    )
}