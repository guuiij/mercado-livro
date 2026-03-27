package com.mercadolivro.book.model

import com.mercadolivro.book.model.enums.BookStatus
import com.mercadolivro.customer.model.CustomerModel
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Table(name = "book")
data class BookModel(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column(nullable = false)
    var name: String,

    @Column(nullable = false, precision = 10, scale = 2)
    var price: BigDecimal,

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    var customer: CustomerModel,

    @Column(name = "created_at", nullable = false, updatable = false)
    var createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "updated_at", nullable = false)
    var updatedAt: LocalDateTime = LocalDateTime.now()

)

{
    @Column
    @Enumerated(EnumType.STRING)
    var status: BookStatus = BookStatus.ATIVO
        set(value) {
            if(field == BookStatus.CANCELADO || field == BookStatus.DELETADO) {
                throw Exception("")
            }
            field = value
        }

    constructor(id: Int? = null,
        name: String,
        price: BigDecimal,
        customer: CustomerModel,
        status: BookStatus,
        createdAt: LocalDateTime = LocalDateTime.now(),
        updatedAt: LocalDateTime = LocalDateTime.now()) : this(id, name, price, customer,createdAt,updatedAt) {
             this.status = status
        }
}