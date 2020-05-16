# UC7 - Remover uma linha de um ficheiro

## 1.Engenharia de Requisitos.
### Formato breve

O utilizador chama um método de uma classe. O sistema remove a linha do ficheiro e retorna o sucesso da operação.

### SSD
![](UC5_SSD.svg)

### Formato Completo

#### Ator Principal
O Utilizador

#### Partes interessadas e seus interesses.

**Utilizador:** pretende remover conteúdo do ficheiro.

#### Pré-condições

Uma instância de IOManager

#### Pós-condições

A linha é removida ao conteúdo, mas não apagada do ficheiro.


#### Cenário de sucesso principal (ou fluxo básico)

1. O Utilizador executa o método removeLine(int index, Key). 
2. O IOManager remove a linha o conteúdo. 



#### Extensões (ou fluxos alternativos)

\-

#### Requisitos especiais

\-

#### Lista de Variações de Tecnologias e Dados

\-

#### Frequência de Ocorrência


\-


## 2. Análise OO

### Excerto do Modelo de Domínio Relevante para o UC

![](UC7_MD.svg)


## 3. Design - Realização do Caso de Uso

### Racional

| Fluxo Principal | Questão: Que Classe... | Resposta  | Justificação  |
|:--------------  |:---------------------- |:----------|:---------------------------- |
| 1. O Utilizador executa o método removeLine(int index, Key).  |...interage com o utilizador?| IOManager|Pure Fabrication|
| |...cordena o caso de uso| FileFireWall|Controller
| 2. O IOManager remove a linha o conteúdo. |...remove a linha do conteúdo?|Manager| Information Expert pois é o responsável por exportar conteúdo para o ficheiro|


### Sistematização ##

Do racional resulta que as classes conceptuais promovidas a classes de software são:

* Manager

Outras classes de software (i.e. Pure Fabrication) identificadas:  

* IOManger
* FileFireWall


###	Diagrama de Sequência

![SD_UCX.png](UC7_SD.svg)


###	Diagrama de Classes

*O diagrama de classes foi omitido pelo simples motivo de ser possível ler o código e o mesmo ser pouco complexo*
 



