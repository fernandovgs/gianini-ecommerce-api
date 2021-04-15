package br.gianini.ecommerce.gianinicheckoutapi.service;

import br.gianini.ecommerce.gianinicheckoutapi.entity.CheckoutEntity;
import br.gianini.ecommerce.gianinicheckoutapi.resource.checkout.CheckoutRequest;

import java.util.Optional;

public interface CheckoutService {

    Optional<CheckoutEntity> create(CheckoutRequest checkoutRequest);
}
