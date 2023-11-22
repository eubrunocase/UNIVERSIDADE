import java.util.List;
                                                                                 // Powered by: BRUNO CASÉ and ZAIRA DUTRA
                                                                                //Last att: 12:58 pm  (21/11/2023)
public class Solicitacao {                 //ATRIBUTOS
    private int id;
    private Laboratorio laboratorio;
    private Professor professor;
    private Disciplina disciplina;
    private List<Aluno> alunos;
    private String data;
    private int tempo;

    public Solicitacao(int id, Laboratorio laboratorio, Professor professor, Disciplina disciplina, Aluno aluno, String data, int tempo) {    //CONSTRUTOR
        this.id = id;
        this.laboratorio = laboratorio;
        this.professor = professor;
        this.disciplina = disciplina;
        this.alunos = alunos;
        this.data = data;
        this.tempo = tempo;
    }

    public List<Aluno> getAlunos() {                                //METODOS ACESSORES
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }


    public String toString() {                                   // METODO TO STRING
        return "Solicitacao{" +
                "id=" + id +
                ", laboratorio=" + laboratorio +
                ", professor=" + professor +
                ", disciplina=" + disciplina +
                ", alunos=" + alunos +
                ", data='" + data + '\'' +
                ", tempo=" + tempo +
                '}';
    }
}