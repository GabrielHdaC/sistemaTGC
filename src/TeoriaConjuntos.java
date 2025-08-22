/**
 * Teoria dos Conjuntos - Conceitos Fundamentais
 * Baseado nos conceitos da Profª Drª Janaína Poffo Possamai
 */
public class TeoriaConjuntos {
    
    /**
     * Apresenta definições e notações básicas
     */
    public static void definicoesNotacoes() {
        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║              📚 DEFINIÇÕES E NOTAÇÕES 📚                   ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
        System.out.println();
        
        System.out.println("🎯 DEFINIÇÃO DE CONJUNTO:");
        System.out.println("Um conjunto é um agrupamento de objetos que compartilham");
        System.out.println("uma propriedade comum.");
        System.out.println();
        
        System.out.println("** NOTAÇÃO BÁSICA:");
        System.out.println("• Conjuntos: letras MAIÚSCULAS (A, B, C, ...)");
        System.out.println("• Elementos: letras minúsculas (a, b, c, ...)");
        System.out.println("• Pertinência: PERTENCE ou NAO-PERTENCE");
        System.out.println("• Conjunto vazio: VAZIO ou { }");
        System.out.println();
        
        System.out.println("🔤 FORMAS DE REPRESENTAÇÃO:");
        System.out.println();
        System.out.println("1️⃣ ENUMERAÇÃO (Extensão):");
        System.out.println("   A = {1, 2, 3, 4, 5}");
        System.out.println("   B = {a, e, i, o, u}");
        System.out.println();
        
        System.out.println("2️⃣ PROPRIEDADE (Compreensão):");
        System.out.println("   E = {x | x é ímpar, 6 < x < 17}");
        System.out.println("   F = {x | x é vogal}");
        System.out.println();
        
        System.out.println("3️⃣ DIAGRAMA DE VENN:");
        System.out.println("   ┌─────────────┐");
        System.out.println("   │   A         │");
        System.out.println("   │  • a   • b  │");
        System.out.println("   │     • c     │");
        System.out.println("   └─────────────┘");
        System.out.println();
        
        System.out.println("** EXEMPLOS PRÁTICOS:");
        System.out.println("• Conjunto dos números naturais: N = {0, 1, 2, 3, ...}");
        System.out.println("• Conjunto das vogais: V = {a, e, i, o, u}");
        System.out.println("• Conjunto dos dias da semana: D = {seg, ter, qua, qui, sex, sab, dom}");
        System.out.println("• Conjunto dos números pares: P = {x | x é par e x é natural}");
        System.out.println();
        
        System.out.println("📊 CARDINALIDADE:");
        System.out.println("• Número de elementos do conjunto");
        System.out.println("• Notação: |A| ou n(A)");
        System.out.println("• Exemplo: A = {1, 2, 3} → |A| = 3");
        System.out.println("═".repeat(62));
    }
    
    /**
     * Apresenta tipos de conjuntos
     */
    public static void tiposConjuntos() {
        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║        🏷️ TIPOS DE CONJUNTOS (FINITO/INFINITO/VAZIO) 🏷️     ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
        System.out.println();
        
        System.out.println("1️⃣ CONJUNTOS FINITOS:");
        System.out.println("• Possuem número limitado de elementos");
        System.out.println("• Podemos contar todos os elementos");
        System.out.println();
        System.out.println("📚 Exemplos:");
        System.out.println("• Livros da biblioteca da FURB");
        System.out.println("• Alunos de uma turma: A = {Ana, Bruno, Carlos}");
        System.out.println("• Dias do mês: D = {1, 2, 3, ..., 31}");
        System.out.println("• Estados do Brasil: |E| = 26");
        System.out.println();
        
        System.out.println("2️⃣ CONJUNTOS INFINITOS:");
        System.out.println("• Possuem infinitos elementos");
        System.out.println("• Impossível enumerar todos");
        System.out.println();
        System.out.println("🔢 Exemplos:");
        System.out.println("• Números naturais: ℕ = {0, 1, 2, 3, ...}");
        System.out.println("• Números ímpares: I = {1, 3, 5, 7, 9, ...}");
        System.out.println("• Números reais: ℝ");
        System.out.println("• Pontos de uma reta");
        System.out.println();
        
        System.out.println("3️⃣ CONJUNTO VAZIO:");
        System.out.println("• Não possui nenhum elemento");
        System.out.println("• Símbolo: ∅ ou { }");
        System.out.println("• Cardinalidade: |∅| = 0");
        System.out.println();
        System.out.println("🦕 Exemplos:");
        System.out.println("• Dinossauros vivos atualmente");
        System.out.println("• Cidades de Goiás banhadas pelo oceano");
        System.out.println("• Números naturais negativos");
        System.out.println("• Soluções reais de x² + 1 = 0");
        System.out.println();
        
        System.out.println("4️⃣ CONJUNTO UNITÁRIO:");
        System.out.println("• Possui exatamente um elemento");
        System.out.println("• Cardinalidade: |A| = 1");
        System.out.println();
        System.out.println("🎯 Exemplos:");
        System.out.println("• A = {5}");
        System.out.println("• B = {Paris} (capital da França)");
        System.out.println("• C = {0} (único elemento neutro da adição)");
        System.out.println();
        
        System.out.println("💡 PROPRIEDADES ESPECIAIS:");
        System.out.println("• Conjuntos infinitos podem ter \"mesmo tamanho\" que suas partes");
        System.out.println("• Conjunto vazio é subconjunto de qualquer conjunto");
        System.out.println("• Todo conjunto é subconjunto de si mesmo");
        System.out.println("═".repeat(62));
    }
    
    /**
     * Apresenta igualdade de conjuntos
     */
    public static void igualdadeConjuntos() {
        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║                ⚖️ IGUALDADE DE CONJUNTOS ⚖️                  ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
        System.out.println();
        
        System.out.println("📐 DEFINIÇÃO:");
        System.out.println("Dois conjuntos A e B são IGUAIS (A = B) se e somente se");
        System.out.println("possuem exatamente os mesmos elementos.");
        System.out.println();
        
        System.out.println("📋 CONDIÇÃO FORMAL:");
        System.out.println("A = B ⟺ (∀x)(x ∈ A ⟺ x ∈ B)");
        System.out.println("\"Para todo x, x pertence a A se e só se x pertence a B\"");
        System.out.println();
        
        System.out.println("✅ EXEMPLOS DE IGUALDADE:");
        System.out.println();
        System.out.println("1️⃣ Ordem não importa:");
        System.out.println("   A = {a, b, c}");
        System.out.println("   B = {b, c, a}");
        System.out.println("   A = B ✅ (mesmos elementos)");
        System.out.println();
        
        System.out.println("2️⃣ Repetição não importa:");
        System.out.println("   C = {1, 2, 3}");
        System.out.println("   D = {1, 1, 2, 2, 3, 3}");
        System.out.println("   C = D ✅ (conjuntos não têm repetição)");
        System.out.println();
        
        System.out.println("3️⃣ Representações diferentes:");
        System.out.println("   E = {2, 4, 6, 8}");
        System.out.println("   F = {x | x é par, 0 < x < 10}");
        System.out.println("   E = F ✅ (mesmos elementos)");
        System.out.println();
        
        System.out.println("❌ EXEMPLOS DE DESIGUALDADE:");
        System.out.println();
        System.out.println("1️⃣ Elementos diferentes:");
        System.out.println("   G = {1, 2, 3}");
        System.out.println("   H = {1, 2, 4}");
        System.out.println("   G ≠ H ❌ (3 ∈ G mas 3 ∉ H)");
        System.out.println();
        
        System.out.println("2️⃣ Cardinalidades diferentes:");
        System.out.println("   I = {a, b}");
        System.out.println("   J = {a, b, c}");
        System.out.println("   I ≠ J ❌ (c ∈ J mas c ∉ I)");
        System.out.println();
        
        System.out.println("💡 PROPRIEDADES DA IGUALDADE:");
        System.out.println("• Reflexiva: A = A");
        System.out.println("• Simétrica: A = B ⟹ B = A");
        System.out.println("• Transitiva: A = B e B = C ⟹ A = C");
        System.out.println();
        
        System.out.println("🔍 VERIFICAÇÃO PRÁTICA:");
        System.out.println("Para verificar se A = B:");
        System.out.println("1. Todo elemento de A está em B?");
        System.out.println("2. Todo elemento de B está em A?");
        System.out.println("3. Se ambas respostas forem SIM → A = B");
        System.out.println("═".repeat(62));
    }
    
    /**
     * Apresenta conjuntos unitários e vazios
     */
    public static void conjuntosUnitariosVazios() {
        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║           🎯 CONJUNTOS UNITÁRIOS E VAZIOS 🎯                ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
        System.out.println();
        
        System.out.println("1️⃣ CONJUNTOS UNITÁRIOS:");
        System.out.println("• Possuem exatamente UM elemento");
        System.out.println("• Cardinalidade: |A| = 1");
        System.out.println("• Também chamados de \"singletons\"");
        System.out.println();
        
        System.out.println("📚 EXEMPLOS UNITÁRIOS:");
        System.out.println("🔹 A = {5}");
        System.out.println("🔹 B = {Paris} (única capital da França)");
        System.out.println("🔹 C = {Brasil} (único país que fala português na América do Sul)");
        System.out.println("🔹 D = {Sol} (única estrela do Sistema Solar)");
        System.out.println("🔹 E = {x ∈ ℕ | x² = 4 e x > 0} = {2}");
        System.out.println();
        
        System.out.println("2️⃣ CONJUNTO VAZIO:");
        System.out.println("• Não possui nenhum elemento");
        System.out.println("• Símbolos: ∅ ou { }");
        System.out.println("• Cardinalidade: |∅| = 0");
        System.out.println("• Único conjunto com essa propriedade");
        System.out.println();
        
        System.out.println("🦕 EXEMPLOS VAZIOS:");
        System.out.println("🔹 V₁ = {dinossauros vivos em 2025}");
        System.out.println("🔹 V₂ = {cidades de Goiás banhadas pelo oceano}");
        System.out.println("🔹 V₃ = {números naturais negativos}");
        System.out.println("🔹 V₄ = {x ∈ ℝ | x² < 0}");
        System.out.println("🔹 V₅ = {pessoas com mais de 200 anos de idade}");
        System.out.println();
        
        System.out.println("⚖️ DIFERENÇA IMPORTANTE:");
        System.out.println("• {0} ≠ ∅");
        System.out.println("• {0} é unitário (contém o elemento 0)");
        System.out.println("• ∅ é vazio (não contém elemento algum)");
        System.out.println();
        
        System.out.println("🔢 MAIS EXEMPLOS:");
        System.out.println("Unitários:");
        System.out.println("• {∅} - conjunto que contém o conjunto vazio");
        System.out.println("• {x | x² = 9 e x > 0} = {3}");
        System.out.println("• {planeta que tem anéis visíveis da Terra} = {Saturno}");
        System.out.println();
        
        System.out.println("Vazios:");
        System.out.println("• {x ∈ ℕ | 5 < x < 6} = ∅");
        System.out.println("• {triângulos com 4 lados} = ∅");
        System.out.println("• {números primos pares maiores que 2} = ∅");
        System.out.println();
        
        System.out.println("💡 PROPRIEDADES ESPECIAIS:");
        System.out.println("• ∅ ⊆ A (conjunto vazio é subconjunto de qualquer conjunto)");
        System.out.println("• ∅ ∪ A = A (união com vazio = próprio conjunto)");
        System.out.println("• ∅ ∩ A = ∅ (interseção com vazio = vazio)");
        System.out.println("• |{A}| = 1 (conjunto contendo conjunto A tem 1 elemento)");
        System.out.println("═".repeat(62));
    }
    
    /**
     * Apresenta conjuntos com conjuntos
     */
    public static void conjuntosComConjuntos() {
        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║              📦 CONJUNTOS COM CONJUNTOS 📦                  ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
        System.out.println();
        
        System.out.println("🎯 CONCEITO:");
        System.out.println("Os elementos de um conjunto podem ser OUTROS CONJUNTOS!");
        System.out.println("Isso cria estruturas hierárquicas complexas.");
        System.out.println();
        
        System.out.println("📚 EXEMPLO FUNDAMENTAL:");
        System.out.println("Seja F = {∅, {a}, {c}, {a, b}, {a, c}, {a, b, c}}");
        System.out.println();
        
        System.out.println("🔍 ANÁLISE DOS ELEMENTOS:");
        System.out.println("1️⃣ ∅ ∈ F          (conjunto vazio é elemento de F)");
        System.out.println("2️⃣ {a} ∈ F        (conjunto unitário {a} é elemento de F)");
        System.out.println("3️⃣ {c} ∈ F        (conjunto unitário {c} é elemento de F)");
        System.out.println("4️⃣ {a, b} ∈ F     (conjunto {a, b} é elemento de F)");
        System.out.println("5️⃣ {a, c} ∈ F     (conjunto {a, c} é elemento de F)");
        System.out.println("6️⃣ {a, b, c} ∈ F  (conjunto {a, b, c} é elemento de F)");
        System.out.println();
        
        System.out.println("📊 CARDINALIDADE:");
        System.out.println("• |F| = 6 (F tem 6 elementos)");
        System.out.println("• Cada elemento de F é um conjunto!");
        System.out.println();
        
        System.out.println("⚠️ CUIDADO COM PERTINÊNCIA:");
        System.out.println("• a ∉ F      (a não é elemento de F)");
        System.out.println("• {a} ∈ F    ({a} É elemento de F)");
        System.out.println("• a ∈ {a}    (a pertence ao conjunto {a})");
        System.out.println("• {a} ⊆ F    ({a} não é subconjunto de F)");
        System.out.println();
        
        System.out.println("🏗️ OUTROS EXEMPLOS:");
        System.out.println();
        
        System.out.println("1️⃣ Conjunto de turmas:");
        System.out.println("   T = {{Ana, Bruno}, {Carlos, Diana}, {Eduardo}}");
        System.out.println("   • |T| = 3 (3 turmas)");
        System.out.println("   • {Ana, Bruno} ∈ T");
        System.out.println();
        
        System.out.println("2️⃣ Conjunto das partes de {1, 2}:");
        System.out.println("   P({1, 2}) = {∅, {1}, {2}, {1, 2}}");
        System.out.println("   • |P({1, 2})| = 4");
        System.out.println("   • Cada subconjunto é um elemento");
        System.out.println();
        
        System.out.println("3️⃣ Estrutura aninhada:");
        System.out.println("   G = {{{a}}, {b, {c}}}");
        System.out.println("   • |G| = 2");
        System.out.println("   • {{a}} ∈ G");
        System.out.println("   • {b, {c}} ∈ G");
        System.out.println();
        
        System.out.println("💡 APLICAÇÕES PRÁTICAS:");
        System.out.println("• Banco de dados relacionais");
        System.out.println("• Estruturas de dados hierárquicas");
        System.out.println("• Conjunto das partes (power set)");
        System.out.println("• Teoria de categorias");
        System.out.println();
        
        System.out.println("🎓 IMPORTANTE LEMBRAR:");
        System.out.println("• ∈ é diferente de ⊆");
        System.out.println("• {a} ≠ a (conjunto vs elemento)");
        System.out.println("• {{a}} ≠ {a} (níveis diferentes)");
        System.out.println("═".repeat(62));
    }
    
    /**
     * Apresenta pertinência vs inclusão
     */
    public static void pertinenciaInclusao() {
        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║              🔍 PERTINÊNCIA VS INCLUSÃO 🔍                  ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
        System.out.println();
        
        System.out.println("⚡ CONCEITOS FUNDAMENTAIS:");
        System.out.println("Duas relações DIFERENTES mas frequentemente confundidas!");
        System.out.println();
        
        System.out.println("1️⃣ PERTINÊNCIA (∈):");
        System.out.println("• Relação entre ELEMENTO e CONJUNTO");
        System.out.println("• \"x pertence ao conjunto A\"");
        System.out.println("• Símbolo: x ∈ A");
        System.out.println("• Negação: x ∉ A");
        System.out.println();
        
        System.out.println("2️⃣ INCLUSÃO (⊆):");
        System.out.println("• Relação entre CONJUNTO e CONJUNTO");
        System.out.println("• \"A é subconjunto de B\"");
        System.out.println("• Símbolo: A ⊆ B");
        System.out.println("• Negação: A ⊈ B");
        System.out.println();
        
        System.out.println("📚 EXEMPLOS PRÁTICOS:");
        System.out.println();
        
        System.out.println("Sejam:");
        System.out.println("V = {a, e, i, o, u} (vogais)");
        System.out.println("M = {a, b, c, d} (primeiras letras)");
        System.out.println("A = {a, e} (subconjunto de V)");
        System.out.println();
        
        System.out.println("✅ PERTINÊNCIA CORRETA:");
        System.out.println("• a ∈ V    (a é uma vogal)");
        System.out.println("• e ∈ V    (e é uma vogal)");
        System.out.println("• a ∈ M    (a está nas primeiras letras)");
        System.out.println("• b ∈ M    (b está nas primeiras letras)");
        System.out.println();
        
        System.out.println("❌ PERTINÊNCIA INCORRETA:");
        System.out.println("• b ∉ V    (b não é vogal)");
        System.out.println("• z ∉ M    (z não está em M)");
        System.out.println("• {a} ∉ V  (conjunto {a} não é elemento de V)");
        System.out.println();
        
        System.out.println("✅ INCLUSÃO CORRETA:");
        System.out.println("• A ⊆ V    ({a, e} é subconjunto das vogais)");
        System.out.println("• ∅ ⊆ V    (vazio é subconjunto de qualquer conjunto)");
        System.out.println("• V ⊆ V    (todo conjunto é subconjunto de si mesmo)");
        System.out.println();
        
        System.out.println("❌ INCLUSÃO INCORRETA:");
        System.out.println("• M ⊈ V    (M não é subconjunto de V, pois b ∈ M mas b ∉ V)");
        System.out.println("• a ⊈ V    (ERRO! a é elemento, não conjunto)");
        System.out.println();
        
        System.out.println("🔄 CASOS ESPECIAIS:");
        System.out.println();
        
        System.out.println("Seja F = {∅, {a}, {a, b}}");
        System.out.println();
        System.out.println("Pertinência:");
        System.out.println("• ∅ ∈ F        ✅ (conjunto vazio é elemento de F)");
        System.out.println("• {a} ∈ F      ✅ (conjunto {a} é elemento de F)");
        System.out.println("• a ∉ F        ✅ (elemento a não está diretamente em F)");
        System.out.println();
        System.out.println("Inclusão:");
        System.out.println("• {∅} ⊆ F      ✅ ({∅} é subconjunto de F)");
        System.out.println("• {{a}} ⊆ F    ✅ ({{a}} é subconjunto de F)");
        System.out.println("• {a} ⊈ F      ❌ ({a} não é subconjunto de F!)");
        System.out.println();
        
        System.out.println("💡 DICAS PARA NÃO CONFUNDIR:");
        System.out.println("• ∈ conecta elemento com conjunto");
        System.out.println("• ⊆ conecta conjunto com conjunto");
        System.out.println("• Se x ∈ A, então {x} ⊆ A");
        System.out.println("• Se A ⊆ B e x ∈ A, então x ∈ B");
        System.out.println();
        
        System.out.println("📋 DEFINIÇÃO FORMAL DE SUBCONJUNTO:");
        System.out.println("A ⊆ B ⟺ (∀x)(x ∈ A ⟹ x ∈ B)");
        System.out.println("\"A é subconjunto de B se todo elemento de A também está em B\"");
        System.out.println("═".repeat(62));
    }
    
}
