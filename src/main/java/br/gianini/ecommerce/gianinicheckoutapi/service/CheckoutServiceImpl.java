package br.gianini.ecommerce.gianinicheckoutapi.service;

import br.gianini.ecommerce.gianinicheckoutapi.entity.CheckoutEntity;
import br.gianini.ecommerce.gianinicheckoutapi.repository.CheckoutRepository;
import br.gianini.ecommerce.gianinicheckoutapi.resource.checkout.CheckoutRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CheckoutServiceImpl implements CheckoutService {

    private final CheckoutRepository checkoutRepository;


    @Override
    public Optional<CheckoutEntity> create(CheckoutRequest checkoutRequest) {
        return Optional.empty();
    }
}
