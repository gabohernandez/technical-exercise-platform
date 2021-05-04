package com.maurogabrielhernandez.technicalexerciseplatform.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maurogabrielhernandez.technicalexerciseplatform.model.Price;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
	
	
	Price findFirstByStartDateLessThanEqualAndEndDateGreaterThanEqualAndProductIdAndBrandIdOrderByPriorityDesc(LocalDateTime date,LocalDateTime date2, Long productId, Long brandId);

}
