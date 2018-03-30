package br.com.angelodt.skip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.angelodt.skip.model.Customer;
import br.com.angelodt.skip.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

    public List<Order> findByCustomerId(Long customerId);
    
    public List<Order> findByCustomer(Customer customer);
}
