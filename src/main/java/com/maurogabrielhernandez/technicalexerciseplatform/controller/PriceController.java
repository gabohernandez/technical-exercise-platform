package com.maurogabrielhernandez.technicalexerciseplatform.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maurogabrielhernandez.technicalexerciseplatform.dto.PriceDTO;
import com.maurogabrielhernandez.technicalexerciseplatform.service.PriceService;


@RestController()
@RequestMapping("/price")
public class PriceController {
	
	@Autowired
	private PriceService priceService;
	
	@GetMapping()
	public ResponseEntity<PriceDTO> findPrice(
			@RequestParam() @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date,
			@RequestParam() Long productId,
			@RequestParam() Long brandId) {
		return ResponseEntity.ok(priceService.findPriceFor(date, productId, brandId));
	}

}
