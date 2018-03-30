package br.com.angelodt.skip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.angelodt.skip.api.dto.CousineDTO;
import br.com.angelodt.skip.api.dto.StoreDTO;
import br.com.angelodt.skip.service.CousineService;

@RestController
@RequestMapping("/api/v1/Cousine")
public class CousineController {
    
    @Autowired
    private CousineService cousineService;
    
    @GetMapping
    public List<CousineDTO> getAll() {
        return cousineService.getAll();
    }
    
    @GetMapping("/search/{searchText}")
    public List<CousineDTO> search(@PathVariable String searchText) {
        return cousineService.search(searchText);
    }
    
    @GetMapping("/{cousineId}/stores")
    public List<StoreDTO> getStores(@PathVariable Long cousineId) {
        return cousineService.getStores(cousineId);
    }

}
