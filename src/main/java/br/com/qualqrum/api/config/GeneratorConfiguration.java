package br.com.qualqrum.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.qualqrum.data.CPF;

@Configuration
public class GeneratorConfiguration {

    @Bean
    public CPF cpf() {
        return new CPF();
    }
}
