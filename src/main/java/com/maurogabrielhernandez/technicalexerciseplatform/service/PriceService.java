package com.maurogabrielhernandez.technicalexerciseplatform.service;

import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.maurogabrielhernandez.technicalexerciseplatform.dto.PriceDTO;
import com.maurogabrielhernandez.technicalexerciseplatform.model.Price;
import com.maurogabrielhernandez.technicalexerciseplatform.repository.PriceRepository;

@Service
public class PriceService {

	private PriceRepository priceRepository;
	private ModelMapper mapper;

	public PriceService(PriceRepository priceRepository, ModelMapper mapper) {
		this.priceRepository = priceRepository;
		this.mapper = mapper;
	}

	/**
	 * 
	 * @param date
	 * @param productId
	 * @param brandId
	 * @return the price for parameters
	 */
	public PriceDTO findPriceFor(LocalDateTime date, Long productId, Long brandId) {
		Price price = this.priceRepository
		        .findFirstByStartDateLessThanEqualAndEndDateGreaterThanEqualAndProductIdAndBrandIdOrderByPriorityDesc(
		                date, date, productId, brandId);
		if (price == null) {
			return null;
		}
		return this.mapper.map(price, PriceDTO.class);
	}

}
