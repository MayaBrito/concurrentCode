# Problemas em Concorrência

A programação concorrente é uma área essencial no desenvolvimento de sistemas, especialmente em aplicações que exigem alta performance e escalabilidade. No entanto, também apresenta desafios significativos, incluindo problemas como deadlocks, condições de corrida e inanição. Este repositório explora esses problemas, fornecendo explicações e exemplos.

## 1. Deadlocks

**Descrição:** Um deadlock ocorre quando duas ou mais threads se bloqueiam mutuamente, esperando que as outras liberem recursos necessários para prosseguir. Nenhuma das threads pode avançar porque cada uma está esperando que outra libere um recurso, resultando em um ciclo de espera.

**Exemplo:** Considere duas threads, T1 e T2, e dois recursos, R1 e R2. Se T1 possui R1 e precisa de R2 para continuar, enquanto T2 possui R2 e precisa de R1, ambas ficarão bloqueadas esperando a liberação do recurso que a outra detém, criando um deadlock.

**Prevenção:** Para evitar deadlocks, é crucial implementar políticas de aquisição de recursos que evitem ciclos de espera, como a imposição de uma ordem para a aquisição de recursos.

## 2. Condições de Corrida

**Descrição:** Condições de corrida ocorrem quando o comportamento de um programa depende da ordem de execução das threads. Isso pode levar a resultados inesperados ou inconsistentes, especialmente em situações onde múltiplas threads acessam e modificam dados compartilhados.

**Exemplo:** Imagine duas threads incrementando uma variável compartilhada. Se ambas as threads leem o valor inicial ao mesmo tempo, incrementam-no e depois escrevem o valor de volta, o incremento de uma das threads será perdido.

**Prevenção:** O uso de mecanismos de sincronização, como locks e semáforos, pode garantir que apenas uma thread modifique os dados compartilhados por vez, evitando condições de corrida.

## 3. Inanição (Starvation)

**Descrição:** Inanição acontece quando uma thread fica indefinidamente bloqueada, sem conseguir acessar os recursos de que necessita para prosseguir. Isso pode ocorrer quando outras threads monopolizam os recursos, não deixando chance para que a thread bloqueada avance.

**Exemplo:** Em um sistema de agendamento de prioridades, uma thread de baixa prioridade pode nunca ser executada se houver um fluxo constante de threads de alta prioridade que consomem todos os recursos.

**Prevenção:** Técnicas como envelhecimento (aging) podem ser usadas para aumentar gradualmente a prioridade de uma thread que está esperando por um longo tempo, garantindo que ela eventualmente obtenha os recursos necessários.

