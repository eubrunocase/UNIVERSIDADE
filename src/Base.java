import java.util.ArrayList;
import java.util.List;                                                        // Powered by: BRUNO CASÉ and ZAIRA DUTRA
                                                                               //Last att: 12:58 pm  (21/11/2023)
public class Base implements IBase{
    private List<Laboratorio> laboratorios;
    private List<Departamento> departamentos;
    private List<Professor> professores;
    private List<Disciplina> disciplinas;
    private List<Aluno> alunos;

    public Base() {
        laboratorios = new ArrayList<>();
        departamentos = new ArrayList<>();
        professores = new ArrayList<>();
        disciplinas = new ArrayList<>();
        alunos = new ArrayList<>();
        inicializarDados();
    }

    public List<Laboratorio> getLaboratorios() {
        return laboratorios;
    }
    public List<Departamento> getDepartamentos() {
        return departamentos;
    }
    public List<Professor> getProfessores() {
        return professores;
    }
    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }
    public List<Aluno> getAlunos() {
        return alunos;
    }
    private void inicializarDados() {
        laboratorios.add(new Laboratorio(1, "LAMI1", 30, true));
        laboratorios.add(new Laboratorio(2, "LAMI2", 20, true));
    }



}
