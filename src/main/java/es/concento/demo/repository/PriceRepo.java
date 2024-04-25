package es.concento.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import es.concento.demo.model.Price;

@Repository
public interface PriceRepo extends JpaRepository<Price, Long>{

	@Query(value = "SELECT price.* FROM price WHERE price.BRAND_ID = :brandId AND price.PRODUCT_ID = :productId AND price.START_DATE >= :currentDate AND price.END_DATE <= :currentDate ORDER BY price.PRIORIRY DESC LIMIT 1",nativeQuery = true)
	Price getPrice(long brinadId, long productId, long currentDate);
}
