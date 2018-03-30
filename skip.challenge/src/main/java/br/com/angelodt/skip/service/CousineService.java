package br.com.angelodt.skip.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.angelodt.skip.api.dto.CousineDTO;
import br.com.angelodt.skip.api.dto.StoreDTO;
import br.com.angelodt.skip.converter.CousineConverter;
import br.com.angelodt.skip.repository.CousineRepository;

@Service
public class CousineService {

    @Autowired
    private CousineConverter converter;
    
    @Autowired
    private CousineRepository repository;
    
    @Autowired
    private StoreService storeService;
    
    
    public List<CousineDTO> getAll() {
        return repository.findAll().stream()
                .map(c -> converter.convertForm(c))
                .collect(Collectors.toList());
    }

    public List<CousineDTO> search(String searchText) {
        return repository.findByNameContains(searchText).stream()
                .map(c -> converter.convertForm(c))
                .collect(Collectors.toList());
    }

    public List<StoreDTO> getStores(Long cousineId) {
        return storeService.findByCousineId(cousineId);
    }

}
