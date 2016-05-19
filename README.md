Especificação e Entrega do Trabalho

Visão Geral

O trabalho que será solicitado visa complementar o conteúdo abordado na disciplina.

Este trabalho deve ser feito em um grupo com 3 alunos.

Os produtos específicos para o projeto ser considerado completo incluem códigos fontes e uma monografia com no máximo 14 páginas no formato da SBC (disponibilizado no moodle), contendo:

Resumo (Não é necessário seguir exatamente a estrutura abaixo. Pode ser suprimido itens que os grupos não julguem necessários)

    Tema e Título do Projeto
    Os nomes dos membros da equipe e N. USP
    Agradecimentos (se for o caso)
    Introdução e descrição do Problema
    Fundamentação Teórica
    Detalhamento da soluçao
    Metodologia, ambientes e ferramentas Utilizadas
    Modelagem do sistema a ser desenvolvido/estudado
    Conclusões
    Referências Bibliográficas

Tema do Projeto

O tema do projeto se resume no desenvolvimento de uma aplicação cliente-servidor de urna eletrônica com Socket (TCP) de acordo com os requisitos listados abaixo:

    Ser implementado exclusivamente na Linguagem Java;
    Utilizar sockets;
    Utilize uma classe “Candidato” que contém os seguintes atributos
        int código_votacao;
        String nome_candidato
        String partido
        int num_votos

    O lado cliente deve possuir uma interface (gráfica ou não) de votação com os seguinte menu:

            1 - Votar (Irá solicitar o código de votação de um candidato)

            2 - Votar branco

            3 - Votar nulo

            999 - Carregar a lista de candidatos do servidor (Nesta opção deve-se enviar uma mensagem ao servidor com um código (ex.: 999) que irá direcionar qual operação será realizada.

            888 – Finalizar as votações da urna e enviar ao servidor

Restrições:

- A urna só permitirá votações votações caso a lista de candidatos já tenha sido carregada
do servidor;
- A urna só permitirá enviar os resultados da urna ao servidor, caso haja no mínimo uma
votação realizada.

O lado do servidor deve possuir uma interface texto que irá:

- Abrir uma thread para controlar novas conexões, em que cada conexão poderá variar deacordo com um “opcode” vindo do cliente:

        “opcode == 999” - Abre uma conexão que irá enviar a lista de candidatos ao cliente;
        “opcode == 888” - Abre uma conexão que irá receber os votos de cada candidato da urna.

    Após o início da thread na função “main”, recomenda-se utilizar um laço de repetição infinito para apresentar as parciais de votos computados de cada candidato.

Observações gerais:

– Não é necessário seguir estritamente os mesmos números de controle “opcode”;
– Perceba que ao abrir uma thread para controlar novas conexões no servidor, esta provavelmente precisará abrir uma nova thread para recebimento de votos da urna ou para envio da lista de candidatos;
– Use sua criatividade!

Ambiente de desenvolvimento e execução

Será utilizado o cluster do LaSDPC. As informações de acesso para cada grupo, bem como, cadastro dos usuários estarão disponíveis no moodle.

Critérios de avaliação

A nota final será dada pela seguinte equação: NF = ((0,40*a + 0.35*b + 0.25*c)*d), em que:

a = Avaliação da funcionalidade em relação ao enunciado: 40%;
b = Avaliação do código fonte: 35%;
c = Avaliação da documentação: 25%;
d = Avaliação da apresentação: Nota individual aos membros do grupo com valor entre 0 e 1;

Cada grupo terá 15 minutos para apresentar. Após a apresentação perguntas direcionadas aos membros do grupo permitirão avaliar o conhecimento do respectivo membro sobre o projeto desenvolvido, considerando aspectos de implementação e conceitos ligados à disciplina.

Considerações Finais

1. O entendimento da proposta, decisões sobre implementação, investigação sobre os conceitos exigidos fazem parte da avaliação final.
2. Se não for enviado o código fonte e a devida documentação, o grupo automaticamente receberá a nota zero.
3. Casos de cópias de trabalhos ocasionarão nota zero para todos os trabalhos semelhantes. É importante destacar que caso isso ocorra, a reprovação na disciplina é uma consequência devido aos critérios de avaliação da disciplina.
4. Os grupos poderão ser entrevistados pelo professor e estagiário PAE individualmente, de acordo com a necessidade, em datas e horários a serem definidos.

Entrega Final  e Códigos

    A monografia deve ser entregue em um formato padrão que está disponível para download no moodle.
    Os códigos também devem ser enviados para um repositório git
    A monografia deve ter no máximo 14 páginas e ser feita via moodle por um dos membros eleitos pelo grupo.

Entrega

28/06/16

06:00h

Apresentação

28/06/15 (Manhã e Tarde)




## Referências

http://www.tutorialspoint.com/swing/swing_event_handling.htm

https://docs.oracle.com/javase/tutorial/uiswing/layout/grid.html

http://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html

https://docs.oracle.com/javase/tutorial/uiswing/examples/layout/GridBagLayoutDemoProject/src/layout/GridBagLayoutDemo.java
