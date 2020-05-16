# UC3 - Apagar um ficheiro
## 1.Engenharia de Requisitos.
### Formato breve

O utilizador instancia uma classe com o caminho do ficheiro. Declara um método e o ficheiro é apagado. A instância retorna o sucesso do método.

### SSD
![](UC3_SSD.svg)

### Formato Completo

#### Ator Principal
O Utilizador

#### Partes interessadas e seus interesses.

**Utilizador:** pretende apagar um ficheiro.

#### Pré-condições

\-

#### Pós-condições

O ficheiro é apagado com sucesso.


#### Cenário de sucesso principal (ou fluxo básico)

1. O Utilizador instancia IOManager.
2. O Utilizador chama o método deleteFile().
3. O IOManager apaga o ficheiro.
4. IOManager retorna o sucesso da operação. 



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

![](UC3_MD.svg)


## 3. Design - Realização do Caso de Uso

### Racional

| Fluxo Principal | Questão: Que Classe... | Resposta  | Justificação  |
|:--------------  |:---------------------- |:----------|:---------------------------- |
| 1. O Utilizador instancia IOManager. |...interage com o utilizador?| IOManager|Pure Fabrication|
| |...cordena o caso de uso| FileFireWall|Controller
| 2. O Utilizador chama o método deleteFile().
| 3. O IOManager apaga o ficheiro.|...apaga o ficheiro?|Manager| Creator(Regra 1)|
| 4. IOManager retorna o sucesso da operação.


### Sistematização ##

 Do racional resulta que as classes conceptuais promovidas a classes de software são:

* Manager

Outras classes de software (i.e. Pure Fabrication) identificadas:  

* IOManger
* FileFireWall


###	Diagrama de Sequência

![SD_UCX.png](UC3_SD.svg)


###	Diagrama de Classes

*O diagrama de classes foi omitido pelo simples motivo de ser possível ler o código e o mesmo ser pouco complexo*

<!--![CD_UCX.png](UC3_CD.svg)
