package br.com.angelodt.skip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.angelodt.skip.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    
    public List<OrderItem> findByOrderId(Long orderId);

}
