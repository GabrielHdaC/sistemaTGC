import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> conjuntoA = new HashSet<>();
        Set<Integer> conjuntoB = new HashSet<>();
        int opcao;

        System.out.println("\n=== SISTEMA DE CONJUNTOS ===\n");

        System.out.println("=== MENU PRINCIPAL ===");
        System.out.println("[1] Começar sistema");
        System.out.println("[2] Sair");
        System.out.print("Escolha uma opção: ");
        opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                System.out.println("\n>>> SISTEMA INICIADO <<<\n");

                conjuntoA.clear();
                conjuntoB.clear();

                // Entrada de valores para conjunto A
                System.out.println(">>> Inserindo valores do Conjunto A <<<");
                while (true) {
                    System.out.print("Defina valor do conjunto A: ");
                    int valorA = scanner.nextInt();
                    conjuntoA.add(valorA);

                    System.out.print("Deseja adicionar mais valores para [A]? [S] para sim [N] para não: ");
                    String resposta = scanner.next();
                    if (!resposta.equalsIgnoreCase("S")) {
                        break;
                    }
                }

                System.out.println();

                // Entrada de valores para conjunto B
                System.out.println(">>> Inserindo valores do Conjunto B <<<");
                while (true) {
                    System.out.print("Defina valor do conjunto B: ");
                    int valorB = scanner.nextInt();
                    conjuntoB.add(valorB);

                    System.out.print("Deseja adicionar mais valores para [B]? [S] para sim [N] para não: ");
                    String resposta = scanner.next();
                    if (!resposta.equalsIgnoreCase("S")) {
                        break;
                    }
                }

                System.out.println();

                // Exibir conjuntos ordenados
                List<Integer> listaA = new ArrayList<>(conjuntoA);
                List<Integer> listaB = new ArrayList<>(conjuntoB);
                Collections.sort(listaA);
                Collections.sort(listaB);

                System.out.println("Conjunto A: " + listaA);
                System.out.println("Conjunto B: " + listaB);
                System.out.println();

                // Menu de operações
                int opcaoOperacao;
                System.out.println("=== OPERAÇÕES DE CONJUNTOS ===");
                System.out.println("[1] União");
                System.out.println("[2] Interseção");
                System.out.println("[3] Diferença");
                System.out.print("Escolha uma operação: ");
                opcaoOperacao = scanner.nextInt();

                System.out.println();

                switch (opcaoOperacao) {
                    case 1:
                        Set<Integer> uniao = new HashSet<>(conjuntoA);
                        uniao.addAll(conjuntoB);
                        List<Integer> listaUniao = new ArrayList<>(uniao);
                        Collections.sort(listaUniao);
                        System.out.println(">>> Resultado da União <<<");
                        System.out.println(listaUniao);
                        System.out.println("-------------------------\n");
                        break;
                    case 2:
                        Set<Integer> intersecao = new HashSet<>(conjuntoA);
                        intersecao.retainAll(conjuntoB);
                        List<Integer> listaInter = new ArrayList<>(intersecao);
                        Collections.sort(listaInter);
                        System.out.println(">>> Resultado da Interseção <<<");
                        System.out.println(listaInter);
                        System.out.println("-------------------------\n");
                        break;
                    case 3:
                        Set<Integer> diferenca = new HashSet<>(conjuntoA);
                        diferenca.removeAll(conjuntoB);
                        List<Integer> listaDif = new ArrayList<>(diferenca);
                        Collections.sort(listaDif);
                        System.out.println(">>> Resultado da Diferença (A - B) <<<");
                        System.out.println(listaDif);
                        System.out.println("-------------------------\n");
                        break;
                    default:
                        System.out.println("Opção inválida.\n");
                        break;
                }
                break;

            case 2:
                System.out.println("Saindo do sistema...");
                break;

            default:
                System.out.println("Opção inválida.");
                break;
        }

        scanner.close();
    }
}
