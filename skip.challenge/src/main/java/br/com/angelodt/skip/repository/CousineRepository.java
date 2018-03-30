package br.com.angelodt.skip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.angelodt.skip.model.Cousine;

public interface CousineRepository extends JpaRepository<Cousine, Long> {
    
    public List<Cousine> findByName(String searchText);
    
    public List<Cousine> findByNameContains(String searchText);

}
