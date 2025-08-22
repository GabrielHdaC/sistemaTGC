# Sistema de Conjuntos - Versão Melhorada 🎯

Um sistema interativo em Java para realizar operações matemáticas entre conjuntos de números inteiros.

## 🚀 Funcionalidades

### Operações Básicas
- ✅ **União (A ∪ B)**: Elementos que estão em A ou B (ou ambos)
- ✅ **Interseção (A ∩ B)**: Elementos que estão em A e B simultaneamente  
- ✅ **Diferença (A - B)**: Elementos que estão em A mas não em B
- ✅ **Diferença (B - A)**: Elementos que estão em B mas não em A

### Operações Avançadas
- ✅ **Diferença Simétrica (A △ B)**: Elementos que estão em A ou B, mas não em ambos
- ✅ **Verificação de Subconjunto**: Verifica se um conjunto é subconjunto de outro
- ✅ **Cardinalidade**: Exibe o número de elementos em cada conjunto

## 🏗️ Arquitetura do Sistema

### Estrutura de Classes

```
src/
├── App.java                    # Classe principal (ponto de entrada)
├── SistemaConjuntos.java      # Controlador principal do sistema
├── ConjuntoOperacoes.java     # Operações matemáticas entre conjuntos
├── InterfaceUsuario.java      # Interface de usuário e validações
└── TesteConjuntos.java        # Testes automatizados do sistema
```

### Princípios Aplicados
- **Separação de Responsabilidades**: Cada classe tem uma função específica
- **Reutilização de Código**: Métodos compartilhados evitam duplicação
- **Tratamento de Exceções**: Validação robusta de entradas
- **Documentação**: Javadoc completo para todas as classes e métodos

## 🎮 Como Usar

### Compilação
```bash
javac *.java
```

### Execução Principal
```bash
java App
```

### Execução dos Testes
```bash
java TesteConjuntos
```

## 📊 Exemplo de Uso

```
=== SISTEMA DE CONJUNTOS ===

Conjunto A: [1, 2, 3, 4, 5] (Cardinalidade: 5)
Conjunto B: [4, 5, 6, 7, 8] (Cardinalidade: 5)

>>> Resultado da União <<<
[1, 2, 3, 4, 5, 6, 7, 8] (Cardinalidade: 8)

>>> Resultado da Interseção <<<
[4, 5] (Cardinalidade: 2)
```

## 🔧 Melhorias Implementadas

### 1. **Modularização**
- ❌ **Antes**: Todo código no método `main()`
- ✅ **Depois**: 4 classes especializadas com responsabilidades específicas

### 2. **Tratamento de Erros**
- ❌ **Antes**: Sem validação de entrada
- ✅ **Depois**: Validação completa com `InputMismatchException`

### 3. **Interface de Usuário**
- ❌ **Antes**: Interface básica e repetitiva
- ✅ **Depois**: Interface rica com emojis, mensagens claras e validações

### 4. **Funcionalidades**
- ❌ **Antes**: 3 operações básicas
- ✅ **Depois**: 7 operações incluindo diferença simétrica e subconjuntos

### 5. **Reutilização**
- ❌ **Antes**: Código duplicado para inserção e ordenação
- ✅ **Depois**: Métodos reutilizáveis e clean code

### 6. **Testes**
- ❌ **Antes**: Sem testes automatizados
- ✅ **Depois**: Classe de testes completa para validação

## 🎯 Benefícios da Refatoração

1. **Manutenibilidade**: Código mais fácil de manter e modificar
2. **Escalabilidade**: Estrutura preparada para novas funcionalidades  
3. **Confiabilidade**: Tratamento robusto de erros e validações
4. **Experiência do Usuário**: Interface mais amigável e informativa
5. **Qualidade**: Código bem documentado e testado

## 🚀 Próximos Passos Sugeridos

- [ ] Implementar conjuntos de outros tipos (String, Double)
- [ ] Adicionar persistência de dados (salvar/carregar conjuntos)
- [ ] Interface gráfica com JavaFX ou Swing
- [ ] Exportação de resultados para arquivo
- [ ] Histórico de operações realizadas
- [ ] Conjuntos nomeados pelo usuário

## 👨‍💻 Tecnologias

- **Java 8+**
- **Collections Framework**
- **Scanner para entrada de dados**
- **Javadoc para documentação**

---

**Desenvolvido com ❤️ para demonstrar boas práticas de programação em Java**

Este projeto implementa um sistema simples para trabalhar com **conjuntos de números inteiros**, permitindo inserir elementos, exibir os conjuntos ordenados e realizar operações básicas: **união, interseção e diferença**.

---

## Tecnologias utilizadas

- **Java 8+**
- Bibliotecas padrão: `Scanner`, `HashSet`, `Set`, `ArrayList`, `Collections`

---

## Funcionalidades

1. **Entrada de dados**  
   - O usuário insere valores para **Conjunto A** e **Conjunto B**.  
   - É possível adicionar quantos valores desejar, decidindo quando parar.

2. **Exibição de conjuntos ordenados**  
   - Após a inserção, os conjuntos são convertidos em listas e exibidos em **ordem crescente**.

3. **Operações de conjuntos**  
   - **União**: combina todos os elementos de A e B, removendo duplicatas.  
   - **Interseção**: retorna apenas os elementos que estão em ambos os conjuntos.  
   - **Diferença (A - B)**: retorna os elementos que estão em A, mas não em B.

4. **Interface de menu**  
   - Menu principal para iniciar o sistema ou sair.  
   - Menu de operações para escolher qual operação de conjuntos executar.

---

## Estrutura do código

- **Scanner**: usado para ler a entrada do usuário.
- **HashSet**: estrutura de dados que armazena elementos únicos, utilizada para os conjuntos A e B.
- **ArrayList + Collections.sort()**: converte o `Set` em lista para exibir os elementos em ordem crescente.
- **Switch-case**: controla o fluxo do menu principal e das operações de conjuntos.

---

## Fluxo do programa

1. O programa exibe o **menu principal**:
   - `[1] Começar sistema`
   - `[2] Sair`

2. Se o usuário escolher iniciar o sistema:
   1. Os conjuntos A e B são **limpos** para garantir que não haja dados antigos.
   2. O usuário insere elementos em **Conjunto A**.
   3. O usuário insere elementos em **Conjunto B**.
   4. Os conjuntos são exibidos **ordenados**.
   5. É apresentado o **menu de operações**:
      - `[1] União`
      - `[2] Interseção`
      - `[3] Diferença`
   6. O resultado da operação escolhida é exibido na tela.

3. Caso o usuário escolha sair, o programa finaliza.

---

## Exemplo de uso

