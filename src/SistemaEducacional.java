import java.util.*;

/**
 * ============================================================================
 *                      CONTROLADOR PRINCIPAL DO SISTEMA
 * ============================================================================
 * 
 * Classe central responsável por coordenar todas as operações do sistema
 * educacional de conjuntos. Atua como o núcleo de controle que integra
 * todos os módulos especializados.
 * 
 * <h3>Responsabilidades:</h3>
 * <ul>
 *   <li>🎯 Controle de fluxo da aplicação</li>
 *   <li>🎨 Apresentação do menu principal</li>
 *   <li>🔗 Integração entre módulos funcionais</li>
 *   <li>⚡ Delegação de tarefas especializadas</li>
 *   <li>🛡️ Tratamento de erros e exceções</li>
 * </ul>
 * 
 * <h3>Arquitetura Modular:</h3>
 * <pre>
 * SistemaEducacional (core)
 * ├── InterfaceEducacionalASCII (ui)
 * ├── GerenciadorConjuntos (modules)
 * ├── ConjuntosMultiTipo (modules)
 * ├── SistemaPersistencia (modules)
 * ├── SistemaExportacao (modules)
 * ├── TeoriaConjuntos (utils)
 * ├── OperacoesAvancadas (utils)
 * ├── ProblemasConjuntos (utils)
 * └── FundamentosTeoricos (utils)
 * </pre>
 * 
 * @author Sistema TGC
 * @version 2.0 - Arquitetura Profissional
 * @since 2025
 * ============================================================================
 */
public class SistemaEducacional {
    // Esta variável guarda nossa "interface" - é quem conversa com o usuário
    private final InterfaceEducacionalASCII ui;
    
    /**
     * CONSTRUTOR - Roda quando criamos um novo SistemaEducacional
     * Cria a interface que vai ser usada para conversar com o usuário
     */
    public SistemaEducacional() {
        this.ui = new InterfaceEducacionalASCII();
    }
    
    /**
     * FUNÇÃO PRINCIPAL - Esta função roda o programa inteiro!
     * 
     * O QUE FAZ:
     * 1. Fica em loop infinito mostrando o menu
     * 2. Pega a opção que o usuário escolheu
     * 3. Chama a função certa para essa opção
     * 4. Volta para o menu (ou sai se escolheu sair)
     * 
     * É como um "diretor de trânsito" - decide para onde vai cada escolha!
     */
    public void executar() {
        boolean continuar = true;  // Flag para controlar o loop
        
        // Loop principal - roda até o usuário escolher sair
        while (continuar) {
            int opcao = ui.exibirMenuPrincipal();  // Mostra menu e pega escolha
            
            // Switch - como um "desvio de trânsito" para cada opção
            switch (opcao) {
                case 1: // Paradoxos e Fundamentos
                    executarParadoxos();
                    break;
                    
                case 2: // Teoria dos Conjuntos
                    executarTeoria();
                    break;
                    
                case 3: // Operações entre Conjuntos
                    executarOperacoes();
                    break;
                    
                case 4: // Problemas Práticos
                    executarProblemas();
                    break;
                    
                case 5: // Calculadora Interativa
                    executarCalculadora();
                    break;
                    
                case 6: // Conjuntos Numéricos
                    executarConjuntosNumericos();
                    break;
                    
                case 7: // Testes
                    executarTestes();
                    break;
                    
                case 8: // Gerenciador de Conjuntos
                    executarGerenciadorConjuntos();
                    break;
                    
                case 9: // Conjuntos Multi-Tipo
                    executarConjuntosMultiTipo();
                    break;
                    
                case 10: // Sistema de Persistência
                    executarSistemaPersistencia();
                    break;
                    
                case 11: // Sistema de Exportação
                    executarSistemaExportacao();
                    break;
                    
                case 12: // Sair
                    continuar = false;  // Para o loop
                    ui.exibirDespedida();
                    break;
                    
                default: // Se digitou número inválido
                    ui.exibirErro("Opção inválida! Escolha entre 1 e 12.");
                    ui.pausar();
                    break;
            }
        }
        
        ui.fechar();  // Fecha o programa limpinho
    }
    
    /**
     * Executa módulo de paradoxos
     */
    private void executarParadoxos() {
        System.out.println("\n================================================================");
        System.out.println("          ** PARADOXOS E FUNDAMENTOS TEÓRICOS **");
        System.out.println("================================================================");
        System.out.println("[1] Paradoxo do Barbeiro de Sevilha");
        System.out.println("[2] Hotel de Hilbert (Infinitos)");
        System.out.println("[3] Paradoxo de Galileu (Naturais vs Pares)");
        System.out.println("[4] Problemas da Linguagem");
        System.out.print(">> Escolha uma opção: ");
        
        int opcao = ui.lerInteiroValidado();
        
        switch (opcao) {
            case 1:
                FundamentosTeoricos.paradoxoBarbeiro();
                break;
            case 2:
                FundamentosTeoricos.hotelHilbert();
                break;
            case 3:
                FundamentosTeoricos.paradoxoGalileu();
                break;
            case 4:
                FundamentosTeoricos.problemasLinguagem();
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
        ui.pausar();
    }
    
    /**
     * Executa módulo de teoria
     */
    private void executarTeoria() {
        System.out.println("\n================================================================");
        System.out.println("          ** TEORIA DOS CONJUNTOS - CONCEITOS **");
        System.out.println("================================================================");
        System.out.println("Demonstração dos conceitos básicos de teoria dos conjuntos...");
        System.out.println();
        
        // Chamar os métodos da classe TeoriaConjuntos
        TeoriaConjuntos.definicoesNotacoes();
        ui.pausar();
        
        TeoriaConjuntos.tiposConjuntos();
        ui.pausar();
        
        TeoriaConjuntos.igualdadeConjuntos();
        ui.pausar();
    }
    
    /**
     * Executa módulo de operações
     */
    private void executarOperacoes() {
        System.out.println("\n================================================================");
        System.out.println("          ** OPERAÇÕES ENTRE CONJUNTOS **");
        System.out.println("================================================================");
        System.out.println("Demonstração das operações básicas com conjuntos...");
        System.out.println();
        
        // Chamar os métodos da classe OperacoesAvancadas
        OperacoesAvancadas.uniaoAvancada();
        ui.pausar();
        
        OperacoesAvancadas.intersecaoAvancada();
        ui.pausar();
        
        OperacoesAvancadas.diferencaAvancada();
        ui.pausar();
        
        OperacoesAvancadas.complementoAvancado();
        ui.pausar();
        
        OperacoesAvancadas.subconjuntosInclusao();
        ui.pausar();
        
        OperacoesAvancadas.diagramasVenn();
        ui.pausar();
    }
    
    /**
     * Executa módulo de problemas
     */
    private void executarProblemas() {
        System.out.println("\n================================================================");
        System.out.println("          ** PROBLEMAS PRÁTICOS E EXERCÍCIOS **");
        System.out.println("================================================================");
        System.out.println("[1] Problema dos Clubes Recreativos");
        System.out.println("[2] Demonstrar Conjuntos Infinitos");
        System.out.println("[3] Exemplificar Tipos de Conjuntos");
        System.out.println("[4] Validar Notação Matemática");
        System.out.print(">> Escolha uma opção: ");
        
        int opcao = ui.lerInteiroValidado();
        
        switch (opcao) {
            case 1:
                System.out.println("\n** PROBLEMA DOS CLUBES RECREATIVOS **");
                ProblemasConjuntos.resolverProblemaClubs();
                break;
            case 2:
                System.out.println("\n** CONJUNTOS INFINITOS **");
                ProblemasConjuntos.demonstrarConjuntosInfinitos();
                break;
            case 3:
                System.out.println("\n** TIPOS DE CONJUNTOS **");
                ProblemasConjuntos.exemplificarTiposConjuntos();
                break;
            case 4:
                System.out.println("\n** NOTAÇÃO MATEMÁTICA **");
                ProblemasConjuntos.validarNotacaoMatematica();
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
        ui.pausar();
    }
    
    /**
     * CALCULADORA INTERATIVA DE CONJUNTOS - SIMPLES E FÁCIL!
     * Permite fazer operações básicas entre dois conjuntos
     */
    private void executarCalculadora() {
        System.out.println("\n================================================================");
        System.out.println("          ** CALCULADORA DE CONJUNTOS **");
        System.out.println("================================================================");
        
        // Criar dois conjuntos simples para o usuário
        System.out.println("Vamos criar dois conjuntos para calcular!");
        System.out.println();
        
        // Conjunto A
        System.out.print("Digite os elementos do conjunto A (separados por espaço): ");
        String entradaA = ui.lerTexto();
        String[] elementosA = entradaA.split(" ");
        
        // Conjunto B  
        System.out.print("Digite os elementos do conjunto B (separados por espaço): ");
        String entradaB = ui.lerTexto();
        String[] elementosB = entradaB.split(" ");
        
        // Ordenar e mostrar os conjuntos de forma organizada
        TreeSet<String> conjuntoA = new TreeSet<>();
        TreeSet<String> conjuntoB = new TreeSet<>();
        
        // Adicionar elementos removendo espaços extras
        for (String elem : elementosA) {
            if (!elem.trim().isEmpty()) {
                conjuntoA.add(elem.trim());
            }
        }
        for (String elem : elementosB) {
            if (!elem.trim().isEmpty()) {
                conjuntoB.add(elem.trim());
            }
        }
        
        System.out.println("\nSeus conjuntos (organizados em ordem):");
        System.out.println("A = {" + String.join(", ", conjuntoA) + "}");
        System.out.println("B = {" + String.join(", ", conjuntoB) + "}");
        System.out.println();
        
        // Menu de operações
        System.out.println("Que operação você quer fazer?");
        System.out.println("[1] União (A U B)");
        System.out.println("[2] Interseção (A INT B)");  
        System.out.println("[3] Diferença (A - B)");
        System.out.println("[4] Todas as operações");
        System.out.print(">> Escolha: ");
        
        int opcao = ui.lerInteiroValidado();
        System.out.println();
        
        switch (opcao) {
            case 1:
                calcularUniao(elementosA, elementosB);
                break;
            case 2:
                calcularIntersecao(elementosA, elementosB);
                break;
            case 3:
                calcularDiferenca(elementosA, elementosB);
                break;
            case 4:
                calcularUniao(elementosA, elementosB);
                calcularIntersecao(elementosA, elementosB);
                calcularDiferenca(elementosA, elementosB);
                break;
            default:
                System.out.println("Opção inválida!");
        }
        
        ui.pausar();
    }
    
    /**
     * CONJUNTOS NUMÉRICOS - OS FAMOSOS!
     * Explica os conjuntos que você usa na matemática
     */
    private void executarConjuntosNumericos() {
        System.out.println("\n================================================================");
        System.out.println("          ** CONJUNTOS NUMÉRICOS **");
        System.out.println("================================================================");
        
        System.out.println("Estes são os conjuntos numéricos que você usa na matemática:");
        System.out.println();
        
        System.out.println("** NÚMEROS NATURAIS (N)");
        System.out.println("   N = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...}");
        System.out.println("   São os números que usamos para contar!");
        System.out.println();
        
        System.out.println("** NÚMEROS INTEIROS (Z)");  
        System.out.println("   Z = {..., -3, -2, -1, 0, 1, 2, 3, ...}");
        System.out.println("   Incluem os negativos também!");
        System.out.println();
        
        System.out.println("** NÚMEROS RACIONAIS (Q)");
        System.out.println("   Q = {frações como 1/2, 3/4, -2/3, 0.5, 0.333...}");
        System.out.println("   São números que podem virar fração!");
        System.out.println();
        
        System.out.println("** NÚMEROS IRRACIONAIS (I)");
        System.out.println("   I = {pi, raiz de 2, raiz de 3, e, ...}");
        System.out.println("   Números que NÃO podem virar fração!");
        System.out.println();
        
        System.out.println("** NÚMEROS REAIS (R)");
        System.out.println("   R = Q U I (Racionais UNIÃO Irracionais)");
        System.out.println("   Todos os números da reta numérica!");
        System.out.println();
        
        System.out.println("** CURIOSIDADE:");
        System.out.println("   N CON Z CON Q CON R");
        System.out.println("   (Cada conjunto está contido no próximo!)");
        
        ui.pausar();
    }
    
    /**
     * TESTES RÁPIDOS - VEJA SE VOCÊ ENTENDEU!
     * Perguntas simples para testar conhecimento
     */
    private void executarTestes() {
        System.out.println("\n================================================================");
        System.out.println("          ** TESTE SEU CONHECIMENTO **");
        System.out.println("================================================================");
        
        int pontos = 0;
        int totalPerguntas = 3;
        
        // Pergunta 1
        System.out.println("PERGUNTA 1:");
        System.out.println("Se A = {1, 2, 3} e B = {2, 3, 4}, qual é A U B? (UNIÃO)");
        System.out.println("[1] {1, 2, 3, 4}");
        System.out.println("[2] {2, 3}");
        System.out.println("[3] {1, 4}");
        System.out.print(">> Sua resposta: ");
        
        int resp1 = ui.lerInteiroValidado();
        if (resp1 == 1) {
            System.out.println("** CORRETO! A união pega todos os elementos dos dois conjuntos!");
            pontos++;
        } else {
            System.out.println("** ERRADO! A resposta é {1, 2, 3, 4}");
        }
        System.out.println();
        
        // Pergunta 2  
        System.out.println("PERGUNTA 2:");
        System.out.println("Se A = {1, 2, 3} e B = {2, 3, 4}, qual é A INT B? (INTERSEÇÃO)");
        System.out.println("[1] {1, 2, 3, 4}");
        System.out.println("[2] {2, 3}");
        System.out.println("[3] {1, 4}");
        System.out.print(">> Sua resposta: ");
        
        int resp2 = ui.lerInteiroValidado();
        if (resp2 == 2) {
            System.out.println("** CORRETO! A interseção pega só os elementos comuns!");
            pontos++;
        } else {
            System.out.println("** ERRADO! A resposta é {2, 3}");
        }
        System.out.println();
        
        // Pergunta 3
        System.out.println("PERGUNTA 3:");
        System.out.println("O número pi pertence a qual conjunto?");
        System.out.println("[1] Números Naturais (N)");
        System.out.println("[2] Números Racionais (Q)");
        System.out.println("[3] Números Irracionais (I)");
        System.out.print(">> Sua resposta: ");
        
        int resp3 = ui.lerInteiroValidado();
        if (resp3 == 3) {
            System.out.println("** CORRETO! pi não pode ser escrito como fração!");
            pontos++;
        } else {
            System.out.println("** ERRADO! pi é irracional porque não vira fração!");
        }
        System.out.println();
        
        // Resultado final
        System.out.println("===============================================");
        System.out.println("** RESULTADO: " + pontos + "/" + totalPerguntas + " pontos");
        
        if (pontos == totalPerguntas) {
            System.out.println("** PARABÉNS! Você mandou bem!");
        } else if (pontos >= totalPerguntas/2) {
            System.out.println("** BOA! Você está no caminho certo!");
        } else {
            System.out.println("** Estude mais um pouco e tente novamente!");
        }
        
        ui.pausar();
    }
    
    // Métodos auxiliares para a calculadora - com resultados ORDENADOS!
    
    /**
     * CALCULAR UNIÃO - junta todos os elementos SEM repetir e EM ORDEM
     */
    private void calcularUniao(String[] a, String[] b) {
        System.out.println("** UNIÃO (A U B):");
        
        // Usar TreeSet para ordenar automaticamente e remover duplicatas
        TreeSet<String> resultado = new TreeSet<>();
        
        // Adicionar elementos de A
        for (String elem : a) {
            resultado.add(elem.trim()); // trim remove espaços extras
        }
        
        // Adicionar elementos de B (TreeSet remove duplicatas automaticamente)
        for (String elem : b) {
            resultado.add(elem.trim());
        }
        
        // Mostrar resultado ordenado
        System.out.print("   Resultado: {");
        int contador = 0;
        for (String elem : resultado) {
            if (contador > 0) System.out.print(", ");
            System.out.print(elem);
            contador++;
        }
        System.out.println("}");
        System.out.println("   (Todos os elementos dos dois conjuntos, EM ORDEM!)");
        System.out.println();
    }
    
    /**
     * CALCULAR INTERSEÇÃO - só elementos comuns e EM ORDEM
     */
    private void calcularIntersecao(String[] a, String[] b) {
        System.out.println("** INTERSEÇÃO (A INT B):");
        
        // Usar TreeSet para ordenar
        TreeSet<String> resultado = new TreeSet<>();
        
        // Procurar elementos comuns
        for (String elemA : a) {
            for (String elemB : b) {
                if (elemA.trim().equals(elemB.trim())) {
                    resultado.add(elemA.trim());
                    break; // Já encontrou, não precisa continuar
                }
            }
        }
        
        // Mostrar resultado ordenado
        System.out.print("   Resultado: {");
        int contador = 0;
        for (String elem : resultado) {
            if (contador > 0) System.out.print(", ");
            System.out.print(elem);
            contador++;
        }
        System.out.println("}");
        System.out.println("   (Só os elementos que aparecem nos dois, EM ORDEM!)");
        System.out.println();
    }
    
    /**
     * CALCULAR DIFERENÇA - elementos de A que não estão em B, EM ORDEM
     */
    private void calcularDiferenca(String[] a, String[] b) {
        System.out.println("** DIFERENÇA (A - B):");
        
        // Usar TreeSet para ordenar
        TreeSet<String> resultado = new TreeSet<>();
        
        // Procurar elementos de A que não estão em B
        for (String elemA : a) {
            boolean estaEmB = false;
            for (String elemB : b) {
                if (elemA.trim().equals(elemB.trim())) {
                    estaEmB = true;
                    break;
                }
            }
            if (!estaEmB) {
                resultado.add(elemA.trim());
            }
        }
        
        // Mostrar resultado ordenado
        System.out.print("   Resultado: {");
        int contador = 0;
        for (String elem : resultado) {
            if (contador > 0) System.out.print(", ");
            System.out.print(elem);
            contador++;
        }
        System.out.println("}");
        System.out.println("   (Elementos de A que NÃO estão em B, EM ORDEM!)");
        System.out.println();
    }
    
    // ===== NOVAS FUNCIONALIDADES AVANÇADAS =====
    
    /**
     * EXECUTAR GERENCIADOR DE CONJUNTOS
     * Permite criar conjuntos nomeados e manter histórico
     */
    private void executarGerenciadorConjuntos() {
        GerenciadorConjuntos gerenciador = new GerenciadorConjuntos(ui);
        gerenciador.executarGerenciador();
    }
    
    /**
     * EXECUTAR CONJUNTOS MULTI-TIPO
     * Trabalha com Integer, Double e String
     */
    private void executarConjuntosMultiTipo() {
        ConjuntosMultiTipo multiTipo = new ConjuntosMultiTipo(ui);
        multiTipo.executarMultiTipo();
    }
    
    /**
     * EXECUTAR SISTEMA DE PERSISTÊNCIA
     * Salva e carrega conjuntos de arquivos
     */
    private void executarSistemaPersistencia() {
        SistemaPersistencia persistencia = new SistemaPersistencia(ui);
        persistencia.executarPersistencia();
    }
    
    /**
     * EXECUTAR SISTEMA DE EXPORTAÇÃO
     * Gera relatórios profissionais em vários formatos
     */
    private void executarSistemaExportacao() {
        SistemaExportacao exportacao = new SistemaExportacao(ui);
        exportacao.executarExportacao();
    }
}
