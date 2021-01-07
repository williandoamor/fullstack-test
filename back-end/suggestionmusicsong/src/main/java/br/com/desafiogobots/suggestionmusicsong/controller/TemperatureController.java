package br.com.desafiogobots.suggestionmusicsong.controller;

import br.com.desafiogobots.suggestionmusicsong.response.Response;
import br.com.desafiogobots.suggestionmusicsong.service.TemperaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@CrossOrigin(origins = "http://localhost:4200/")
@Path("/temperatura")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@ComponentScan
public class TemperatureController {


    private TemperaturaService service;

    @Autowired
    public TemperatureController(TemperaturaService service) {
        this.service = service;
    }

    @GET
    @Path("/cidade/{cidade}")
    public Response buscarTemperatura(@PathParam("cidade") String cidade) throws IOException {

        return service.buscarTemperatura(cidade);
    }



}
