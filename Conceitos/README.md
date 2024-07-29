# Concorrência em Linguagens de Programação

Irei abordar alguns conceitos aqui de forma objetiva, se quiser um pouco mais de detalhe sobre algum conteúdo procure a sessão no repositorio referente ao mesmo.

## `Conceitos Básicos`

A concorrência em programação refere-se à capacidade de um programa executar múltiplas tarefas simultaneamente. Isso permite que o programa utilize melhor os recursos do computador, aumentando sua eficiência e capacidade de resposta. Existem duas formas principais de implementar a concorrência:

1. **Multitarefa Preemptiva**: O sistema operacional divide o tempo do processador entre as diferentes tarefas, executando-as em curtos intervalos de tempo.
2. **Multitarefa Cooperativa**: As tarefas cooperam entre si para ceder o tempo do processador umas às outras.

`Para entender um pouco mais sobre esses conceitos veja a sessão de Multitarefa`

## `Conceitos importantes em concorrência:`

- **Processo**: Uma instância em execução de um programa.
- **Thread**: Um subconjunto de um processo que pode ser executado de forma independente.
- **Sincronização**: Mecanismos para coordenar o acesso a recursos compartilhados por diferentes threads.
- **Comunicação entre threads**: Mecanismos para que as threads troquem informações entre si.

## Problemas de concorrência:

- **Deadlocks**: Quando duas ou mais threads se bloqueiam esperando uma pela outra liberar um recurso.
- **Condições de corrida**: Quando o resultado de um programa depende da ordem de execução das threads.
- **Inanição (Starvation)**: Uma thread fica indefinidamente bloqueada sem conseguir acessar recursos essenciais.

### Descrição mais detalhada sobre um dos problemas citados acima

#### O que são deadlocks?

Deadlocks são erros de programação que ocorrem quando duas ou mais threads se bloqueiam esperando uma pela outra liberar um recurso que a outra precisa, levando a um impasse.

#### Impacto dos deadlocks:

- Congelamentos e travamentos do programa.
- Perda de dados.
- Comportamento imprevisível.

###   Exemplo de solução: Semáforos

#### Problemas de concorrência resolvidos por semáforos:

- **Deadlocks**: Garantem que apenas uma thread possa acessar um recurso crítico por vez.
- **Condições de corrida**: Asseguram que o acesso aos recursos compartilhados seja ordenado e consistente.
- **Inanição**: Implementam algoritmos que garantem que todas as threads tenham a chance de acessar os recursos.

#### Exemplo Prático:

Imagine um banco de dados com diversas threads realizando operações simultâneas. Semáforos podem ser utilizados para controlar o acesso à base de dados, garantindo a consistência dos dados e prevenindo erros.

---

### Multithreading e Multiprocessamento

#### Multithreading

- Divide um processo em threads mais leves que compartilham recursos como memória e espaço de endereço.
- Ideal para tarefas que podem ser divididas em subtarefas menores e independentes.

#### Multiprocessamento

- Utiliza múltiplos processos, cada um com seu próprio espaço de memória e contexto de execução.
- Ideal para tarefas pesadas e independentes que não precisam compartilhar memória.

#### Escolhendo entre Multithreading e Multiprocessamento:

- **Tipo de tarefa**: Tarefas independentes e pesadas são mais adequadas para Multiprocessamento, enquanto tarefas interdependentes e leves podem se beneficiar do Multithreading.
- **Recursos do hardware**: Multiprocessamento se beneficia de CPUs multinúcleo, enquanto Multithreading pode ter bom desempenho em CPUs com um único núcleo.
- **Linguagem de programação**: Algumas linguagens possuem suporte nativo ao Multithreading e Multiprocessamento, enquanto outras exigem bibliotecas ou frameworks específicos.

---

## Por que Desenvolver Programas Concorrentes?

### Benefícios da Concorrência

1. **Maior Eficiência e Capacidade de Resposta:**
   - **Melhor Utilização dos Recursos:** Programas concorrentes podem utilizar mais efetivamente os recursos disponíveis, como múltiplos núcleos de CPU. Isso permite que tarefas sejam executadas em paralelo, aumentando o throughput geral do sistema.
   - **Redução de Latência:** A concorrência pode melhorar a capacidade de resposta de um sistema, especialmente em aplicações que dependem de operações I/O. Enquanto uma tarefa está esperando por um recurso, outras podem continuar executando.

2. **Modularidade:**
   - **Isolamento de Tarefas:** Ao dividir um programa em componentes concorrentes, cada tarefa ou módulo pode ser desenvolvido, testado e mantido de forma independente. Isso facilita a identificação e a correção de problemas, bem como a implementação de melhorias.
   - **Escalabilidade:** Programas concorrentes são mais fáceis de escalar, pois novas funcionalidades podem ser adicionadas como novos módulos concorrentes. Isso permite que o sistema cresça de maneira organizada e eficiente.

A concorrência não só melhora a performance, como também facilita o desenvolvimento de sistemas mais robustos e flexíveis.

