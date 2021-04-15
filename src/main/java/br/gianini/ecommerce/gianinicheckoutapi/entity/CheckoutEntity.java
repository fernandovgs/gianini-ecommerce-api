package br.gianini.ecommerce.gianinicheckoutapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CheckoutEntity {

    @Id
    private Long id;

    @Column
    private String code;
}
