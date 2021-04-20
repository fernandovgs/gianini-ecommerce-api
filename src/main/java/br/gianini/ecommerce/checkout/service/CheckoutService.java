package br.gianini.ecommerce.checkout.service;

import br.gianini.ecommerce.checkout.entity.CheckoutEntity;
import br.gianini.ecommerce.checkout.resource.checkout.CheckoutRequest;

import java.util.Optional;

public interface CheckoutService {

    Optional<CheckoutEntity> create(CheckoutRequest checkoutRequest);
}
