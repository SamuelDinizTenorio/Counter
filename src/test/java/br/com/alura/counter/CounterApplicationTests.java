package br.com.alura.counter;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Classe de teste para a aplicação Counter.
 * Garante que o contexto do Spring Boot é carregado corretamente.
 */
@SpringBootTest
class CounterApplicationTests {

	/**
	 * Testa se o contexto da aplicação Spring é carregado sem erros.
	 * Um teste bem-sucedido aqui indica que a configuração de injeção de dependência
	 * e a inicialização dos beans estão funcionando como esperado.
	 */
	@Test
	void contextLoads() {
	}

}
