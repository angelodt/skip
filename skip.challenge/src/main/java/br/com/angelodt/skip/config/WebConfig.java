package br.com.angelodt.skip.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.support.DomainClassConverter;
import org.springframework.format.support.FormattingConversionService;

@Configuration
@ComponentScan(basePackages={"br.com.angelodt.skip.converter.*"})
public class WebConfig {
    
    @Bean
    public DomainClassConverter<FormattingConversionService> domainClassConverter(
            FormattingConversionService conversionService) {
        return new DomainClassConverter<FormattingConversionService>(conversionService);
    }

}
