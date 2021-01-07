package br.com.desafiogobots.suggestionmusicsong.objetos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Musics {

    private String nome;

    private String cantor;
}
