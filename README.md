# URL Redirect Lambda - Segunda Parte do Projeto Java 🚀

Este repositório faz parte do sistema de encurtamento de URLs desenvolvido durante o evento da **Rocketseat**. Ele
representa a **segunda parte** do projeto e é responsável pela lógica de redirecionamento e validação de URLs, bem como
pela configuração do **API Gateway** para centralizar e gerenciar as requisições.

A primeira parte do projeto está disponível no repositório:
[Create URL Shortener](https://github.com/Robson16/CreateUrlShortener)

Este contém a função Lambda responsável por criar URLs encurtadas dinamicamente e integrá-las ao Amazon S3.

---

## 🔍 Descrição

### Aula 03 - Redirecionamento de URLs e Configuração do API Gateway

Nesta aula, conduzida pela educadora **Fernanda Kipper**, implementamos as seguintes funcionalidades:

- **Redirecionamento de URLs**: Criamos a função Lambda que processa as URLs encurtadas, redirecionando o usuário para a
  URL original.
- **Validação de URLs**: Adicionamos uma lógica para verificar a data de expiração das URLs, garantindo que somente
  links válidos sejam redirecionados.
- **Configuração do API Gateway**: Centralizamos e gerenciamos todas as requisições utilizando o API Gateway,
  proporcionando uma estrutura robusta e segura para o serviço.

---

## 🛠️ Tecnologias e Dependências

Este projeto utiliza as seguintes tecnologias e bibliotecas:

- **AWS Lambda Java Core**: Para a implementação das funções Lambda.
- **AWS Lambda Java Log4j2**: Para gerenciamento e registro de logs.
- **Amazon S3 SDK**: Para interação com o armazenamento de dados.
- **Lombok**: Para simplificar o código Java com anotações.
- **Jackson Databind**: Para manipulação de objetos JSON.

### Configuração do Maven:

- **Java 17** como versão do compilador.
- **Maven Shade Plugin** para empacotar o projeto como um único JAR executável.

---

## 🚀 Como Executar

1. Clone este repositório:
   ```bash
   git clone https://github.com/Robson16/RedirectUrlShortener.git

```

2. Configure suas credenciais da AWS para acessar os serviços necessários.

3. Compile o projeto:
    ```
   mvn clean package
   ```

4. Implante as funções Lambda na AWS e configure os triggers necessários.
5. Teste as funcionalidades através de uma ferramenta como Postman ou curl.

## 🌐 Referências e Links

- [Primeira Parte do Projeto - Create URL Shortener](https://github.com/Robson16/CreateUrlShortener)
- [AWS Lambda](https://aws.amazon.com/pt/lambda/)
- [Amazon S3](https://aws.amazon.com/pt/s3/)
- [Amazon API Gateway](https://aws.amazon.com/pt/api-gateway/)

##💻 Desenvolvido por Robson Henrique Rodrigues durante o evento *Curso Gratuito de Java* da Rocketseat. 🧑‍💻