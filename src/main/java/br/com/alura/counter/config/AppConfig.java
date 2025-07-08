package br.com.alura.counter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

/**
 * Classe de configuração para os beans da aplicação.
 * Centraliza a criação de objetos que serão gerenciados pelo contêiner do Spring.
 */
@Configuration 
public class AppConfig {

    /**
     * Cria e disponibiliza um bean do tipo {@link Scanner} para toda a aplicação.
     * Este bean será usado para ler a entrada do usuário a partir do console.
     * @return Uma instância singleton de {@link Scanner}.
     */
    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }
}