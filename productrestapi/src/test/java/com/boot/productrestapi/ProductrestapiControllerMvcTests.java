package com.boot.productrestapi;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.boot.productrestapi.entities.Product;
import com.boot.productrestapi.repos.ProductRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@RunWith(SpringRunner.class)
@WebMvcTest  //provides the mvc environment so that we can test without starting the server(running the app)
class ProductrestapiControllerMvcTests {
	
	private static final int product_price = 5000;

	private static final String product_description = "Good Lap";

	private static final String product_name = "Dell";

	private static final int product_id = 3;

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	ProductRepository repository;
	
	private static final String productUrl="/productapi/products/";
	
	private static final String contextPathUrl="/productapi";
	
	private static Product buildProduct(){
		Product product=new Product();
		product.setId(product_id);
		product.setName(product_name);
		product.setDescription(product_description);
		product.setPrice(product_price);
		return product;	
	}
	
	@Test
	void testCreateProduct() throws JsonProcessingException, Exception {
		Product product=buildProduct();
		ObjectWriter objectWriter=new ObjectMapper().writer().withDefaultPrettyPrinter();
		when(repository.save(any())).thenReturn(product);
		mockMvc.perform(post(productUrl).contextPath(contextPathUrl).contentType(MediaType.APPLICATION_JSON)
				.content(objectWriter.writeValueAsString(product)))
				.andExpect(status().isOk()).andExpect(content().json(objectWriter.writeValueAsString(product)));
	}
	
	@Test
	void testUpdateProduct() throws JsonProcessingException, Exception {
		Product product=buildProduct();
		when(repository.save(any())).thenReturn(product);
		ObjectWriter objectWriter=new ObjectMapper().writer().withDefaultPrettyPrinter();
		mockMvc.perform(put(productUrl).contextPath(contextPathUrl).contentType(MediaType.APPLICATION_JSON).content(objectWriter.writeValueAsString(product)))                               
				.andExpect(status().isOk()).andExpect(content().json(objectWriter.writeValueAsString(product)));
	}
	
	@Test
	void testDeleteProduct() throws Exception {
		doNothing().when(repository).deleteById(product_id); //as dlt method wont return anything, use doNothing()
		mockMvc.perform(delete(productUrl+product_id).contextPath(contextPathUrl)).andExpect(status().isOk());
	}
	
	@Test
	void testGetProduct() throws JsonProcessingException, Exception {
		Product product=buildProduct();
		ObjectWriter objectWriter=new ObjectMapper().writer().withDefaultPrettyPrinter();
		when(repository.findById(product_id)).thenReturn(Optional.of(product));
		mockMvc.perform(get(productUrl+product_id).contextPath(contextPathUrl))
			.andExpect(status().isOk()).andExpect(content().json(objectWriter.writeValueAsString(product)));
	}
	
	@Test
	void testGetProducts() throws Exception {
		Product product=buildProduct();
		List<Product> products=Arrays.asList(product);
		when(repository.findAll()).thenReturn(products); //inside getProducts method
		
		ObjectWriter objectWriter=new ObjectMapper().writer().withDefaultPrettyPrinter();
				
		mockMvc.perform(get(productUrl).contextPath(contextPathUrl)).andExpect(status().isOk())  //status().isOk() - this checks if 200 status(success) is returned (ie)if the 'products' list we created is returned 
		.andExpect(content().json(objectWriter.writeValueAsString(products)));     //use only single quotes inside json()
	}

}
