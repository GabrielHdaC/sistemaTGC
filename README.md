# Sistema de Operações com Conjuntos em Java

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

