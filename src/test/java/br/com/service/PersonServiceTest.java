package br.com.service;

import br.com.domain.Person;
import br.com.domain.VotoEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class PersonServiceTest {

    PersonService service = new PersonService();

    @Test
    public void verificaSeIdadeAcimaDeDezoito(){
        Person person = new Person(18);
        PersonService service = new PersonService();
        Boolean result = service.isAdult(person);
        Assertions.assertTrue(result);
    }

    @Test
    public void verificaVotoNaoObrigatorioAcimaSetenta(){
        Person person = new Person(70);
        PersonService service = new PersonService();
        String result = service.podeVotarOld(person);
        Assertions.assertEquals("Voto Opcional", result);
    }

    @Test
    public void verificaVotoNaoObrigatorioAbaixoDeDezoito(){
        Person person = new Person(17);
        PersonService service = new PersonService();
        String result = service.podeVotarOld(person);
        Assertions.assertEquals("Voto Opcional", result);
    }

    @Test
    public void verificaVotosObrigatorios(){
        for (int i = 18; i < 70; i++){
            Assertions
                    .assertEquals(
                            VotoEnum.OBRIGATORIO,
                            service.podeVotar(new Person(i)
                            )
                    );
        }
    }

    @Test
    public void verificaVotosInelegiveis(){
        for (int i = 0; i < 16; i++){
            Assertions
                    .assertEquals(
                            VotoEnum.INELEGIVEL,
                            service.podeVotar(new Person(i)
                            )
                    );
        }
    }

    @Test
    public void verificaVotosOpcionais(){
        for (int i = 16; i < 100; i++){
            Assertions
                    .assertEquals(
                            VotoEnum.OPCIONAL,
                            service.podeVotar(new Person(i)
                            )
                    );
            if(i == 17){
                i = 69;
            }
        }

//        for (int i = 80; i > 69; i--){
//            Assertions
//                    .assertEquals(
//                            VotoEnum.OPCIONAL,
//                            service.podeVotar(new Person(i)
//                            )
//                    );
//        }
    }



}
