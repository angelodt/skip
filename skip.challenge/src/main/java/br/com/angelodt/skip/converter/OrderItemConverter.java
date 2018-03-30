package br.com.angelodt.skip.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.angelodt.skip.api.dto.OrderItemDTO;
import br.com.angelodt.skip.interfaces.ConverterService;
import br.com.angelodt.skip.model.OrderItem;
import ma.glasnost.orika.MapperFacade;

@Component
public class OrderItemConverter implements ConverterService<OrderItem, OrderItemDTO>{

    @Autowired
    private MapperFacade orikaMapperFacade;
    
    @Autowired
    private ProductConverter productConverter;

    @Override
    public OrderItemDTO convertForm(OrderItem entity) {
        OrderItemDTO dto = orikaMapperFacade.map(entity, OrderItemDTO.class);
        dto.setProduct(productConverter.convertForm(entity.getProduct()));
        return dto;
    }

    @Override
    public OrderItem convert(OrderItemDTO dtoObject) {
        OrderItem entity = orikaMapperFacade.map(dtoObject,OrderItem.class);
        entity.setProduct(productConverter.convert(dtoObject.getProduct()));
        return entity;
    }

}
