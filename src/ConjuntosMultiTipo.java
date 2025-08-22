import java.text.DecimalFormat;
import java.util.*;

/**
 * CONJUNTOS DE TIPOS VARIADOS - Sistema Multi-Tipo!
 * 
 * Esta classe permite trabalhar com:
 * - Conjuntos de NÚMEROS INTEIROS
 * - Conjuntos de NÚMEROS DECIMAIS (Double)
 * - Conjuntos de PALAVRAS (String)
 * - Conversões entre tipos
 * 
 * É como ter uma "calculadora universal de conjuntos"!
 * 
 * @author Sistema TGS - Versão Multi-Tipo
 */
public class ConjuntosMultiTipo {
    
    private final InterfaceEducacionalASCII ui;
    private final DecimalFormat formatoDecimal;
    
    /**
     * CONSTRUTOR
     */
    public ConjuntosMultiTipo(InterfaceEducacionalASCII ui) {
        this.ui = ui;
        this.formatoDecimal = new DecimalFormat("#.##");
    }
    
    /**
     * MENU PRINCIPAL dos Conjuntos Multi-Tipo
     */
    public void executarMultiTipo() {
        boolean continuar = true;
        
        while (continuar) {
            mostrarMenuMultiTipo();
            int opcao = ui.lerInteiroValidado();
            
            switch (opcao) {
                case 1 -> trabalharComInteiros();
                case 2 -> trabalharComDecimais();
                case 3 -> trabalharComPalavras();
                case 4 -> exemploConversoes();
                case 5 -> demonstracaoCompleta();
                case 6 -> continuar = false;
                default -> {
                    ui.exibirErro("Opção inválida! Digite 1-6.");
                    ui.pausar();
                }
            }
        }
    }
    
    /**
     * Menu do sistema multi-tipo
     */
    private void mostrarMenuMultiTipo() {
        ui.limparTela();
        System.out.println("================================================================");
        System.out.println("         ** CONJUNTOS MULTI-TIPO AVANÇADOS **");
        System.out.println("================================================================");
        System.out.println();
        System.out.println("  [1] Trabalhar com NÚMEROS INTEIROS");
        System.out.println("  [2] Trabalhar com NÚMEROS DECIMAIS");
        System.out.println("  [3] Trabalhar com PALAVRAS/TEXTO");
        System.out.println("  [4] Exemplo de CONVERSÕES entre Tipos");
        System.out.println("  [5] DEMONSTRAÇÃO COMPLETA");
        System.out.println("  [6] Voltar ao Menu Principal");
        System.out.println();
        System.out.println("================================================================");
        System.out.print(">> Sua escolha: ");
    }
    
    // ===== TRABALHAR COM INTEIROS =====
    
    /**
     * CONJUNTOS DE NÚMEROS INTEIROS
     */
    private void trabalharComInteiros() {
        System.out.println("\n** CONJUNTOS DE NÚMEROS INTEIROS **");
        System.out.println();
        
        // Criar dois conjuntos de inteiros
        TreeSet<Integer> conjunto1 = lerConjuntoInteiro("primeiro");
        TreeSet<Integer> conjunto2 = lerConjuntoInteiro("segundo");
        
        // Mostrar conjuntos
        System.out.println();
        System.out.println("** SEUS CONJUNTOS CRIADOS: **");
        System.out.println("A = " + conjunto1);
        System.out.println("B = " + conjunto2);
        System.out.println();
        
        // Calcular operações
        TreeSet<Integer> uniao = new TreeSet<>(conjunto1);
        uniao.addAll(conjunto2);
        
        TreeSet<Integer> intersecao = new TreeSet<>(conjunto1);
        intersecao.retainAll(conjunto2);
        
        TreeSet<Integer> diferenca = new TreeSet<>(conjunto1);
        diferenca.removeAll(conjunto2);
        
        // Mostrar resultados
        System.out.println("** RESULTADOS DAS OPERAÇÕES: **");
        System.out.println("A U B = " + uniao);
        System.out.println("A INT B = " + intersecao);
        System.out.println("A - B = " + diferenca);
        
        // Análises matemáticas
        System.out.println();
        System.out.println("** ANÁLISES MATEMÁTICAS: **");
        System.out.println("Quantidade de elementos em A: " + conjunto1.size());
        System.out.println("Quantidade de elementos em B: " + conjunto2.size());
        System.out.println("Quantidade na União: " + uniao.size());
        System.out.println("Quantidade na Interseção: " + intersecao.size());
        
        if (!conjunto1.isEmpty()) {
            System.out.println("Menor elemento de A: " + conjunto1.first());
            System.out.println("Maior elemento de A: " + conjunto1.last());
        }
        
        ui.pausar();
    }
    
    /**
     * Ler conjunto de números inteiros
     */
    private TreeSet<Integer> lerConjuntoInteiro(String nome) {
        System.out.print("Digite números inteiros para o " + nome + " conjunto (separados por espaço): ");
        String entrada = ui.lerTexto();
        String[] elementos = entrada.split(" ");
        
        TreeSet<Integer> conjunto = new TreeSet<>();
        
        for (String elem : elementos) {
            try {
                if (!elem.trim().isEmpty()) {
                    conjunto.add(Integer.parseInt(elem.trim()));
                }
            } catch (NumberFormatException e) {
                System.out.println("AVISO: '" + elem + "' não é um número inteiro válido. Ignorado.");
            }
        }
        
        return conjunto;
    }
    
    // ===== TRABALHAR COM DECIMAIS =====
    
    /**
     * CONJUNTOS DE NÚMEROS DECIMAIS
     */
    private void trabalharComDecimais() {
        System.out.println("\n** CONJUNTOS DE NÚMEROS DECIMAIS **");
        System.out.println("(Use ponto para separar decimais, ex: 3.14)");
        System.out.println();
        
        // Criar dois conjuntos de decimais
        TreeSet<Double> conjunto1 = lerConjuntoDecimal("primeiro");
        TreeSet<Double> conjunto2 = lerConjuntoDecimal("segundo");
        
        // Mostrar conjuntos formatados
        System.out.println();
        System.out.println("** SEUS CONJUNTOS CRIADOS: **");
        System.out.println("A = " + formatarConjuntoDouble(conjunto1));
        System.out.println("B = " + formatarConjuntoDouble(conjunto2));
        System.out.println();
        
        // Calcular operações
        TreeSet<Double> uniao = new TreeSet<>(conjunto1);
        uniao.addAll(conjunto2);
        
        TreeSet<Double> intersecao = new TreeSet<>(conjunto1);
        intersecao.retainAll(conjunto2);
        
        TreeSet<Double> diferenca = new TreeSet<>(conjunto1);
        diferenca.removeAll(conjunto2);
        
        // Mostrar resultados
        System.out.println("** RESULTADOS DAS OPERAÇÕES: **");
        System.out.println("A U B = " + formatarConjuntoDouble(uniao));
        System.out.println("A INT B = " + formatarConjuntoDouble(intersecao));
        System.out.println("A - B = " + formatarConjuntoDouble(diferenca));
        
        // Análises estatísticas
        System.out.println();
        System.out.println("** ANÁLISES ESTATÍSTICAS: **");
        if (!conjunto1.isEmpty()) {
            double soma = conjunto1.stream().mapToDouble(Double::doubleValue).sum();
            double media = soma / conjunto1.size();
            System.out.println("Soma dos elementos de A: " + formatoDecimal.format(soma));
            System.out.println("Média dos elementos de A: " + formatoDecimal.format(media));
            System.out.println("Menor valor em A: " + formatoDecimal.format(conjunto1.first()));
            System.out.println("Maior valor em A: " + formatoDecimal.format(conjunto1.last()));
        }
        
        ui.pausar();
    }
    
    /**
     * Ler conjunto de números decimais
     */
    private TreeSet<Double> lerConjuntoDecimal(String nome) {
        System.out.print("Digite números decimais para o " + nome + " conjunto (ex: 1.5 2.7 3.14): ");
        String entrada = ui.lerTexto();
        String[] elementos = entrada.split(" ");
        
        TreeSet<Double> conjunto = new TreeSet<>();
        
        for (String elem : elementos) {
            try {
                if (!elem.trim().isEmpty()) {
                    conjunto.add(Double.parseDouble(elem.trim()));
                }
            } catch (NumberFormatException e) {
                System.out.println("AVISO: '" + elem + "' não é um número decimal válido. Ignorado.");
            }
        }
        
        return conjunto;
    }
    
    /**
     * Formatar conjunto de doubles para exibição
     */
    private String formatarConjuntoDouble(TreeSet<Double> conjunto) {
        if (conjunto.isEmpty()) {
            return "{}";
        }
        
        List<String> formatados = new ArrayList<>();
        for (Double d : conjunto) {
            formatados.add(formatoDecimal.format(d));
        }
        
        return "{" + String.join(", ", formatados) + "}";
    }
    
    // ===== TRABALHAR COM PALAVRAS =====
    
    /**
     * CONJUNTOS DE PALAVRAS/STRINGS
     */
    private void trabalharComPalavras() {
        System.out.println("\n** CONJUNTOS DE PALAVRAS/TEXTO **");
        System.out.println();
        
        // Criar dois conjuntos de strings
        TreeSet<String> conjunto1 = lerConjuntoPalavras("primeiro");
        TreeSet<String> conjunto2 = lerConjuntoPalavras("segundo");
        
        // Mostrar conjuntos
        System.out.println();
        System.out.println("** SEUS CONJUNTOS CRIADOS: **");
        System.out.println("A = {" + String.join(", ", conjunto1) + "}");
        System.out.println("B = {" + String.join(", ", conjunto2) + "}");
        System.out.println();
        
        // Calcular operações
        TreeSet<String> uniao = new TreeSet<>(conjunto1);
        uniao.addAll(conjunto2);
        
        TreeSet<String> intersecao = new TreeSet<>(conjunto1);
        intersecao.retainAll(conjunto2);
        
        TreeSet<String> diferenca = new TreeSet<>(conjunto1);
        diferenca.removeAll(conjunto2);
        
        // Mostrar resultados
        System.out.println("** RESULTADOS DAS OPERAÇÕES: **");
        System.out.println("A U B = {" + String.join(", ", uniao) + "}");
        System.out.println("A INT B = {" + String.join(", ", intersecao) + "}");
        System.out.println("A - B = {" + String.join(", ", diferenca) + "}");
        
        // Análises de texto
        System.out.println();
        System.out.println("** ANÁLISES DE TEXTO: **");
        analisarConjuntoPalavras("A", conjunto1);
        analisarConjuntoPalavras("B", conjunto2);
        
        ui.pausar();
    }
    
    /**
     * Ler conjunto de palavras
     */
    private TreeSet<String> lerConjuntoPalavras(String nome) {
        System.out.print("Digite palavras para o " + nome + " conjunto (separadas por espaço): ");
        String entrada = ui.lerTexto();
        String[] elementos = entrada.split(" ");
        
        TreeSet<String> conjunto = new TreeSet<>();
        
        for (String elem : elementos) {
            if (!elem.trim().isEmpty()) {
                conjunto.add(elem.trim().toLowerCase()); // Converter para minúsculas
            }
        }
        
        return conjunto;
    }
    
    /**
     * Analisar conjunto de palavras
     */
    private void analisarConjuntoPalavras(String nome, TreeSet<String> conjunto) {
        if (conjunto.isEmpty()) {
            System.out.println("Conjunto " + nome + " está vazio.");
            return;
        }
        
        // Estatísticas básicas
        int totalPalavras = conjunto.size();
        int totalCaracteres = conjunto.stream().mapToInt(String::length).sum();
        double mediaCaracteres = (double) totalCaracteres / totalPalavras;
        
        String menorPalavra = conjunto.stream().min(Comparator.comparing(String::length)).orElse("");
        String maiorPalavra = conjunto.stream().max(Comparator.comparing(String::length)).orElse("");
        
        System.out.println("Conjunto " + nome + ":");
        System.out.println("  - Total de palavras: " + totalPalavras);
        System.out.println("  - Total de caracteres: " + totalCaracteres);
        System.out.println("  - Média de caracteres por palavra: " + formatoDecimal.format(mediaCaracteres));
        System.out.println("  - Palavra mais curta: '" + menorPalavra + "' (" + menorPalavra.length() + " chars)");
        System.out.println("  - Palavra mais longa: '" + maiorPalavra + "' (" + maiorPalavra.length() + " chars)");
        System.out.println("  - Primeira alfabeticamente: '" + conjunto.first() + "'");
        System.out.println("  - Última alfabeticamente: '" + conjunto.last() + "'");
    }
    
    // ===== CONVERSÕES ENTRE TIPOS =====
    
    /**
     * Demonstrar conversões entre tipos
     */
    private void exemploConversoes() {
        System.out.println("\n** EXEMPLO DE CONVERSÕES ENTRE TIPOS **");
        System.out.println();
        
        // Conjunto original de strings
        TreeSet<String> palavras = new TreeSet<>();
        palavras.addAll(Arrays.asList("1", "2", "3", "4", "5", "3.14", "2.71", "abc"));
        
        System.out.println("Conjunto original (String): {" + String.join(", ", palavras) + "}");
        System.out.println();
        
        // Tentar converter para números
        TreeSet<Integer> inteiros = new TreeSet<>();
        TreeSet<Double> decimais = new TreeSet<>();
        TreeSet<String> naoNumericos = new TreeSet<>();
        
        for (String s : palavras) {
            try {
                // Tentar como inteiro primeiro
                inteiros.add(Integer.parseInt(s));
            } catch (NumberFormatException e1) {
                try {
                    // Tentar como decimal
                    decimais.add(Double.parseDouble(s));
                } catch (NumberFormatException e2) {
                    // Não é número
                    naoNumericos.add(s);
                }
            }
        }
        
        // Mostrar resultados
        System.out.println("** RESULTADOS DA CONVERSÃO: **");
        System.out.println("Inteiros encontrados: " + inteiros);
        System.out.println("Decimais encontrados: " + formatarConjuntoDouble(decimais));
        System.out.println("Não numéricos: {" + String.join(", ", naoNumericos) + "}");
        
        // Operações mistas
        System.out.println();
        System.out.println("** OPERAÇÕES COM TIPOS CONVERTIDOS: **");
        if (!inteiros.isEmpty()) {
            int soma = inteiros.stream().mapToInt(Integer::intValue).sum();
            System.out.println("Soma dos inteiros: " + soma);
        }
        
        if (!decimais.isEmpty()) {
            double soma = decimais.stream().mapToDouble(Double::doubleValue).sum();
            System.out.println("Soma dos decimais: " + formatoDecimal.format(soma));
        }
        
        ui.pausar();
    }
    
    // ===== DEMONSTRAÇÃO COMPLETA =====
    
    /**
     * Demonstração completa de todos os tipos
     */
    private void demonstracaoCompleta() {
        System.out.println("\n** DEMONSTRAÇÃO COMPLETA - TODOS OS TIPOS **");
        System.out.println();
        
        // Criar conjuntos de exemplo
        TreeSet<Integer> numeros = new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5));
        TreeSet<Double> decimais = new TreeSet<>(Arrays.asList(1.1, 2.2, 3.3, 4.4));
        TreeSet<String> frutas = new TreeSet<>(Arrays.asList("maçã", "banana", "laranja", "uva"));
        TreeSet<String> cores = new TreeSet<>(Arrays.asList("azul", "verde", "amarelo", "vermelho"));
        
        System.out.println("=== CONJUNTOS DE DEMONSTRAÇÃO ===");
        System.out.println("Números: " + numeros);
        System.out.println("Decimais: " + formatarConjuntoDouble(decimais));
        System.out.println("Frutas: {" + String.join(", ", frutas) + "}");
        System.out.println("Cores: {" + String.join(", ", cores) + "}");
        System.out.println();
        
        // Operações entre frutas e cores
        TreeSet<String> uniaoPalavras = new TreeSet<>(frutas);
        uniaoPalavras.addAll(cores);
        
        TreeSet<String> intersecaoPalavras = new TreeSet<>(frutas);
        intersecaoPalavras.retainAll(cores);
        
        System.out.println("=== OPERAÇÕES COM PALAVRAS ===");
        System.out.println("Frutas U Cores = {" + String.join(", ", uniaoPalavras) + "}");
        System.out.println("Frutas INT Cores = {" + String.join(", ", intersecaoPalavras) + "}");
        System.out.println("(Interseção vazia - frutas e cores são conjuntos disjuntos!)");
        System.out.println();
        
        // Estatísticas gerais
        System.out.println("=== ESTATÍSTICAS GERAIS ===");
        System.out.println("Total de elementos únicos: " + (numeros.size() + decimais.size() + uniaoPalavras.size()));
        System.out.println("Tipos diferentes utilizados: 3 (Integer, Double, String)");
        System.out.println("Maior conjunto: " + (uniaoPalavras.size() > numeros.size() ? "Palavras" : "Números"));
        
        ui.pausar();
    }
}
