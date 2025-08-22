import java.util.*;

/**
 * ============================================================================
 *                      GERENCIADOR DE CONJUNTOS NOMEADOS
 * ============================================================================
 * 
 * Módulo especializado para gestão avançada de conjuntos com funcionalidades
 * profissionais de persistência, nomenclatura e histórico de operações.
 * 
 * <h3>Funcionalidades Principais:</h3>
 * <ul>
 *   <li>🏷️ Conjuntos nomeados personalizados</li>
 *   <li>💾 Persistência em memória durante a sessão</li>
 *   <li>🔄 Operações entre conjuntos salvos</li>
 *   <li>📋 Histórico completo de operações</li>
 *   <li>🎯 Interface intuitiva de gerenciamento</li>
 * </ul>
 * 
 * @author Sistema TGC - Módulo Conjuntos
 * @version 2.0 - Gestão Profissional
 * @since 2025
 * ============================================================================
 */
public class GerenciadorConjuntos {
    
    // Dicionário para guardar conjuntos com nomes
    private final Map<String, TreeSet<String>> conjuntosSalvos;
    
    // Lista para histórico de operações
    private final List<String> historico;
    
    // Interface para conversar com usuário
    private final InterfaceEducacionalASCII ui;
    
    /**
     * CONSTRUTOR - Inicializa o gerenciador
     */
    public GerenciadorConjuntos(InterfaceEducacionalASCII ui) {
        this.conjuntosSalvos = new HashMap<>();
        this.historico = new ArrayList<>();
        this.ui = ui;
        
        // Criar alguns conjuntos de exemplo
        criarConjuntosExemplo();
    }
    
    /**
     * MENU PRINCIPAL do Gerenciador de Conjuntos
     */
    public void executarGerenciador() {
        boolean continuar = true;
        
        while (continuar) {
            mostrarMenuGerenciador();
            int opcao = ui.lerInteiroValidado();
            
            switch (opcao) {
                case 1:
                    criarNovoConjunto();
                    break;
                case 2:
                    listarConjuntos();
                    break;
                case 3:
                    operarEntreConjuntos();
                    break;
                case 4:
                    verHistorico();
                    break;
                case 5:
                    removerConjunto();
                    break;
                case 6:
                    continuar = false;
                    break;
                default:
                    ui.exibirErro("Opção inválida! Digite 1-6.");
                    ui.pausar();
            }
        }
    }
    
    /**
     * Mostra o menu do gerenciador
     */
    private void mostrarMenuGerenciador() {
        ui.limparTela();
        System.out.println("================================================================");
        System.out.println("          ** GERENCIADOR DE CONJUNTOS AVANÇADO **");
        System.out.println("================================================================");
        System.out.println();
        System.out.println("** CONJUNTOS SALVOS: " + conjuntosSalvos.size());
        System.out.println("** OPERAÇÕES NO HISTÓRICO: " + historico.size());
        System.out.println();
        System.out.println("  [1] Criar Novo Conjunto");
        System.out.println("  [2] Listar Todos os Conjuntos");
        System.out.println("  [3] Fazer Operação entre Conjuntos");
        System.out.println("  [4] Ver Histórico de Operações");
        System.out.println("  [5] Remover Conjunto");
        System.out.println("  [6] Voltar ao Menu Principal");
        System.out.println();
        System.out.println("================================================================");
        System.out.print(">> Sua escolha: ");
    }
    
    /**
     * CRIAR NOVO CONJUNTO - Com nome personalizado
     */
    private void criarNovoConjunto() {
        System.out.println("\n** CRIAR NOVO CONJUNTO **");
        System.out.println();
        
        // Pedir nome
        System.out.print("Digite um nome para seu conjunto: ");
        String nome = ui.lerTexto().trim();
        
        // Verificar se já existe
        if (conjuntosSalvos.containsKey(nome)) {
            System.out.println("ATENÇÃO: Já existe um conjunto com esse nome!");
            System.out.print("Deseja substituir? (s/n): ");
            String resposta = ui.lerTexto().trim().toLowerCase();
            if (!resposta.equals("s")) {
                System.out.println("Operação cancelada.");
                ui.pausar();
                return;
            }
        }
        
        // Pedir elementos
        System.out.print("Digite os elementos (separados por espaço): ");
        String entrada = ui.lerTexto();
        String[] elementos = entrada.split(" ");
        
        // Criar conjunto ordenado
        TreeSet<String> novoConjunto = new TreeSet<>();
        for (String elem : elementos) {
            if (!elem.trim().isEmpty()) {
                novoConjunto.add(elem.trim());
            }
        }
        
        // Salvar
        conjuntosSalvos.put(nome, novoConjunto);
        
        // Mostrar resultado
        System.out.println();
        System.out.println("** CONJUNTO CRIADO COM SUCESSO! **");
        System.out.println(nome + " = {" + String.join(", ", novoConjunto) + "}");
        
        // Adicionar ao histórico
        historico.add("CRIADO: " + nome + " = {" + String.join(", ", novoConjunto) + "}");
        
        ui.pausar();
    }
    
    /**
     * LISTAR TODOS OS CONJUNTOS salvos
     */
    private void listarConjuntos() {
        System.out.println("\n** SEUS CONJUNTOS SALVOS **");
        System.out.println();
        
        if (conjuntosSalvos.isEmpty()) {
            System.out.println("Nenhum conjunto salvo ainda.");
        } else {
            int contador = 1;
            for (Map.Entry<String, TreeSet<String>> entry : conjuntosSalvos.entrySet()) {
                String nome = entry.getKey();
                TreeSet<String> conjunto = entry.getValue();
                System.out.println(contador + ". " + nome + " = {" + String.join(", ", conjunto) + "}");
                contador++;
            }
        }
        
        System.out.println();
        ui.pausar();
    }
    
    /**
     * OPERAR ENTRE CONJUNTOS - União, interseção, diferença
     */
    private void operarEntreConjuntos() {
        if (conjuntosSalvos.size() < 2) {
            System.out.println("\nVocê precisa de pelo menos 2 conjuntos para fazer operações!");
            System.out.println("Crie mais conjuntos primeiro.");
            ui.pausar();
            return;
        }
        
        System.out.println("\n** OPERAÇÕES ENTRE CONJUNTOS **");
        System.out.println();
        
        // Listar conjuntos disponíveis
        System.out.println("Conjuntos disponíveis:");
        String[] nomes = conjuntosSalvos.keySet().toArray(String[]::new);
        for (int i = 0; i < nomes.length; i++) {
            System.out.println((i + 1) + ". " + nomes[i] + " = {" + String.join(", ", conjuntosSalvos.get(nomes[i])) + "}");
        }
        System.out.println();
        
        // Escolher primeiro conjunto
        System.out.print("Escolha o primeiro conjunto (1-" + nomes.length + "): ");
        int idx1 = ui.lerInteiroValidado() - 1;
        if (idx1 < 0 || idx1 >= nomes.length) {
            System.out.println("Índice inválido!");
            ui.pausar();
            return;
        }
        
        // Escolher segundo conjunto
        System.out.print("Escolha o segundo conjunto (1-" + nomes.length + "): ");
        int idx2 = ui.lerInteiroValidado() - 1;
        if (idx2 < 0 || idx2 >= nomes.length) {
            System.out.println("Índice inválido!");
            ui.pausar();
            return;
        }
        
        String nome1 = nomes[idx1];
        String nome2 = nomes[idx2];
        TreeSet<String> conjunto1 = conjuntosSalvos.get(nome1);
        TreeSet<String> conjunto2 = conjuntosSalvos.get(nome2);
        
        // Escolher operação
        System.out.println();
        System.out.println("Que operação fazer?");
        System.out.println("[1] " + nome1 + " U " + nome2 + " (União)");
        System.out.println("[2] " + nome1 + " INT " + nome2 + " (Interseção)");
        System.out.println("[3] " + nome1 + " - " + nome2 + " (Diferença)");
        System.out.println("[4] Todas as operações");
        System.out.print(">> Escolha: ");
        
        int opcao = ui.lerInteiroValidado();
        System.out.println();
        
        switch (opcao) {
            case 1:
                calcularUniaoNomeada(nome1, conjunto1, nome2, conjunto2);
                break;
            case 2:
                calcularIntersecaoNomeada(nome1, conjunto1, nome2, conjunto2);
                break;
            case 3:
                calcularDiferencaNomeada(nome1, conjunto1, nome2, conjunto2);
                break;
            case 4:
                calcularUniaoNomeada(nome1, conjunto1, nome2, conjunto2);
                calcularIntersecaoNomeada(nome1, conjunto1, nome2, conjunto2);
                calcularDiferencaNomeada(nome1, conjunto1, nome2, conjunto2);
                break;
            default:
                System.out.println("Opção inválida!");
        }
        
        ui.pausar();
    }
    
    /**
     * VER HISTÓRICO de todas as operações
     */
    private void verHistorico() {
        System.out.println("\n** HISTÓRICO DE OPERAÇÕES **");
        System.out.println();
        
        if (historico.isEmpty()) {
            System.out.println("Nenhuma operação realizada ainda.");
        } else {
            for (int i = 0; i < historico.size(); i++) {
                System.out.println((i + 1) + ". " + historico.get(i));
            }
        }
        
        System.out.println();
        ui.pausar();
    }
    
    /**
     * REMOVER CONJUNTO
     */
    private void removerConjunto() {
        if (conjuntosSalvos.isEmpty()) {
            System.out.println("\nNenhum conjunto para remover.");
            ui.pausar();
            return;
        }
        
        System.out.println("\n** REMOVER CONJUNTO **");
        System.out.println();
        
        // Listar conjuntos
        String[] nomes = conjuntosSalvos.keySet().toArray(String[]::new);
        for (int i = 0; i < nomes.length; i++) {
            System.out.println((i + 1) + ". " + nomes[i]);
        }
        
        System.out.print("Qual conjunto remover (1-" + nomes.length + ")? ");
        int idx = ui.lerInteiroValidado() - 1;
        
        if (idx >= 0 && idx < nomes.length) {
            String nomeRemovido = nomes[idx];
            conjuntosSalvos.remove(nomeRemovido);
            historico.add("REMOVIDO: " + nomeRemovido);
            System.out.println("Conjunto '" + nomeRemovido + "' removido!");
        } else {
            System.out.println("Índice inválido!");
        }
        
        ui.pausar();
    }
    
    // ===== OPERAÇÕES COM CONJUNTOS NOMEADOS =====
    
    private void calcularUniaoNomeada(String nome1, TreeSet<String> conjunto1, String nome2, TreeSet<String> conjunto2) {
        TreeSet<String> resultado = new TreeSet<>(conjunto1);
        resultado.addAll(conjunto2);
        
        String operacao = nome1 + " U " + nome2 + " = {" + String.join(", ", resultado) + "}";
        System.out.println("** UNIÃO: " + operacao);
        historico.add("UNIÃO: " + operacao);
    }
    
    private void calcularIntersecaoNomeada(String nome1, TreeSet<String> conjunto1, String nome2, TreeSet<String> conjunto2) {
        TreeSet<String> resultado = new TreeSet<>(conjunto1);
        resultado.retainAll(conjunto2);
        
        String operacao = nome1 + " INT " + nome2 + " = {" + String.join(", ", resultado) + "}";
        System.out.println("** INTERSEÇÃO: " + operacao);
        historico.add("INTERSEÇÃO: " + operacao);
    }
    
    private void calcularDiferencaNomeada(String nome1, TreeSet<String> conjunto1, String nome2, TreeSet<String> conjunto2) {
        TreeSet<String> resultado = new TreeSet<>(conjunto1);
        resultado.removeAll(conjunto2);
        
        String operacao = nome1 + " - " + nome2 + " = {" + String.join(", ", resultado) + "}";
        System.out.println("** DIFERENÇA: " + operacao);
        historico.add("DIFERENÇA: " + operacao);
    }
    
    /**
     * Criar alguns conjuntos de exemplo para demonstração
     */
    private void criarConjuntosExemplo() {
        TreeSet<String> naturais = new TreeSet<>();
        naturais.addAll(Arrays.asList("1", "2", "3", "4", "5"));
        conjuntosSalvos.put("Naturais", naturais);
        
        TreeSet<String> pares = new TreeSet<>();
        pares.addAll(Arrays.asList("2", "4", "6", "8"));
        conjuntosSalvos.put("Pares", pares);
        
        TreeSet<String> vogais = new TreeSet<>();
        vogais.addAll(Arrays.asList("a", "e", "i", "o", "u"));
        conjuntosSalvos.put("Vogais", vogais);
        
        historico.add("SISTEMA: Conjuntos de exemplo criados");
    }
}
