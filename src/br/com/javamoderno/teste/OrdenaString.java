package br.com.javamoderno.teste;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaString {
    public static void main(String[] args) {

        List<String> str = new ArrayList<String>();
        str.add("abcbfdzbfdgfsdghfg");
        str.add("bsedf");
        str.add("xkdlsmn");
        str.add("fgdskfhbc");
        str.add("rgnbd4sf.m ");


        /*ao invés de criar uma classe e implementar o comparator, para então usar como parâmetro, voçe pode Utilizar (nesse caso)
        o compare da propria classe se houver, mas se precisar utilizar baastanteo comparator, crie uma classe e o implemente*/
        str.sort(((s1, s2) -> Integer.compare(s1.length(), s2.length())));



       /* Aqui usa-se uma classe anonima, pois, damos new na interface Consumer já implementando os metodos
       criar uma classe que implementa a interface,colocamos tudo numa variavel do tipo Consumer

       Consumer<String> imprime = new Consumer<String>() {
           @Override
           public void accept(String s) {
               System.out.println(s);}};

       /* Simplificamos o código acima na classe anonima, ao invés de dar new na classe para depois passa-la como argumento
       já colocamos a instanciação dela como parâmetros no forEach*/

        str.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });


               /* Podemos simplificar mais ainda com um lambda e deixar o código com apenas algumas linhas
                no lambda (neste caso) como o forEach só recebe um Consumer, ele infere que o que voce ta passando é um consumer
                ainda mais, o tipo da sua Collection também é inferido então não é necessário colocar.
                Outro ponto é que, se seu lambda possui apenas um argumento, como esse print que ta sendo feito, não precisa
                de chaves ou mais parenteses*/

        str.forEach(s1 -> System.out.println(s1));
        // com method reference:
        str.forEach(System.out::println);

        /*o Comparator possui o metodo comparing que recebe uma implementação da interface Function, onde voce pode passar
        um lambda como argumento para simplificar a comparação */

        str.sort(Comparator.comparing(s -> s.length()));
        System.out.println(str);

        /* a maneira mais simplificada de comparação com function pode ser o exemplo abaixo(utilize se for algo simples,
        caso seu metodo de comparar seja mais complexo utilie o lambda. Essa forma de utilizar pode ser usada em outros
        casos onde vc precise invocar apenas um método */
        str.sort(Comparator.comparing(String::length));

    }
}







