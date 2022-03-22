package co.sofka.email;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<Email> listaEmails = new ArrayList<>();
        listaEmails.add(new Email(1, "pepito@gmail.com", "Enviado"));
        listaEmails.add(new Email(2, "anita@gmail.com", "No Enviado"));
        listaEmails.add(new Email(3, "jesus@hotmail.com", "Enviado"));
        listaEmails.add(new Email(4, "mariana@nocumplo.cm", "No Enviado"));
        listaEmails.add(new Email(5, "maria@gmail.com", "No Enviado"));
        listaEmails.add(new Email(6, "pep@nocumplo.cm", "No Enviado"));
        listaEmails.add(new Email(7, "poo@gmail.com", "Enviado"));
        listaEmails.add(new Email(8, "pepita@gmail.com", "No Enviado"));
        listaEmails.add(new Email(9, "pepit@gmail.com", "Enviado"));
        listaEmails.add(new Email(10, "pepo@gmail.com", "Enviado"));
        listaEmails.add(new Email(11, "peto@hotmail.com", "No Enviado"));
        listaEmails.add(new Email(12, "pepito@outlook.com", "No Enviado"));
        listaEmails.add(new Email(13, "pepito@nocumplo.cm", "No Enviado"));
        listaEmails.add(new Email(14, "carlos@hotmail.com", "Enviado"));
        listaEmails.add(new Email(15, "plie@gmail.com", "Enviado"));
        listaEmails.add(new Email(16, "woa@outlook.com", "No Enviado"));
        listaEmails.add(new Email(17, "link@gmail.com", "No Enviado"));
        listaEmails.add(new Email(18, "zelda@outlook.com", "No Enviado"));
        listaEmails.add(new Email(29, "skywalker@gmail.com", "Enviado"));
        listaEmails.add(new Email(20, "vader@hotmail.com", "Enviado"));
        listaEmails.add(new Email(21, "kyloren@gmail.com", "Enviado"));
        listaEmails.add(new Email(22, "leiaprincess@hotmail.com", "Enviado"));
        listaEmails.add(new Email(23, "jedi@gmail.com", "Enviado"));
        listaEmails.add(new Email(24, "link@gmail.com", "Enviado"));
        listaEmails.add(new Email(25, "pepito@gmail.com", "Enviado"));
        listaEmails.add(new Email(26, "pepito@nocumplo.cm", "No Enviado"));
        listaEmails.add(new Email(27, "pepito@gmail.com", "Enviado"));
        listaEmails.add(new Email(28, "pepito@gmail.com", "No Enviado"));
        listaEmails.add(new Email(29, "pepito@hotmail.com", "No Enviado"));
        listaEmails.add(new Email(30, "pepito@gmail.com", "Enviado"));


//Flux para correos que no se repiten usando distinct
        Flux<Email> distinct = Flux.fromIterable(listaEmails)
                .distinct();

       distinct.subscribe(System.out::println);

//-----------------------------------------------------------------
        //Correos con gmail
        Flux<Email> gmail = Flux.fromIterable(listaEmails)
                .filter(email -> email.getEmail().contains("@gmail.com"));
            gmail.subscribe(System.out::println);


    //Cantidad de correos con dominio gmail
         Mono<Long> gmailCantidad = Flux.fromIterable(listaEmails)
                   .filter(email -> email.getEmail().contains("@gmail.com"))
                   .count();
         gmailCantidad.subscribe(System.out::println);


        //Correos con hotmail
        Flux<Email> hotmail = Flux.fromIterable(listaEmails)
                .filter(email -> email.getEmail().contains("@hotmail.com"));
         hotmail.subscribe(System.out::println);


//Cantidad de correos con dominio hotmail
         Mono<Long> hotmailCantidad = Flux.fromIterable(listaEmails)
                   .filter(email -> email.getEmail().contains("@hotmail.com"))
                   .count();
                  hotmailCantidad.subscribe(System.out::println);


        //Correos con outlook
        Flux<Email> outlook = Flux.fromIterable(listaEmails)
                .filter(email -> email.getEmail().contains("@outlook.com"));

        outlook.subscribe(System.out::println);

//Cantidad de correos con dominio outlook
         Mono<Long> outlookCantidad = Flux.fromIterable(listaEmails)
                   .filter(email -> email.getEmail().contains("@outlook.com"))
                   .count();
                   outlookCantidad.subscribe(System.out::println);




//------------------------------------------------------------------------
//correos correctos
        Mono<Long> count = Flux.merge(gmail,hotmail,outlook)
                .count();

        System.out.println("El total de correos correctos: ");
        count.subscribe(System.out::println);



//------------------------------------------------------------------------

        //Los que cumplen y no cumplen
        Flux<Object> map = Flux.fromIterable(listaEmails)
                .map(email -> {
                    if (email.getEmail().contains("@outlook.com") || email.getEmail().contains("@gmail.com") || email.getEmail().contains("@hotmail.com")) {
                        System.out.println("-----------");
                        return email.getEmail();
                    }
                    System.out.println("-----------");
                    System.out.println("El siguiente correo no cumple: ");
                    return email.getEmail();

                }
        );
        map.subscribe(System.out::println);



        //----------------------------------------------------------


        Flux<Object> cambiarEstado = Flux.fromIterable(listaEmails)
                .map(email -> {
                            if (email.getEmail().contains("@outlook.com") || email.getEmail().contains("@gmail.com") || email.getEmail().contains("@hotmail.com")) {
                                if(email.getEstado().contains("No Enviado")){
                                    email.setEstado("Enviado");


                                }
                                return email;
                            }

                            System.out.println("El siguiente correo no cumple por lo tanto el correo no puede ser enviado: ");
                            return email;

                        }
                );
        cambiarEstado.subscribe(System.out::println);


    }







}
