package org.sid.inventoryservice;

import org.sid.inventoryservice.entities.Product;
import org.sid.inventoryservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner start(ProductRepository productRepository,
								   RepositoryRestConfiguration repositoryRestConfiguration){

		return args -> {
			repositoryRestConfiguration.exposeIdsFor(Product.class);
			productRepository.saveAll(
					List.of(
							Product.builder().name("PC").price(1400).quantity(23).build(),
							Product.builder().name("Camer").price(10500).quantity(10).build(),
							Product.builder().name("Ecran").price(350).quantity(9).build()
					)
			);

			 productRepository.findAll().forEach(product -> {
				 System.out.println(product);
			 });
		};


	}

}
