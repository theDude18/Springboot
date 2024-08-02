package com.boot.productrestapi;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.boot.productrestapi.entities.Product;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductrestapiApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testRead() {
		RestTemplate rT=new RestTemplate();
		Product product=rT.getForObject("http://localhost:8181/productapi/products/1",Product.class);
		assertNotNull(product);
	}
}
