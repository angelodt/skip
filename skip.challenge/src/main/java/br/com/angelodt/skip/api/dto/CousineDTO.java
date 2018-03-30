package br.com.angelodt.skip.api.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CousineDTO implements Serializable {
    
    private Long id;
    
    private String name;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
}
