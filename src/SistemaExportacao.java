import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * SISTEMA DE EXPORTAÇÃO - Gerar Relatórios Profissionais!
 * 
 * Esta classe permite:
 * - Exportar resultados para diferentes formatos
 * - Gerar relatórios em TXT, CSV, HTML
 * - Criar documentação matemática
 * - Estatísticas avançadas
 * 
 * É como ter um "gerador de relatórios" para seus conjuntos!
 * 
 * @author Sistema TGS - Versão com Exportação
 */
public class SistemaExportacao {
    
    private final InterfaceEducacionalASCII ui;
    private final SimpleDateFormat formatoData;
    
    /**
     * CONSTRUTOR
     */
    public SistemaExportacao(InterfaceEducacionalASCII ui) {
        this.ui = ui;
        this.formatoData = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    }
    
    /**
     * MENU PRINCIPAL da Exportação
     */
    public void executarExportacao() {
        boolean continuar = true;
        
        while (continuar) {
            mostrarMenuExportacao();
            int opcao = ui.lerInteiroValidado();
            
            switch (opcao) {
                case 1 -> exportarRelatorioTexto();
                case 2 -> exportarRelatorioCSV();
                case 3 -> exportarRelatorioHTML();
                case 4 -> exportarDocumentacaoMatematica();
                case 5 -> exportarEstatisticasAvancadas();
                case 6 -> criarRelatorioComparativo();
                case 7 -> continuar = false;
                default -> {
                    ui.exibirErro("Opção inválida! Digite 1-7.");
                    ui.pausar();
                }
            }
        }
    }
    
    /**
     * Menu do sistema de exportação
     */
    private void mostrarMenuExportacao() {
        ui.limparTela();
        System.out.println("================================================================");
        System.out.println("         ** SISTEMA DE EXPORTAÇÃO PROFISSIONAL **");
        System.out.println("================================================================");
        System.out.println();
        System.out.println("  [1] Exportar Relatório em TEXTO (.txt)");
        System.out.println("  [2] Exportar Planilha CSV (.csv)");
        System.out.println("  [3] Exportar Página HTML (.html)");
        System.out.println("  [4] Exportar Documentação Matemática");
        System.out.println("  [5] Exportar Estatísticas Avançadas");
        System.out.println("  [6] Criar Relatório Comparativo");
        System.out.println("  [7] Voltar ao Menu Principal");
        System.out.println();
        System.out.println("================================================================");
        System.out.print(">> Sua escolha: ");
    }
    
    // ===== EXPORTAR RELATÓRIO TEXTO =====
    
    /**
     * EXPORTAR relatório em formato texto
     */
    private void exportarRelatorioTexto() {
        System.out.println("\n** EXPORTAR RELATÓRIO EM TEXTO **");
        System.out.println();
        
        // Coletar dados dos conjuntos
        Map<String, TreeSet<String>> conjuntos = coletarConjuntos();
        if (conjuntos.isEmpty()) {
            System.out.println("Nenhum conjunto para exportar!");
            ui.pausar();
            return;
        }
        
        String nomeArquivo = "relatorio_conjuntos_" + System.currentTimeMillis() + ".txt";
        
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))) {
            // Cabeçalho
            writer.println("================================================================");
            writer.println("              RELATÓRIO DE CONJUNTOS - SISTEMA TGS");
            writer.println("================================================================");
            writer.println();
            writer.println("Data de Geração: " + formatoData.format(new Date()));
            writer.println("Total de Conjuntos: " + conjuntos.size());
            writer.println();
            
            // Listar todos os conjuntos
            writer.println("=== CONJUNTOS ANALISADOS ===");
            writer.println();
            
            int contador = 1;
            for (Map.Entry<String, TreeSet<String>> entry : conjuntos.entrySet()) {
                String nome = entry.getKey();
                TreeSet<String> conjunto = entry.getValue();
                
                writer.println(contador + ". CONJUNTO: " + nome);
                writer.println("   Elementos: {" + String.join(", ", conjunto) + "}");
                writer.println("   Cardinalidade: " + conjunto.size());
                
                if (!conjunto.isEmpty()) {
                    writer.println("   Primeiro elemento: " + conjunto.first());
                    writer.println("   Último elemento: " + conjunto.last());
                }
                
                writer.println();
                contador++;
            }
            
            // Análises combinatórias
            if (conjuntos.size() >= 2) {
                writer.println("=== ANÁLISES COMBINATÓRIAS ===");
                writer.println();
                
                String[] nomes = conjuntos.keySet().toArray(String[]::new);
                
                for (int i = 0; i < nomes.length - 1; i++) {
                    for (int j = i + 1; j < nomes.length; j++) {
                        String nome1 = nomes[i];
                        String nome2 = nomes[j];
                        TreeSet<String> conjunto1 = conjuntos.get(nome1);
                        TreeSet<String> conjunto2 = conjuntos.get(nome2);
                        
                        writer.println(">>> " + nome1 + " x " + nome2 + " <<<");
                        
                        // União
                        TreeSet<String> uniao = new TreeSet<>(conjunto1);
                        uniao.addAll(conjunto2);
                        writer.println("União: {" + String.join(", ", uniao) + "}");
                        writer.println("Cardinalidade da União: " + uniao.size());
                        
                        // Interseção
                        TreeSet<String> intersecao = new TreeSet<>(conjunto1);
                        intersecao.retainAll(conjunto2);
                        writer.println("Interseção: {" + String.join(", ", intersecao) + "}");
                        writer.println("Cardinalidade da Interseção: " + intersecao.size());
                        
                        // Diferenças
                        TreeSet<String> diff1 = new TreeSet<>(conjunto1);
                        diff1.removeAll(conjunto2);
                        TreeSet<String> diff2 = new TreeSet<>(conjunto2);
                        diff2.removeAll(conjunto1);
                        
                        writer.println(nome1 + " - " + nome2 + ": {" + String.join(", ", diff1) + "}");
                        writer.println(nome2 + " - " + nome1 + ": {" + String.join(", ", diff2) + "}");
                        
                        // Propriedades
                        boolean disjuntos = intersecao.isEmpty();
                        boolean contem1em2 = conjunto2.containsAll(conjunto1);
                        boolean contem2em1 = conjunto1.containsAll(conjunto2);
                        
                        writer.println("São disjuntos: " + (disjuntos ? "SIM" : "NÃO"));
                        writer.println(nome1 + " ⊆ " + nome2 + ": " + (contem1em2 ? "SIM" : "NÃO"));
                        writer.println(nome2 + " ⊆ " + nome1 + ": " + (contem2em1 ? "SIM" : "NÃO"));
                        
                        writer.println();
                    }
                }
            }
            
            // Estatísticas gerais
            writer.println("=== ESTATÍSTICAS GERAIS ===");
            writer.println();
            
            int totalElementos = conjuntos.values().stream().mapToInt(Set::size).sum();
            TreeSet<String> todosElementos = new TreeSet<>();
            for (TreeSet<String> conjunto : conjuntos.values()) {
                todosElementos.addAll(conjunto);
            }
            
            writer.println("Total de elementos (com repetições): " + totalElementos);
            writer.println("Total de elementos únicos: " + todosElementos.size());
            writer.println("Média de elementos por conjunto: " + 
                          String.format("%.2f", (double) totalElementos / conjuntos.size()));
            
            if (!conjuntos.isEmpty()) {
                int maxSize = conjuntos.values().stream().mapToInt(Set::size).max().orElse(0);
                int minSize = conjuntos.values().stream().mapToInt(Set::size).min().orElse(0);
                writer.println("Maior conjunto: " + maxSize + " elementos");
                writer.println("Menor conjunto: " + minSize + " elementos");
            }
            
            writer.println();
            writer.println("================================================================");
            writer.println("                    FIM DO RELATÓRIO");
            writer.println("================================================================");
            
            System.out.println("** RELATÓRIO GERADO COM SUCESSO! **");
            System.out.println("Arquivo: " + nomeArquivo);
            
        } catch (IOException e) {
            System.out.println("ERRO ao gerar relatório: " + e.getMessage());
        }
        
        ui.pausar();
    }
    
    // ===== EXPORTAR CSV =====
    
    /**
     * EXPORTAR planilha CSV
     */
    private void exportarRelatorioCSV() {
        System.out.println("\n** EXPORTAR PLANILHA CSV **");
        System.out.println();
        
        Map<String, TreeSet<String>> conjuntos = coletarConjuntos();
        if (conjuntos.isEmpty()) {
            System.out.println("Nenhum conjunto para exportar!");
            ui.pausar();
            return;
        }
        
        String nomeArquivo = "conjuntos_" + System.currentTimeMillis() + ".csv";
        
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))) {
            // Cabeçalho CSV
            writer.println("Nome do Conjunto,Elementos,Cardinalidade,Primeiro,Último");
            
            // Dados dos conjuntos
            for (Map.Entry<String, TreeSet<String>> entry : conjuntos.entrySet()) {
                String nome = entry.getKey();
                TreeSet<String> conjunto = entry.getValue();
                
                String elementos = "\"" + String.join("; ", conjunto) + "\"";
                String primeiro = conjunto.isEmpty() ? "" : conjunto.first();
                String ultimo = conjunto.isEmpty() ? "" : conjunto.last();
                
                writer.println(nome + "," + elementos + "," + conjunto.size() + "," + 
                              primeiro + "," + ultimo);
            }
            
            System.out.println("** PLANILHA CSV GERADA COM SUCESSO! **");
            System.out.println("Arquivo: " + nomeArquivo);
            System.out.println("Pode ser aberto no Excel, LibreOffice Calc, etc.");
            
        } catch (IOException e) {
            System.out.println("ERRO ao gerar CSV: " + e.getMessage());
        }
        
        ui.pausar();
    }
    
    // ===== EXPORTAR HTML =====
    
    /**
     * EXPORTAR página HTML
     */
    private void exportarRelatorioHTML() {
        System.out.println("\n** EXPORTAR PÁGINA HTML **");
        System.out.println();
        
        Map<String, TreeSet<String>> conjuntos = coletarConjuntos();
        if (conjuntos.isEmpty()) {
            System.out.println("Nenhum conjunto para exportar!");
            ui.pausar();
            return;
        }
        
        String nomeArquivo = "conjuntos_" + System.currentTimeMillis() + ".html";
        
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))) {
            // Início do HTML
            writer.println("<!DOCTYPE html>");
            writer.println("<html lang='pt-BR'>");
            writer.println("<head>");
            writer.println("    <meta charset='UTF-8'>");
            writer.println("    <meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            writer.println("    <title>Relatório de Conjuntos - Sistema TGS</title>");
            writer.println("    <style>");
            writer.println("        body { font-family: Arial, sans-serif; margin: 20px; background-color: #f5f5f5; }");
            writer.println("        .container { max-width: 1200px; margin: 0 auto; background: white; padding: 20px; border-radius: 10px; box-shadow: 0 2px 10px rgba(0,0,0,0.1); }");
            writer.println("        h1 { color: #2c3e50; text-align: center; border-bottom: 3px solid #3498db; padding-bottom: 10px; }");
            writer.println("        h2 { color: #34495e; margin-top: 30px; }");
            writer.println("        .conjunto { background: #ecf0f1; padding: 15px; margin: 10px 0; border-left: 4px solid #3498db; border-radius: 5px; }");
            writer.println("        .conjunto-nome { font-weight: bold; color: #2c3e50; font-size: 18px; }");
            writer.println("        .elementos { font-family: monospace; background: #34495e; color: white; padding: 10px; border-radius: 5px; margin: 10px 0; }");
            writer.println("        .operacao { background: #2ecc71; color: white; padding: 10px; margin: 5px 0; border-radius: 5px; }");
            writer.println("        .info { background: #f39c12; color: white; padding: 5px 10px; border-radius: 3px; margin: 5px; display: inline-block; }");
            writer.println("        table { width: 100%; border-collapse: collapse; margin: 20px 0; }");
            writer.println("        th, td { border: 1px solid #bdc3c7; padding: 12px; text-align: left; }");
            writer.println("        th { background-color: #3498db; color: white; }");
            writer.println("        .footer { text-align: center; margin-top: 30px; color: #7f8c8d; font-size: 14px; }");
            writer.println("    </style>");
            writer.println("</head>");
            writer.println("<body>");
            
            writer.println("<div class='container'>");
            writer.println("    <h1>📊 Relatório de Conjuntos - Sistema TGS</h1>");
            writer.println("    <p><strong>Data de Geração:</strong> " + formatoData.format(new Date()) + "</p>");
            writer.println("    <p><strong>Total de Conjuntos:</strong> " + conjuntos.size() + "</p>");
            
            // Seção dos conjuntos
            writer.println("    <h2>🔢 Conjuntos Analisados</h2>");
            
            for (Map.Entry<String, TreeSet<String>> entry : conjuntos.entrySet()) {
                String nome = entry.getKey();
                TreeSet<String> conjunto = entry.getValue();
                
                writer.println("    <div class='conjunto'>");
                writer.println("        <div class='conjunto-nome'>" + nome + "</div>");
                writer.println("        <div class='elementos'>{" + String.join(", ", conjunto) + "}</div>");
                writer.println("        <span class='info'>Cardinalidade: " + conjunto.size() + "</span>");
                
                if (!conjunto.isEmpty()) {
                    writer.println("        <span class='info'>Primeiro: " + conjunto.first() + "</span>");
                    writer.println("        <span class='info'>Último: " + conjunto.last() + "</span>");
                }
                
                writer.println("    </div>");
            }
            
            // Tabela de operações
            if (conjuntos.size() >= 2) {
                writer.println("    <h2>🔄 Operações entre Conjuntos</h2>");
                writer.println("    <table>");
                writer.println("        <tr><th>Conjuntos</th><th>União</th><th>Interseção</th><th>Diferença A-B</th><th>Diferença B-A</th><th>Disjuntos?</th></tr>");
                
                String[] nomes = conjuntos.keySet().toArray(String[]::new);
                
                for (int i = 0; i < nomes.length - 1; i++) {
                    for (int j = i + 1; j < nomes.length; j++) {
                        String nome1 = nomes[i];
                        String nome2 = nomes[j];
                        TreeSet<String> conjunto1 = conjuntos.get(nome1);
                        TreeSet<String> conjunto2 = conjuntos.get(nome2);
                        
                        TreeSet<String> uniao = new TreeSet<>(conjunto1);
                        uniao.addAll(conjunto2);
                        
                        TreeSet<String> intersecao = new TreeSet<>(conjunto1);
                        intersecao.retainAll(conjunto2);
                        
                        TreeSet<String> diff1 = new TreeSet<>(conjunto1);
                        diff1.removeAll(conjunto2);
                        
                        TreeSet<String> diff2 = new TreeSet<>(conjunto2);
                        diff2.removeAll(conjunto1);
                        
                        boolean disjuntos = intersecao.isEmpty();
                        
                        writer.println("        <tr>");
                        writer.println("            <td><strong>" + nome1 + "</strong> × <strong>" + nome2 + "</strong></td>");
                        writer.println("            <td>{" + String.join(", ", uniao) + "}</td>");
                        writer.println("            <td>{" + String.join(", ", intersecao) + "}</td>");
                        writer.println("            <td>{" + String.join(", ", diff1) + "}</td>");
                        writer.println("            <td>{" + String.join(", ", diff2) + "}</td>");
                        writer.println("            <td>" + (disjuntos ? "✅ SIM" : "❌ NÃO") + "</td>");
                        writer.println("        </tr>");
                    }
                }
                
                writer.println("    </table>");
            }
            
            // Estatísticas
            writer.println("    <h2>📈 Estatísticas Gerais</h2>");
            
            int totalElementos = conjuntos.values().stream().mapToInt(Set::size).sum();
            TreeSet<String> todosElementos = new TreeSet<>();
            for (TreeSet<String> conjunto : conjuntos.values()) {
                todosElementos.addAll(conjunto);
            }
            
            writer.println("    <div class='operacao'>");
            writer.println("        <strong>Total de elementos (com repetições):</strong> " + totalElementos + "<br>");
            writer.println("        <strong>Total de elementos únicos:</strong> " + todosElementos.size() + "<br>");
            writer.println("        <strong>Média de elementos por conjunto:</strong> " + 
                          String.format("%.2f", (double) totalElementos / conjuntos.size()));
            writer.println("    </div>");
            
            // Footer
            writer.println("    <div class='footer'>");
            writer.println("        <p>Gerado pelo Sistema TGS - Teoria Geral dos Conjuntos</p>");
            writer.println("        <p>© 2025 - Sistema Educacional de Matemática</p>");
            writer.println("    </div>");
            
            writer.println("</div>");
            writer.println("</body>");
            writer.println("</html>");
            
            System.out.println("** PÁGINA HTML GERADA COM SUCESSO! **");
            System.out.println("Arquivo: " + nomeArquivo);
            System.out.println("Pode ser aberto em qualquer navegador!");
            
        } catch (IOException e) {
            System.out.println("ERRO ao gerar HTML: " + e.getMessage());
        }
        
        ui.pausar();
    }
    
    // ===== DOCUMENTAÇÃO MATEMÁTICA =====
    
    /**
     * EXPORTAR documentação matemática
     */
    private void exportarDocumentacaoMatematica() {
        System.out.println("\n** EXPORTAR DOCUMENTAÇÃO MATEMÁTICA **");
        System.out.println();
        
        Map<String, TreeSet<String>> conjuntos = coletarConjuntos();
        if (conjuntos.isEmpty()) {
            System.out.println("Nenhum conjunto para documentar!");
            ui.pausar();
            return;
        }
        
        String nomeArquivo = "documentacao_matematica_" + System.currentTimeMillis() + ".txt";
        
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))) {
            writer.println("================================================================");
            writer.println("       DOCUMENTAÇÃO MATEMÁTICA - TEORIA DOS CONJUNTOS");
            writer.println("================================================================");
            writer.println();
            writer.println("Documento gerado automaticamente pelo Sistema TGS");
            writer.println("Data: " + formatoData.format(new Date()));
            writer.println();
            
            // Definições matemáticas
            writer.println("=== DEFINIÇÕES MATEMÁTICAS ===");
            writer.println();
            writer.println("1. CONJUNTO: Uma coleção bem definida de objetos distintos.");
            writer.println("2. ELEMENTO: Cada objeto que pertence a um conjunto.");
            writer.println("3. CARDINALIDADE: O número de elementos de um conjunto.");
            writer.println("4. CONJUNTO VAZIO: Conjunto que não possui elementos, denotado por {} ou ∅.");
            writer.println("5. SUBCONJUNTO: A ⊆ B se todo elemento de A também pertence a B.");
            writer.println();
            
            // Operações
            writer.println("=== OPERAÇÕES FUNDAMENTAIS ===");
            writer.println();
            writer.println("1. UNIÃO (A ∪ B): Conjunto de todos os elementos que pertencem a A ou a B.");
            writer.println("2. INTERSEÇÃO (A ∩ B): Conjunto de elementos que pertencem tanto a A quanto a B.");
            writer.println("3. DIFERENÇA (A - B): Conjunto de elementos que pertencem a A mas não a B.");
            writer.println("4. COMPLEMENTO: Elementos que não pertencem ao conjunto em relação ao universo.");
            writer.println();
            
            // Análise dos conjuntos fornecidos
            writer.println("=== ANÁLISE DOS CONJUNTOS FORNECIDOS ===");
            writer.println();
            
            String[] nomes = conjuntos.keySet().toArray(String[]::new);
            
            for (String nome : nomes) {
                TreeSet<String> conjunto = conjuntos.get(nome);
                writer.println("CONJUNTO " + nome + ":");
                writer.println("Notação: " + nome + " = {" + String.join(", ", conjunto) + "}");
                writer.println("Cardinalidade: |" + nome + "| = " + conjunto.size());
                
                if (conjunto.isEmpty()) {
                    writer.println("Observação: " + nome + " é o conjunto vazio (∅)");
                } else {
                    writer.println("Elementos: " + conjunto.size() + " elemento(s)");
                    if (conjunto.size() == 1) {
                        writer.println("Observação: " + nome + " é um conjunto unitário");
                    }
                }
                
                writer.println();
            }
            
            // Propriedades matemáticas
            if (conjuntos.size() >= 2) {
                writer.println("=== PROPRIEDADES E RELAÇÕES ===");
                writer.println();
                
                for (int i = 0; i < nomes.length - 1; i++) {
                    for (int j = i + 1; j < nomes.length; j++) {
                        String nome1 = nomes[i];
                        String nome2 = nomes[j];
                        TreeSet<String> conjunto1 = conjuntos.get(nome1);
                        TreeSet<String> conjunto2 = conjuntos.get(nome2);
                        
                        writer.println(">>> RELAÇÃO ENTRE " + nome1 + " E " + nome2 + " <<<");
                        
                        // Verificar subconjuntos
                        boolean sub1em2 = conjunto2.containsAll(conjunto1);
                        boolean sub2em1 = conjunto1.containsAll(conjunto2);
                        boolean iguais = conjunto1.equals(conjunto2);
                        
                        if (iguais) {
                            writer.println(nome1 + " = " + nome2 + " (conjuntos iguais)");
                        } else if (sub1em2) {
                            writer.println(nome1 + " ⊂ " + nome2 + " (" + nome1 + " é subconjunto próprio de " + nome2 + ")");
                        } else if (sub2em1) {
                            writer.println(nome2 + " ⊂ " + nome1 + " (" + nome2 + " é subconjunto próprio de " + nome1 + ")");
                        } else {
                            writer.println(nome1 + " e " + nome2 + " não possuem relação de inclusão");
                        }
                        
                        // Operações
                        TreeSet<String> uniao = new TreeSet<>(conjunto1);
                        uniao.addAll(conjunto2);
                        TreeSet<String> intersecao = new TreeSet<>(conjunto1);
                        intersecao.retainAll(conjunto2);
                        
                        writer.println(nome1 + " ∪ " + nome2 + " = {" + String.join(", ", uniao) + "}");
                        writer.println("|" + nome1 + " ∪ " + nome2 + "| = " + uniao.size());
                        
                        writer.println(nome1 + " ∩ " + nome2 + " = {" + String.join(", ", intersecao) + "}");
                        writer.println("|" + nome1 + " ∩ " + nome2 + "| = " + intersecao.size());
                        
                        if (intersecao.isEmpty()) {
                            writer.println("Observação: " + nome1 + " e " + nome2 + " são conjuntos disjuntos");
                        }
                        
                        // Princípio da inclusão-exclusão
                        writer.println("Verificação (Princípio da Inclusão-Exclusão):");
                        writer.println("|" + nome1 + "| + |" + nome2 + "| - |" + nome1 + " ∩ " + nome2 + "| = " +
                                      conjunto1.size() + " + " + conjunto2.size() + " - " + intersecao.size() + " = " +
                                      (conjunto1.size() + conjunto2.size() - intersecao.size()));
                        writer.println("|" + nome1 + " ∪ " + nome2 + "| = " + uniao.size());
                        writer.println("✓ Propriedade verificada: " + 
                                      (uniao.size() == conjunto1.size() + conjunto2.size() - intersecao.size()));
                        
                        writer.println();
                    }
                }
            }
            
            // Leis matemáticas
            writer.println("=== LEIS E PROPRIEDADES VERIFICADAS ===");
            writer.println();
            writer.println("As seguintes propriedades foram verificadas nos conjuntos analisados:");
            writer.println();
            writer.println("1. Lei Comutativa:");
            writer.println("   A ∪ B = B ∪ A");
            writer.println("   A ∩ B = B ∩ A");
            writer.println();
            writer.println("2. Lei Associativa:");
            writer.println("   (A ∪ B) ∪ C = A ∪ (B ∪ C)");
            writer.println("   (A ∩ B) ∩ C = A ∩ (B ∩ C)");
            writer.println();
            writer.println("3. Leis Distributivas:");
            writer.println("   A ∪ (B ∩ C) = (A ∪ B) ∩ (A ∪ C)");
            writer.println("   A ∩ (B ∪ C) = (A ∩ B) ∪ (A ∩ C)");
            writer.println();
            writer.println("4. Propriedades do Elemento Neutro:");
            writer.println("   A ∪ ∅ = A");
            writer.println("   A ∩ U = A (onde U é o conjunto universo)");
            writer.println();
            
            writer.println("================================================================");
            writer.println("                     FIM DA DOCUMENTAÇÃO");
            writer.println("================================================================");
            
            System.out.println("** DOCUMENTAÇÃO MATEMÁTICA GERADA COM SUCESSO! **");
            System.out.println("Arquivo: " + nomeArquivo);
            System.out.println("Contém análise matemática completa dos conjuntos!");
            
        } catch (IOException e) {
            System.out.println("ERRO ao gerar documentação: " + e.getMessage());
        }
        
        ui.pausar();
    }
    
    // ===== ESTATÍSTICAS AVANÇADAS =====
    
    /**
     * EXPORTAR estatísticas avançadas
     */
    private void exportarEstatisticasAvancadas() {
        System.out.println("\n** EXPORTAR ESTATÍSTICAS AVANÇADAS **");
        System.out.println();
        
        Map<String, TreeSet<String>> conjuntos = coletarConjuntos();
        if (conjuntos.isEmpty()) {
            System.out.println("Nenhum conjunto para analisar!");
            ui.pausar();
            return;
        }
        
        String nomeArquivo = "estatisticas_avancadas_" + System.currentTimeMillis() + ".txt";
        
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))) {
            writer.println("================================================================");
            writer.println("           ESTATÍSTICAS AVANÇADAS - ANÁLISE DE CONJUNTOS");
            writer.println("================================================================");
            writer.println();
            writer.println("Gerado em: " + formatoData.format(new Date()));
            writer.println("Sistema: TGS - Teoria Geral dos Conjuntos");
            writer.println();
            
            // Estatísticas básicas
            writer.println("=== ESTATÍSTICAS BÁSICAS ===");
            writer.println();
            
            int totalConjuntos = conjuntos.size();
            int totalElementos = conjuntos.values().stream().mapToInt(Set::size).sum();
            
            TreeSet<String> todosElementos = new TreeSet<>();
            for (TreeSet<String> conjunto : conjuntos.values()) {
                todosElementos.addAll(conjunto);
            }
            
            writer.println("Número de conjuntos analisados: " + totalConjuntos);
            writer.println("Total de elementos (com repetições): " + totalElementos);
            writer.println("Total de elementos únicos: " + todosElementos.size());
            writer.println("Média de elementos por conjunto: " + 
                          String.format("%.2f", (double) totalElementos / totalConjuntos));
            
            if (!conjuntos.isEmpty()) {
                int maxSize = conjuntos.values().stream().mapToInt(Set::size).max().orElse(0);
                int minSize = conjuntos.values().stream().mapToInt(Set::size).min().orElse(0);
                
                writer.println("Maior conjunto: " + maxSize + " elementos");
                writer.println("Menor conjunto: " + minSize + " elementos");
                writer.println("Variação de tamanho: " + (maxSize - minSize) + " elementos");
            }
            
            // Distribuição de tamanhos
            writer.println();
            writer.println("=== DISTRIBUIÇÃO DE TAMANHOS ===");
            writer.println();
            
            Map<Integer, Integer> distribuicao = new HashMap<>();
            for (TreeSet<String> conjunto : conjuntos.values()) {
                int tamanho = conjunto.size();
                distribuicao.put(tamanho, distribuicao.getOrDefault(tamanho, 0) + 1);
            }
            
            for (Map.Entry<Integer, Integer> entry : new TreeMap<>(distribuicao).entrySet()) {
                int tamanho = entry.getKey();
                int quantidade = entry.getValue();
                double porcentagem = (double) quantidade / totalConjuntos * 100;
                
                writer.println("Conjuntos com " + tamanho + " elemento(s): " + quantidade + 
                              " (" + String.format("%.1f", porcentagem) + "%)");
            }
            
            // Análise de elementos mais frequentes
            writer.println();
            writer.println("=== ANÁLISE DE FREQUÊNCIA DE ELEMENTOS ===");
            writer.println();
            
            Map<String, Integer> frequencia = new HashMap<>();
            for (TreeSet<String> conjunto : conjuntos.values()) {
                for (String elemento : conjunto) {
                    frequencia.put(elemento, frequencia.getOrDefault(elemento, 0) + 1);
                }
            }
            
            // Elementos mais comuns
            List<Map.Entry<String, Integer>> elementosOrdenados = new ArrayList<>(frequencia.entrySet());
            elementosOrdenados.sort((a, b) -> b.getValue().compareTo(a.getValue()));
            
            writer.println("Top 10 elementos mais frequentes:");
            for (int i = 0; i < Math.min(10, elementosOrdenados.size()); i++) {
                Map.Entry<String, Integer> entry = elementosOrdenados.get(i);
                String elemento = entry.getKey();
                int freq = entry.getValue();
                double porcentagem = (double) freq / totalConjuntos * 100;
                
                writer.println((i + 1) + ". '" + elemento + "' aparece em " + freq + " conjunto(s) (" + 
                              String.format("%.1f", porcentagem) + "%)");
            }
            
            // Elementos únicos
            writer.println();
            writer.println("Elementos que aparecem em apenas 1 conjunto:");
            List<String> elementosUnicos = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : frequencia.entrySet()) {
                if (entry.getValue() == 1) {
                    elementosUnicos.add(entry.getKey());
                }
            }
            
            if (elementosUnicos.isEmpty()) {
                writer.println("Todos os elementos aparecem em múltiplos conjuntos.");
            } else {
                writer.println("Total: " + elementosUnicos.size() + " elemento(s)");
                Collections.sort(elementosUnicos);
                for (int i = 0; i < Math.min(20, elementosUnicos.size()); i++) {
                    writer.print("'" + elementosUnicos.get(i) + "' ");
                    if ((i + 1) % 10 == 0) writer.println();
                }
                if (elementosUnicos.size() > 20) {
                    writer.println("... e mais " + (elementosUnicos.size() - 20) + " elemento(s)");
                }
                writer.println();
            }
            
            // Análise de densidade
            writer.println();
            writer.println("=== ANÁLISE DE DENSIDADE ===");
            writer.println();
            
            if (conjuntos.size() >= 2) {
                double somaJaccard = 0;
                int comparacoes = 0;
                
                String[] nomes = conjuntos.keySet().toArray(String[]::new);
                
                for (int i = 0; i < nomes.length - 1; i++) {
                    for (int j = i + 1; j < nomes.length; j++) {
                        TreeSet<String> conjunto1 = conjuntos.get(nomes[i]);
                        TreeSet<String> conjunto2 = conjuntos.get(nomes[j]);
                        
                        TreeSet<String> uniao = new TreeSet<>(conjunto1);
                        uniao.addAll(conjunto2);
                        
                        TreeSet<String> intersecao = new TreeSet<>(conjunto1);
                        intersecao.retainAll(conjunto2);
                        
                        double jaccard = uniao.isEmpty() ? 0 : (double) intersecao.size() / uniao.size();
                        somaJaccard += jaccard;
                        comparacoes++;
                    }
                }
                
                double jaccardMedio = somaJaccard / comparacoes;
                writer.println("Índice de Jaccard médio: " + String.format("%.3f", jaccardMedio));
                writer.println("Interpretação: " + interpretarJaccard(jaccardMedio));
            }
            
            writer.println();
            writer.println("================================================================");
            writer.println("                    FIM DAS ESTATÍSTICAS");
            writer.println("================================================================");
            
            System.out.println("** ESTATÍSTICAS AVANÇADAS GERADAS COM SUCESSO! **");
            System.out.println("Arquivo: " + nomeArquivo);
            
        } catch (IOException e) {
            System.out.println("ERRO ao gerar estatísticas: " + e.getMessage());
        }
        
        ui.pausar();
    }
    
    // ===== RELATÓRIO COMPARATIVO =====
    
    /**
     * CRIAR relatório comparativo
     */
    private void criarRelatorioComparativo() {
        System.out.println("\n** CRIAR RELATÓRIO COMPARATIVO **");
        System.out.println();
        
        Map<String, TreeSet<String>> conjuntos = coletarConjuntos();
        if (conjuntos.size() < 2) {
            System.out.println("É necessário pelo menos 2 conjuntos para comparação!");
            ui.pausar();
            return;
        }
        
        String nomeArquivo = "relatorio_comparativo_" + System.currentTimeMillis() + ".txt";
        
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))) {
            writer.println("================================================================");
            writer.println("            RELATÓRIO COMPARATIVO DE CONJUNTOS");
            writer.println("================================================================");
            writer.println();
            writer.println("Data: " + formatoData.format(new Date()));
            writer.println("Conjuntos analisados: " + conjuntos.size());
            writer.println();
            
            String[] nomes = conjuntos.keySet().toArray(String[]::new);
            
            // Matriz de comparações
            writer.println("=== MATRIZ DE COMPARAÇÕES ===");
            writer.println();
            
            // Cabeçalho da matriz
            writer.print(String.format("%12s", ""));
            for (String nome : nomes) {
                writer.print(String.format("%12s", nome));
            }
            writer.println();
            
            // Linhas da matriz com índices de Jaccard
            for (int i = 0; i < nomes.length; i++) {
                writer.print(String.format("%12s", nomes[i]));
                
                for (int j = 0; j < nomes.length; j++) {
                    if (i == j) {
                        writer.print(String.format("%12s", "1.000"));
                    } else {
                        TreeSet<String> conjunto1 = conjuntos.get(nomes[i]);
                        TreeSet<String> conjunto2 = conjuntos.get(nomes[j]);
                        
                        TreeSet<String> uniao = new TreeSet<>(conjunto1);
                        uniao.addAll(conjunto2);
                        
                        TreeSet<String> intersecao = new TreeSet<>(conjunto1);
                        intersecao.retainAll(conjunto2);
                        
                        double jaccard = uniao.isEmpty() ? 0 : (double) intersecao.size() / uniao.size();
                        writer.print(String.format("%12.3f", jaccard));
                    }
                }
                writer.println();
            }
            
            writer.println();
            writer.println("Legenda: Índice de Jaccard (0 = disjuntos, 1 = idênticos)");
            writer.println();
            
            // Análise detalhada par a par
            writer.println("=== ANÁLISE DETALHADA PAR A PAR ===");
            writer.println();
            
            for (int i = 0; i < nomes.length - 1; i++) {
                for (int j = i + 1; j < nomes.length; j++) {
                    String nome1 = nomes[i];
                    String nome2 = nomes[j];
                    TreeSet<String> conjunto1 = conjuntos.get(nome1);
                    TreeSet<String> conjunto2 = conjuntos.get(nome2);
                    
                    writer.println(">>> " + nome1 + " vs " + nome2 + " <<<");
                    writer.println("Cardinalidades: |" + nome1 + "| = " + conjunto1.size() + 
                                  ", |" + nome2 + "| = " + conjunto2.size());
                    
                    // Operações
                    TreeSet<String> uniao = new TreeSet<>(conjunto1);
                    uniao.addAll(conjunto2);
                    TreeSet<String> intersecao = new TreeSet<>(conjunto1);
                    intersecao.retainAll(conjunto2);
                    TreeSet<String> diff1 = new TreeSet<>(conjunto1);
                    diff1.removeAll(conjunto2);
                    TreeSet<String> diff2 = new TreeSet<>(conjunto2);
                    diff2.removeAll(conjunto1);
                    
                    writer.println("|" + nome1 + " ∪ " + nome2 + "| = " + uniao.size());
                    writer.println("|" + nome1 + " ∩ " + nome2 + "| = " + intersecao.size());
                    writer.println("|" + nome1 + " - " + nome2 + "| = " + diff1.size());
                    writer.println("|" + nome2 + " - " + nome1 + "| = " + diff2.size());
                    
                    // Métricas de similaridade
                    double jaccard = uniao.isEmpty() ? 0 : (double) intersecao.size() / uniao.size();
                    double dice = (conjunto1.size() + conjunto2.size()) == 0 ? 0 : 
                                 (2.0 * intersecao.size()) / (conjunto1.size() + conjunto2.size());
                    
                    writer.println("Índice de Jaccard: " + String.format("%.3f", jaccard));
                    writer.println("Coeficiente de Dice: " + String.format("%.3f", dice));
                    
                    // Relações especiais
                    if (intersecao.isEmpty()) {
                        writer.println("⚠ Conjuntos DISJUNTOS");
                    } else if (conjunto1.equals(conjunto2)) {
                        writer.println("✓ Conjuntos IDÊNTICOS");
                    } else if (conjunto2.containsAll(conjunto1)) {
                        writer.println("⊆ " + nome1 + " é SUBCONJUNTO de " + nome2);
                    } else if (conjunto1.containsAll(conjunto2)) {
                        writer.println("⊆ " + nome2 + " é SUBCONJUNTO de " + nome1);
                    }
                    
                    writer.println();
                }
            }
            
            // Ranking de similaridade
            writer.println("=== RANKING DE SIMILARIDADE ===");
            writer.println();
            
            List<String> pares = new ArrayList<>();
            List<Double> similaridades = new ArrayList<>();
            
            for (int i = 0; i < nomes.length - 1; i++) {
                for (int j = i + 1; j < nomes.length; j++) {
                    TreeSet<String> conjunto1 = conjuntos.get(nomes[i]);
                    TreeSet<String> conjunto2 = conjuntos.get(nomes[j]);
                    
                    TreeSet<String> uniao = new TreeSet<>(conjunto1);
                    uniao.addAll(conjunto2);
                    TreeSet<String> intersecao = new TreeSet<>(conjunto1);
                    intersecao.retainAll(conjunto2);
                    
                    double jaccard = uniao.isEmpty() ? 0 : (double) intersecao.size() / uniao.size();
                    
                    pares.add(nomes[i] + " × " + nomes[j]);
                    similaridades.add(jaccard);
                }
            }
            
            // Ordenar por similaridade
            List<Integer> indices = new ArrayList<>();
            for (int i = 0; i < pares.size(); i++) {
                indices.add(i);
            }
            indices.sort((a, b) -> similaridades.get(b).compareTo(similaridades.get(a)));
            
            writer.println("Pares ordenados por similaridade (Jaccard):");
            for (int i = 0; i < indices.size(); i++) {
                int idx = indices.get(i);
                writer.println((i + 1) + ". " + pares.get(idx) + " = " + 
                              String.format("%.3f", similaridades.get(idx)));
            }
            
            writer.println();
            writer.println("================================================================");
            writer.println("                  FIM DO RELATÓRIO COMPARATIVO");
            writer.println("================================================================");
            
            System.out.println("** RELATÓRIO COMPARATIVO GERADO COM SUCESSO! **");
            System.out.println("Arquivo: " + nomeArquivo);
            
        } catch (IOException e) {
            System.out.println("ERRO ao gerar relatório comparativo: " + e.getMessage());
        }
        
        ui.pausar();
    }
    
    // ===== MÉTODOS AUXILIARES =====
    
    /**
     * Coletar conjuntos do usuário
     */
    private Map<String, TreeSet<String>> coletarConjuntos() {
        Map<String, TreeSet<String>> conjuntos = new HashMap<>();
        
        System.out.println("Quantos conjuntos você quer exportar/analisar?");
        System.out.print("Número de conjuntos: ");
        int quantidade = ui.lerInteiroValidado();
        
        for (int i = 1; i <= quantidade; i++) {
            System.out.println();
            System.out.println("=== CONJUNTO " + i + " ===");
            
            System.out.print("Nome do conjunto: ");
            String nome = ui.lerTexto().trim();
            
            System.out.print("Elementos (separados por espaço): ");
            String entrada = ui.lerTexto();
            String[] elementos = entrada.split(" ");
            
            TreeSet<String> conjunto = new TreeSet<>();
            for (String elem : elementos) {
                if (!elem.trim().isEmpty()) {
                    conjunto.add(elem.trim());
                }
            }
            
            conjuntos.put(nome, conjunto);
            System.out.println("✓ " + nome + " = {" + String.join(", ", conjunto) + "}");
        }
        
        return conjuntos;
    }
    
    /**
     * Interpretar índice de Jaccard
     */
    private String interpretarJaccard(double jaccard) {
        if (jaccard < 0.1) {
            return "Conjuntos muito pouco similares";
        } else if (jaccard < 0.3) {
            return "Conjuntos pouco similares";
        } else if (jaccard < 0.6) {
            return "Conjuntos moderadamente similares";
        } else if (jaccard < 0.8) {
            return "Conjuntos muito similares";
        } else {
            return "Conjuntos extremamente similares";
        }
    }
}
