package application;

import auxiliar.Solicitacao;
import auxiliar.SolicitarLaboratorio;
import db.DB;
import entities.*;

import java.sql.*;
import java.util.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Execucao {                                                        // Powered by: BRUNO CASÉ and ZAIRA DUTRA
    //Last att: 12:58 pm  (21/11/2023)
    public static void main(String[] args) throws ParseException, SQLException {










        Base bd = new Base();
        List<Laboratorio> laboratorios = bd.getLaboratorios();
        List<Disciplina> disciplinas = bd.getDisciplinas();
        List<Departamento> departamentos = bd.getDepartamentos();
        List<Professor> professores = bd.getProfessores();

        Scanner ler = new Scanner(System.in);
        System.out.println("Ola, seja bem-vindo(a) ao sistema de reserva de laboratorios da Ucsal");
        System.out.println();
        System.out.println("Para solicitar um  laboratorio digite 1");// tratar possibilidade de outra String
        System.out.println();
        System.out.println("Para exibir a base de dados da universidade digite 2");
        int resposta = ler.nextInt();

        if (resposta ==1 ){

         Solicitacao solicitacao = new Solicitacao();
            System.out.print("Informe qual laboratório deseja reservar:");//atribuir a solicitacao, o laboratorio correspondente ao nome informado
            String lami = ler.next();
                for (Laboratorio lab : laboratorios){
                    if(lab.getDescricao().equalsIgnoreCase(lami)){
                        solicitacao.setLaboratorio(lab);

                    }
                }
                System.out.println(solicitacao.getLaboratorio());
            System.out.println("Digite o numero de id do o aluno de onde a lista de alunos vai começar:");
            int alnId = ler.nextInt();
                List<Aluno> turma = bd.getAlunos(solicitacao.getLaboratorio().getCapacidade(),alnId);
                Set<Aluno> turma1 = new HashSet<>(turma);
                solicitacao.setAlunos(turma1);
                System.out.println(turma1);

            System.out.println("Informe o nome do professor responsável:");// atribuir a solicitaçao, o professor correspondente ao nome informado
            String prof = ler.next();
                for (Professor professor : professores) {
                    if (professor.getNome().equalsIgnoreCase(prof)) {
                        solicitacao.setProfessor(professor);


                    }
                }
                System.out.println(solicitacao.getProfessor());


            System.out.println("Informe a sigla da disciplina:");
            String sigla = ler.next();
            for (Disciplina dis : solicitacao.getProfessor().getPdisciplinas()) {// Fiz uma logica para comparar a disciplina informada e checar entre qual das disciplinas que o professor leciona, é a que vai ser lecionada no dia.
                if (dis.getSigla().equalsIgnoreCase(sigla)) {
                    solicitacao.setDisciplina(dis);// precisa ser feito um try catch para uma situacao onde o usuario diz que o professor nao pode dar aula de uma disciplina que ele não domina
                    System.out.println(dis);
                }
            }
            System.out.println("Lista de alunos:");
            System.out.println(turma1);
            System.out.println();
            System.out.print("Informe a data dd/mm/yy do uso do laboratorio:" );
            String dataString = ler.next();

            // Converter a string para um objeto Date
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
                try {
                    Date data = dateFormat.parse(dataString);
                    solicitacao.setData(data);
                    System.out.println("Data definida com sucesso: " + data);
                } catch (ParseException e) {
                    System.out.println("Formato de data inválido. Certifique-se de usar o formato dd/MM/yy.");


                }
            System.out.print("Informe o horário (HH:mm) inicial de uso do laboratório: ");
            String horarioString = ler.next();
            try {
                // Converter a string de horário para um objeto Date
                SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
                Date horario = timeFormat.parse(horarioString);
                solicitacao.setHorario(horario);

            } catch (ParseException e) {
                System.out.println("Formato de horário inválido. Certifique-se de usar o formato HH:mm.");
            }

            System.out.println("Informe quanto por quanto tempo (minutos) deseja reservar o laboratorio:");
            int tempo = ler.nextInt();
            solicitacao.setTempo(tempo);

            System.out.println("Aqui está a revisao da sua solicitacao:");
            System.out.println(solicitacao);
            System.out.println("Deseja prosseguir com a reserva? (sim/nao)");
            String res = ler.next();

        } else if(resposta== 2){
            System.out.println(laboratorios);
            System.out.println(disciplinas);
            System.out.println(departamentos);
            System.out.println(professores);

        }

    }
}
