package application;

import auxiliar.Reserva;
import auxiliar.SolicitarLaboratorio;
import entities.Departamento;
import entities.Disciplina;
import entities.Laboratorio;
import entities.Professor;

import java.util.List;
import java.util.Scanner;

public class Execucao {                                                        // Powered by: BRUNO CASÉ and ZAIRA DUTRA

    public static void main(String[] args) {
        //fazendo testes por enquanto

        Base bd = new Base();
        SolicitarLaboratorio solicitacao = new SolicitarLaboratorio(bd);
        solicitacao.solicitarLaboratorio();



        /*
        System.out.println("Quantos alunos existem?");
        int qtde = ler.nextInt();
        List<Aluno> alunos = bd.getAlunos(qtde, 1);
        for (Aluno aln : alunos){
            System.out.println(aln.toString());
        } */


    }
}
