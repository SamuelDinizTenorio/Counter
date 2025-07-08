package br.com.alura.counter.cli;

import java.util.Scanner;

import br.com.alura.counter.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Classe principal da interface de linha de comando (CLI).
 * Responsável por exibir o menu, capturar a entrada do usuário e orquestrar
 * as operações de contagem.
 */
@Component
public class Main {

    private final Scanner scanner;
    private final Counter countUp;
    private final Counter countDown;

    @Autowired
    public Main(Scanner scanner, CountUp countUp, CountDown countDown) {
        this.scanner = scanner;
        this.countUp = countUp;
        this.countDown = countDown;
    }

    /**
     * Inicia o loop principal do programa, exibindo o menu e processando
     * as escolhas do usuário até que a opção de sair seja selecionada.
     * Trata exceções de entrada e interrupções de forma graciosa.
     */
    public void startCounter() {
        boolean running = true;
        while (running) {
            displayMenu();
            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        handleCountUp();
                        break;
                    case 2:
                        handleCountDown();
                        break;
                    case 3:
                        System.out.println("Saindo do programa...");
                        running = false; // Saída elegante do laço
                        break;
                    default:
                        System.out.println("Erro: Opção inválida. Digite um número entre 1 e 3!");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Entrada inválida. Digite um número inteiro para a opção.");
            } catch (InterruptedException e) {
                System.out.println("A contagem foi interrompida.");
                Thread.currentThread().interrupt(); // Restaura o status de interrupção
                running = false; // Sai do programa se a contagem for interrompida
            }
        }
    }

    /**
     * Exibe o menu de opções para o usuário no console.
     */
    private void displayMenu() {
        System.out.println("\nEscolha uma opção:");
        System.out.println("1 - Contagem crescente");
        System.out.println("2 - Contagem decrescente");
        System.out.println("3 - Sair");
        System.out.print("Sua escolha: ");
    }

    /**
     * Gerencia a lógica para a contagem crescente.
     * Solicita o número final ao usuário e invoca o serviço de contagem.
     * @throws InterruptedException se a thread for interrompida durante a contagem.
     */
    private void handleCountUp() throws InterruptedException {
        int finalNumber = readPositiveInteger("Digite o número final da contagem crescente: ");
        countUp.start(finalNumber);
    }

    /**
     * Gerencia a lógica para a contagem decrescente.
     * Solicita o número inicial ao usuário e invoca o serviço de contagem.
     * @throws InterruptedException se a thread for interrompida durante a contagem.
     */
    private void handleCountDown() throws InterruptedException {
        int finalNumber = readPositiveInteger("Digite o número para iniciar a contagem regressiva: ");
        countDown.start(finalNumber);
    }

    /**
     * Lê um inteiro positivo do usuário.
     * Continua pedindo até que um inteiro positivo válido seja inserido.
     */
    private int readPositiveInteger(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int number = Integer.parseInt(scanner.nextLine());

                if (number > 0) {
                    return number;
                }
                System.out.println("Erro: O número deve ser um inteiro maior que zero!");
            } catch (NumberFormatException e) {
                System.out.println("Erro: Entrada inválida. Digite um número inteiro positivo!");
            }
        }
    }
}
