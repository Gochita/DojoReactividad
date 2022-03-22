package chat;

import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class Chat {
    public static void main(String[] args) {
        List<String> malasPalabras= new ArrayList<>();
        malasPalabras.add("jueputa");
        malasPalabras.add("mierda");
        malasPalabras.add("gonorrea");
        malasPalabras.add("nojoda");
        malasPalabras.add("careverga");
        malasPalabras.add("monda");
        malasPalabras.add("cabeza e monda");
        malasPalabras.add("marica");
        malasPalabras.add("hijueputa");
        malasPalabras.add("guevon");
        malasPalabras.add("verga");


        List<String> chat= List.of("Hola como estas?","Mal vieras la que me paso marica",
                "mierda que paso?","un hijueputa me choco el carro","verga marica y como quedo el carro?","el cabeza e monda ese me lo destrozo",
                "que gonorrea parce y ahora?","una monda solo me dio pa la mitad del arreglo marica","charro, mas tarde te llamo","hablamos parce");



        Flux<String> correctionChat = Flux.fromIterable(chat).map(frase->{
            if(frase.contains(chat.get(2))){
              return frase.replace(malasPalabras.get(1),"****");
            }
            return frase;
        });

        correctionChat.subscribe(System.out::println);




        }
    }





