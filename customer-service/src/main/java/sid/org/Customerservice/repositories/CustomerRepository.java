package sid.org.Customerservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import sid.org.Customerservice.entities.Customer;

@RestResource
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
