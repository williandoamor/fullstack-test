## Compilando o Projeto

* Para executar o projeto no terminal, digite o seguinte comando:

```shell script
mvn spring-boot:run 
```

* Após executar o comando acima já será possível utilizar os recursos da API.

* Esta API consulta a cidade envida pelo front-end e retorna com os dados sobre o clima da cidade escolhida.
 - Para testar no navegador ou no postman informa o endereço abaixo passando a cidade conforme exemplo.
  
```
  localhost:8080/temperatura/cidade/sao paulo
``` 


 - A API irá retornar a cidade, a temperatura e a situação do tempo no dia atual.


## Pré-Requisitos para execução do projeto.

* Java 8 ou versões superiores.
* Maven 3.6.3 ou versões superiores.
* Intellj IDEA Community Edition ou sua IDE favorita.
 - Para utilizar no Intellj é necessário instalar o plugin do Lombok na IDE.
