package auxiliar;

import entities.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class SolicitarLaboratorio {
    private Scanner scanner;
    private List<Laboratorio> laboratorios;
    private List<Disciplina> disciplinas;
    private List<Departamento> departamentos;
    private List<Professor> professores;


    public SolicitarLaboratorio(Scanner scanner, List<Laboratorio> laboratorios, List<Disciplina> disciplinas, List<Departamento> departamentos, List<Professor> professores) {
        this.scanner = scanner;
        this.laboratorios = laboratorios;
        this.disciplinas = disciplinas;
        this.departamentos = departamentos;
        this.professores = professores;
    }
    public void solicitarLab() throws ParseException {
        Solicitacao solicitacao = new Solicitacao();

        System.out.print("Informe qual laboratório deseja reservar:");
        String lami = scanner.next();
        for (Laboratorio lab : laboratorios) {
            if (lab.getDescricao().equalsIgnoreCase(lami)) {
                solicitacao.setLaboratorio(lab);
            }
        }

        System.out.println("Informe o nome do professor responsável:");
        String prof = scanner.next();
        for (Professor professor : professores) {
            if (professor.getNome().equalsIgnoreCase(prof)) {
                solicitacao.setProfessor(professor);
            }
        }

        System.out.println("Informe a sigla da disciplina:");
        String sigla = scanner.next();
        for (Disciplina dis : solicitacao.getProfessor().getPdisciplinas()) {
            if (dis.getSigla().equalsIgnoreCase(sigla)) {
                solicitacao.setDisciplina(dis);
                System.out.println(dis);
            }
        }

        System.out.println("Lista de alunos:");
        Solicitacao bd = null;
        List<Aluno> alunos = bd.getAlunos(solicitacao.getLaboratorio().getCapacidade());
        System.out.println(alunos);

        System.out.print("Informe a data dd/MM/yy do uso do laboratório:");
        String dataString = scanner.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        try {
            Date data = dateFormat.parse(dataString);
            solicitacao.setData(data);
            System.out.println("Data definida com sucesso: " + data);
        } catch (ParseException e) {
            System.out.println("Formato de data inválido. Certifique-se de usar o formato dd/MM/yy.");
        }

        System.out.print("Informe o horário (HH:mm) inicial de uso do laboratório: ");
        String horarioString = scanner.next();
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        try {
            Date horario = timeFormat.parse(horarioString);
            solicitacao.setHorario(horario);
        } catch (ParseException e) {
            System.out.println("Formato de horário inválido. Certifique-se de usar o formato HH:mm.");
        }

        System.out.println("Informe quanto por quanto tempo (minutos) deseja reservar o laboratório:");
        int tempo = scanner.nextInt();
        solicitacao.setTempo(tempo);

        System.out.println("Aqui está a revisão da sua solicitação:");
        System.out.println(solicitacao);
        System.out.println("Deseja prosseguir com a reserva? (sim/nao)");
        String res = scanner.next();


    }

}