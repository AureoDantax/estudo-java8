package br.com.javamoderno.teste;

import br.com.javamoderno.main.Curso;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class TestaCursos {
    public static void main(String[] args) {

        List<Curso> cursos = new ArrayList<>();
        cursos.add(new Curso("Java", 100));
        cursos.add(new Curso("php", 8));
        cursos.add(new Curso("html", 100));
        cursos.add(new Curso("python", 25));
        cursos.add(new Curso("JS", 900));
        //uma ordenação por ordem crescente de alunos
        cursos.sort(comparing(Curso::getAlunos));
        System.out.println(cursos);

        /*aqui realizamos o filtro pelos cursos com menos de 1000 alunos, se houver ele devolve o curso,
        se não ele lança uma exception dizendo que o curso não está disponível,
        usei essa implementação simples para entender como funciona esse metodo, você pode devolver outro curso se preferir*/
        cursos.stream()
                .filter(c -> c.getAlunos() < 1000)
                .findAny()
                .ifPresentOrElse(curso -> System.out.println(curso.getNome()),
                        () -> System.out.println(new Exception("Curso não disponível")));

        /*aqui filtramos e alculamos a media aritimetica da quantidade de alunos nos cursos trazidos pelo filtro
        fazemos um mapDouble que possui o metodo average para o calculo*/
        OptionalDouble sum = cursos.stream()
                .filter(curso -> curso.getAlunos() >= 100)
                .mapToDouble(Curso::getAlunos)
                .average();

        System.out.println(sum);


         /*o collect.(collector. estende essa possibilidade para Map, Set e afins, para list e array pode ser feito direto
         o collect vai guardar o filtro acima na sua coleção e assim "modifica-la" com os valores contidos no seu filtro*/
        cursos = cursos.stream()
                .filter(curso -> curso.getAlunos() == 100)
                .toList();
        System.out.println(cursos);

        /*para o toMap ele recebe duas functions dado o curso passe a chave e dado o curso passe o valor
        ao invés de criar a variavel você pode concatenar com o  .forEach que também existe em Map passando o atributo diretamente (nome,aluno) e
        fazer o lambda para imprimi-los, formatados de sua maneira*/
        Map<String, Integer> Mapcurso = cursos.stream()
                .filter(c -> c.getAlunos() <= 100)
                .collect(Collectors.toMap(
                        curso -> curso.getNome(), curso -> curso.getAlunos()
                ));
        System.out.println(Mapcurso);

        // o orElse nesse caso irá trazer outro curso, um curso do index 0 da lista de cursos
        cursos.stream()
                .filter(c -> c.getAlunos() <= 10)
                .findAny()
                .orElse(cursos.get(0));


    }
}
