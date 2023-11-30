package application;

import auxiliar.Reserva;
import auxiliar.Solicitacao;
import auxiliar.SolicitarLaboratorio;
import entities.*;
import java.util.List;                                                           // FALTA FAZER OS TRY CATCH, IMPRIMIR OS ALUNOS E RESOLVER ALGUNS DETALHES
import java.util.Objects;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Execucao {

    public static void main(String[] args) throws ParseException {
        Base bd = new Base();
        List<Laboratorio> laboratorios = bd.getLaboratorios();
        List<Disciplina> disciplinas = bd.getDisciplinas();
        List<Departamento> departamentos = bd.getDepartamentos();
        List<Professor> professores = bd.getProfessores();
        List<Aluno> alunos = bd.Alunos();


        Scanner ler = new Scanner(System.in);

        System.out.println("Ola, seja bem-vindo(a) ao sistema de reserva de laboratórios da Ucsal");
        System.out.println();
        System.out.println("Para solicitar um laboratório digite 1");
        System.out.println();
        System.out.println("Para exibir a base de dados da universidade digite 2");
        System.out.println("Para finalizar o atendimento digite 3");
        int resposta = ler.nextInt();

        if (resposta == 1) {
            SolicitarLaboratorio solicitacaoLab = new SolicitarLaboratorio(ler, laboratorios, disciplinas, departamentos, professores);
            solicitacaoLab.solicitarLab();


        } else if (resposta == 2) {
            System.out.println("Base de dados da UCSAL: ");
            bd.BasePrint();
        } else if (resposta == 3){
            ler.close();
            System.out.println("Atendimento finalizado");
        }
    }
}
