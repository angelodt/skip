package br.com.angelodt.skip.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.angelodt.skip.api.dto.CousineDTO;
import br.com.angelodt.skip.interfaces.ConverterService;
import br.com.angelodt.skip.model.Cousine;
import ma.glasnost.orika.MapperFacade;

@Component
public class CousineConverter implements ConverterService<Cousine, CousineDTO> {

    @Autowired
    private MapperFacade orikaMapperFacade;
    
    @Override
    public CousineDTO convertForm(Cousine entity) {
        CousineDTO dto = orikaMapperFacade.map(entity, CousineDTO.class);
        return dto;
    }

    @Override
    public Cousine convert(CousineDTO dtoObject) {
        Cousine entity = orikaMapperFacade.map(dtoObject,Cousine.class);
        return entity;
    }

}
