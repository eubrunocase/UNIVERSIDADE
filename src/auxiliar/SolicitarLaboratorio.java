package auxiliar;

import application.Base;
import entities.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalAmount;
import java.util.*;

public class SolicitarLaboratorio {
    private Scanner scanner;
    private List<Laboratorio> laboratorios;
    private List<Disciplina> disciplinas;
    private List<Departamento> departamentos;
    private List<Professor> professores;




    public   SolicitarLaboratorio(Scanner scanner, List<Laboratorio> laboratorios, List<Disciplina> disciplinas, List<Departamento> departamentos, List<Professor> professores) {
        this.scanner = scanner;
        this.laboratorios = laboratorios;
        this.disciplinas = disciplinas;
        this.departamentos = departamentos;
        this.professores = professores;

    }

    public void solicitarLab() throws ParseException {
        Solicitacao solicitacao = new Solicitacao();
        //Definindo o laboratorio
        System.out.print("Informe qual laboratório deseja reservar:");
        String lami = scanner.next();
        for (Laboratorio lab : laboratorios) {
            if (lab.getDescricao().equalsIgnoreCase(lami)) {
                solicitacao.setLaboratorio(lab);
            }
        }
        //Definindo o professor
        System.out.println("Informe o nome do professor responsável:");
        String prof = scanner.next();
        for (Professor professor : professores) {
            if (professor.getNome().equalsIgnoreCase(prof)) {
                solicitacao.setProfessor(professor);
            }
        }
        //Definindo a disciplina
        System.out.println("Informe a sigla da disciplina:");
        String sigla = scanner.next();
        for (Disciplina dis : solicitacao.getProfessor().getPdisciplinas()) {
            if (dis.getSigla().equalsIgnoreCase(sigla)) {
                solicitacao.setDisciplina(dis);
                System.out.println(dis);
            }
        }
        //Definindo a turma
        System.out.println("Informe a partir de qual posicao (id) na lista de alunos você quer a lista :");
        int inicio = scanner.nextInt();
        Base bd = new Base();
        List<Aluno> alunos = bd.getAlunos(solicitacao.getLaboratorio().getCapacidade(), inicio);
        Set<Aluno> turma = new HashSet<Aluno>(alunos);
        System.out.println(turma);


        // Definindo data
        System.out.print("Informe a data dd/MM/yy do uso do laboratório:");
        String dataString = scanner.next();
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
            LocalDate data = LocalDate.parse(dataString, formatter);
            solicitacao.setData(data);
            System.out.println("Data definida com sucesso: " + data);
        } catch (DateTimeParseException e) {
            System.out.println("Formato de data inválido. Certifique-se de usar o formato dd/MM/yy.");
        }


        // Definindo horario
        System.out.print("Informe o horário (HH:mm) inicial de uso do laboratório: ");
        String horarioString = scanner.next();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        try {
            LocalTime horario = LocalTime.parse(horarioString, timeFormatter);
            solicitacao.setHorario(horario);
            System.out.println("Horário definido com sucesso: " + horario);
        } catch (DateTimeParseException e) {
            System.out.println("Formato de horário inválido. Certifique-se de usar o formato HH:mm.");
        }


        System.out.println("Informe quanto por quanto tempo (minutos) deseja reservar o laboratório:");

        long minutos = scanner.nextLong();

        // Criar uma Duration a partir dos segundos inseridos pelo usuário
        Duration duration = Duration.ofMinutes(minutos);
        solicitacao.setTempo(duration);

        System.out.println("Aqui está a revisão da sua solicitação:");
        System.out.println(solicitacao);
        System.out.println("Deseja prosseguir com a reserva? (sim/nao)");
        

        System.out.println("Atendimento finalizado");


    }

    }
