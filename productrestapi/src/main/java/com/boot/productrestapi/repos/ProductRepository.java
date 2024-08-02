package com.boot.productrestapi.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.boot.productrestapi.entities.*;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Query("select p from Product p where p.name=?1")  //In @Query, instead of table name, *(star) and row names, u shld u give Class name(Product) and obj name(p) and Class variable name(name). This query is called JPQL(JPA query language).                 
	List<Product> getByName(String name);    //Return type is List, bcoz name is not Primary key and many same names can be present in the table.
	
	List<Product> getByPrice(int price); //without @Query also, these methods works bcoz JPA has DSL(Domain Specific language) and it checks the method name with the variable names of Product class and it will automatically creates the query with respect to that variable name like in getByName above. 
}
