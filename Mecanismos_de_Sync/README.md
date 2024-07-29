# Mecanismos de Sincronização

## Produtor-Consumidor - `Buffer.java`

Cenário onde um produtor gera dados e os coloca em um buffer enquanto um consumidor consome os dados do buffer.

- **Problema**: O produtor pode tentar colocar dados no buffer quando este estiver cheio, ou o consumidor pode tentar consumir dados quando o buffer estiver vazio.
- **Solução**: Utilizar um buffer com semáforos para controlar o acesso.

## Multiplex - `Resource.java`

Cenário onde múltiplas threads tentam acessar um recurso crítico ao mesmo tempo.

- **Problema**: Apenas uma thread pode acessar o recurso crítico por vez.

## Rendezvous ou Barreira

Cenário onde duas ou mais threads precisam se encontrar em um ponto específico do programa para trocar informações e realizar tarefas em conjunto antes de prosseguir.

- **Problema**: As threads podem chegar ao ponto de encontro em momentos diferentes.
- **Solução**: Utilizar um mecanismo de rendezvous para bloquear as threads até que todas estejam presentes no ponto de encontro.

## RW Lock (Read-Write Lock)

Cenário onde um recurso precisa ser acessado para leitura por várias threads simultaneamente, mas apenas uma thread pode modificá-lo a qualquer momento.

- **Problema**: O acesso simultâneo de threads para leitura e escrita pode levar a inconsistências nos dados.
- **Solução**: Utilizar um RW lock para controlar o acesso ao recurso.

---
