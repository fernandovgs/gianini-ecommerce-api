package br.gianini.ecommerce.checkout.listener;

import br.gianini.ecommerce.checkout.entity.CheckoutEntity;
import br.gianini.ecommerce.checkout.enums.Status;
import br.gianini.ecommerce.checkout.repository.CheckoutRepository;
import br.gianini.ecommerce.checkout.streaming.PaymentPaidSink;
import br.gianini.ecommerce.payment.event.PaymentCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentPaidListener {

    private final CheckoutRepository checkoutRepository;

    @StreamListener(PaymentPaidSink.INPUT)
    public void handler(PaymentCreatedEvent event) {
        final CheckoutEntity checkoutEntity = checkoutRepository.findByCode(event.getCheckoutCode().toString()).orElseThrow();
        checkoutEntity.setStatus(Status.APPROVED);
        checkoutRepository.save(checkoutEntity);
    }
}
