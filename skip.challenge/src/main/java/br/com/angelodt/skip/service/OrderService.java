package br.com.angelodt.skip.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.angelodt.skip.api.dto.OrderDTO;
import br.com.angelodt.skip.converter.OrderConverter;
import br.com.angelodt.skip.model.Customer;
import br.com.angelodt.skip.model.Order;
import br.com.angelodt.skip.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderConverter converter;
    
    @Autowired
    private OrderRepository repository;
    
    public OrderDTO getOrder(Long orderId) {
        return converter.convertForm(repository.getOne(orderId));
    }

    public List<OrderDTO> getOrders(Customer customerOrders) {
        return repository.findByCustomerId(customerOrders.getId()).stream()
                .map(o -> converter.convertForm(o))
                .collect(Collectors.toList());
    }

    public void addNewOrder(OrderDTO newOrder) {
        Order order = converter.convert(newOrder);
        repository.save(order);
    }
}
