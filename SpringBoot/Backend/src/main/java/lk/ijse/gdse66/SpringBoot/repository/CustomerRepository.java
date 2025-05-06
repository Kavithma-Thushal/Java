package lk.ijse.gdse66.SpringBoot.repository;

import lk.ijse.gdse66.SpringBoot.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}