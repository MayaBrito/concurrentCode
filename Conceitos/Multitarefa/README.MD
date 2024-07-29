# `Conceitos Básicos`

A concorrência em programação refere-se à capacidade de um programa executar múltiplas tarefas simultaneamente. Isso permite que o programa utilize melhor os recursos do computador, aumentando sua eficiência e capacidade de resposta. Existem duas formas principais de implementar a concorrência:

## `Multitarefa Preemptiva (preemptive multitasking)`

A multitarefa preemptiva é uma técnica onde o sistema operacional interrompe periodicamente a execução de um programa e passa o controle para outro que está em espera. Esse método impede que um único programa monopolize os recursos do sistema, sendo também conhecido como "time-slice multitasking", ou seja, **o sistema operacional divide o tempo do processador entre as diferentes tarefas, executando-as em curtos intervalos de tempo**.

### Vantagens

1. **Maximização do uso do processador:** O sistema operacional alterna rapidamente entre programas, geralmente em milissegundos ou microssegundos, permitindo uma utilização mais eficiente do processador.
2. **Gerenciamento de múltiplas tarefas:** Essencial para sistemas operacionais de desktop, servidores e dispositivos móveis que precisam lidar com várias tarefas simultâneas, como em servidores web que gerenciam múltiplas solicitações.

### Desvantagens

1. **Overhead de contexto:** O processo de salvar o estado atual de um programa e carregar o estado de outro pode consumir tempo e recursos.
2. **Consumo de recursos:** A alternância rápida entre muitos programas pode afetar o desempenho geral do sistema.

A multitarefa preemptiva requer uma gestão cuidadosa para otimizar a eficiência e manter o sistema responsivo.

## `Multitarefa Cooperativa (cooperative multitasking)`

A multitarefa cooperativa é um método onde várias tarefas são executadas simultaneamente, mas o controle do tempo de processamento é gerido pelas próprias tarefas. Diferente da multitarefa preemptiva, aqui, uma tarefa em execução (foreground) decide quando liberar o processador para outras tarefas, ou seja, **as tarefas cooperam entre si para ceder o tempo do processador umas às outras**.

### Características Principais

1. **Controle pelas Tarefas:** As tarefas decidem quando liberar o processador, o que significa que a tarefa em primeiro plano tem total controle sobre o tempo de processamento.
2. **Alternância Voluntária:** A troca entre tarefas ocorre apenas quando a tarefa em execução decide liberar o processador, geralmente durante períodos de espera ou quando não necessita de recursos adicionais.
3. **Prioridade da Tarefa Ativa:** A tarefa de primeiro plano tem prioridade sobre o processador, podendo bloquear tarefas de segundo plano.

### Vantagens

1. **Economia de Recursos:** Evita a troca de contexto frequente, economizando recursos do sistema.
2. **Simplicidade de Implementação:** É mais fácil de implementar em comparação com a multitarefa preemptiva.

### Desvantagens

1. **Dependência da Cooperação:** A eficiência depende da disposição das tarefas de liberar o processador; uma tarefa pode monopolizar o sistema.
2. **Ineficiência Potencial:** Tarefas em primeiro plano podem manter o controle do processador por muito tempo, causando ineficiência no uso de recursos.
