import java.util.*;

/**
 * Interface de Usuário - Sistema Educacional de Conjuntos
 * Versão ASCII compatível com Windows PowerShell
 * Baseado nos Fundamentos Matemáticos da Profª Drª Janaína Poffo Possamai
 */
public class InterfaceEducacionalASCII {
    private Scanner scanner;
    
    public InterfaceEducacionalASCII() {
        this.scanner = new Scanner(System.in);
    }
    
    /**
     * MENU PRINCIPAL - Simples e fácil de entender
     * Mostra todas as opções disponíveis no sistema
     */
    public int exibirMenuPrincipal() {
        limparTela();
        System.out.println("================================================================");
        System.out.println("          ** SISTEMA EDUCACIONAL DE CONJUNTOS **");
        System.out.println("         Aprenda matemática de forma simples!");
        System.out.println("================================================================");
        System.out.println();
        System.out.println("** ESCOLHA O QUE VOCÊ QUER APRENDER:");
        System.out.println();
        System.out.println("  [1] Paradoxos Famosos (histórias interessantes)");
        System.out.println("  [2] O que são Conjuntos (conceitos básicos)");
        System.out.println("  [3] Operações com Conjuntos (união, interseção...)");
        System.out.println("  [4] Problemas Práticos (exercícios do dia a dia)");
        System.out.println("  [5] Calculadora Simples (faça contas com conjuntos)");
        System.out.println("  [6] Números Matemáticos (N, Z, Q, R...)");
        System.out.println("  [7] Teste seus Conhecimentos (quiz rápido)");
        System.out.println("  [8] Sair");
        System.out.println();
        System.out.println("================================================================");
        System.out.print(">> Digite o número da sua escolha: ");
        
        return lerInteiroValidado();
    }
    
    /**
     * Lê e valida entrada de inteiro
     */
    public int lerInteiroValidado() {
        while (true) {
            try {
                String entrada = scanner.nextLine().trim();
                if (entrada.isEmpty()) {
                    System.out.print(">> Entrada inválida! Digite um número inteiro: ");
                    continue;
                }
                int valor = Integer.parseInt(entrada);
                return valor;
            } catch (NumberFormatException e) {
                System.out.print(">> Entrada inválida! Digite um número inteiro: ");
            }
        }
    }
    
    /**
     * Limpa a tela (multiplataforma)
     */
    public void limparTela() {
        // Para Windows
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            // Se falhar, imprime linhas em branco
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
    }
    
    /**
     * Pausa e aguarda Enter
     */
    public void pausar() {
        System.out.print("\nPressione ENTER para continuar...");
        scanner.nextLine();
    }
    
    /**
     * Exibe mensagem de erro
     */
    public void exibirErro(String mensagem) {
        System.out.println("ERRO: " + mensagem);
    }
    
    /**
     * Exibe mensagem de despedida
     */
    public void exibirDespedida() {
        limparTela();
        System.out.println("================================================================");
        System.out.println("        ** Obrigado por usar o Sistema Educacional! **");
        System.out.println("        ** Continue estudando Matemática! **");
        System.out.println("================================================================");
    }
    
    /**
     * Lê uma linha de texto do usuário
     */
    public String lerTexto() {
        return scanner.nextLine();
    }
    
    /**
     * Fecha o scanner
     */
    public void fechar() {
        if (scanner != null) {
            scanner.close();
        }
    }
}
