import { Musics } from './Musics';

export interface Cidade extends Response {

    name: String;

    temperatura: String;

    description: String;

    musics: Musics[];

    object: Cidade[];
    

}
