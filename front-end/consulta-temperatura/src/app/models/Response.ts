export interface Response{

    /*Resposta 0 - Erro, 1 - OK, 2 - OK mas com Restrições*/
    response: BigInteger;
    /*Messagem da Resposta*/
    message: String;
    /*Error Código*/
    status: BigInteger;
  }