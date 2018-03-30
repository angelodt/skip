package br.com.angelodt.skip.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.angelodt.skip.api.dto.ProductDTO;
import br.com.angelodt.skip.interfaces.ConverterService;
import br.com.angelodt.skip.model.Product;
import ma.glasnost.orika.MapperFacade;

@Component
public class ProductConverter implements ConverterService<Product, ProductDTO> {

    @Autowired
    private MapperFacade orikaMapperFacade;
    
    @Override
    public ProductDTO convertForm(Product entity) {
        ProductDTO dto = orikaMapperFacade.map(entity, ProductDTO.class);
        dto.setStoreId(entity.getStore().getId());
        return dto;
    }

    @Override
    public Product convert(ProductDTO dtoObject) {
        Product entity = orikaMapperFacade.map(dtoObject,Product.class);
        return entity;
    }
}
