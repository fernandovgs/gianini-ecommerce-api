package br.gianini.ecommerce.checkout.service;

import br.gianini.ecommerce.checkout.entity.CheckoutEntity;
import br.gianini.ecommerce.checkout.enums.Status;
import br.gianini.ecommerce.checkout.event.CheckoutCreatedEvent;
import br.gianini.ecommerce.checkout.repository.CheckoutRepository;
import br.gianini.ecommerce.checkout.resource.checkout.CheckoutRequest;
import br.gianini.ecommerce.checkout.streaming.CheckoutCreatedSource;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
//@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequiredArgsConstructor // new way to inject dependencies learned
public class CheckoutServiceImpl implements CheckoutService {

    private final CheckoutRepository checkoutRepository;
    private final CheckoutCreatedSource checkoutCreatedSource;

    @Override
    public Optional<CheckoutEntity> create(CheckoutRequest checkoutRequest) {
        final CheckoutEntity checkoutEntity = CheckoutEntity.builder()
                .code(UUID.randomUUID().toString())
                .status(Status.CREATED)
                .build();
        final CheckoutEntity savedEntity = checkoutRepository.save(checkoutEntity);

        final CheckoutCreatedEvent checkoutCreatedEvent = CheckoutCreatedEvent.newBuilder()
                .setCheckoutCode(savedEntity.getCode())
                .setStatus(savedEntity.getStatus().name())
                .build();
        checkoutCreatedSource.output().send(MessageBuilder.withPayload(checkoutCreatedEvent).build());

        return Optional.of(savedEntity);
    }
}
