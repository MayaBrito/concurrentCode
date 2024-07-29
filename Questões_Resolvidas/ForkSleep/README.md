# Fork-sleep-join

Crie um programa que recebe um número inteiro n como argumento e cria n threads.
Cada uma dessas threads deve dormir por um tempo aleatório de no máximo 5 segundos.
A main-thread deve esperar todas as threads filhas terminarem de executar para em
seguida escrever na saída padrão o valor de n. Faça a thread-mãe esperar as filhas
de duas maneiras: 

- 1. Usando o equivalente à função join em C ou Java; 
- 2. Usando semáforos.