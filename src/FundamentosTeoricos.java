/**
 * Fundamentos Teóricos e Paradoxos da Matemática
 * 
 * Esta classe demonstra paradoxos fundamentais que quebram a intuição humana
 * e são essenciais para compreender os limites da lógica matemática.
 * 
 * CONCEITOS COMPLEXOS EXPLICADOS:
 * - Paradoxos autorreferenciais (Barbeiro)
 * - Infinitos de diferentes tamanhos (Galilei) 
 * - Bijeções em conjuntos infinitos (Hilbert)
 * 
 * @author Gabriel Heron
 * @version 3.0 - Clean Code
 * @based_on Profª Drª Janaína Poffo Possamai - FURB
 */
public class FundamentosTeoricos {
    
    // Constantes para formatação visual (Clean Code: Magic Numbers)
    private static final String HEADER_DECORATOR = "╔══════════════════════════════════════════════════════════════╗";
    private static final String FOOTER_DECORATOR = "╚══════════════════════════════════════════════════════════════╝";
    private static final String SEPARATOR_LINE = "═════════════════════════════════════════════════════";
    
    /**
     * MÉTODO UTILITÁRIO - Clean Code: DRY (Don't Repeat Yourself)
     * 
     * Imprime um cabeçalho formatado de forma consistente.
     * Centraliza a lógica de formatação em um só lugar.
     * 
     * @param titulo O título a ser exibido no cabeçalho
     */
    private static void imprimirCabecalho(String titulo) {
        System.out.println(HEADER_DECORATOR);
        System.out.println("║              " + titulo + "          ║");
        System.out.println(FOOTER_DECORATOR);
        System.out.println();
    }
    
    /**
     * MÉTODO UTILITÁRIO - Clean Code: Reutilização de Código
     * 
     * Imprime uma seção com título e conteúdo formatados.
     * Evita repetição de código de formatação.
     * 
     * @param titulo O título da seção
     * @param conteudo O conteúdo da seção
     */
    private static void imprimirSecao(String titulo, String conteudo) {
        System.out.println(titulo + ":");
        System.out.println(conteudo);
        System.out.println();
    }
    
    /**
     * PARADOXO AUTORREFERENCIAL - CONCEITO COMPLEXO!
     * 
     * O Paradoxo do Barbeiro demonstra como definições aparentemente 
     * simples podem gerar contradições lógicas insuperáveis.
     * 
     * COMO FUNCIONA:
     * 1. Criamos uma regra que parece fazer sentido
     * 2. Aplicamos a regra ao próprio criador da regra
     * 3. A regra se torna contraditória e impossível
     * 
     * POR QUE É IMPORTANTE:
     * - Mostra limitações da linguagem natural
     * - Base para teoremas de incompletude (Gödel)
     * - Fundamento da teoria de conjuntos moderna
     */
    public static void paradoxoBarbeiro() {
        imprimirCabecalho("� PARADOXO DO BARBEIRO DE SEVILHA 💈");
        
        imprimirSecao("📜 CONTEXTO", 
            "Na cidade de Sevilha há uma lei rígida quanto ao uso da barba:");
        
        imprimirRegras();
        imprimirParadoxoCore();
        imprimirAnaliseLogica();
        imprimirConclusaoEImportancia();
        
        System.out.println(SEPARATOR_LINE + "\n");
    }
    
    /**
     * MÉTODO AUXILIAR - Clean Code: Extrair Métodos Pequenos
     * Imprime as regras do paradoxo de forma organizada
     */
    private static void imprimirRegras() {
        imprimirSecao("📋 REGRAS",
            """
            • Todo homem adulto é obrigado a se barbear diariamente
            • O homem pode fazer a barba sozinho, em casa
            • Ou pode ir no barbeiro – o único da cidade
            • Lei: "O barbeiro deverá fazer a barba daqueles que
              optarem por não fazer a barba sozinhos\"""");
    }
    
    /**
     * MÉTODO AUXILIAR - Clean Code: Single Responsibility
     * Apresenta o core do paradoxo - a pergunta central
     */
    private static void imprimirParadoxoCore() {
        imprimirSecao("❓ PARADOXO", "🤔 Quem faz a barba do barbeiro em Sevilha?");
    }
    
    /**
     * MÉTODO AUXILIAR - Clean Code: Evitar Métodos Gigantes  
     * Quebra a análise lógica em partes compreensíveis
     */
    private static void imprimirAnaliseLogica() {
        System.out.println("🧠 ANÁLISE LÓGICA:");
        
        System.out.println("📌 Se o barbeiro faz a própria barba:");
        System.out.println("   → Ele não deveria ir ao barbeiro (ele mesmo)");
        System.out.println("   → Contradição com a lei!");
        System.out.println();
        
        System.out.println("📌 Se o barbeiro NÃO faz a própria barba:");
        System.out.println("   → Pela lei, o barbeiro deve fazer a barba dele");
        System.out.println("   → Mas o barbeiro É ele mesmo!");
        System.out.println("   → Contradição novamente!");
        System.out.println();
    }
    
    /**
     * MÉTODO AUXILIAR - Clean Code: Expressividade
     * Explica a importância matemática do paradoxo
     */
    private static void imprimirConclusaoEImportancia() {
        imprimirSecao("💡 CONCLUSÃO",
            """
            Este é um PARADOXO LÓGICO - uma declaração aparentemente
            verdadeira que leva a uma contradição lógica.""");
        
        System.out.println("🎯 IMPORTÂNCIA:");
        System.out.println("• Mostra limitações da linguagem comum");
        System.out.println("• Demonstra necessidade de rigor matemático");
        System.out.println("• Base para desenvolvimento da Teoria dos Conjuntos");
        System.out.println("═".repeat(62));
    }
    
    /**
     * CONCEITO COMPLEXO: BIJEÇÃO EM CONJUNTOS INFINITOS
     * 
     * O Hotel de Hilbert demonstra a propriedade contraintuitiva dos 
     * conjuntos infinitos: é possível fazer correspondência 1:1 entre
     * um conjunto infinito e um subconjunto próprio dele mesmo.
     * 
     * COMO FUNCIONA A MATEMÁTICA AQUI:
     * 1. ℕ = {1, 2, 3, 4, 5, ...} (ocupados)
     * 2. Função f(n) = n + 1 mapeia cada hóspede para próximo quarto
     * 3. Resultado: {2, 3, 4, 5, 6, ...} (libera quarto 1)
     * 4. |N| = |N U {novo_hóspede}| ← ISSO SÓ FUNCIONA NO INFINITO!
     * 
     * POR QUE ISSO QUEBRA A CABEÇA:
     * - No finito: não se pode adicionar sem remover
     * - No infinito: sempre há "espaço" através de reorganização
     */
    public static void hotelHilbert() {
        imprimirCabecalho("🏨 HOTEL DE HILBERT 🏨");
        
        imprimirSecao("🏨 SITUAÇÃO",
            """
            Imagine um hotel com INFINITOS quartos (um para cada número natural)
            Quartos: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ..., ∞
            Status: TODOS os quartos estão ocupados! 🔴""");
        
        imprimirProblemaHotel();
        imprimirSolucaoRemanejamento();
        imprimirDesafioInfinitoHospedes();
        
        System.out.println(SEPARATOR_LINE + "\n");
    }
    
    /**
     * MÉTODO AUXILIAR - Clean Code: Single Responsibility
     * Define claramente o problema do hotel
     */
    private static void imprimirProblemaHotel() {
        System.out.println("❓ PROBLEMA:");
        System.out.println("Chega UMA nova família querendo se hospedar.");
        System.out.println("O dono do hotel:");
        System.out.println("• NÃO quer despejar nenhum hóspede");
        System.out.println("• NÃO quer recusar a nova família");
        System.out.println();
    }
    
    /**
     * MÉTODO AUXILIAR - Clean Code: Responsabilidade Única
     * Explica a solução matemática do remanejamento
     */
    private static void imprimirSolucaoRemanejamento() {
        imprimirSecao("💡 SOLUÇÃO GENIAL",
            "O dono pede para TODOS os hóspedes se mudarem:");
        
        System.out.println("📋 REMANEJAMENTO (Função f(n) = n + 1):");
        System.out.println("Quarto 1 → Quarto 2");
        System.out.println("Quarto 2 → Quarto 3");
        System.out.println("Quarto 3 → Quarto 4");
        System.out.println("Quarto n → Quarto n+1");
        System.out.println("...");
        System.out.println();
        
        System.out.println("✅ RESULTADO:");
        System.out.println("• Quarto 1 fica LIVRE para a nova família!");
        System.out.println("• TODOS os antigos hóspedes continuam hospedados");
        System.out.println("• Ninguém fica sem quarto");
        System.out.println();
    }
    
    /**
     * MÉTODO AUXILIAR - Clean Code: Separação de Conceitos
     * Apresenta o desafio mais avançado com infinitos hóspedes
     */
    private static void imprimirDesafioInfinitoHospedes() {
        System.out.println("🤯 E SE CHEGAREM INFINITAS FAMÍLIAS?");
        System.out.println("Solução: cada hóspede vai para o quarto 2×n");
        System.out.println("Quarto 1 → Quarto 2");
        System.out.println("Quarto 2 → Quarto 4");
        System.out.println("Quarto 3 → Quarto 6");
        System.out.println("Quarto n → Quarto 2n");
        System.out.println();
        System.out.println("Resultado: Todos os quartos ÍMPARES ficam livres!");
        System.out.println("Quartos livres: 1, 3, 5, 7, 9, 11, ... (infinitos!)");
        System.out.println();
        
        System.out.println("🧠 LIÇÃO MATEMÁTICA:");
        System.out.println("• Infinito + 1 = Infinito");
        System.out.println("• Infinito + Infinito = Infinito");
        System.out.println("• Conjuntos infinitos têm propriedades especiais!");
        System.out.println("═".repeat(62));
    }
    
    /**
     * CONCEITO MAIS COMPLEXO: CARDINALIDADE DE CONJUNTOS INFINITOS
     * 
     * O Paradoxo de Galileu quebra nossa intuição sobre tamanho e mostra 
     * que no infinito, uma parte pode ter o mesmo "tamanho" que o todo.
     * 
     * MATEMÁTICA ENVOLVIDA (muito complexa!):
     * 1. Axioma de Euclides: Todo > Parte (funciona no finito)
     * 2. Bijeção f: ℕ → P onde f(n) = 2n
     * 3. |A| = |B| ⟺ ∃ bijeção entre A e B  
     * 4. Logo: |N| = |P| mesmo que P CONTIDO-EM N
     * 
     * POR QUE ISSO É DIFÍCIL DE ENTENDER:
     * - Nossa experiência é só com conjuntos finitos
     * - No finito: remover elementos sempre diminui o tamanho
     * - No infinito: correspondências 1:1 determinam "igualdade"
     * 
     * IMPORTÂNCIA HISTÓRICA:
     * - Levou à criação da Teoria dos Conjuntos (Cantor)
     * - Base para diferentes "tamanhos" de infinito (ℵ₀, ℵ₁, ...)
     */
    public static void paradoxoGalileu() {
        imprimirCabecalho("🔄 PARADOXO DE GALILEU 🔄");
        
        imprimirAxiomaEuclides();
        imprimirDefinicaoConjuntos();
        imprimirObservacaoInicial();
        imprimirDescobertaGalileu();
        imprimirMapeamentoBijetivo();
        imprimirConclusaoParadoxal();
        imprimirResolucaoMatematica();
        
        System.out.println(SEPARATOR_LINE + "\n");
    }
    
    /**
     * MÉTODO AUXILIAR - Clean Code: Métodos Pequenos e Focados
     * Apresenta o axioma clássico que será "quebrado"
     */
    private static void imprimirAxiomaEuclides() {
        imprimirSecao("📚 AXIOMA DE EUCLIDES",
            "\"O todo é sempre maior que a parte\"\n💭 Parece óbvio, não é? Mas...");
    }
    
    /**
     * MÉTODO AUXILIAR - Clean Code: Single Responsibility  
     * Define claramente os conjuntos que serão comparados
     */
    private static void imprimirDefinicaoConjuntos() {
        System.out.println("🔢 CONJUNTOS:");
        System.out.println("ℕ (Naturais) = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, ...}");
        System.out.println("P (Pares)    = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, ...}");
        System.out.println();
    }
    
    /**
     * MÉTODO AUXILIAR - Clean Code: Expressividade
     * Estabelece a intuição inicial que será contradita
     */
    private static void imprimirObservacaoInicial() {
        imprimirSecao("🤔 OBSERVAÇÃO",
            """
            • P ⊂ ℕ (Pares é subconjunto dos Naturais)
            • Logo, P deveria ser "menor" que ℕ, certo?""");
    }
    
    /**
     * MÉTODO AUXILIAR - Clean Code: Separação de Responsabilidades
     * Introduz a descoberta revolucionária de Galileu
     */
    private static void imprimirDescobertaGalileu() {
        imprimirSecao("💡 DESCOBERTA DE GALILEU",
            "Criou uma correspondência biunívoca:");
    }
    
    /**
     * MÉTODO AUXILIAR - Clean Code: Visualização Clara
     * Mostra o mapeamento bijetivo de forma visual e compreensível
     */
    private static void imprimirMapeamentoBijetivo() {
        System.out.println("📊 MAPEAMENTO BIJETIVO (f: ℕ → P):");
        System.out.println("ℕ:  1  2  3  4  5  6  7  8  9  10  11  12  ...");
        System.out.println("     ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓   ↓   ↓");
        System.out.println("P:  2  4  6  8  10 12 14 16 18 20  22  24  ...");
        System.out.println();
        
        System.out.println("🎯 FUNÇÃO MATEMÁTICA: f(n) = 2n");
        System.out.println("• Cada natural n corresponde exatamente a um par 2n");
        System.out.println("• Cada par corresponde exatamente a um natural");
        System.out.println("• Não sobra nem falta elemento em nenhum conjunto!");
        System.out.println();
    }
    
    /**
     * MÉTODO AUXILIAR - Clean Code: Clareza na Conclusão
     * Apresenta o paradoxo de forma clara e impactante
     */
    private static void imprimirConclusaoParadoxal() {
        System.out.println("🤯 CONCLUSÃO PARADOXAL:");
        System.out.println("• |ℕ| = |P| (mesmo \"tamanho\" - cardinalidade ℵ₀!)");
        System.out.println("• Mas P ⊂ ℕ (P é parte de ℕ)");
        System.out.println("• ⚡ Contradição com Euclides: \"o todo > parte\"");
        System.out.println();
    }
    
    /**
     * MÉTODO AUXILIAR - Clean Code: Explicação Educativa
     * Resolve o paradoxo e explica a matemática por trás
     */
    private static void imprimirResolucaoMatematica() {
        System.out.println("💡 RESOLUÇÃO MATEMÁTICA:");
        System.out.println("• O axioma de Euclides vale para conjuntos FINITOS");
        System.out.println("• Para conjuntos INFINITOS, usamos CARDINALIDADE");
        System.out.println("• Cardinalidade = existência de bijeção, não inclusão");
        System.out.println("• Isso abriu caminho para ℵ₀, ℵ₁, ℵ₂... (infinitos diferentes)!");
    }
    
    /**
     * Apresenta os Problemas da Linguagem
     */
    public static void problemasLinguagem() {
        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║                📝 PROBLEMAS DA LINGUAGEM 📝                ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
        System.out.println();
        
        System.out.println("❗ PROBLEMA CENTRAL:");
        System.out.println("A linguagem comum é AMBÍGUA e IMPRECISA para a matemática");
        System.out.println();
        
        System.out.println("📋 EXEMPLO CLÁSSICO:");
        System.out.println("\"A diretoria pediu que o professor comunicasse");
        System.out.println("aos alunos sua alegria pelo progresso que eles");
        System.out.println("vinham fazendo nos estudos.\"");
        System.out.println();
        
        System.out.println("❓ AMBIGUIDADE:");
        System.out.println("De quem é a alegria?");
        System.out.println("🤔 Alegria da DIRETORIA?");
        System.out.println("🤔 Alegria do PROFESSOR?");
        System.out.println();
        
        System.out.println("🔍 ANÁLISE:");
        System.out.println("• \"sua\" pode se referir a:");
        System.out.println("  - Diretoria (sujeito da oração principal)");
        System.out.println("  - Professor (sujeito mais próximo)");
        System.out.println("• A gramática permite ambas interpretações!");
        System.out.println();
        
        System.out.println("⚠️ CONSEQUÊNCIAS:");
        System.out.println("• Paradoxos surgem dessas ambiguidades");
        System.out.println("• Contradições lógicas aparecem");
        System.out.println("• Impossibilidade de demonstrações rigorosas");
        System.out.println();
        
        System.out.println("💡 SOLUÇÃO MATEMÁTICA:");
        System.out.println("• Linguagem FORMAL e SIMBÓLICA");
        System.out.println("• Definições PRECISAS e UNÍVOCAS");
        System.out.println("• Notação matemática RIGOROSA");
        System.out.println();
        
        System.out.println("🎯 EXEMPLOS DE PRECISÃO:");
        System.out.println("❌ Linguagem comum: \"números grandes\"");
        System.out.println("✅ Matemática: x > 1000");
        System.out.println();
        System.out.println("❌ Linguagem comum: \"alguns elementos\"");
        System.out.println("✅ Matemática: ∃x ∈ A");
        System.out.println();
        System.out.println("❌ Linguagem comum: \"todos os casos\"");
        System.out.println("✅ Matemática: ∀x ∈ U");
        System.out.println();
        
        System.out.println("🏗️ CONSTRUÇÃO DA TEORIA DOS CONJUNTOS:");
        System.out.println("• Base sólida para a matemática");
        System.out.println("• Eliminação de ambiguidades");
        System.out.println("• Fundamento para lógica formal");
        System.out.println("═".repeat(62));
    }
    
}
