package br.gianini.ecommerce.gianinicheckoutapi.service;

import br.gianini.ecommerce.gianinicheckoutapi.entity.CheckoutEntity;
import br.gianini.ecommerce.gianinicheckoutapi.repository.CheckoutRepository;
import br.gianini.ecommerce.gianinicheckoutapi.resource.checkout.CheckoutRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
//@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequiredArgsConstructor // new way to inject dependencies learned
public class CheckoutServiceImpl implements CheckoutService {

    private final CheckoutRepository checkoutRepository;

    @Override
    public Optional<CheckoutEntity> create(CheckoutRequest checkoutRequest) {
        final CheckoutEntity checkoutEntity = CheckoutEntity.builder()
                .code(UUID.randomUUID().toString())
                .build();
        return Optional.of(checkoutRepository.save(checkoutEntity));
    }
}
