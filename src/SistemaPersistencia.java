import java.io.*;
import java.util.*;

/**
 * SISTEMA DE PERSISTÊNCIA - Salvar e Carregar Conjuntos!
 * 
 * Esta classe permite:
 * - Salvar conjuntos em arquivos
 * - Carregar conjuntos de arquivos
 * - Backup automático
 * - Histórico de operações persistente
 * 
 * É como ter um "banco de dados" para seus conjuntos!
 * 
 * @author Sistema TGS - Versão com Persistência
 */
public class SistemaPersistencia {
    
    private final InterfaceEducacionalASCII ui;
    private final String diretorioConjuntos;
    private final String arquivoHistorico;
    
    /**
     * CONSTRUTOR
     */
    public SistemaPersistencia(InterfaceEducacionalASCII ui) {
        this.ui = ui;
        this.diretorioConjuntos = "conjuntos_salvos";
        this.arquivoHistorico = "historico_operacoes.txt";
        
        // Criar diretório se não existir
        criarDiretorioSeNecessario();
    }
    
    /**
     * MENU PRINCIPAL da Persistência
     */
    public void executarPersistencia() {
        boolean continuar = true;
        
        while (continuar) {
            mostrarMenuPersistencia();
            int opcao = ui.lerInteiroValidado();
            
            switch (opcao) {
                case 1 -> salvarConjunto();
                case 2 -> carregarConjunto();
                case 3 -> listarArquivosSalvos();
                case 4 -> criarBackup();
                case 5 -> verHistoricoPersistente();
                case 6 -> excluirArquivo();
                case 7 -> importarConjuntoDeTexto();
                case 8 -> continuar = false;
                default -> {
                    ui.exibirErro("Opção inválida! Digite 1-8.");
                    ui.pausar();
                }
            }
        }
    }
    
    /**
     * Menu do sistema de persistência
     */
    private void mostrarMenuPersistencia() {
        ui.limparTela();
        System.out.println("================================================================");
        System.out.println("         ** SISTEMA DE PERSISTÊNCIA AVANÇADO **");
        System.out.println("================================================================");
        System.out.println();
        
        // Mostrar info do diretório
        File dir = new File(diretorioConjuntos);
        int arquivos = dir.exists() ? dir.list().length : 0;
        System.out.println("** ARQUIVOS SALVOS: " + arquivos);
        System.out.println("** DIRETÓRIO: " + diretorioConjuntos);
        System.out.println();
        
        System.out.println("  [1] Salvar Conjunto em Arquivo");
        System.out.println("  [2] Carregar Conjunto de Arquivo");
        System.out.println("  [3] Listar Todos os Arquivos Salvos");
        System.out.println("  [4] Criar Backup Completo");
        System.out.println("  [5] Ver Histórico Persistente");
        System.out.println("  [6] Excluir Arquivo");
        System.out.println("  [7] Importar Conjunto de Arquivo Texto");
        System.out.println("  [8] Voltar ao Menu Principal");
        System.out.println();
        System.out.println("================================================================");
        System.out.print(">> Sua escolha: ");
    }
    
    // ===== SALVAR CONJUNTO =====
    
    /**
     * SALVAR CONJUNTO em arquivo
     */
    private void salvarConjunto() {
        System.out.println("\n** SALVAR CONJUNTO EM ARQUIVO **");
        System.out.println();
        
        // Pedir nome do arquivo
        System.out.print("Nome do arquivo (sem extensão): ");
        String nomeArquivo = ui.lerTexto().trim();
        if (nomeArquivo.isEmpty()) {
            System.out.println("Nome inválido!");
            ui.pausar();
            return;
        }
        
        // Pedir nome do conjunto
        System.out.print("Nome do conjunto: ");
        String nomeConjunto = ui.lerTexto().trim();
        
        // Pedir tipo de dados
        System.out.println("Tipo de dados:");
        System.out.println("[1] Números Inteiros");
        System.out.println("[2] Números Decimais");
        System.out.println("[3] Palavras/Texto");
        System.out.print(">> Escolha: ");
        int tipo = ui.lerInteiroValidado();
        
        // Pedir elementos
        System.out.print("Digite os elementos (separados por espaço): ");
        String elementos = ui.lerTexto();
        
        // Criar arquivo
        String nomeCompleto = nomeArquivo + ".conjunto";
        File arquivo = new File(diretorioConjuntos, nomeCompleto);
        
        try (PrintWriter writer = new PrintWriter(new FileWriter(arquivo))) {
            // Cabeçalho do arquivo
            writer.println("# ARQUIVO DE CONJUNTO - Sistema TGS");
            writer.println("# Data: " + new Date());
            writer.println("# Nome: " + nomeConjunto);
            writer.println("# Tipo: " + obterNomeTipo(tipo));
            writer.println();
            
            // Dados do conjunto
            writer.println("NOME=" + nomeConjunto);
            writer.println("TIPO=" + tipo);
            writer.println("ELEMENTOS=" + elementos);
            
            System.out.println();
            System.out.println("** CONJUNTO SALVO COM SUCESSO! **");
            System.out.println("Arquivo: " + arquivo.getAbsolutePath());
            
            // Salvar no histórico
            salvarHistorico("SALVO: " + nomeConjunto + " em " + nomeCompleto);
            
        } catch (IOException e) {
            System.out.println("ERRO ao salvar arquivo: " + e.getMessage());
        }
        
        ui.pausar();
    }
    
    // ===== CARREGAR CONJUNTO =====
    
    /**
     * CARREGAR CONJUNTO de arquivo
     */
    private void carregarConjunto() {
        System.out.println("\n** CARREGAR CONJUNTO DE ARQUIVO **");
        System.out.println();
        
        // Listar arquivos disponíveis
        File dir = new File(diretorioConjuntos);
        if (!dir.exists() || dir.list().length == 0) {
            System.out.println("Nenhum arquivo salvo encontrado!");
            ui.pausar();
            return;
        }
        
        String[] arquivos = dir.list((d, name) -> name.endsWith(".conjunto"));
        if (arquivos.length == 0) {
            System.out.println("Nenhum arquivo de conjunto encontrado!");
            ui.pausar();
            return;
        }
        
        System.out.println("Arquivos disponíveis:");
        for (int i = 0; i < arquivos.length; i++) {
            System.out.println((i + 1) + ". " + arquivos[i]);
        }
        
        System.out.print("Escolha o arquivo (1-" + arquivos.length + "): ");
        int escolha = ui.lerInteiroValidado() - 1;
        
        if (escolha < 0 || escolha >= arquivos.length) {
            System.out.println("Escolha inválida!");
            ui.pausar();
            return;
        }
        
        File arquivo = new File(dir, arquivos[escolha]);
        
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            String nome = "";
            int tipo = 1;
            String elementos = "";
            
            // Ler dados do arquivo
            while ((linha = reader.readLine()) != null) {
                if (linha.startsWith("NOME=")) {
                    nome = linha.substring(5);
                } else if (linha.startsWith("TIPO=")) {
                    tipo = Integer.parseInt(linha.substring(5));
                } else if (linha.startsWith("ELEMENTOS=")) {
                    elementos = linha.substring(10);
                }
            }
            
            // Mostrar informações carregadas
            System.out.println();
            System.out.println("** CONJUNTO CARREGADO COM SUCESSO! **");
            System.out.println("Nome: " + nome);
            System.out.println("Tipo: " + obterNomeTipo(tipo));
            System.out.println("Elementos: " + elementos);
            
            // Processar e mostrar conjunto
            processarConjuntoCarregado(nome, tipo, elementos);
            
            // Salvar no histórico
            salvarHistorico("CARREGADO: " + nome + " de " + arquivos[escolha]);
            
        } catch (IOException | NumberFormatException e) {
            System.out.println("ERRO ao carregar arquivo: " + e.getMessage());
        }
        
        ui.pausar();
    }
    
    /**
     * Processar conjunto carregado conforme o tipo
     */
    private void processarConjuntoCarregado(String nome, int tipo, String elementos) {
        String[] elementosArray = elementos.split(" ");
        
        switch (tipo) {
            case 1: // Inteiros
                TreeSet<Integer> inteiros = new TreeSet<>();
                for (String elem : elementosArray) {
                    try {
                        if (!elem.trim().isEmpty()) {
                            inteiros.add(Integer.parseInt(elem.trim()));
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Elemento inválido ignorado: " + elem);
                    }
                }
                System.out.println(nome + " = " + inteiros);
                break;
                
            case 2: // Decimais
                TreeSet<Double> decimais = new TreeSet<>();
                for (String elem : elementosArray) {
                    try {
                        if (!elem.trim().isEmpty()) {
                            decimais.add(Double.parseDouble(elem.trim()));
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Elemento inválido ignorado: " + elem);
                    }
                }
                System.out.println(nome + " = " + decimais);
                break;
                
            case 3: // Strings
                TreeSet<String> strings = new TreeSet<>();
                for (String elem : elementosArray) {
                    if (!elem.trim().isEmpty()) {
                        strings.add(elem.trim());
                    }
                }
                System.out.println(nome + " = {" + String.join(", ", strings) + "}");
                break;
        }
    }
    
    // ===== LISTAR ARQUIVOS =====
    
    /**
     * LISTAR todos os arquivos salvos
     */
    private void listarArquivosSalvos() {
        System.out.println("\n** ARQUIVOS SALVOS **");
        System.out.println();
        
        File dir = new File(diretorioConjuntos);
        if (!dir.exists()) {
            System.out.println("Diretório de conjuntos não existe ainda.");
            ui.pausar();
            return;
        }
        
        String[] arquivos = dir.list((d, name) -> name.endsWith(".conjunto"));
        
        if (arquivos.length == 0) {
            System.out.println("Nenhum arquivo de conjunto encontrado.");
        } else {
            System.out.println("Total de arquivos: " + arquivos.length);
            System.out.println();
            
            for (int i = 0; i < arquivos.length; i++) {
                File arquivo = new File(dir, arquivos[i]);
                System.out.println((i + 1) + ". " + arquivos[i]);
                System.out.println("   Tamanho: " + arquivo.length() + " bytes");
                System.out.println("   Modificado: " + new Date(arquivo.lastModified()));
                
                // Tentar ler informações básicas
                try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
                    String linha;
                    while ((linha = reader.readLine()) != null) {
                        if (linha.startsWith("# Nome: ")) {
                            System.out.println("   Conjunto: " + linha.substring(8));
                        } else if (linha.startsWith("# Tipo: ")) {
                            System.out.println("   Tipo: " + linha.substring(8));
                        }
                    }
                } catch (IOException e) {
                    System.out.println("   (Erro ao ler detalhes)");
                }
                
                System.out.println();
            }
        }
        
        ui.pausar();
    }
    
    // ===== BACKUP =====
    
    /**
     * CRIAR BACKUP completo
     */
    private void criarBackup() {
        System.out.println("\n** CRIAR BACKUP COMPLETO **");
        System.out.println();
        
        String nomeBackup = "backup_" + System.currentTimeMillis() + ".txt";
        File arquivoBackup = new File(nomeBackup);
        
        try (PrintWriter writer = new PrintWriter(new FileWriter(arquivoBackup))) {
            writer.println("# BACKUP COMPLETO DO SISTEMA TGS");
            writer.println("# Data: " + new Date());
            writer.println("# Gerado automaticamente");
            writer.println();
            
            // Backup de todos os conjuntos
            File dir = new File(diretorioConjuntos);
            if (dir.exists()) {
                String[] arquivos = dir.list((d, name) -> name.endsWith(".conjunto"));
                
                writer.println("=== CONJUNTOS SALVOS ===");
                for (String arquivo : arquivos) {
                    writer.println();
                    writer.println(">>> ARQUIVO: " + arquivo);
                    
                    try (BufferedReader reader = new BufferedReader(new FileReader(new File(dir, arquivo)))) {
                        String linha;
                        while ((linha = reader.readLine()) != null) {
                            writer.println(linha);
                        }
                    } catch (IOException e) {
                        writer.println("ERRO ao ler: " + arquivo);
                    }
                }
            }
            
            // Backup do histórico
            writer.println();
            writer.println("=== HISTÓRICO DE OPERAÇÕES ===");
            File historicoFile = new File(arquivoHistorico);
            if (historicoFile.exists()) {
                try (BufferedReader reader = new BufferedReader(new FileReader(historicoFile))) {
                    String linha;
                    while ((linha = reader.readLine()) != null) {
                        writer.println(linha);
                    }
                } catch (IOException e) {
                    writer.println("ERRO ao ler histórico");
                }
            }
            
            System.out.println("** BACKUP CRIADO COM SUCESSO! **");
            System.out.println("Arquivo: " + arquivoBackup.getAbsolutePath());
            
        } catch (IOException e) {
            System.out.println("ERRO ao criar backup: " + e.getMessage());
        }
        
        ui.pausar();
    }
    
    // ===== HISTÓRICO PERSISTENTE =====
    
    /**
     * VER HISTÓRICO persistente
     */
    private void verHistoricoPersistente() {
        System.out.println("\n** HISTÓRICO PERSISTENTE **");
        System.out.println();
        
        File arquivo = new File(arquivoHistorico);
        if (!arquivo.exists()) {
            System.out.println("Nenhum histórico encontrado ainda.");
            ui.pausar();
            return;
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            int contador = 1;
            
            while ((linha = reader.readLine()) != null) {
                System.out.println(contador + ". " + linha);
                contador++;
            }
            
            if (contador == 1) {
                System.out.println("Histórico está vazio.");
            }
            
        } catch (IOException e) {
            System.out.println("ERRO ao ler histórico: " + e.getMessage());
        }
        
        ui.pausar();
    }
    
    /**
     * SALVAR no histórico persistente
     */
    public void salvarHistorico(String operacao) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(arquivoHistorico, true))) {
            String timestamp = new Date().toString();
            writer.println("[" + timestamp + "] " + operacao);
        } catch (IOException e) {
            // Ignorar erros de histórico para não interromper operação principal
        }
    }
    
    // ===== EXCLUIR ARQUIVO =====
    
    /**
     * EXCLUIR arquivo
     */
    private void excluirArquivo() {
        System.out.println("\n** EXCLUIR ARQUIVO **");
        System.out.println();
        
        File dir = new File(diretorioConjuntos);
        if (!dir.exists() || dir.list().length == 0) {
            System.out.println("Nenhum arquivo para excluir!");
            ui.pausar();
            return;
        }
        
        String[] arquivos = dir.list((d, name) -> name.endsWith(".conjunto"));
        if (arquivos.length == 0) {
            System.out.println("Nenhum arquivo de conjunto encontrado!");
            ui.pausar();
            return;
        }
        
        System.out.println("Arquivos disponíveis:");
        for (int i = 0; i < arquivos.length; i++) {
            System.out.println((i + 1) + ". " + arquivos[i]);
        }
        
        System.out.print("Escolha o arquivo para excluir (1-" + arquivos.length + "): ");
        int escolha = ui.lerInteiroValidado() - 1;
        
        if (escolha < 0 || escolha >= arquivos.length) {
            System.out.println("Escolha inválida!");
            ui.pausar();
            return;
        }
        
        System.out.print("Tem certeza? Esta ação não pode ser desfeita! (s/n): ");
        String confirmacao = ui.lerTexto().trim().toLowerCase();
        
        if (confirmacao.equals("s")) {
            File arquivo = new File(dir, arquivos[escolha]);
            if (arquivo.delete()) {
                System.out.println("Arquivo excluído com sucesso!");
                salvarHistorico("EXCLUÍDO: " + arquivos[escolha]);
            } else {
                System.out.println("ERRO ao excluir arquivo!");
            }
        } else {
            System.out.println("Operação cancelada.");
        }
        
        ui.pausar();
    }
    
    // ===== IMPORTAR DE TEXTO =====
    
    /**
     * IMPORTAR conjunto de arquivo de texto simples
     */
    private void importarConjuntoDeTexto() {
        System.out.println("\n** IMPORTAR CONJUNTO DE ARQUIVO TEXTO **");
        System.out.println();
        
        System.out.print("Digite o nome do arquivo de texto (com extensão): ");
        String nomeArquivo = ui.lerTexto().trim();
        
        File arquivo = new File(nomeArquivo);
        if (!arquivo.exists()) {
            System.out.println("Arquivo não encontrado: " + nomeArquivo);
            ui.pausar();
            return;
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            StringBuilder conteudo = new StringBuilder();
            String linha;
            
            while ((linha = reader.readLine()) != null) {
                conteudo.append(linha).append(" ");
            }
            
            System.out.println("Conteúdo lido: " + conteudo.toString().trim());
            System.out.println();
            
            // Processar como conjunto de palavras
            String[] elementos = conteudo.toString().trim().split("\\s+");
            TreeSet<String> conjunto = new TreeSet<>();
            
            for (String elem : elementos) {
                if (!elem.trim().isEmpty()) {
                    conjunto.add(elem.trim());
                }
            }
            
            System.out.println("Conjunto importado: {" + String.join(", ", conjunto) + "}");
            System.out.println("Total de elementos únicos: " + conjunto.size());
            
            // Opção de salvar
            System.out.print("Deseja salvar este conjunto? (s/n): ");
            String salvar = ui.lerTexto().trim().toLowerCase();
            
            if (salvar.equals("s")) {
                System.out.print("Nome para o conjunto: ");
                String nome = ui.lerTexto().trim();
                
                String nomeArquivoSalvo = nome.replaceAll("\\s+", "_") + ".conjunto";
                File arquivoSalvo = new File(diretorioConjuntos, nomeArquivoSalvo);
                
                try (PrintWriter writer = new PrintWriter(new FileWriter(arquivoSalvo))) {
                    writer.println("# CONJUNTO IMPORTADO - Sistema TGS");
                    writer.println("# Data: " + new Date());
                    writer.println("# Origem: " + nomeArquivo);
                    writer.println("# Nome: " + nome);
                    writer.println("# Tipo: Palavras/Texto");
                    writer.println();
                    writer.println("NOME=" + nome);
                    writer.println("TIPO=3");
                    writer.println("ELEMENTOS=" + String.join(" ", conjunto));
                    
                    System.out.println("Conjunto salvo como: " + nomeArquivoSalvo);
                    salvarHistorico("IMPORTADO: " + nome + " de " + nomeArquivo);
                }
            }
            
        } catch (IOException e) {
            System.out.println("ERRO ao ler arquivo: " + e.getMessage());
        }
        
        ui.pausar();
    }
    
    // ===== MÉTODOS AUXILIARES =====
    
    /**
     * Criar diretório se necessário
     */
    private void criarDiretorioSeNecessario() {
        File dir = new File(diretorioConjuntos);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }
    
    /**
     * Obter nome do tipo
     */
    private String obterNomeTipo(int tipo) {
        switch (tipo) {
            case 1: return "Números Inteiros";
            case 2: return "Números Decimais";
            case 3: return "Palavras/Texto";
            default: return "Desconhecido";
        }
    }
}
