package br.com.desafiogobots.suggestionmusicsong.service;

import br.com.desafiogobots.suggestionmusicsong.dto.CidadeDTO;
import br.com.desafiogobots.suggestionmusicsong.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class TemperaturaService {


    private CidadeDTO cidadeDTO;

    @Autowired
    public TemperaturaService(CidadeDTO cidadeDTO) {
        this.cidadeDTO = cidadeDTO;
    }



    public Response buscarTemperatura(String cidade) throws IOException {

        return cidadeDTO.buscarCidade(cidade);

    }
}
