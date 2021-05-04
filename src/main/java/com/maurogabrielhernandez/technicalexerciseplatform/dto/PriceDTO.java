package com.maurogabrielhernandez.technicalexerciseplatform.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.maurogabrielhernandez.technicalexerciseplatform.enumerator.CurrencyEnum;

public class PriceDTO {

	private Long brandId;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private Long productId;
	private BigDecimal price;
	private CurrencyEnum curr;

	public PriceDTO() {
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public CurrencyEnum getCurr() {
		return curr;
	}

	public void setCurr(CurrencyEnum curr) {
		this.curr = curr;
	}

}
