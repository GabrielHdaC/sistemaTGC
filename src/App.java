/**
 * Sistema Educacional de Conjuntos - Versão Corrigida
 * 
 * Sistema interativo baseado nos Fundamentos Matemáticos
 * da Profª Drª Janaína Poffo Possamai - FURB
 * 
 * Funcionalidades:
 * - Paradoxos e Fundamentos Teóricos
 * - Teoria dos Conjuntos Completa
 * - Operações Avançadas com Fórmulas
 * - Problemas Práticos e Exercícios
 * - Interface ASCII Compatível com Windows
 * 
 * @author Gabriel Heron
 * @version 3.1 - Interface Corrigida
 */
public class App {
    
    /**
     * Método principal da aplicação
     */
    public static void main(String[] args) {
        System.out.println("Iniciando Sistema Educacional de Conjuntos...");
        SistemaEducacional sistema = new SistemaEducacional();
        sistema.executar();
    }
}
