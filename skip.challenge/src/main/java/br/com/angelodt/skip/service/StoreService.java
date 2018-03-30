package br.com.angelodt.skip.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.angelodt.skip.api.dto.ProductDTO;
import br.com.angelodt.skip.api.dto.StoreDTO;
import br.com.angelodt.skip.converter.StoreConverter;
import br.com.angelodt.skip.repository.StoreRepository;

@Service
public class StoreService {

    @Autowired
    private StoreConverter converter;
    
    @Autowired
    private StoreRepository repository;
    
    @Autowired
    private ProductService productService;
    
    public List<StoreDTO> getAll() {
        return repository.findAll().stream()
                .map(s -> converter.convertForm(s))
                .collect(Collectors.toList());                
    }

    public List<StoreDTO> search(String searchText) {
        return repository.searchByName(searchText).stream()
                .map(s -> converter.convertForm(s))
                .collect(Collectors.toList()); 
    }

    public StoreDTO getStore(Long storeId) {
        return converter.convertForm(repository.getOne(storeId));
    }

    public List<ProductDTO> getProducts(Long storeId) {
        return productService.findByStore(storeId);
    }
    
    public List<StoreDTO> findByCousineId(Long cousineId) {
        return repository.findByCousineId(cousineId).stream()
                .map(s -> converter.convertForm(s))
                .collect(Collectors.toList()); 
    }

}
