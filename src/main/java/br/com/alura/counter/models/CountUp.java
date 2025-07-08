package br.com.alura.counter.models;

import org.springframework.stereotype.Component;

@Component
public class CountUp implements Counter {

    /**
     * Realiza uma contagem crescente de 1 até o número final especificado,
     * com uma pausa de 1 segundo entre cada número.
     *
     * @param finalNumber O número final da contagem. Deve ser um inteiro positivo.
     * @throws InterruptedException     Se a thread for interrompida durante a
     *                                  pausa.
     */
    @Override
    public void start(int finalNumber) throws InterruptedException {
        System.out.println("Iniciando a contagem de 0 até " + finalNumber + "...");
        for (int i = 0; i <= finalNumber; i++) {
            Thread.sleep(1000);
            System.out.println(i);
        }
        System.out.println("Contagem finalizada com sucesso!");
    }
}
