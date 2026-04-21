# ⛽ Fuel Tank Volume System

Sistema desenvolvido em **Java** com **JavaFX** para auxiliar na medição de tanques de combustível, realizando o cálculo do volume armazenado a partir da medição em centímetros.

O projeto foi desenvolvido como **atividade de extensão universitária**, com foco em aplicar conhecimentos de tecnologia na solução de uma necessidade real de operação em posto de combustíveis, automatizando um processo manual do dia a dia e trazendo mais agilidade, organização e confiabilidade.

---

## 📌 Objetivo

Facilitar a conferência diária dos tanques de combustível, permitindo informar a medição em centímetros e obter automaticamente o volume correspondente em litros com base em tabelas reais de calibração.

---

## 🚀 Funcionalidades

✅ Interface gráfica com JavaFX  
✅ Seleção do tanque / combustível  
✅ Entrada da medição em centímetros  
✅ Cálculo automático do volume em litros  
✅ Histórico de medições na tela  
✅ Exibição/Ocultação do histórico  
✅ Salvamento automático do histórico em arquivo CSV  
✅ Estrutura portátil para execução fora da IDE

---

## 🛢️ Cenário atual do projeto

Versão configurada inicialmente para um posto de combustíveis específico, contendo os tanques utilizados atualmente:

- Diesel S500 – 15.000L  
- Gasolina Comum – 15.000L  
- Etanol – 7.500L  
- Diesel S10 – 7.500L  

---

## 🧠 Tecnologias utilizadas

- Java 21  
- JavaFX  
- Orientação a Objetos (POO)  
- Manipulação de arquivos CSV  
- Persistência em arquivo  
- IntelliJ IDEA  
- Git / GitHub

---

## 📂 Estrutura do Projeto

```text
fuel-tank-volume-system
├─ src
│  └─ main
│     └─ java
│        ├─ app
│        │  └─ FuelTankApp.java
│        ├─ console
│        │  └─ Main.java
│        ├─ entity
│        │  ├─ FuelType.java
│        │  ├─ MeasurementTable.java
│        │  └─ Tank.java
│        ├─ exceptions
│        │  └─ InvalidMeasurementException.java
│        ├─ services
│        │  ├─ HistoryFileService.java
│        │  └─ TankService.java
│        └─ util
│           └─ CsvLoader.java
│
├─ resources
│  ├─ tank_7500.csv
│  └─ tank_15000.csv
│
├─ open.bat
└─ README.md
```

---

## 📸 Demonstração
- Tela principal
- Escolha do tanque
- Digitação da medição
- Resultado em litros
- Histórico de medições

<img width="447" height="526" alt="medicao" src="https://github.com/user-attachments/assets/6e086754-cc7e-4882-b91c-f5e83e574dbe" />

---

<img width="449" height="530" alt="medicao2" src="https://github.com/user-attachments/assets/a37400dd-b821-4719-a911-9c5c4a016c87" />

---

## 📄 Exemplo de histórico salvo

~~~csv
DataHora,Tanque,CM,Litros
20/04/2026 09:10,Diesel S500,56,2544
20/04/2026 09:12,Etanol,70,4310
~~~

---


## ▶️ Como executar
Pela IDE
Executar a classe:
app.FuelTankApp

 ---

 
## 📚 Aprendizados neste projeto

Durante o desenvolvimento pratiquei:

- JavaFX na prática
- Eventos e componentes gráficos
- Organização em pacotes e camadas
- Tratamento de exceções
- Leitura de arquivos CSV
- Escrita em arquivos CSV
- Execução fora da IDE
- Solução de problema real utilizando software

---

## 🔧 Melhorias futuras

Tornar o sistema genérico para qualquer posto / empresa
- Cadastro dinâmico de tanques
- Cadastro de combustíveis
- Cadastro de usuários
- Banco de dados relacional
- Relatórios gerenciais
- Dashboard de estoque
- API REST com Spring Boot
- Interface web moderna com React
- Integração entre backend + frontend
- Controle de acesso e autenticação

---

## 💡 Visão de evolução

A versão atual é um MVP funcional desktop, focado em resolver rapidamente uma necessidade operacional real.

Como evolução futura, o projeto pode se transformar em uma solução completa com:

- Backend em Spring Boot
- Frontend em React
- Banco de dados
- Multiempresa
- Controle de estoque
- Relatórios e indicadores

---

## 👨‍💻 Autor

Joelson Bruno Costa Rodrigues

🎓 Análise e Desenvolvimento de Sistemas

🔗 LinkedIn: https://www.linkedin.com/in/joelson-bruno-734106389

---

## ⭐ Considerações finais

Projeto desenvolvido unindo aprendizado acadêmico com aplicação prática em ambiente real de trabalho, buscando transformar um processo manual em uma solução digital simples, funcional e com grande potencial de evolução.


