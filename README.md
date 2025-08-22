# 🎓 Sistema Educacional TGS - Teoria dos Conjuntos

Sistema educacional interativo para aprendizagem de Teoria dos Conjuntos com interface ASCII profissional.

## 🚀 Como Executar

### Método 1: Script Automático (Recomendado)
```cmd
run.bat
```

### Método 2: Manual
```cmd
# Criar pasta build
mkdir build

# Compilar
javac -encoding UTF-8 -d build -cp src src\*.java

# Executar
java "-Dfile.encoding=UTF-8" "-Dconsole.encoding=UTF-8" -cp build App
```

## 📁 Estrutura do Projeto

```
sistemaTGC/
├── src/                    # Código fonte Java
│   ├── App.java           # Classe principal
│   ├── SistemaEducacional.java
│   ├── InterfaceEducacionalASCII.java
│   └── ... (outros módulos)
├── .vscode/               # Configurações VS Code
├── run.bat               # Script de execução
└── README.md
```

## 🎯 Funcionalidades

1. **Teoria dos Conjuntos** - Conceitos fundamentais
2. **Operações Básicas** - União, interseção, diferença
3. **Operações Avançadas** - Produto cartesiano, potência
4. **Problemas Práticos** - Exercícios educacionais
5. **Fundamentos Teóricos** - Paradoxos e conceitos
6. **Gerenciador de Conjuntos** - CRUD completo
7. **Interface ASCII** - Menu interativo
8. **Conjuntos Multi-Tipo** - Números, decimais, texto
9. **Sistema de Persistência** - Salvar/carregar arquivos
10. **Sistema de Exportação** - Relatórios profissionais

## ⚙️ Requisitos

- Java 8 ou superior
- Terminal com suporte a UTF-8
- Windows (testado) / Linux / macOS

## 📝 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## 🎉 Status

✅ Sistema 100% funcional  
✅ UTF-8 configurado  
✅ Código limpo e moderno  
✅ Interface profissional  
✅ Documentação completa  

**Pronto para uso educacional!** 🚀
