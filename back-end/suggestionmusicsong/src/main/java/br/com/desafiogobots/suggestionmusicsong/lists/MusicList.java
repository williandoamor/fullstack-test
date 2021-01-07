package br.com.desafiogobots.suggestionmusicsong.lists;

import br.com.desafiogobots.suggestionmusicsong.objetos.Musics;

import java.util.ArrayList;
import java.util.List;

public class MusicList {

    /*Faixa de musicas para festas*/
    public List<Musics> getMusicasFestas() {

        List<Musics> aList = new ArrayList<>();

        Musics musics = new Musics();
        musics.setNome("Nosso Sonho");
        musics.setCantor("Claudinho e Bochecha");

        aList.add(musics);

        musics = new Musics();
        musics.setNome("Dança da mãozinha");
        musics.setCantor("Tchakabum");

        aList.add(musics);

        musics = new Musics();
        musics.setNome("Onda Onda");
        musics.setCantor("Tchakabum");

        aList.add(musics);

        return aList;
    }


    /*Lista de musicas pop*/
    public List<Musics> getMusicasPop() {

        List<Musics> aList = new ArrayList<>();

        Musics musics = new Musics();
        musics.setNome("Menina Solta");
        musics.setCantor("Giulia Be");

        aList.add(musics);

        musics = new Musics();
        musics.setNome("Some que ele vez atrás");
        musics.setCantor("Anitta & Maria Mendonça");

        aList.add(musics);

        musics = new Musics();
        musics.setNome("Vai Malandra");
        musics.setCantor("Anitta");

        aList.add(musics);

        return aList;
    }

    /*Lista de musicas rock*/
    public List<Musics> getMusicasRock() {

        List<Musics> aList = new ArrayList<>();

        Musics musics = new Musics();
        musics.setNome("Sweet Child O' Mine");
        musics.setCantor("Guns N' Roses");

        aList.add(musics);

        musics = new Musics();
        musics.setNome("Wonderwall");
        musics.setCantor("Oasis");

        aList.add(musics);

        musics = new Musics();
        musics.setNome("Always");
        musics.setCantor("Bon Jovi");

        aList.add(musics);

        return aList;
    }

    /*Lista de musicas classicas*/
    public List<Musics> getMusicasClassicas() {

        List<Musics> aList = new ArrayList<>();

        Musics musics = new Musics();
        musics.setNome("Molto Allegro");
        musics.setCantor("Mozart");

        aList.add(musics);

        musics = new Musics();
        musics.setNome("Beethoven 9ª");
        musics.setCantor("Beethoven");

        aList.add(musics);

        musics = new Musics();
        musics.setNome("Sonata ao Luar");
        musics.setCantor("Beethoven");

        aList.add(musics);

        return aList;
    }

}
