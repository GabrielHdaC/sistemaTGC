import java.util.*;

/**
 * Operações Avançadas entre Conjuntos
 * Implementa todas as operações com fórmulas e propriedades
 */
public class OperacoesAvancadas {
    
    /**
     * Demonstra união com fórmulas
     */
    public static void uniaoAvancada() {
        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║                      ∪ UNIÃO (A ∪ B) ∪                      ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
        System.out.println();
        
        System.out.println("📐 DEFINIÇÃO FORMAL:");
        System.out.println("A ∪ B = {x | x ∈ A ou x ∈ B}");
        System.out.println("\"Conjunto de todos os elementos que pertencem a A ou a B (ou ambos)\"");
        System.out.println();
        
        System.out.println("🧮 FÓRMULA FUNDAMENTAL:");
        System.out.println("n(A ∪ B) = n(A) + n(B) - n(A ∩ B)");
        System.out.println();
        
        System.out.println("🎯 EXEMPLO PRÁTICO:");
        Set<Integer> A = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> B = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8));
        
        System.out.println("A = " + new TreeSet<>(A));
        System.out.println("B = " + new TreeSet<>(B));
        System.out.println();
        
        Set<Integer> uniao = new HashSet<>(A);
        uniao.addAll(B);
        
        Set<Integer> intersecao = new HashSet<>(A);
        intersecao.retainAll(B);
        
        System.out.println("📊 CÁLCULO:");
        System.out.println("n(A) = " + A.size());
        System.out.println("n(B) = " + B.size());
        System.out.println("n(A ∩ B) = " + intersecao.size() + " → " + new TreeSet<>(intersecao));
        System.out.println();
        
        System.out.println("Aplicando a fórmula:");
        System.out.println("n(A ∪ B) = " + A.size() + " + " + B.size() + " - " + intersecao.size());
        System.out.println("n(A ∪ B) = " + (A.size() + B.size() - intersecao.size()));
        System.out.println();
        
        System.out.println("✅ RESULTADO:");
        System.out.println("A ∪ B = " + new TreeSet<>(uniao));
        System.out.println("n(A ∪ B) = " + uniao.size() + " ✓");
        System.out.println();
        
        System.out.println("🔍 PROPRIEDADES DA UNIÃO:");
        System.out.println("• Comutativa: A ∪ B = B ∪ A");
        System.out.println("• Associativa: (A ∪ B) ∪ C = A ∪ (B ∪ C)");
        System.out.println("• Idempotente: A ∪ A = A");
        System.out.println("• Elemento neutro: A ∪ ∅ = A");
        System.out.println("• Absorção: A ∪ U = U (onde U é universo)");
        System.out.println("═".repeat(62));
    }
    
    /**
     * Demonstra interseção com fórmulas
     */
    public static void intersecaoAvancada() {
        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║                  ∩ INTERSEÇÃO (A ∩ B) ∩                     ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
        System.out.println();
        
        System.out.println("📐 DEFINIÇÃO FORMAL:");
        System.out.println("A ∩ B = {x | x ∈ A e x ∈ B}");
        System.out.println("\"Conjunto dos elementos que pertencem simultaneamente a A e B\"");
        System.out.println();
        
        System.out.println("🎯 EXEMPLO PRÁTICO:");
        Set<Integer> A = new HashSet<>(Arrays.asList(2, 4, 6, 8, 10));
        Set<Integer> B = new HashSet<>(Arrays.asList(3, 6, 9, 12));
        Set<Integer> C = new HashSet<>(Arrays.asList(6, 12, 18));
        
        System.out.println("A = " + new TreeSet<>(A) + " (números pares até 10)");
        System.out.println("B = " + new TreeSet<>(B) + " (múltiplos de 3)");
        System.out.println("C = " + new TreeSet<>(C) + " (múltiplos de 6)");
        System.out.println();
        
        Set<Integer> interAB = new HashSet<>(A);
        interAB.retainAll(B);
        
        Set<Integer> interBC = new HashSet<>(B);
        interBC.retainAll(C);
        
        Set<Integer> interAC = new HashSet<>(A);
        interAC.retainAll(C);
        
        System.out.println("📊 RESULTADOS:");
        System.out.println("A ∩ B = " + new TreeSet<>(interAB) + " (pares E múltiplos de 3)");
        System.out.println("B ∩ C = " + new TreeSet<>(interBC) + " (múltiplos de 3 E de 6)");
        System.out.println("A ∩ C = " + new TreeSet<>(interAC) + " (pares E múltiplos de 6)");
        System.out.println();
        
        // Interseção tripla
        Set<Integer> interABC = new HashSet<>(interAB);
        interABC.retainAll(C);
        System.out.println("A ∩ B ∩ C = " + new TreeSet<>(interABC) + " (todos os três)");
        System.out.println();
        
        System.out.println("🔍 CASOS ESPECIAIS:");
        System.out.println("• Conjuntos disjuntos: A ∩ B = ∅");
        System.out.println("• Auto-interseção: A ∩ A = A");
        System.out.println("• Com vazio: A ∩ ∅ = ∅");
        System.out.println();
        
        System.out.println("🔍 PROPRIEDADES DA INTERSEÇÃO:");
        System.out.println("• Comutativa: A ∩ B = B ∩ A");
        System.out.println("• Associativa: (A ∩ B) ∩ C = A ∩ (B ∩ C)");
        System.out.println("• Idempotente: A ∩ A = A");
        System.out.println("• Elemento absorvente: A ∩ ∅ = ∅");
        System.out.println("• Com universo: A ∩ U = A");
        System.out.println("═".repeat(62));
    }
    
    /**
     * Demonstra diferença de conjuntos
     */
    public static void diferencaAvancada() {
        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║                  - DIFERENÇA (A - B) -                      ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
        System.out.println();
        
        System.out.println("📐 DEFINIÇÃO FORMAL:");
        System.out.println("A - B = {x | x ∈ A e x ∉ B}");
        System.out.println("\"Conjunto dos elementos que estão em A mas NÃO estão em B\"");
        System.out.println();
        
        System.out.println("🎯 EXEMPLO PRÁTICO:");
        Set<Integer> A = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Set<Integer> B = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8));
        
        System.out.println("A = " + new TreeSet<>(A));
        System.out.println("B = " + new TreeSet<>(B));
        System.out.println();
        
        Set<Integer> difAB = new HashSet<>(A);
        difAB.removeAll(B);
        
        Set<Integer> difBA = new HashSet<>(B);
        difBA.removeAll(A);
        
        System.out.println("📊 RESULTADOS:");
        System.out.println("A - B = " + new TreeSet<>(difAB) + " (em A mas não em B)");
        System.out.println("B - A = " + new TreeSet<>(difBA) + " (em B mas não em A)");
        System.out.println();
        
        System.out.println("⚠️ OBSERVAÇÃO IMPORTANTE:");
        System.out.println("A - B ≠ B - A (diferença NÃO é comutativa!)");
        System.out.println();
        
        System.out.println("🔄 DIFERENÇA SIMÉTRICA:");
        Set<Integer> difSimetrica = new HashSet<>(difAB);
        difSimetrica.addAll(difBA);
        System.out.println("A △ B = (A - B) ∪ (B - A) = " + new TreeSet<>(difSimetrica));
        System.out.println("Elementos que estão em A ou B, mas NÃO em ambos");
        System.out.println();
        
        System.out.println("📏 FÓRMULAS ÚTEIS:");
        System.out.println("• n(A - B) = n(A) - n(A ∩ B)");
        System.out.println("• A - B = A ∩ B̄ (complemento de B)");
        System.out.println("• (A - B) ∩ B = ∅");
        System.out.println("• (A - B) ∪ B = A ∪ B");
        System.out.println();
        
        System.out.println("🎲 EXEMPLO NUMÉRICO:");
        Set<Integer> intersecao = new HashSet<>(A);
        intersecao.retainAll(B);
        
        System.out.println("n(A) = " + A.size());
        System.out.println("n(A ∩ B) = " + intersecao.size());
        System.out.println("n(A - B) = n(A) - n(A ∩ B) = " + A.size() + " - " + intersecao.size() + " = " + (A.size() - intersecao.size()));
        System.out.println("Confirmação: |" + new TreeSet<>(difAB) + "| = " + difAB.size() + " ✓");
        System.out.println("═".repeat(62));
    }
    
    /**
     * Demonstra complemento
     */
    public static void complementoAvancado() {
        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║                    Ā COMPLEMENTO Ā                          ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
        System.out.println();
        
        System.out.println("📐 DEFINIÇÃO:");
        System.out.println("Ā = U - A = {x ∈ U | x ∉ A}");
        System.out.println("\"Complemento de A em relação ao universo U\"");
        System.out.println();
        
        System.out.println("🎯 EXEMPLO PRÁTICO:");
        Set<Integer> U = new HashSet<>();
        for (int i = 1; i <= 10; i++) {
            U.add(i);
        }
        
        Set<Integer> A = new HashSet<>(Arrays.asList(2, 4, 6, 8, 10));
        Set<Integer> B = new HashSet<>(Arrays.asList(1, 3, 5));
        
        System.out.println("U = " + new TreeSet<>(U) + " (universo: números de 1 a 10)");
        System.out.println("A = " + new TreeSet<>(A) + " (números pares)");
        System.out.println("B = " + new TreeSet<>(B) + " (números ímpares menores que 6)");
        System.out.println();
        
        Set<Integer> compA = new HashSet<>(U);
        compA.removeAll(A);
        
        Set<Integer> compB = new HashSet<>(U);
        compB.removeAll(B);
        
        System.out.println("📊 COMPLEMENTOS:");
        System.out.println("Ā = " + new TreeSet<>(compA) + " (números ímpares)");
        System.out.println("B̄ = " + new TreeSet<>(compB) + " (não estão em B)");
        System.out.println();
        
        System.out.println("🧮 VERIFICAÇÃO DAS LEIS:");
        
        // Lei de De Morgan
        Set<Integer> uniaoAB = new HashSet<>(A);
        uniaoAB.addAll(B);
        Set<Integer> compUniaoAB = new HashSet<>(U);
        compUniaoAB.removeAll(uniaoAB);
        
        Set<Integer> intersecaoCompAB = new HashSet<>(compA);
        intersecaoCompAB.retainAll(compB);
        
        System.out.println("🎯 Lei de De Morgan 1: (A ∪ B)⁻ = Ā ∩ B̄");
        System.out.println("(A ∪ B)⁻ = " + new TreeSet<>(compUniaoAB));
        System.out.println("Ā ∩ B̄ = " + new TreeSet<>(intersecaoCompAB));
        System.out.println("Iguais? " + compUniaoAB.equals(intersecaoCompAB) + " ✓");
        System.out.println();
        
        // Complemento do complemento
        Set<Integer> compCompA = new HashSet<>(U);
        compCompA.removeAll(compA);
        
        System.out.println("🎯 Lei do Duplo Complemento: (Ā)⁻ = A");
        System.out.println("(Ā)⁻ = " + new TreeSet<>(compCompA));
        System.out.println("A = " + new TreeSet<>(A));
        System.out.println("Iguais? " + compCompA.equals(A) + " ✓");
        System.out.println();
        
        System.out.println("🔍 PROPRIEDADES DO COMPLEMENTO:");
        System.out.println("• A ∪ Ā = U (união com complemento = universo)");
        System.out.println("• A ∩ Ā = ∅ (interseção com complemento = vazio)");
        System.out.println("• (Ā)⁻ = A (duplo complemento)");
        System.out.println("• Ū = ∅ (complemento do universo = vazio)");
        System.out.println("• ∅̄ = U (complemento do vazio = universo)");
        System.out.println();
        
        System.out.println("🧮 LEIS DE DE MORGAN:");
        System.out.println("• (A ∪ B)⁻ = Ā ∩ B̄");
        System.out.println("• (A ∩ B)⁻ = Ā ∪ B̄");
        System.out.println("═".repeat(62));
    }
    
    /**
     * Demonstra subconjuntos e inclusão
     */
    public static void subconjuntosInclusao() {
        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║              ⊆ SUBCONJUNTOS E INCLUSÃO ⊆                   ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
        System.out.println();
        
        System.out.println("📐 DEFINIÇÃO:");
        System.out.println("A ⊆ B ⟺ (∀x)(x ∈ A ⟹ x ∈ B)");
        System.out.println("\"A é subconjunto de B se todo elemento de A também está em B\"");
        System.out.println();
        
        System.out.println("🎯 EXEMPLO HIERÁRQUICO:");
        Set<Integer> N = new HashSet<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        Set<Integer> P = new HashSet<>(Arrays.asList(2, 4, 6, 8, 10));
        Set<Integer> M4 = new HashSet<>(Arrays.asList(4, 8));
        Set<Integer> S = new HashSet<>(Arrays.asList(4));
        
        System.out.println("N = " + new TreeSet<>(N) + " (naturais até 10)");
        System.out.println("P = " + new TreeSet<>(P) + " (pares)");
        System.out.println("M4 = " + new TreeSet<>(M4) + " (múltiplos de 4)");
        System.out.println("S = " + new TreeSet<>(S) + " (singleton)");
        System.out.println();
        
        System.out.println("📊 RELAÇÕES DE INCLUSÃO:");
        System.out.println("S ⊆ M4? " + M4.containsAll(S) + " ✓");
        System.out.println("M4 ⊆ P? " + P.containsAll(M4) + " ✓");
        System.out.println("P ⊆ N? " + N.containsAll(P) + " ✓");
        System.out.println();
        System.out.println("Hierarquia: S ⊆ M4 ⊆ P ⊆ N");
        System.out.println();
        
        System.out.println("🔢 CONJUNTO DAS PARTES:");
        Set<Integer> A = new HashSet<>(Arrays.asList(1, 2));
        System.out.println("A = " + new TreeSet<>(A));
        System.out.println();
        System.out.println("P(A) = conjunto de todos os subconjuntos de A");
        System.out.println("P(A) = {∅, {1}, {2}, {1, 2}}");
        System.out.println();
        
        List<Set<Integer>> partesA = new ArrayList<>();
        partesA.add(new HashSet<>());  // ∅
        partesA.add(new HashSet<>(Arrays.asList(1)));  // {1}
        partesA.add(new HashSet<>(Arrays.asList(2)));  // {2}
        partesA.add(new HashSet<>(Arrays.asList(1, 2)));  // {1, 2}
        
        System.out.println("📋 VERIFICAÇÃO DOS SUBCONJUNTOS:");
        for (int i = 0; i < partesA.size(); i++) {
            Set<Integer> subset = partesA.get(i);
            boolean isSubset = A.containsAll(subset);
            System.out.println((i+1) + ". " + (subset.isEmpty() ? "∅" : new TreeSet<>(subset)) + 
                             " ⊆ A? " + isSubset + " ✓");
        }
        System.out.println();
        
        System.out.println("🧮 FÓRMULA DA CARDINALIDADE:");
        System.out.println("Se |A| = n, então |P(A)| = 2ⁿ");
        System.out.println("Para A = {1, 2}: |A| = 2, logo |P(A)| = 2² = 4 ✓");
        System.out.println();
        
        System.out.println("🔍 PROPRIEDADES DA INCLUSÃO:");
        System.out.println("• Reflexiva: A ⊆ A (todo conjunto é subconjunto de si)");
        System.out.println("• Transitiva: A ⊆ B e B ⊆ C ⟹ A ⊆ C");
        System.out.println("• Antissimétrica: A ⊆ B e B ⊆ A ⟹ A = B");
        System.out.println("• ∅ ⊆ A (vazio é subconjunto de qualquer conjunto)");
        System.out.println("• A ⊆ U (qualquer conjunto é subconjunto do universo)");
        System.out.println();
        
        System.out.println("⚠️ INCLUSÃO PRÓPRIA (⊂):");
        System.out.println("A ⊂ B ⟺ A ⊆ B e A ≠ B");
        System.out.println("\"A é subconjunto próprio de B\"");
        System.out.println("Exemplo: P ⊂ N (pares são subconjunto próprio dos naturais)");
        System.out.println("═".repeat(62));
    }
    
    
    /**
     * Demonstra diagramas de Venn em ASCII
     */
    public static void diagramasVenn() {
        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║                 🎨 DIAGRAMAS DE VENN 🎨                     ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
        System.out.println();
        
        System.out.println("🎯 REPRESENTAÇÃO VISUAL DAS OPERAÇÕES:");
        System.out.println();
        
        System.out.println("1️⃣ UNIÃO (A ∪ B):");
        System.out.println("┌─────────────────────────────┐");
        System.out.println("│    ╭─────────╮              │");
        System.out.println("│    │  ██████ │ ╮            │");
        System.out.println("│    │ ██████████│██           │");
        System.out.println("│    │ ██████████│████         │  U");
        System.out.println("│    │ ██████████│██           │");
        System.out.println("│    │  ██████ │ ╯            │");
        System.out.println("│    ╰─────────╯              │");
        System.out.println("│         A     B              │");
        System.out.println("└─────────────────────────────┘");
        System.out.println("Área sombreada: A ∪ B");
        System.out.println();
        
        System.out.println("2️⃣ INTERSEÇÃO (A ∩ B):");
        System.out.println("┌─────────────────────────────┐");
        System.out.println("│    ╭─────────╮              │");
        System.out.println("│    │         │ ╮            │");
        System.out.println("│    │    ██████│              │");
        System.out.println("│    │    ██████│              │  U");
        System.out.println("│    │    ██████│              │");
        System.out.println("│    │         │ ╯            │");
        System.out.println("│    ╰─────────╯              │");
        System.out.println("│         A     B              │");
        System.out.println("└─────────────────────────────┘");
        System.out.println("Área sombreada: A ∩ B");
        System.out.println();
        
        System.out.println("3️⃣ DIFERENÇA (A - B):");
        System.out.println("┌─────────────────────────────┐");
        System.out.println("│    ╭─────────╮              │");
        System.out.println("│    │ ███████ │ ╮            │");
        System.out.println("│    │ ███     │              │");
        System.out.println("│    │ ███     │              │  U");
        System.out.println("│    │ ███     │              │");
        System.out.println("│    │ ███████ │ ╯            │");
        System.out.println("│    ╰─────────╯              │");
        System.out.println("│         A     B              │");
        System.out.println("└─────────────────────────────┘");
        System.out.println("Área sombreada: A - B");
        System.out.println();
        
        System.out.println("4️⃣ COMPLEMENTO (Ā):");
        System.out.println("┌─────────────────────────────┐");
        System.out.println("│████╭─────────╮██████████████│");
        System.out.println("│████│         │██████████████│");
        System.out.println("│████│         │██████████████│");
        System.out.println("│████│    A    │██████████████│  U");
        System.out.println("│████│         │██████████████│");
        System.out.println("│████│         │██████████████│");
        System.out.println("│████╰─────────╯██████████████│");
        System.out.println("└─────────────────────────────┘");
        System.out.println("Área sombreada: Ā");
        System.out.println();
        
        System.out.println("🎯 EXEMPLO NUMÉRICO:");
        System.out.println("U = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}");
        System.out.println("A = {2, 4, 6, 8}");
        System.out.println("B = {6, 7, 8, 9}");
        System.out.println();
        System.out.println("A ∪ B = {2, 4, 6, 7, 8, 9}");
        System.out.println("A ∩ B = {6, 8}");
        System.out.println("A - B = {2, 4}");
        System.out.println("Ā = {1, 3, 5, 7, 9, 10}");
        System.out.println("═".repeat(62));
    }
    
    /**
     * Apresenta fórmulas e propriedades
     */
    public static void formulasPropriedades() {
        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║               📐 FÓRMULAS E PROPRIEDADES 📐                 ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
        System.out.println();
        
        System.out.println("🧮 FÓRMULAS FUNDAMENTAIS:");
        System.out.println();
        System.out.println("📊 CARDINALIDADE:");
        System.out.println("• n(A ∪ B) = n(A) + n(B) - n(A ∩ B)");
        System.out.println("• n(A - B) = n(A) - n(A ∩ B)");
        System.out.println("• n(Ā) = n(U) - n(A)");
        System.out.println("• n(P(A)) = 2^n(A)");
        System.out.println();
        
        System.out.println("🔄 LEIS COMUTATIVAS:");
        System.out.println("• A ∪ B = B ∪ A");
        System.out.println("• A ∩ B = B ∩ A");
        System.out.println();
        
        System.out.println("🔗 LEIS ASSOCIATIVAS:");
        System.out.println("• (A ∪ B) ∪ C = A ∪ (B ∪ C)");
        System.out.println("• (A ∩ B) ∩ C = A ∩ (B ∩ C)");
        System.out.println();
        
        System.out.println("🔄 LEIS DISTRIBUTIVAS:");
        System.out.println("• A ∪ (B ∩ C) = (A ∪ B) ∩ (A ∪ C)");
        System.out.println("• A ∩ (B ∪ C) = (A ∩ B) ∪ (A ∩ C)");
        System.out.println();
        
        System.out.println("🧠 LEIS DE DE MORGAN:");
        System.out.println("• (A ∪ B)⁻ = Ā ∩ B̄");
        System.out.println("• (A ∩ B)⁻ = Ā ∪ B̄");
        System.out.println();
        
        System.out.println("⚡ LEIS DE ABSORÇÃO:");
        System.out.println("• A ∪ (A ∩ B) = A");
        System.out.println("• A ∩ (A ∪ B) = A");
        System.out.println();
        
        System.out.println("🎯 ELEMENTOS NEUTROS:");
        System.out.println("• A ∪ ∅ = A (vazio é neutro da união)");
        System.out.println("• A ∩ U = A (universo é neutro da interseção)");
        System.out.println();
        
        System.out.println("💥 ELEMENTOS ABSORVENTES:");
        System.out.println("• A ∪ U = U (universo absorve na união)");
        System.out.println("• A ∩ ∅ = ∅ (vazio absorve na interseção)");
        System.out.println();
        
        System.out.println("🔄 LEIS DE IDEMPOTÊNCIA:");
        System.out.println("• A ∪ A = A");
        System.out.println("• A ∩ A = A");
        System.out.println();
        
        System.out.println("⚡ LEIS DE COMPLEMENTO:");
        System.out.println("• A ∪ Ā = U");
        System.out.println("• A ∩ Ā = ∅");
        System.out.println("• (Ā)⁻ = A");
        System.out.println("• Ū = ∅, ∅̄ = U");
        System.out.println();
        
        System.out.println("🎯 EXEMPLO DE APLICAÇÃO:");
        System.out.println("Simplificar: (A ∪ B) ∩ (A ∪ B̄)");
        System.out.println();
        System.out.println("Usando distributiva:");
        System.out.println("= A ∪ (B ∩ B̄)");
        System.out.println("= A ∪ ∅");
        System.out.println("= A");
        System.out.println();
        System.out.println("✅ Resultado: (A ∪ B) ∩ (A ∪ B̄) = A");
        System.out.println("═".repeat(62));
    }
}
