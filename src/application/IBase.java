package application;

import entities.*;

import java.util.List;
//Last att: 12:58 pm  (21/11/2023)


public interface IBase {
    List<Laboratorio> getLaboratorios();
    List<Departamento> getDepartamentos();
    List<Professor> getProfessores();
    List<Disciplina> getDisciplinas();
    List<Aluno> getAlunos(int qtde);
}
