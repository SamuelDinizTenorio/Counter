package br.com.alura.counter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.counter.cli.Main;

/**
 * Classe principal que inicializa a aplicação Spring Boot.
 * Implementa {@link CommandLineRunner} para executar a lógica do contador
 * assim que a aplicação for iniciada.
 */
@SpringBootApplication
public class CounterApplication implements CommandLineRunner {

	@Autowired
	private Main main;

	public static void main(String[] args) {
		SpringApplication.run(CounterApplication.class, args);
	}

	/**
	 * Este método é executado automaticamente pelo Spring Boot após a inicialização
	 * do contexto da aplicação. Ele serve como o ponto de entrada para a lógica
	 * da aplicação de linha de comando.
	 * @param args Argumentos de linha de comando passados para a aplicação.
	 */
	@Override
	public void run(String... args) {
		main.startCounter();
	}
}
