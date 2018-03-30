package br.com.angelodt.skip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.angelodt.skip.api.dto.OrderDTO;
import br.com.angelodt.skip.model.Customer;
import br.com.angelodt.skip.service.OrderService;

@RestController
@RequestMapping("/api/v1/Order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    
    @GetMapping("/{orderId}")
    public OrderDTO getOrder(@PathVariable Long orderId) {
        try {
            return orderService.getOrder(orderId);
        } catch (Exception e) {
            return null;
        }
    }
    
    @GetMapping("/customer")
    public List<OrderDTO> getOrders(@PathVariable Customer customerOrders) {
        return orderService.getOrders(customerOrders);
    }
    
    @PostMapping
    public void addNewOrder(@RequestBody OrderDTO newOrder) {
        orderService.addNewOrder(newOrder);
    }
}
