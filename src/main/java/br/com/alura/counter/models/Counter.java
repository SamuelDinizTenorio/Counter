package br.com.alura.counter.models;

/**
 * Define o contrato para operações de contagem.
 * Qualquer classe que implemente esta interface deve fornecer uma lógica
 * para iniciar uma contagem.
 */
public interface Counter {

    /**
     * Inicia o processo de contagem.
     * @param finalNumber O número que define o limite ou o início da contagem.
     * @throws InterruptedException se a execução da thread for interrompida.
     */
    public abstract void start(int finalNumber) throws InterruptedException;

}
