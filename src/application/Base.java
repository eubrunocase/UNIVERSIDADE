package application;

import entities.*;
import application.IBase;


import java.util.*;
import java.util.List;
import java.util.Random;

//Last att: 12:58 pm  (21/11/2023)
public class Base implements IBase {
    private List<Laboratorio> laboratorios;
    private List<Departamento> departamentos;
    private List<Professor> professores;
    private List<Disciplina> disciplinas;
    private List<Aluno> alunos;

    private final int QTDE_PROFESSORES = 15;
    private final int QTDE_DEPARTAMENTOS = 3;
    private final int QTDE_LABORATORIOS= 15;

    public Base() {
        laboratorios = new ArrayList<>();
        departamentos = new ArrayList<>();
        professores = new ArrayList<>();
        disciplinas = new ArrayList<>();
        alunos = new ArrayList<>();
    }

    public List<Laboratorio> getLaboratorios() {


        for (int i = 1; i <= QTDE_LABORATORIOS; i++) {
            int capacidade = (i == 1 || i == 10) ? 30 : (i >= 2 && i <= 7) ? 20 : 15;
            laboratorios.add(new Laboratorio(i, "LAB" + i, capacidade, true));
        }
        return laboratorios;

    }


    public List<Departamento> getDepartamentos() {
        departamentos.add(new Departamento(1, "ES", "Engenharia de Software", true));
        departamentos.add(new Departamento(2, "CAD", "Computação de Alto Desempenho", true));
        departamentos.add(new Departamento(3, "IC", "Infraestrutura Computacional", true));
        return departamentos;
    }


    public List<Disciplina> getDisciplinas() {
        disciplinas.add(new Disciplina("(BES005)","LÓGICA DE PROGRAMAÇÃO E ALGORITMOS", 1, true));
        disciplinas.add(new Disciplina("(BES006)","ESTRUTURA DE DADOS", 2,true));
        disciplinas.add(new Disciplina("(BES008)","PROGRAMAÇÃO ORIENTADA A OBJETOS", 3, true));
        disciplinas.add(new Disciplina("(BES011)","BANCOS DE DADOS", 4, true));
        disciplinas.add(new Disciplina("(BES012)","ENGENHARIA DE REQUISITOS", 5, true));
        disciplinas.add(new Disciplina("(BES020)","PROGRAMAÇÃO PARA DISPOSITIVOS MÓVEIS", 6, true));
        disciplinas.add(new Disciplina("(BES026)","SISTEMAS DISTRIBUÍDOS", 7, true));
        disciplinas.add(new Disciplina("(BES038)","INTELIGÊNCIA ARTIFICIAL", 8, true));
        disciplinas.add(new Disciplina("(BES049)","PROGRAMAÇÃO WEB", 9, true));
        disciplinas.add(new Disciplina("(BES048)","PROGRAMAÇÃO FRONT END", 10, true));
        return disciplinas;
    }

    public List<Professor> getProfessores() {
        getDisciplinas();// trazendo todos os departamentos pra usar aqui
        getDepartamentos();// trazendo todas as disciplinas geral pra usar aqui

        for (int i = 1; i <= QTDE_PROFESSORES; i++) {//Para cada professor gerado

            Departamento dep = (i >= 1 && i <= 10) ? departamentos.get(0) :// se estiver no primeiro intervalo vai ser do departamento de incice 0
                    (i >= 11 && i <= 14) ? departamentos.get(1) :// segue a mesma lógica com o departamento de indice 1
                            departamentos.get(2);// aqui de indice 2

            ArrayList<Disciplina> dis = new ArrayList<Disciplina>();// criando uma lista de disciplinas do professor instanciado
            if (i >= 1 && i <= 10) {// se estiver no intervalo recebe tais disciplinas
                dis.add(disciplinas.get(0));
                dis.add(disciplinas.get(5));
                dis.add(disciplinas.get(3));
            } else if (i >= 11 && i <= 14) {
                dis.add(disciplinas.get(2));
                dis.add(disciplinas.get(4));
                dis.add(disciplinas.get(1));
                dis.add(disciplinas.get(8));
            } else {
                dis.add(disciplinas.get(10));
                dis.add(disciplinas.get(9));
                dis.add(disciplinas.get(7));
            }

            Professor prof = new Professor(true, i+0, "Professor",dep, dis);
            professores.add(prof);
        }
        return professores;
    }


    public List<Aluno> getAlunos(int qtde, int inicio) {
        for (int i=0; i<qtde; i++)
            alunos.add(new Aluno(i+1,"Aluno"+(i+1), "202320" + i, true));
        return alunos;
    }



}
