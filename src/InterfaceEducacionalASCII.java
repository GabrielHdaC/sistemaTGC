import java.io.IOException;
import java.util.Scanner;

/**
 * ============================================================================
 *                    INTERFACE DE USUÁRIO ASCII PROFISSIONAL
 * ============================================================================
 * 
 * Classe responsável por toda interação com o usuário através de interface
 * textual ASCII otimizada para terminais Windows, Linux e macOS.
 * 
 * <h3>Características:</h3>
 * <ul>
 *   <li>🎨 Interface ASCII elegante e responsiva</li>
 *   <li>🛡️ Validação robusta de entrada de dados</li>
 *   <li>💻 Compatibilidade multiplataforma</li>
 *   <li>🎯 Experiência de usuário intuitiva</li>
 *   <li>📱 Design adaptável para diferentes tamanhos de terminal</li>
 * </ul>
 * 
 * <h3>Funcionalidades:</h3>
 * - Exibição de menus hierárquicos
 * - Coleta e validação de dados do usuário
 * - Formatação profissional de saídas
 * - Controle de fluxo interativo
 * - Tratamento de erros de entrada
 * 
 * @author Sistema TGC - Equipe UI/UX
 * @version 2.0 - Interface Profissional
 * @since 2025
 * ============================================================================
 */
public class InterfaceEducacionalASCII {
    private final Scanner scanner;
    
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
        System.out.println("             VERSÃO AVANÇADA - TODAS AS FUNCIONALIDADES");
        System.out.println("================================================================");
        System.out.println();
        System.out.println("    === CONTEÚDO EDUCATIVO ===");
        System.out.println("  [1] Paradoxos Famosos (histórias interessantes)");
        System.out.println("  [2] O que são Conjuntos (conceitos básicos)");
        System.out.println("  [3] Operações com Conjuntos (união, interseção...)");
        System.out.println("  [4] Problemas Práticos (exercícios do dia a dia)");
        System.out.println();
        System.out.println("    === FERRAMENTAS BÁSICAS ===");
        System.out.println("  [5] Calculadora Simples (faça contas com conjuntos)");
        System.out.println("  [6] Números Matemáticos (N, Z, Q, R...)");
        System.out.println("  [7] Teste seus Conhecimentos (quiz rápido)");
        System.out.println();
        System.out.println("    === FUNCIONALIDADES AVANÇADAS ===");
        System.out.println("  [8] Gerenciador de Conjuntos (nomeados + histórico)");
        System.out.println("  [9] Conjuntos Multi-Tipo (números, decimais, texto)");
        System.out.println(" [10] Sistema de Persistência (salvar/carregar arquivos)");
        System.out.println(" [11] Sistema de Exportação (relatórios profissionais)");
        System.out.println();
        System.out.println(" [12] Sair");
        System.out.println();
        System.out.println("================================================================");
        System.out.print(">> Digite o número da sua escolha (1-12): ");
        
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
        } catch (IOException | InterruptedException e) {
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
