package com.mercadolivro.customer.extension

import com.mercadolivro.book.controller.request.PostBookRequest
import com.mercadolivro.book.controller.request.PutBookRequest
import com.mercadolivro.customer.controller.request.PostCustomerRequest
import com.mercadolivro.customer.controller.request.PutCustomerRequest
import com.mercadolivro.book.model.BookModel
import com.mercadolivro.customer.model.CustomerModel
import com.mercadolivro.book.model.enums.BookStatus
import com.mercadolivro.customer.model.enums.CustomerStatus


fun PostCustomerRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(name = this.name, email = this.email, status = CustomerStatus.ATIVO)
}

fun PutCustomerRequest.toCustomerModel(previousValue: CustomerModel): CustomerModel {
    return CustomerModel(id = previousValue.id, name = this.name, email = this.email, status = previousValue.status)
}

fun PostBookRequest.toBookModel(customer: CustomerModel): BookModel {
    return BookModel(
        name = this.name,
        price = this.price,
        status = BookStatus.ATIVO,
        customer = customer
    )
}

fun PutBookRequest.toBookModel(previousValue: BookModel): BookModel {
    return BookModel(
        id = previousValue.id,
        name = this.name ?: previousValue.name,
        price = this.price ?: previousValue.price,
        status = previousValue.status,
        customer = previousValue.customer
    )
}

fun CustomerModel.toResponse(): CustomerResponse {

}