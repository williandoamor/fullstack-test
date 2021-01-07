package br.com.desafiogobots.suggestionmusicsong.objetos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cidade {

    String name;

    String temperatura;

    String description;

    List<Musics> musics;
}
