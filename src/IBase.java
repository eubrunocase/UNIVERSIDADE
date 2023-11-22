import java.util.List;
import java.util.ArrayList;                                                         // Powered by: BRUNO CASÉ and ZAIRA DUTRA
                                                                                     //Last att: 12:58 pm  (21/11/2023)


public interface IBase {
    List<Laboratorio> getLaboratorios();
    List<Departamento> getDepartamentos();
    List<Professor> getProfessores();
    List<Disciplina> getDisciplinas();
    List<Aluno> getAlunos();
}
