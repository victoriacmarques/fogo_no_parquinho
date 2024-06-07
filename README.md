# fogo_no_parquinho
Trabalho 1 da cadeira "Gerenciamento de Configuração de Software"

## Descrição

Este projeto é um sistema de gerenciamento de ingressos para um parque de diversões, desenvolvido como parte da disciplina de "Gerenciamento de Configuração de Software". O sistema permite a gestão de visitantes, emissão e cancelamento de ingressos, registro de visitas a atrações, e consulta de faturamento e visitantes.

## Funcionalidades

1. **Cadastro de Visitantes**
   - O sistema permite ao operador cadastrar um novo visitante e listar os atuais visitantes já cadastrados.

2. **Emissão de Ingressos**
   - O sistema permite emitir um novo ingresso para um dia, seguindo a sequência daquele dia e até o limite de 500 ingressos por dia, associando-o a um visitante já cadastrado.

3. **Cadastro de Atrações**
   - O sistema inicia com todas as atrações do parque já cadastradas (sejam criativos!).

4. **Registro de Visitas às Atrações**
   - O sistema permite ao operador registrar que um visitante foi em determinada atração. Um visitante pode ir em qualquer atração no dia do ingresso, inclusive pode ir na mesma atração mais de uma vez.

5. **Localização de Visitantes**
   - O sistema permite que o operador localize um visitante por parte de seu nome ou pela identificação do ingresso. Ao localizar o visitante, o sistema lista todas as atrações em que o visitante esteve.

6. **Consulta de Faturamento**
   - O sistema permite ao operador consultar o faturamento de um determinado mês/ano, somando os valores dos ingressos dos respectivos dias.

7. **Consulta de Visitantes por Atração**
   - O sistema permite ao operador consultar, para uma determinada data, todas as atrações do parque e a quantidade de visitantes que utilizou cada uma delas, ordenadas da mais visitada à menos visitada.

8. **Cancelamento de Ingressos**
   - O sistema permite ao operador cancelar um ingresso emitido para um visitante, desde que o ingresso não tenha sido utilizado em nenhuma atração do parque. Esse ingresso só poderá ser reativado pelo mesmo visitante que solicitou o cancelamento, sem impactar os ingressos dos demais visitantes.

9. **Consulta de Total de Visitantes**
   - O sistema permite ao operador consultar o número total de visitantes presentes no parque em um determinado dia.

## Classes

### 1. **Adulto**
   Representa um visitante adulto do parque.

### 2. **Atracao**
   Enumeração que representa as atrações do parque.

### 3. **Crianca**
   Representa um visitante criança do parque.

### 4. **GestaoDeAtracoes**
   Gerencia as atrações do parque.

### 5. **GestaoDeIngressos**
   Gerencia os ingressos do parque.

### 6. **GestaoDeVisitantes**
   Gerencia os visitantes do parque.

### 7. **Ingresso**
   Representa um ingresso do parque de diversões.

### 8. **Main**
   Classe principal para iniciar o sistema de ingressos do parque de diversões.

### 9. **RegistroAtracao**
   Representa o registro de um visitante em uma atração do parque.

### 10. **SistemaDeIngressos**
   Sistema de gerenciamento de ingressos do parque de diversões.

### 11. **Visitante**
   Representa um visitante do parque.

## Como Executar

Para executar o sistema, utilize a classe `Main` que contém o método `main` responsável por iniciar o programa.

1. Compile todas as classes:
   ```sh
   javac *.java

