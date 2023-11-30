package application;

import auxiliar.*;
import entities.*;

import java.time.*;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Execucao {

    public static void main(String[] args) throws ParseException {
        Base bd = new Base();
        List<Laboratorio> laboratorios = bd.getLaboratorios();
        List<Disciplina> disciplinas = bd.getDisciplinas();
        List<Departamento> departamentos = bd.getDepartamentos();
        List<Professor> professores = bd.getProfessores();
        List<Aluno> alunos = bd.Alunos();


        Scanner ler = new Scanner(System.in);

        System.out.println();
        System.out.println("Ola, seja bem-vindo(a) ao sistema de reserva de laboratórios da Ucsal");
        System.out.println();
        System.out.println("Para solicitar um laboratório digite 1");
        System.out.println("Para exibir a base de dados da universidade digite 2");
        System.out.println("Para finalizar o atendimento digite 3");
        int resposta = ler.nextInt();

        if (resposta == 1) {
            SolicitarLaboratorio solicitarLaboratorio = new SolicitarLaboratorio(ler, laboratorios, disciplinas, departamentos, professores);
            Solicitacao solicitacao= solicitarLaboratorio.solicitarLab(); //cria uma solicitacao
            Reservas reservas = new Reservas();
            List<Reserva> listaReservas = reservas.getListaReservas();
            ValidarSolicitacao validacao = new ValidarSolicitacao();
            boolean aprovacao = validacao.checarConflito(solicitacao, listaReservas);
            LocalDate hoje = LocalDate.now();
            LocalDateTime hojeAgora = hoje.atTime(LocalTime.now());
            Reserva novaReserva = new Reserva(solicitacao,aprovacao, solicitacao.getDataHora(), solicitacao.getTempo(), solicitacao.getProfessor(), solicitacao.getDisciplina(), hojeAgora);




        } else if (resposta == 2) {
            System.out.println("Base de dados da UCSAL: ");
            bd.BasePrint();
        } else if (resposta == 3){
            ler.close();
            System.out.println("Atendimento finalizado");
        }
    }
}
