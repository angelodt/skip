package br.com.angelodt.skip.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.angelodt.skip.api.dto.StoreDTO;
import br.com.angelodt.skip.interfaces.ConverterService;
import br.com.angelodt.skip.model.Store;
import ma.glasnost.orika.MapperFacade;

@Component
public class StoreConverter implements ConverterService<Store, StoreDTO> {

    @Autowired
    private MapperFacade orikaMapperFacade;

    @Override
    public StoreDTO convertForm(Store entity) {
        StoreDTO dto = orikaMapperFacade.map(entity, StoreDTO.class);
        dto.setCousineId(entity.getCousine().getId());
        return dto;
    }

    @Override
    public Store convert(StoreDTO dtoObject) {
        Store entity = orikaMapperFacade.map(dtoObject,Store.class);
        return entity;
    }
}
