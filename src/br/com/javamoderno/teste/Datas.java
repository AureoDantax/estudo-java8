package br.com.javamoderno.teste;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Datas{
    public static void main(String[] args) {

        // osobjetos são imutaveis, as alterações através de métodos de conversao e operações devem ser colocados em variaveis

        //Objeto que traz a data de hoje
        LocalDate hoje = LocalDate.now();
        System.out.println(hoje);

        // gravar uma data específica que recebe dia mes e ano
        LocalDate copa = LocalDate.of(2022,11,28 );
        System.out.println(copa);

        // calcular periodo entre datas de forma simples
        Period periodo = Period.between(hoje,copa);
        System.out.println(periodo);

        //somar datas ou subtrair datas
        LocalDate Proximacopa= copa.plusYears(4);
        LocalDate copaAnterior= copa.minusYears(4);
        System.out.println(Proximacopa);

        //formatação de datas, esse ofPattern recebe uma string onde você formata a data dd/mm/yyyy por exemplo
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataformatada = Proximacopa.format(formatador);
        System.out.println(dataformatada);

        //Inserindo horas e minutos na data com LocalDateTime
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter format= DateTimeFormatter.ofPattern("dd/MM/yy hh:mm");
        System.out.println(agora.format(format));

        // converter o moento atual em data
        LocalDate agoraemdata = agora.toLocalDate();
        System.out.println(agoraemdata);

        // adicionar horas na data
        LocalDateTime copacomhoras =copa.atTime(23,45,07);
        System.out.println(copacomhoras);







    }
}
