package es.concento.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import es.concento.demo.model.Price;

@Repository
public interface PriceRepo extends JpaRepository<Price, Long>{

	@Query(value = "SELECT * FROM \"prices\" WHERE \"brand_id\" = :brandId AND \"product_id\" = :productId AND \"start_date\" >= :currentDate AND \"end_date\" <= :currentDate ORDER BY \"priority\" DESC LIMIT 1",nativeQuery = true)
	Price getPrice(long brandId, long productId, long currentDate);
}
