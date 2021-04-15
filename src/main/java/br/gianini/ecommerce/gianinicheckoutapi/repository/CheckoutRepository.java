package br.gianini.ecommerce.gianinicheckoutapi.repository;

import br.gianini.ecommerce.gianinicheckoutapi.entity.CheckoutEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckoutRepository extends JpaRepository<CheckoutEntity, Long> {


}
