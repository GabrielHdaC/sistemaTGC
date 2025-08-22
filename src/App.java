/**
 * ============================================================================
 *                    SISTEMA EDUCACIONAL DE CONJUNTOS - TGC
 * ============================================================================
 * 
 * Aplicação principal para ensino e aprendizagem de Teoria dos Conjuntos.
 * 
 * Este sistema oferece uma interface educacional completa com:
 * - Conceitos teóricos fundamentais
 * - Operações matemáticas entre conjuntos
 * - Problemas práticos e exercícios
 * - Ferramentas avançadas de gestão de dados
 * 
 * @author Sistema TGC
 * @version 2.0 - Edição Profissional
 * @since 2025
 * 
 * Arquitetura:
 * - main/     : Classe principal de inicialização
 * - core/     : Lógica central do sistema
 * - ui/       : Interfaces de usuário
 * - modules/  : Módulos funcionais especializados
 * - utils/    : Utilitários e ferramentas auxiliares
 * ============================================================================
 */
public class App {
    
    /**
     * Ponto de entrada principal da aplicação.
     * 
     * Inicializa o sistema educacional e transfere o controle para
     * o controlador principal que gerencia toda a experiência do usuário.
     * 
     * @param args Argumentos de linha de comando (não utilizados)
     */
    public static void main(String[] args) {
        System.out.println("📚 Iniciando Sistema Educacional de Conjuntos...");
        System.out.println("🔧 Carregando módulos e dependências...");
        
        try {
            SistemaEducacional sistema = new SistemaEducacional();
            sistema.executar();
        } catch (Exception e) {
            System.err.println("❌ Erro fatal durante execução: " + e.getMessage());
            System.err.println("📋 Detalhes técnicos: " + e.getClass().getSimpleName());
        }
        
        System.out.println("👋 Sistema finalizado. Obrigado por usar!");
    }
}
