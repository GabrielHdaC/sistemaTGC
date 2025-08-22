import java.util.*;

/**
 * Classe para Resolver Problemas Práticos de Conjuntos
 * 
 * Esta classe implementa soluções para problemas reais usando teoria matemática.
 * O foco está na aplicação do PRINCÍPIO DA INCLUSÃO-EXCLUSÃO - um dos conceitos
 * mais complexos e úteis da matemática de conjuntos.
 * 
 * CONCEITOS COMPLEXOS IMPLEMENTADOS:
 * - Princípio da Inclusão-Exclusão (PIE)
 * - Cardinalidade de uniões múltiplas  
 * - Mapeamento bijetivo em exemplos práticos
 * - Visualização de teoremas abstratos
 * 
 * @author Gabriel Heron
 * @version 3.0 - Optimized & Documented
 * @based_on Fundamentos Matemáticos - Profª Drª Janaína Poffo Possamai
 */
public class ProblemasConjuntos {
    
    // Constantes do problema - Clean Code: Avoid Magic Numbers
    private static final int POPULACAO_TOTAL = 40000;
    private static final double PERCENTUAL_COLINA = 0.20;      // 20%
    private static final double PERCENTUAL_SILVESTRE = 0.16;   // 16% 
    private static final double PERCENTUAL_CAMPESTRE = 0.14;   // 14%
    private static final double PERCENTUAL_COLINA_SILVESTRE = 0.08;    // 8%
    private static final double PERCENTUAL_COLINA_CAMPESTRE = 0.05;    // 5%
    private static final double PERCENTUAL_SILVESTRE_CAMPESTRE = 0.04; // 4%
    private static final double PERCENTUAL_TRES_CLUBES = 0.02;         // 2%
    
    /**
     * PROBLEMA COMPLEXO: PRINCÍPIO DA INCLUSÃO-EXCLUSÃO
     * 
     * Este é um dos conceitos mais difíceis da matemática de conjuntos!
     * 
     * O QUE FAZ QUEBRAR A CABEÇA:
     * 1. Não podemos simplesmente somar |A| + |B| + |C|
     * 2. Isso conta intersecções múltiplas vezes
     * 3. Precisamos "incluir" e "excluir" sistematicamente
     * 
     * FÓRMULA MATEMÁTICA (PIE para 3 conjuntos):
     * |A U B U C| = |A| + |B| + |C| 
     *               - |A INT B| - |A INT C| - |B INT C| 
     *               + |A INT B INT C|
     * 
     * POR QUE FUNCIONA:
     * - Primeiro: conta tudo (inclui duplicatas)
     * - Segundo: remove intersecções duplas (exclui)  
     * - Terceiro: readiciona tripla intersecção (inclui novamente)
     * 
     * APLICAÇÃO PRÁTICA:
     * A = pessoas que frequentam Colina
     * B = pessoas que frequentam Silvestre  
     * C = pessoas que frequentam Campestre
     * 
     * Queremos: quantas pessoas frequentam PELO MENOS UM clube?
     */
    public static void resolverProblemaClubs() {
        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║           🏛️ PROBLEMA DOS CLUBES RECREATIVOS 🏛️            ║");
        System.out.println("║              (Princípio da Inclusão-Exclusão)               ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
        System.out.println();
        
        // Clean Code: Extract Method - separar lógica em métodos menores
        DadosProblema dados = calcularDadosProblema();
        
        exibirContextoProblema();
        exibirDadosCalculados(dados);
        int resultado = aplicarPrincipioInclusaoExclusao(dados);
        exibirResolucaoDetalhada(dados, resultado);
        exibirConclusaoEImportancia(resultado);
    }
    
    /**
     * CLASSE INTERNA - Clean Code: Encapsulation
     * 
     * Encapsula todos os dados calculados do problema.
     * Evita passar múltiplos parâmetros entre métodos.
     */
    private static class DadosProblema {
        final int colina;
        final int silvestre;
        final int campestre;
        final int colinaSilvestre;
        final int colinaCampestre;
        final int silvestreCampestre;
        final int tresClubes;
        
        DadosProblema(int colina, int silvestre, int campestre,
                     int colinaSilvestre, int colinaCampestre, 
                     int silvestreCampestre, int tresClubes) {
            this.colina = colina;
            this.silvestre = silvestre;
            this.campestre = campestre;
            this.colinaSilvestre = colinaSilvestre;
            this.colinaCampestre = colinaCampestre;
            this.silvestreCampestre = silvestreCampestre;
            this.tresClubes = tresClubes;
        }
    }
    
    /**
     * MÉTODO AUXILIAR - Clean Code: Single Responsibility
     * Calcula todos os dados numéricos do problema
     */
    private static DadosProblema calcularDadosProblema() {
        // Conversão de percentuais para números absolutos
        int colina = (int)(POPULACAO_TOTAL * PERCENTUAL_COLINA);
        int silvestre = (int)(POPULACAO_TOTAL * PERCENTUAL_SILVESTRE);
        int campestre = (int)(POPULACAO_TOTAL * PERCENTUAL_CAMPESTRE);
        
        int colinaSilvestre = (int)(POPULACAO_TOTAL * PERCENTUAL_COLINA_SILVESTRE);
        int colinaCampestre = (int)(POPULACAO_TOTAL * PERCENTUAL_COLINA_CAMPESTRE);
        int silvestreCampestre = (int)(POPULACAO_TOTAL * PERCENTUAL_SILVESTRE_CAMPESTRE);
        
        int tresClubes = (int)(POPULACAO_TOTAL * PERCENTUAL_TRES_CLUBES);
        
        return new DadosProblema(colina, silvestre, campestre,
                                colinaSilvestre, colinaCampestre,
                                silvestreCampestre, tresClubes);
    }
    
    /**
     * MÉTODO AUXILIAR - Clean Code: Expressiveness  
     * Apresenta o contexto do problema de forma clara
     */
    private static void exibirContextoProblema() {
        System.out.println("🏙️ CONTEXTO:");
        System.out.println("Cidade com " + String.format("%,d", POPULACAO_TOTAL) + " habitantes");
        System.out.println("Três clubes recreativos: Colina, Silvestre, Campestre");
        System.out.println("❓ PERGUNTA: Quantas pessoas NÃO frequentam nenhum clube?");
        System.out.println();
    }
    
    /**
     * MÉTODO AUXILIAR - Clean Code: Readable Code
     * Exibe os dados calculados de forma organizada
     */
    private static void exibirDadosCalculados(DadosProblema dados) {
        System.out.println("📊 DADOS CALCULADOS (percentuais → números absolutos):");
        System.out.println("┌─────────────────────────────────────┬─────────────┐");
        System.out.println("│ Frequentam Colina                   │ " + String.format("%,8d", dados.colina) + " │");
        System.out.println("│ Frequentam Silvestre                │ " + String.format("%,8d", dados.silvestre) + " │");
        System.out.println("│ Frequentam Campestre                │ " + String.format("%,8d", dados.campestre) + " │");
        System.out.println("├─────────────────────────────────────┼─────────────┤");
        System.out.println("│ Colina E Silvestre                  │ " + String.format("%,8d", dados.colinaSilvestre) + " │");
        System.out.println("│ Colina E Campestre                  │ " + String.format("%,8d", dados.colinaCampestre) + " │");
        System.out.println("│ Silvestre E Campestre               │ " + String.format("%,8d", dados.silvestreCampestre) + " │");
        System.out.println("├─────────────────────────────────────┼─────────────┤");
        System.out.println("│ TODOS os três clubes                │ " + String.format("%,8d", dados.tresClubes) + " │");
        System.out.println("└─────────────────────────────────────┴─────────────┘");
        System.out.println();
    }
    
    /**
     * MÉTODO COMPLEXO - O CORAÇÃO DO PROBLEMA!
     * 
     * Aplicação do Princípio da Inclusão-Exclusão (PIE)
     * 
     * ESTA É A PARTE MAIS DIFÍCIL DE ENTENDER:
     * Por que não podemos simplesmente somar A + B + C?
     * 
     * PROBLEMA DA SOMA SIMPLES:
     * - Se alguém frequenta Colina E Silvestre, seria contado 2 vezes
     * - Se alguém frequenta os 3 clubes, seria contado 3 vezes!
     * 
     * SOLUÇÃO DO PIE:
     * 1. INCLUI: Soma todos os conjuntos individuais
     * 2. EXCLUI: Subtrai todas as intersecções duplas  
     * 3. INCLUI: Soma de volta a intersecção tripla
     * 
     * @param dados Os dados calculados do problema
     * @return Quantidade de pessoas que frequentam pelo menos um clube
     */
    private static int aplicarPrincipioInclusaoExclusao(DadosProblema dados) {
        // Fórmula PIE: |A U B U C| = |A| + |B| + |C| - |A INT B| - |A INT C| - |B INT C| + |A INT B INT C|
        int resultado = dados.colina + dados.silvestre + dados.campestre
                       - dados.colinaSilvestre - dados.colinaCampestre - dados.silvestreCampestre
                       + dados.tresClubes;
        
        return resultado;
    }
    
    /**
     * MÉTODO AUXILIAR - Clean Code: Educational Display
     * Mostra passo a passo como a fórmula PIE é aplicada
     */
    private static void exibirResolucaoDetalhada(DadosProblema dados, int resultado) {
        System.out.println("🧮 RESOLUÇÃO PASSO A PASSO (Princípio da Inclusão-Exclusão):");
        System.out.println();
        
        System.out.println("📐 FÓRMULA MATEMÁTICA:");
        System.out.println("|A U B U C| = |A| + |B| + |C| - |A INT B| - |A INT C| - |B INT C| + |A INT B INT C|");
        System.out.println();
        
        System.out.println("🔢 SUBSTITUINDO OS VALORES:");
        System.out.println(String.format("|Colina ∪ Silvestre ∪ Campestre| = %,d + %,d + %,d", 
                                        dados.colina, dados.silvestre, dados.campestre));
        System.out.println(String.format("                                  - %,d - %,d - %,d", 
                                        dados.colinaSilvestre, dados.colinaCampestre, dados.silvestreCampestre));
        System.out.println(String.format("                                  + %,d", dados.tresClubes));
        System.out.println(String.format("                                  = %,d pessoas", resultado));
        System.out.println();
        
        System.out.println("🎯 INTERPRETAÇÃO:");
        System.out.println("• Primeiro: soma todos que frequentam cada clube individual");
        System.out.println("• Segundo: subtrai as intersecções (evita dupla contagem)");
        System.out.println("• Terceiro: soma de volta a tripla intersecção (estava sendo subtraída demais)");
        System.out.println();
    }
    
    /**
     * MÉTODO AUXILIAR - Clean Code: Clear Results
     * Apresenta a conclusão final e a importância matemática
     */
    private static void exibirConclusaoEImportancia(int frequentamAlgumClube) {
        int naoFrequentamNenhum = POPULACAO_TOTAL - frequentamAlgumClube;
        double percentualNaoFrequenta = (naoFrequentamNenhum * 100.0) / POPULACAO_TOTAL;
        
        System.out.println("✅ RESPOSTA FINAL:");
        System.out.println("┌─────────────────────────────────────────────────────┐");
        System.out.println("│ Pessoas que frequentam ALGUM clube: " + String.format("%,11d", frequentamAlgumClube) + " │");
        System.out.println("│ Pessoas que NÃO frequentam NENHUM:  " + String.format("%,11d", naoFrequentamNenhum) + " │");
        System.out.println("│ Porcentagem que não frequenta:      " + String.format("%11.1f%%", percentualNaoFrequenta) + " │");
        System.out.println("└─────────────────────────────────────────────────────┘");
        System.out.println();
        
        System.out.println("🎓 IMPORTÂNCIA MATEMÁTICA:");
        System.out.println("• O PIE resolve problemas de contagem complexos");
        System.out.println("• É fundamental em Probabilidade e Combinatória");
        System.out.println("• Aparece em Análise de Algoritmos e Ciência da Computação");
        System.out.println("• Exemplo prático de como a matemática resolve problemas reais!");
    }
    
    /**
     * CONCEITO EDUCATIVO - Clean Code Version
     * 
     * Demonstra bijeções em conjuntos infinitos usando o exemplo de Galilei
     * Versão otimizada e bem documentada
     */
    public static void demonstrarConjuntosInfinitos() {
        System.out.println("=== CONJUNTOS INFINITOS - GALILEI ===");
        System.out.println("Demonstração: ℕ (naturais) tem o mesmo 'tamanho' que números pares");
        System.out.println();
        
        System.out.println("Mapeamento biunívoco:");
        System.out.println("ℕ:     1  2  3  4  5  6  7  8  9  10 ...");
        System.out.println("Pares: 2  4  6  8  10 12 14 16 18 20 ...");
        System.out.println();
        
        System.out.println("🔍 ANÁLISE:");
        System.out.println("• Cada número natural n corresponde ao par 2n");
        System.out.println("• Todos os pares são cobertos por essa correspondência");
        System.out.println("• Logo, |ℕ| = |Pares| mesmo sendo Pares ⊂ ℕ");
        System.out.println("• Isso só acontece com conjuntos INFINITOS!");
        System.out.println("===========================================\n");
    }
    
    /**
     * Mostra exemplos de diferentes tipos de conjuntos
     * Baseado na classificação do documento
     */
    public static void exemplificarTiposConjuntos() {
        System.out.println("=== TIPOS DE CONJUNTOS ===");
        
        // Conjunto Finito
        Set<String> livrosBiblioteca = new HashSet<>(Arrays.asList(
            "Java: O Guia Completo", "Algoritmos e Estruturas de Dados", 
            "Matemática Discreta", "Fundamentos de Programação"
        ));
        
        System.out.println("📚 CONJUNTO FINITO:");
        System.out.println("Livros da Biblioteca: " + livrosBiblioteca);
        System.out.println("Cardinalidade: " + livrosBiblioteca.size());
        System.out.println();
        
        // Conjunto Vazio (dinossauros vivos)
        Set<String> dinossaurosVivos = new HashSet<>();
        
        System.out.println("🦕 CONJUNTO VAZIO:");
        System.out.println("Dinossauros Vivos: " + dinossaurosVivos + " = ∅");
        System.out.println("Cardinalidade: " + dinossaurosVivos.size());
        System.out.println();
        
        // Representação de conjunto infinito (números ímpares)
        System.out.println("🔢 CONJUNTO INFINITO:");
        System.out.println("Números Ímpares: {1, 3, 5, 7, 9, 11, 13, ...}");
        System.out.println("Cardinalidade: ∞ (infinito)");
        System.out.println("===========================================\n");
    }
    
    /**
     * Valida as regras de notação matemática
     * Baseado nas convenções do documento
     */
    public static void validarNotacaoMatematica() {
        System.out.println("=== NOTAÇÃO MATEMÁTICA ===");
        System.out.println("✅ CONVENÇÕES CORRETAS:");
        System.out.println("• Conjuntos: letras MAIÚSCULAS (A, B, C, ...)");
        System.out.println("• Elementos: letras minúsculas (a, b, c, ...)");
        System.out.println();
        
        System.out.println("📝 EXEMPLOS:");
        System.out.println("A = {1, 2, 3, 4, 5}    → Conjunto A");
        System.out.println("a ∈ A                  → elemento a pertence ao conjunto A");
        System.out.println("B = {x | x é par}      → Conjunto B por compreensão");
        System.out.println("A ∪ B                  → União dos conjuntos A e B");
        System.out.println("A ∩ B                  → Interseção dos conjuntos A e B");
        System.out.println("===========================================\n");
    }
    
    /**
     * Executa todas as demonstrações baseadas no documento
     */
    public static void main(String[] args) {
        System.out.println("🎓 FUNDAMENTOS MATEMÁTICOS - TEORIA DOS CONJUNTOS");
        System.out.println("Baseado no documento: Unidade 1_2025_VF\n");
        
        validarNotacaoMatematica();
        exemplificarTiposConjuntos();
        demonstrarConjuntosInfinitos();
        resolverProblemaClubs();
        
        System.out.println("🎉 Demonstrações concluídas com sucesso!");
    }
}
