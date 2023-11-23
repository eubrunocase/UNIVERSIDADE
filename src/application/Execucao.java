package application;

import auxiliar.Solicitacao;
import auxiliar.SolicitarLaboratorio;
import entities.Departamento;
import entities.Disciplina;
import entities.Laboratorio;
import entities.Professor;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Execucao {                                                        // Powered by: BRUNO CASÉ and ZAIRA DUTRA
    //Last att: 12:58 pm  (21/11/2023)
    public static void main(String[] args) {
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



        } else if(resposta== 2){
            System.out.println(laboratorios);
            System.out.println(disciplinas);
            System.out.println(departamentos);
            System.out.println(professores);

        }














        //fazendo testes por enquanto


    /*

        Scanner ler = new Scanner(System.in);
        Base bd = new Base();
        List<Laboratorio> laboratorios = bd.getLaboratorios();
        List<Disciplina> disciplinas = bd.getPdisciplinas();
        List<Departamento> departamentos = bd.getDepartamentos();
        List<Professor> professores = bd.getProfessores();
        System.out.println(disciplinas);
        System.out.println();
        System.out.println(departamentos);
        System.out.println();
        System.out.println(laboratorios);
        System.out.println();
        System.out.println(professores);*/




        /*
        System.out.println("Quantos alunos existem?");
        int qtde = ler.nextInt();
        List<Aluno> alunos = bd.getAlunos(qtde, 1);
        for (Aluno aln : alunos){
            System.out.println(aln.toString());
        } */


    }
}
