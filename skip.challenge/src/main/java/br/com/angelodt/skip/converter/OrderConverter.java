package br.com.angelodt.skip.converter;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.angelodt.skip.api.dto.OrderDTO;
import br.com.angelodt.skip.interfaces.ConverterService;
import br.com.angelodt.skip.model.Order;
import br.com.angelodt.skip.service.OrderItemService;
import ma.glasnost.orika.MapperFacade;

@Component
public class OrderConverter implements ConverterService<Order, OrderDTO>{

    @Autowired
    private MapperFacade orikaMapperFacade;
    
    @Autowired
    private OrderItemService orderItemService;
    
    @Autowired
    private OrderItemConverter orderItemConverter;

    @Override
    public OrderDTO convertForm(Order entity) {
        OrderDTO dto = orikaMapperFacade.map(entity, OrderDTO.class);
        dto.setOrderItem(orderItemService.findByOrderId(entity.getId()));
        return dto;
    }

    @Override
    public Order convert(OrderDTO dtoObject) {
        Order entity = orikaMapperFacade.map(dtoObject,Order.class);
        entity.setOrderItem(dtoObject.getOrderItem().stream()
                .map(oi -> orderItemConverter.convert(oi))
                .collect(Collectors.toList()));
        return entity;
    }
}
