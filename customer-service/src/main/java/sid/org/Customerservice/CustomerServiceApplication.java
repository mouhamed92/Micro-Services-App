package sid.org.Customerservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import sid.org.Customerservice.entities.Customer;
import sid.org.Customerservice.repositories.CustomerRepository;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner start(CustomerRepository customerRepository,
								   RepositoryRestConfiguration repositoryRestConfiguration){

		return args -> {

			repositoryRestConfiguration.exposeIdsFor(Customer.class);
			customerRepository.saveAll(
					List.of(
							Customer.builder().name("Mohamed").email("mohamed@gmail.com").build(),
							Customer.builder().name("Ali").email("Ali@gmail.com").build(),
							Customer.builder().name("Salah").email("Salah@gmail.com").build()
							)
			);

			customerRepository.findAll().forEach(customer->{
				System.out.println(customer);
			});
		};


	}

}
