package br.com.angelodt.skip.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.angelodt.skip.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
    public Customer findByEmail(String email);

}
