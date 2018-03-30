package br.com.angelodt.skip.interfaces;

public interface ConverterService<ENTITY, DTO> {
    public abstract DTO convertForm(ENTITY entity);
    public abstract ENTITY convert(DTO dtoObject);
}
