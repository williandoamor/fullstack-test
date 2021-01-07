package br.com.desafiogobots.suggestionmusicsong.dto;

import br.com.desafiogobots.suggestionmusicsong.downloader.GetJson;
import br.com.desafiogobots.suggestionmusicsong.enumeratos.TiposMusicas;
import br.com.desafiogobots.suggestionmusicsong.lists.MusicList;
import br.com.desafiogobots.suggestionmusicsong.objetos.Cidade;
import br.com.desafiogobots.suggestionmusicsong.response.Response;
import br.com.desafiogobots.suggestionmusicsong.utils.Numeric;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class CidadeDTO {

    public Response buscarCidade(String cidade) {

        List<Cidade> aList = new ArrayList<>();

        try {

            String uri = "https://api.hgbrasil.com/weather?array_limit=1&fields=only_results,temp,city,city_name,description,forecast,max,min,date&key=b262205f&city_name={cityName}";
            JSONObject object = new JSONObject(GetJson.doGet(uri.replace("{cityName}", cidade).replace(" ", "%20")));

            if (object != null && !object.isEmpty()) {

                aList.add(jsForObject(object));
            }


            //
            //
            if (aList.isEmpty()) {


                return new Response().Vazio();

            } else {

                return new Response().OK(aList);
            }

        } catch (Exception e) {

            e.printStackTrace();
            return new Response().Error("Erro ao buscar temperatura da cidade " + e.getMessage());
        }
    }


    /*Converte a lista de resultados em objetos*/
    private Cidade jsForObject(JSONObject object) {

        Cidade cidade = new Cidade();

        /*Cria o objeto cidade*/
        cidade.setTemperatura(object.optString("temp"));
        cidade.setName(object.getString("city"));
        cidade.setDescription(object.optString("description"));

        int temperatura = Numeric.textForBigDecimal(cidade.getTemperatura()).intValue();


        if (temperatura > TiposMusicas.FESTAMUSIC) {

            cidade.setMusics(new MusicList().getMusicasFestas());

        } else if (temperatura >= TiposMusicas.POPMUSIC && temperatura <= TiposMusicas.FESTAMUSIC) {

            cidade.setMusics(new MusicList().getMusicasPop());

        } else if (temperatura >= TiposMusicas.CLASSICMUSIC && temperatura <= TiposMusicas.ROCKMUSIC) {

            cidade.setMusics(new MusicList().getMusicasRock());

        } else {

            cidade.setMusics(new MusicList().getMusicasClassicas());

        }


        return cidade;
    }

}
