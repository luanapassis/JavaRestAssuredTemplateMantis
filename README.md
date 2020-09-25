# JavaRestAssuredTemplate

	-Automação contém 50 scripts de testes que executam na api do Mantis LocalHost.
	-Na instalação do mantis, utilizar o prefixo mantis_ nas tabelas do sistema.
	-Contém construção de requisições a partir de objetos
	-Contém construção de requisições a partir de objetos utilizando a biblioteca net.minidev.json

## Automação

- Arquitetura Projeto
	- Linguagem		- JAVA
	- Versão Java - Java 1.8.0
	- Orquestrador de testes - TestNG 7.1.0
	- Relatório de testes automatizados - ExtentReports 4.1.3
	- Framework interação com API - RestAssured 4.3.0 

## Execução em Paralelo

Para execução de testes em paralelo, adicionar as tags parallel e thread na tag suite do arquivo testng.xml
Exemplo:
<suite name="All Test Suite"  parallel="methods" thread-count="3" >	

*o paralelismo não está passando os casos de testes devido a conexão com o banco e criação de massa de teste no @before

## Execução no Azuere

Configuração do Agente local:
https://docs.microsoft.com/en-us/azure/devops/pipelines/agents/v2-windows?view=azure-devops&viewFallbackFrom=vsts

## Execução no Jenkins

Configuração do build no Jenkins: 
	-Baixar o maven Binary zip archive no site https://maven.apache.org/download.cgi 
	-Descompactar numa pasta do sistema 
	-Incluir o caminho xxx\apache-maven-x.x.x\bin na variavel path do windows

	-No jenkins Acessar Global Tool Configuration 
	-Configurar o jkd e o maven exemplo https://subscription.packtpub.com/book/networking_and_servers/9781786465702/2/ch02lvl1sec16/configuring-java-and-maven-in-jenkins

	-Criar um Job de maven 
	-No Construir adicionar o caminho do POM.xml xxx\templateJava\pom.xml 
	-No metas e opções usar o "clean test"

obs: é necessário usar os plugins do maven no POM e criar o arquivo testng.xml onde contem todos os casos de testes que serão executados.

## Arquitetura

**Premissas de uma boa arquitetura de automação de testes:**
*  Facilitar o desenvolvimento dos testes automatizados (reuso).
*  Facilitar a manutenção dos testes (refatoração).
*  Tornar o fluxo do teste o mais legível possível (fácil entendimento do que está sendo testado).

**Estrutura da arquitetura**

  - Bases ("contem as bases para requisições REST e SOAP alem da base para os testes")
  - DbSteps ("Contem classe para queries utilizadas no projeto")
  - Helpers ("Contem metodos auxiliares para os projetos")
  - Enuns ("Contem enums utilizados na arquitetura do projeto")
  - Models ("Contem classes para construção de objetos para envio no body das requisições Rest")
  - Requests ("Diretorio para armazenar as requisições do projeto")
  - Tests ("Diretorio para armazenar os testes do projeto")
  
 **Padrões por tipo de componente**

* Pacotes: começam sempre com letra minuscula. Ex: `pages, dataBaseSteps, bases`
* Classes: começam sempre com letra maiúscula. Ex: `LoginRequest, LoginTests`
* Arquivos: começam sempre com letra minuscula. Ex: `dataDrivenFile.csv`
* Métodos: começam sempre com letra minuscula. Ex: `verificarElementoXPTO()`
* Variáveis: começam sempre com letra minúscula. Ex: `botaoXPTO`
* Objetos: começam sempre com letra minúscula. Ex: `request`

No caso de palavras com uma letra, as duas devem ser escritas juntas de acordo com o padrão do tipo que será nomeado, ex:`retornaSeValorEOEsperado()`



**Padrões de escrita: Classes e Arquivos**

Nomes de classes e arquivos devem terminar com o tipo de conteúdo que representam, em inglês, ex:

```
LoginTests (classe de testes)
loginTestData.csv (planilha de dados)
```

OBS: Atenção ao plural e singular! Se a classe contém um conjunto do tipo que representa, esta deve ser escrita no plural, caso seja uma entidade, deve ser escrita no singular.


**Padrões de escrita: Geral**

Nunca utilizar acentos, caracteres especiais e “ç” para denominar pastas, classes, métodos, variáveis, objetos e arquivos.

**Padrões de escrita: Objetos**

Nomes dos objetos devem ser exatamente os mesmos nomes de suas classes, iniciando com letra minúscula, ex:

```
LoginRequest (classe) loginRequest (objeto)
LoginFlows (classe) loginFlows (objeto)
```
