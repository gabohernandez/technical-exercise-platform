package com.maurogabrielhernandez.technicalexerciseplatform;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.util.UriComponentsBuilder;

import com.maurogabrielhernandez.technicalexerciseplatform.dto.PriceDTO;

@SpringBootTest(webEnvironment=WebEnvironment.DEFINED_PORT)
@TestPropertySource(properties = "server.port=8080")
public class PriceTests {
	
	final private static String BASE_URL = "http://localhost:";
	final private static String PORT = "8080";
	final private static String ENDPOINT = "/api/price";
	final private static String FINAL_URL = BASE_URL.concat(PORT).concat(ENDPOINT);

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void getPriceFor20200614At10_returnOkWithPrice3550() {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(FINAL_URL)
				.queryParam("date", "2020-06-14T10:00")
				.queryParam("productId", 35455)
				.queryParam("brandId", 1);

		ResponseEntity<PriceDTO> response = this.restTemplate.getForEntity(builder.toUriString(), PriceDTO.class);
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(BigDecimal.valueOf(35.50).setScale(2), response.getBody().getPrice());
	}
	
	@Test
	public void getPriceFor20200614At16_returnOkWithPrice2545() {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(FINAL_URL)
				.queryParam("date", "2020-06-14T16:00")
				.queryParam("productId", 35455)
				.queryParam("brandId", 1);

		ResponseEntity<PriceDTO> response = this.restTemplate.getForEntity(builder.toUriString(), PriceDTO.class);
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(BigDecimal.valueOf(25.45).setScale(2), response.getBody().getPrice());
	}
	
	@Test
	public void getPriceFor20200614At21_returnOkWithPrice3550() {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(FINAL_URL)
				.queryParam("date", "2020-06-14T21:00")
				.queryParam("productId", 35455)
				.queryParam("brandId", 1);

		ResponseEntity<PriceDTO> response = this.restTemplate.getForEntity(builder.toUriString(), PriceDTO.class);
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(BigDecimal.valueOf(35.50).setScale(2), response.getBody().getPrice());
	}
	
	@Test
	public void getPriceFor20200615At10_returnOkWithPrice3050() {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(FINAL_URL)
				.queryParam("date", "2020-06-15T10:00")
				.queryParam("productId", 35455)
				.queryParam("brandId", 1);

		ResponseEntity<PriceDTO> response = this.restTemplate.getForEntity(builder.toUriString(), PriceDTO.class);
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(BigDecimal.valueOf(30.50).setScale(2), response.getBody().getPrice());
	}
	
	@Test
	public void getPriceFor20200616At21_returnOkWithPrice3895() {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(FINAL_URL)
				.queryParam("date", "2020-06-16T21:00")
				.queryParam("productId", 35455)
				.queryParam("brandId", 1);

		ResponseEntity<PriceDTO> response = this.restTemplate.getForEntity(builder.toUriString(), PriceDTO.class);
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(BigDecimal.valueOf(38.95).setScale(2), response.getBody().getPrice());
	}
	
	@Test
	public void getPriceFor20180614At16_returnOkWithOutPrice() {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(FINAL_URL)
				.queryParam("date", "2018-06-14T16:00")
				.queryParam("productId", 35455)
				.queryParam("brandId", 1);

		ResponseEntity<PriceDTO> response = this.restTemplate.getForEntity(builder.toUriString(), PriceDTO.class);
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNull(response.getBody());
	}

}
