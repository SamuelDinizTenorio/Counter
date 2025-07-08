package br.com.alura.counter.models;

import org.springframework.stereotype.Component;

@Component
public class CountDown implements Counter {

    /**
     * Realiza uma contagem decrescente do número final especificado até 0,
     * com uma pausa de 1 segundo entre cada número.
     *
     * @param finalNumber O número final da contagem. Deve ser um inteiro positivo.
     * @throws InterruptedException Se a thread for interrompida durante a pausa.
     */
    @Override
    public void start(int finalNumber) throws InterruptedException {
        System.out.println("Iniciando a contagem regressiva até 0...");
        for (int i = finalNumber; i >= 0; i--) {
            Thread.sleep(1000);
            System.out.println(i);
        }
        System.out.println("Contagem finalizada com sucesso!");
    }
}
