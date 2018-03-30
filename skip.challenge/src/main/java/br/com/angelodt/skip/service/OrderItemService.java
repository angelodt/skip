package br.com.angelodt.skip.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.angelodt.skip.api.dto.OrderItemDTO;
import br.com.angelodt.skip.converter.OrderItemConverter;
import br.com.angelodt.skip.repository.OrderItemRepository;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemConverter converter;
    
    @Autowired
    private OrderItemRepository repository;
    
    public List<OrderItemDTO> findByOrderId(Long orderId) {
        return repository.findByOrderId(orderId).stream()
                .map(oi -> converter.convertForm(oi))
                .collect(Collectors.toList());
    }
}
