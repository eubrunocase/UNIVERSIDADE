package application;

import auxiliar.*;
import entities.*;

import java.time.*;
import java.util.*;
import java.text.ParseException;

public class Execucao {

    public static void main(String[] args) throws ParseException {
        Base bd = new Base();                                       //setup
        List<Laboratorio> laboratorios = bd.getLaboratorios();
        List<Disciplina> disciplinas = bd.getDisciplinas();
        List<Departamento> departamentos = bd.getDepartamentos();
        List<Professor> professores = bd.getProfessores();
        List<Aluno> alunos = bd.Alunos();

        Scanner ler = new Scanner(System.in);

        System.out.println();
        System.out.println("Ola, seja bem-vindo(a) ao sistema de reserva de laboratórios da Ucsal");
        System.out.println();
        int resposta;
        String answer;
        Reservas reservas = new Reservas();
        List<Reserva> listaReservas = reservas.getListaReservas();
        do {
            System.out.println("Para solicitar um laboratório digite 1");
            System.out.println("Para exibir a base de dados da universidade digite 2");
            System.out.println("Para finalizar o atendimento digite 3");
            resposta = ler.nextInt();

            if (resposta == 1) {
                SolicitarLaboratorio solicitarLaboratorio = new SolicitarLaboratorio(ler, laboratorios, disciplinas, departamentos, professores);
                Solicitacao solicitacao = solicitarLaboratorio.solicitarLab(); // cria uma solicitação
                System.out.println("Deseja prosseguir com a reserva? (sim/nao)");
                String res1 = ler.next();
                if (res1.equalsIgnoreCase("sim")) {

                    ValidarSolicitacao validacao = new ValidarSolicitacao();
                    boolean aprovacao = validacao.checarConflito(solicitacao, listaReservas);
                    LocalDate hoje = LocalDate.now();
                    LocalDateTime hojeAgora = hoje.atTime(LocalTime.now());
                    Reserva novaReserva = new Reserva(solicitacao, aprovacao, solicitacao.getDataHora(), solicitacao.getTempo(), solicitacao.getProfessor(), solicitacao.getDisciplina(), hojeAgora);
                    novaReserva.Efetivar(novaReserva, listaReservas);
                    System.out.println(listaReservas);
                } else {
                    System.out.println("Atendimento finalizado");
                }

            } else if (resposta == 2) {
                System.out.println("Base de dados da UCSAL: ");
                bd.BasePrint();
            } else if (resposta == 3) {
                System.out.println("Atendimento finalizado");
            }

            System.out.println("Deseja realizar uma nova solicitação e reserva? (sim/nao)");
             answer = ler.next();

        } while (answer.equalsIgnoreCase("sim"));

        ler.close();
    }
}